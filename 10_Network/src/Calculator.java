
public class Calculator {
	
	private String name;
	
	public Calculator(String name) {
		this.name = name;
	}

	public void add(long n) {
		
		System.out.println(name + "계산기가 계산합니다.");
		//1부터 n사이의 모든 정수를 더하기
		
		long result = 0;
		for(int i = 1; i <= n ; i++) {
			result += i; // result += 1; result += 2; ... result += n;
		}
		System.out.println(n + "까지 더한 값은" + result + "입니다.");
	}

}
