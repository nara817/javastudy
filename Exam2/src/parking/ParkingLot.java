package parking;

import java.util.Scanner;

public class ParkingLot {

	private String name; // 자동자 이름
	private Car[] cars; // 자동차 배열
	private int idx; // index 실제 주차장에 주차된 자동차
	private Scanner sc; // Scanner

	/*
	 * 2) constructotr(생성자) 매개변수로 주차장이름을 전달 받아서 필드를 초기화하고, 길이가 10인 cars 배열을 생성하고,
	 * 키보드로부터 정보를 입력 받을 수 있는 sc인스턴스를 생성한다.
	 * 
	 */

	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	} // String타입으로 선택

	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(idx == cars.length) {		//실제 주차된 자동차==자동차 배열의 길기
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
	} // 3) sc 인스턴스를 이용해서 차량번호화 모델명을 입력 받은 뒤 cars 배열에 순차적으로 저장한다.
		System.out.println("차량번호 >>>");
		String carNo = sc.next(); // 차량번호 입력받아서 변수에 넣기공백 없는 문자열은 next)
		
		System.out.println("모델명 >>>");
		String model = sc.next();0
		
		cars[idx++] = new Car(carNo, model); // 차는 계속 늘기때문에 ++
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
		
		
		
}

}

/*
1) 가장 먼저 "현재 등록된 차량 0대"와 같은 메시지를 출력합니다. 
2) 주차장이 가득찬 경우 '더 이상 차량 등록이 불가능합니다.'메시지를 출력하고 addCar() 메소드를 종료한다. 
3) sc 인스턴스를 이용해서 차량번호화 모델명을 입력 받은 뒤 cars 배열에 순차적으로 저장한다. 
4) 차량번호와 모델명은 공백 없는 문자열로 처리한다. 
5) 차량번호가 "288러1111"과 같은 차량의 등록이 성공하면 "차량번호 288러1111 차량이 등록되었습니다." 메시지를 출력한다. 
6) 기타 명시되지 않은 예외는 발생하지 않는것으로 가장한다.
 */