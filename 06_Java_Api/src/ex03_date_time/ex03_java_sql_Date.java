package ex03_date_time;

import java.sql.Date;

public class ex03_java_sql_Date {

	public static void main(String[] args) {
		
		// Oracle 데이터베이스와 호환되는 java.sql.Date
		// 2023-01-17
		Date now = new Date(System.currentTimeMillis());
		System.out.println(now);
				

	}

}
