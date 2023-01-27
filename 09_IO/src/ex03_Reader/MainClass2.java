package ex03_Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 ex01 더이상 보여줄 문자가 없을때 멈춤 2풀이
 */
public class MainClass2 {
	
	/*
	 Reader 
	 1. 문자 기반의 입력 스트림이다. 
	 2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다. 
	 3. 문자를 읽어 들이는 스트림이다.(파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다. 등등)
	 */

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;

		try {

			fr = new FileReader(file); // 리더가 스트림을 뜻함, 입력 스트림 이름이 fr
			
			int c;
			while (true) {

				c = fr.read();

				if (c == -1) {
					break; // 더이상 보여줄 문자가 없을때 멈춤
				}
				System.out.print((char) c);
			}
			
		/*	int c = fr.read(); // int로 주고받기로 약속했음 char X
			c = fr.read(); // 계속해서 반복시 read가 -1이 나올 경우 더이상 보여 줄게 없다는 뜻 */
			
//			System.out.println((char)c); // 받을땐 int지만 보여줄땐 char로 보여주겠다 → ((char)c) 문자열로 출력해줌 예) I
			
		} catch (IOException e) { // FileNotFoundException 이 함께 처리된다.
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public static void main(String[] args) {
		ex01();

	}

}
