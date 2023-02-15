package ex03_singleton;

public class User {
	
	// static 필드 (미리 User를 만들어 둔다.)
	// ㄴ 객체마다 생성되지 않고 클래스별로 1개씩만 생성됨
	private static User user = new User(); // User 1개 만듬
	
	// private 생성자(외부에서는 생성자를 호출할 수 없다.)
	private User() {
		
	}
	
	// static 메소드 (static 필드를 사용하기 위해서)
	// user필드를 외부에서 사용할 수 있도록 반환하는 Getter
	public static User getInstance() {
		return user;
	}
	
}
