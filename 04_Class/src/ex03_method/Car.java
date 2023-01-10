package ex03_method;

public class Car {
	
	// 필드
	int oilPot;
	int carSpeed; // push Accel 마다 속도는 10씩 증가, 최대 속도 100, pushBrake 마다 속도 10씩 소
	
	// 기름 넣기 메소드
		void addOil(int oil) {
			if(oilPot +oil > 50) {
				oilPot = 50;
				return; // 메소드를 종료하시오. -> (반환타입이 없을때=즉 void인경우만 사용가능)
			}
			oilPot += oil;
		}

		// 달리기 메소드
		void pushAccel() {
			if(oilPot == 0) { // 달리기전 기름통 확인/ 기름 없음 안달림
				return;
			}
			oilPot--; // Accel 밟을때 마다 oil 1씩 줄어듬
			
			if(carSpeed + 10 > 100) {
				carSpeed = 100;
				return;
			}
			carSpeed +=10;
			
			}
		//System.out.println("달린다"); >> 달리기


		
		// 멈추기 메소드
		void pushBrake() { // 멈출때는 기름 안줄고, 속도만 줄어든다
			
			if(carSpeed == 0) {
				return;
			}
			carSpeed -=10;
			if(carSpeed <0) { // 속도를 10줄였는데 0보다 작을때
				carSpeed = 0;
			}
		}
		
			
			
		}