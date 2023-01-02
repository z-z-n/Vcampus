package server.common;

public class OnlyCardNum implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String cardNum = null;
	public OnlyCardNum(String c) {
		this.cardNum = c;
	}
}