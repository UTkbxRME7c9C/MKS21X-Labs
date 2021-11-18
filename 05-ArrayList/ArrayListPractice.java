import java.util.ArrayList;
public class ArrayListPractice{
  public static ArrayList<String> replaceEmpty( ArrayList<String> data){
    ArrayList<String> e = new ArrayList<String>();
    for (int i=0;i<data.size();i++){
        if (data.get(i).equals("")){
          e.add("Empty");
        }else{
          e.add(data.get(i));
        }
    }
    return e;
  }

  public static ArrayList<String> newRandomArray(int len){
    ArrayList<String> e = new ArrayList<String>();
    for (int i = 0;i<len;i++){
      e.add(""+ (int)(Math.random()*100));
    }
    return e;
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> data){
    ArrayList<String> e = new ArrayList<String>();
    for(int i=0;i<data.size();i++){
      e.add( data.get(data.size()-1-i));
    }
    return e;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    int maxi = Math.max(a.size(), b.size());
    int mini = Math.min(a.size(), b.size());
    ArrayList<String> e = new ArrayList<String>();  
    for (int i = 0;i<maxi; i++){
      if (i < mini){
        e.add(a.get(i));
        e.add(b.get(i));
      } else if (a.size() == maxi){
        e.add(a.get(i));
      } else {
        e.add(b.get(i));
      }
    }
    return e;
  }
  public static void main(String[] args){
    ArrayList<String> arr1 = newRandomArray(4); 
    ArrayList<String> arr2 = newRandomArray(200000);
    ArrayList<String> arr3 = newRandomArray(200000);
    /*
    System.out.println(arr1 + " " + arr2);
    System.out.println(mixLists(arr1,arr2));
    System.out.println(makeReversedList(arr1));
    arr1.set(0,"");
    System.out.println(replaceEmpty(arr1));
    */
    arr1 = makeReversedList(arr3);
    arr1 = mixLists(arr1,arr2);
    System.out.println(arr1);


  }
}
