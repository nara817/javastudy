package ex01_connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainClass {
	
	// ex01 + ex02 함께 주로 사용됨 
	
	public static void ex01() {
		
		// 클래스를 로드하는 방법(메모리에 로드한다 : 사용하겠다)
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OracleDriver도 가능하다.
						//ㄴ2번째꺼 사용( java.lang.Class.forName(String className))
			System.out.println("클래스가 로드되었습니다.");
			
			
		} catch(ClassNotFoundException e) {	// 클래스 못찾았다는 예외(ClassNotfound예외)
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
	public static void ex03() {
		
		// 프로퍼티 파일 읽는 문자 입력 스트림 생성하기
		BufferedReader reader = null;
		Connection con = null;
				
		try {
			
			reader = new BufferedReader(new FileReader("db.properties"));
			
			// 프로퍼티 파일을 읽어서 사용자 정보 처리하기
			// 프로퍼티 파일을 읽어서 프로퍼티 객체 생성하기
			Properties properties = new Properties();
			//ㄴ 자바 유틸을 읽는 클래스
			// 메소드를 따로 부름
			properties.load(reader);
			
			// 프로퍼티 객체에 저장된 각 property 읽기
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			
			// DriverManager로부터 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password); // getConnection 에러 > SQLException  필요
			System.out.println("DB에 접속되었습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection () { // Connection 반환메소드
												//getConnection 호출하면, Connection 옴
		
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties properties = new Properties();
			properties.load(new BufferedReader(new FileReader("db.properties")));

			con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),
					properties.getProperty("password"));

		} catch (Exception e) { // ClassNotFoundException, SQLException, IOException
			e.printStackTrace();
		}
		return con; // finally, con.close 하면안됨 따로 만들어야함(닫으면 안됨)
	}
	public static void main(String[] args) {
		Connection con = getConnection();
		System.out.println("DB에 접속되었습니다.");
		// 닫으려면, 여기서 con.close + 예외처리필요

	}

}
