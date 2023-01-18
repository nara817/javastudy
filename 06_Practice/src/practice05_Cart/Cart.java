package practice05_Cart;

public class Cart {

	private Product[] products;   // 배열 선언/ 제품이 들어갈 공간
	private int prodCount;        // 실제로 products 배열에 저장된 Product의 개수(카트에 들어간 제품의 갯수)
	
	// new Cart(10)(물건을10개 담을 수 있는 카트), new Cart(20),.... 
	// 생성자를 임의 생성할 경우 직접 만들어야함 source탭 이용불가
	public Cart(int cartSize) {
		products = new Product[cartSize];  // 배열 생성  // 제품 아직 안들어 있으니 productCount 아직 0
		prodCount = 0;
	}
	
	// getter 와 setter 만들기  / 소스탭 이용

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	
	// 카트에 물건 담기
	// addProduct(new Meat(1, "소고기", 5000)) 자식객체를 부모에게 저장하는게 가능
	// addProduct(new Pizza(2, "고구마피자", 3000))
	// addProduct(new Noodle(3, "누들면", 1500)) 
	public void addProduct(Product product) { // 제품 추가
		
		// 카트가 가득 차면 물건을 담지 못한다.
		if(products.length == prodCount) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 카트에 물건 담기
		products[prodCount++] = product;
		
	}
	
	// 카트에 물건 빼기
	// deleteProduct(1)
	// deleteProduct(2)
	// deleteProduct(3)
	public void deleteProduct(int prodNo) {
		
		// 카트가 비어 있으면 뺄 물건이 없다.
		if(prodCount == 0) {
			System.out.println("카트가 비어있습니다.");
			return;
		}
		
		// 카트에서 물건 빼기
		for(int i = 0; i < prodCount; i++) {
			if(products[i].getProdNo() == prodNo) {
				products[i] = products[--prodCount];  // 마지막 물건을 뺀 물건 자리로 옮기기
				break;
			}
		}
		
	}
	
}