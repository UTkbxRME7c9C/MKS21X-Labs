public class Test{
  public static void main(String[] args){
    SuperArray alist = new SuperArray();
    alist.add("Mario");
    alist.add("Ash");
    /*
    System.out.println(alist);
    System.out.println(alist.toString());
    System.out.println(alist.toStringDebug());
    */
    alist.add("Samus");
    alist.add("Link");
    alist.add("Kirby");
    /*
    System.out.println(alist);
    System.out.println(alist.toStringDebug());
    System.out.println(alist.size());
    */
    System.out.println(alist.get(10));
    System.out.println(alist.set(0, "Luigi"));
    System.out.println(alist.get(0));

  }
}
