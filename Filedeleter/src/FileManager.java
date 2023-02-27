import java.io.*;
import java.util.*;

public class FileManager extends FileCopy
{
	private File delPath;
	OnFileListener onFile;

	void getAll(File path)
	{
		if(isfirst){
			running = true;
		}
		   
		File[] files;
		if (path.isDirectory())
		{
			files = path.listFiles();
			for (File f:files)
			{
				if (f.isDirectory() && f.canRead())
				{
					dir++;
					getAll(f);
				}
				else if (f.isFile())
				{
					file++;
					size += f.length() / (1024.0 * 1024);
					if(onFile!=null)
						onFile.onFile(f);
				}
			}
		}
	}

	public void del(File path)
	{
		if(isfirst)
		{
			running=true;
			delPath=path;
			isfirst=false;
		}
		File[] files;
		if (path.isDirectory())
		{
			files = path.listFiles();
			for (File f:files)
				if (f.isDirectory() && f.canRead())
				{
					dir++;
					del(f);
					f.delete();
				}
				else if (f.isFile()){
					file++;
					size += f.length() / (1024.0 * 1024);
					f.delete();
				}
		}
		delPath.delete();
	}

	public void setOnFileListener(OnFileListener onfl){
		onFile=onfl;
	}
	@Override
	void reset()
	{
		// TODO: Implement this method
		delPath=null;
		super.reset();
	}
	
	int getFileCount()
	{
		return file;
	}
	int getDirCount()
	{
		return dir;
	}
	float getSize()
	{
		return size;
	}
}
