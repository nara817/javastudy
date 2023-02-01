package ex01_generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MainClass2 { // 보강수업

	public static void ex01() {
		// 아래의 두문장이 동일한 식인가
	
		ArrayList<String> list = new ArrayList<String>(); 		
		
		List<String> list2 = new ArrayList<String>(); // 인터페이스로 호출시, 내용이 적음(상속관계 연관지어 생각하기)
		/*List<String> list2 = new List >> 불가(추상메소드)*/
		
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		
		
		System.out.println(list.get(0)); // 저장한 순서대로 하나씩 꺼내보기!
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3)); 
		
		
		// 일반for문
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("------");
		
		// 향상for문
		for(String season : list) {
			System.out.println(season);
		}
		
		
	}
	public static void ex02() { // Map
		
		
		TreeMap<Integer, String> treemap = new TreeMap<Integer, String>(); // 순서대로 저장원할경우
		treemap.put(90, "제시카");
		treemap.put(100, "제시");
		treemap.put(70, "사만다");
		System.out.println(treemap); // 순서대로 출력됨
		
		Map<Integer, String> map = new HashMap<Integer, String>(); // new Map(인터페이스는 못만듬!)
		map.put(1, "a");
		map.put(10, "b");
		map.put(101, "c");
		map.put(11, "d");
		System.out.println(map); // 순서 상관없이 막 출력됨		
	}
	public static void ex03() {
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("age", age + ""); // 빈문자열""
		System.out.println(map);		
	}
	
	public static void ex04() {
		
		Map<String, Object> map = new HashMap<String, Object>();	
		map.put("Service-Key", "kdjfhkaf");
		map.put("Content-Type", "application/xml");
		
		System.out.println(map.get("Service-Key"));
		System.out.println(map.get("Content-Type"));
		
		ex05(map);
		
	}
	
	
	public static void ex05(Map<String, Object> map) {
		
		for( Entry<String, Object> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
	}
	public static void main(String[] args) {
		ex04();

	}

}
