import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
		//Dependency dependency = new Dependency("com.android.tools.build", "gradle", "4.0.0", "jar");
		Dependency dependency = new Dependency("com.android.tools.build", "gradle", "3.5.0", "jar");
        Dependency dependency2 = new Dependency("com.google.android.gms", "play-services-ads", "19.5.0", "aar");
        Maven m = new Maven();
        // https://maven.google.com/com/google/android/gms/play-services-ads/18.3.0/play-services-ads-18.3.0.aar
        m.setRepo("https://maven.google.com/");
		m.setRepo("https://repo1.maven.org/maven2/");
		m.setRepo("https://jcenter.bintray.com/");
		//m.setPath("/sdcard/Android/ad");
		m.setPath("/sdcard/gradle");
		File file = new File(m.getPath()+"/maven-out.txt");
		PrintStream stream = new PrintStream(file);
		System.setOut(stream);
		m.get(dependency);
		System.err.print("Done");
    }
}
