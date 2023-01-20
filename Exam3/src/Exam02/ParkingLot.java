package Exam02;

import java.util.Scanner;

import parking.Car;

public class ParkingLot {

	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;

	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}

	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if (idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.println("차량번호 >>>");
		String carNo = sc.next();

		System.out.println("모델명 >>>");
		String model = sc.next();

		cars[idx++] = new Car(carNo, model);
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
;

	}

	public void deleteCar() {
		if (idx == 10) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.println("제거할 차량번호 >>>");
		String carNo = sc.next(); 
		for(int i = 0; i < idx; i++) {
			Car car = cars[i]; // 주차장에 저장되어있는 차량
/*2번째 방법*/			if(carNo.equals(car.getCarNo())) { //차량번호 일치 여부 판단 됨
		
		// i(삭제하고자하는) = 0, idx = 4, 개수3 // 뒤에있는 차량을 앞으로 옮기는 방법
		//System.arraycopy(carNo, i+1, car, i, i+3); 3개묶음 차를 앞열로 옮기는 방법3(=삭제할 다음요소들을 삭제할 자리로 보낸다)
		System.arraycopy(carNo, i+1, cars, i, idx-i-1);
		cars[--idx] = null;
		System.out.println("차량번호" + carNo+ "인 차량이 삭제되었습니다.");
		return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");// for문이 끝난 자리(동일 차량 번호가 단하나도 없을때, 삭제할 차량이 없을때)
	}	
	public void printAllCars() {
			System.out.println("대박주차장");		
			if (idx ==10)
				System.out.println("등록된 차량이 없습니다.");
				return;
		}

	public void manage() {

		while (true) {

			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>>");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addCar();
				break;
			case 2:
				deleteCar();
				break;
			case 3:
				printAllCars();
				break;
			case 0:
				return;
			default:
				System.out.println("존재하지 않는 메뉴 입니다.");
			}

		}
	}
}