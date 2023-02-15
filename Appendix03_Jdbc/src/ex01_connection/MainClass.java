package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
	
	// ex01 + ex02 함께 주로 사용됨 
	
	public static void ex01() {
		
		// 클래스를 로드하는 방법(메모리에 로드한다 : 사용하겠다)
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OracleDriver도 가능하다.
						//ㄴ2번째꺼 사용( java.lang.Class.forName(String className))
			System.out.println("클래스가 로드되었습니다.");
			
			
		} catch(ClassNotFoundException e) {	// 클래스 못찾았다는 예외
			e.printStackTrace();
		}

	}
	public static void ex02() {
		
		// Oracle DataBase와 연결할 때 사용하는 Connection 인터페이스
		// Oracle 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // thin> 가볍다 xedb가 가벼워서 쓰는것!
		String user = "GDJ61";
		String password = "1111";
		
		//선언 > 예외처리필요!
		Connection con = null;
		//ㄴ 인터페이스로 import
		
		
		// DriverManager 클래스로부터 Connection 객체를 받아온다.
		
		try {

			con = DriverManager.getConnection(url, user, password);
								// ㄴ3번째꺼 사용getConnection(String url, String user, String password)
			System.out.println("DB에 접속되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 사용이 끝난 Connection 객체는 반드시 닫아야 한다.
		try {

			if (con != null) {
				con.close(); // ★반드시 닫아주기!★ 예외발생
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
	public static void main(String[] args) {
		ex02(); 

	}

}
