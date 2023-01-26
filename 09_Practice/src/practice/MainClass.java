package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import jdk.tools.jaotc.collect.classname.ClassNameSource;

public class MainClass {

	// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시)
	// C:\14\31\30
	public static void ex01() {
		
		LocalTime now = LocalTime.now();
		
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
	}
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
	/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
	*/
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
		
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
				if(file.isHidden()) {
					continue;
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size = new DecimalFormat("#,##0").format(length);
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
			}
			System.out.println(fileCount + "개 파일 " + new DecimalFormat("#,##0").format(totalFileSize) + " 바이트"); // #,##0 천단위 경로
			
		}
		
	}
	
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		/* 저장된 파일이 myfile.txt 뿐이라는 걸 알고 있어서 이런 코드가 나왔죠.
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		*/

		// 이건 저장된 모든 파일을 지운다는 코드입니다.(디렉터리는 없다는 가정이요.)
		File[] files = dir.listFiles();
		if(files != null) {			
			for(File file : files) {
				if(file.isFile()) {
					file.delete();
				}
			}
		}
		
		if(dir.exists()) {
			dir.delete();
		}
		
	}
	
	
	// 문제4. C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력 받아서 보내시오.(Scanner사용) 1)스트링 배열 포문 돌리기 2) 배열 안만들고 입력 받자마자 바로 보내기 5번
	public static void ex04() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sentences = new String[5]; // 5문장 입력
		System.out.println("5문장을 입력하세요.");
		for (int i = 0; i < sentences.length; i++) {
			sentences[i] = sc.nextLine(); // next는 띄어쓰기xxx
		}

		File dir = new File("C:" + File.separator + "storage");
		if (dir.exists() == false) {
			dir.mkdirs();
		}

		File file = new File(dir, "diary.txt");

		try (PrintWriter out = new PrintWriter(file)) {
			for (int i = 0; i < sentences.length; i++) {
				out.println(sentences[i]);
			}

			System.out.println("diary.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt 파일을 생성하시오.
	// 예시)
	// 2023-01-26 12:08:30 / by zero
	// try catch , 파일만드는 코드는 catch에 있어야함
	// 예외 1.5와 같은 실수 입력시
	public static void ex05() {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수를 입력하세요 >>> ");
		int number1 = sc.nextInt();
		
		System.out.print("두 번째 정수를 입력하세요 >>> ");
		int number2 = sc.nextInt();
		
		int add = number1 + number2;
		int sub = number1 - number2;
		int mul = number1 * number2;
		int div = number1 / number2;
		
		System.out.println(number1 + "+" + number2 + "=" + add);
		System.out.println(number1 + "-" + number2 + "=" + sub);
		System.out.println(number1 + "*" + number2 + "=" + mul);
		System.out.println(number1 + "/" + number2 + "=" + div);

		sc.close();
	
	} catch(Exception e) {
		
		// 날짜
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTime = dtf.format(now);
		
		// 예외 클래스 이름
		String className = e.getClass().getName();
		
		// 예외 메시지
		String message = e.getMessage();
		
		// 로그 파일 만들기
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "log.txt");
		
		// 생성 모드(언제나 새로 만든다.)    new FileWriter(file)
		// 추가 모드(기존 내용에 추가한다.)  new FileWriter(file, true)
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			
			bw.write(dateTime + " " + className + " " + message + "\n");
			// bw.newLine();  \n을 대신할 수 있는 코드
			
			System.out.println("예외 메시지가 log.txt 파일에 기록되었습니다.");
			
		} catch(IOException e2) {
			e2.printStackTrace();
		}
		
	}
	
}
	
	public static void main(String[] args) {
		ex05();
	}

}