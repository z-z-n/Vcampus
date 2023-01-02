package server.common;

public class NameAndCardNum implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String name;
	public String cardNum;
	public NameAndCardNum(String c, String n) {
		this.cardNum = c;
		this.name = n;
	}
}
