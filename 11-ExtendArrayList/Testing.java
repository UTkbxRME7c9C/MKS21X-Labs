public class Testing {
    public static void main(String[] args){
      OrderedArrayList<String> b = new OrderedArrayList<String>();
      b.add("cccc");
      b.add("bbbb");
      b.add("aaaa");
      b.add("cock");
      b.add(0,"helo");
      b.set(0,"cbba");
      System.out.println(b.toString());     

    }
}
