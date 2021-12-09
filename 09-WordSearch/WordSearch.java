import java.util.Arrays;
/*Lab9: Word Search generator
*/
public class WordSearch{
    private char[][] data;
        /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
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
      try{
        char[] tmp = data[row].clone();
        int tmp2 = 0;
        if (data[row].length-col < word.length()){
          throw new Exception();
        }
        for(int i = col;i<data[row].length;i++){
          if(tmp2 < word.length()){
            if (tmp[i] != '_' && tmp[i] != word.charAt(tmp2)){
              throw new Exception();
            }else{
              tmp[i] = word.charAt(tmp2);
              tmp2++;
            }
          }
        }
        data[row] = tmp.clone();
        return true;
      }catch(Exception e){
        return false;
      }
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
        try{
          if (data.length-row < word.length()){
            throw new Exception();
          }
          char[] tmp = new char[data.length];
          for (int i=0;i<data.length;i++){
            for (int j = 0;j<data[i].length;j++){
               tmp[i] = data[i][col];
            }
          }
          int tmp2 = 0;
          for (int i=row;i<data.length;i++){
            if (tmp2 < word.length()){
              if (tmp[i] != '_' && tmp[i] != word.charAt(tmp2)){
                throw new Exception();
              } else {
                tmp[i] = word.charAt(tmp2);
                tmp2++;
              }
            }
          }
          for (int i=0;i<data.length;i++){
            data[i][col] = tmp[i];
          }
          return true;
        }catch( Exception e){
          return false;
        }
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
      try{
        if (data.length-row < word.length() || data[row].length-col < word.length()){
          throw new Exception();
        }
        int tmp2 = 0;
        for(int i = row;i<data.length;i++){
          if (data[i][col] != '_' && data[i][col] != word.charAt(tmp2)){
            throw new Exception();
          } else{
            data[i][col] = word.charAt(tmp2);
            col++;
            tmp2++;
          }
        }
        return true;
      }catch(Exception e){
        return false;
      }
    }

}
