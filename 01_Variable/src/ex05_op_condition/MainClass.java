package ex05_op_condition;

public class MainClass {

	public static void ex01() {
		
		// 크기비교 연산
	
		int a = 3;
		int b = 4;
		
		boolean result1 = a>b;
		boolean result2 = a>=b; 
		boolean result3 = a<b; 
		boolean result4 = a<=b; 
		boolean result5 = a==b; //조심!
		boolean result6 = a!=b; //조심!
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		
	}
	
	
	public static void ex02() {
		
		// 논리연산
		// 1. 논리 AND : &&,모든 조건이 true이면 true 아니면 false
		// 2. 논리 OR : ||, 하나의 조건이라도 true이면 true 아니면 false
		// 3. 논리 NOT : !, 조건이 true이면 false 조건이 false 이면 true

		int a = 10;
		int b = 10;

		
		boolean result1 = (a==10) && (b==10); // 둘다 true
		boolean result2 = (a==10) && (b==20); // a true, b flalse
		
		System.out.println(result1);
		System.out.println(result2);
		
		
		boolean result3 = (a==10) || (b==10);
		boolean result4 = (a==10) || (b==20);

		
		System.out.println(result3);
		System.out.println(result4);
		
		boolean result5 = !(a==10);
		boolean result6 = !(a==20);
		
		System.out.println(result5);
		System.out.println(result6);
	}
	
	public static void ex03() {

		// Short Circuit Evaluation 논리연산
		// 1. 논리 AND의 경우 조건의 결과가 false인 경우가 발생하면 더 이상 동작하지 않는다. 
		// 최종결과가 false로 정해져있기 때문
		// 2. 논리 OR의 경우 조건의 결과가 true인 경우가 발생하면 더이상 종작하지 않는다.
		// 최종결과가 false로 정해져있기 때문
		
			
		int a = 10;
		int b = 10;
		
		boolean result1 = (a == 20) && (++b == 11);
		System.out.println(b); //b 11 동작x
		System.out.println(result1);
		
		boolean result2 = (a == 10) || (++b == 11);
		System.out.println(b);
		System.out.println(result2);
		
	}
	
	
	public static void ex04() { // 연습
	
		
		int score = 75;
		
		//boolean result = ??; //70점대면 true 아니면 false
		boolean result = (score >=70) && (score<80);
		System.out.println(result);
		
		boolean result2 = (score / 10) == 7;//몫을 구함 
		System.out.println(result2);
		
	}
	
	
		public static void ex05() { 
			
		// 조건 연산
		// (조건식) ?true일 때 처리 : false 일 때 처리
			
		int score = 80;
		
		String result = (score >= 60) ? "합격" : "불합격";// String 문자열 저장 변수 /3항 연산자
		System.out.println(result);
			
			
		}
			
		public static void ex06() {
			
			int n = 3;
			
			//String result = ??; // 짝수,홀수
			String result = (n % 2 == 0) ? "짝수" : "홀수"; 
			System.out.println(result);			
			
		}
			
		public static void ex07() {

			int n =3; // n = 0 (n != 0 && n % 3 == 0)? > 짝수 답
			
			//String result = ??; // 짝수, 홀수, 3의배수
			String result = (n % 3 == 0) ? "3의배수" : ( n % 2 ==0) ? "짝수" : "홀수";// 아닌경우 짝수, 홀수 
			System.out.println(result);
		
		}
		public static void main(String[] args) {

		ex07(); //실행해
	}

}
