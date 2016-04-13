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
			System.out.println("������ ���Ƚ��ϴ�.");
			System.out.println("Ŭ���̾�Ʈ ������ ������Դϴ�.");
			
			while(true){
				Socket client = server.accept();			//accept�� ���ӵǸ� Socket��ü ��ȯ
				System.out.println(client.getInetAddress() + "���� �����߽��ϴ�.");
				System.out.println("��ȭ�� ���۵˴ϴ�.");
				System.out.println("*���ǻ��� : ���� �� ���� �ְ� �޾ƾ߸� �մϴ�.");
				System.out.println("�� ����� ������ ���ϸ� ���α׷��� ����� �� �ֽ��ϴ�.");
				System.out.println();
				
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
				
				while(true){
					System.out.printf("%n������ �Է��� ��ٸ��� ���Դϴ�.%n");
					String clientMessage = dis.readUTF();
					System.out.println("���� >" + clientMessage);
					System.out.println();
					
					System.out.print("�� >");
					String myMessage = sc.nextLine();
					dos.writeUTF(myMessage);
				
				}//��ȭ �ְ� �޴� ���ѷ��� (����ǰ� ��������)
			
			}//while ���ѷ��� (���� ������ ��������)
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//server ������

	
	
	
	public static void main(String[] args) {
		new Server();
	}//main

}//class
