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
			StringBuilder sbURL = new StringBuilder(); //String 문장을 이어 붙일 수 없기 때문에 StringBuilder선언(객체append+객체append)
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 요청변수 필수값serviceKey 
			sbURL.append("&returnType=json"); // 필수값은아니지만, json타입으로 무조건 해야함
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // 요청변수 필수값
			
			url = new URL(sbURL.toString()); // 위에서 append한 객체들을 toString 불러내,  URL문자열 형태로 저장
	//		URLConnection urlcon =  url.openConnection();
			con = (HttpURLConnection) url.openConnection(); // openConnection(url 안에 있는 통신을 위한 메소드) > URL패키지 클레스에 url 생성, 정보를 가져오기위해
			// HttpURLConnection 에 con 생성,  con에서 url메소드인 openConnection를  HttpURLConnection(클래스)로 형변환 하고, con에 담는다
			// url 주소를 openconnection 사용해서 httpurlconnection 형태로 변환하여 con에 담음 
			//url.openConnection() 객체가 생성됨
			
			con.setRequestMethod("GET"); // 요청주소에 나와있음 통신 고정값
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // 통신 고정값
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) { //getResponseCode(통신결과 값)이 정상 
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));//연결이냐 
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));//아니냐
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
				String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
				URL url = null;
				HttpURLConnection con = null;
				BufferedReader reader = null;
				
				try {
					
					StringBuilder sbURL = new StringBuilder();
					sbURL.append(apiURL);
					sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
					sbURL.append("&returnType=json");
					sbURL.append("&searchDate=2023-01-30");
					
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
					JSONArray items = new JSONObject(sb.toString())
										.getJSONObject("response")
										.getJSONObject("body")
										.getJSONArray("items");
					for(int i = 0; i < items.length(); i++) {
						JSONObject item = items.getJSONObject(i);
						System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
						System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoCn"));
						System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeCn"));
						System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourCn"));
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

	public static void ex03() { //측정소별 실시간 측정정보 조회
		
		
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ=="; // 일반 인증키(Decoding)값
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"; // 요청주소
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		try {
			
			String stationName = "종로구";
			String dataTerm = "Daily";
			StringBuilder sbURL = new StringBuilder(); //String 문장을 이어 붙일 수 없기 때문에 StringBuilder선언(객체append+객체append)
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 요청변수 필수값serviceKey 
			sbURL.append("&returnType=json"); // 필수값은아니지만, json타입으로 무조건 해야함
			sbURL.append("&stationName=" + URLEncoder.encode(stationName, "UTF-8")); // 요청변수 필수값
			sbURL.append("&dataTerm=" + URLEncoder.encode(dataTerm, "UTF-8")); // 요청변수 필수값
			
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET"); // 요청주소에 나와있음 통신 고정값
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // 통신 고정값
			
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
				String khaiValue = item.getString("khaiValue");
				String so2Value = item.getString("so2Value");
				String coValue = item.getString("coValue");
				if(Double.parseDouble(coValue) >= 0.8) {
					
				System.out.println(khaiValue + ": 아황산가스 농도 -" + so2Value + ", 일산화탄소 농도 - " + coValue);				
				
			}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ex03();
	}

}