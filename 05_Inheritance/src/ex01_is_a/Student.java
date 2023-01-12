package ex01_is_a;

/*
 	자식 클래스
 	1. 서브 클래스라고 한다. (sub)
 	2. 부모 클래스의 기능을 자기 것처럼 사용할 수 있다.
 */
public class Student extends Person { 
// Person(=부모)기능을 확장한(상속) Student(=자식)
	
	public void study() {
		System.out.println("공부한다.");
	}

}
