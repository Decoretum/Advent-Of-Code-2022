package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1{
    static ArrayList <Integer> Sum = new ArrayList<>();
    static HashMap <Integer,Integer> Calories = new HashMap<>();
    public static void main (String args[]){
        try{
            int startcalorie = 0;
            int position = 0;
            File input = new File("Day1/input.txt");
            Scanner reader = new Scanner(input);

            while (reader.hasNextLine()){


                String output = reader.nextLine();
                if (output.isEmpty()){
                    Calories.put(position,startcalorie);
                    startcalorie = 0;
                    position++;
                }
                else{
                    startcalorie += Integer.parseInt(output);
                }
            

            }

            int max = 0;
            for (Integer a : Calories.values()){
                if (a > max){
                    max = a;
                }
            }

            System.out.println(max);
            reader.close();








        }

        catch(FileNotFoundException error){
            System.out.println("Error");
            error.printStackTrace();
        }
    }
}