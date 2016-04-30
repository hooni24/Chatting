package chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("접속할 서버의 IP주소를 입력하세요 >");
			String ip = sc.nextLine();
			
			Socket client = new Socket(ip, 7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println("대화가 시작됩니다.");
			System.out.println("*주의사항 : 서로 한 번씩 주고 받아야만 합니다.");
			System.out.println("한 사람이 여러번 말하면 프로그램이 종료될 수 있습니다.");
			System.out.println();
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(client.isConnected()){
				System.out.print("나 >");
				String myMessage = sc.nextLine();
				dos.writeUTF(myMessage);
				
				System.out.printf("%n상대방의 입력을 기다리는 중입니다.%n");
				String serverMessage = dis.readUTF();
				System.out.println("상대 >" + serverMessage);
				System.out.println();
				
			}// 연결상태인 동안 무한루프.
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
