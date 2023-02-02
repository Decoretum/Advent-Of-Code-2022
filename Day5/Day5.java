package Day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    static void Move(int n, ArrayList<Integer> list1, ArrayList<Integer> list2){
        for (int i = 0; i < n; i++){
            
        }
    }
    public static void main (String args[]){
        try{
            //Will use Arraylist
            //move n from list to list
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            one.add("S");
            one.add("L");
            one.add("W");

            two.add("J");
            two.add("T");
            two.add("N");
            two.add("Q");
            Crate crateone = new Crate(one);
            Crate cratetwo = new Crate(two);
            cratetwo.Transfer(2,crateone);
            crateone.Show();

            File input = new File("Day5/input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                //sum += Compare2(line);
                //System.out.println(line);
            }
            
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

}