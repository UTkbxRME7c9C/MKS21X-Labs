public class Demo{
	public static double distance(Point a, Point b){
		return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));

	}

    public static void main(String[]args){
        Point P1 = new Point(1,2);
        Point P2 = new Point(3,4);

	System.out.println(distance(P1,P2));
	System.out.println(Point.distance(P1,P2));
	System.out.println(  P1.distanceTo(P2));
    }
 } 
