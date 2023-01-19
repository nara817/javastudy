package ex05_exception;

public class Gun { //메소드 마다 try catch 하는게 아닌, 각 호출할때 한꺼번에 할 수 있음!!(

	private int bullet; // 총알
	public static final int MAX_Bullet = 10; // 최대 총알수(final로 막아둬서 안전함)

	// 총알 넣기
	public void reload(int bullet) throws GunException{ // reload메소드를 호출하는 곳으로 예외를 던지겠다

		if (this.bullet + bullet > MAX_Bullet) {
			throw new GunException("장전 불가능", "A-1");//return; 예외코드 A-1 > 장전 불가능이란뜻
		}
		this.bullet += bullet;
		System.out.println(this.bullet + "발 장전 완료"); // 현 몇발 들어있는지..
	}

	// 총쏘기
	public void shoot() throws GunException {
		if (bullet == 0) {
			throw new GunException("총알 부족", "A-2"); // 예외코드 A-1 > 총알 부족뜻
		}
		bullet--;
	System.out.println("빵" + bullet + ""); // 몇발 남았는지
	}

	// getter setter생성
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
}

