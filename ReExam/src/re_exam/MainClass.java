package re_exam;

import java.util.Arrays;

public class MainClass {
	
	// 문제1. 절대값 구하기
	public static void ex01() {
	
		
		int number = 5;
		/*
		int absNumber;
		
		if(number >=0) {
			absNumber = number;
		} else {
			absNumber = -number; //(int number = -5;)인경우	
		}					
		System.out.println(absNumber);
	}
	*/
	
	int absNumber = (number >=0 ) ? number : -number; // 상위 식과 동일
	System.out.println(absNumber);
}
	
	// 문제2. 나이에 따른 구분하기
	// 0~7 미취학 아동
	// 8~13 초등학생
	// 14~16 중학생
	// 17~19 고등학생
	// 20~100 성인
	// 나머지 잘못된 나이
	public static void ex02() {
		
		String strAge = "30"; // 문자열을 숫자로 바꿈(Integer.parseInt)
		int age =  Integer.parseInt(strAge);
		if(age < 0 || age > 100) {
			System.out.println("잘못된 나이");
		} else if(age <= 7) {
			System.out.println("미취학 아동");
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else
			System.out.println("성인");
	} 
	
	// 문제3. 삼각형 넓이 구하기 (배열)
	public static void ex03() {
		
		int width = 3; // 너비
		int hight = 3; // 높이
	//	double area = width * hight / 2; // int끼리 계산하면 4나옴 틀린답임
	//	double area = width * hight / 2.0; // 소수점 결과가 필요하기에, 연산에 소수점 하나이상 섞어주기 		
		double area = width * hight / 0.5; // = 동일한 식
		System.out.println("삼각형 넓이 : " + area);
	}
	
	// 문제4. 월 -> 계절과 마지막 일 출력하기
	//예	  1월 -> 겨울	31	
	//		  2월 -> 겨울 	28
	//		  3월 -> 봄 	31
	//		  4월 -> 봄 	30
	public static void ex04() {
		
	/* month % 12 나머지 / 3
		ㄴ 겨울 0,1,2 / 3 >> 
		겨울0 
		봄1 
		여름2 
		가을3	*/
		
		int month = 1;
		int []lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		 //  				12월 
		if(month < 0 || month > 12) { // 1~12월이 아닌 다른 값이 month인경우
			System.out.println(month + "월은 잘못된 입력입니다.");
			return;
		}
		String[] season = {"겨울", "봄", "여름", "가을"};
		System.out.println(month + "월은 " + season[month % 12 / 3]+ "입니다.");
		System.out.println(month + "월은 " + lastDay[month]+ "일까지 있습니다.");
	//	System.out.println(month + "월은 " + lastDay[month-1]+ "일까지 있습니다.");
	// 	ㄴ int []lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};	>> 0이 인덱스에 없는 경우 
		
	}
	
	//문제5. 10과 가까운 수 찾기
	public static void ex05() {
		int a = 8; // 차이 2
		int b = 11; // 차이 1
		int diff1 = (a>10) ? a-10 : 10-a; //(10 - 8 = 10 - a : 2) // 큰수에서 작은수를 빼는거
		int diff2 = (b>10) ? b-10 : 10-b; //(11 - 10 = b - 11 : 1)
		System.out.println("10과 가까운 수 는" +  (diff1 < diff2 ? a : b) + "입니다.");
	}
	
	//문제6. money 분리하기
		public static void ex06() {		
			
			int money = 87654;
			// 		  / 50000원 1몫 37654나머지
			// 37654 / 10000원 3 7654
			// 7654 / 5000원 1 
			int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1}; // 원단위 배열로
			int[] count = new int[unit.length];// 갯수 구할 변수가 많이 필요함 개수가10 변수가 10 > 결과 나올 배열 필요
			
			for(int i = 0 ; i < unit.length; i++) {
				count[i] = money / unit[i];
				money %= unit[i];	
				System.out.println(unit[i] + "원권 : " + count[i] + "개");
			}
			System.out.println(Arrays.toString(unit)); // 배열 확인해볼 수 있음
			System.out.println(Arrays.toString(count)); // 배열 확인해볼 수 있음
			
		}
			
			/*count[0] = money / unit[0];
			money = money % unit[0];
			
			count[1] = money / unit[1];
			money = money % unit[1];
			 
			. . . */
		
		//문제7. 2차원 배열에 구구단 결과 저장하기
		public static void ex07() {
			
		int[][] arr = new int [8][9]; // 8줄 9칸
		
		for(int i = 0;  i < arr.length; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				arr[i][j] = (i + 2) * (j + 1);
				
			}
			
		//arr[0][0] = 2*1;
		//arr[0][1] = 2*2;
			
		//arr[1][0] = 3*1;
		//arr[1][1] = 3*2;
			
		//arr[2][0] = 4*1;
		//arr[2][1] = 4*2;	
				/*
		for(int i = 0;  i < arr.length; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
		arr[i][j] = (i + 2) * (j + 1);			
		}
		System.out.println(String.format("3%d", arr[i][j])); // 숫자 1가 자리씩 출력 하는 방법	
		System.out.println(String.format(Arrays. tostring(arr[i][j])); // 다른 출력법
		}
		*/
			
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));			
		}
	}
		}
			
	public static void main(String[] args) {
		ex07();

	}

}
