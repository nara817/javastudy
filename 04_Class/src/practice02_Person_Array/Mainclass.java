package practice02_Person_Array;

public class Mainclass {
	
	public static void ex01() {		
		
	String[] nameList = {"정숙" , "상철" , "미희"};
	int[] ageList = {20,30,40};
	
	Person[] arr = new Person[3]; //배열의 생성(초기화 null값 3개저장됨 Person 3명 들어갈 집 생성함)
	
	for(int i = 0; i < arr.length; i++) {
		arr[i] = new Person(); // Person 3명 만듬
		arr[i].setName(nameList[i]); // 이름
		arr[i].setAge(ageList[i]); // 나이
		System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
		
	}	
}

	public static void ex02() {		
		
		String[] nameList = {"정숙" , "상철" , "미희"};
		int[] ageList = {20,30,40}; 
		
		Person[] arr = new Person[3]; // Person 3명 만듬
		
		for(int i = 0 ;  i < arr.length; i ++) { 
			arr[i] = new Person(nameList[i],ageList[i]);
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());			
		}
	}
	
	
	public static void ex03() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Home home = new Home(3);
		
		for(int i = 0; i < home.getArr().length; i++) { //집에 3명의 정보 채우기
			home.getArr()[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 : " + home.getArr()[i].getName() + ", 나이 : " + home.getArr()[i].getAge());
		}
		
	}
		
	public static void main(String[] args) {
		ex02();	

	}
}