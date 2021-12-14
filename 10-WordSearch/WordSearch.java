
import java.util.*;
import java.io.*;
/*Lab9: Word Search generator
*/
public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsAdded;
    private int seed;
    private Random randgen;
        /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols, String filename){
      data = new char[rows][cols];
      randgen = new Random();
      seed = randgen.nextInt();
      randgen = new Random(seed);
      clear();
      addAllWords(filename);
      fillInRandomLetters();
    }

    public WordSearch(int rows,int cols, String filename, int randSeed){
      data = new char[rows][cols];
      seed = randSeed;
      randgen = new Random(seed);
      clear();
      addAllWords(filename);
      fillInRandomLetters();
    }

    private void clear(){
      for (int i=0;i<data.length;i++){
        for (int j = 0;j<data[i].length;j++){
          data[i][j] = '_';
        }
      }
    }
    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String ret = "";
      for (int i=0;i<data.length;i++){
        for (int j = 0;j<data[i].length;j++){
           ret+= data[i][j] + " ";
        }
        ret+="\n";
      }
      ret+= "Words: ";
      for (int i = 0; i < wordsAdded.size()-1;i++){
        ret+= wordsAdded.get(i)+", ";
      }
      ret+= wordsAdded.get(wordsAdded.size()-1) + "\nseed: " + seed;
      return ret;
    }
        /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    // public boolean addWordHorizontal(String word,int row, int col){
    //   int tmp2 = 0;
    //   if (data[row].length-col < word.length()){
    //     return false;
    //   }
    //   for(int i = col;i<word.length()+col;i++){
    //     if(tmp2 < word.length()){
    //       if (data[row][i] != '_' && data[row][i] != word.charAt(tmp2)){
    //         return false;
    //       }
    //       tmp2++;
    //     }
    //   }
    //   tmp2 = 0;
    //   for(int i = col;i<data[row].length;i++){
    //     if(tmp2 < word.length()){
    //       data[row][i] = word.charAt(tmp2);
    //       tmp2++;
    //     }
    //   }
    //   return true;
    // }


   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    // public boolean addWordVertical(String word,int row, int col){
    //   int tmp2 = 0;
    //   if (data.length-row < word.length()){
    //     return false;
    //   }
    //   for (int i=row;i<data.length;i++){
    //     if (tmp2 < word.length()){
    //       if (data[i][col] != '_' && data[i][col] != word.charAt(tmp2)){
    //         return false;
    //       }
    //       tmp2++;
    //     }
    //   }
    //   tmp2 = 0;
    //   for (int i=row;i<data.length;i++){
    //     if (tmp2 < word.length()){
    //       data[i][col] = word.charAt(tmp2);
    //       tmp2++;
    //     }
    //   }
    //   return true;
    // }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left towards the bottom right, it must fit on the board,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    // public boolean addWordDiagonal(String word,int row, int col){
    //   if (data.length-row < word.length() || data[row].length-col < word.length()){
    //     return false;
    //   }
    //   int tmp2 = 0;
    //   int coltmp = col;
    //   for(int i = row;i<data.length;i++){
    //     if(tmp2 < word.length()){
    //       if (data[i][coltmp] != '_' && data[i][coltmp] != word.charAt(tmp2)){
    //         return false;
    //       }
    //       tmp2++;
    //       coltmp++;
    //     }
    //   }
    //   tmp2 = 0;
    //   for(int i = row;i<data.length;i++){
    //     if(tmp2 < word.length()){
    //       data[i][col] = word.charAt(tmp2);
    //       col++;
    //       tmp2++;
    //     }
    //   }
    //   return true;
    // }

        /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added in the direction rowIncrement,colIncrement
    *Words must have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical locaiton of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@param rowInc is -1,0, or 1 and represents the displacement of each letter in the row direction
    *@param colInc is -1,0, or 1 and represents the displacement of each letter in the col direction
    *@return true when: the word is added successfully.
    *        false (and do not change the board at all) when any of the following happen:
    *        a) rowInc and colInc are both 0,
    *        b) the word doesn't fit,
    *        c) there are overlapping letters that do not match
    */
    private boolean addWord(int row, int col, String word, int rowInc, int colInc){
      if (rowInc == 0 && colInc == 0) return false;
      int x;
      int y;
      for (int i = 0; i < word.length();i++){
        x = col + colInc*i;
        y = row + rowInc*i;
        if ((x < 0 || x >= data[row].length) || (y < 0 || y >= data.length)){
          return false;
        }
        if (data[y][x] != '_' && data[y][x] != word.charAt(i)){
          return false;
        }
      }
      for (int i = 0; i < word.length();i++){
        data[row + rowInc*i][col + colInc*i] = word.charAt(i);
      }
      return true;
    }

    private void addAllWords(String filename){
      wordsAdded = new ArrayList<String>();
      ArrayList<String> wordsToBeAdded = new ArrayList<String>();
      try{
        File file = new File(filename);
        Scanner input = new Scanner(file);
        while(input.hasNextLine()){
          String in = input.nextLine();
          if (! in.equals(""))
            wordsToBeAdded.add(in.toUpperCase());
        }
        input.close();
      }catch (FileNotFoundException e){
        System.out.println("no file");
      }
      Collections.shuffle(wordsToBeAdded, randgen);
      int count;
      for (int i = 0; i < wordsToBeAdded.size();i++){
        count = 50;
        while (count > 0){
          if (addWord(randgen.nextInt(data.length), randgen.nextInt(data[0].length), wordsToBeAdded.get(i), randgen.nextInt(3)-1, randgen.nextInt(3)-1)){
            wordsAdded.add(wordsToBeAdded.get(i));
            break;
          }
          count--;
        }
      }
    }

    private void fillInRandomLetters(){
      for (int i=0;i<data.length;i++){
        for (int j = 0;j<data[i].length;j++){
          if (data[i][j] == '_')
            data[i][j] = (char) (randgen.nextInt(26)+65);
        }
      }
    }

}