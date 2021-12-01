import java.util.Arrays;

public class Sorts{
  public static void main(String[]args){
    int[] t1 = {5,4,4,2,1,1,2,5,6,7,3,99};
    System.out.println(Arrays.toString(t1));
    bubbleSort(t1);
    System.out.println(Arrays.toString(t1));
  }
  public static void bubbleSort(int[] data){
    int t = data.length;
    while (t > 0){
      for(int i = 0;i<data.length-1;i++){
        if (data[i] > data[i+1]){
          int tmp = data[i];
          data[i] = data[i+1];
          data[i+1] = tmp;
        }
      }
      t--;
    }

  }
}
