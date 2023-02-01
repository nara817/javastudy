package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.w3c.dom.Text;

public class MainClass2 {

	/*
	 * URl 1. uniform Resource Locator 2. 정형화된 자원의 경로 3. 실제로는 웹 주소를 의미한다.(인터넷주소) 4.
	 * 구성 포로토콜:// 호스트 / 서버경로 ?파라미터=값&파라미터=값&...
	 * https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr
	 * =9&acq=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90&qdt=0&ie=utf8&query=삼성전자
	 * HyperText Transfer Protocol secure 1) 프로토콜 : 통신규약, https(secure(=인증서) + http
	 * : 보안처리된 하이퍼텍스트 전송 프로토콜) 2) 호스트 : 서버의 대표 주소 3) 서버경로 : URL Mapping(URL Pattern)
	 * → 개발자가 만드는 경로 / 서버를 빌리는거(=호스팅서비스) ?은 하나만 나올 수 있음, 2개가 있으면 잘못된 주소 4) 파라미터 :
	 * 서버로 보내는 데이터를 의미(변수라고 생각하면 된다.)(주소?...&...&...&) where=nexearch → 첫번째 파라미터
	 * requst.getParnater("where") query 이하는 → 삼성전자의 인코딩된 데이터 호스트 / 서버경로 ? 파라미터
	 * query
	 */

