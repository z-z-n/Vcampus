package server.common;

public class LoginClass implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String cardNum = null;
	public String pwd = null;
	public LoginClass(String c, String p) {
		this.cardNum = c;
		this.pwd = p;
	}
}
