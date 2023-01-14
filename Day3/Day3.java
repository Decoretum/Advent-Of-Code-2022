package Day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3{
    static ArrayList<ArrayList<Integer>> Sum = new ArrayList<>();
    static ArrayList<Integer> GroupSum = new ArrayList<>(); //1 big arraylist
    static HashMap <String,Integer> BigValues = new HashMap<>();
    static HashMap <String,Integer> SmallValues = new HashMap<>();
    static ArrayList<String> Values = new ArrayList<>();
    
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

    static void Group(String line1, String line2, String line3, HashMap<String,Integer> Big, HashMap<String,Integer> Small){
        ArrayList <String> Group3 = new ArrayList<>();
        HashSet<String> NoRep = new HashSet<>();
        ArrayList <String> Container = new ArrayList<>();
        String[] one1 = line1.split("");
        String[] two1 = line2.split("");
        String[] three1 = line3.split("");
        Group3.add(line1);
        Group3.add(line2);
        Group3.add(line3);
        for (int i = 0; i < one1.length; i++){
            NoRep.add(one1[i]);
        }

        for (int i = 0; i < two1.length; i++){
            NoRep.add(two1[i]);
        }

        for (int i = 0; i < three1.length; i++){
            NoRep.add(three1[i]);
        }

        ArrayList <String> StringSet = new ArrayList<>(NoRep);

        for (int i = 0; i < NoRep.size(); i++){
            if (!Container.contains(StringSet.get(i)) && Arrays.asList(one1).contains(StringSet.get(i)) && Arrays.asList(two1).contains(StringSet.get(i)) && Arrays.asList(three1).contains(StringSet.get(i))){
                Container.add(StringSet.get(i));
            }
        }

        if (Big.containsKey(Container.get(0))){
            GroupSum.add(Big.get(Container.get(0)));
        }

        else if (Small.containsKey(Container.get(0))){
            GroupSum.add(Small.get(Container.get(0)));
        }

        //GroupSum.add(Group3);


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
                Values.add(line);
            }


            int max = 0;
            for (int i = 0; i < Sum.size(); i++){
            for (int j = 0; j < Sum.get(i).size(); j++){
                max += Sum.get(i).get(j);
            }
        }

            for (int i = 2; i < Values.size(); i+=3){
                Group(Values.get(i),Values.get(i-1),Values.get(i-2), BigValues, SmallValues);
            }

            int max2 = 0;
            for (int i=0; i<GroupSum.size(); i++){
                max2 += GroupSum.get(i);
            }

        System.out.println(max);
        System.out.println(max2);
        
       
       
        }

        catch(FileNotFoundException error){
            error.printStackTrace();
        }
        



    }
}