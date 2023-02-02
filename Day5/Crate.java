package Day5;
import java.util.*;

public class Crate{
    ArrayList<String> Letters = new ArrayList<>();
    public Crate(ArrayList<String> List){
        Letters = List;
    }

    public void Transfer(int n, Crate crate){
        for (int i = this.Letters.size()-1, j = 0; i >= 0 && j != n; i--){
            crate.Take(this.Letters.get(i));
            j++;
        }

        for (int i = n-1; i >= 0 ; i--){
            this.Letters.remove(i);
        }
    }

    public void Take(String letter){
        this.Letters.add(letter);
    }

    public void Show(){
        for (String i : this.Letters){
            System.out.println(i);
        }
    }
}