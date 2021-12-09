public class Test{
  public static void main(String[] args){
    WordSearch a = new WordSearch(5,8);
    System.out.println(a.addWordVertical("lol", 1, 5));
    System.out.println(a.addWordHorizontal("baka", 4, 4));
    System.out.println(a.toString());

  }
}
