package practice101_Concert;
/* 클래스만들기
seat1 
 */
public class Seat {
	
	private String name; //1
	
	// 생성자 //2 아래처럼 만들거나, getter setter 이용해서 만들거나
	/*public Seat() {} // new Seat() + setName함께 사용 / 호출 > 좌석 주인x
	public Seat(String name) { // new Seat("홍길동") 호출 > 좌석 주인o
		this.name = name; 
}*/
	// getter setter //2
	public String getName() { //name 확인용 메소드(예약자 확인용)불러오기위해(private때문에)
		return name;
	}
	public void setName(String name) { //name 저장용 메소드(예약 처리용) 변경해주기위해(private)
		this.name = name;
	}

	//3
	public boolean isOccupied() { // 좌석이 점유되었으면 true반환
 		return name != null; // 아래 if문과 동일한 식
	/*	if(name == null) {
			return false; // 점유되어 있지 않다.
		} else {
			return true; // 점유되어 있다.
			
		} */
	}
	// 4 이름 비교
	public boolean isMatched(String name) { // 좌석의 name(필드)과 매개변수 String name이름을 받아와서 
		return name.equals(this.name); // 아래 if문과 동일한 식
		/*	if(this.name.equals(name)) {//좌석의 이름 주인
			return true;
		} else {
			return false;
		} 
		}*/
		}
	
}