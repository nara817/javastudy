package practice06_Person_Array;

public class Person {
	
	// 필드
	private String name;
	private int age;
	
	// new Person()
	// new Person("alice",20)
	// 생성자 (디폴트 생성자는 생성자를 만들지 않았을때만 사용됨)
	public Person() {} // new Preson (이름 없고, 나이 없음 > 이름,나이를 바꿀 메소드 필요)
	public Person(String name, int age) { // new Person("alice",20)
		this.name = name;
		this.age = age;
	}

	// 메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
