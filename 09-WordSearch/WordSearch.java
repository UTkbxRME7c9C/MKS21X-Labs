// import java.util.Arrays;
// import java.util.ArrayList;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.Scanner;
//
// public class WordSearch{
//     public static void main(String[] args){
//         try{
//             File file = new File(args[2]);
//             Scanner input = new Scanner(file);
//             ArrayList<String> words = new ArrayList<String>(Arrays.asList(input.nextLine().split(",")));
//             input.close();
//             System.out.println(Arrays.deepToString(letras));
//             System.out.println(words);
//             for(int i = 0;i<words.size();i++){
//                 if (words.get(i).length() > Integer.parseInt(args[0]) && words.get(i).length() > Integer.parseInt(args[1])){
//                     words.remove(i);
//                     i--;
//                 }
//             }
//             System.out.println(words);
//         }catch(FileNotFoundException e){
//             System.out.println("no file??");
//         }
//     }
// }














public class WordSearch{
    private char[][] data;
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      for (int i=0;i<data.length;i++){
        for (int j = 0;j<data[i].length;j++){
          data[i][j] = '_';
        }
      }
    }

    private void clear(){
      for (int i=0;i<data.length;i++){
        for (int j = 0;j<data[i].length;j++){
          data[i][j] = '_';
        }
      }
    }

    public String toString(){
      String full = "aa\naa";
      return full;
    }

}
