package ex01_one_dim;

public class Ex03_advanced_for_practice {
	
	
	public static void ex01() {
		
		int[] scores = {50, 90, 60, 100, 80};
				
		int total = 0;
		int max = 0;
		int min = 100;
		
		// 	변수 : 배열변수
		for(int n : scores) {
			total += n;
			if(max < n) {
				max = n;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
