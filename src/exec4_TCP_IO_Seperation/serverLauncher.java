package exec4_TCP_IO_Seperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverLauncher {
	public static void main (String []argv) {
		Socket client = null;
		ServerSocket server = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		int port = 10789;
		String msg = "";
		
		try {
			server = new ServerSocket(port);
			client = server.accept();
			
			if (client != null) {
				System.out.println(client.toString());
				bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				printWriter = new PrintWriter(client.getOutputStream(), true);
				
				while(true) {
					msg = bufferedReader.readLine();
					System.out.println("From client : " + msg);
					if(msg.equals("bye") ) {
						System.out.println("Disconnect");
						printWriter.println("bye");
						break;
					}
					printWriter.println("msg(" + msg + ") is received");
				}
			}
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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
