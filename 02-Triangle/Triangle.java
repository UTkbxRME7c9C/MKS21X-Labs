public class Triangle{
	private Point v1,v2,v3;
	public Triangle(Point A, Point B, Point C){
		v1 = A;
		v2 = B;
		v3 = C;
	}
	public  Triangle(double AX, double AY, double BX, double BY, double CX, double CY){
		v1 = new Point(AX, AY);
		v2 = new Point(BX, BY);
		v3 = new Point(CX, CY);
	}

	public void setVertex(int ver, Point a){
		if (ver == 1)
			v1 = a;
		if (ver == 2)
			v2 = a;
		if (ver == 3)
			v3 = a;
	}
	public Point getVertex(int ver){
		Point[] pts = {v1,v2,v3};
		return pts[ver-1];
	}
	public String toString(){
		return "{"+v1.toString()+", "+v2.toString() + ", " + v3.toString()+"}";
	}
	public double getPerimeter(){
		return v1.distanceTo(v2) + v2.distanceTo(v3) + v3.distanceTo(v1);
	}

	public static boolean closeEnough(double a, double b){
		double clo = (Math.abs((a-b)/b))*100;
		return clo <= 0.001:
	}
	public static void main(String[]args) {
		Triangle T1 = new Triangle(1,2,3,4,6,3);
		Triangle T2 = new Triangle(new Point(1*Math.sqrt(4),2),new Point(3*Math.sqrt(4),4),new Point(6*Math.sqrt(3),3*Math.sqrt(2)));
		Triangle T3 = new Triangle(2,4*Math.sqrt(6),8,10*Math.sqrt(12),1,1);
		System.out.println(T1.toString());
		System.out.println(T2.getPerimeter());
		System.out.println(T3.getVertex(1).toString());
		T3.setVertex(1, new Point(5,5));
		System.out.println(T3.getVertex(1).toString());
		System.out.println(T3.toString());

	}
}
