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
    System.out.println("Negative Reverse test = "+test(revand, args[0]));
    Arrays.sort(revand); // [-99...-1]
    for(int i = 0;i<revand.length;i++){
      revand[i] = revand[i]*-1;
    }//[99...1]
    System.out.println("Reverse sort test =     "+test(revand, args[0]));
    System.out.println("All same ints test =    "+test(same, args[0]));
    System.out.println("Random array test =     "+test(rand, args[0]));
    System.out.println("Negative random test =  "+ test(nrand, args[0]));
    System.out.println("No length test =        "+ test(noray, args[0]));
    System.out.println("One length test =       "+ test(Arrays.copyOf(rand, 1), args[0]));
    System.out.println("Two length test =       "+ test(Arrays.copyOf(rand, 2), args[0]));
    Arrays.sort(rand);
    System.out.println("Sort test =             "+ test(rand, args[0]));
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

  public static boolean test(int[] data, String type){
    int[] copy = Arrays.copyOf(data, data.length);
    int[] copy2 = Arrays.copyOf(data, data.length);
    if (type.equals("bubbleSort")){
      bubbleSort(copy);
    } else if (type.equals("selectionSort")){
      selectionSort(copy);
    }
    Arrays.sort(copy2);
    if (Arrays.equals(copy,copy2))
      return true;
    return false;
  }

  public static void selectionSort(int[] ary){
    int t = 0;
    while (t < ary.length){
      int min = Integer.MAX_VALUE;
      int temp = 0;
      for (int i = t;i<ary.length;i++){
        if (ary[i] < min){
          min = Math.min(min,ary[i]);
          temp = i;
        }
      }
      ary[temp] = ary[t];
      ary[t] = min;
      t++;
    }
  }

  public static void insertionSort(int[] ary){
	for(int i = 1;i < ary.length; i++){
		if (ary[i] < ary[i-1]){
			int tmp = ary[i];
			for(int j = i;j >=0;j--){
				if (ary[j] < tmp){

				} else{
					
				}
			}
		}
	}	
  }
}
