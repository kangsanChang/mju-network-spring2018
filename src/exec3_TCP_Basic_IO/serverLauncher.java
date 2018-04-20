package exec3_TCP_Basic_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverLauncher {
	public static void main(String[] argv) {
		Socket client = null;
		ServerSocket server = null;
		PrintWriter printWriter;
		BufferedReader bufferedReader;
		int port = 10789;
		
		try {
			server = new ServerSocket(port);
			client = server.accept();
			
			if(client!=null) {
				System.out.println(client.toString());
			}
			
			printWriter = new PrintWriter(client.getOutputStream(), true);
			bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while (true) {
				String msg = bufferedReader.readLine();
				System.out.println("From Client : " + msg);
				if(msg.equals("bye")){
					System.out.println("disconnect");
					break;
				}
				printWriter.println("message("+msg+") is received");
			}
			printWriter.println("server is disconnecting");
			client.close();
			server.close();
		} catch (IOException e){
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
