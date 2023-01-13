package ex03_constructor;

public class Alba extends Student{

	
	// 필드
	private String company;
	
	// 생성자 (요기서 만들기 Source > Generate Constructor using Fields)
	public Alba(String name, String school, String company) {
		super(name, school);
		this.company = company;
	}

	
	// 메소드
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
	
	
