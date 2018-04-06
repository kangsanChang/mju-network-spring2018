package exec2_UDP_Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class serverLauncher {
	public static void main (String []args) {
		int port = 108789;
		DatagramSocket socket;
		DatagramPacket packet;
		byte[] buffer = new byte[1024];
	
		try {
			socket = new DatagramSocket(port);
			packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			
			String text = new String(packet.getData());
			System.out.println("received Message : " + text);
			System.out.println("packet length : " + text.length());
			
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
