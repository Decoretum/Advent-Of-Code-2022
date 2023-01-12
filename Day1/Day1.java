package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day1{
    static ArrayList <Integer> Sum = new ArrayList<>();
    static HashMap <Integer,Integer> Calories = new HashMap<>();

    static void InsertionSort(ArrayList<Integer> list){ //efficient, but for smaller datasets

        int listlength = list.size();
        int[] array = new int[listlength];
        for (int i=0; i < list.size(); i++){ //arraylist to array for easier selection sorting, didnt work with arraylist
            array[i] = list.get(i);
        }

        for (var i=1; i < array.length; i++){
            int current = i;
            int before = i-1;
            while (before >= 0 && array[before] > array[current]){
                array[before + 1] = array[before];
                before--;
            }
            array[before + 1] = array[current];
        }
        for (int a : array){
            System.out.println(a);
        }
    }

    static void BubbleSort(ArrayList<Integer> list){ //not efficient, but it works for large datasets
        int listlength = list.size();
        int[] array = new int[listlength];
        for (int i=0; i < list.size(); i++){ 
            array[i] = list.get(i);
        }

        int arrlength = array.length;
        boolean sorted = false;
        while (sorted == false){
            sorted = true;
            for (int i = 1; i < arrlength; i++){
                if (array[i] < array[i-1]){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                    sorted = false;
                }
            }
        }

        for(int i : array){
            System.out.println(i);
        }

        int sum4 = 0;

        for (int i = 1; i <= 3; i++){
           sum4 += array[array.length - i];
        }

        System.out.println(sum4);
        


    }

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
            for (int a : Calories.values()){
                Sum.add(a);
                if (a > max){
                    max = a;
                }
            }

            reader.close();
            System.out.println(max);
            BubbleSort(Sum);





        
            


        }

        catch(FileNotFoundException error){
            System.out.println("Error");
            error.printStackTrace();
        }
    }
}