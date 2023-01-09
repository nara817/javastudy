package ex01_branch;

public class Ex01_if_t {

	public static void main(String[] args) {
		
		// 봄3,4,5 여름6,7,8 가울9,10,11 겨울12,1,2
		int month = 12; //겨울12,1,2, /12로 나눔 나머지값 0,1,2
						//봄3,4,5 / 12로 나눔 나머지값 3,4,5 동일
	
		int mod = month % 12;
		
		if(mod <=2) {
			System.out.println("겨울");
		}
		else if(mod <=5) {
			System.out.println("봄");
		}
		else if(mod <=8) {
			System.out.println("여름");
		}
		else {
			System.out.println("가을");
		}
		
	
	}
}