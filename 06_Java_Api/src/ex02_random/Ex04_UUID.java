package ex02_random;

import java.util.UUID;

public class Ex04_UUID {

	public static void main(String[] args) {
		
		/*
		 java.util.UUID
		 1. 전역 고유 식별자(Universal Unique IDentifier)
		 ㄴ동일한 랜덤값이 존재하지 않도록, 다른 값이 나오게
		 2. 32개의 16진수(0~f)와 4개의 하이픈 (-)로 구성된 식별자 값이다.		 
		 */

		
		UUID uuid = UUID.randomUUID(); // 객체 생성x
	//		 ㄴ 문자열로 바꿔 줘야함(toString사용)
		System.out.println(uuid);
		String str = uuid.toString(); // 문자열로 바꿈
	
		// 하이픈(-) 모두 없애기: 모든 하이픈을 빈문자열로 바꾸기
		String replacedstr = str.replace("_", ""); 
		System.out.println(replacedstr);
				
				
				
	}

}
