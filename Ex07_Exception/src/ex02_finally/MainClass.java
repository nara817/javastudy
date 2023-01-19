package ex02_finally;

import java.beans.Expression;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		// finally 블록
		// 항상 마지막에 실행되는 블록으로 생략 할 수 있다.
		
		
	/*	System.out.println("나이를 입력하세요 >>>");	
		Scanner sc = new Scanner(System.in); 
					↓ finally 선언 후 , 오류발생시 수정필요
		Scanner sc;
		System.out.println("나이를 입력하세요 >>>");
			sc = new Scanner(System.in); 
		*/
		
		Scanner sc;
		System.out.println("나이를 입력하세요 >>>");
			sc = new Scanner(System.in); // finally 선언 후 , 오류발생시 스코프 필요(스코프: 변수를 사용할 수 있는 범위)
			try {
			int age = sc.nextInt(); // > 요기서 예외발생하면 아래꺼 실행x catch로 ㄱㄱ
			System.out.println(age>=20? "주류 구매 가능" : "주류 구매 불가능");
		} catch(Exception e) {
			System.out.println("예외발생");
		} finally { // finally 블록은 지원(resource)을 반납할 때 주로 사용한다.
			sc.close(); // (자원의반납?)생략가능 > 예외 발생|| 예외 발생x >  실행
		}
	}
}
