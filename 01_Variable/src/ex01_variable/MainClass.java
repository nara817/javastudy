package ex01_variable;

public class MainClass {

//	single comment(주석 설명)
/*
 multilple comment(여러 줄 주석)
*/
	/*
	키워드 이름 규칙
	1. 프로젝트 : 대소문자 상관없음 마음대로
	2. 패키지 : 모두 소문자로 작성. 실무에서는 회사 도메인과 앱 이름으로 작성(ex com.samsung.galaxy)
	3. 클래스 : 첫 글자만 대문자로 작성 나머지는 소문자. Upper Camel Case 방식(HelloWorld)
	4. 메소드 : 첫 글자만 대문자로 작성 나머지는 소문자. Lower Camel Case 방식(helloWorld)
	5. 변수 : 첫 글자만 대문자로 작성 나머지는 소문자. Lower Camel Case 방식(helloWorld)
	6. 상수 : 모두 대문자로 작성(변하지않는값).Snake Case 방식(HELLO_WORLD)
	*/
	
	/*
	main 메소드
	1. Java가 싱행될 때 main 메소드가 실생된다.
	2. 열린 main 메소드가 없으면 최근에 실행에 성공한 main 메소드를 실행한다.
	 */
	
	
	
	public static void main(String[] args) {

		// 코드는 들여쓰기가 잘 되어야 한다.(탭키 사용)
		// 변수 선언하기(어떤 데이터를 저장할 것인가 ? 어떤 이름을 사용알 것인가?)
		// 타입의 구분
		//1. primitive type :기본타입(소문마로 되어 있음), 값을 저장하는 타입
		//2. reference type :참조타입(첫 글자가 대문자로 되어 있음), 값이 저장된 참조값을 저장하는 타입
		// >>모든클래스는 참조 타입
		
//		//논리타입
		boolean isGood = true;
		boolean isAlive = false;
		System.out.println(isGood);
		System.out.println(isAlive);
		System.out.println(isAlive);
		
		//	문자타입(Chaeacter) :1글자
		char ch1 = 'A';
		char ch2 = '홍'; //한글도 저장가능
		char ch3= '\n'; //라인피드 - 줄바꿈
		char ch4 = '\t'; //탭
		char ch5 = '\''; //작은 따옴표를 문자로 쓰겠다는 뜻
		char ch6 = '\"'; //큰 따옴표를 문자로 쓰겠다는 뜻
		System.out.println(ch1);
		System.out.println(ch1);
		System.out.println(ch1);
		System.out.println(ch1);
		
		// 정수타입
		int age = 46;
		long money = 10000000000L; //긴숫자의 경우 L붙임(약 이십일억얼마?)
		System.out.println(money);
		System.out.println(age);
		
		// 정수 구분의 기준
		System.out.println(Integer.MAX_VALUE);
		
		// 실수 타입
		//float 사용x
		double leftEye = 0.7;//double은 float의 2배값
		double rightEye = 0.9;//double은 float의 2배값
		System.out.println(leftEye);
		System.out.println(rightEye);
		
		// 문자열 타입(여러 글자를 의미, 글자 수 제한이 없음,유일한 참조타입)
		String name = "김나라"; //java에서 기본 타입과 같은 사용법을 제공
		System.out.println(name);
		String country = new String("Korea"); //대부분의 참조타입
		System.out.println(country);
		
		// 상수 선언하기(final 키워드가 필요)
		final double PI = 3.141592;
		System.out.println(PI);
		
	}

}
