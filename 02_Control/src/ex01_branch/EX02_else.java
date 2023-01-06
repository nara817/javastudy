package ex01_branch;

public class EX02_else {

		
	public static void ex01() {
			
		int score = 50;
			
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
			
		else(score < 60) {
				System.out.println("불합격");
			System.out.println("보충수업입니다.");
				
		}
	}
	public static void main(String[] args) {
		ex01();
	}
