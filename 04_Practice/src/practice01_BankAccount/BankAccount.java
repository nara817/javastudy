package practice01_BankAccount;

public class BankAccount {
	
	// 필드
	private String accNo;
	private long balance;
	
	// 생성자
	public BankAccount(String accNo, long balance) { // 계좌를 생성한다
		this.accNo = accNo;
		this.balance = balance;
	
	}
	
	// 메소드(입금, 출금, 이체, 조회)
	
	// 입금(마이너스 입금 불가 처리)
	public void deposit(long money) {// 반환타입x (입금하고 받아오는거 없음)
		if(money <= 0) {
			return; // 메소드 종료, 오직 반환이 void인 경우에만 사용 가능
	}
	balance += money;
}
	
	// 출금(마이너스출금 + 잔액보다 큰 출금 불가처리)
	public long withdrawal(long money) {
		if(money <= 0 || money < balance) { // 통장에 5만원 있는데 더 큰 금액을 출금하려함
			return 0; // ㄴㄴ 안댐
		}
		balance -= money;
		return money;
	}
	
	// 이체(누구에게, 계좌번호, 금액)
	public void transfer(BankAccount other, long money) { // 반환타입x (이체하고 받아오는거 없음)
		// 1. 내 통장에서 money 출금 : withdrawal(money) = 현 객체 내통장 동일한 내용this.withdrawal(money)
		//									ㅣ
		// 2. 상대 통장에 '실제로 내 통장에서 출금된 금액 입금' : other.deposit(money)
		other.deposit(withdrawal(money));
}
	// 조회
	public void inquiry() {
		System.out.println("계좌번호 : " + accNo);
		System.out.println("잔액 : " + balance + "원");
	}
	
}