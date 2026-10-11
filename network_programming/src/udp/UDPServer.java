package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	static int count;
	public static void main(String[] args) {
		try(DatagramSocket datagramSocket = new DatagramSocket(8080);){
			byte[] b = new byte[1024];
			DatagramPacket dp = new DatagramPacket(b, b.length);
			while(true) {
				if(count>=100) {
					break;
				}
				datagramSocket.receive(dp);
				System.out.println("The message received from the client to the server: " + new String(dp.getData(), 0, dp.getLength()));
				count++;
			}	
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
