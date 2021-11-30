import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Non{
  try{
    if (args[1].equals("1")){
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
      String[] vwl = ["a", "e", "i", "o", "u"];
      String[] no = ["ab", "cd", "pq", "xy"];
      int total = 0;
      while (input.hasNextLine()){
        String line = input.nextLine() + "..";
        int vowels = 0;
        boolean dub = false;
        boolean bl = true;
        for(int i = 0; i<line.length()-2;i++){
          if line.substring(i,i+2)
        }
      }
      input.close()
      System.out.println(total);
    }else if (args[1].equals("2")){
      File file = new File(args[0]);
      Scanner input = new Scanner(file);
    }else{
      throw new NoSuchFieldError("not a valid method");
    }
  }catch(FileNotFoundException e) {
      System.out.println("please add filename");
  }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("insufficient args, please add filename and method#");
  }catch(NoSuchFieldError e){
      System.out.println("add method #, should be 1 or 2");
  }
}
