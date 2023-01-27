package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {
		
		// List<Map<String, Object>> products = Arrays.asList(product1, product2, product3); > 한줄씩으로 복원하기
		// C:/storage/product.csv 읽기
		
		File file = new File("C:" + File.separator + "storage","product.csv");
		//                   →                               → 여기까지 string
		
		BufferedReader br = null;
		try {
			
			br = new BufferedReader(new FileReader(file)); // 스트림 이름 br
			
			List<Map<String, Object>> products = new ArrayList<Map<String, Object>>();
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] items = line.split(","); // split을 쓰면 string반환
				// 세탁기, 삼성 ,100 > items0 세탁기 items1 삼성 items2 100
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);
				product.put("maker", items[1]);
				product.put("price", Integer.parseInt(items[2])); // items[2]가 아닌 string으로 변환해야함
				products.add(product); // 제품들에 제품 넣기				
			}
			System.out.println(products);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
