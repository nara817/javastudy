package parking;

import java.util.Scanner;

public class ParkingLot {

	private String name; // 자동자 이름
	private Car[] cars; // 자동차 배열
	private int idx; // index 실제 주차장에 주차된 자동차
	private Scanner sc; // Scanner

	/*
	2) constructotr(생성자) 매개변수로 주차장이름을 전달 받아서 필드를 초기화하고, 길이가 10인 cars 배열을 생성하고,
	키보드로부터 정보를 입력 받을 수 있는 sc인스턴스를 생성한다.
	
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
		String carNo = sc.next(); // 차량번호 입력받아서 변수에 넣기공백 없는 문자열은 "next"메소드는 공백이 오면 거기서 끝남!
								//공백의 뒤 부분을 nextline(줄바꿈이전까지)출력  
		
		System.out.println("모델명 >>>");
		String model = sc.next();
		
		cars[idx++] = new Car(carNo, model); // 차는 계속 늘기때문에 ++
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
		
}
	public void deleteCar() {
	
	}
	public void printAllCars() {
		
	}
	public void manage() {
		
		while(true) {
			
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>>"); // 메뉴를 운영하겠다! 입력받는건 숫자로 
		// =String choice = sc.next(); 동일 (case "1" "" 추가해야함)
			int choice = sc.nextInt();//정수로 입력할때 받는 Scanner nextInt
			//추가시켜줄때 사용하는 메소드 addCar
			switch(choice) {
			case 1:
				addCar(); // addCar 호출
				break; //>> 완성한 기능은 1번까지임 (반환타입 없고, 매개 변수 없어서..)
			case 2:
				deleteCar(); // deleteCar 호출
				break; 
			case 3:
				printAllCars(); // printAllCars 호출 / 0이들어오면 프로젝트 끝냄!
				break; 
			case 0:
				return; // return은 manage메소드 종료 / break하면 switch 끝내버려서 사용x
			default: // 1230모두 아닐때! 4567같은 잘못 된 값 입력될 경우를 위해
				System.out.println("존재하지 않는 메뉴 입니다."); // ParkingLotMain클래스 새로 만들기!
			}

		}
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