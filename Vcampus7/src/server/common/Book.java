package server.common;

public class Book implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String bookId=null;
	public String bookName=null;
	public String compress=null;
	//public int isBorrowed=0; //0表示没有借出，1表示已借出
    public Book(String id,String name,String c) {
    	this.bookId=id;
    	this.bookName=name;
    	this.compress=c;
    	//this.isBorrowed=i;
    }
}
