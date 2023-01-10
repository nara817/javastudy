package ex02_field;

public class MainClass {

	public static void main(String[] args) {
		
		// School 객체 생성
		School school = new School();
		
		school.name = "철산초";
		school.students = new Student[3]; //학생 3명 저장될 수 있는 배열이 만들어짐
		
		for(int i = 0; i < school.students.length; i++) {
			
			// Student 객체 생성
			school.students[i] = new Student(); // 학생이 3명이면 3번 호출되어야함/배열에 들어가는 각각 1개를 생성하는것
			
			school.students[i].name = "정숙";
			school.students[i].stuNo = "10101";
			
			// Score 객체 생성
			school.students[i].score = new Score(); // 객체 만들기
			
			school.students[i].score.kor = 100;
			school.students[i].score.eng = 90;
			school.students[i].score.math = 80;
			
			System.out.println("학번 : " + school.students[i].stuNo);
			System.out.println("이름 : " + school.students[i].name);
			System.out.println("국어 : " + school.students[i].score.kor);
			System.out.println("영어 : " + school.students[i].score.eng);
			System.out.println("수학 : " + school.students[i].score.math);
			
			
			/*
	 		Student student = new Student(); // 객체 만들기
	
	student.stuNo = "10101";
	student.name = "정숙";
	student.score = new Score();// 객체 만들기
	student.score.kor = 100;
	student.score.eng = 90;
	student.score.math = 80;
	
	
	System.out.println("학번 : " + student.stuNo);
	System.out.println("이름 : " + student.name);
	System.out.println("국어 : " + student.score.kor);
	System.out.println("영어 : " + student.score.eng);
	System.out.println("수학 : " + student.score.math);

	 */
			
			
			
			
		}

	}

}