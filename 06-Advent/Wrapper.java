import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wrapper{
    public static void main(String[] args){
        try{
            if (args[1].equals("1")){
                File file = new File(args[0]);
                Scanner input = new Scanner(file);
                int total = 0;
                while (input.hasNextLine()){
                    String[] line = (input.nextLine().split("x"));
                    int l = Integer.parseInt(line[0]);
                    int w = Integer.parseInt(line[1]);
                    int h = Integer.parseInt(line[2]);
                    total += ((2*l)*w)+((2*w)*h)+((2*h)*l) + Math.min(Math.min((l*w), (l*h)), (w*h));
                }
                input.close();
                System.out.println(total);
            }else if (args[1].equals("2")){

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