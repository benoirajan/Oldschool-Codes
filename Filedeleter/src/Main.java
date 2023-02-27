import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main
{
	public static void main(String[] args)
	{
		final FileManager fm=new FileManager();
		File f=new File("/storage/sdcard0/SongBook1.0_source_from_JADX");
	    File f2=new File("/storage/sdcard1/");
		File f3=new File("/storage/sdcard1/SongBook1.0_source_from_JADX");
		new Thread(new Runnable(){

				@Override
				public void run()
				{
					int a=0;
					while (true)
					{
						try
						{
							Thread.sleep(1000);
						}
						catch (InterruptedException e)
						{}
						System.out.println("Dirs : " + fm.getDirCount() + " File : " + fm.getFileCount() + " Size : " + fm.getSize() + "MB");
						if (!fm.running)
							a++;
						if (a > 1){
							fm.reset1();
							break;
						}
					}
				}
			}).start();
		
			long l=System.currentTimeMillis();
			//fm.del(f3);
		    fm.copy(f,f2);
			fm.reset();
			l=System.currentTimeMillis()-l;
			l/=1000;
			System.out.println(l+"s");
			System.out.println("Done");
		//fm.getAll(f);
	}
}
