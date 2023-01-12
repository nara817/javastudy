package ex06_dafult_constructor;

public class User {

	// 생성자를 만들지 않으면 "디폴트 생성자"가 사용된다.
	
	/* 예)
	  User() {
	  
	  }
	 
	 >> 디폴트 생성자가 생긴 모습
	 
	 */
	
	
	// 필드
	String id;
	String pw;
	
	// 메소드
	void info() {
		System.out.println("아이디:" + id);
		System.out.println("비밀번호:" + pw);
	}
	
	
	
	
	
	
}
