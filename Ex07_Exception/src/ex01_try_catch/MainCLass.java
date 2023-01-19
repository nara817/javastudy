package ex01_try_catch;

import java.io.FileReader;
import java.util.Scanner;

public class MainCLass {

	public static void ex01() {

		try { // 코드구역 > 실행하다 문제가 생기면 catch로 ㄱㄱ

			String[] season = new String[4]; // 계절4개저장

			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn"; // 인덱스3 // 인덱스 4 -> null값을 str로
			season[3] = "winter";
			season[4] = "what??";

			// for(변수: 배열) >> 향상 for문
			for (String str : season) { // >> 에러가 나면 건너뛰고 catch로 ㄱㄱ
				System.out.println(str.substring(0, 3)); // 0번 인덱스 부터3 글자라는 뜻

			}

		} catch (Exception e) { // 모든 예외는Exception으로 처리가능 //예외 객체 이름은 e라고 적음

			System.out.println("ArrayIndexOutOfBoundsException 발생");

		} // >> catch block이라고 부름

	}

	public static void ex02() {

		try {

			String input = "1,2,3,,4,5"; // 숫자들이 ,로 구분되어 넘어옴
			String[] numbers = input.split(","); // split ,로 분리되어 출력
			int[] iNumbers = new int[numbers.length]; // 문자열을 숫자로

			for (int i = 0; i < numbers.length; i++) {
				iNumbers[i] = Integer.parseInt(numbers[i]);
				System.out.println(iNumbers[i]); // >> 문자열이 아닌 숫자가 됨
			}
		} catch (NumberFormatException e) { // UnChdcked Exception 이므로 RuntimeException 가능
			System.out.println("NumberFormatException 발생");
		}
	}

	public static void ex03() {

		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("덧셈식을 입력하시오(예: 1+2) >>>");
			String expr = sc.next();
			String[] item = expr.split("[+]"); // 이들 중 하나로 나눠달라(=5개중 1개)
			int number1 = Integer.parseInt(item[0]);
			int number2 = Integer.parseInt(item[1]);
			System.out.println(number1 + number2);

			sc.close();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("+를 포함해서 입력하세요.");
		} catch (NumberFormatException e) {
			System.out.println("정수 덧셈만 가능합니다.");
		} catch (Exception e) { // 마지막 catch 블록은 Exception으로 모든 예외를 처리한다
			System.out.println("예외가 발생했습니다.");
		}
	}

	public static void ex04() {

		try {
			FileReader fr = new FileReader("sample.txt"); // 문법이 틀린게 아닌데 오류남/ sample.txt파일이 없으면 오류날 수 있어 try catch해
			fr.close();
		} catch (Exception e) {
			System.out.println("예외가 발생하였다.");
		}

	}

	public static void main(String[] args) {
		ex04();

	}

}
