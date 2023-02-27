
import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Maven {
	private static final String POM = ".pom";
	private String path;
	private List<String> urls,repo;

	public Maven() {
		urls = new ArrayList<String>();
		repo = new ArrayList();
	}

	public void setPath(String p) {
		path = p;
	}

	public String getPath() {
		return path;
	}

	public void setRepo(String url) {
		repo.add(url);
	}

	public void get(Dependency dep) {
		if (urls.contains(dep.toString())) {
			return;
		}
		urls.add(dep.toString());
		parse(dep);
	}

	private void parse(Dependency dep) {
		String p = save(dep, POM);
		save(dep, "." + dep.type);
		if (p != null)
			parseFile(p);
	}

	private void parseFile(String p) {
		//System.err.println("Parsing.. " + p);
		try {
			File inputFile = new File(p);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("dependency");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (eElement != null) {
						Dependency td = new Dependency();
						Node elem = eElement.getElementsByTagName("groupId").item(0);
						if (elem != null)
							td.group = elem.getTextContent();
						elem = null;
						elem = eElement.getElementsByTagName("artifactId").item(0);
						if (elem != null)
							td.artifact = elem.getTextContent();
						elem = null;
						elem = eElement.getElementsByTagName("version").item(0);
						td.version = "1.0";
						if (elem != null)
							td.version = elem.getTextContent();
						else System.err.println("err "+td.artifact);
						Node telem =  eElement.getElementsByTagName("type").item(0);
						if (telem == null)
							td.type = "jar";
						else
							td.type = telem.getTextContent();
						get(td);
					}
				}
			}
		}
		catch (Exception e) {
			File f = new File(p).getParentFile();
			//for (File tf : f.listFiles())
			//tf.delete();
			System.err.println(p);
			System.err.println(e.getMessage());
		}
	}

	private String save(Dependency dep, String type) {
		// downloading code
		
		String folder = path + '/' + dep.toUrl();
		File f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		String file = folder + dep.getFileName() + type;
		Exception err=new Exception("");
		for(String r:repo)
		try {
			String url = r + dep.toUrl() + dep.getFileName() + type;
			if (new File(file).exists()) {
				//System.err.println("File exists!");
				return file;
			}
			URL Url = new URL(url);				
			URLConnection uc=Url.openConnection();
			uc.connect();
			BufferedInputStream in = new BufferedInputStream(uc.getInputStream());
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
			System.err.println(new File(file).getName() + " " + (int)(new File(file).length() / 1024) + "KB");
			return file;
		}
		catch (IOException e) {
			err = e;
			File t = new File(file);
			if (t.exists())
				t.delete();
		}
		System.err.println("download failed");
		System.err.println(err.getMessage());
		return null;
	}
}
