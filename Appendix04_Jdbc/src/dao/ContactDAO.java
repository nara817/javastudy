package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ContactDTO;


/*
 	DAO
// 	1. Database Access Object
 	2. Database에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받아온다.
 	3. 여러 객체가 만들어 지지 않도록 singleton 패턴으로 생성한다.
 	(객체1이 insert하는동안 객체2가 select요청할 수 있음.. 객체1이 insert하는중에 select할 수 없으므로 
 	모든 작업이 완료되어야, 다른 작업을 할 수 있음)
 
 */


public class ContactDAO {
	
	/*************** 1. singleton ***************/
	private static ContactDAO dao = new ContactDAO(); // dao 외부에서는 new DAO()불가
	private ContactDAO() {} // 디폴트값으로 생성, 내부에서는 호출 가능
	public static ContactDAO getInstance() { // get인스턴스메소드 , 외부에서 사용 할 수 있도록 메소드 생성
		// static으로 생성되어있는 메소드 (=클래스메소드), static 메소드는 클래스 이름으로 호출을해야해함
		return dao;
		
	}

	/*************** 2. field(=변수) ***************/
	// 해당 클래스들이 가지는 메소드들이 공동으로 사용하는..
	// Connection 얻어오고 < 목록보기, 삽입, 수정, 삭제하기 가능
	
	// ContactDAO 클래스의 메소드들이 공통으로 사용할 요소를 선언한다.
	private Connection con ; // DB접속
	private PreparedStatement ps; // 쿼리문 실행
	private ResultSet rs; // SELECT 결과 처리
	private String sql; // 쿼리문 자체
	private int res;// INSERT, UPDATE, DELECT결과 > result int값 
	
	/*************** 3. method(=메소드) ***************/
	// CRUD : CRUD작업(= DB기본작업 > CREATE(INSERT), READ(SELECT), UPDATE, DELETE)
	
	// CRUD 메소드의 진행 순서 : Connection 얻기 > CRUD작업 > 사용한 자원 반납(rs.cs.con./Close)
	// 									└     메소드화			┘
	
	// 공통 메소드 - 1 (Connection 얻기)
	private Connection getConnection() { // 내부에서만 확인 할 수 있도록
		
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			con = DriverManager.getConnection(p.getProperty("url"), p);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	// 공통 메소드 - 2 (사용한 자원 반납)
	private void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CRUD 메소드 - 1 (연락처 추가하기) 추가DAO
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.

	public int insertContact(ContactDTO contact) { // 메소드 이름에 insert 반환타입 int
		 // 삽입할 연락처 변수, 받아오기 ContcatDTO 하나면 됨!
		
		try {
			
			con = getConnection(); // con은 필드로 선언해둔 Connection
			sql = "INSERT INTO CONTACT_TBL(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS) VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?)"; // 쿼리만들기
			// 																								name, tel, email, address
			ps = con.prepareStatement(sql);
			// 변수 채우기
			ps.setString(1, contact.getName());    // 1번째 물음표에
			ps.setString(2, contact.getTel());     // 2번째 물음표에
			ps.setString(3, contact.getEmail());   // 3번째 물음표에
			ps.setString(4, contact.getAddress()); // 4번째 물음표에
			res = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		return res;
	}
	
	// CRUD 메소드 - 2 (연락처 삭제하기) 삭제DAO
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : int contact_no 변수에는 삭제할 연락처의 고유 번호가 저장되어 있다.
	public int deleteContact(int contact_no) {
		
		try {
			
			con = getConnection();
			sql = "DELETE FROM CONTACT_TBL WHERE CONTACT_NO = ?" ;
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			res = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		} 
		
		return res;
	}
	
	// CRUD 메소드 - 3 (이름을 이용한 연락처 조회하기)
	// 삭제 > 이름 입력 > 이름을 가진사람의 목록보고(select) > 삭제하기 위해!
	// 1. 반환값 : List<ContactDTO>
	// 					ㄴ 연락처 1개의 정보
	//				 ㄴ연락처가 여러개 나올 수 있으니
	// 2. 매개변수 : String name 변수에는 조회할 연락처으 이름이 저장되어 있다.
	public List<ContactDTO> selectContactsByName(String name) {
		// 					ㄴ여러개가 반환된다!
		
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		
		try {
			
			con = getConnection();
			sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) { // 조회결과가 있으면

				// rs 객체는 행 단위로 처리한다.
				ContactDTO contact = new ContactDTO();
				contact.setContact_no(rs.getInt("CONTACT_NO") );
				contact.setName(rs.getString("NAME")) ;
				contact.setTel(rs.getString("TEL") );
				contact.setEmail(rs.getString("EMAIL") );
				contact.setAddress(rs.getString("ADDRESS") );
				// >> 하나의 연락처가 되었음
				
				contactList.add(contact);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contactList;
		
	}
	
	// CRUD 메소드 - 4 (연락처 수정하기)
	// 1. 반환값   : 0(실패) 또는 1(성공)
	// 2. 매개변수 : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다..
	public int updateContact(ContactDTO contact) {
		
		try {
			
			con = getConnection();
			sql = "UPDATE CONTACT_TBL";
			sql += "	SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS = ?";		// 수정할 내용(모든정보)
			sql += " WHERE CONTACT_NO = ?"; // 조건: 번호
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setString(4, contact.getAddress());
			ps.setInt(5, contact.getContact_no());
			res = ps.executeUpdate();			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	// CRUD 메소드 - 5 (연락처 No를 이용한 연락처 조회하기)
	// 1. 반환값   : ContactDTO
	// 2. 매개변수 : int contact_no 변수에는 조회할 연락처의 고유 번호가 저장되어 있다.
	public ContactDTO selectContactByNo(int contact_no) {
	
		ContactDTO contact = null;
		
		try {
			
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			// ㄴ 결과가 한개 if
			if(rs.next()) { 
				contact = new ContactDTO();
				contact.setContact_no(contact_no); // 쿼리문 보고 이름이 아닌 순서대로 숫자로 적기!
				contact.setName(rs.getString(2) );
				contact.setTel(rs.getString(3) );
				contact.setEmail(rs.getString(4) );
				contact.setAddress(rs.getString(5) );
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contact;
	}
	// CRUD 메소드 - 6 (전체 연락처 조회하기)
		// 1. 반환값 : List<ContactDTO>
		// 2. 매개변수 : 없다.
		public List<ContactDTO> selectAllContacts() {
			
			List<ContactDTO> contactList = new ArrayList<ContactDTO>();
			
			try {
				
				con = getConnection();
				sql =  "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
				sql += "  FROM CONTACT_TBL";
				sql += "  ORDER BY CONTACT_NO DESC"; // 최근 등록한 연락처가 위로 올라오도록 (DESC 내림차순)
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) { // 조회결과가 있으면

					// rs 객체는 행 단위로 처리한다.
					ContactDTO contact = new ContactDTO();
					contact.setContact_no(rs.getInt("CONTACT_NO") );
					contact.setName(rs.getString("NAME")) ;
					contact.setTel(rs.getString("TEL") );
					contact.setEmail(rs.getString("EMAIL") );
					contact.setAddress(rs.getString("ADDRESS") );
					// >> 하나의 연락처가 되었음
					
					contactList.add(contact);
					
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return contactList;
			
		}
}
