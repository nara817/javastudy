package ex06_Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {
	
	public static void printList(List<Integer> list) {
		
		int lastIndex = list.size() - 1;
		
		for(int i = 0; i < lastIndex; i++) {
			System.out.println(list.get(i) + "→");
		}
		System.out.println(list.get(lastIndex)); // 마지막 요소: 길이(사이즈) -1
		
	}

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(5,2,3,1,4); // 초기화
		
		printList(list);  // 5→2→3→1→4
		
		Collections.sort(list); // 오름차순 정렬
		
		printList(list); // 1→2→3→4→5
		
		int idx = Collections.binarySearch(list, 4); // 4가 존재하는 인덱스 찾기(이진 검색은 반드시 정렬이 되어 있어야 한다.)
		if(idx >=0) {
			System.out.println("찾았다.");
		} else {
			System.out.println("못찾았다.");
		}
		//System.out.println(idx);
	}

}
