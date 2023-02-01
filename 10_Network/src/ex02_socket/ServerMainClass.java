package ex02_socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMainClass {
	
	
	/*
	InputStream
	OutputStream > 한글 처리 못함
	
	> 1. InputStreamReader, OutputStreamWriter로 변환해서 한글 처리하기(2번보단 1번이 대중적으로 많이 사용됨)
	> 2. DataInputStream의 readUTF, DataOutputStream의 writeUTF로 한글 처리하기
	
	*/

	public static void main(String[] args) {
		
		// ServerSocket : 서버가 사용하는 Socket
		ServerSocket serverSocket = null;
		
		try {
			
			serverSocket = new ServerSocket(); // IOException 처리가 필요하다.
		
			// IntSocketAddress : Socket 사용 시 "호스트", "포스트번호(FTP)"를 관리하는 클래스
			// (같은 포스트번호를 쓰면 서로 통신 가능, 다른 번호는 통신 불가)
			InetSocketAddress address = new InetSocketAddress("localhost", 9090); // 호스트이름,포스트번호 정수 
																				// 완성되는주소 - localhost:9090
			// bind : SereverSocket에 InetSocketAddress 정보전달 - localhost:9090이 서버 주소이다.
			serverSocket.bind(address);
			
			// 무한루프로 serverSocket 구성
			while(true) {
				
				 System.out.println("[서버] 클라이언트 접속을 기다리고 있습니다.");
				
				// 클라이언트의 접속 요청을 허용
				Socket clientSocket = serverSocket.accept(); // localhost:9090 아무도 접속을 안하면, 계속 여기서 실행중(누군가 해당 호스트로 접속 할때 까지기다리고있음)
				
				// 클라이언트의 접속 확인을 위해서 InetSocketAddress를 활용
				InetSocketAddress clientAddress = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
				System.out.println("[서버] 접속된 클라이언트 : " + clientAddress.getHostName());
				
				// 클라이언트에게 welcome 메시지 보내기
				DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); // 접속한 클라이언트로 데이터를 보내는 출력 스트림 / 클라이언트가 다수인경우, serverSocket 사용x
				out.writeUTF("어서오세요 환영합니다!"); // writerUTF 메소드를 이용하면 바이트 스트림으로도 한글 깨짐 없이 데이터를 보낼 수 있다.

				// 클라이언트가 보낸 메시지 확인하기(반갑습니다 writer로 오는거 받아서 출력)
				
				
				
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String line = null;// 여러줄을 보낼 수도 있음(줄단위로)
				StringBuilder sb = new StringBuilder();
				while((line = in.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				System.out.println("[서버] " + sb.toString());
				
				
				// 스트림 종료
				out.close();
				in.close();
				
				// 클라이언트 접속 종료(생략 가능, 클라이언트 메인에서 함)
				clientSocket.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket.isClosed() == false) { // serverSocket이 열려있으면
					serverSocket.close(); // serverSocket 닫아라
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
