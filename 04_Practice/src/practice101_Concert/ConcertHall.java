package practice101_Concert;

import javax.swing.JOptionPane;

import practice10_Concert.ConcertHall;

public class ConcertHall {
	
	private SeatGroup[] seatGroups; // 배열의 선언
	private String[] seatTypes = {"S", "R", "A"}; // S:30 R:40 A:40 > Map으로도 가능
	private int[] seatCount = {30,40,50};
	
	// new ConcertHall()
	public ConcertHall() {
		seatGroups = new SeatGroup[seatTypes.length]; // 배열의 생성 seatTypes또는 seatCount 가져와서 배열로 사용
		// ㄴ 아직  null 값만 들어있음 new SeatGroup 해줘야함!
		for(int i = 0; i < seatGroups.length; i++) {
			seatGroups[i] = new SeatGroup(seatTypes[i], seatCount[i]);
		}
		
	}
	// 예약 확인하기(콘서트홀 입장에서)
	public void info() {
		for(int i = 0 ; i < seatGroups.length; i++) {
		seatGroups[i].info(); // SeatGroup의 public void info 가져옴
		System.out.println("-----------------------"); // S석 보여주고 ---- 구분 R석 보여주고 ----- 구분...
		}
		
	}
	
	// 예약하기
	public void reserve() {
		// 예약할 타입 확인필요 S,R,A
		
		String seatType = JOptionPane.showInputDialog("좌석 타입을 입력하세요.");
		
		for(int i = 0; i < seatTypes.length; i++) {
			if(seatType.equals(seatTypes[i])) { // seatTypes[i]저장되어있던  S,R,A과 비교
				seatGroups[i].reserve();
				return; // 예약 종료하기
				
			}
		}
		JOptionPane.showMessageDialog(null, "입력한" + seatType + "타입은 존재하지 않습니다.");// 동일한게 아무것도 없다면, 잘못된 시트타입 보여주고 종료
	}
	
	
	

public static void main(String[] args) {

}

}