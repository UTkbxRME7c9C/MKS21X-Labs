import java.util.ArrayList;
public class ArrayListPractice{
  public static ArrayList<String> replaceEmpty( ArrayList<String> data){
    ArrayList<String> e = new ArrayList<String>(data.size());
    for (int i=0;i<data.size();i++){
        if (data.get(i).equals("")){
          e.set(i,"Empty")
        }else{
          e.set(i, data.get(i));
        }
    }
    return e;
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> data){
    ArrayList<String> e = new ArrayList<String>(data.size());
    for(int i=0;i<data.size();i++){
      e.set(data.size()-i, data.get(i));
    }
    return e;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    //return a new ArrayList that has all values of a and b in alternating order that is:
    //a[0], b[0], a[1], b[1]...
    //when one list is longer than the other, just append the remaining values to the end.
  }
}
