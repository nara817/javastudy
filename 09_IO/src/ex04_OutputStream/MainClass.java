package ex04_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


public class MainClass {

	/*
	OutputStream
		int  → 데이터를 하나씩 내보낼때
		byte[ ] → 바이트기반 스트림으로 바이트배열 / 여러 데이터를 내보낼때(정수단위)


	*/
	
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex01.bin");
		
		// 스트림 선언
		FileOutputStream fos = null;
		
		// 생성
		try {
			
			fos = new FileOutputStream(file); // 파일 출력 통로 fos(int,byte[ ]만 보낼 수 있음) 
			
			// 출력 단위
			// 1. int : 1개 출력
			// 2. byte[] : 2개 이상 출력
			
			int c = 'A';
			String str = "pple";
	/*★★★*/		byte[] b = str.getBytes(); //byte[] b = {}'p','p','l','e'} → 예)처리불가 / 문자 cahr 2byte, byte는 1byte이므로
										// getBytes → "pple"스트링 배열을 알아서 바이트 배열로 바꿔줌
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() { // 한글 데이터(인코딩 필요)를 바이트 스트림으로 내보낼때
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			// getBytes(Charsets charsets)
			byte[] b = str.getBytes(StandardCharsets.UTF_8); // utf-8인코딩해서 만들어달라(UTF_8 한글 하나가 3byte)
			// getBytes(String charsetName)
			// byte[] b = str.getBytes("UTF-8");
			
			fos.write(b);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트");// 파일 사이즈 확인하는 코드
		
	}
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir,"ex03.bin");
		
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
		/* fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(bos); ↓↓ 하위 식과 동일 가능한 아래 식으로 사용*/
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8"));
			// ← bos.close(); 해당 위치에 작성 가능 finally포함 하위 내용 적을 필요 없음
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ex03.bin 파일의 크기 : " + file.length() + "바이트");// 파일 사이즈 확인하는 코드
	}
	
	public static void ex04() {
		
		// byte 스트림중 output 스트림
		// 변수를 그대로 출력하는 DataOutputStream(보조스트림 Buffer처럼 사용) 
		// 한글처리할때(String) 주로 마니 사용됨
		File dir = new File("C:" + File.separator + "storage");
		
		File file = new File(dir,"ex04.dat"); // 확장자가 달라져도 상관 없음(bin)
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream(file));
			
			// 출력할 변수
			String name = "에밀리";
			int age = 30;
			double height = 180.5;
			boolean isAlive = true;
			
			// 출력 (변수타입에 따라서 메소드가 다름)
			dos.writeUTF(name);
			dos.write(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);

			// dos.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (dos != null) {
					dos.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("ex04.dat 파일의 크기 : " + file.length() + "바이트");// 파일 사이즈 확인하는 코드
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutputStream
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 출력할 객체
			List<Person> people = Arrays.asList(
				new Person("에밀리", 30, 180.5, true),
				new Person("제시카", 35, 190.5, true)
			);
			
			// 출력할 객체
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 출력
			oos.writeObject(people);
			oos.writeObject(person);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ex05.dat 파일의 크기 : " + file.length() + "바이트");
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}

