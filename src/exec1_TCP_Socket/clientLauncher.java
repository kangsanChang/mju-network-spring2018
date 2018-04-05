package exec1_TCP_Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class clientLauncher {
	public static void main(String []args) {
		int serverPort = 10789;
		String serverIP = "127.0.0.1";
		Socket server = null;
	
		try {
			server = new Socket(serverIP, serverPort);
			
			if(server != null) {
				System.out.println(server.toString());
			}
			
			server.close();
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
