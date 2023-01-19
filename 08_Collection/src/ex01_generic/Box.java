package ex01_generic;

public class Box<T> { // 박스를 만들때 정수인지 실수인지 구분<>, <>괄호 안에 값이 타입이 됨
	
	private T item; //Object item; //Object다 저장 시킬 수 있으나, 빼서 casting해야하는 불편함이 있음

	
	// getter setter
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	

}
