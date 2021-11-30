import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Non{
  public static void main(String[] args){
    try{
      if (args[1].equals("1")){
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        String[] no = {"ab", "cd", "pq", "xy"};
        int total = 0;
        while (input.hasNextLine()){
          String line = input.nextLine() + "3";
          int vowels = 0;
          boolean dub = false;
          boolean bl = true;
          for(int i = 0; i<no.length;i++){
            if(line.contains(no[i]))
            bl = false;
          }
          for(int i = 0;i<line.length()-1;i++){
            if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' ||line.charAt(i) == 'u' )
              vowels++;
            if (line.charAt(i) == line.charAt(i+1))
              dub = true;
          }
          if (dub && (bl && (vowels >= 3)))
            total++;
        }
        input.close();
        System.out.println(total);
      }else if (args[1].equals("2")){
        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        int total = 0;
        while (input.hasNextLine()){
          String line = input.nextLine() + "345";
          boolean dub = false;
          boolean two = false;
          for (int i = 0;i<line.length()-3;i++){
            if (line.charAt(i) == line.charAt(i+2) && line.charAt(i) != line.charAt(i+1))
              dub = true;
            String sub = line.substring(i,i+2);
            if (line.substring(i+2).contains(sub))
              two = true;
          }
          if (dub && two)
            total++;
        }   
        input.close();
        System.out.println(total);
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
}

