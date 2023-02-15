package ex01_setter;

public class User {//생성자 생성x 디폴트값 사용하겠다
	
	
	private String id;
	private String pw;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
}