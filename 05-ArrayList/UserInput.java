import java.util.ArrayList;
import java.util.Scanner;

public class UserInput{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Double> output = new ArrayList<Double>(1);
        double nums = 0.0;
        double average = 0.0;
        double mins = Double.MAX_VALUE;
        double maxs = Double.MIN_VALUE;
        while (true){
            System.out.println("Enter a non negative number. A negative number will end the program:");
            nums = Double.parseDouble(input.nextLine());
            if (nums < 0){
                input.close();
                average = average/output.size();
                break;
            } else {
                output.add(nums);
                average += nums;
                mins = Math.min(mins, nums);
                maxs = Math.max(maxs, nums);
            }
        }
        System.out.println("You entered: " + output );
        System.out.println("Mean: " + average);
        System.out.println("Min value: "+mins);
        System.out.println("Max value: "+maxs);
    }
}