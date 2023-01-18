package ex06_Object;

public class Person {
	
	// 필드
	private String name; /*3*/
	
	// 생성자
	public Person() {	/*3*///이름 안받아옴
		
		
	}
	
	public Person(String name)  {/*4*/	//이름 받아옴
		this.name = name;
	}
	public String getName() { /*5*/ //getter 만들기
		return name;
	}
	public void setName(String name) {/*5*/  //setter 만들기
		this.name = name;
	}
	
	
	

	public void eat() {/*1*/
		System.out.println("먹는다.");
	}

	public void sleep() {/*1*/
		System.out.println("잔다.");
	}

//	@Override  /*8*/Source탭에서 생성하기 > Generate hashcode  end equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override  /*8*/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override  /*9*/ // Source탭에서 생성하기 > Generate toSpring
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
