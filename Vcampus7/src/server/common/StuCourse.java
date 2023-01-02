package server.common;

public class StuCourse  implements java.io.Serializable{
		private static final long serialVersionUID = 1L;
		public String cardNum=null;
		public String teacherCard=null;
		public String courseId=null;
		public String courseTime=null;
		
		
		public StuCourse(String cn,String tc,String ci,String ct) {
	    	this.cardNum=cn;
	    	this.teacherCard=tc;
	    	this.courseId=ci;
	    	this.courseTime=ct;
	    }
		
		public StuCourse(String ca,String ci) {
			this.cardNum=ca;
			this.courseId=ci;
		}
		public StuCourse(String cn) {
			this.cardNum=cn;
	    	this.teacherCard=null;
	    	this.courseId=null;
	    	this.courseTime=null;
		}
	}

