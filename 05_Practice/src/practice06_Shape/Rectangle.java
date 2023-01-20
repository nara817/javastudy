package practice06_Shape; // is a로 풀이

// 정사각형 상속관계 (자식: 사각형)
public class Rectangle implements Shape { // implements Shape 지우고 extends 입력

	// 필드
	private double width;
	private double height;

	// 생성자
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
}
