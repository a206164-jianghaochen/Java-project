package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {
	public static void main(String[] args) {
		
		try(ServerSocket serverSocket = new ServerSocket(8080);){
			System.out.println("=== TCP Server started; waiting for client dial-in connection... ===");
			
			Socket socket = serverSocket.accept();
			System.out.println("The client has successfully connected: " + socket.getInetAddress().getHostAddress());
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] b = new byte[1024];
			
			while(true) {
				
			int len = is.read(b);
			if (len == -1) {
                System.out.println("Client has closed the connection. Server exiting...");
                break;
            }
			String clientMsg = new String(b, 0, len, StandardCharsets.UTF_8);
            System.out.println("Received from client: " + clientMsg);
			String reply = "Server echoes: " + clientMsg;
            os.write(reply.getBytes(StandardCharsets.UTF_8));
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
