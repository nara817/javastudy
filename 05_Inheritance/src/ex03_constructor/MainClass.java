package ex03_constructor;

public class MainClass {

	public static void main(String[] args) {
		
		
		Student student = new Student();
		
		/*********************************/
		
		Student student2 = new Student("정숙", "가산중학교");
		System.out.println(student2.getName());
		System.out.println(student2.getSchool());
				

	}

}
