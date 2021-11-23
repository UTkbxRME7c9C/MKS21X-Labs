import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Triangles{
  public static void main(String[] args){
    try{
      if (args[1].equals("1")){
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            int total = 0;
            while(input.hasNextInt()){
              int a = input.nextInt();
              int b = input.nextInt();
              int c = input.nextInt();
              if (a + b > c && b + c > a && a+c > b)
                total++;
            }
            input.close();
            System.out.println(total);
      } else if (args[1].equals("2")){
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            int total = 0;
            ArrayList<Integer> a = new ArrayList<Integer>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            ArrayList<Integer> c = new ArrayList<Integer>();
            while(input.hasNextInt()){
              a.add(input.nextInt());
              b.add(input.nextInt());
              c.add(input.nextInt());
            }
            b.addAll(c);
            a.addAll(b);
            input.close();
            for (int i = 0;i<a.size();i+=3){
              int s1 = a.get(i);
              int s2 = a.get(i+1);
              int s3 = a.get(i+2);
              if (s1 + s2 > s3 && s2 + s3 > s1 && s1+s3 > s2)
                total++;
              }
              System.out.println(total);
      } else {
              throw new NoSuchFieldError("not a valid method");
      }
    }catch(FileNotFoundException e) {
      System.out.println("you never said the file, add your file name");
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("exec again, but this time actually put the args (filename and method #)");
    }catch(NoSuchFieldError e){
      System.out.println("your method is wrong, it has to be either 1 or 2");
    }
  }
}
