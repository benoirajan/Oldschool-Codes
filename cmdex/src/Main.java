import java.io.*;
import java.net.*;
import java.util.*;
import org.apache.http.*;
import org.apache.http.client.*;
import java.text.*;

public class Main {

	private static Process pro;
	public static void main(String[] args) {
		System.out.println(010);
		Scanner s = new Scanner(System.in);
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-ddd");
		System.out.println(sd.format(Calendar.getInstance().getTime()));
		System.out.println(String.format("%.1f", 48.455f));
		while (true) {
			try {
				System.out.print("$");
				run(s.next());
			}
			catch (IOException e) {System.out.println(e.getLocalizedMessage());}
		}
	}

	/**
	 Running cmd...
	 @param cmd is code
	 */
	private static void run(String cmd) throws IOException {
		pro = Runtime.getRuntime().exec(cmd, null, new File("/sdcard/"));
		println("Input  " , pro.getInputStream());
		println("Error  " , pro.getErrorStream());
	}

	private static void println(String cmd, InputStream ins) throws IOException {
		BufferedReader in = new BufferedReader(
			new InputStreamReader(ins));

		String line = "";
		boolean nill = false;
		while ((line = in.readLine()) != null) {
//			if (!nill)
//				System.out.println(cmd +" :");
//			nill = true;
			System.out.println(line);
		}
	}
	public void d(){
		
	}
}
