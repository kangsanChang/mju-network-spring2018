package exec3_TCP_Basic_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLauncher {
	public static void main (String []argv) {
		Socket server = null;
		int port = 10789;
		String ip = "127.0.0.1";
		BufferedReader getMsgFromUser; //키보드로부터 유저의 입력을 받아들이는 객체
		PrintWriter printWriter; //서버로 출력 담당 객체
		BufferedReader bufferedReader; //서버로 부터의 입력 담당 객체 
		String msg = "";
		try {
			server = new Socket(ip, port); //server socket에 연결
			// 입출력 객체 생성.
			getMsgFromUser = new BufferedReader(new InputStreamReader(System.in));
			printWriter = new PrintWriter(server.getOutputStream(), true);
			bufferedReader = new BufferedReader(new InputStreamReader(server.getInputStream()));
			if (server != null) {	//접속 성공 시 상태 출력. 
				System.out.println(server.toString());
			}
			while (true) { //무한 루프를 돌며 입출력. 
				System.out.print("To Server : ");
				msg = getMsgFromUser.readLine();
				printWriter.println(msg);
				if (msg.equals("bye")) { //bye 입력 시 연결 종료.
					msg = bufferedReader.readLine();
					break;
				}
				msg = bufferedReader.readLine();
				System.out.println(msg); 
			}
		System.out.println(msg);
		System.out.println("Now client disconnect");
		server.close(); //접속 종료
		} catch (UnknownHostException e) {
		  e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
