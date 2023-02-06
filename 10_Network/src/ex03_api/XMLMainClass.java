package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLMainClass {

	public static void ex01() {
		
		/*
			한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			2. 요청 변수(Request Parameter)
				1) serviceKey : 인증키
		*/
		
		String serviceKey = "u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null; // api로 부터 받아오는 입력 스트림
		BufferedWriter writer = null;
		
		try {
			
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"); // GET방식
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET"); // 반드시 대문자로!
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // 각 단어는 대문자로 시작 - 하이픈 
												// ㄴ UTF-8로 인코딩된 xml파일			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {  // 성공했을때 / HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));// 인풋스트림을 리더로 바꿔줌 InputStreamReader
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			// 입력받는 read(), read(char[] cbuf) 여러글자 한번에 받기, readLine() 한줄씩 받아오는거
			// BufferedReader > readLine() 사용
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString()); // 스트링빌더에 있는 모든 정보를 보냄
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex01_parse() {
		
		File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
		
		// xml 분석
		try {
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();   // <response> (최상위 태그)
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();  // <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);          // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes();        // <header>의 자식 태그(<resultCode>, <resultMsg>), <body>의 자식 태그(<items>, <numOfRows>, <pageNo>, <totalCount>)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					if(node2.getNodeName().equals("items")) {     // <items> 태그 대상
						NodeList items = node2.getChildNodes();   // <items>의 자식 태그(<item>)
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChildren = item.getChildNodes();        // <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
						}
					}
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		/*
			한국공항공사_항공기 운항정보 : 국제선 운항 스케쥴
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
			2. 요청 변수(Request Parameter)
				1) serviceKey : 인증키
				2) pageNo : 조회할 페이지번호
				3) schDate : 검색일자
				4) schDeptCityCode : 출발도시코드
				5) schArrvCityCode : 도착도시코드
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

	public static void ex02_parse() {
		
		File file = new File("C:" + File.separator + "storage", "국제선운항스케쥴.xml");
		
		// xml 분석
		try {
		
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			Element root = doc.getDocumentElement();   // <response> (최상위 태그)
			System.out.println(root.getNodeName());
			
			NodeList nodeList = root.getChildNodes();  // <response>의 자식 태그(<header>, <body>)
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);          // <header>와 <body>
				System.out.println("  " + node.getNodeName());
				NodeList nodeList2 = node.getChildNodes();        // <header>의 자식 태그(<resultCode>, <resultMsg>), <body>의 자식 태그(<items>, <numOfRows>, <pageNo>, <totalCount>)
				for(int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
					System.out.println("    " + node2.getNodeName());
					if(node2.getNodeName().equals("items")) {     // <items> 태그 대상
						NodeList items = node2.getChildNodes();   // <items>의 자식 태그(<item>)
						for(int k = 0; k < items.getLength(); k++) {
							Node item = items.item(k);
							System.out.println("      " + item.getNodeName());
							NodeList itemChildren = item.getChildNodes();        // <item>의 자식 태그
							for(int l = 0; l < itemChildren.getLength(); l++) {
								Node itemChild = itemChildren.item(l);
								System.out.println("        " + itemChild.getNodeName() + ":" + itemChild.getTextContent());
							}
						}
					}
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ex01_parse();
	}

}