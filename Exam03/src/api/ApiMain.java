package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		String serviceKey = "u5NYolr9xhMJVumYYhOWVBgfivzHscgIUbweuM3c7Eim3n2QFG35by9KMCobAwYMcPyQjTyt/etTOG37cclejw==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath"; // 요청주소

		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		try {

			String siDo = "서울특별시";
			String guGun = "금천구";
			String searchYear = "2021";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&siDo=" + URLEncoder.encode(siDo, "UTF-8"));
			sbURL.append("&guGun=" + URLEncoder.encode(guGun, "UTF-8"));

			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}

			reader.close();
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
}
