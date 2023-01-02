package server.common;

public class GradeClass implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String cardNum=null;
	public String courseId=null;
	public int score = 0;
	
	public GradeClass(String cn,String ci,int s) {
    	this.cardNum=cn;
    	this.courseId=ci;
    	this.score=s;
    }
	
	public GradeClass(String cn) {
    	this.cardNum=cn;
	}
	
	public GradeClass(String cn,String ci) {
    	this.cardNum=cn;
    	this.courseId=ci; 	
    }
	
	public GradeClass() {
		
	}
}
