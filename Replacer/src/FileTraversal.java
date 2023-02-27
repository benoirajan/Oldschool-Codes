
import java.io.*;

public class FileTraversal extends FileCallback {

	@Override
	protected void onFile(File filePath)throws IOException{
		//---------_----------£+£+£8£
		osl.onFound(filePath.getName());
	
	}

	@Override
	protected void onStart(File path) {
	}

	protected OnInfo osl;
	private boolean isfirst = true;
	public void traverse(File path)throws IOException {
		get(path);
		onStop(path);
	}

	private void get(File path) throws IOException {
		if (isfirst) {
			onStart(path);
			isfirst = false;
		}
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File f:files)
				if (f.isDirectory() && f.canRead())
					onDirectory(f);
				else if (f.isFile())
					onFile(f);
		}
	}

	protected void onDirectory(File dirPath) throws IOException {
		get(dirPath);
	}

	private void onStop(File path) {
		if (osl != null)
			osl.onStop();
	}

	public void setOnStopListener(OnInfo ol) {
		osl = ol;
	}
}

