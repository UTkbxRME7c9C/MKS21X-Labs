public class Tester{
    public static void main(String[] args){
        RealNumber now = new RealNumber(56.2);
        RealNumber wow = new RealNumber(56.2);
        System.out.println(now.getValue());
        System.out.println(wow.getValue());
        System.out.println(wow.subtract(now));
        System.out.println(wow.divide(now));
        System.out.println(wow.multiply(now));
        System.out.println(wow.add(now));
        System.out.println(wow.compareTo(now));
        System.out.println(wow.equals(now));

        /*
        RationalNumber naw = new RationalNumber(1, 2);
        RationalNumber waw = new RationalNumber(3, 4);
        System.out.println("rational " + waw.getNumerator());
        System.out.println(waw.getDenominator());
        System.out.println(waw.toString());
        System.out.println(waw.reciprocal().toString());
        System.out.println(waw.equals(naw));
        System.out.println(waw.multiply(naw).toString());
        System.out.println(waw.divide(naw).toString());
        System.out.println(waw.add(naw).toString());
        System.out.println(naw.subtract(waw).toString());
        */





    }
}