	public static void ex01() {

		// 주소
		/* ★ */ String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		// URL처리를 위한 URL 클래스
		/* ★ */ URL url = null; // url을 사용하려면 필수 예외처리 필요

		try {

			url = new URL(apiURL); // 반드시 예외 처리 필요한 코드

			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());

		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		}

	}

	public static void ex02() {

		// 웹 접속을 담당하는 HttpURLConnection
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;

		try {

			/* ★ */ url = new URL(apiURL);
			// MalformedURLException 처리가 필요하다.
			/* ★ */ con = (HttpURLConnection) url.openConnection(); // IOException 처리가 필요하다.
			// url.openConnection(); > 처리불가 HttpURLConnection 캐스팅

			/*
			 * HTTP 응답 코드 공부하기 1. 200 : 정상 2. 40X (예 401 402..404)400번대: 잘못된 요청(사용자가 잘못하였음)
			 * / 404:주소 틀렸음 3. 50X 500번대 : 서버측 오류(서버가 잘못하였음) / 자바 코드 잘못 짜면..;;
			 * 
			 */
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK); // = 200(정상)대신 사용되기도함
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND); // 404
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR); // 500 내부 에러

			// apiURL 접속 확인
			int responseCode = con.getResponseCode(); // 응답 코드는 숫자로 나오기때문 int 사용
			// con 접속 정보를 담고있는 객체
			if (responseCode == 200) {
				System.out.println(apiURL + "접속 완료");
			}

			// 요청방식(요청 메소드) 확인
			String reauestMetod = con.getRequestMethod();
			System.out.println("요청 방식 : " + reauestMetod);

			// 컨텐트타입(웹상에서 주고 받는 데이터의 타입)
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType); // text/html; charset=UTF-8 ★외우기

			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent"); // getRequestProperty 헤더의 키값이 무엇인가?
			System.out.println("User-Agent : " + userAgent); // → 지금은 자바로 접속함 (예 크롬브라우져 > 네이버닷컴 접속 → 크롬으로 접속했다는 정보가
																// userAgent)
			// ㄴ 사람인지 여부를 판단 가능(메크로 프로그램 등)

			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer); // 이전 주소가 나옴(Referer이 아닌 직접 파라미터를 전달해주는 방식도 쓰임)
			// ㄴ(예 네이버>웹툰>로그인>로그인시도>웹툰페이지 다시열림(하지만,대부분 메인대문페이지로 이동함))

			// 접속 종료
			con.disconnect(); // 생락도 가능

		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			System.out.println("apiURL 접속 오류");
		}

	}

	public static void ex03() { // 다운로드 프로그램(바이트파일을 대상했으므로, 모든파일 가능)

		// 다음 로고 이미지(이미지 주소로 복사)
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;

		InputStream in = null; // 이미지(다음 로고) Daum 로그를 읽어 들이는 입력 스트림

		// 파일작업
		FileOutputStream out = null;// C:\storage\daum.png로 내보내는 출력 스트림

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 접속 되었다면 작업을 수행하겠다

				in = con.getInputStream();
				out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum.png");
				// ㄴ 파일 클래스 없이, 스트림값을 전달하여 처리

				byte[] b = new byte[10];
				int readByte = 0; // 10바이트 읽기로 했지만, 10바이트가 아닐 수 있으니 readByte 필요

				while ((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte); // b배열의 인덱스 0부터 readByte 만큼만
				}

				System.out.println("다운로드 완료");

				out.close();
				in.close();
				con.disconnect();
			}
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
	}

	public static void ex03_1() { // ex03 문제 동일 BufferedInputStream 사용하여속도 향상

		// 다음 로고 이미지(이미지 주소로 복사)
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;

		BufferedInputStream in = null; // 이미지(다음 로고) Daum 로그를 읽어 들이는 입력 스트림

		// 파일(디렉터리 작업)
		BufferedOutputStream out = null;// C:\storage\daum.png로 내보내는 출력 스트림
		File file = new File("C:" + File.separator + "storge", "daum.png");

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection(); // HttpURLConnection 캐스팅

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {

				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));

				byte[] b = new byte[10];
				int readByte = 0;

				while ((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);
				}
				System.out.println("다운로드 완료");

				out.close();
				in.close();
				con.disconnect();
			}
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ex04() { // 문서 내려받기

		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;

		InputStreamReader reader = null; // 읽어 들이는 리더가 필요
		FileWriter writer = null; // 파일과 연결 라이터 필요
		File file = new File("C:" + File.separator + "storage", "다운로드문서.txt");

		try {

			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Connection Reader와 Writer 사용x > IntputStreamReader(바이트 입력 스트림을 문자 입력 스트림으로
				// 변환)
				/* ★★ */ reader = new InputStreamReader(con.getInputStream()); // 문자스트림은 char 변환 필요 / 성공했을땐 정상스트림
			} else {
				reader = new InputStreamReader(con.getErrorStream()); // ErrorStream 콘솔창에 출력시, / 아닌경우 에러스트림을 만들겠다.
			}

			// 파일 복사 다운로드 프로그램
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2]; // 2글자씩 읽어라
			int readCount = 0; // 실제로 읽어들인 글수

			while ((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount 만큼만 사용하겠다
			}

			writer = new FileWriter(file);
			writer.write(sb.toString());

			writer.close();
			writer.close();
			con.disconnect();

			System.out.println("다운로드 완료");

		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static void ex04_1() { // ex03 문제 동일 BufferedInputStream 사용하여속도 향상
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null; // 입력 스트림

		BufferedWriter writer = null; // 출력 스트림(디렉토리로 내보내는)
		
		File file = new File("C:" + File.separator + "storage","다운로드문서.txt");
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				// Connection Reader와 Writer 사용x > IntputStreamReader(바이트 입력 스트림을 문자 입력 스트림으로 변환)
	/*★★*/		reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 문자스트림은 char 변환 필요 / 성공했을땐 정상스트림
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); // ErrorStream 콘솔창에 출력시, / 아닌경우 에러스트림을 만들겠다.
			}
			
			// 파일 복사 다운로드 프로그램 
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2]; // 2글자씩 읽어라
			int readCount = 0; // 실제로 읽어들인 글자수
			
			
			while ((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount 만큼만 사용하겠다
			}

			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());

			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println("다운로드 완료");
			
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ex04_2() { // ex04 문제 동일 주소오류, 다운로드 실패
																	// 주소가 상이, 다운로드 실패
	String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/_63d8848f7d506.txt"; 
	URL url = null;
	HttpURLConnection con = null;
	
	BufferedReader reader = null;
	BufferedWriter writer = null;
	File file = null;
	
	try {
		
		url = new URL(apiURL);
		con = (HttpURLConnection) url.openConnection();
		
		String message = null;
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
			message = "다운로드 성공";
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			file = new File("C:" + File.separator + "storage", "다운로드실패.html");
			message = "다운로드 실패";
		}
		
		StringBuilder sb = new StringBuilder();
		char[] cbuf = new char[2];
		int readCount = 0;
		
		while((readCount = reader.read(cbuf)) != -1) {
			sb.append(cbuf, 0, readCount);
		}
		
		writer = new BufferedWriter(new FileWriter(file));
		writer.write(sb.toString());
		
		writer.close();
		reader.close();
		con.disconnect();
		
		System.out.println(message);
		
	} catch(MalformedURLException e) {
		System.out.println("apiURL 주소 오류");
	} catch(IOException e) {
		e.printStackTrace();
	}
	
}
	public static void ex05() { // UFF-8 인코딩해서 보내주는
		
		/*
		 query=djf&fdaskfjdslakfj&... > query= 삼성
		인코딩(암호화) : 원본 데이터를 UTF-8 방식으로 암호화
		디코딩(복호화) ㅣ UFT-8 방식으로 암호화된 데이터를 복원
		*/
		
	String data = "한글 english 12345 !@#$%";
	
	try {
		
		// 인코딩
		String encodeData = URLEncoder.encode(data, "UTF-8");
		System.out.println(encodeData);
		
		// 디코딩
		String decodeData = URLDecoder.decode(encodeData, "UTF-8");
		System.out.println(decodeData);
		
	} catch (UnsupportedEncodingException e) {
		System.out.println("인코딩 실패");
	}
		
	}
	
	public static void ex06() { // 연습
		
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		
		
	}
	
public static void main(String[] args) {
	ex06();
}

}
