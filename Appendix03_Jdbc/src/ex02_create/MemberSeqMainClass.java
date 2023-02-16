package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberSeqMainClass {
	// 한번만 성공함, 두번째 부터는 이미 만들어져있어서.. 실패
	public static void main(String[] args) {
		
		Connection con = null; // try catch 처리 후 생성 2
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "CREATE SEQUENCE MEMBER_SEQ NOCACHE"; // PreparedStatement ps = null; 위에 생성해주기 3
			
			ps = con.prepareStatement(sql);
			
			ps.execute();
		
		/*	if(ps.execute()) {
				System.out.println("MEMBER_SEQ 가 생성되었습니다.");
			} else {
				System.out.println("MEMBER_SEQ 가 생성이 실패 했습니다.");
			}  // 이거 안씀!!*/
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
