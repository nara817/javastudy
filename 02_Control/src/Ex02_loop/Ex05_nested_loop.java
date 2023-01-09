package Ex02_loop;

public class Ex05_nested_loop {

	
	public static void ex01() {
		//for문의 중첩
		for(int day = 1; day <=5; day++) {
			for(int hour = 1; hour <=8; hour++) {
				System.out.println(day + "일차" + hour + "교시수업");
			}
			
		}
		
	}
	
	public static void ex02() {
		//while문의 중첩
		
		int day = 1 ; 
		while(day <=5) {
			
			int hour = 1;
			while(hour <=8) {
				System.out.println(day + "일차" + hour + "교시수업");
				hour++;
			}
			
			day++;
		}
		
		
	}
	
	
	public static void ex03() {
		
		// 전체 구구단 출력하기
		// 2 x 1 = 2
		// ...
		// 9x 9 = 81
	
		
		for(int dan = 2; dan <=9; dan++) {
			for(int n = 1; n <=9; n++) {
				System.out.println(dan + " x " + n + " = " +(dan *n));
			}
		}

	}
	
	public static void ex04() {
		// 전체 구구단 출력하기 (반복문이 역전됨n과 dan의 루프위치가 바뀜)
		// 2x1=2 3x1=3 4X1=4 ... 9x1=9
		// ...
		// 2x9= 18 3x9=27 4x9 36 ... 9x9=81
		
		for(int n = 1; n <=9; n++) {
			for(int dan = 2; dan <=9; dan++) {
				System.out.print(dan + "x" + n + "=" +(dan *n)+"\t");
			}
			System.out.println(); //9x9=81에서 부터 줄바꿈
		}
		
	}
	
	public static void main(String[] args) {
		ex04();
		
	}

}
