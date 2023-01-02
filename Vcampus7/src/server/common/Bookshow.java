package server.common;

public class Bookshow implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String bookId=null;
	public String bookName=null;
	public String compress=null;
	public int isBorrowed=0;
    public Bookshow(String id,String name,String c,int i) {
    	this.bookId=id;
    	this.bookName=name;
    	this.compress=c;
    	this.isBorrowed=i;
    }

}
