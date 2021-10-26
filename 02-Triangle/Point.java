public class Point{
    private double x,y;
    public Point(double X, double Y){
        x=X;
        y=Y;
    }
    public Point(Point p){
        x= p.x;
        y= p.y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public String toString(){
	return "("+x+", "+y+")";	    
    }
    public static double distance(Point a, Point b){
	return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2)) ;
    }
    public static boolean closeEnough(double a, double b){
	    double clo =  (Math.abs((a-b)/b))*100;
	    return clo <= 0.001;
    }
    public double distanceTo(Point a){
	return Math.sqrt(Math.pow(x-a.x, 2)+Math.pow(y-a.y, 2));
    }
    public static void main(String[]args){
	System.out.println(closeEnough(0.1234567899,0.1234567890));
    }
}

