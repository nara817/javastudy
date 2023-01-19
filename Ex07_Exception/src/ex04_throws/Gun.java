package ex04_throws;

// 임폴트 시점?!

public class Gun { //메소드 마다 try catch 하는게 아닌, 각 호출할때 한꺼번에 할 수 있음!!(

	private int bullet; // 총알
	public static final int MAX_Bullet = 10; // 최대 총알수(final로 막아둬서 안전함)

	// 총알 넣기
	public void reload(int bullet) throws RuntimeException{ // reload메소드를 호출하는 곳으로 예외를 던지겠다

		if (this.bullet + bullet > MAX_Bullet) {
			throw new RuntimeException("장전 불가능");//return;
		}
		this.bullet += bullet;
	}

	// 총쏘기
	public void shoot() throws RuntimeException {
		if (bullet == 0) {
			throw new RuntimeException("총알 부족"); 
		}
		bullet--;
	}

	// getter setter생성
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
}
