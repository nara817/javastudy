package ex04_throws;

public class MainClass2 { // try catch 하기전 상황

	public static void main(String[] args) {

		// 총만들기
		Gun gun = new Gun();

		// 총알 넣기 reload 호출 + MAX값이 10, 그 이상일때 예외발생
		gun.reload(0);
		for (int n = 0; n < 11; n++) {
			gun.shoot();
		}
	}

}
