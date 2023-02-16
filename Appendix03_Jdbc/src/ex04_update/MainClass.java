package ex04_update;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	public static void main(String[] args) {
		

		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localHost:1521:xe";
			
			con = DriverManager. getConnection(url, p);
			
			// id가 admin인 회원이 작성한 게시글의 TITLE 앞에 [New]를 추가하시오.
			String sql = "UPDATE BOARD_TBL SET TITLE = '[New]'|| TITLE";
				   sql += " WHERE MEMBER_NO = (SELECT MEMBER_NO FROM MEMBER_TBL WHERE ID = ?)"; // 단일행 서브쿼리
										//  ㄴ 단일행 연산자 등호(=)				// 변수자리 물음표
						// ID 정보 없기때문에, MEMBER_NO
			
			ps = con.prepareStatement(sql);
			
			String id  = "admin"; 
			
			ps.setString(1, id); // 1번째 물음표(?) 자리에 id를 넣으시오

			// 변수값이 정수 일경우, ps.setInt 일수도 있고.. ps.setDouble 일수도 있음!
			
			int updateResult = ps.executeUpdate();
			
			System.out.println(updateResult + "개의 행이 삽입되었습니다.");
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

	}

