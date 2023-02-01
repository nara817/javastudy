package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class XMLMainClass {

	public static void ex01() {
		
		/* 한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			2. 요청변수(Request Parameter)
				1) serviceKey : 인증키
		
		*/
			
		String serviceKey = "u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null; // api로 부터 받아오는 입력 스트림
		BufferedWriter writer = null;
		
		try {
		apiURL+= "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"); // GET방식
		url = new URL(apiURL);
		con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET"); // 반드시 대문자로!
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // 각 단어는 대문자로 시작 - 하이픈 
												// ㄴ UTF-8로 인코딩된 xml파일
		int responseCode = con.getResponseCode(); 
		if(responseCode == 200) { // 성공했을때 reader // 200 > HttpURLConnection.HTTP_OK 동일
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));// 인풋스트림을 리더로 바꿔줌 InputStreamReader
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		
		// 입력받는 read(), read(char[] cbuf) 여러글자 한번에 받기, readLine() 한줄씩 받아오는거
		// BufferedReader > readLine() 사용
		while((line=reader.readLine()) != null) {
			sb.append(line);
		}
		
		reader.close();
		con.disconnect();
		// System.out.println(responseCode);  > 응답 확인1

	 File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
	 writer = new BufferedWriter(new FileWriter(file));
	writer.write(sb.toString()); // 스트링빌더에 있는 모든 정보를 보냄
	writer.close();
	
	System.out.println("공항코드정보.xml이 생성되었습니다.");
	 
	} catch(IOException e) {
		e.printStackTrace();
	}
	}
	
	public static void ex01_1() {
		
		String serviceKey = "u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==";//decoding
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
		URL url = null;
		HttpURLConnection con = null;  // api로 부터 받아오는 입력 스트림
		BufferedReader reader = null;
		
		try {
			
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));// GET방식
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");// 반드시 대문자로!
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");// 각 단어는 대문자로 시작 - 하이픈 
														// ㄴ UTF-8로 인코딩된 xml파일
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));// 인풋스트림을 리더로 바꿔줌 InputStreamReader
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader > readLine() 사용
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			System.out.println(sb.toString());  // 스트링빌더에 있는 모든 정보를 보냄
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		/* 한국공항공사_항공기 운항정보 : 국제선 운항 스케줄
		1. 서비스 URL : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
		2. 요청변수(Request Parameter)
			1) serviceKey : 인증키
			2) pageNo : 페이지 번호 (예 pageNo=1)
			3) schDate : 검색일자
			4) schDeptCityCode : 출발 도시 코드
			5) schArrvCityCode : 도착 도시 코드
	*/
	String serviceKey = "u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==";
	String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
	URL url = null;
	HttpURLConnection con = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	
	try {
		
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		apiURL += "&pageNo=1";
		apiURL += "&schDate=20230201";
		apiURL += "&schDeptCityCode=ICN";
		apiURL += "&schArrvCityCode=JFK";
		url = new URL(apiURL);
		con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		
		int responseCode = con.getResponseCode();
		if(responseCode == 200) {  // HttpURLConnection.HTTP_OK이 200을 의미한다.
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
		
		File file = new File("C:" + File.separator + "storage", "국제선운항스케쥴.xml");
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(sb.toString());
		writer.close();
		
		System.out.println("국제선운항스케쥴.xml이 생성되었습니다.");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
}

public static void main(String[] args) {
	ex02();
}

}
