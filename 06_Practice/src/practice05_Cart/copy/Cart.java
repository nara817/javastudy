package practice05_Cart.copy;

public class Cart {
	
	// 배열 선언
	private Product[] product; // 제품이 들어갈 공간
	private int prodCount; // 실제 카트에 들어간 제품의 갯수

	
	// 배열 생성
	public Cart(int cartsize) {
		products = new Product[cartsize] ;  // products 오류발생
		prodCount = 0;
	}


	public Product[] getProduct() {
		return product;
	}


	public void setProduct(Product[] product) {
		this.product = product;
	}


	public int getProdCount() {
		return prodCount;
	}


	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
}