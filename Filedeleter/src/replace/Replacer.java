package replace;
import java.io.*;
import FileTraversal;

public class Replacer extends FileTraversal{

	private String replace,find;

	public void setReplace(String find, String replace){
		this.replace = replace;
		this.find = find;
	}

	@Override
	protected void onFile(File filePath){
		super.onFile(filePath);
		try {
			replace(filePath);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

	private void replace(File file) throws IOException{
			FileInputStream in = new FileInputStream(file);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			String s ;
			StringBuilder out=new StringBuilder();
			int isfount=0;

			while((s = bf.readLine()) != null){
				s += "\n";
				out.append(s);
			}
			int te = 0,index=0;
			while((te = out.substring(index).indexOf(find)) != -1){
				index += te;
				out.replace(index, index + find.length(), replace);
				index += replace.length();
				isfount++;
			}

			if(isfount > 0){
				System.out.println(file.getName() + " : " + isfount);
				FileOutputStream outf = new FileOutputStream(file);
				outf.write(out.toString().getBytes());
			}
		}
}
