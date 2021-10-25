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

	}
	public String toString(){
		return "{"+v1.toString()+", "+v2.toString() + ", " + v3.toString()+"}";
	}

	public static void main(String[]args) {
		Triangle T1 = new Triangle(1,2,3,4,6,3);
		Triangle T2 = new Triangle(new Point(1,2),new Point(3,4),new Point(6,3));
		System.out.println(T1.toString());
		System.out.println(T2.toString());
	}
}
