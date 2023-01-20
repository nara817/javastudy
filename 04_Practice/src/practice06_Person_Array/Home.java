package practice06_Person_Array;

public class Home {

	// 필드
	private Person[] arr; // 사람 여러명 저장(집마다 사람 수 다르기에 new안댐)
	private int count; // 사람이 몇명 있다
	
	// 생성자
	public Home(int count) {
		arr = new Person[count]; // 배열의 길이 count
		this.count = count;
	}

	// 메소드
	public Person[] getArr() {
		return arr;
	}

	public void setArr(Person[] arr) {
		this.arr = arr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	} 
	
	
	}
