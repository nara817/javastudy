package ex09_access_modifier;

public class MailClass {

	public static void main(String[] args) {

		User user = new User();
	// ㄴClass ㄴ객체(변수이지만 class인경우 객체라고 부름)
		
		// user 객체에 id 전달하기
		user.setId("admin");
		
		// user 객체의 id 확인하기
		System.out.println(user.getId());
		
		// user 객체에 pw 전달하기
		user.setPw("123456");
		
		// user 객체의 pw 확인하기
		System.out.println(user.getPw());
	}

}
