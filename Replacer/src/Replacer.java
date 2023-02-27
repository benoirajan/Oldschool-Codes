import java.io.*;

public class Replacer extends FileTraversal {

	@Override
	protected void onStart(File path) {
	}


	private final String replace,find;
	public Replacer(String find, String replace) {
		this.replace = replace;
		this.find = find;
	}

	@Override
	protected void onFile(File filePath) throws IOException{
		replace(filePath);
	}

	private void replace(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		String s ;
		StringBuilder out=new StringBuilder();
		int isfount=0;

		while ((s = bf.readLine()) != null) {
			s += "\n";
			out.append(s);
		}
		int te = 0,index=0;
		while ((te = out.substring(index).indexOf(find)) != -1) {
			index += te;
			out.replace(index, index + find.length(), replace);
			index += replace.length();
			isfount++;
		}

		if (isfount > 0) {
			if (osl != null)
				osl.onFound(file.getName());
			FileOutputStream outf = new FileOutputStream(file);
			outf.write(out.toString().getBytes());
		}
	}
}
