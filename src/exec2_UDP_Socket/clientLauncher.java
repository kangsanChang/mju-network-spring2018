package exec2_UDP_Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class clientLauncher {
	public static void main(String [] argv) {
		DatagramSocket socket = null; //UDP socket
		DatagramPacket packet = null; //UDP packet
		String text = "Hello, Socket programming"; //보낼 data
		byte[] buffer = text.getBytes(); //보낼 data의 길이
		String serverIP = "192.168.0.1";
		int serverPORT = 10789;
		
		
		try {
			socket = new DatagramSocket(); //UDP socket 생성
			//UDP packet생성.(보낼 곳을 명시) 
			packet = new DatagramPacket(buffer,buffer.length, InetAddress.getByName(serverIP), serverPORT);
			System.out.println(InetAddress.getByName(serverIP));
			System.out.println(InetAddress.getByName(serverIP).getClass());
			System.out.println(serverIP);
			System.out.println(serverIP.getClass());
			socket.send(packet); //packet을 보냄.
			System.out.println("sended Massege : " + text);
			socket.close(); //socket을 닫음.
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}