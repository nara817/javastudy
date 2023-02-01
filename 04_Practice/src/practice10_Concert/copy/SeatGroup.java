package practice10_Concert.copy;

import java.util.Scanner;

public class SeatGroup {

	private String seatType;  // "S", "R", "A" 중 하나를 가짐
	private Seat[] seats;
	private Scanner sc;
	
	public SeatGroup(String seatType, int count) {  // new SeatGroup("S", 20) : S석이 20개 있다.// 
		this.seatType = seatType;
		seats = new Seat[count]; // count 배열의 개수만큼 만들기 위해
		for(int i = 0; i < count; i++) {
			seats[i] = new Seat();  // 빈 좌석 생성
		}
		sc = new Scanner(System.in);
	}
	
	// 예약
	public boolean reserve() {
		reserveInfo();
		// 시트번호는 1부터 시작
		System.out.print("예약할 시트번호 >>> ");
		int seatNo = sc.nextInt(); // int 입력 받을땐 nextInt
		if(seatNo < 1 || seatNo > seats.length) { //seatNo가 1보다 작거나  (length=최대값 개수)
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false;
		}
		// 예약된 시트인지 확인
		if(seats[seatNo - 1].isOccupied()) { // 배열은 0번부터 시작, 좌석은 1번부터 시작하기때문에 -1 해줌
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false; // 예약된 좌석이니 예약 중단
		}
		// 예약 진행
		System.out.print("예약자 이름 >>> ");
		String name = sc.next();
		seats[seatNo - 1].setName(name); // 예약 진행되었으니, -1(배열은 0번부터 시작, 좌석은 1번부터 시작하기때문에 -1 해줌 동일)
		System.out.println(seatNo + "번 좌석 예약이 완료되었습니다.");
		return true; 
	}
	
	// 예약 취소
	public boolean cancel() {
		reserveInfo();
		System.out.print("취소자 이름 >>> ");
		String name = sc.next();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {  // 예약된 좌석만 비교
				if(seats[i].isMatched(name)) {  // 예약자 이름과 취소자 이름이 같으면 true 반환
					seats[i].cancel();
					System.out.println("예약자 " + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}  // for
		System.out.println(name + "으로 예약된 좌석이 없습니다.");
		return false;
	}
	
	// 예약 상황 출력
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) { // 예약된 좌석
				System.out.print(seats[i].getName().substring(0, 1) + "* ");// substring 문자열 자르는거 0번째부터 1번째 까지 
			} else {  														// 김0나1라2 1의 전까지 김*
				System.out.print((i + 1) + (i < 9 ? "   " : "  "));// i < 9 참이면 띄어쓰기 3번 거짓이면 띄어쓰기 2번
			}//1   2   3   4  ---  8   9  10
			// 11  12  13  14
			// 21  22  23  24
			if((i + 1) % 10 == 0) { // 10의 자리일때 줄바꿈
				System.out.println();
			}
		}
		System.out.println();
	}
	
}