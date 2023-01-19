package practice05_Cart.copy;

public class Customer { // 카트에 물건 담을 고객

	private int myMoney; // 결제할 돈
	private int myPoint; // 물건 구매시 포인트+
	private Cart myCart; // 물건 담을 카트

	// 생성자 자동생성 generate constructor using fields
	public Customer(int myMoney, int myPoint) {
		this.myMoney = myMoney;
		this.myPoint = myPoint;
		this.myCart = new Cart(10); // 물건10개만 담을 수 있는 카트 / 카트 새로 생성
	}

	// getter와 setter 생성
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
	
	// 카트에 물건 담기
	public void addToCart(Product product) {
		myCart.addProduct(product);
	}

}