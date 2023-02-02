package Day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    static void Move(int n, Crate C1, Crate C2){
        C1.Transfer(n,C2);
    }

    static void NewMove(int n, Crate C1, Crate C2){
        C1.NewTransfer(n,C2);
    }
    public static void main (String args[]){
        try{
            //Will use Arraylist
            //move n from list to list
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            ArrayList<String> three = new ArrayList<>();
            ArrayList<String> four = new ArrayList<>();
            ArrayList<String> five = new ArrayList<>();
            ArrayList<String> six = new ArrayList<>();
            ArrayList<String> seven = new ArrayList<>();
            ArrayList<String> eight = new ArrayList<>();
            ArrayList<String> nine = new ArrayList<>();

            one.add("S");
            one.add("L");
            one.add("W");

            two.add("J");
            two.add("T");
            two.add("N");
            two.add("Q");

            three.add("S");
            three.add("C");
            three.add("H");
            three.add("F");
            three.add("J");

            four.add("T");
            four.add("R");
            four.add("M");
            four.add("W");
            four.add("N");
            four.add("G");
            four.add("B");

            five.add("T");
            five.add("R");
            five.add("L");
            five.add("S");
            five.add("D");
            five.add("H");
            five.add("Q");
            five.add("B");

            six.add("M");
            six.add("J");
            six.add("B");
            six.add("V");
            six.add("F");
            six.add("H");
            six.add("R");
            six.add("L");

            seven.add("D");
            seven.add("W");
            seven.add("R");
            seven.add("N");
            seven.add("J");
            seven.add("M");

            eight.add("B");
            eight.add("Z");
            eight.add("T");
            eight.add("F");
            eight.add("H");
            eight.add("N");
            eight.add("D");
            eight.add("J");

            nine.add("H");
            nine.add("L");
            nine.add("Q");
            nine.add("N");
            nine.add("B");
            nine.add("F");
            nine.add("T");


            Crate crateone = new Crate(one);
            Crate cratetwo = new Crate(two);
            Crate cratethree = new Crate(three);
            Crate cratefour = new Crate(four);
            Crate cratefive = new Crate(five);
            Crate cratesix = new Crate(six);
            Crate crateseven = new Crate(seven);
            Crate crateeight = new Crate(eight);
            Crate cratenine = new Crate(nine);
 
            HashMap <Integer, Crate> Crates = new HashMap<>();
            Crates.put(1,crateone);
            Crates.put(2,cratetwo);
            Crates.put(3,cratethree);
            Crates.put(4,cratefour);
            Crates.put(5,cratefive);
            Crates.put(6,cratesix);
            Crates.put(7,crateseven);
            Crates.put(8,crateeight);
            Crates.put(9,cratenine);

            File input = new File("Day5/input.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String line2 = line.trim();
                String rep = line2.replaceAll("[^0-9]","");
                if (rep.length() == 4){
                    //Move( Integer.parseInt  ( (String.valueOf(rep.charAt(0))) + (String.valueOf(rep.charAt(1)))), Crates.get( Integer.parseInt( String.valueOf(rep.charAt(2))) ), Crates.get(Integer.parseInt(String.valueOf(rep.charAt(3)))) );
                    NewMove( Integer.parseInt  ( (String.valueOf(rep.charAt(0))) + (String.valueOf(rep.charAt(1)))), Crates.get( Integer.parseInt( String.valueOf(rep.charAt(2))) ), Crates.get(Integer.parseInt(String.valueOf(rep.charAt(3)))) );

                }
                else{
                    //Move( Integer.parseInt(String.valueOf(rep.charAt(0))), Crates.get( Integer.parseInt( String.valueOf(rep.charAt(1))) ), Crates.get(Integer.parseInt(String.valueOf(rep.charAt(2)))) );
                    NewMove( Integer.parseInt(String.valueOf(rep.charAt(0))), Crates.get( Integer.parseInt( String.valueOf(rep.charAt(1))) ), Crates.get(Integer.parseInt(String.valueOf(rep.charAt(2)))) );

                }
            }


                Crates.get(1).Show();
                Crates.get(2).Show();
                Crates.get(3).Show();
                Crates.get(4).Show();
                Crates.get(5).Show();
                Crates.get(6).Show();
                Crates.get(7).Show();
                Crates.get(8).Show();
                Crates.get(9).Show();
               

            
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }

}