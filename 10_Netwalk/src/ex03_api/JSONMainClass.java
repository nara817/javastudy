package ex03_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void ex01() { // 시도별 실시간 측정정보 조회
		
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ=="; // 일반 인증키(Decoding)값
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"; // 요청주소
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 요청변수 필수값
			sbURL.append("&returnType=json"); // 필수값은아니지만, json타입으로 무조건 해야함
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // 요청변수 필수값
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
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
			
			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			JSONArray items = body.getJSONArray("items");
			
			// items안에 JSONObject 20개의 Property를 가지고있는 객체가 10개
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i); // i를 하나씩 꺼내오기 / JSONObject타입을 가져올땐 캐스팅 필요
				String stationName = item.getString("stationName");
				String pm10Value = item.getString("pm10Value");
				String o3Value = item.getString("o3Value");
				System.out.println(stationName + ": 미세먼지 -" + pm10Value + ", 오존농도 - " + o3Value);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 첫째날~넷째날예보
	// 첫째날~넷째날예보일시
	
	public static void ex02() { // 초미세먼지 주간예보 조회
		// 필수값 
				// 서비스키 serviceKey
				
				String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ=="; // 일반 인증키(Decoding)값
				String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth"; // 요청주소
				URL url = null;
				HttpURLConnection con = null;
				BufferedReader reader = null;
				
				try {
					
					String sidoName = "서울";
					StringBuilder sbURL = new StringBuilder();
					sbURL.append(apiURL);
					sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 요청변수 필수값
					sbURL.append("&returnType=json"); // 필수값은아니지만, json타입으로 무조건 해야함
					sbURL.append("&searchDate=2023-01-30"); // 조회날짜 샘플데이터 참고 2020-11-09
					
					url = new URL(sbURL.toString());
					con = (HttpURLConnection) url.openConnection();
					
					con.setRequestMethod("GET");
					con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
					
					if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
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
					
					System.out.println(sb.toString());
					JSONObject obj = new JSONObject(sb.toString());
					JSONObject body = obj.getJSONObject("response").getJSONObject("body");
					JSONArray items = body.getJSONArray("items");
					
					for(int i = 0; i < items.length(); i++) {
						JSONObject item = items.getJSONObject(i); // i를 하나씩 꺼내오기 / JSONObject타입을 가져올땐 캐스팅 필요
						String presnatnDt = item.getString("presnatnDt");
						String frcstOneCn = item.getString("frcstOneCn");
						String frcstOneDt = item.getString("frcstOneDt");
						String frcstThreeCn = item.getString("frcstThreeCn");
						String frcstFourCn = item.getString("frcstFourCn");

						//System.out.println(presnatnDt + ": 첫째날예보 -" + frcstOneCn + ", 둘째날예보 - " + frcstOneDt + ", 셋째날예보 - " + frcstFourCn + ", 넷째날예보 - ");
						
						
						
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	public static void main(String[] args) {
		ex02();
	}

}