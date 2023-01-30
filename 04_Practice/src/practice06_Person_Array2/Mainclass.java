package practice06_Person_Array2;

public class Mainclass {
	
// 이름 배열 namelist 지원 미래 예림
// 따로 나이 배열 따로 agelist
	public static void main(String[] args) {
		
		String[] nameList = {"지원","미래","예림"};
		int[] ageList = {20,30,40};
		
		// home객체를 구성
		Home home = new Home(3); 
	
		//  가족 구성원의 길이만큼
		for(int i = 0; i < home.getArr().length; i++) {// 3을 저장해서,  arr값 가져오기위해서
		// arr 배열에 namelist, agelist 넣기
			home.getArr()[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 :"+ home.getArr()[i].getName() +  ", 나이 : "+ home.getArr()[i].getAge());
			
			
			
		}
	}
} 