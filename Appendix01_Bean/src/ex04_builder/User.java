package ex04_builder;

public class User {
	//필드( Builder객체가 가진 값을 받아온다) // User의 필드
	private String id;
	private String pw;
	
	
	// User 생성자
	public User(Builder builder) {
	//User user = new User(){}
		this.id = builder.id;
		this.id = builder.pw;
	}
	
	// Builder객체 반환
	public static Builder builder() {
		return new Builder();
	}
	
	
	
	@Override
	public String toString() {
		return String.format("User [id=%s, pw=%s]", id, pw);
	}
	
	// Builder 클래스(내부 클래스)
	public static class Builder{
		 
		// Builder 필드(여기로 값을 전달 받아서 User 필드로 전달한다) // Builder의 필드
		private String id;
		private String pw;
		
		// 값을 받아오는 메소드
		// 1. 메소드명과 필드명을 동일하게 구성)
		// 2. 메소드 체이닝을 위해서 현재 객체를 반환한다.
		
		public Builder id(String id) {
			this.id = id;
			return this;
		}
		public Builder pw(String pw) {
			this.id = pw;
			return this;
		}
		
		// User 객체 반환
		// Builder 필드 값을 가진 User 객체를 반환
		public User build() {
			return new User(this); //this는 id,pw 값을 모두 가지고 있는 Builder 객체
		}
	}


		
	}

