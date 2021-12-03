import java.util.Arrays;

public class Sorts{
  public static void main(String[]args){
    int[] same = new int[1000];
    int[] rand = new int[1000];
    int[] nrand = new int[1000];
    int[] noray = new int[0];
    for (int i = 0;i <same.length; i++){
      same[i] = 1;
      rand[i] = (int)(Math.random()*1000);
      nrand[i] = rand[i]*-1;
    }
    int[] revand = Arrays.copyOf(rand, 1000);
    Arrays.sort(revand); // [1 ... 99]
    for(int i = 0;i<revand.length;i++){
      revand[i] = revand[i]*-1;
    } // [-1... -99]
    System.out.println("Negative Reverse test = "+test(revand));
    Arrays.sort(revand); // [-99...-1]
    for(int i = 0;i<revand.length;i++){
      revand[i] = revand[i]*-1;
    }//[99...1]
    System.out.println("Reverse sort test =     "+test(revand));
    System.out.println("All same ints test =    "+test(same));
    System.out.println("Random array test =     "+test(rand));
    System.out.println("Negative random test =  "+ test(nrand));
    System.out.println("No length test =        "+ test(noray));
    System.out.println("One length test =       "+ test(Arrays.copyOf(rand, 1)));
    System.out.println("Two length test =       "+ test(Arrays.copyOf(rand, 2)));
    Arrays.sort(rand);
    System.out.println("Sort test               "+ test(rand));
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
