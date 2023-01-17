package ex03_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex04_SimpleDateFormat {

	
	/*
	 	형식
	 	1. yy	: 23(년도 2자리)
	 	2. yyyy : 2023
	 	3. M	: 1 (1~12) (월)
	 	4. MM 	: 01 (01~12) (월)
	 	5. MMM	: 1월(각 나라에 따라 상이 / 로컬화되어있음)
	 	6. d	: 17 (1~31)
	 	7. dd	: 17 (01~31)
	 	8. E 	: 화 (요일)
	 	9. a	: 오후
	 	10. h 	: 2 (1~12)(시)
	 	11. hh	: 02 (01~12) (시)
	 	12. H 	: 14 (0~23) (시)
	 	13. HH 	: 14 (00~23) (시)
//	 	14. m 	: 8 (0~59) (분)
	 	15. mm 	: 08 (00~59) (분)
	 	16. s 	: 30 (0~59) (초)
	 	17. ss 	: 30 (00~59) (초)
	 	
	 	ex)
	 	2023.01.03.18:11
	 	yyyy.MM.dd.HH:mm
	 */
	
	public static void main(String[] args) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm:ss");
		String strNow = sdf.format(now);
		System.out.println(strNow);

	}

}
