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
	public boolean equals(Triangle other){
		return (v1.equals(other.v1) && v2.equals(other.v2)) && v3.equals(other.v3) ;
	}
	public String classify(){
		double a= v1.distanceTo(v2);
		double b= v2.distanceTo(v3);
		double c= v3.distanceTo(v1);
		if (closeEnough(a,b) && closeEnough(b,c)){
			return "equilateral";
		} else if ((closeEnough(a,b) || closeEnough(b,c)) || closeEnough(a,c) ){
			return "isosceles";
		}
		return "scalene";
	}
	public double area(){
		double s = (v1.distanceTo(v2) + v2.distanceTo(v3) + v3.distanceTo(v1))/2;
		return Math.sqrt(s*(s-v1.distanceTo(v2))*(s-v2.distanceTo(v3))*(s-v3.distanceTo(v1)));
	}

	public static boolean closeEnough(double a, double b){
		double clo = (Math.abs((a-b)/b))*100;
		return (clo <= 0.001) || (a == 0.0 && b == 0.0);
	}
	public static void main(String[]args) {
		Triangle T1 = new Triangle(1,2,3,4,6,3);
		Triangle T2 = new Triangle(new Point(1*Math.sqrt(4),2),new Point(3*Math.sqrt(4),4),new Point(6*Math.sqrt(3),3*Math.sqrt(2)));
		Triangle T3 = new Triangle(2,4*Math.sqrt(6),8,10*Math.sqrt(12),1,1);
		Triangle T4 = new Triangle(1,2,3,4,6,3);
		System.out.println(T1.toString());
		System.out.println(T2.getPerimeter());
		System.out.println(T3.getVertex(1).toString());
		T3.setVertex(1, new Point(5,5));
		System.out.println(T3.getVertex(1).toString());
		System.out.println(T3.toString());
		Point P1 = new Point(0.1234567890,0.1234567899);
		System.out.println(closeEnough(0.00000, 0.0000));
		System.out.println(P1.equals(new Point(0.001, 0.001)));
		System.out.println(T1.equals(T4));	
		System.out.println(T1.area());
		Triangle T5 = new Triangle(1,1,2,2,3,1);
		Triangle T6 = new Triangle(0,0,3,3*Math.sqrt(3),6,0);
	       	System.out.println(T5.classify());	
	       	System.out.println(T6.classify());	
	}
}
