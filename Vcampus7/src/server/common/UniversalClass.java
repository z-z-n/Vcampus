package server.common;

public class UniversalClass implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String context = null;
	public UniversalClass(String s) {
		this.context = s;
	}
}
