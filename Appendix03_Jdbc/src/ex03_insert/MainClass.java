package ex03_insert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {
	
	// 상수 삽입
	
	public static void ex01() {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url,user, password);
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin', '관리자', '서울', TO_DATE('2023-02-15', 'YYYY-MM-DD'))"; // 특정날짜 지정 11/11/11/ 년/월/일, 오늘날짜 SYSDATE
// 					ㄴ 띄어쓰기 신경써주기!    												DB에는 YY/MM/DD 요런식으로 들어가있음
			
			ps = con.prepareStatement(sql); // jdbc 에서 달라지지 않는 공통 코드!
			int insResult = ps.executeUpdate(); // excute 아님!ps.excuteUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
				
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close(); // 만든거 역순으로 닫기! ps먼저 > con 다음
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public static void ex01_1() {
		// ex01의 다른방법
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin2', '관리자', '서울', TO_DATE('2023-02-15', 'YYYY-MM-DD'))"; // 특정날짜 지정 11/11/11/ 년/월/일, 오늘날짜 SYSDATE
// 					ㄴ 띄어쓰기 신경써주기!    												DB에는 YY/MM/DD 요런식으로 들어가있음
			
			ps = con.prepareStatement(sql); // jdbc 에서 달라지지 않는 공통 코드!
			int insResult = ps.executeUpdate(); // excute 아님!ps.excuteUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
				
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close(); // 만든거 역순으로 닫기! ps먼저 > con 다음
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	// 변수 삽입(상수 삽입보다 이게 더 중요!)
	public static void ex02() {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			
			con = DriverManager. getConnection(url, p);
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NO, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ? , ? , SYSDATE)";
			// 				변수 자리 물음표 >	id,name,address
			
			ps = con.prepareStatement(sql);
			
			String id = "master"; 
			String name = "운영자"; 
			String address = "경기"; 
			
			ps.setString(1, id); // 1번째 물음표(?) 자리에 id를 넣으시오
			ps.setString(2, name); // 2번째 물음표(?) 자리에 name를 넣으시오
			ps.setString(3, address); // 3번째 물음표(?) 자리에 address를 넣으시오
			// 정수값이 정수 일경우, ps.setint 일수도 있음
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( ps !=null ) ps.close();
				if( con !=null ) ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void ex03() {
		// ex02와 틀은 동일, BordTable 참고 - admin이 작성한 임의의 게시글을 삽입해 보자
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			
			con = DriverManager. getConnection(url, p);
			
			String sql = "INSERT INTO BOARD_TBL(BOARD_NO, MEMBER_NO, TITLE, CONTENT, CREATE_DATE)";
			sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			// 				변수 자리 물음표 >	TITLE,CONTENT
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 1;
			String title = "오늘은 목요일"; 
			String content = "보충은 취소되었음"; 
			
			ps.setInt(1, memberNo); // 1번째 물음표(?) 자리에 memberNo를 넣으시오
			ps.setString(2, title); // 2번째 물음표(?) 자리에 title를 넣으시오
			ps.setString(3, content); // 3번째 물음표(?) 자리에 content를 넣으시오
			// 변수값이 정수 일경우, ps.setInt 일수도 있고.. ps.setDouble 일수도 있음!
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( ps !=null ) ps.close();
				if( con !=null ) ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
	}
	public static void main(String[] args) {
		ex03();

	}

}
