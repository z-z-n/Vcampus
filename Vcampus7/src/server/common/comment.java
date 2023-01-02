package server.common;

public class comment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String cardNum=null;
	public String teachercard=null;
	public String comment=null;
	public comment(String card,String tc,String co) {
		this.cardNum=card;
		this.teachercard=tc;
		this.comment=co;
		
	}
	public comment(String card,String tc) {
		this.cardNum=card;
		this.teachercard=tc;
	}
	public comment(String card) {
		this.cardNum=card;
	}
}
