package ex07_abstract;

	/*
	추상 메소드
	1. abstract method
	2. 본문이 없는 메소드이다.
	3. 중괄호({})를 없애고, 세미콜론(,)을 붙이고, abstract 키워드를 메소드 앞에 (public 뒤에)추가한다.
	*/
	
	/*
	추상 클래스
	1. abstract class
	2. 추상 메소드를 1개 이상 가진 클래스이다.
	3. abstract를 클래스 앞에 추가한다.
	4. 추상 클래스를 상속 받는 클래스는 "반드시" "모든" "추상 메소드"를 오버라이드 해야한다.
	5. 추상 클래스는 객체 생성이 불가능하다.
	(본문이 없는 메소드를 가지고 있기 때문에)
	*/

public /*1_2*/abstract class Person {

		
	/*1*/public void eat() {
	/*1*/System.out.println("먹는다.");
	}
	/*1*/public void sleep() {
	/*1*/System.out.println("잔다.");
	}	
	/*4*/public /*1_1*/abstract void study(); 
	//         			 ㄴ메소드 void study()
		// ㄴ본문{}이 없는 메소드(추상메소드)	
}
