public class Test{
  public static void getloop(SuperArray ary){
    System.out.println("--START OF ARRAY--");
    for (int i = 0; i < ary.size();i++ ){
      System.out.println(ary.data()[i]);
    }
    System.out.println("--END OF ARRAY--");
  }

  public static void setloop(SuperArray old){
    System.out.println("--Array change--");
    for (int i = 0; i< old.size(); i++){
      old.data()[i] = "Generic" + i;
    }
    getloop(old);
  }
  public static void loopone(SuperArray old){
    System.out.println("--Array change--");
    for (int i = 0; i< old.size()-1; i++){
      old.data()[i] = old.data()[i+1];
    }
    old.data()[old.size()-1] = "NOPE!";
    getloop(old);
  }




  public static void main(String[] args){
    SuperArray alist = new SuperArray();
    alist.add("Mario");
    alist.add("Ash");
    /*
    System.out.println(alist);
    System.out.println(alist.toString());
    System.out.println(alist.toStringDebug());
    */
    alist.add("Ash");
    alist.add("Samus");
    alist.add("Link");
    alist.add("Kirby");
    /*
    System.out.println(alist);
    System.out.println(alist.toStringDebug());
    System.out.println(alist.size());

    System.out.println(alist.get(10));
    System.out.println(alist.set(0, "Luigi"));
    System.out.println(alist.get(0));
    getloop(alist);
    setloop(alist);
    loopone(alist);
    */
    System.out.println(alist.indexOf("Ash"));
    System.out.println(alist.lastIndexOf("Ash"));
    alist.add(1, "aaa");
    System.out.println(alist);


  }
}
