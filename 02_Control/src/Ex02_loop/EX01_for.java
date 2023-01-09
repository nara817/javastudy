package Ex02_loop;

public class EX01_for {

	public static void ex01() {
		
		
		/* for문
		   1. 연속된 숫자를 생성하는 반복문(배열에서 주로사용)
		   2. 형식
		 for(초기문 ; 조건문 ; 증감문) {
		 	실행문
		 	순서 초기문1 조건문2 실행문3 증감문4(2,3,4번이 루프 반복됨)		 	
		 }
		 */
		
		
		// 1~10 (int a=0; a<=9; a++)
		// syso -------(a+1); 해당식도 답은 동일
		for(int a = 1; a <= 10; a++) { 		// 조건은 종료되는 숫자 ex10
			System.out.println(a);

		}
	}
		
	public static void ex02() {
		
			// 횟수(5번) 시작은 일반적으로 0부터 (*1부터보단 더 선호)
			// a = 0; a <= 4; a++ (동일한 식)
			// a = 1; a <= 5; a++ (동일한 식)
			// a = 0 ; a < 5; a++ (동일한 식)
			
			int count = 5;
			
			for(int a = 0; a < count; a++) { // count = 5 /가장 많이 사용되는
				System.out.println("Hello World");
			}
		
		}
	public static void ex03() { //연습
		
		// 10~1
		
		for(int a = 10; a >= 1; a--) {
			System.out.println(a);
		
		}
		
	}
			
	
		
	public static void ex04() { //연습
		
		//구구단 2단 출력 (1~9까지 만드는것)
		// 2 x 1 = 2(2*a)
		// 2 x 2 = 4
		// 2 x .....
		
		for(int a = 1; a <=9; a++)
			System.out.println("2 x " + a + " = " + 2 * a);
		//						ㄴ요기랑				ㄴ요기는 같은 값이 들어감
		//		int dan = 2; 이곳에 원하는 구구단을 넣으면 됨
		// 						(dan + " x " + a + " = " +(dan +a)); 위와 동일한 식 > *해당식으로 사용!!
	}
	
	public static void main(String[] args) {	
		ex01();
		

	}

}
