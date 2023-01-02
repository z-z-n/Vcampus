package server.common;

public class RegisterClass implements java.io.Serializable{
	private static final long serialVersionUID = 1L; // 不用管
	public String cardNum;
	public String pwd;
	public String code; //验证码
	public String name; //生日年份
	//public String month;
	//public String date;
	public RegisterClass(String ca, String pw, String co, String na) {
		this.cardNum = ca;
		this.pwd = pw;
		this.code = co;
		this.name=na;
		//this.month = mo;
		//this.date = da;
	}
}