package ex04_builder;

public class MainClass {

	public static void main(String[] args) {

	//	User user = User.builder().id("admin").pw("123456").build(); 하위와 동일
		User user = User.builder()
						.id("admin")
						.pw("123456")
						.build();
		
		System.out.println(user);
		

	}

}
