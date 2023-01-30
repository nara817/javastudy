package practice071_Coffee;

public class CoffeeBean { // 커피원두

	// 필드 : 커피 원산지origin
	private String origin;

// 생성자
	public CoffeeBean(String origin) {
		super();
		this.origin = origin;
	}

	// 메소드
public void info() {
	System.out.println( "원산지: " + origin );
}
}



