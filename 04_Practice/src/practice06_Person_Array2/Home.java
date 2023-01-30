package practice06_Person_Array2;

import practice06_Person_Array.Person;

public class Home {
	

	private Person[] arr; // 집안에 가족들
	private int count; //가족들에 사람 수 넣기, 반복문은 배열의 길이를 알아야해서 필드count
	
	
	public Home(int count) { 	// 생성자 만들기  count는 필요함, home arr은 필요 없음 참조기때문에
		arr = new Person[count];
		this.count = count;
	}

	
	public Person[] getArr() { // 안만들면 참조 불가
		return arr;
	}


	public void setArr(Person[] arr) { // 안만들면 참조 불가
		this.arr = arr;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	

	
	
	
	
	

}
