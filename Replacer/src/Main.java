import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		FileTraversal rp = new Replacer("com.leff.","leff.");
		rp.setOnStopListener(new OnInfo(){

				@Override
				public void onFound(String name) {
					System.out.println(name);
				}

				@Override
				public void onStop() {
					System.out.println("Done");
				}
			});
		try {
			rp.traverse(new File("/storage/emulated/0/AppProjects/Android/Midi/app/src/main/java"));
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}

