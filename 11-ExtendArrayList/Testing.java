public class Testing {
    public static void main(String[] args){
      OrderedArrayList<String> b = new OrderedArrayList<String>();
      b.add("aaa");
      b.add("aab");
      b.add("aae");
      b.add("aac");
      b.add("bbb");
      b.add("aa");
      b.add("eee");
      System.out.println(b.toString());  
      b.sort();
      System.out.println(b.toString());  
      System.out.println(b.whereToPlace("ccc"));   

    }
}
