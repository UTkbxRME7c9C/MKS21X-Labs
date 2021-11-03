public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  public RationalNumber(int nume, int deno){
    super(0.0);
    if (deno == 0) {
        denominator = 1;
        numerator = 0;
    } else {
        denominator = deno;
        numerator = nume;
    }
  }

  public double getValue(){
    return 0.0;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }
  public RationalNumber reciprocal(){
    return (new RationalNumber(denominator,numerator));
  }
  public boolean equals(RationalNumber other){
    return (numerator == other.numerator) && (denominator == other.denominator);
  }

  public String toString(){
    return numerator +"/"+ denominator;
  }

  private static int gcd(int a, int b){
    int tmp = a;
    if (b > a){
        a = b;
        b = tmp;
    }
    while (b != 0){
        tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
  }

  private void reduce(){
    int gecd = gcd(numerator, denominator);
    numerator = numerator / gecd;
    denominator = denominator / gecd;
  }

  public RationalNumber multiply(RationalNumber other){
    RationalNumber aa = new RationalNumber(numerator * other.numerator, denominator * other.denominator);
    aa.reduce();
    return aa;
  }

  public RationalNumber divide(RationalNumber other){
    RationalNumber aa = new RationalNumber(numerator * other.denominator, denominator * other.numerator);
    aa.reduce();
    return aa;
  }

  public RationalNumber add(RationalNumber other){
    RationalNumber aa = new RationalNumber((numerator * other.denominator)+(other.numerator*denominator), denominator * other.denominator);
    aa.reduce();
    return aa;
  }

  public RationalNumber subtract(RationalNumber other){
    RationalNumber aa = new RationalNumber((numerator * other.denominator)-(other.numerator*denominator), denominator * other.denominator);
    aa.reduce();
    return aa;
  }
} 