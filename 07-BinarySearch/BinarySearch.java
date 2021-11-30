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
    int result; 
    result = binarySearch(new int[]{0,0,0,0,0,0,0},0);
    System.out.println(result);//should be 3
    result = binarySearch(new int[]{0,0,0,0,0,0,0},1);
    System.out.println(result);//should be -1
    
    result = binarySearch(new int[]{0,1,2,3,4,5,6},0);
    System.out.println(result);//should be 0
    result = binarySearch(new int[]{0,1,2,3,4,5,7},7);
    System.out.println(result);//should be 6   
    result = binarySearch(new int[]{9,5,4},4);
    System.out.println(result);//should be 2 but its not...    


  }
}
