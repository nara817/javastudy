package practice3_Cart;

public class MainClass {

	public static void main(String[] args) {
		
		
		Customer me = new Customer(10000, 500); // 10000원에 500원
		
		me.addToCart(new Meat(1,"소고기",5000));
		me.addToCart(new Pizza(1,"고구마피자",3000));
		me.addToCart(new Noodle(1,"누들면",2000));
		
		String receipt = me.buy(); //계산대
		System.out.println(receipt);
		
		System.out.println(me.getMyMoney());
		System.out.println(me.getMyPoint());

	}

}
