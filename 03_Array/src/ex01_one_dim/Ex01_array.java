package ex01_one_dim;

public class Ex01_array {

	/*
	 배열이란?
	 1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
	 2. 배열의 구성요소
	  	1) 배열명: 모든 변수의 대표 이름
	  	2) 인덱스: 각 변수를 구분하기 위한 위치정보. 0부터 시작하는 정수값.

	 */
	/*
	  배열의 사용 방법
	  1. 배열의 선언
	  		1) int[] arr; > 권장, java에서 사용
	  		2) int arr[]; > c언어에서 사용
	  2. 배열의 생성
	  	arr = new int[5]; / 5개의 정수를 저장 할 수 있는 배열
	  	 	 */
	/*
	  배열의 요소
	  	1. 배열의 각 변수를 의미
	   	2. 배열명[인덱스(위치)]
	   	3. 배열이 생성되면 자동으로 초기화된다.
	   	  0(=false), 0.0,false(boolean타입), null(참조타입) 값으로 초기화된다.(값이 없음을 의미=0)
	  
	 */
	
	public static void ex01() {// x)
		
		
		//배열 선언
		int[] arr;
		
		//배열 생성
		arr = new int[5];
				
		//배열 요소
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
						//		ㄴ인덱스(i) i=0 i<5
	}
	
	public static void ex02() { //ex01x) ex02로 연습하기
		
		//for문 이용
		// 배열의 선언 + 생성(동시에 합쳐서)
		int[]arr = new int[5];
		
		// 배열의 요소 순회(하나씩 접근하기)
		for(int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void ex03() {
		
		// 배열의 길이
		int length = 5;
		
		// 배열 선언 + 생성
		int[] arr=new int[length];
		
		// 배열 순회
		for(int i=0; i < length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void ex04() { // 이거 주로 사용됨!! 이걸로 연습!!
		
		// 배열 선언 + 생성
		int[] arr = new int[5];
		
		// 배열 순회
		for(int i = 0; i < arr.length; i++)
			//                   ㄴ 이게 5란 뜻(배열의 길이)
			System.out.println(arr[i]);
		
	}
	
	public static void ex05() { // 연습
	
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장하기
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;
		
		// 합계(평균), 최대/최소값
		int total = 0; // Zero
		int max = 0;   //가장 작은 값
		int min = 100; // 가장 큰 값
		
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
			if(max < scores[i]) { //가장 큰값 보다 더 큰 값이 나왔는지 확인 , 현 최대값 0
				max = scores[i]; //최대값이 0에서 100으로 갱신 max 100
			}
			
		if(min > scores[i]) {
			min = scores[i];
		}
	}
		

		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + (double)total / scores.length + "점"); // 합계갯수
		System.out.println("최대 : " + max + "점");
		//                             ㄴ소수점 살림
		System.out.println("최소 : " + min + "점");
	}
		
	
	public static void ex06() { // 연습
	
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장하기
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;
		
		// 배열의 첫번째 요소를 초기화로 저장하고
		// 배열의 두번째 요소부터 순회한다
		
		// 합계(평균), 최대/최소값
		int total = scores[0]; 
		int max = scores[0];   
		int min = scores[0]; 
		
		for(int i = 1; i < scores.length; i++) {
			      //ㄴ 요거만 0에서 1로 변경
			total += scores[i]; // 첫번째 요소의 0을 두번 반복하는 걸 막을수 있음 첫번째 요소는 초기화,두번째부터 시작!
			if(max < scores[i]) { //가장 큰값 보다 더 큰 값이 나왔는지 확인 , 현 최대값 0
				max = scores[i]; //최대값이 0에서 100으로 갱신 max 100
			}
			
		if(min > scores[i]) {
			min = scores[i];
		}
	}
		

		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + (double)total / scores.length + "점"); // 합계갯수
		System.out.println("최대 : " + max + "점");
		//                             ㄴ소수점 살림
		System.out.println("최소 : " + min + "점");
	}
	
	
	
	public static void ex07() { // 연습
		
		// 배열 초기화
		int[] arr = {10, 20, 30};

		// 배열 순회
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	public static void ex08() { // 연습x)
		
		String[] weekName = {"토","일","월","화","수","목","금"};
		
		int day = 13;
		
		System.out.println(day + "일은" + weekName[day % weekName.length] + "요일이다.");
		
	
	}
	
	public static void ex09() { // 연습x)
		
	String[] season = {"겨울","봄","여름","가을"};
	
	int month = 1;
	
	System.out.println(month + "월은" + season[month % 12 / 3] + "이다.");
		
		
	}
		public static void main(String[] args) {
		ex09();

	}

}
