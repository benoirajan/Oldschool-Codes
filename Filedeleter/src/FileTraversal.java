import java.io.*;

public class FileTraversal {

	private boolean isfirst = true;

	private boolean terminate;

	public void traverse(File path) {
		terminate = false;
		get(path);
		onStop(path);
		terminate =  true;
	}

	private void get(File path) {
		if (isfirst) {
			onStart(path);
			isfirst = false;
		}
		if (terminate)
			return;
		if (path.isDirectory()) {
			File[] files = path.listFiles();
			for (File f:files)
				if (f != null)
					if (f.isDirectory() && f.canRead())
						onDirectory(f);
					else if (f.isFile())
						onFile(f);
		}
	}
	protected void onFile(File filePath) {
	}

	protected void onDirectory(File dirPath) {
		get(dirPath);
	}

	protected void onStart(File path) {
	}

	private void onStop(File path) {
	}

	public void terminate() {
		terminate = true;
	}
}
