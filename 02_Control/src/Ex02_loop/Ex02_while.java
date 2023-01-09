package Ex02_loop;

public class Ex02_while {
	
	/* 
	  while문
	  1.특정 조건을 만족하면 반복하는 반목문(어딘가에 들어있는 데이터를 가져오는 경우 주로 사용/파일(특정파일의 텍스트를 읽기위해), 특정 데이터베이스)
	  2. 형식
	  	while(조건문) {
	  		실행문 
	  	}
	 */
	public static void ex01() {
		
		// 1~10 하위 식은 for문으로 해야함! 아래는 그냥 예시
		int a = 1;
		while(a <= 10) {
			System.out.println(a);
			a++;
		}
		
	}

	public static void ex02() {
		
		int account = 85000; //통장
		int money = 550; // 돈 출금
		int n = 0; // 출금 횟수
		
		// 출금금액이 통장의 금액보단 많아야함, 적으면 안댐
		while(account >= money) { //n++으로 사용시 0을 쓰고 하나를 늘림 ++n 먼저1을 출력 후 증감을위해
			System.out.print(++n + "번째 출금 결과 :");
			account -= money;
			System.out.println("계좌 " + account + "원");
		}
	}
	
	public static void main(String[] args) {
		ex02();

	}

}
