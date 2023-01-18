package practice3_Cart;

public class Customer { //카드에 물건 담을 고객
	
	private int myMoney;
	private int myPoint;
	private Cart myCart; // 카트있어야함!!
	
	
	public Customer(int myMoney, int myPoint) {// 고객만들기 카트를 외부에서 받아올 필요 없음
		this.myMoney = myMoney;
		this.myPoint = myMoney;
		this.myCart = new Cart(10); //10개물건 담을 수 있는 카드 /  카트가 아직 없어 생성해야함
					// ㄴ고객이 오면 걍 카트 줘버림
		
	}

	// getter와 setter 생성 / 소스탭

	public int getMyMoney() {
		return myMoney;
	}


	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}


	public int getMyPoint() {
		return myPoint;
	}


	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}


	public Cart getMyCart() {
		return myCart;
	}


	public void setMyCart(Cart myCart) {
		this.myCart = myCart;
	}
	
	// 카트에 물건담기
	public void addToCart(Product product) { // 카트에 물건 담는 코드 호출
		myCart.addProduct(product);
		
	}
	
	// 카트에서 물건 빼기
	public void deleteFromCart(int prodNo) {
		myCart.deleteProduct(prodNo);		
	}
	
	// 구매
	// 영수증을 String으로 반환
	public String buy() {
		
		int buyMoney = 0; // 구매한 물건들의 가격 합계
		int buyPoint = 0; // 구매한 물건들의 가격에 의한 포인트		
		
		String receipt = "----- 영수증 -----\n"; // 영수증  줄바꿈\n
 		
		
		for(int i = 0 ; i < myCart.getProductCount(); i++) {//카트에 담긴 물건 빼기 결제하기 위해서
			
			Product product = myCart.getProducts()[i]; // 카트에서 뺀 물건 1개
							//myCart.getProducts() 배열(카트에서 의 productS [i])
			buyMoney += product.getProdPrice();
			buyPoint += product.getProdPrice() * 0.05; // 제품 가격의 5% 포인트
			receipt += product.getProdName() + "   " + product.getProdPrice() + "원\n"; //한줄에 하나당 나오게 영수증에
			// 구매가 불가능한 경우 : 돈이 부족함
			if(myMoney < buyMoney) {
				System.out.println("돈이 부족합니다. 구매를 종료합니다.");
				return""; // receipt null; 빈문자열이 나오거나 안주거나
			}
		}
		
		myPoint += buyPoint; // 구매한 제품의 금액만큼 포인트 오르고
		myMoney -= buyMoney; // 내 돈은 줄고
		
		receipt += "---------------------------\n";
		receipt += "발생한 포인트" + buyPoint + "점\n";
		receipt += "보유 포인트" + myPoint + "점\n";
		receipt += "구매총액" + buyMoney + "원\n";
		return receipt;
		
	}

}
