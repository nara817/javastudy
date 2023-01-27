package ex02_Writer;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLMainClass {
	
	/*
		XML
		1. eXtensible Markup Language
		2. HTML(표준 마크업 언어)의 확장 버전
		3. 정해진 태그 외 사용자 정의 태그의 사용이 가능하다
	*/
	
	/*
 	목표.
 	1. 파일 경로
 		C:/storage/product.XML → Document 문서라고 한다 / 문서를 객체화 하는 방식(dom처리방식)
 	2. 내용
 		<products> → 시작태그
			 <product>
				<model>세탁기</model>
				<maker>삼성</maker>
	 			<price>100</price>
			</products>
			<product>
				<model>냉장고</model>
				<maker>LG</maker>
				<price>200</price>
			</products>
			<product>
				<model>TV</model>
				<maker>삼성</maker>
				<price>300</price>
			</products>
 		</products> → 종료태그
 		products ~ /products e1
 		product ~ /product e2
 		model ~ /price e3
 		e2이 e1의 자식
 		e3이 e2의자식
 		
	Element :products,product,model,maker,price → 해당 태그들을 Element한다
	태그사이 텍스트(예:세탁기, 삼성..등) : textContient라고 부름 → text() 메소드
	 */

	public static void main(String[] args) {
		
		Map<String,Object> product1 = new HashMap<String, Object>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String,Object> product2 = new HashMap<String, Object>();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String,Object> product3 = new HashMap<String, Object>();
		product3.put("model", "TV");
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		List<Map<String, Object>> productList = Arrays.asList(product1, product2, product3);

		try {
			
			// Document 생성(Document는 XML문서 자체를 의미한다.) ↓팩토리패턴
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // 공장 만들기
			DocumentBuilder builder = factory.newDocumentBuilder(); // Document 만드는 builder 만듬
			Document document = builder.newDocument();
			
			// <products> 태그 : Element 생성
			Element products = document.createElement("products"); // Element는 document가 만듬
			document.appendChild(products);
			
			// productList순회 반복문 향상for문
			for(Map<String, Object> map : productList) {
				// <product> Element 생성 
				Element product = document.createElement("product");
				products.appendChild(product);
				
				// <model> Element 생성 
				Element model = document.createElement("model");
				product.appendChild(model);
				model.setTextContent((String) map.get("model")); // textContient / 반환타입이 key: model인 Value: Object / String 타입인데 Object 되어있어서 
				// setTextContent→ String을 요구함
				// map.get("model")) → ((String) map.get("model")) 변환 또는 toString도 가능
				
				// <maker> Element 생성 
				Element maker = document.createElement("maker");
				product.appendChild(maker);
				maker.setTextContent((String)map.get("maker"));
				// setTextContent→ String을 요구함
				
				// <price> Element 생성 
				Element price = document.createElement("price");
				product.appendChild(price);
				price.setTextContent((int) map.get("price")+""); // 또는 ((String) map.get("price"))
				// setTextContent→ String을 요구하기때문에 int아님 String 

			}
			
			// XML 설정
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer(); 
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.setOutputProperty("indent", "yes");// 들여쓰기 intent
			transformer.setOutputProperty("doctype-public", "yes");  // standalone="no" 제거하기 위해서 document.setXmlStandalone(true);를 추가하면 개행(줄바꿈)이 안 되므로 추가한 코드
			
			// XML 문서 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
				
				File file = new File(dir, "product2.xml");
				Source source = new DOMSource(document);
				StreamResult streamResult = new StreamResult(file);
				transformer.transform(source, streamResult);
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
