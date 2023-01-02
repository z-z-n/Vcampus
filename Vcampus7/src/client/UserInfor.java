package client;

public class UserInfor {
	public String UserID;//账号
	public String name;
	public String status;//权限
	public UserInfor(String id,String na,String t)
	{
		this.UserID=id;
		this.name=na;
		switch(t)
		{
		case "2":
			this.status="教师";
			break;
		case "1":
			this.status="学生";
			break;
		case "3":
			this.status="教务管理员";
			break;
		case "4":
			this.status="图书管理员";
			break;
		case "5":
			this.status="商城管理员";
			break;
		case "6":
			this.status="超级管理员";
			break;
		default:
			System.out.println("权限设置错误！");
			break;
		}
	}
}
//try git