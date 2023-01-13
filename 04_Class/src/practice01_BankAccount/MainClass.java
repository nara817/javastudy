package practice01_BankAccount;

public class MainClass {

	public static void main(String[] args) {
		
		BankAccount myAcc = new BankAccount("010-1111-1111", 50_000); // 내계좌 /생성자
		BankAccount yourAcc = new BankAccount("010-9999-9999", 100_000); // 타인계좌
		
		myAcc.transfer(yourAcc, 50_000);
		
		myAcc.inquiry();
		yourAcc.inquiry();
	}

}
      