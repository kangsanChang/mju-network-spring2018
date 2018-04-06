package exec1_TCP_Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverLauncher {
	public static void main (String []args) {
		// 192.168.43.132
		Socket client = null; // client 와 연결되는 socket
		ServerSocket server = null; // 접속을 받는 server socket
		int port = 10789; // local port number
		
		try {
			server = new ServerSocket(port); 
			client = server.accept(); 
			
			if(client != null) { // Connected
				System.out.println(client.toString());
			}
			
			client.close();
			server.close();
		} catch(IOException e) {	// Error occurred
			e.printStackTrace();
		} finally {
			if(client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(server != null) {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
