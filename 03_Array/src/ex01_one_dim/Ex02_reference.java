package ex01_one_dim;

public class Ex02_reference {

	public static void ex01() {		
		
		int[] arr; // 변수 1개
		arr = new int[5]; // 변수 5개 = 총 변수6개
		
		System.out.println(arr); // 5개 배열 요소의 참조(주소,번지)값 닶은 @앞부분은 무시하기, @뒷부분이 참조값
	}
	
	public static void ex02() {
		
		int[] a = new int[5]; // 10번지
		int[] b; //14번지(int는 4bit)
		
		b = a; // b가 길이가 5인 배열이 되버림 / a도 배열 b도 배열임 / 해당 번지 값을 a로 가도되고 b로 가도됨
		
		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
		
		/*
        |-------|
      a | 0x123 |	  ─────┐
        |-------|          │
        |  ...  |          │
        |-------|          │
   a[0] |   0   | 0x123    │
        |-------|          │
   a[1] |   0   |          │
        |-------|          │
   a[2] |   0   |          │ b = a;
        |-------|          │
   a[3] |   0   |          │
        |-------|          │
   a[4] |   0   |          │
        |-------|          │
        |  ...  |          │
        |-------|          │
      b | 0x123 |	  ◀────┘
        |-------|
	*/
}
	
	
	public static void ex03() { // 심화
		
		// 생성된 배열의 크기를 늘이는 방법(늘리는게 불가능 내부데이터 옮겨서, 새로 만들어 옮김)
		
		// 기존 배열
		int[] a = new int[5];
		
		// 신규 배열
		int[] b = new int[10];
		
		// 기존 배열 요소 -> 신규 배열 요소
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		
		// 기본 배열의 참고값을 신규 배열의 참조값으로 수정
		a = b;
		
		// 기존 배열이 신규 배열로 변경되었으므로 확인
		for(int i=0; i < a.length; i++) {
			System.out.println(a[i]);
		}
			
	}
	
	
	
	
	public static void main(String[] args) {
		ex03();
		
	
		
		
	}

}
