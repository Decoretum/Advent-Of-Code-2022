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

            //counter
            int total = 0;

            //hashmap for every directory
            HashMap<FSystem,Integer> Dirs = new HashMap<>();
            

            //Data structure to use 
            //My own custom FileSystem data structure 
            FSystem Head = new FSystem("/");
            Dirs.put(Head, 0);
            boolean mode = false;

            while (reader.hasNextLine()){                
                String line = reader.nextLine();
                System.out.println(line);

                //Beggining edge case
                if (line.equals("$ cd /")){
                    continue;
                }
                
                //Normal Cases
                else if (line.equals("$ ls")){
                    System.out.println("Will start adding files/directory");
                    mode = true;
                    continue;
                }

                //Mode is in appending mode but shifted to cd
                else if (mode == true && line.contains("$")) {
                    System.out.println("Stopped appending!");
                    mode = false;
                }
                
                //Mode is in appending file or directory
                if (mode == true){
                    if (line.contains("dir")){//directory scenario
                        FSystem NewDir = new FSystem(line.replace("dir ",""), Head);
                        Head.Files.add(NewDir);
                        Dirs.put(NewDir, 0);
                    } else if (!line.contains("$") && !line.contains("dir")){ //File scenario
                        String converted = line.replaceAll("[^\\d]","");
                        int num = Integer.parseInt(converted);
                        System.out.println(num);
                        FSystem Copy = Head;
                        while (Copy != null){             
                            int old = Dirs.get(Copy);
                            Dirs.put(Copy, old+num);          
                            Copy = Copy.moveOut();
                        }
                        
                    }
                }
                
                //mode not in appending, will always have a $ prefix
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
            

            for (FSystem i: Dirs.keySet()){
                System.out.println("Name " + ": " + i.name + " with children");
                for (FSystem j: i.ListAll()){
                    System.out.println(j.name);
                }
                if (Dirs.get(i) <= 100000){
                    total += Dirs.get(i);
                }
            }

            System.out.println(total);
            


        } catch (FileNotFoundException e){
            System.out.println("No file");
        }
    }
}