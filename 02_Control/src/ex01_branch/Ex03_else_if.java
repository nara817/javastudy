package ex01_branch;

public class Ex03_else_if {
	
	public static void ex01() {
	
		// 80 이상 : 상
		// 60 이상 : 중
		// 나머지   : 하
		
		int score = 50;
		
		if(score >= 80) {
			System.out.println("상");
		}
		else if(score >=60) {
			System.out.println("중");
		}
		else {
				System.out.println("하");
		}
		
	}
	
	
	public static void ex02() {
		
		// 수, 우, 미, 양, 가, 잘못된 점수(100점,0점이하) /잘못된 점수 먼져!!
		int score = 65;
	
		if(score < 0|| score >100) {
			System.out.println("잘못된 점수");
		}
		else if(score >=90) {
			System.out.println("수");
		}
		else if(score >=80) {
			System.out.println("우");
		}
		else if(score >=70) {
			System.out.println("미");
		}
		else if(score >=60) {
			System.out.println("양");
		}
		else {
			System.out.println("가");
		}
		
	}

	public static void ex03() { // 연습
		// 봄3,4,5 여름6,7,8 가울9,10,11 겨울12,1,2
		int month = 312; //겨울12,1,2, /12로 나눔 나머지값 0,1,2
						//봄3,4,5 / 12로 나눔 나머지값 3,4,5 동일
		
		int mod = month % 12;
		
		if(mod <=2) {
			System.out.println("겨울");
		}
		else if(mod <=5) {
		System.out.println("봄");
		}
		else if(mod <=8) {
			System.out.println("여름");
		}	
			else {
				System.out.println("가을");
				
	}
		}
	
	
	
	public static void ex04() { // 연습
		
		int day = 6; // 금 7 / 나머지 값이 6
		int nDay = 10; // 10일후
		
		day = day + nDay; // 16 = 6+10 day = day + nday
		
	
		String weekName; // 월요일
		
		int mod = day % 7;
		
		if(mod ==0) {
			weekName ="토";
		}
		else if(mod ==1) {
			weekName ="일";
		}
		else if(mod ==2) {
			weekName ="월";
		}
		else if(mod ==3) {
			weekName ="화";
		}
		else if(mod ==4) {
			weekName ="수";
		}
		else if(mod ==5) {
			weekName ="목";
		}
		else {
			weekName ="금";
		}
		
		System.out.println(nDay + " 일 후는" + weekName +"요일이다");
		
	}
	
	public static void main(String[] args) {
		ex04();

	}

}
