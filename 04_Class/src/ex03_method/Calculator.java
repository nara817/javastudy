package ex03_method;

public class Calculator {

	// 메소드 (함수)
	
	/*
	 ex) double addition(double a, double b) {
		 return a + b; 
	 
	  	메소드 형식
	  반환타입 메소드명(매개변수) {
	  ㄴ(double/결과 값의 타입) (addition) (double a, double b) {
	  	메소드 본문
	  	return 반환값
	  }

	  	1. 반환값 + 반환타입
	  		메소드 실행(메소드 호출)의 결과
	  			(a + b) -> double타입
	  	2. 메소드명
	  	개발자 마음대로 정함
	  	3. 매개변수
	  		메소드로 전달되는 값(인수, argument)을 저장하는 변수
	  		(return a + b = double 으로 돌려줌)
	 */
	
	/*
	 
	  메소드의 4가지 형식											메소드 호출
	  
	 1. 반환값 x,인수x(값을 받지도 않고, 되돌려주지도 않는거)
	  	void method() {												method();
	  		메소드 본문
	  	}
	 2. 반환값x, 인수o												int a = 0;
	 	void method(int arg저장할 매개변수) {						method(a);
	 		메소드 본문
	 	}
	 3. 반환값o, 인수x												int result;
	 	int method() {												result = method();
	 		메소드 본문		
	 		rerurn 반환값
	 	}
	 4. 반환값o, 인수o												int a = 0;
	 	int method(int arg) {										int result;
	 		메소드 본문												result = method(a);
	 		rerurn 반환값
	 	}
	 		 		 
	 
	 */
	
	//addition 메소드 정의+
	double addition(double a, double b) {
		
		return a + b;
	}
	
	// subtraction 메소드의 정의-
	double subtraction(double a, double b) {
		return a - b;		
	}
}
