package ex01_one_dim;

public class Ex01_array_practice {

	public static void ex01() {

		// 배열 선언+생성
		int[] arr = new in[5]; // 배열의 길이가 5

		// 배열의 요소 순회
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void ex02() {

		// 배열의 선언+생성
		int[] arr = new int[5];

		// 배열의 요소 순회
		for (int i = 0; i < arr.length; i++)

			System.out.println(arr[i]);

	}

	public static void ex03() {

		// 배열 선언+생성
		int[] arr = new int[6];

		// 배열 요소 순회
		for (int i = 0; i < arr.length; i++)

			System.out.println(arr[i]);

	}

	public static void ex04() {

		// 점수를 배열로 관리하기
		int[] scores = new int[5];

		// 각 점수를 배열에 저장하기
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;

		// 합계(평균), 최대/최소값
		int total = 0;
		int max = 0;
		int min = 0;

		for (int i = 0; i < scores.length; i++) {
			total += scores[i];
			if (max < scores[i]) {
				max = scores[i];
			}

			if (min > scores[i]) {
				min = scores[i];
			}
		}
		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + (double)total / scores.length + "점"); // 합계갯수
		System.out.println("최대 : " + max + "점");
		//                             ㄴ소수점 살림
		System.out.println("최소 : " + min + "점");
	}

	public static void main(String[] args) {
		ex04();
	}

}
