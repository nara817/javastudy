package ex03_Server_Client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMainClass {

	// 서버 하나와 클라이언트 둘이 대화도 가능(Client 두번 돌리면 됨)
	public static void main(String[] args) {
		
		Socket socket = null;
		BufferedWriter writer = null; // 서버로 텍스트를 보내는 출력 스트림
		Scanner sc = null;
		
		try {
			
			socket = new Socket();
			socket.connect( new InetSocketAddress("localhost", 9090)); // 서버 주소는 localhost이고, 포트번호는 9090이다
		
		// socket 정보를 이용하는 클라이언트를 스레드로 생성(로컬호스트 9090으로 접속 할 수 있는 클라이언트를..)
			Client client = new Client(socket); // localhost:9090 서버로 연결 할 수 있는 socket 정보를 넘김
			client.start(); // 클라이언트 스레드 실행(서버로 텍스트 보내기, 무한루프로 보낼 수만 있음=독립개체)
			
			
		sc = new Scanner(System.in);
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//텍스트를 보내주는 write, socket은 바이트기반
		
		while (true) {
			System.out.println(">>>"); 
			String message = sc.nextLine(); // 채팅 내용을 입력
			writer.write(message + "\n"); // 서버가 엔터까지 입력으로 인식할 수 있도록 \n을 추가해서 보냄
		}

	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
}