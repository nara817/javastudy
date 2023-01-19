package ex03_throw;

import java.util.Scanner;

public class MainClass {

	public static void ex01() {

		try {

			Integer.parseInt("하핳");
			int a = 4 / 0; // 계산할 수 없음(ArithmeticException) 숫자연산 잘못 되었음, 0으로 나누기xx
			System.out.println(a);

		} catch (Exception e) {

			System.out.println(e.getClass().getName());// 예외 클래스 이름 확인
			System.out.println(e.getMessage());// 예외 메시지 확인(왜 발생했는지)

		}

	}

	public static void ex02() {

		try {

			Integer.parseInt("호홓");

		} catch (Exception e) { // catch{} 비워두면 절대 안댐!!

			e.printStackTrace(); // 예외 발생 내역을 추적(완제품x, 개발중에는 이것만 사용함)
		}
	}

	public static void ex03() { // 자바가 아닌 사람이 판단해야 하는 예외(RuntimeException 주로 사용됨)
		
		
		/*
		  throw
		  1. 예외 객체를 생성해서 직접 던질 수 있다.
		  2. 개발자가 직접 예외를 처리할 때 사용한다. 
		  */
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.println("나이를 입력하세요 >>>"); // 5000 (5000살...;;)
			int age = sc.nextInt();
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 불가능합니다.");//String타입의 RuntimeException /  return자리에
			}
			System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
		} catch(Exception e) {
			System.out.println(e.getMessage());//e.printStackTrace(); 개발 중 코드로, 개발 끝나고 사용xx
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		ex03();

	}

}
