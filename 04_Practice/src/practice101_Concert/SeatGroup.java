package practice101_Concert;

import javax.swing.JOptionPane;

/* 클래스만들기
SeatGroup2
ㄴ 좌석을 여러개 모아서 부름 SeatGroup
ㄴ 각 좌석의 타입(S,R,A)마다 좌석의 갯수가 다름 

using Fields + getter setter 사용가능한 경우 > bean인경우 만 가능
 */

public class SeatGroup {

	private String seatType; // S, R, A 타입
	private Seat[] seats; // 배열의 선언 시트타입의 배열, 시트들 각 타입별로 몇개의 좌석이 들어오는지 아직 알 수 없음

	// new SeatGroup("S",10) : "S"석이 10개 있다.

	public SeatGroup(String seatType, int length) {
		this.seatType = seatType;
		seats = new Seat[length]; // 배열생성
		for (int i = 0; i < length; i++) { // 각 시트자리에
			seats[i] = new Seat(); // 점유 되지 않은 빈 좌석을 배열의 길이 만큼 만들기(*시트 자리에 빈좌석을 시트 자리만큼 만들어준다)
									// new Seat(); 꼭 해줘야한다!! 생성자에 넣던 어디에 넣던 상관 없으나 꼭 생성해야함(예약시에 넣어줘도 됨)
		}
	}

	// 좌석 예매 상황
	public void info() {

		// 좌석의 갯수 30개
		System.out.println("[" + seatType + "]타입");
		for (int i = 0; i < seats.length; i++) {

			System.out.println(i < 9 ? "0" : "" + (i + 1) + "  "); // 공백2개로 비어있는 자리로
			if (seats[i].isOccupied() == false) {
				System.out.println("   ");
			} else {
				System.out.println(seats[i].getName()); // 빈 좌석이 아니면 예약자가 누군지 보여주기
			} // System.out.println(i +1) + " "); // 좌석번호 붙여주기
			if ((i + 1) % 10 == 0) { // 인덱스를 9로 나누었을때, 인덱스의 일의자리가 9이면, 줄을 바꾸고 아니면 공백을 주자
				System.out.println();
			} else {
				System.out.print(" ");
			}

		}
	}

	// 예약 하기 Scanner 대신 사용 가능
	public boolean reserve() {
		info(); // 예매 상황 보여주기
		String strNo = JOptionPane.showInputDialog("예약할 시트번호를 입력하세요."); // showInputDialog 입력상자(Scanner 대신 사용 가능)
		int seatNo = Integer.parseInt(strNo);
		if (seatNo < 0 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			// JOptionPane.showConfirmDialog(null, strNo + "번 좌석은 없는 좌석입니다."); 다이얼로그로 입력창 띄울
			// 수 있음
			return false; // 예약하기 실패
		}
		// 점유된 자리인지 확인(예약된 시트인지 확인)
		if (seats[seatNo - 1].isOccupied()) { // -1 인덱스로 사용 할 수 있도록
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}
		// 예약 진행
		String name = JOptionPane.showInputDialog("예약자 성함을 입력하세요.");
		seats[seatNo - 1].setName(name);
		System.out.println(seatNo + "번 좌석 예약이 성공했습니다.");
		return true;
	}

	// 예약 취소
	public boolean cancel() {
		info();
		String name = JOptionPane.showInputDialog("취소자 성함을 입력하세요."); // 해당이름이 있는지 확인
		for (int i = 0; i < seats.length; i++) {
			if (seats[i].isOccupied() && seats[i].isMatched(name)) { // 해당좌석의 (점유여부)예약 여부 확인 && /같은 이름은 없다는 가정으로 품
				seats[i].setName(null);// 이름이 없어지는게 취소(예약 안된자리 null)
				JOptionPane.showMessageDialog(null, "예약자" + name + "의 예약이 최소되었습니다.");
				return true;

			}
		}
		JOptionPane.showMessageDialog(null, "입력된 이름" + name + "은 존재하지 않습니다.");// 동일한 이름이 입력되지 않았을때
		return false;
	}
}