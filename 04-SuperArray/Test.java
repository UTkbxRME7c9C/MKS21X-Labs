public class Test{
  public static void main(String[] args){
    SuperArray alist = new SuperArray();
    alist.add("Mario");
    /*
    System.out.println(alist);
    System.out.println(alist.toStringDebug());
    alist.add("Samus");
    System.out.println(alist);
    System.out.println(alist.toStringDebug());
    */
    alist.add("Ash");
    alist.add("Link");
    alist.add("Kirby");
    /*
    System.out.println(alist.toString());
    System.out.println(alist.size());
    System.out.println(alist.toStringDebug());
    */
    System.out.println(alist.get(-1));
  }
}
