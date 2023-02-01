package ex02_socket;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


/*
실행 순서
ServerMain 실행 > ClientMain 실행
 */
public class ClientMainClass {
	
	

	public static void main(String[] args) {
		
		// Socket : 클라이언트가 사용하는 Socket
		Socket socket = null;
		
		try {
			
			socket = new Socket();
			
			// InetSocketAdress : 접속할 서버의 정보를 이용해서 생성
			InetSocketAddress address = new InetSocketAddress("localhost", 9090);
			
			// 서버에 접속
			socket.connect(address); // IOException 처리가 필요
			
			System.out.println("[클라이언트] 접속 성공");
			
			// 서버가 보낸 welcome 메시지 확인하기
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String welcomeMessage = in.readUTF(); 
			System.out.println("[클라이언트] " + welcomeMessage);
			
			// 서버에게 메시지 보내기(클라이언트가 보내줌, socket>Output(바이트)사용>Writer(문자)로 변환 필요+Buffer
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.write("반갑습니다!");
			
			// 스트림 종료
			out.close();
			in.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket.isClosed() == false) {
				}
			} catch(Exception e) {
				e.printStackTrace();
				}
			}
		}

	}

