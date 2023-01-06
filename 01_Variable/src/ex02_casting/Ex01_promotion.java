package ex02_casting;

public class Ex01_promotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자동 변환
		// 1. 작은 크기 > 큰 크키
		// 2. 정수 > 실수
		
		long money =10000; //ex money > 8바이트 10000 > 4바이트  (작은 > 큰)
		//4바이트를 사용한 10000이 8바이트 money로 프로모션됨
		//long money =10000L; // L붙임 8 > 8 변화없음
		System.out.println(money);
		
		double score = 90; //정수 90이 실수 90.0으로 프로모션된다
		System.out.println(score);
		

	}

}
