package Ex02_loop;

public class Ex03_break {

	
	
	/* 
	 break문
	 1. switch문 종료
	 2. 반목문(for,while) 종료 
	 */
	public static void ex01() {
		
		/* 
		 	무한루프
		 	1. 끝나지 않는 반복문
		 	2. 형식
		 		for(;;) >> 아무것도 안적고 ;;만 입력 / 무한루프라는 뜻
		 		while(true) >> 대부분 사용 for보단 while
		 */
		
		// 1 ~ 10
		
		int a = 1;		
		while(true) {
			
			if(a > 10) { //a가 11부턴 사용 안됨
				break;
				}
			System.out.println(a);
			a++;
		}
		
		
	}
	
	public static void ex02() {
		
		// 모금
		
		int goal = 100000; // 모금액 목표
		int money = 60; // 인당 모금액 지정
		int total = 0; // 실 모금액(누적금액)
		int n = 0; // 횟수
		
		while(true) {
			// goal total을 비교
			// 1회 모금액 60원 현재 60원
			// 2회 모금액 60원 현재 120원
			// ?회 모금액 60원 현재 100000원보다 더 큰숫자가 나올 수 있음
			
		if( total >= goal) {
				break;
				}	
		total += money;
		
		System.out.println(++n + "회 모금액" + money +"원 현재 모금액 " + total + "원");

		}
		
	}
	
	// for문을 이용해서 해보기!
	
	public static void main(String[] args) {
		ex02();

	}

}
