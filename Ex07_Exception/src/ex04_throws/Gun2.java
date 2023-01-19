package ex04_throws;


public class Gun2 { // try catch 하기전 상황

	// 총알
	private int bullet;
	// 최대 총알수
	public static final int MAX_Bullet = 10;

	// 총알 넣기
	public void reload(int bullet) {
		if (this.bullet + bullet > MAX_Bullet) { // 현재 총알에 추가로 총알을 추가한걸 가정해보았을때..?
			return;				// 현재 총알 + 추가된 총알이 > 최대 총알수 보다 더 크면 // 실행x
		} 										
		this.bullet += bullet; // this.bullet = this.bullet + bullet
	}
	
	// 총쏘기
	public void shoot() {
		if(bullet == 0 ) { //총알이 0 없으면
			return; // 총알 없으면 실행x
		}
		bullet--; 
	}

	// bullet getter setter생성
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

}
