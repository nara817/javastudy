package ex01_String;

public class MainClass {
	
	public static void literal() {
		
		// 문자열 리터럴(Literal)
		String str1 = "hello";
		String str2 = "hello";
		
		// 문자열 리터럴은 Java에 의해서 최적화되기 때문에
		// 동일한 리터럴를("hello") 2번이상 사용하면
		// 기존에 사용한 리터럴을 재사용한다. ("hello" 라는 리터럴이 2개 이상 만들어 지지 않는다.)
		
		
		/*
		 
        |-------|
   str1 | 0x123 |	 
   		|-------|        
   str2 | 0x123 |          
        |-------|         
   		| . . . |   	   
        |-------|          
        |"hello"| 0x123    
        |-------|          

	*/
		// 참조값이 같다는 의미이다. 저장된 문자열이 같다는 의미가 아니다.	
		System.out.println(str1 == str2);  
				
	}
	
	public static void stringObject() {
		
		// 문자열 객체(Object)
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		// 문자열 객체는 언제나 새로 생성된다.
		
		
		/*
		 
             |-------|
        str1 | 0x456 |	 
   		     |-------|        
        str2 | 0x456 |          
             |-------|         
   		     | . . . |   	   
             |-------|          
   		     | . . . |   	   
             |-------|          
             |"hello"| 0x123    
             |-------|          
   		     | . . . |   	                             
             |-------|          
   		     |"hello"| 0x456  	   
             |-------|          

	*/
		// 참조값이 다르다는 의미이다. 저장된 문자열이 다르다는 의미가 아니다.
		System.out.println(str1 == str2); 
		
	}
	
	public static void equals() {
		
		// equals(==) 메소드 >> 문자열 전용
		// 비교하는 문자열이 동일하면 true, 아니면 false 반환
		
		String str1 = "hello";
		String str2 = new String("hello");
		
		// 대소문자도 일치해야함
		if(str1.equals(str2)) {
			System.out.println("str1과 str2는 같은 문자열이다.");
		} else {
			System.out.println("str1과 str2는 다른 문자열이다.");
		}
		
		// 대소문자는 무시함
		if(str1.equalsIgnoreCase(str2)) {
			if(str1.equals(str2)) {
				System.out.println("str1과 str2는 같은 문자열이다.");
			} else {
				System.out.println("str1과 str2는 다른 문자열이다.");
			}
		}
	}
	
	public static void length() {
		
		// length 메소드
		// 문자열의 길이(=글자수)를 반환
		
		String str = "Hello\nWorld"; //줄바꾸기는 1글자(\n)
		int length = str.length();
		System.out.println("글자수 : " + length);
	}
	
	public static void charAt() {

		// charAt 메소드
		// 문자열의 특정 인덱스의 문자(Char)를 반환

		
		String name = "김나라";
		
		/* 아래와 동일한 식
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2)); */
		
		for(int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
	}
	public static void main(String[] args) {
		charAt();

	}

}
