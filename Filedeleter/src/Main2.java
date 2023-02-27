
import java.util.*;
import java.util.function.*;
import java.util.regex.*;

public class Main2 
{
	public static void main(String[] a){
		d();
	}
	
	static void d(){
		String s = "12.2.4";
		Pattern p = Pattern.compile("[0-9].[0-9].[0-9]");
		Matcher m = p.matcher(s);
		if(m.find())
			for(String k:s.split("\\."))
				System.out.print(k);
		else System.out.println("nono");
		System.out.println("\ndone");
	}
}
