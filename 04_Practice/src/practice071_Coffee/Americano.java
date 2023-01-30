package practice071_Coffee;

public class Americano {

// 필드
private Espresso[] cups;// 에스프레소 여러잔 들어 갈 수 있음 > 배열
private int shotCount; // 아메리카노에 들어간 에스프레소 개수(샷)
private int extraWater; // 물
private int idx; // cups 배열 인덱스

// 생성자(외부에서 땡겨 쓰려고) private이니까 직접 못대려오니까
public Americano(int shotCount, int extraWater) {
	super();
	cups = new Espresso[shotCount]; //컵스:에스프레소가 들어갈 수 있는 공간을 만듬, 그 공간이 샷이 들어 갈 수 있을 만큼에 공간
	this.shotCount = shotCount;
	this.extraWater = extraWater;
}	
	// 샷 추가 addEspresso 메소드 / "더 이상 샷을 추가할 수 없습니다."
public void addEspresso(Espresso espresso) {
	if(idx == shotCount) {
		System.out.println("더 이상 샷을 추가할 수 없습니다.");
		return;
	}
	cups[idx++] = espresso;
	
}
	
	// 조회 info 메소드 / "◁◁◁ " +  + "번째 샷 정보 ▷▷▷"
public void info() {
	int totalwater = 0;
	for(int i = 0; i < cups.length; i++) {
		System.out.println("◁◁◁ " + (i + 1) + "번째 샷 정보 ▷▷▷");
		cups[i].info();
		totalwater += cups[i].getWater(); // 컵 i번째 만큼 담긴 물(Espresso water에서 가져옴)을 > totalwater에 저장
		// 샷만들때 들어간 물양
	}
	totalwater += extraWater;
	System.out.println("아메리카노 총 ml : " + totalwater + "ml" );
	// 아메리카노 만들때 들어간 물양
}
}
