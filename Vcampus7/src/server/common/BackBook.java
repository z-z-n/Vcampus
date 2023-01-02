package server.common;

public class BackBook implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String cardNum=null;
	public String bookId=null;
	
    public BackBook(String ca,String id) {
    	this.cardNum=ca;
    	this.bookId=id;
    }
}
