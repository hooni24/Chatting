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
			System.out.print("������ ������ IP�ּҸ� �Է��ϼ��� >");
			String ip = sc.nextLine();
			
			Socket client = new Socket(ip, 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			System.out.println("��ȭ�� ���۵˴ϴ�.");
			System.out.println("*���ǻ��� : ���� �� ���� �ְ� �޾ƾ߸� �մϴ�.");
			System.out.println("�� ����� ������ ���ϸ� ���α׷��� ����� �� �ֽ��ϴ�.");
			System.out.println();
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(client.isConnected()){
				System.out.print("�� >");
				String myMessage = sc.nextLine();
				dos.writeUTF(myMessage);
				
				System.out.printf("%n������ �Է��� ��ٸ��� ���Դϴ�.%n");
				String serverMessage = dis.readUTF();
				System.out.println("��� >" + serverMessage);
				System.out.println();
				
			}// ��������� ���� ���ѷ���.
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
