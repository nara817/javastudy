package ex01_generic;

public class MainClass {

	public static void main(String[] args) {

		// Box box = new Box(); 이런형태에서 변형

		// Generic 처리할 때는 "항상" 참조 자료형을 전달해야한다.
//		Box<int> box1 = new Box<int>(); int → Integer
		Box<Integer> box1 = new Box<Integer>();
		box1.setItem(10);
		System.out.println(box1.getItem());

		// JDK 1.7 이후로 생성자에는 자료형을 생략할 수 있다.
		Box<String> box2 = new Box<>();
		box2.setItem("hello");
		System.out.println(box2.getItem());
	}

}
