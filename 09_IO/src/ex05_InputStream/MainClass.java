package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


import ex04_OutputStream.Person;

public class MainClass {
	
	public static void ex01() {
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin"); //(경로, 파일명)
		
		FileInputStream fis = null; // fis 초기화
		
		try {
			
			fis = new FileInputStream(file); // fis 연결하는 스트림(통로)을 생성
		
			// 입력 단위
			// 1. int : 1개 입력
			// 2. byte[] : 2개 이상
			
			int c = 0;
			StringBuilder sb = new StringBuilder(); // StringBuilder 변경 가능한 문자열을 만들어줌
			while ((c = fis.read()) != -1) {
				sb.append((char) c); // append   StringBuilder 클래스의 Append 함수를 이용하여 builder 객체에 문자열을 이어붙인 후 꺼내는 방법
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	public static void ex02() {
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin"); //(경로, 파일명)
		
		FileInputStream fis = null;
		
		// 원래 깨져서 출력됨(바이트 스트림과 한글 처리의 문제 확인)
		
		try {
			fis = new FileInputStream(file);
			
			byte[] b = new byte[3]; // 한 번에 4바이트를 읽어 오시오.
			int readByte = 0; // 실제로 읽은 바이트를 저장해 두시오. (ex02.bin 마지막 읽어오는건 3바이트)
			StringBuilder sb = new StringBuilder();
			
			while ((readByte = fis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
				if(readByte == -1) {
					break;
				}
				System.out.println(sb.toString()); // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
													// (4바이트를 읽었다면 4개를, 3바이트를 읽었다면 3개를 사용한다.
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void ex02_complete() {
		// ex02 깨져서 출력되는거 해결법
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InputStreamReader
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin"); //(경로, 파일명)
		
		InputStreamReader isr = null;		
		
		try {
			isr = new InputStreamReader(new FileInputStream(file)); // FileReader처럼 사용하는것
			
			char[] cbuf = new char[4]; //  한 번에 4바이트를 읽어 오시오.
			int readCount = 0; // 실제로 읽은 글자수를 저장해 두시오.
			StringBuilder sb = new StringBuilder();
			
			while ((readCount = isr.read(cbuf)) != -1) {
				sb.append(cbuf,0,readCount); // 배열 cbuf의 인덱스 0부터 readCount개 데이터를 사용한다.
				}
				System.out.println(sb.toString()); // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
													// (4바이트를 읽었다면 4개를, 3바이트를 읽었다면 3개를 사용한다.

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	public static void ex03() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedInputStream bis = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] b = new byte[4];
			int readByte = 0;
			StringBuilder sb = new StringBuilder();
			
			while((readByte = bis.read(b)) != -1) {
				sb.append(new String(b, 0, readByte));
			}
			
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex03_complete() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			String line = null; 
			StringBuilder sb = new StringBuilder();
			
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n"); 
				}
				System.out.println(sb.toString());
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex04() {
		
		// 	String name, int age, double height, boolean isAlive 순으로 값이 저장된 ex04.dat
		
		File file = new File("C:" + File.separator + "storage", "ex04.dat");
		
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream(file));
			// 입력(변수 타입에 따라서 메소드가 다름)
			String name = dis.readUTF();          // writeUTF에 대응
			int age = dis.readInt();              // writeInt에 대응
			double height = dis.readDouble();     // writeDouble에 대응
			boolean isAlive = dis.readBoolean();  // writeBoolean에 대응);
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			System.out.println(isAlive);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex05() {
		
		// Person 객체가 3개 저장되어 있는 (List<Person> 2개, Person 1개) ex05.dat 파일
		
		File file = new File("C:" + File.separator + "storage", "ex05.dat");
		
		ObjectInputStream ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 입력
			//readObject 메소드는 Object를 반환하므로 적절하게 캐스팅 해야한다
			//List<Person> people = ois.readObject(); ↓ 캐스팅 해야한다
			@SuppressWarnings("unchecked") // List<Person>에 대한 오류 해결
			List<Person> people = (List<Person>)ois.readObject();
			Person person = (Person)ois.readObject();
		
			System.out.println(people); // →→ person에 toString 해줌
			System.out.println(person);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		ex01();

	}

}
