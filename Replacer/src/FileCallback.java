import java.io.*;

abstract public class FileCallback 
{
	abstract protected void onFile(File filePath)throws IOException;
	abstract protected void onStart(File path);
}
