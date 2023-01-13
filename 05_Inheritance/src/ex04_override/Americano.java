package ex04_override;

/*
	  메소드 오버라이드
	  1. method override
	  2. 부모 클래스의 메소드와 동일한 메소드 형식으로 자식 클래스가 새로운 메소드를 만드는 것이다.
	  3. 부모 클래스의 메소드를 사용할 수 없기 때문에, 새로운 메소드를 다시 만드는 것이다.
	  4. 자식 클래스가 메소드를 다시 만들 때는 애너테이션(Annotation)중 @Override를 추가한다.
	  메소드 오버로딩: 기존에 없던 새로운 메소드를 정의
	  메소드 오버라이드 : 상속 받은 메소드의 내용만 변경 
 */

public class Americano extends Espresso {
	
	@Override //(자바한테 알려주는거)다시만든이란 뜻
	public void taste() { // 다시 만든 taste
		
		System.out.println("아메리카노는 맛있다.");
	}

}
