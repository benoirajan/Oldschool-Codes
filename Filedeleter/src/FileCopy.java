import java.io.*;

public class FileCopy
{
	protected int file=0,dir=1;
	protected float size=0;
	private int name;
	protected boolean isfirst=true,running=false;

	void copy(File from, File to)
	{
		if (isfirst)
		{
			name = from.getAbsolutePath().indexOf(from.getName());
			isfirst = false;
			running=true;
		}
		File[] files;
		if (from.isDirectory())
		{
			files = from.listFiles();
			for (File f:files)
				if (f.isDirectory() && f.canRead())
				{
					dir++;
					copy(f, to);
					paste(f, to);
				}
				else if (f.isFile()){
					file++;
					size+=f.length() / (1024.0 * 1024);
					paste(f, to);
				}
		}
	}
	private void paste(File from, File to)
	{
		to = new File(getpath(to, from));
		if (from.isFile())
		{
			if (!to.exists())
				to.getParentFile().mkdirs();
			try
			{
				FileInputStream fin=new FileInputStream(from);
				FileOutputStream fo=new FileOutputStream(to);
				byte[] in=new byte[1024];
				int read;
				while ((read = fin.read(in, 0, 1024)) != -1)
					fo.write(in, 0, read);
			}
			catch (IOException e)
			{
				System.out.println(e.getLocalizedMessage());
			}
		}
		else if (!to.exists())
		{
			to.mkdirs();
		}
	}

    private String getpath(File to, File from)
	{
		String p=from.getAbsolutePath();
		return to + "/" + p.substring(name);
	}
	public void reset1()
	{
		file=0;
		dir=1;
		size=0;
	}
	void reset(){
		running=false;
		isfirst=true;
	}
}
