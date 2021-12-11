public class Test{
  public static void main(String[] args){
    WordSearch a = new WordSearch(10,10, "words",500);
   // System.out.println(a.addWordHorizontal("cccc", 0, 0));
    // System.out.println(a.addWordVertical("aaaa", 1, 2));
    // System.out.println(a.addWordDiagonal("hioo", 1,5));
    // System.out.println(a.addWordDiagonalRev("baaab", 4,9));

    //System.out.println(a.addWord(4,5,"qwe",1,0));
    //System.out.println(a.addWord(4,2,"rty",-1,0));
    //System.out.println(a.addWord(2,3,"egr",-1,-1));
    //System.out.println(a.addWord(2,3,"egr",-1,0));
    //a.addAllWords("words");
    
    System.out.println(a.toString());
  }

}

