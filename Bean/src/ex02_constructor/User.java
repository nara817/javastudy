package ex02_constructor;

public class User {
	
	// 필드
	private String id;/*1*/
	private String pw;/*1*/

	// 생성자
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	// toString
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}
