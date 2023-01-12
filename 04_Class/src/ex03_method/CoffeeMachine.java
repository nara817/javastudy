package ex03_method;

public class CoffeeMachine { // 어려웡 일단 보류
	
	// 필드
	int moneyPot; // 돈통 초기화 0
	String[]menu = {"아메리카노", "카페라떼", "마키아또"}; 
	int[] prices = {900, 1500, 2000};
	
			
	
	// 메소드
	CoffeeAndChange buyCoffee(int money, int choice){//커피사려고 사용자한테 돈,종류 선택
//	(반환타입)                          ㄴ choice -1  menu,price 인덱스로 쓰겠다
		
		// 돈이 모자르면 money 그대로 변환 (예외상황)
		int price = prices[choice - 1]; //사용자가 선택한 커피의 가격
		if(money < price) { // 제품의 가격보다 들어온 돈이 적다
			CoffeeAndChange cnc = new CoffeeAndChange();
			cnc.change = money;
			return cnc;
 //					ㄴ MainClass > coffeeMachine.buyCoffee(1000, 1)			
			
		}
		
		String coffee = menu[choice -1]; 
	
		moneyPot += price; // 돈이 누적됨 +
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee;
		cnc.change = money - price;
		return cnc;
	}

	
	

}
