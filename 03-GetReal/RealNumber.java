 public class RealNumber{
    private double value;
  
    public RealNumber(double v){
      value = v;
    }
  
    public double add(RealNumber other){
        return value + other.value;
    }
  
    public double multiply(RealNumber other){
      return value * other.value;
    }

    public double divide(RealNumber other){
      return value / other.value;
    }

    public double subtract(RealNumber other){
      return value-other.value;
    }
  
    public double getValue(){
      return value;
    }
  
    public String toString(){
      return ""+value;
    }
    
    public int compareTo(RealNumber other){
      double minuss = value - other.value;
      if (minuss < 0){
        return -1;
      }else if (minuss > 0){
        return 1;
      }
      return 0;
    }

    public boolean equals(RealNumber other){
      // maybe include closeEnough code?
      if (value == other.value)
        return true;
      return false;
    }
  }