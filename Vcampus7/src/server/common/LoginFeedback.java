package server.common;

public class LoginFeedback implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String name = null;
	public String priority = null;
	public LoginFeedback(String n, String p) {
		this.name = n;
		this.priority = p;
	}
}
