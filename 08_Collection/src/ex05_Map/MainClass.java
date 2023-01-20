package ex05_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {

	public static void ex01() {

		/*
		 * HashMap 1. 하나의 데이터가 2개의 요소로 구성된다. 2. 용어 정리 1) Entry : 하나의 데이터 (Map에 저장되는
		 * Entry가 2개로 구성된다) 2) Key : Entry의 구성요소, "식별자 역할"을 수행(배열의 인덱스와 같은 역할) 3) Value
		 * : Entry의 구성요소, 실제 데이터(배열에 저장된 데이터와 같은 역할) 3. 주로 Key는 String을 사용한다.("변수 이름")
		 * 4. 주로 Value는 Object를 사용한다.(변수에 저장된 값) 5. "Key는 중복이 불가능"하고, Value는 중복이
		 * 가능하다.(동일한 변수이름이 둘일 순 없으니까!)
		 * 
		 */

		// Person 정보를 HashMap으로 만들기(class Person 안만들고..)
		/* ★★ */ Map<String, Object> person = new HashMap<>(); // import > Map, HashMap

		// 추가(Key+Value)
		// put메소드(Key변수,Value변수)
		person.put("name", "홍길동");
		person.put("age", 30);

		// 수정
		// (Key+Value)
		person.put("age", 40); // 기존 Key와 동일한 Key값의 Value가 수정된다.

		// 삭제
		// remove(Key) 해당 Key값의 Entry를 지워줌
		person.remove("age");
//	int age = (int)person.remove("age"); 삭제된 Value가 반환된다. Value는 Objet타입(age)이므로 캐스팅 해야 사용할 수 있다.

		// 확인
		// put(Key,Value)
		System.out.println(person); // 값 {name=홍길동, age=30}
		// Entry1 name=홍길동, Entry2 age=30

	}

	public static void ex02() {

		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("atumn", "가을");
		dictionary.put("winter", "겨울");

		// Value 가져오기
		// get(Key)를 이용해서
		String season = dictionary.get("winter");
		System.out.println(season);
	}

	public static void ex03() {

		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("atumn", "가을");
		dictionary.put("winter", "겨울");

		// Map 순회하기
		// 1. Key만 모두 가져온뒤, 해당 key값을 가진 Value를 가져오기
		Set<String> keySet = dictionary.keySet(); // set에는 순서가 없으니, 인덱스가 없어 일반 for문 사용불가 향상for문 사용
		for (String key : keySet) {
			// System.out.println(key); 2. Key만 모두 가져오기(중복 없는 자료구조 set사용)
			// System.out.println(key);
			System.out.println(key + dictionary.get(key));
		}
		// 2. Entry를 모두 가져온뒤, Key와 Value로 분리하기 (엔트리:(맵=객체))
		/* ★★ */ for (Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	public static void ex04() {
		
		// 제목(title), 저자(author), 가격(price)으로 구성되는 책(book) : HashMap으로 만들기
		
		// 책(book) 3권이 저장된 ArrayList
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "어린왕자");
		book1.put("author","생텍쥐베리");
		book1.put("price", "10000");
		
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "어린왕자투");
		book2.put("author","생텍쥐베리투");
		book2.put("price", "20000");
		
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "어린왕자쓰리");
		book3.put("author","생텍쥐베리쓰리");
		book3.put("price", "3000");
	
		List<Map<String, Object>> books = new ArrayList<Map<String,Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
	
	// for문 순회
	
	// List의 순회
	for(int i = 0, length = books.size(); i < length; i++) {
		// Map의 순회(List에 저장된 요소가 Map이다.)
		Map<String, Object> book = books.get(i);
		System.out.println((i + 1) + "번째 책의 정보");
		for(Entry<String, Object> entry : book.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
}
	public static void main(String[] args) {
		ex03();

	}

}
