
public class Dependency {
	String group, artifact, version, type;

	public String scope;

	public Dependency() {
	}

	public Dependency(String grp, String arti, String ver, String typ) {
		group = grp;
		artifact = arti;
		version = ver;
		type = typ;
	}

	public String toUrl() {
		if(version.contains("["))
			version =  version.substring(1,version.indexOf("]"));
		return group.replace('.', '/') + '/' + artifact + '/' + version + '/';
	}

	//for windows based filepath
	public String toFile() {
		return group.replace('.', '\\') + '\\' + artifact + '\\' + version + '\\';
	}

	public String getFileName() {
		return artifact + '-' + version;
	}

	@Override
	public String toString() {
		return group + artifact + version + type;
	}
}
