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
    public double distanceTo(Point a){
	return Math.sqrt(Math.pow(x-a.x, 2)+Math.pow(y-a.y, 2));
    }
}

