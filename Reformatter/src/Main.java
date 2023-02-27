
import java.util.*;
import java.io.*;
public class Main {
	private static final char nl = '\n';
	private static String Str = "";
	private static int identation = 1;

	private static final char TAB = '\t';

	private static int ident;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream in = new FileInputStream("/storage/emulated/0/Html/bootstrap/js/bootstrap.min.js");
		FileOutputStream out = new FileOutputStream("/storage/emulated/0/dk.js");
		byte[] b=new byte[1024*8];
		int read=0;System.out.println("startex");
		while ((read = in.read(b)) > 0) {
			Str="";
			for (int i=0;i < read;i++)
				Str += (char)b[i];
			Str = (clearCode(Str));
			out.write(format().getBytes());
			System.out.println("8kb");
		}
		in.close();
		System.out.println("done");
	}

	private static String clearCode(String str) {
		String sb = "";
		boolean space2 = false;
		for (int i = 0;i < str.length();i++) {
			char t = str.charAt(i);
			switch (t) {
				case ' ':if (!space2 && !hasln(i + 1))
						sb += t;
					space2 = true;
					break;
				case TAB:
					space2 = false;
					break;
				default:
					space2 = t == nl;
					sb += t;
			}
		}
		return sb;
	}

	private static String format() {
		ident = 0;
		String s="";
		for (int i = 0;i < Str.length();i++) {
			char t = Str.charAt(i);
			switch (t) {
				case '{':
					ident += identation;
					s += t;
					if (!hasln(i + 1))
						s += (nl + getIdent(ident));
					break;
				case nl:
					s += nl;
					if (Str.charAt(i + 1) != '}')
						s += (getIdent(ident));
					break;
				case '}':
					ident -= identation;
					if (!hasln(i - 1))
						s += nl;
					s += (getIdent(ident) + t);
					//if (!hasln(i + 1))
						//s += (nl + getIdent(ident));
					break;
				default:
					s += t;
			}
		}
		return s;
	}

	private static boolean hasln(int i) {
		return Str.length() > i && Str.charAt(i) == nl;
	}

	private static String getIdent(int space) {
		if (space < 1)
			return "";
		return "\t" + getIdent(space - 1);
	}
}
