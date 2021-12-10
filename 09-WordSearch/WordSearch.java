
import java.util.*;
import java.io.*;
/*Lab9: Word Search generator
*/
public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private int seed;
    private Random randgen;
        /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     */
    // public WordSearch(int rows,int cols){
    //   data = new char[rows][cols];
    //   clear();
    // }
      public WordSearch(int rows, int cols, String filename ){
        data = new char [rows][cols];
        clear();
      }
    /**Set all values in the WordSearch to underscores'_'*/
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
    public boolean addWordHorizontal(String word,int row, int col){
      int tmp2 = 0;
      if (data[row].length-col < word.length()){
        return false;
      }
      for(int i = col;i<word.length()+col;i++){
        if(tmp2 < word.length()){
          if (data[row][i] != '_' && data[row][i] != word.charAt(tmp2)){
            return false;
          }
          tmp2++;
        }
      }
      tmp2 = 0;
      for(int i = col;i<data[row].length;i++){
        if(tmp2 < word.length()){
          data[row][i] = word.charAt(tmp2);
          tmp2++;
        }
      }
      return true;
    }


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
    public boolean addWordVertical(String word,int row, int col){
      int tmp2 = 0;
      if (data.length-row < word.length()){
        return false;
      }
      for (int i=row;i<data.length;i++){
        if (tmp2 < word.length()){
          if (data[i][col] != '_' && data[i][col] != word.charAt(tmp2)){
            return false;
          }
          tmp2++;
        }
      }
      tmp2 = 0;
      for (int i=row;i<data.length;i++){
        if (tmp2 < word.length()){
          data[i][col] = word.charAt(tmp2);
          tmp2++;
        }
      }
      return true;
    }

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
    public boolean addWordDiagonal(String word,int row, int col){
      if (data.length-row < word.length() || data[row].length-col < word.length()){
        return false;
      }
      int tmp2 = 0;
      int coltmp = col;
      for(int i = row;i<data.length;i++){
        if(tmp2 < word.length()){
          if (data[i][coltmp] != '_' && data[i][coltmp] != word.charAt(tmp2)){
            return false;
          }
          tmp2++;
          coltmp++;
        }
      }
      tmp2 = 0;
      for(int i = row;i<data.length;i++){
        if(tmp2 < word.length()){
          data[i][col] = word.charAt(tmp2);
          col++;
          tmp2++;
        }
      }
      return true;
    }

    public boolean addWord(int row, int col, String word, int rowInc, int colInc){
      if (colInc == 0){ //horizontal
        if (rowInc == 1){
          int tmp = 0;
          if (data[row].length-col < word.length()){
            return false;
          }
          for(int i = col;i<word.length()+col;i++){
            if(tmp < word.length()){
              if (data[row][i] != '_' && data[row][i] != word.charAt(tmp)){
                return false;
              }
              tmp++;
            }
          }
          tmp = 0;
          for(int i = col;i<data[row].length;i++){
            if(tmp < word.length()){
              data[row][i] = word.charAt(tmp);
              tmp++;
            }
          }
        } else if (rowInc == -1){
          if (col+1 < word.length()){
            return false;
          }
          int tmp = 0;
          for(int i = col;i>0;i--){
            if(tmp < word.length()){
              if (data[row][i] != '_' && data[row][i] != word.charAt(tmp)){
                return false;
              }
              tmp++;
            }
          }
          tmp = 0;
          for(int i = col;i>=0;i--){
            if(tmp < word.length()){
              data[row][i] = word.charAt(tmp);
              tmp++;
            }
          }
        }
      } else if (colInc == 1){
        if (rowInc == 0){
          int tmp = 0;
          if (data.length-row < word.length() || col >= data[0].length){
            return false;
          }
          for (int i=row;i<data.length;i++){
            if (tmp < word.length()){
              if (data[i][col] != '_' && data[i][col] != word.charAt(tmp)){
                return false;
              }
              tmp++;
            }
          }
          tmp = 0;
          for (int i=row;i<data.length;i++){
            if (tmp < word.length()){
              data[i][col] = word.charAt(tmp);
              tmp++;
            }
          }
        }
      } else if (colInc == -1){
        if (rowInc == 0){
          if (row+1 < word.length() || row >= data.length){
            return false;
          }
          int tmp = 0;
          for (int i=row;i>=0;i--){
            if (tmp < word.length()){
              if (data[i][col] != '_' && data[i][col] != word.charAt(tmp)){
                return false;
              }
              tmp++;
            }
          }
          tmp = 0;
          for (int i=row;i>=0;i--){
            if (tmp < word.length()){
              data[i][col] = word.charAt(tmp);
              tmp++;
            }
          }
        }
      }
      return true;
    }

}