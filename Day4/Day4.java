package Day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4{
    static int Compare(String line){
        String[] Get = line.split(","); //split pairs
        String[] Getone = Get[0].split("-"); //numb per pair
        String[] Gettwo = Get[1].split("-");
        if (Integer.parseInt(Getone[0]) <= Integer.parseInt(Gettwo[0]) && Integer.parseInt(Getone[1]) >= Integer.parseInt(Gettwo[1])){
            return 1;
        }

        else if (Integer.parseInt(Gettwo[0]) <= Integer.parseInt(Getone[0]) && Integer.parseInt(Gettwo[1]) >= Integer.parseInt(Getone[1])){
            return 1;
        }

        else{
            return 0;
        }
    }
    
    static int Compare2(String line){
        String[] Get = line.split(","); //split pairs
        String[] Getone = Get[0].split("-"); //numb per pair
        String[] Gettwo = Get[1].split("-");
        int P11 = Integer.parseInt(Getone[0]);
        int P12 = Integer.parseInt(Getone[1]);
        int P21 = Integer.parseInt(Gettwo[0]);
        int P22 = Integer.parseInt(Gettwo[1]);

        if (((P12 >= P21) && (P11 <= P21)) || ((P22 >= P11) && (P21 <= P11))){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main (String args[]){
         try{
            int sum = 0;
            File input = new File("Day4/input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                sum += Compare2(line);
            }
            System.out.println(sum);
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }

}

}