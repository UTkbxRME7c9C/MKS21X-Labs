import java.util.Arrays;

public class BinarySearch{
  public static int binarySearch(int[] data, int target){
    int first = 0;
    int last = data.length-1;
    int mid = 0;
    while (first <= last){
      mid = (first+last)/2;
      if (data[mid] == target){
        return mid;
      }
      if (target > data[mid]){
        first = mid+1;
      } else if (target < data[mid]){
        last = mid-1;
      }
    }
    return -1;
  }

  public static void main(String[] args){
    int[] arr = new int[10];
    for (int i = 0;i<10;i++){
      arr[i] = (int)(Math.random()*100);
    }
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(binarySearch(arr, arr[1]));
    System.out.println(binarySearch(arr, arr[2]));
    System.out.println(binarySearch(arr, arr[3]));
    System.out.println(binarySearch(arr, arr[4]));
    System.out.println(binarySearch(arr, arr[5]));
  }
}
