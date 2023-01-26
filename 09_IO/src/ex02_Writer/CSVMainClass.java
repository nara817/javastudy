package ex02_Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {
		
		/*
			CSV
			1. Comma Separate  Values
			2. 쉼표(,)로 분리된 값들
			3. 확장자가 csv인 파일
			4. 기본연결프로그램은 엑셀
			5. 메모장으로 열어야 쉼표를 확인 가능(,기준으로 셀 분리되어 출력되어있는 파일)
				→ 공공데이터 받을때(한줄에 정보 하나씩)
		*/
		/*
		 	목표.
		 	1. 파일 경로
		 		C:/storage/product.csv
		 	2. 내용
		 		세탁기,삼성,100
		 		냉장고,LG,200
		 		TV,삼성,300
		*/
		Map<String,Object> product1 = new HashMap<>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String,Object> product2 = new HashMap<>();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String,Object> product3 = new HashMap<>();
		product3.put("model", "TV");
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		List<Map<String, Object>> products = Arrays.asList(product1, product2, product3);
				
	/*	List<Map<String, Object>> products = new Arrays.asList<Map<String, Object>>();
		products.add(product1);
		products.add(product2);
		products.add(product3);  위 식과 동일 */
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir,"product.csv");
		
		try (PrintWriter out = new PrintWriter(file)) {		

			for(int i = 0; i < products.size(); i++) {
				Map<String, Object> product = products.get(i);
				out.println(product.get("model") + "," + product.get("maker") + "," + product.get("price"));
			}
			
		/*	out.println(products.get(0)).get("model"))
			out.println(products.get(0)).get("maker"))
			out.println(products.get(0)).get("price"))  위 식과 동일 */
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
