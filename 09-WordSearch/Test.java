public class Test{
  public static void main(String[] args){
    WordSearch a = new WordSearch(10,10);
    System.out.println(a.addWordHorizontal("cccccccc", 0, 0));

    System.out.println(a.addWordVertical("aaaa", 1, 2));
    System.out.println(a.addWordDiagonal("hioo", 1,5));
    System.out.println(a.addWordDiagonalRev("baaab", 4,9));
    System.out.println(a.toString());

  }
}
