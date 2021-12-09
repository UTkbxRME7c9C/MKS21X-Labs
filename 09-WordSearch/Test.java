public class Test{
  public static void main(String[] args){
    WordSearch a = new WordSearch(5,8);
    // System.out.println(a.addWordVertical("aaaa", 1, 5));
    // System.out.println(a.addWordHorizontal("bbbb", 4, 4));
    System.out.println(a.addWordDiagonal("bbbb", 1, 3));
    System.out.println(a.toString());

  }
}
