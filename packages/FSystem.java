package packages;
import java.util.ArrayList;

public class FSystem {
    public String name;
    public FSystem Parent;
    public ArrayList<FSystem> Files;
    public int storage;

    public FSystem (String a, FSystem b) {
        this.name = a;
        this.Parent = b;
        ArrayList<FSystem> files = new ArrayList<>();
        this.Files = files;
        this.storage = 0;
    }

    //To be used by the main head of the system
    public FSystem (String a) {
        this.name = a;
        ArrayList<FSystem> files = new ArrayList<>();
        this.Files = files;
        this.storage = 0;
    }


    public FSystem moveIn (String a){
        for (int i = 0; i < this.Files.size(); i++){
            FSystem file = this.Files.get(i);
            if (file.name.equals(a)){
                return file;
            }
            
        }
        System.out.println("No child found!");
        //required syntax fallback
        return Parent;
    }

    public FSystem moveOut(){
        return this.Parent;
    }

    public ArrayList<FSystem> ListAll (){
        return this.Files;
    }

}
