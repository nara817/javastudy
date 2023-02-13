package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class ApiMain {

	public static void main(String[] args) {


		try {
			
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml");
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				} else {
					reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				}
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			con.disconnect();
			// 포스트맨 http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000 확인하기
			// 응답데이터 확인
			System.out.println(sb.toString());
			 // 응답데이터(XML)를 JSON데이터로 변환하기●●●
			JSONObject obj = XML.toJSONObject(sb.toString());
			// System.out.println(obj); > 데이터 확인
			
			// pubDate 조회
			String pubDate = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getString("pubDate");
			// category 조회
			String category = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getString("category");
			System.out.println("category");
			
			// data 속성에 저장된 날씨 배열 가져오기
			JSONArray dataList = obj.getJSONObject("rss")
								.getJSONObject("channel")
								.getJSONObject("item")
								.getJSONObject("description")
								.getJSONObject("body")
								.getJSONArray("data");
			// 순회
			for (int i = 0; i < dataList.length(); i++) {
				JSONObject data = dataList.getJSONObject(i);
		//안나옴System.out.println(data.getInt("sky"));
		//안나옴System.out.println(data.getString("wdEn"));
				System.out.println(data.getInt("temp"));
				System.out.println(data.getString("wfKor"));
				System.out.println(data.getInt("hour"));
			}  // 시험때는 결과가 파일에 누적 될 수 있도록 하기? 위처럼 출력하면 안댐 ㅠ-ㅠ
			
			// 결과 파일 만들기
			BufferedWriter writer = new BufferedWriter(new FileWriter("weather.txt")); // 경로 지정없는 경우, 프로젝트에 생김!
			writer.write(pubDate + "\n");
			writer.write(category + "\n");
			writer.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} 

	}

}
