package Day5;
import java.util.*;

public class Crate{
    ArrayList<String> Letters = new ArrayList<>();
    public Crate(ArrayList<String> List){
        this.Letters = List;
    }

    public void Transfer(int n, Crate crate){
        for (int i = this.Letters.size()-1, j = n; i >= 0 && j > 0; i--, j--){
            crate.Take(this.Letters.get(i));
        }

        for (int i = this.Letters.size()-1, j = n; i >= 0 && j > 0; i--, j--){
            this.Letters.remove(i);
        }
    }

    public void NewTransfer(int n, Crate crate){
        if (n == 1){
            for (int i = this.Letters.size()-1, j = n; i >= 0 && j > 0; i--, j--){
            crate.Take(this.Letters.get(i));
        }

            for (int i = this.Letters.size()-1, j = n; i >= 0 && j > 0; i--, j--){
                this.Letters.remove(i);
        }
        }
        else{
            String[]reverse = new String[n];
            for (int i = this.Letters.size()-1, a=0, j = n; i >= 0 && j > 0; i--, j--, a++){
                reverse[a] = this.Letters.get(i);
                }    

            for (int i = this.Letters.size()-1, j = n; i >= 0 && j > 0; i--, j--){
                this.Letters.remove(i);
                }

            Collections.reverse(Arrays.asList(reverse));
            for (String i : reverse){
                crate.Take(i);
            }
        }
        
    }

    public void Take(String letter){
        this.Letters.add(letter);
    }

    public void Show(){
        if (this.Letters.size() <= 0){
            return;
        }
        else{
            System.out.print(this.Letters.get(this.Letters.size() - 1));
        }
    }
}