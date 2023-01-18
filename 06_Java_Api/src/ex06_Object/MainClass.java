package ex06_Object;

public class MainClass {
	
	/* 
		java.lang.Object 클래스(기본저장소로 여기에 저장된 클래스는 import 안함)
 		1. 모든 클래스의 최상위 슈퍼 클래스(부모 extends)이다.
 		2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다.
 		3. 모든 것을 저장할 수 있는 만능 타입니다.
 	★★★	4. Object타입으로 저장된 객체는 Object 클래스의 메소드만 호출 할 수 있으므로 다시 원래 객체의 타입으로 캐스팅해서 사용해야 한다.
 		
	*/
	
	/*
	 	Object 클래스의 주요 메소드
	 	1. equals
	 		1) 동등 비교할 때 사용하는 메소드
	 		2) 동등 비교하는 객체들의 참조값을 비교함(객체의 값을 비교하지 못함)
	 	★★★	3) 객체의 값으로 동등 비교를 수행하기 위해서는 equals메소드를 "오버라이드" 해야함
	 	2. toSpring 
	 		1) 문자열로 변환활 때 사용하는 메소드
	 		2) 객체이름 + @ + 참조값 형식으로 변환함
	 	★★★	3) 원하는 형식으로 변경하려면 toSpring 메소드를 "오버라이드" 해야한다
	 */		
	
	
	public static void ex01() {
		
		Object person = new Person();	/*2*/
		if(person instanceof Person) { //downcastig Object저장되어있는데 person타입인지
			((Person) person).eat();	// Object 객체는 항상 캐스팅 해야한다
			((Person) person).sleep();
		}
	}
		
	public static void ex02() {
		//name이 같은면 같은 Person으로 처리하기로 한 시스템
		
		Person person1 = new Person("홍길동"); /*6*/
		Person person2 = new Person("홍길동"); /*6*/

		
		if(person1.equals(person2)) /*7*/ { //person1 person2가 같으면 같은 Person으로 처리
			System.out.println("같은 Person이다."); 	//Object클래스의 person1,person2 같은 문자열이 저장되어있어도
		} else {										//각각 인스턴스를  생성했기 때문에 서로 다른 인스턴스를 참조하고 있음
			System.out.println("다른 Person이다.");		// 따라서 equals 연산의 결과가 둘이 다르다고 판단
		}
		
	}
		
	
	public static void ex03() {
		
		Person person = new Person("홍길동");
		System.out.println(person.toString()); // 부모가 가진 equals 다른 값을 출력함 ,홍길동을 출력하기위해 새로만들어야함 > 메인클래스에서 오버라이드 해줌
		System.out.println(person); // toString 메소드는 호출을 생략함
	}						
		public static void main(String[] args) {
			ex03();
		
		

	}

}
