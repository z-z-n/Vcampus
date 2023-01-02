package server.common;

//import java.util.Date;

public class BorrowBook implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
    public String cardNum;
    public String bookId;
    public String da;
    //public String month;
    //public String day;
    public BorrowBook(String c,String id,String d) {
    	this.cardNum=c;
    	this.bookId=id;
    	this.da=d;
    	//this.month=m;
    	//this.day=d;
    }
}
