public class classwork{
    public static int stringToInt(String s){
        int total = 0;
        for(int i = s.length()-1;i>=0;i--){
            int place = (int)(Math.pow(10,(i-(s.length()-1))));
            total= total+ (valueOfDigit(s.charAt(i))*place);
        }
        return total;
    } 
    public static int valueOfDigit(char c){
        return c - 48;
    }
    public static void main(String[] args){
        int t = stringToInt("111");
        System.out.println(t);
    }
}
