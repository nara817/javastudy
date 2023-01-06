package ex01_branch;

public class Ex01_if {


		
	public static void	ex01() {
		
		// if 문

		int score = 50;
		
		if(score >= 60)
			System.out.println("합격");
		
		if(score < 60)
			System.out.println("불합격");
		
	}
	public static void	ex02() {
		
		// if 문의 중괄호
		// 실행문이 1개인경우 생락 할 수 있다
		// 실행문이 2개 이상인 경우 반드시 필요하다

		int score = 50;
	
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		
		if(score < 60) {
				System.out.println("불합격");
			System.out.println("보충수업입니다.");
			
}
	}
	
	public static void main(String[] args) {
	ex02();
	
	

}

}