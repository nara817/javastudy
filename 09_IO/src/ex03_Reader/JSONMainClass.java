package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void main(String[] args) {
		
		
		File file = new File("C:" + File.separator + "storage", "product.json");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) !=null) {
				sb.append(line);
				
			}
			
			JSONArray arr = new JSONArray(sb.toString()); //JSONArray 배열 이름 arr 새로 생성 > 
			// → List로 바꾸기 일반 for문이나 향상 for문으로 
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			for(int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				products.add(obj.toMap()); // JSON obj를 Map으로 바꿔서 List에 저장하기 → toMap
			}
			System.out.println(products);
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
