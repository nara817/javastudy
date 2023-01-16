package ex06_downcasting;

public class MainClass {
	
	public static void ex01() {
		
		// upcasting
		/*3*/Person person/*부모타입객체*/ = new Student();
		
		// downcasting
		/*4*/Student student = (Student)person; // 강제변환 person앞에 (Student) "()사용"
		
		/*5*/student.eat();
		/*5*/student.sleep();
		/*5*/student.study();
		

			}

	public static void ex02() {
	
		// Person
		/*3*/Person person/*부모타입객체*/ = new Person();
	
		// 잘못된 캐스팅
		/*4*/Student student = (Student)person; // 강제변환 person앞에 (Student) "()사용"
		
		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다.
		/*5*/student.eat();
		/*5*/student.sleep();
		/*5*/student.study(); // 오류 발생 부분(Person은 study가 없음)

		}
	
	
	public static void ex02_2() {
	
		Person person = new Person();
		
		Student student = (Student)person;
		
		student.eat();
		student.sleep();
		student.study();
		
		((Student)person).eat();
		/*	Student student = (Student)person;
		student.eat(); 같은내용 */
		
		((Student)person).sleep();
		/*	Student student = (Student)person;
		student.sleep(); 같은내용 */
		
		((Student)person).study();
		/*	Student student = (Student)person;
		student.study(); 같은내용 */
		
	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();
		//		ㄴ객체
		// Student 객체(=인스턴스)가 맞다면 Study 타입으로 캐스팅하자.
		if(person instanceof Student) {
			
		/*	Student student = (Student)person;
			student.eat();
			student.sleep();
			student.study();
			
			위 내용이 곧 아래와 동일 / 가능한 아래식으로 사용 */
			
			person.eat();
			person.sleep();
			((Student)person).study(); 
			
		}
			
		}
		
		

	public static void main(String[] args) {
		ex03();
	
}
}
