package mavencontrol;
import java.io.*;
import java.util.regex.*;
import FileTraversal;
import java.util.*;
import FileManager;

public class Limiter {

	private static Pattern p;

	private static FileManager fm;
	public static void main(String[] arg) {
		p = Pattern.compile("[0-9].[0-9]");
		Helper h = new Helper();
		fm =new FileManager();
		h.traverse(new File("/storage/emulated/0/Apps/gmaven_stable/"));
	}

	static class Helper extends FileTraversal {
		@Override
		protected void onDirectory(File dirPath) {
			super.onDirectory(dirPath);
			if(dirPath.listFiles().length==0)
				dirPath.delete();
			//System.out.println(dirPath);
			//deleteUnwant(dirPath.listFiles());
		}
		//public Helper init(){}
		private void deleteUnwant(File[] list) {
			System.out.println(list[0]);
			if (list[0].getName().length() > 3) {
				Matcher m = p.matcher(list[0].getName().substring(0,4));
				if (m.find()&&list.length>3) {
					Arrays.sort(list);
					for (int i=0;i<list.length-3;i++)
						fm.del(list[i]);
					System.out.println("\n");
				}
			}
		}
	}
}
