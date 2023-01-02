package server.common;

/*
 *  教务排课类
 */
public class CourseScheduling implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String courseId = null;
    public String teacherCard = null;
    public String courseName = null;
    public String courseTime = null;
    public String classroom=null;
    public int capacity=0;
    public int cnt=0;
    public String prefertime=null;
    public int type=0;
    
    public CourseScheduling(String ci,String tc,String cn,String ct,String cla,int cap,int cnt,String p,int t) {
    	this.courseId=ci;
    	this.teacherCard=tc;
    	this.courseName=cn;
    	this.courseTime=ct;
    	this.classroom=cla;
    	this.capacity=cap;
    	this.cnt=cnt;
    	this.prefertime=p;
    	this.type=t;
    }
    public CourseScheduling(String ci,String tc,String cn,String ct,String cla,int cap,String p,int t) {
    	this.courseId=ci;
    	this.teacherCard=tc;
    	this.courseName=cn;
    	this.courseTime=ct;
    	this.classroom=cla;
    	this.capacity=cap;
    	this.prefertime=p;
    	this.type=t;
    }
    public CourseScheduling(String ci,String tc,String cn,String ct,String cla,int cap,int t) {
    	this.courseId=ci;
    	this.teacherCard=tc;
    	this.courseName=cn;
    	this.courseTime=ct;
    	this.classroom=cla;
    	this.capacity=cap;
    	this.type=t;
    }
    
    public CourseScheduling(String tc,String pt) {
    	this.teacherCard=tc;
    	this.prefertime=pt;
    }
    
    public CourseScheduling(String tc) {
    	this.teacherCard=tc;
    }
    public CourseScheduling() {
    }
}
