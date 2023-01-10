package ex02_two_dim;

public class Ex02_advanced_for {
	
	public static void ex01() {
		
		int[][] srcores = {
				{70, 80, 90},  // 1번째 학생 점수
				{80, 90, 100}, // 2번째 학생 점수
				{50, 60, 70}   // 3번째 학생 점수
		};
			
		for(int[] arr : srcores) { // 1차원 배열: 2차원 배열의 이름
			for(int score: arr) { // 1차원 배열의 값: 1차원 배열 / arr은 1,2,3번째 학생 점수각각 {1,2,3} 뭉탱이
				System.out.print(score +"\t");
			}
			System.out.println();
		}
	}
	
	public static void ex02() {
		
		String[][] timeTable = {
				{"국어", "윤리", "수학", "체육"},
				{"미술", "수학", "영어"},
				{"사회", "한자", "수학", "국어", "영어"},
				{"음악", "국어", "윤리"},
				{"수학", "영어", "체육", "과학"}
		};

	
	for(String[] day : timeTable) {
		for(String subject : day) {
			System.out.print(subject + "\t");
		}
		System.out.println();
	}
	
	}

	public static void main(String[] args) {
		ex02();

	}

}
