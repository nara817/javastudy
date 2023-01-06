package ex04_op_number;

public class MainClass {

	// ex01 메소드 정의(기능을 만든다/만들기만함 호출x)
	public static void ex01() {

		int a = 5;
		int b = 2;
		
		int add = a + b;
		int sub = a - b;
		int mul = a * b;
		int div = a / b; //몫
		int mod = a % b; //몫이 아닌 나머지값(퍼센트)
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(mod);
	}
	
	// ex02 메소드 정의
	public static void ex02() {
		
		int a = 5;
		int b = 2;
		
		double div = (double)a / b; //a=5.0으로 바꿈 5.0 / 2.0 바꾸는 캐스팅 이후 프로모션이 진행됨
		
		System.out.println(div);  //2.5
	}
	
	// ex03 메소드 정의
	public static void ex03() {
		
		int second = 90;
		
		int min = second/60; //1
		int sec = second%60; //30
		
		
		System.out.println(min);
		System.out.println(sec);
		
	}
	
	// ex04 메소드 정의
	public static void ex04() {
		
		// 1 증가 : ++
		// 1 감소 : --
		
		// 전위 연산(pre operator)
		// ++a 또는 --a(먼저 더하다, 빼다)
		// 변수 a의 값을 1 증가(감소) 시킨 뒤에 사용

		
		int a = 10;
		System.out.println(++a);
	
		// 후위 연산(post operator)
		// b++ 또는 b--
		//변수b의 값을 사용 한 뒤에 1증가(감소)시키시오

		int b = 10;
		
		System.out.println(b++);
//		System.out.println(b);

	}
	
	// ex05 메소드 정의
	public static void ex05() {
	
		// 대입 연산
		// 등호(=)의 오른쪽 값을 왼쪽으로 보내는 연산
		
		// a = b 서로 다른 식	 b = a
	
		int a;
		
		a = 10; // 10 = a; (불가)
		System.out.println(a);
	}
	
	// ex06 메소드 정의
	public static void ex06() {

	int x = 10;
	int y = 20;
	
	//교환
	
	
	int temp; // 백업
	temp = x;
	x = y;
	y = temp;
	
	System.out.println(x); //20
	System.out.println(y); //10
	
	}

	
	// ex07 메소드 정의
	public static void ex07() {
	
		int account = 10000; // 5000원 추가입금
		
		account += 5000; // 복합대입연산 (동일한 식)account = account + 5000;
		System.out.println(account);

		//account ++ //1원 추가입금

		account -= 5000; // 복합대입연산 (동일한 식)account = account - 5000;
		System.out.println(account);
			
	}
	
	// ex08 메소드 정의
	public static void ex08() {
		
		long account = 123456;
		
		// 5% 이자 받으면 얼마인가
		//account = account(롱타입) + account *0.05(더블타입); = 더블 / 실수
		double result; //소수점을 살려야 할경우 double사용
		result = account * 1.05; //(동일한 식)account = account + account * 0.05;
		
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {
		
		ex08(); //ex08 메소드 호출(만든걸 사용하겠다)
		
	
	}

}
