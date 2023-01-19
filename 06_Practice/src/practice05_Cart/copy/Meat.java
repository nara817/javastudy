package practice05_Cart.copy;

public class Meat extends Product { // extends먼저 해주고 > generate constructor from superclass

	// new Meat(1, "소고기" , 5000)

	public Meat(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice);
	}

}
