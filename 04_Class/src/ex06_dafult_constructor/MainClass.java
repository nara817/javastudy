package ex06_dafult_constructor;

public class MainClass {
	
	/* ★★★★★★★★
	 	생성자(constructor)
	 	1. 객체를 생성할 때 사용되는 메소드
	 	2. new 키워드 이후에 호출된다.
	 	3. 특징
	 		1) 생성자의 이름은(메소드명) 클래스와 이름과 같다.
	 		2) 반환타입이 존재하지 않는다.(void조차 적지 않는다!!!!) (반환타입이 없을땐 void)
	 		3) 매개변수는 일반 메소드와 동일하게 사용한다.
	 		
	 */
	/*
	 	디폴트 생성자(Default constructor)
	 	1.개발자가 생성자를 만들지 않으면 자동으로 사용되는 생성자이다.
	 	2. 매개변수가 없고, 본문이 비어있는 형태
	 */
	

	public static void main(String[] args) {
		
		// User 객체 생성(생성자가 자동으로 호출되는 지점)
		User user = new User();
		//               ㄴclass와 이름 동일
		
		// info 메소드 호출
		user.info();
		

	}

}
