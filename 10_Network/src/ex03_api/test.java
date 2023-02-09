package ex03_api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class test { // JSON이란 키와 벨류 값으로 이루어진 클래스

	public static void ex01() { // 시도별 실시간 측정정보 조회
		
		/*
		File file = new File("C:" + File.separator + "storage3", "test0207.json");
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) !=null) {
				sb.append(line);
		
*/
		String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ=="; // 일반 인증키(Decoding)값
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"; // 요청주소
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null; // 빨리 읽기 위한 
		
		try { 
			
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder(); //String 문장을 이어 붙일 수 없기 때문에 StringBuilder선언
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 요청변수 필수값serviceKey 
			sbURL.append("&returnType=json"); // 필수값은아니지만, json타입으로 무조건 해야함
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // 요청변수 필수값
			
			url = new URL(sbURL.toString()); // URL이 STRING값이 아니기에 문자열로 반환
			con = (HttpURLConnection) url.openConnection(); // HttpURLConnection 이랑 URL을 연결!(CON) /정보를 가져오기위해(HttpURLConnection 에서 쓸 수 있는 메소드를 사용 할수 있음)
			con.setRequestMethod("GET"); // 요청주소에 GET있음!> 요청방식 (포스트방법은 수정방식)
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder(); // InputStream은 문자를 못읽기 떄문에 StringBuilder선언
			while((line = reader.readLine()) != null) { // LINE이 빈값이 아니라면 이어준다
				sb.append(line); // 이어준 값은 sb에 담고 
			}
			
			reader.close(); // 종료
			con.disconnect(); // 종료(연결을 끊는 객체)
			
			System.out.println(sb.toString()); //String 변환 >> 이거 출력시 나옴 아래 response,body,items
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			JSONArray items = body.getJSONArray("items"); // >> items 부터는 배열이기때문에, 각각 분리해서response+body 담아서  JSONArray로 담아줌 생성됨 
			
			// items안에 JSONObject 20개의 Property를 가지고있는 객체가 10개
			for(int i = 0; i < items.length(); i++) { // JSONArray items의 길이 만큼
				JSONObject item = items.getJSONObject(i); // 각의 item을 objct로 만들어서 i를 하나씩 담아줌 / JSONObject타입을 가져올땐 캐스팅 필요
				String stationName = item.getString("stationName"); // 프로퍼티와 벨류가 있음, 프로퍼티속의 값을 가져오는것으로  
				String pm10Value = item.getString("pm10Value");
				String o3Value = item.getString("o3Value");
				System.out.println(stationName + ": 미세먼지 -" + pm10Value + ", 오존농도 - " + o3Value);
				
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void main(String[] args) {
		ex01();
	}

}