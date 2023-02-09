package ex03_Server_Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMainClass {
	// 클라이언트가 여러명 들어올 수 있음
	public static void main(String[] args) {
		 ServerSocket serverSocket = null; // 서버
		 Socket socket = null;			  // 클라이언트
		 
			try {

				serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress("localhost", 9090)); // 호스트가 localhost 포스트번호가9090인 서버 생성

				System.out.println("==채팅서버오픈==");

				while (true) {
					socket = serverSocket.accept(); // ClientMainClass 의 socket.connect() 요청을 받아주는
					System.err.println("접속한 클라이언트 정보 : " + socket.getInetAddress()); // 접속한 클라이언트의 ip주소 확인
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
