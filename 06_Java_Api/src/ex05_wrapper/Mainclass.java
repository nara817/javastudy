package ex05_wrapper;

public class Mainclass {
	
	/* 
		wrapper class
		1. 기본자료형(Primitive Type)을 참조 자료형(Reference Type)으로 만들어 놓은 클래스이다.
		2. 주요 종류
	정수	byte	→	Byte
			int		→	Integer
			long	→	Long
	실수	double	→	Double
			boolean	→	Boolean
			char	→	Character			
		3. 용어 정리
		1) Auto Boxing : 기본 자료형을 → 참조 자료형 int a = 10; → 「Integer a = 10;」
		1) Auto UnBoxing : 참조 자료형을 → 기본 자료형 Integer a = 10; →  「int b = a;」 
		4. "반드시" 참조 자료형"을 요구하는 제네릭(generic)에서 주로 사용한다.
		예) int를 사용하려해도 사용 할 수 없음(경고 빨간줄), Integer를 사용해야함
	*/

	public static void main(String[] args) {
		
		Integer a = 10; // Auto UnBoxing
		Integer b = 10; // Auto UnBoxing
		
		int sum = a + b; // Auto UnBoxing
		System.out.println(sum);

	}

}
