package practice071_Coffee;

public class Espresso {
	
	// 커피원두 coffeBean
	private CoffeeBean coffeeBean; //CoffeeBean 클래스에서 coffeeBean가져옴 
	// 물 water
	private int water;
	
	// 생성자
public Espresso(CoffeeBean coffeeBean, int water) {
	super();
	this.coffeeBean = coffeeBean;
	this.water = water;
}
	
	// 필요한 메소드
	public CoffeeBean getCoffeeBean() {
	return coffeeBean;
}


public void setCoffeeBean(CoffeeBean coffeeBean) {
	this.coffeeBean = coffeeBean;
}


public int getWater() {
	return water;
}


public void setWater(int water) {
	this.water = water;
}


// 조회 info
// coffeeBean 조회
// 물 ml : + 물의 양 + ml
public void info() {
	coffeeBean.info(); // CoffeeBean클래스에 있는 info정보 불러오기(origin + "원산지")
	System.out.println("물ml : " + water + "ml");

}

}
