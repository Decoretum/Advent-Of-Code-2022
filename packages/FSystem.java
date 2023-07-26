package packages;
import java.util.ArrayList;

public class FSystem {
    public String name;
    public FSystem Parent;
    public ArrayList<Object> Files;
    public int storage;

    public FSystem (String a, FSystem b) {
        name = a;
        Parent = b;
        ArrayList<Object> files = new ArrayList<>();
        Files = files;
        storage = 0;
    }

    //To be used by the main head of the system
    public FSystem (String a) {
        name = a;
        ArrayList<Object> files = new ArrayList<>();
        Files = files;
        storage = 0;
    }


    public FSystem moveIn (String a){
        for (int i = 0; i < this.Files.size(); i++){
            if (this.Files.get(i) instanceof FSystem){
                FSystem file = (FSystem) this.Files.get(i);
                if (file.name.equals(a)){
                    return file;
                }
            }
        }
        //required syntax fallback
        return Parent;
    }

    public FSystem moveOut(){
        return Parent;
    }

    public ArrayList<Object> ListAll (){
        return Files;
    }

}
