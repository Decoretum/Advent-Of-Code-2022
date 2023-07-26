package Day7;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import packages.FSystem;

//File Directory
//

public class Day7{
    public static void main (String args[]){
        try {
            FileInputStream file = new FileInputStream("Day7/input.txt");
            Scanner reader = new Scanner(file);
            

            //Data structure to use 
            //My own custom FileSystem data structure 
            FSystem Head = new FSystem("/");
            boolean mode = false;

            while (reader.hasNextLine()){                
                String line = reader.nextLine();

                //Beggining edge case
                if (line.equals("$ cd /")){
                    continue;
                }
                
                //Normal Cases
                else if (line.equals("$ ls")){
                    // System.out.println("line: " + line);
                    // System.out.println("Current pointer name: " + Head.name);
                    mode = true;
                    continue;
                }

                //Mode is in appending mode but shifted to cd
                else if (mode == true && line.contains("$")) {
                    mode = false;
                }

                if (mode == true){
                    if (line.contains("dir")){
                        FSystem NewDir = new FSystem(line.replaceAll("dir ",""), Head);
                        Head.Files.add(NewDir);
                    } else if (!line.contains("$") && !line.contains("dir")){ //File scenario
                        String converted = line.replaceAll("[^\\d]","");
                        int num = Integer.parseInt(converted);
                        Head.storage += num;
                        //FSystem parent = Head.moveOut();
                    }
                }
                
                //will always have a $ prefix
                else{   
                    String target = line.replace("$ cd ","");

                    //moving out of directory
                    if (target.equals("..")){
                        Head = Head.moveOut();
                    } else { //moving in a directory
                        Head = Head.moveIn(target);
                    }
                }
            }
            reader.close();
            while (Head.Parent != null){
                Head = Head.moveOut();
            }
            System.out.println(Head.storage);

        } catch (FileNotFoundException e){
            System.out.println("No file");
        }
    }
}