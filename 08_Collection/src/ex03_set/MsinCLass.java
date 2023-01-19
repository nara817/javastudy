package ex03_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.sun.jdi.connect.Connector.IntegerArgument;

	/*
	 	Set(집합)
		1. 저장된 요소들에 인덱스가 없다. → 저장 순서가 없다.
  ★★★★★	2. 중복 저장이 되지 않는다.
	 */

public class MsinCLass {
	
	public static void ex01() {
		
		
		// HashSet
		Set<String> set = new HashSet<String>(); //(인터페이스)
		
		// 추가 // ArrayList와 다르게 인덱스 지정x
		set.add("spring");
		set.add("spring");
		set.add("spring"); // 같은값이 여러개 있어도, 중복 저장x
		set.add("summer");
		set.add("atumn");
		set.add("winter");
		
		// 제거(값을 직접 전달해서 제거)
		set.remove("winter");
		
		
		// 확인
		System.out.println(set);
		
	}

	public static void ex02() { // 향상 for문
		
		// HashSet 객체의 초기화(List를 이용해서 초기화를 진행)
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		
		// 인덱스가 없기 때문에 향상 for문만 가능
		for(Integer n : set) {
			System.out.println(n);
		}
		
	} 
	
	
	public static void ex03() {
		
		 Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		 Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
		 
		 //교집합
		 set1.retainAll(set2); // set1에 교집합 결과가 저장된다.
		 
		 System.out.println(set1); // 교집합 처리시 set1 값이 변한다
		 System.out.println(set2);
		
		
	}
	
	public static void ex04() {
	Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
	Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
	
	//합집합
	set1.addAll(set2); // set1에 합집합 결과가 저장된다.
	
	System.out.println(set1); // set1에 합집합 결과가 저장된다.
	System.out.println(set2);
	
	
}
	
	public static void ex05() {
		

		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3,4,5,6,7));
		
		//차집합 (한쪽에서 빼기)
		set1.removeAll(set2); // set1에 차집합 결과가 저장된다.
		
		System.out.println(set1);  // set1에 차집합 결과가 저장된다.
		System.out.println(set2);
		
	}
	
	public static void ex06() { // 로또번호 6개 저장
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		// 1 ~ 45 : 6개 랜덤으로 발생
		while(lotto.size() < 6) { // 언제 끝날지 모르니 while문
			lotto.add( (int)(Math.random() * 45) + 1 ); // 1~45 : 6개 랜덤으로 발생 mathRandom
		}
		
		System.out.println(lotto);
		
	}
	public static void main(String[] args) {
		ex05();

	}

}
