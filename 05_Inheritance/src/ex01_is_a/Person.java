package ex01_is_a;

/*
 	is a 관계
 	1. 상속 관계로 만들 수 있는 관계인다.
 	2. Student is d Person
 	3. 자식(class) is a 부모(class)
 */

/*
 	부모 클래스
 	1. 슈퍼 클래스라고 한다. (super)
 	2. 자식 클래스에게 기능을 제공하다.
 */


/*
┌───────┐
│ Person│
│───────│
│eat()  │
│sleep()│
└───────┘
      ▲
      │
      │
┌───────┐
│Student│
│───────│
│study()│
└───────┘            
*/

public class Person {
	
	public void eat() {
		System.out.println("먹는다.");
	}

	public void sleep() {
		System.out.println("잔다.");
	}
}
