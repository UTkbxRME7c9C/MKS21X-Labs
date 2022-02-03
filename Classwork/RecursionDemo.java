public class RecursionDemo{
    public static final char[] comb = {'a','b','c'};
    public static void makeWords(int size, String results){
        if (size==0){ System.out.println(results);} else{
        for(int i = 0;i<comb.length;i++){
            makeWords(size-1,results+comb[i]);
        }}
    }

    public static void printBinary(int length){
        printBinary(length,"");
      }

      public static void printBinary(int n,String word){
        if(n == word.length()){
          System.out.println(word);
        }else{
          printBinary(n,word+"0");
          printBinary(n,word+"1");
        }
      }

    public static void main(String[] args){
       makeWords(3,"");
    }
}