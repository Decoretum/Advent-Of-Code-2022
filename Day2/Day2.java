package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//X for Rock, Y for Paper, and Z for Scissors
//A (1) for Rock, B (2) for Paper, C (3) for Scissors

//part 2 
// X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.

public class Day2{
    public static void main (String args[]){
        ArrayList<Integer> Outcome = new ArrayList<>();
        ArrayList<Integer> StrategyOutcome = new ArrayList<>();
        HashMap<Character,Integer> Values = new HashMap<>();
        Values.put('X',1);
        Values.put('Y',2);
        Values.put('Z',3);
        
        try{
            File game = new File("Day2/input.txt");
            Scanner reader = new Scanner(game);
            while(reader.hasNextLine()){
                String result = reader.nextLine();
                char digit1 = result.charAt(0);
                char digit2 = result.charAt(2);
                if (digit1 == 'A' && digit2 == 'Y'){
                    Outcome.add(Values.get(digit2) + 6);
                    StrategyOutcome.add(3 + 1);
                }
                else if (digit1 == 'A' && digit2 == 'X'){
                    Outcome.add(Values.get(digit2) + 3);
                    StrategyOutcome.add(0 + 3);
                }
                else if (digit1 == 'A' && digit2 == 'Z'){
                    Outcome.add(Values.get(digit2) + 0);
                    StrategyOutcome.add(6 + 2);
                }

                else if (digit1 == 'B' && digit2 == 'Y'){
                    Outcome.add(Values.get(digit2) + 3);
                    StrategyOutcome.add(3 + 2);
                }
                else if (digit1 == 'B' && digit2 == 'X'){
                    Outcome.add(Values.get(digit2) + 0);
                    StrategyOutcome.add(0 + 1);
                }
                else if (digit1 == 'B' && digit2 == 'Z'){
                    Outcome.add(Values.get(digit2) + 6);
                    StrategyOutcome.add(6 + 3);
                }

                else if (digit1 == 'C' && digit2 == 'Y'){
                    Outcome.add(Values.get(digit2) + 0);
                    StrategyOutcome.add(3 + 3);
                }
                else if (digit1 == 'C' && digit2 == 'X'){
                    Outcome.add(Values.get(digit2) + 6);
                    StrategyOutcome.add(0 + 2);
                }
                else if (digit1 == 'C' && digit2 == 'Z'){
                    Outcome.add(Values.get(digit2) + 3);
                    StrategyOutcome.add(6 + 1);
                }

                

    
            }
            reader.close();
            int max = 0;
            for (int i=0; i < Outcome.size(); i++){
                max += Outcome.get(i);
            }

            int max2 = 0;
            for (int i=0; i < StrategyOutcome.size(); i++){
                max2 += StrategyOutcome.get(i);
            }

            System.out.println(max);
            System.out.println(max2);


        }
        catch(FileNotFoundException error){
            System.out.println("ERROR");
            error.printStackTrace();
        }
    }
}