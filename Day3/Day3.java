package Day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3{
    static ArrayList Sum = new ArrayList<>();
    static HashMap <String,Integer> BigValues = new HashMap<>();
    static HashMap <String,Integer> SmallValues = new HashMap<>();
    
    static void Analyse(String line){
        String[] arrayn = line.split("");
        int arrayl = arrayn.length / 2;
        String[] left = new String[arrayl];
        String[] right = new String[arrayl];
        for (int i=0; i < arrayl; i++){
            left[i] = arrayn[i];
        }

        for (int i = arrayl+1; i < arrayl; i++){
            right[i] = arrayn[i];
        }


        for (String i : left){
            System.out.println(i);
        }

    }
    public static void main (String args[]){
        String Big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small = "abcdefghijklmnopqrstuvwxyz";
        String[] parsedBig = Big.split("");
        String[] parsedSmall = Small.split("");
        for (int i=27, k=1, j=0; j < parsedBig.length; i++, j++, k++){
            BigValues.put(parsedBig[j],i);
            SmallValues.put(parsedSmall[j],k);
        }

        try{
            File input = new File("Day3/input.txt");
            Scanner reader = new Scanner(input);
            String sample = "vJrwpWtwJgWrhcsFMMfFFhFp";
            /*while (reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }*/
            Analyse(sample);
        }

        catch(FileNotFoundException error){
            error.printStackTrace();
        }
        



    }
}