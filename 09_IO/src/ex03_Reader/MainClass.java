package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class MainClass {
	
	/*
	 ex01 더이상 보여줄 문자가 없을때 멈춤 2풀이
	  + StringBuilder을 이용해 한번에 여러개를 읽어 들일 수 있도록
	 */
	
	/*
	 Reader 
	 1. 문자 기반의 입력 스트림이다. 
	 2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다. 
	 3. 문자를 읽어 들이는 스트림이다.(파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다. 등등)
	 */

	public static void ex01() { // 학습용 잘안씀
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file); // 리더가 스트림을 뜻함, 입력 스트림 이름이 fr

			int c;
			
			StringBuilder sb = new StringBuilder();	
			while ((c = fr.read()) != -1) { // 더이상 보여줄 문자가 없을때 멈춤 2풀이
				sb.append((char)c);
			}
			System.out.println(sb.toString());
			
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
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			
			char[] cbuf = new char[5]; //5글자를 읽어 들이는 배열
			
			int readCount = 0; // 실제로 읽은 글자의 개수
			
			while((readCount = fr.read(cbuf))!=-1) {
				
				// ex2. txt 읽는 과정(abcedfg > txt내용
				// 루프 readCount	cbuf
				// 1	5			a b c d e
				// 2	2			f g c d e >> 5개 저장 후, 2개를 더 저장 시킴 > fg출력 후 > cde는 건들이지 않고, 그대로 남아있는 상태
				// 3 	-1
				
				for(int i = 0; i < readCount; i++) { // 배열의 사이즈 length가 들어가면 안댐
					System.out.println(cbuf[i]);
				}
			}
		} catch (IOException e) {
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
	public static void ex02_1() {
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			
			char[] cbuf = new char[5]; //5글자를 읽어 들이는 배열
			
			int readCount = 0; // 실제로 읽은 글자의 개수
			StringBuilder sb = new StringBuilder();
											
			while((readCount = fr.read(cbuf))!=-1) {
				
				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount개 글자를 sb에 추가하시오./ offset 0 고정값 총7글자만 
				
				// ex2. txt 읽는 과정(abcedfg > txt내용
				// 루프 readCount	cbuf
				// 1	5			a b c d e
				// 2	2			f g c d e >> 5개 저장 후, 2개를 더 저장 시킴 > fg출력 후 > cde는 건들이지 않고, 그대로 남아있는 상태
				// 3 	-1
				
				//for(int i = 0; i < readCount; i++) { // 배열의 사이즈 length가 들어가면 안댐
					//System.out.println(cbuf[i]);
				//}
			} // while 
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
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
	
	public static void ex03() { 
		
		/*
			BufferReader의 장점
			1. 속도가 빠르다.
			2.  readLine 메소드를 사용 할 수 있다.(한줄씩만 읽어 들이는(전체에서 부분만)ReadLine 메소드)
		*/

		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}

		File file = new File(dir, "ex03.txt");

		BufferedReader br = null;

		try {

			br = new BufferedReader(new FileReader(file)); // 속도 향상 스트림
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) { // -1이 아닌 null / 글자 배열이 정해진게x
				sb.append(line);
			}
			
			System.out.println(sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
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
