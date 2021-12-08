import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch{
    public static void main(String[] args){
        try{
            char[][] letras = new char[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
            File file = new File(args[2]);
            Scanner input = new Scanner(file);
            ArrayList<String> words = new ArrayList<String>(Arrays.asList(input.nextLine().split(",")));
            input.close();
            System.out.println(Arrays.deepToString(letras));
            System.out.println(words);
            // for(int i = 0;i<words.size();i++){
            //     if (words.get(i).length() > Integer.parseInt(args[0]) && words.get(i).length() > Integer.parseInt(args[1])){
            //         words.remove(i);
            //         i--;
            //     }
            // }
            System.out.println(words);
        }catch(FileNotFoundException e){
            System.out.println("no file??");
        }
    }
}