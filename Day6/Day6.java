package Day6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day6{
    static void Analyze(String datum){

    }
    public static void main (String args[]){
        ArrayList <String> Data = new ArrayList<>();
        try{
            File input = new File("Day6/input.txt");
            Scanner data = new Scanner(input);
            int answer = 0;
            int answer2 = 0;
            String datum = data.nextLine();
        
            String cond = "No";
            String cond2 = "No";
            for (int i = 0; cond.equals("No"); i++){
                HashSet<String> Sety = new HashSet<>();
                Sety.add(String.valueOf(datum.charAt(i)));
                Sety.add(String.valueOf(datum.charAt(i+1)));
                Sety.add(String.valueOf(datum.charAt(i+2)));
                Sety.add(String.valueOf(datum.charAt(i+3)));
                if (Sety.size() == 4){
                    cond = "Yes";
                    answer = i+4 ;
                }
        }

                for (int i = 0; cond2.equals("No"); i++){
                    HashSet<String> Set2 = new HashSet<>();
                    for (int main = i, j=0; j < 14; j++, main++){
                        Set2.add(String.valueOf(datum.charAt(main)));
                    }
                    if (Set2.size() == 14){
                        cond2 = "Yes";
                        answer2 = i + 14;
                    }
                    
                }
                

           

        System.out.println(answer);
        System.out.println(answer2);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
        
    }
}