import java.io.*;
import replace.*;

public class wordReplacer extends FileTraversal{
	public static void main(String[] ar){
		Replacer fco = new Replacer();
		fco.setReplace("com.bat","com.bat2");
		fco.traverse(new File("/storage/sdcard1/AppProjects/Android/BatteryAlert 21/app/"));
		System.out.println("Done");
	}
	
}
