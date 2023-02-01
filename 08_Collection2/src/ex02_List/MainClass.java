package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void ex01() {

		// 배열 리스트(ArryList) 선언 및 생성
		/* import */ /* import */
		List<String> list = new ArrayList<String>(); // 크기,길이 지정x / 컴 저장 공간 만큼 맘대로 다 가능

		// 추가
		list.add("summer"); // 배열리스트 인덱스와 동일, 인덱스의 지정이 없으면 (spring이)항상 마지막에 추가됨
		list.add("autumn");
		list.add("frog"); // 계절이 아닌 갑분 개구리
		list.add("winter");
		list.add(0, "spring"); // 인덱스0에 spring 추가됨

		// 수정 autumn → fall
		list.set(2, "fall"); // 인덱스2의 요소를 fall로 수정함 인덱스 0 spring/인덱스1 summer/인덱스2 autumn ...

		// 삭제
		// list.remove("frog"); // 1. 삭제할 대상을 직접 전달
		list.remove(3); // 2. 삭제할 대상의 인덱스를 전달

		// 확인
		System.out.println(list); // 출력 값 [spring, summer, autumn, winter]

	}

	public static void ex02() {
		
		// ArrayList 초기화(특정 클래스의 도움을 받아야함)
		List<Integer> list = /* import */Arrays.asList(1,2,3,4,5);  // 1,2,3,4,5로 초기화 / Arrays 배열용 클래스
				
				// list 길이 구하기
				System.out.println("리스트 길이 : " + list.size());
				// list에 저장된 개별요소
				System.out.println("첫 번째 요소 : " + list.get(0));
				System.out.println("마지막 요소 : " + list.get(list.size()-1));
				
				// list 순회
				// 모든 요소의 합계 구하기
				int total = 0;
				for(int i = 0, length = list.size(); i < length; i++) {
					total += list.get(i);
				}
				System.out.println("모든 요소의 합 : " + total);
	}
	
	
	public static void ex03() {  // 연습
		
		List<User> userList = new ArrayList<User>();
		
		for(int i = 0; i < 3; i++) {
			User user = new User("user", "123456");
			userList.add(user);
		}
		
		// 아이디만 출력하기
		for(int i = 0, length = userList.size(); i < length; i++) {
			System.out.println(userList.get(i).getId());
		}
		
	}
	

	public static void main(String[] args) {
		ex03();

	}

}
