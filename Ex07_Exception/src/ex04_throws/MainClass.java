package ex04_throws;

public class MainClass {

	public static void main(String[] args) {
		// 총만들어서, 총 쏠때 try catch
		Gun gun = new Gun();

		try {
			gun.reload(10); // 총알넣기 reload 호출 / 11이상 > 예외발생
			for (int n = 0; n < 11; n++) { // 총쏘기 shoot 호출
				gun.shoot();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
