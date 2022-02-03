//OLD CW


public class Recursion{
    public int powerN(int base, int n) {
        if (n>1){
          int a = base*base;
          n-=1;
          powerN(a,n);
        }
        return base; 
      }
    public static void main(String[] args){

    }
}