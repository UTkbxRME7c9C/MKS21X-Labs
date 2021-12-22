public class classwork{
    public static int stringToInt(String s){
        int total = 0;
        boolean isNegative = false;
        if (s.charAt(0) == '-'){
            s = s.substring(1);
            isNegative = true;
        }
        for (int i = 0; i < s.length();i++){
            int place = (int)(Math.pow(10, s.length()-i-1));
            total+= valueOfDigit(s.charAt(i))*place;
        }
        if (isNegative) total=total*-1;
        return total;
    } 
    public static int valueOfDigit(char c){
        return c - 48;
    }
    public static void main(String[] args){
        System.out.println(stringToInt("-0"));
        System.out.println(stringToInt("-1"));
        System.out.println(stringToInt("-9"));
        System.out.println(stringToInt("-10"));
        System.out.println(stringToInt("-100"));
        System.out.println(stringToInt("-543"));
        System.out.println(stringToInt("-34636"));


    }
}
