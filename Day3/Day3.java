package Day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3{
    static ArrayList<ArrayList<Integer>> Sum = new ArrayList<>();
    static ArrayList<ArrayList<String>> GroupSum = new ArrayList<>(); //1 big arraylist
    static HashMap <String,Integer> BigValues = new HashMap<>();
    static HashMap <String,Integer> SmallValues = new HashMap<>();
    
    private static void Analyse(String line, HashMap<String,Integer> Big, HashMap<String,Integer> Small){
        String[] arrayn = line.split("");
        int arrayl = arrayn.length / 2;
        String[] left = new String[arrayl];
        String[] right = new String[arrayl];
        ArrayList<Integer> common1 = new ArrayList<>();
        for (int i=0; i < arrayl; i++){
            left[i] = arrayn[i];
        }

        for (int j=0, i = arrayl; i < arrayl*2; i++, j++){
            right[j] = arrayn[i];
        }

       for (int i=0; i < arrayl; i++){
            for (int j=0; j < arrayl; j++){
                if (left[i].equals(right[j])){
                    if (Big.containsKey(right[j]) && !common1.contains(Big.get(right[j]))){
                        common1.add(Big.get(right[j]));
                    }
                    else if (Small.containsKey(right[j]) && !common1.contains(Small.get(right[j]))){
                        common1.add(Small.get(right[j]));
                    }
                }
            }
        } 

        Sum.add(common1);

    }

    static void Group(String line, HashMap<String,Integer> Big, HashMap<String,Integer> Small){
        String[] arrayn = line.split("");
        ArrayList<Integer> common1 = new ArrayList<>();


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
            String sample = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
            int count = 1;
            while (reader.hasNextLine()){
                ArrayList<String> minigroup = new ArrayList<>(); 
                String line = reader.nextLine();
                Analyse(line,BigValues,SmallValues);
                if (count > 3){
                    count = 1;
                    if (count == 1){
                        GroupSum.add(line);
                        count++;
                    }
                }
                else if (count <= 3){
                    minigroup.add(line);
                    count++;
                }

            }


            int max = 0;
            for (int i = 0; i < Sum.size(); i++){
            for (int j = 0; j < Sum.get(i).size(); j++){
                max += Sum.get(i).get(j);
            }

            System.out.println(GroupSum);
        }

        System.out.println(max);
        }

        catch(FileNotFoundException error){
            error.printStackTrace();
        }
        



    }
}