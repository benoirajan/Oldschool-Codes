import java.net.*;
import java.io.*;

/**
  * This program demonstrates a simple TCP/IP socket client.
  *
  * @author www.codejava.net
  */
public class Clie {
	
	public static void main(String[] args) {

		int port = 6868;
		 String host="192.168.137.1";
		
		try {
			Socket socket = new Socket(host, port);
		

			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String time = reader.readLine();
			System.out.println(time);
		}
		catch (IOException e) {}
		
	}
}
