package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		try {
			//요청메세지 - Call Back URL - 요청 주소 넣고 > ●●포스트맨으로 확인●● > api주소 넣고, 밑에 요청변수 키랑 벨류값 입력 후 > send
		// API 주소 완성
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
			apiURL += "?serviceKey=" + URLEncoder.encode("u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==", "UTF-8"); // Decoding 키
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8");
			apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8");
			apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8");
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8");
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8");
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");
			
		// URL 객체 생성(API주소의 형식 검증)
			URL url = new URL(apiURL);
			
		// API 주소 접속
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// GET 방식의 요청임을 처리
		con.setRequestMethod("GET"); // Rest(GET) 주소창에 주렁주렁 달아서 요청하는 방식
		
		// 응답 데이터는 "json"임을 처리
		// 웹 상에서 주고 받는 데이터 타입 : Content_Type
		con.setRequestProperty("Content-Type", "application/json"); // ; charset=UTF-8 생략도 가능
		
		// 접속된 API로 부터 데이터를 읽어 들일 입력 스트립 필요
		// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
		// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요
		// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
		BufferedReader reader = null;
		if(con.getResponseCode() == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		// BufferedReader는 readLine 메소드를 지원한다.
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		// 이제 API의 응답 데이터는 sb에 저장되어 있다.
		// System.out.println(sb.toString()); // > 값 잘나왔는지 중간 점검!
		
		// API의 응답 데이터를 분석하기 위해서 JSONObject로 변환한다.
		// json 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
		
		JSONObject obj = new JSONObject(sb.toString()); // obj는 전체 내용을 뜻함("resultCode"~ 부터 ...)
		JSONObject items = obj.getJSONObject("items");  // obj에서 items 빼고
		JSONArray itemList = items.getJSONArray("item");  // items에서 item[] 배열 빼고
		
	/*	JSONArray itemList = new JSONObjct(sb.toString())
								.getJSONObject("items")
								.getJSONArray("item");
		위 3줄과 동일 */
		// item 리스트에서 필요한 정보 for문 돌려서 추출!
		List<Accident> list = new ArrayList<Accident>();
		for (int i = 0; i < itemList.length(); i++) {
			// 응답 데이터에서 필요한 데이터를 분석(파싱)한다.
			JSONObject item = itemList.getJSONObject(i); // 요소 하나하나가 JSONObject
			// 응답데이터 확인 > 발생월일시, 발생요일코드, 사망자수, 부상자수
			String occrrncDt = item.getString("occrrnc_dt");
			String occrrncDayCd = item.getString("occrrnc_day_cd");
			int dthDnvCnt = item.getInt("dth_dnv_cnt");
// 											ㄴ응답데이터의 이름은 못바꿈!			
			int injpsnCnt = item.getInt("injpsn_cnt"); // 응답데이터의 이름은 못바꾸지만, 변수이름은 변경가능
// 				ㄴ변수 이름! 임의로 바꿀 수 있음(밑줄 없애고, 대문자로 바꿔주기!)	
			// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)로 만든다.
// 4개의 데이터를 1개의 데이터로 1) Bean 또는  2) Map으로 만들어야함!
//  > Accident 클래스를 생성(해당 4개의 필드값을 지정) > Bean
			Accident accident = new Accident();
			accident.setOccrrncDt(occrrncDt);
			accident.setOccrrncDayCd(occrrncDayCd);
			accident.getDthDnvCnt(dthDnvCnt);
			accident.setDthDnvCnt(injpsnCnt); //  이걸 안만들고 Map 만들어도됨
			// 객체를 ArrayList에 저장한다.
			list.add(accident);
		}
// 	Accident 9개를 1곳에 모아둘 수 있는 자료 Array List
		
	
	} catch(Exception e) {
		e.printStackTrace();
	}

}

}		
		
			/*reader.close();
			con.disconnect();

			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			JSONArray items = body.getJSONArray("items");

			for (int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String occrrnc_dt = item.getString("occrrnc_dt");
				String occrrnc_day_cd = item.getString("occrrnc_day_cd");
				String dth_dnv_cnt = item.getString("dth_dnv_cnt ");
				String injpsn_cnt = item.getString("injpsn_cnt"); 
				System.out.println("발생일자 " + occrrnc_dt + occrrnc_day_cd + "요일" + ", 사망자수 " + dth_dnv_cnt + " 명"
						+ ", 부상자수 " + injpsn_cnt);

			}

		} catch (MalformedURLException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
} */
