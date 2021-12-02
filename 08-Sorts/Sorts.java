import java.util.Arrays;

public class Sorts{
  public static void main(String[]args){
    int[] same = new int[1000];
    int[] rand = new int[1000];
    int[] nrand = new int[1000];
    for (int i = 0;i <same.length; i++){
      same[i] = 1;
      rand[i] = (int)(Math.random()*100);
      nrand[i] = rand[i]*-1;
    }
    System.out.println(test(same));
    System.out.println(test(rand));
    System.out.println(test(nrand));

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
  public static boolean test(int[] data){
    int[] copy = Arrays.copyOf(data, data.length);
    int[] copy2 = Arrays.copyOf(data, data.length);
    bubbleSort(copy);
    Arrays.sort(copy2);
    if (Arrays.equals(copy,copy2))
      return true;
    return false;
  }
}
