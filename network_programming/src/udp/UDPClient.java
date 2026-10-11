package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args)  {
		
		try(DatagramSocket datagramSockect = new DatagramSocket();
				Scanner sc = new Scanner(System.in);
				){
			while(true) {
			System.out.println("Client: Please enter a message you want to send: ");
			String data = sc.nextLine();
			if("666".equals(data)) {
				System.out.println("The client exited.");
				break;	
			}
			byte[] b = data.getBytes();
			DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getByName("localhost"), 8080);
			datagramSockect.send(dp);
			System.out.println("Message has been sent successfully.");
			}	
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
