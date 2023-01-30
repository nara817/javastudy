package ex04_OutputStream;

import java.io.Serializable;

/*
ObcectOutputStream/ObcectINputStream
객체 입출력을 수행하려면 "반드시" 직렬화 처리를 해야한다.
*/

/*
직렬화 처리방법
//	1. java.io.Serializable 인터페이스를 구현(implements)한다. (★필수★)
	2. serialVersionUID 필드 값을 정의한다. (선택, 경고는 뜰 수 있음 > 해결방법 add gerate serialVersionID))
	
*/

public class Person implements Serializable {


	private static final long serialVersionUID = 7033755836244474051L;
	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	// 생성자 2개(디폴트값, 필드를 받는값)
	public Person() {
		
	}
	
	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}

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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, age=%s, height=%s, isAlive=%s]", name, age, height, isAlive);
	}

}
