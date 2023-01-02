package server.common;

public class Chat implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String str1;
	public String str2;
	public String str3;
	public String str4;
	public Chat(String str1, String str2, String str3, String str4) {
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
	}
}
