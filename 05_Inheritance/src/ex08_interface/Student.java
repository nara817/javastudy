package ex08_interface;

/*
	용어 정리하기
	1. 클래스를 상속 받는다. extends 키워드를 사용한다.
	public class Person {}
	public class Student extends Person() {}
	
	2. 인터페이스를 구현한다. implements 키워드를 사용한다. (인터페이스 안에 추상 메소드를 만들겠다!)
	public interface Person {}
	public class Student implements Person() {}
	
*/
 
public class Student /*4*/implements Person{ /*4 Student뒤에 implements Person입력*/

/*5 > Source > Overide/ Implement Methods..
*/@Override
	public void study() {
		System.out.println("공부한다.");
		
	} 
	
	

}
