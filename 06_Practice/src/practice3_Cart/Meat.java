package practice3_Cart;

public class Meat extends Product {// 상속Meat Product의 자식으로 만들기 
			// ㄴ오류 발생Meat 생성하려면, new Product을 먼저해야함 / 디폴트값도 생성 되지 않아 오류발생하는거

	// new Meat(1, "소고기" , 5000)
	public Meat(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice);
	}
	
}
