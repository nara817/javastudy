package practice04_Shape; /*class 생성시 인터페이스 add 해서 생성*/

public class Circle implements Shape {
	
	// 필드
	private double radius;
	

	// 생성자
	public Circle(double Radius) {
		super();
		this.radius = radius;
	}	

	@Override
	public double getArea() {
		return PI * radius * radius;
	}


}
