package practice101_Concert;

public class Seat {

	private String name; // 시트 예약한 사람이름

	public String getName() { // 예약 한 사람 화인
		return name;
	}

	public void setName(String name) { // 예약
		this.name = name;
	}

	public void cancel() { // 예약 취소
		name = null;
	}

	public boolean isOccupied() {// 예약 여부 확인(boolean 트루 펄스 값 )
		return name != null;// null이 아니면 true 반환(예약되어있으면 true 반환 이름이 있으면)
	}
	// 예약자 확인
	public boolean isMatched(String name) { // isMatched 호출시 넘어온 값 name에 담아준다
		return name.equals(this.name); //   ㄴ 해당 이름과 (시트 예약한 사람이름) 이름을 비교
}
}