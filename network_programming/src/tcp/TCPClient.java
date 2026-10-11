package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		
		try(Socket socket = new Socket("localhost", 8080);
			Scanner sc = new Scanner(System.in)){
			
			OutputStream os = socket.getOutputStream();
			
			InputStream is = socket.getInputStream();
			byte[] b = new byte[1024];
			
			while(true) {
			System.out.println("Client: Please enter a message (type '666' to exit): ");
			String data = sc.nextLine();
			if("666".equals(data)) {
				System.out.println("Client exiting...");
				break;
			}
			os.write(data.getBytes(StandardCharsets.UTF_8));
			int len = is.read(b);
			if (len == -1) {
                System.out.println("Server disconnected.");
                break;
            }
			System.out.println("Received server's reply: " + new String(b, 0, len, StandardCharsets.UTF_8));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
