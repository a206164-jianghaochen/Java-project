package ipaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
			String hostName = inetAddress.getHostName();
			String addr = inetAddress.getHostAddress();
			System.out.println(hostName);
			System.out.println(addr);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
