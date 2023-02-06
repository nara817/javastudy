package ex01_Thread;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator myClac = new Calculator("영희");//myClac 스레드 생성
		myClac.start(); // start 메소드는 run 메소드를 스스로 호출한다. main은 myClac 스레드의 동작 시작만 처리하고 동작 완료까지 기다리지 않는다.

		Calculator yourClac = new Calculator("상철");//yourClac 스레드 생성
		yourClac.start(); // start 메소드는 run 메소드를 스스로 호출한다. main은 yourClac 스레드의 동작 시작만 처리하고 동작 완료까지 기다리지 않는다.
		
		// myClac 스레드가 yourClac 스레드 보다 먼저 실행된다는 보장이 전혀 없다.
		// 스레드 실행 순서를 정하는건 개발자가 아니라 JVM이다.(자바스스로)
		
		System.out.println("main 메소드를 종료합니다.");
	}

}
