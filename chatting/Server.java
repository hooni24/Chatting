package chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private DataOutputStream dos;
	private DataInputStream dis;
	Scanner sc = new Scanner(System.in);
	
	public Server(){
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 열렸습니다.");
			System.out.println("클라이언트 접속을 대기중입니다.");
			
			while(true){
				Socket client = server.accept();			//accept는 접속되면 Socket객체 반환
				System.out.println(client.getInetAddress() + "에서 접속했습니다.");
				System.out.println("대화가 시작됩니다.");
				System.out.println("*주의사항 : 서로 한 번씩 주고 받아야만 합니다.");
				System.out.println("한 사람이 여러번 말하면 프로그램이 종료될 수 있습니다.");
				System.out.println();
				
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
				
				while(true){
					System.out.printf("%n상대방의 입력을 기다리는 중입니다.%n");
					String clientMessage = dis.readUTF();
					System.out.println("상대방 >" + clientMessage);
					System.out.println();
					
					System.out.print("나 >");
					String myMessage = sc.nextLine();
					dos.writeUTF(myMessage);
				
				}//대화 주고 받는 무한루프 (연결되고 나서부터)
			
			}//while 무한루프 (서버 열리고 나서부터)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//server 생성자

	
	
	
	public static void main(String[] args) {
		new Server();
	}//main

}//class
