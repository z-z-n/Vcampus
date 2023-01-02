package server.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import server.common.*;

//该类用来实现各项功能如登录，借书等
public class DbService {
	public static void setEmail(String code, String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		Long time = System.currentTimeMillis();  //获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(time);
		ResultSet res = db.search("select * from emailcheck where cardnum = '"+ cardNum +"';");
		if(res.next()) {
			db.adm("UPDATE emailcheck SET code='"+ code +"'WHERE cardnum='"+ cardNum +"';");
			db.adm("UPDATE emailcheck SET tme='"+ date +"'WHERE cardnum='"+ cardNum +"';");
		}
		else {
			db.adm("INSERT INTO emailcheck (cardnum, code, tme) VALUES ('"+ cardNum +"','"+ code +"','"+
			date +"');");
		}
	}
	

	public static String loginCheck(String cardNum, String pwd) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardnum = '"+ cardNum +"';");
		if(res.next()) {
			String password = res.getString("pwd");
			String name = res.getString("name");
			if (password.equals(pwd)) {
				return name;
			}
			else {
				return "密码不正确";
			}
		}
		else {
			return "该用户未注册";
		}
	}
	
	public static boolean isRegistered(String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardnum = '"+ cardNum +"';");
		if(res.next()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static String checkEmail(String cardNum, String code) throws SQLException {
		DbOperation db = new DbOperation();
		// 数据库里没有验证码，或者匹配不上，统一说 验证码错误
		ResultSet res = db.search("select * from emailcheck where cardnum = '"+ cardNum +"';");
		if(res.next()) {
			String co = res.getString("code");
			if(co.equals(code)) {
				// 判断验证码是否过期(超过5分钟)
				String tme = res.getString("tme");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Long t = null;
				try {
					t = format.parse(tme).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if((System.currentTimeMillis() - t) / (1000 * 60) >= 5) { // 超过5分钟则超时
					return "验证码超时";
				}
				else {
					return "200";
				}
			}
			else {
				return "验证码错误";
			}
		}
		else {
			return "验证码错误";
		}
	}
	
	public static void addUser(String ca, String pwd, String na) {
		DbOperation db = new DbOperation();
		String p = null;
		if(ca.substring(0, 1).equals("2")){
			p = "1";
		}
		else if(ca.substring(0, 1).equals("1")) {
			p = "2";
		}
		else {
			p = "3";
		}
		db.adm("INSERT INTO userbasic (cardnum, name,priority, money, pwd) VALUES"
				+ "('"+ ca +"','"+ na +"','"+ p +"', 500, '"+ pwd +"');");
		if(p.equals("1")) {
			// 学生才要在这stuinfo数据库中添加信息，老师和管理员不用
			db.adm("INSERT INTO stuinfo (cardnum, photopath, stunum, sex, selfintro, birthyear, birthmonth, birthdate)"
					+ "VALUES ('"+ ca +"', null, null, null, null, null, null, null);");
		}
	}
	
	/*public static String borrow(String ca,String id,String da) {
		DbOperation db=new DbOperation();
		
	}*/
	
	//查询已经借阅的数量
	public int countbook(String ca) throws SQLException {
		int cnt=0;
		DbOperation db = new DbOperation();
		ResultSet rs=db.search("SELECT * FROM borrowperson WHERE cardNum = '"+ ca +"'");
		while(rs.next()) {
			cnt++;
		}
		return cnt;
	}
	
	//返回已经借的书
	public static ResultSet findborrow(String ca) {
		DbOperation db = new DbOperation();
		ResultSet rs=db.search("select *from borrowperson where cardNum='"+ ca +"';");
		return rs;
	}
	
	public static ResultSet findbyid(String id) {
		DbOperation db = new DbOperation();
		ResultSet rs=db.search("select *from bookinfo where bookId='"+ id +"';");
		return rs;
	}
	
	public static ResultSet findbyname(String na) {
		DbOperation db = new DbOperation();
		ResultSet rs=db.search("select *from bookinfo where bookName='"+ na +"';");
		return rs;
	}
	
	public static String borrow(String ca,String id,String da) throws SQLException {
		DbOperation db1 = new DbOperation();
		DbOperation db2 = new DbOperation();
		DbService d=new DbService();
		String rs=null;
		String p=ca.substring(0, 1);
		if(p.equals("2")&&d.countbook(ca)==3) {
			rs="借书量超出学生可借数";	
			return rs;
		}
		else if(p.equals("1")&&d.countbook(ca)==5) {
			rs="借书量超出教师可借数";	
			return rs;
		}
		ResultSet s=db1.search("select *from bookinfo where bookID='"+ id +"'");
		if(s.next()) {
			int status=s.getInt(4);
			if(status==1) {
				rs="该书已被借出";
				return rs;
			}
			else {	
				//假如书存在且可以借，就在借阅表里添加一条信息，并将bookinfo表里的那本书改成已借阅
				Long time = System.currentTimeMillis();  //获取当前时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(time);
				Date d2 = java.sql.Date.valueOf(date); //获取现在时间
				Date d1 = java.sql.Date.valueOf(da);   //把String类型的日期转成date类型
				long diff = d1.getTime() - d2.getTime();  
			    long days = diff / (1000 * 60*60*24);   //计算借阅时长
			    if(p.equals("2")&&days>5) {
			    	rs="超出学生借阅时长(5天)";
			    	return rs;
			    }
			    if(p.equals("1")||p.equals("3")&&days>10) {
			    	rs="超出教师借阅时长(10天)";
			    	return rs;
			    }
				db1.adm("insert into borrowperson (cardNum,bookId,finalDate) values('"+ ca +"','"+ id +"','"+d1+"')");			
				rs="借阅成功";
				db2.adm("update bookinfo set isBorrowed=1 where bookId='"+ id +"'");			
				return rs;
			}
		}
		else {		
			rs="没有该编号的书";
			return rs;
		}
		
	}
	
	//还书
	public static String back(String ca,String id) throws SQLException {
		String rs=null;
		DbOperation db=new DbOperation();
		ResultSet re=db.search("select *from borrowperson where cardNum='"+ ca +"'&& bookId='"+ id +"'");
		if(!re.next()) {
			rs="没有借该书";
		}
		else {
			db.adm("delete from borrowperson where bookId='"+id+"'");
			db.adm("update bookinfo set isBorrowed=0 where bookId='"+id+"'");
			rs="归还成功";
		}
		return rs;
	}
	
	public static String addbook(String id,String na,String com) throws SQLException {
		String rs=null;
		DbOperation db=new DbOperation();
		ResultSet re=db.search("select *from bookinfo where bookId='"+ id +"';");
		if(re.next()) {
			rs="已有该编号的书";
			
		}
		else {
			db.adm("insert into bookinfo (bookId,bookName,compress,isBorrowed) values('"+ id +"','"+ na +"','"+com+"',0);");
			rs="上架成功";
		}
		return rs;
	}
	
	public static String deletebook(String id) throws SQLException {
		String rs=null;
		DbOperation db=new DbOperation();
		ResultSet re=db.search("select * from bookinfo where bookId='"+id+"';");
		if(!re.next()) {
			rs="没有该编号的书";
		}
		else {
			int status=re.getInt(4);
			if(status==0) {	
				db.adm("delete from bookinfo where bookId='"+ id +"';");
				rs="下架成功";
			}
			else {
				rs="该书正在被借阅，无法下架";
			}
		}
		return rs;
	}
	
	public static String modifybook(String id,String na,String com) throws SQLException {
		String rs=null;
		DbOperation db=new DbOperation();
		ResultSet re=db.search("select *from bookinfo where bookId='"+id+"';");
		if(!re.next()) {
			rs="没有该编号的书";
		}
		else {
			int status=re.getInt(4);
			if(status==1) {
				rs="该书正在被借阅，无法下架";
			}
			else {	
				String sql="update bookinfo set bookName='"+ na+"',compress='"+com+"' where bookId='"+id+"'";
				db.adm(sql);
				rs="修改成功";
			}
		}
		return rs;
	}
	
	
	public static String getFilePath(String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from stuinfo where cardnum = '"+ cardNum +"';");
		res.next();
		return res.getString("photopath");
	}
	
	public static void addPhoto(String cardNum, String path) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE stuinfo SET photoPath='"+ path +"' WHERE cardnum='"+ cardNum +"';");
	}
	
	public static StuBasicInfo getStuBasic(String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from stuinfo where cardnum = '"+ cardNum +"';");
		res.next();
		return new StuBasicInfo(cardNum, res.getString("stunum"),res.getInt("sex"));
	}
	
	public static StuExtendInfo getStuExtension(String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from stuinfo where cardnum = '"+ cardNum +"';");
		res.next();
		return new StuExtendInfo(cardNum, res.getString("selfIntro"),res.getString("phone"),res.getString("email"),res.getString("birthYear"),res.getString("birthMonth"),res.getString("birthDate"));
	}
	
	public static void addRequest(ChangeWithReason obj) throws SQLException {
		DbOperation db = new DbOperation();
		// 数据库之前有记录则覆盖，否则新增一条记录
		ResultSet res = db.search("select * from stuinforequest where cardnum = '"+ obj.cardNum +"';");
		if(res.next()) {
			db.adm("UPDATE stuinforequest SET stunum="+ obj.stunum +" WHERE cardnum='"+ obj.cardNum +"';");
			db.adm("UPDATE stuinforequest SET sex="+ obj.sex +" WHERE cardnum='"+ obj.cardNum +"';");
			db.adm("UPDATE stuinforequest SET reason='"+ obj.reason +"' WHERE cardnum='"+ obj.cardNum +"';");
			db.adm("UPDATE stuinforequest SET name='"+ obj.name +"' WHERE cardnum='"+ obj.cardNum +"';");
		}
		else {
			db.adm("INSERT INTO stuinforequest (cardnum, stunum, sex, reason, name) VALUES"
					+ "('"+ obj.cardNum +"',"+ obj.stunum +","+ obj.sex +",'"+ obj.reason +"','"+ obj.name +"');");
		}
	}
	
	public static void setStuExtension(StuExtendInfo obj) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE stuinfo SET selfintro='"+ obj.selfIntro +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET phone='"+ obj.phone +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET email='"+ obj.email +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET birthyear='"+ obj.birthYear +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET birthmonth='"+ obj.birthMonth +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET birthdate='"+ obj.birthDate +"' WHERE cardnum='"+ obj.cardNum +"';");
	}
	
	public static NameAndCardNum[] getStuNameAndCardNum(int num) {
		DbOperation db = new DbOperation();
		ResultSet res =  db.search("select * from userbasic;");
		NameAndCardNum[]temp = new NameAndCardNum[num];
		int count = 0;
		try {
			while(res.next()) {
				if(res.getString("cardnum").substring(0, 1).equals("2")) {
					temp[count] = new NameAndCardNum(res.getString("cardnum"),res.getString("name"));
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static int getStuNameAndCardNumCount() {
		DbOperation db = new DbOperation();
		ResultSet res =  db.search("select * from userbasic;");
		int count = 0;
		try {
			while(res.next()) {
				if(res.getString("cardnum").substring(0, 1).equals("2")) {
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void setStuBasicInfo(StuBasicInfo obj) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE stuinfo SET sex='"+ obj.sex +"' WHERE cardnum='"+ obj.cardNum +"';");
		db.adm("UPDATE stuinfo SET stunum='"+ obj.stuNum +"' WHERE cardnum='"+ obj.cardNum +"';");
		// 然后在学生修改信息请求数据库中查找，如果有的话则删除
		db.adm("delete from stuinforequest where cardnum='"+ obj.cardNum +"';");
	}
	
	public static int getInfoRequestCount() {
		DbOperation db = new DbOperation();
		ResultSet res =  db.search("select * from stuinforequest;");
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static ChangeWithReason[] getInfoRequest(int num) {
		DbOperation db = new DbOperation();
		ResultSet res =  db.search("select * from stuinforequest;");
		ChangeWithReason[]temp = new ChangeWithReason[num];
		int count = 0;
		try {
			while(res.next()) {
				temp[count] = new ChangeWithReason(res.getString("cardnum"),res.getInt("sex"),res.getInt("stunum"),res.getString("reason"),res.getString("name"));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static void refuseRequest(String cardNum) {
		DbOperation db = new DbOperation();
		db.adm("delete from stuinforequest where cardnum='"+ cardNum +"';");
	}
	
	public static HallInfo getHallInfo(String cardNum) throws SQLException {
		DbOperation db = new DbOperation();
		double money = 0;
		double moneyUsed = 0;
		int bookBorrowed = 0;
		Date tmp = Date.valueOf("2022-7-15");
		ResultSet res =  db.search("select * from userbasic where cardnum = '"+ cardNum +"';");
		res.next();
		money = res.getDouble("money");
		res =  db.search("select * from borrowperson where cardnum = '"+ cardNum +"';");
		while(res.next()) {
			bookBorrowed ++;
			// 日期处理
			if(res.getDate("finaldate").before(tmp)) {
				tmp = res.getDate("finaldate");
			}
		}
		Long time = System.currentTimeMillis();  //获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dat = format.format(time); // 获取当月月份
		int month = Integer.parseInt(dat.substring(6,7)); // 暂不考虑10-12月
		res =  db.search("select * from shoppinghistory where cardnum = '"+ cardNum +"';");
		while(res.next()) {
			if(res.getDate("tme").getMonth()+1 == month) {
				moneyUsed += res.getDouble("pay");
			}
		}
		return new HallInfo(money,moneyUsed,bookBorrowed,tmp);
	}
	
	public static void addMoney(String cardNum, double add) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardnum = '"+ cardNum +"';");
		res.next();
		double money = res.getDouble("money");
		money = money + add;
		db.adm("UPDATE userbasic SET money="+ money +" WHERE cardnum='"+ cardNum +"';");
	}
	
	public static boolean courseCheck(String cn,String ci) throws SQLException {
		//检查选中课程是否已选
		DbOperation db = new DbOperation();
		String str=null;
		ResultSet res = db.search("select * from stucourse where cardNum = '"+ cn +"';");
		
		while(res.next()) {
			str=res.getString("courseId");
			if(ci==str) return false;
		}
		
		return true;
	}
	
	public static boolean courseConflicts(String cn,String ci) throws SQLException{
		//判断选中课程是否和已选课程冲突
		DbOperation db = new DbOperation();
		ResultSet res2 = db.search("select * from courseinfo where courseId = '"+ ci+"';");
		String str2=null;
		while(res2.next()) {
			str2=res2.getString("courseTime");
		}
		
		String str1=null;
		ResultSet res1 = db.search("select * from stucourse where cardNum = '"+ cn +"';");
		while(res1.next()) {
			str1=res1.getString("courseTime");
			for(int i=0;i<str1.length();i++) {
				for(int j=0;j<str2.length();j++) {
					if(str1.charAt(i)==str2.charAt(j)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static void addChoosedCourse(String cn,String ci) throws SQLException{
		//添加选课信息
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from courseinfo where courseId = '"+ ci +"';");
		res.next();
		db.adm("INSERT INTO stucourse(cardNum,teacherCard,courseId,courseTime) VALUES('"+ cn +"','"+ res.getString("teacherCard")+"','"+ ci +"', '"+ res.getString("courseTime") +"');");
	}
	
	public static int dropchoosedcourse(String ca,String ci) throws SQLException {
		//退选
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select * from stucourse where courseId='"+ci+"' and cardNum='"+ca+"'");
		if(res.next()) {
			db.adm("delete from stucourse where courseId='"+ci+"' and cardNum='"+ca+"'");
			return 1;
		}
		else {
			return 0;
		}
	}
	public static int addcnt(String ci) throws SQLException {
		//查看课容量
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select * from courseinfo where courseId='"+ci+"'");
		res.next();
		int cnt=res.getInt("cnt");
		int capacity=res.getInt("capacity");
		if(cnt==capacity) {
			return 0;
		}
		else {
			cnt++;
			db.adm("update courseinfo set cnt='"+cnt+"' where courseId='"+ci+"'");
			return 1;
		}
	}
	
	public static boolean courseIdCheck(String ci) throws SQLException {
		//检查课程编号是否重复
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from courseinfo where courseId = '"+ ci +"';");
		if(res.next()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean registeredCheck(String cardNum) throws SQLException {
		//检查输入教师是否已注册
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardnum = '"+ cardNum +"';");
		if(res.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isCourse(String ci) throws SQLException {
		//检查选中课程是否存在
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from courseinfo where courseId = '"+ ci +"';");
		if(res.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void addCourse(String ci,String tc,String cn,String ct,String cla,int ca,String pre,int t) {
		//排课
		DbOperation db = new DbOperation();
		db.adm("update courseinfo set courseId='"+ci+"', courseName='"+ cn +"', courseTime='"+ ct +"', classroom='"+cla+"', capacity='"+ca+"', cnt=0 , type='"+ t +"' where teacherCard ='"+tc+"';");
	}
	
	public static boolean ifSetTime(String tc) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from courseinfo where teacherCard = '"+ tc +"';");
		if(res.next()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void setTime(String pt,String tc) throws SQLException {
		DbOperation db = new DbOperation();
		db.adm("INSERT INTO courseinfo(teacherCard,prefertime)"
				+ " VALUES('"+ tc+"','"+pt+"');");
	}
	
	
	public static int typeconflict(String t,int type) throws SQLException {
		//保证必修课不互相冲突，选修课可以
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select * from courseinfo where courseTime='"+t+"'");
		if(res.next()) {
			if(type==2) { //选修可以与别的可时间冲突
				return 1;
			}
			else {
				ResultSet res1=db.search("select * from courseinfo where courseTime='"+t+"'");			
				while(res1.next()) {
					int ty=res1.getInt("type");//当要排的课是必修时，检查这一时间段的课程，如果有必修则冲突
					if(ty==1) {
						return 0;
					}
				}
				return 1;
			}
		}		
		else {
			return 1;
		}
	}
		
	public static int checkclassroom(String cl,String t) throws SQLException {
		//检查同一时间的课的教室是否冲突
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select * from courseinfo where courseTime='"+t+"' and classroom='"+cl+"'");
		if(res.next()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static void scoreUpload(String cn,String ci,int s) throws SQLException{
		//添加选课信息
		DbOperation db = new DbOperation();
		db.adm("INSERT INTO gradeinfo(cardNum,courseId,score) VALUES('"+ cn +"','"+ ci +"', '"+ s +"');");
	}
	
   	public static ResultSet sendCourse() throws SQLException {
			//发送课程信息功能函数
			DbOperation db = new DbOperation();
			ResultSet res=db.search("select *from courseinfo where courseId is not null");
			return res;
	}

	public static ResultSet sendschedule(String cn) throws SQLException {
			//发送课表信息功能函数
			DbOperation db = new DbOperation();
			ResultSet res=db.search("select *from stucourse where cardNum = '"+ cn +"';");
			return res;
	}
	
	public static ResultSet printScore() throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select *from gradeinfo order by courseId ASC");
		return res;
    }
	
	public static void comment(String card,String tc,String co) {
		//老师添加评语
		DbOperation db=new DbOperation();
		db.adm("update homeworksubmit set comment='"+co+"', correct=1 where teacherCard='"+tc+"' and cardNum='"+card+"';");
	}
	
	public static ResultSet readcomment(String card,String tc) {
		//学生读评语
		DbOperation db=new DbOperation();
		ResultSet res=db.search("select * from homeworksubmit where cardNum='"+card+"' and teacherCard='"+tc+"';");
		return res;
	}
	
	public static ResultSet tocomment(String card) {
		//老师查看所有发给他未批改的文件
		DbOperation db=new DbOperation();
		ResultSet res=db.search("select * from homeworksubmit where correct=0,teacherCard='"+card+"';");
		return res;
	}
	
	public static int sf(String path,String card,String tc) throws SQLException {
		DbOperation db=new DbOperation();
		ResultSet res=db.search("select * from stucourse where cardNum='"+card+"' and teacherCard='"+tc+"'");
		if(res.next()) {
			db.adm("insert into homeworksubmit (cardNum,teacherCard,filePath,comment,correct) values('"+ card +"','"+ tc +"','"+path+"',null,0);");
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static ResultSet gf(String card) {
		DbOperation db=new DbOperation();
		ResultSet res=db.search("select * from homeworksubmit where cardNum='"+card+"'");
		return res;
	}
	
	public static ResultSet gethomework(String card) {
		DbOperation db=new DbOperation();
		ResultSet res=db.search("select * from homeworksubmit where correct=0 and teacherCard='"+card+"';");
		return res;
	}
	
	public static String getCourseId(String cn) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select *from courseinfo where teacherCard='"+ cn +"';");
		String courseId=null;
		if(res.next()) {
			courseId=res.getString("courseId");
		}
		else {
			courseId="-1";
		}
		
		return courseId;
	}
	
	public static ResultSet scoreInquiryByT(String ci) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select *from gradeinfo where courseId='"+ ci +"';");
		return res;
	}

	public static ResultSet scoreInquiry(String cn) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res=db.search("select *from gradeinfo where cardNum='"+ cn +"';");
		return res;
	}
	
	public static boolean gradeCheck(String cardNum,String ci) throws SQLException {
		//检查输入成绩是否已上传
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from gradeinfo where cardNum = '"+ cardNum +"' and courseId = '"+ ci +"'");
		if(res.next()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static String getCourseId2(String cn) throws SQLException {
			DbOperation db = new DbOperation();
			ResultSet res=db.search("select *from courseinfo where courseName='"+ cn +"';");
			String courseId=null;
			if(res.next()) {
				courseId=res.getString("courseId");
			}
			else {
				courseId=null;
			}
			
			return courseId;
		}

	public static ResultSet scoreInquiryByT2(String ci,String cn) throws SQLException {
			DbOperation db = new DbOperation();
			ResultSet res=db.search("select *from gradeinfo where courseId='"+ ci +"'and cardNum='"+cn+"';");
			return res;
		}


	public static void editScore(String cn,String ci,int s) throws SQLException {
		DbOperation db = new DbOperation();
		db.adm("update gradeinfo set score='"+s+"' where cardNum='"+cn+"'and courseId='"+ci+"'");
	}
	
	public static void deletegrade(String ca,String ci) {
		DbOperation db = new DbOperation();
		db.adm("delete from gradeinfo where cardNum='"+ca+"' and courseId='"+ci+"'");
	}
	public static String getTime(String tc) throws SQLException {
		//获取预期时间
		DbOperation db = new DbOperation();
		String pt=null;
		ResultSet res = db.search("select * from courseinfo where teacherCard = '"+ tc +"';");
		if(res.next()) {
			pt=res.getString("preferTime");
		}else {
			pt=null;
		}
		return pt;
	}

	
	//商城模块
	public static void setPic(String id, String path) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE goodslist SET imgpath='"+ path +"' WHERE goodsid='"+ id +"';");
	}
	
	public static String addGoods(Goods obj) throws SQLException {
		DbOperation db = new DbOperation();
		// 先检查商品ID在该数据库里面是否已经存在
		ResultSet res =  db.search("select * from goodslist where goodsid='"+ obj.id +"';");
		if(res.next()) {
			return "该商品ID已经存在";
		}
		db.adm("INSERT INTO goodslist (goodsid, goodsname, goodsintro, price, num, imgpath) VALUES('"
				+ obj.id +"','"+ obj.name +"','"+ obj.introduction +"',"+ obj.price +","+ obj.number + ", NULL);");
		return "操作成功";
	}
	
	public static void moreGoods(String id, int number) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res =  db.search("select * from goodslist where goodsid='"+ id +"';");
		int nowNum = 0;
		if(res.next()) {
			nowNum = res.getInt("num");
		}
		nowNum = nowNum + number;
		db.adm("UPDATE goodslist SET num="+ nowNum +" WHERE goodsid='"+ id +"';");
	}
	
	public static void multifyPrice(String id, double money) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE goodslist SET price="+ money +" WHERE goodsid='"+ id +"';");
	}
	
	public static void deleteGoods(String id) {
		DbOperation db = new DbOperation();
		// 从商品总表中删除
		db.adm("delete from goodslist where goodsid='"+ id +"';");
		// 从购物车表中删除(先不做，待定)
//		db.adm("delete from shoppingtrolley where goodsid='"+ id +"';");
		// 从评论表中删除
		db.adm("delete from shoppingcomment where goodsid='"+ id +"';");
	}
	
	public static int getSearchCount(String word) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from goodslist where goodsname LIKE '%"+ word +"%';"); // 关键词匹配模糊搜索
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Goods[] getSearch(int num, String word) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from goodslist where goodsname LIKE '%"+ word +"%';");
		Goods[]temp = new Goods[num];
		int count = 0;
		try {
			while(res.next()) {
				temp[count] = new Goods(res.getString("goodsid"),res.getString("goodsName"),res.getDouble("price"),res.getInt("num"),res.getString("goodsIntro"));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static Goods getDetail(String id) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from goodslist where goodsid='"+ id +"';");
		res.next();
		return new Goods(res.getString("goodsid"), res.getString("goodsname"),res.getDouble("price"),res.getInt("num"),res.getString("goodsintro"));
	}
	
	public static int getCommentCount(String id) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppingcomment where goodsid= '"+ id +"';"); 
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static CommentGood[] getComment(int num, String id) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppingcomment where goodsid= '"+ id +"';"); 
//		ResultSet res2 = null;
		String cardNum = null;
		String name = null;
		String gid = null;
		String com = null;
		CommentGood[]temp = new CommentGood[num];
		int count = 0;
		try {
			while(res.next()) {
				cardNum = res.getString("cardnum");
				gid = res.getString("goodsid");
				com = res.getString("comment");
				temp[count] = new CommentGood(gid, cardNum, name, com);
				count++;
			}
			for(int i=0; i<num; i++) {
				res = db.search("select * from userbasic where cardnum='"+ temp[i].cardNum +"';");
				res.next();
				temp[i].name = res.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static String buy(String id, String cardNum, int num) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from goodslist where goodsid= '"+ id +"';"); 
		res.next();
		double price = res.getDouble("price");
		double price2 = 0;
		int count = res.getInt("num");
		if(count < num) {
			return "库存不足";
		}
		else {
			res = db.search("select * from userbasic where cardnum= '"+ cardNum +"';");
			res.next();
			price = price * num;
			price2 = res.getDouble("money") - price;
			if(price2 < 0) {
				return "账户金额不足";
			}
			else {
				// 商品个数减少
				count = count - num;
				db.adm("UPDATE goodslist SET num="+ count +" WHERE goodsid='"+ id +"';");
				// 扣钱
				db.adm("UPDATE userbasic SET money="+ price2 +" WHERE cardnum='"+ cardNum +"';");
				// 清除购物车中的该商品(如果有)
				deleteCar(id,cardNum);
				// 增加消费记录
				Long time = System.currentTimeMillis();  //获取当前时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(time);
				java.sql.Date d2 = java.sql.Date.valueOf(date); //获取现在时间
				db.adm("INSERT INTO shoppinghistory (cardnum, goodsid, num, pay, tme) VALUES"
						+ "('"+ cardNum +"','"+ id +"',"+ num +","+ price +",'"+ d2 +"');");
				return "操作成功";
			}
		}
	}
	
	public static void commentg(String cardNum, String id, String comment) {
		DbOperation db = new DbOperation();
		db.adm("INSERT INTO shoppingcomment (cardnum, goodsid, comment) VALUES ('"+ cardNum +"','"+ id +"','"+ comment +"');");
	}
	
	public static String addCar(String cardNum, String id) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppingtrolley WHERE goodsid='"+ id +"' AND cardnum='"+ cardNum +"';");
		if(res.next()) {
			return "该商品已在购物车中";
		}
		else {
			db.adm("INSERT INTO shoppingtrolley (cardnum, goodsid) VALUES ('"+ cardNum +"','"+ id +"');");
			return "操作成功";
		}
	}
	
	public static int lookCarCount(String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppingtrolley where cardnum='"+ cardNum +"';");
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Goods[] lookCar(int num, String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppingtrolley where cardnum='"+ cardNum +"';");
		Goods[]temp = new Goods[num];
		String id = null;
		int count = 0;
		try {
			while(res.next()) {
				id = res.getString("goodsid");
				temp[count] = new Goods(id,null,0,0,null);
				count++;
			}
			for(int i=0; i<num; ++i) {
				res = db.search("select * from goodslist where goodsid='"+ temp[i].id +"';");
				if(res.next()) {
					temp[i] = new Goods(temp[i].id,res.getString("goodsname"),res.getDouble("price"),res.getInt("num"),res.getString("goodsintro"));
				}
				else { // 该商品已下架
					temp[i] = new Goods(temp[i].id,"该商品已下架",0,0,"该商品已被下架");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static String getPicPath(String id) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from goodslist where goodsid='"+ id +"';");
		res.next();
		return res.getString("imgpath");
	}
	
	public static String getTN(String tc) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardNum='"+ tc +"';");
		res.next();
		return res.getString("name");
	}
	
	public static String getCN(String ci) throws SQLException {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from courseinfo where courseId='"+ ci +"';");
		res.next();
		return res.getString("courseName");
	}
	
	public static void deleteCar(String id, String cardNum) {
		DbOperation db = new DbOperation();
		db.adm("DELETE FROM shoppingtrolley WHERE goodsid='"+ id +"' AND cardnum='"+ cardNum +"';");
	}
	
	public static int getHistoryCount(String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppinghistory where cardnum='"+ cardNum +"';");
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static HistoryInfo[] getHistory(String cardNum, int num) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from shoppinghistory where cardnum='"+ cardNum +"';");
		HistoryInfo[]temp = new HistoryInfo[num];
		String id = null;
		int count = 0;
		try {
			while(res.next()) {
				id = res.getString("goodsid");
				temp[count] = new HistoryInfo(id,null,null,res.getDouble("pay"),res.getInt("num"),res.getDate("tme"));
				count++;
			}
			for(int i=0; i<num; ++i) {
				res = db.search("select * from goodslist where goodsid='"+ temp[i].id +"';");
				if(res.next()) {
					temp[i].name = res.getString("goodsname");
					temp[i].introduction = res.getString("goodsIntro");
				}
				else { // 该商品已下架
					temp[i].name = "该商品已下架";
					temp[i].introduction = "该商品已下架";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static String createGroup(String cardNum, String name) {
		DbOperation db = new DbOperation();
		db.adm("INSERT INTO groupinfo (cardnum, name) VALUES ('"+ cardNum +"','"+ name +"');");
		ResultSet res = db.search("SELECT LAST_INSERT_ID();");
		int no = 0;
		try {
			res.next();
			no = res.getInt(1);
			db.adm("INSERT INTO usergroup (cardnum, groupnum) VALUES ('"+ cardNum +"','"+ String.valueOf(no) +"');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(no);
	}
	
	public static String searchName(String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from userbasic where cardnum='"+ cardNum +"';");
		try {
			if(res.next()) {
				return res.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "查不到";
	}
	
	public static boolean makeFriends(String cardNum1, String cardNum2, String content) {
		DbOperation db = new DbOperation();
		// 查看是否已经在申请待通过
		ResultSet res = db.search("select * from requestlist where cardnum='"+ cardNum1 +"' AND number='"+ cardNum2 +"';");
		try {
			if(res.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 查看是否已经成为好友
		res = db.search("select * from relationinfo where (cardnum1='"+ cardNum1 +"' AND cardnum2='"+ cardNum2 +"') OR (cardnum1='"+
		cardNum2+"' AND cardnum2='"+ cardNum1 +"') ;");
		try {
			if(res.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.adm("INSERT INTO requestlist (cardnum, number, reason, type) VALUES ('"+ cardNum1 +"','"+ cardNum2 +"','"+ content +"', 0);");
		return true;
	}
	
	public static String searchGroup(String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from groupinfo where groupnum="+ Integer.valueOf(cardNum) +";");
		try {
			if(res.next()) {
				return res.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "查不到";
	}
	
	public static boolean enterGroup(String cardNum1, String cardNum2, String content) {
		DbOperation db = new DbOperation();
		// 查看是否已经在申请待通过
			ResultSet res = db.search("select * from requestlist where cardnum='"+ cardNum1 +"' AND number='"+ cardNum2 +"';");
			try {
				if(res.next()) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 查看是否已经成为群成员
			res = db.search("select * from usergroup where cardnum='"+ cardNum1 +"' AND groupnum='"+ cardNum2 +"';");
			try {
				if(res.next()) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		db.adm("INSERT INTO requestlist (cardnum, number, reason, type) VALUES ('"+ cardNum1 +"','"+ cardNum2 +"','"+ content +"', 1);");
		return true;
	}
	
	public static int applicationResCount(String cardNum) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from requestlist WHERE number='"+cardNum+"' AND type=0;"); // 查找相关的好友申请
		int count = 0;
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res = db.search("select * from groupinfo WHERE cardnum='"+ cardNum +"';"); // 查找该一卡通对应的群号
		Vector<String> v = new Vector<String>();
		try {
			while(res.next()) {
				v.add(res.getString("groupnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(String str:v) {
			res = db.search("select * from requestlist WHERE number='"+str+"' AND type=1;"); // 查找加群申请
			try {
				while(res.next()) {
					count++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		res = db.search("select * from requestlist WHERE cardnum='"+ cardNum +"';"); // 查找申请结果
		try {
			while(res.next()) {
				if(res.getInt("type")!=0 && res.getInt("type")!=1 && res.getInt("type")!=2 && res.getInt("type")!=5) {
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Chat[] applicationRes(int num, String cardNum) {
		DbOperation db = new DbOperation();
		Chat[]temp = new Chat[num];
		ResultSet res = db.search("select * from requestlist WHERE number='"+cardNum+"' AND type=0;"); // 查找相关的好友申请
		int count = 0;
		try {
			while(res.next()) {
				// 姓名区域先用cardNum代替，最后统一替换
				temp[count] = new Chat("好友申请",res.getString("cardnum"),res.getString("reason"),String.valueOf(res.getInt("no")));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res = db.search("select * from groupinfo WHERE cardnum='"+ cardNum +"';"); // 查找该一卡通对应的群号
		Vector<String> v = new Vector<String>();
		try {
			while(res.next()) {
				v.add(res.getString("groupnum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(String str:v) {
			res = db.search("select * from requestlist WHERE number='"+str+"' AND type=1;"); // 查找加群申请
			try {
				while(res.next()) {
					temp[count] = new Chat("加群申请",res.getString("cardnum"),res.getString("reason"),String.valueOf(res.getInt("no")));
					count++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.adm("UPDATE requestlist SET type=5 where type=1 AND number='"+ str +"';");
		}
		// 把一卡通转换成姓名
		for(int i=0; i<count; ++i) {
			res = db.search("select * from userbasic WHERE cardnum='"+ temp[i].str2 +"';");
			try {
				res.next();
				temp[i].str2 = temp[i].str2+"%"+res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 更改状态
		db.adm("UPDATE requestlist SET type=2 where type=0 AND number='"+ cardNum +"';");
		int ttt = count;
		res = db.search("select * from requestlist WHERE cardnum='"+ cardNum +"';"); // 查找申请结果
		try {
			while(res.next()) {
				if(res.getInt("type")==3) {
					temp[count]=new Chat("好友申请结果","一卡通"+res.getString("number")+"的用户通过了您的好友申请",null,res.getString("number"));
					count++;
				}
				else if(res.getInt("type")==4) {
					temp[count]=new Chat("好友申请结果","一卡通"+res.getString("number")+"的用户拒绝了您的好友申请",null,res.getString("number"));
					count++;
				}
				else if(res.getInt("type")==6) {
					temp[count]=new Chat("入群申请结果","群号"+res.getString("number")+"的群主通过了您的入群申请",null,res.getString("number"));
					count++;
				}
				else if(res.getInt("type")==7) {
					temp[count]=new Chat("入群申请结果","群号"+res.getString("number")+"的群主拒绝了您的入群申请",null,res.getString("number"));
					count++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 把群号转化为群主一卡通号
		for(int i=ttt;i<count;i++) {
			if(temp[i].str1.equals("入群申请结果")) {
				res = db.search("select * from groupinfo WHERE groupnum='"+ temp[i].str4 +"';");
				try {
					res.next();
					temp[i].str4 = res.getString("cardnum");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 把一卡通号转化为姓名
		for(int i=ttt;i<count;i++) {
			res = db.search("select * from userbasic WHERE cardnum='"+ temp[i].str4 +"';");
			try {
				res.next();
				temp[i].str3 = res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 展示过后删除相关信息
		db.adm("delete from requestlist WHERE cardnum='"+ cardNum +"' AND type=3;");
		db.adm("delete from requestlist WHERE cardnum='"+ cardNum +"' AND type=4;");
		db.adm("delete from requestlist WHERE cardnum='"+ cardNum +"' AND type=6;");
		db.adm("delete from requestlist WHERE cardnum='"+ cardNum +"' AND type=7;");
		return temp;
	}
	
	public static int msgResCount(String cardNum) {
		DbOperation db = new DbOperation();
		int count = 0;
		ResultSet res = db.search("select * from msglist WHERE too='"+ cardNum +"' AND (type=0 OR type=2);");
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Chat[] msgRes(int num, String cardNum) {
		DbOperation db = new DbOperation();
		Chat[]temp = new Chat[num];
		int count = 0;
		ResultSet res = db.search("select * from msglist WHERE too='"+ cardNum +"' AND type=0;");
		try {
			while(res.next()) {
				temp[count] = new Chat(res.getString("fro"),res.getString("fro"),res.getString("tme"),res.getString("msg"));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res = db.search("select * from msglist WHERE too='"+ cardNum +"' AND type=2;");
		try {
			while(res.next()) {
				temp[count] = new Chat(res.getString("groupnum"),res.getString("fro"),res.getString("tme"),res.getString("msg"));
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将一卡通号变为姓名
		for(int i=0; i<count; i++) {
			res = db.search("select * from userbasic where cardnum='"+ temp[i].str2 +"';");
			try {
				res.next();
				temp[i].str2 = res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 更新数据状态
		db.adm("UPDATE msglist SET type=1 WHERE too='"+ cardNum +"' AND type=0 ;");
		db.adm("UPDATE msglist SET type=3 WHERE too='"+ cardNum +"' AND type=2 ;");
		return temp;
	}
	
	public static void passFriends(String id) {
		DbOperation db = new DbOperation();
		// 通过请求
		db.adm("UPDATE requestlist SET type=3 WHERE no="+ Integer.valueOf(id) +";");
		// 加入表格
		ResultSet res = db.search("select * from requestlist WHERE no="+ Integer.valueOf(id) +";");
		String c1 = null;
		String c2 = null;
		try {
			res.next();
			c1 = res.getString("cardnum");
			c2 = res.getString("number");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.adm("INSERT INTO relationinfo (cardnum1,cardnum2) VALUES ('"+ c1 +"','"+ c2 +"');");
	}
	
	public static void passGroup(String id) {
		DbOperation db = new DbOperation();
		// 通过请求
		db.adm("UPDATE requestlist SET type=6 WHERE no="+ Integer.valueOf(id) +";");
		// 加入表格
		ResultSet res = db.search("select * from requestlist WHERE no="+ Integer.valueOf(id) +";");
		String c1 = null;
		String c2 = null;
		try {
			res.next();
			c1 = res.getString("cardnum");
			c2 = res.getString("number");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.adm("INSERT INTO usergroup (cardnum,groupnum) VALUES ('"+ c1 +"','"+ c2 +"');");
	}
	
	public static boolean sendMsg(String cardNum, String too, String content) {
		DbOperation db = new DbOperation();
		Long time = System.currentTimeMillis();  //获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(time);
		if(too.length()==9) { // 好友聊天
			db.adm("INSERT INTO msglist (tme,fro,too,groupnum,msg,type) VALUES ('"+ date +"','"+ cardNum +"','"+ 
		too+"',NULL,'"+ content +"',0);");
			return true;
		}
		else { // 群内聊天
			ResultSet res = db.search("select * from usergroup WHERE cardnum='"+ cardNum +"' AND groupnum='"+ too +"';");
			try {
				if(res.next()) {
					Vector<String> v = new Vector<String>();
					res = db.search("select * from usergroup WHERE groupnum='"+ too +"';");
					try {
						while(res.next()) {
							if(res.getString("cardnum").equals(cardNum)) {
								
							}
							else {
								v.add(res.getString("cardnum")); // 添加所有群内成员(发言的人除外)
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(String str:v) {
						db.adm("INSERT INTO msglist (tme,fro,too,groupnum,msg,type) VALUES ('"+ date +"','"+ cardNum +"','"+ 
					str+"','"+ too +"','"+ content +"',2);");
					}
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
	public static int getFriendsCount(String cardNum) {
		DbOperation db = new DbOperation();
		int count = 0;
		ResultSet res = db.search("select * from relationinfo WHERE cardnum1='"+ cardNum +"';");
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res = db.search("select * from relationinfo WHERE cardnum2='"+ cardNum +"';");
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Chat[] getFriends(String cardNum, int num) {
		DbOperation db = new DbOperation();
		Chat[] temp = new Chat[num];
		int count = 0;
		ResultSet res = db.search("select * from relationinfo WHERE cardnum1='"+ cardNum +"';");
		try {
			while(res.next()) {
				temp[count] = new Chat(res.getString("cardnum2"),null,null,null);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res = db.search("select * from relationinfo WHERE cardnum2='"+ cardNum +"';");
		try {
			while(res.next()) {
				temp[count] = new Chat(res.getString("cardnum1"),null,null,null);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将一卡通号转化为姓名
		for(int i=0; i<count; i++) {
			res = db.search("select * from userbasic WHERE cardnum='"+ temp[i].str1 +"';");
			try {
				res.next();
				temp[i].str2 = res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	public static int getGroupCount(String cardNum) {
		DbOperation db = new DbOperation();
		int count = 0;
		ResultSet res = db.search("select * from usergroup WHERE cardnum='"+ cardNum +"';");
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static Chat[] getGroup(String cardNum,int num) {
		DbOperation db = new DbOperation();
		Chat[] temp = new Chat[num];
		int count = 0;
		ResultSet res = db.search("select * from usergroup WHERE cardnum='"+ cardNum +"';");
		try {
			while(res.next()) {
				temp[count]=new Chat(res.getString("groupnum"),null,null,null);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将群号转化为群名
		for(int i=0; i<count; i++) {
			res = db.search("select * from groupinfo WHERE groupnum='"+ Integer.valueOf(temp[i].str1) +"';");
			try {
				res.next();
				temp[i].str2 = res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	public static int groupMembersCount(String no) {
		DbOperation db = new DbOperation();
		int count = 0;
		ResultSet res = db.search("select * from usergroup where groupnum='"+ no +"';");
		try {
			while(res.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static NameAndCardNum[] groupMembers(String no, int num) {
		DbOperation db = new DbOperation();
		int count = 0;
		NameAndCardNum[] temp = new NameAndCardNum[num];
		ResultSet res = db.search("select * from usergroup where groupnum='"+ no +"';");
		try {
			while(res.next()) {
				temp[count]=new NameAndCardNum(res.getString("cardnum"),null);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 将一卡通号转化为姓名
		for(int i=0; i<count; i++) {
			res = db.search("select * from userbasic where cardnum='"+ temp[i].cardNum +"';");
			try {
				res.next();
				temp[i].name = res.getString("name");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}
	
	public static void deleteMembers(String no, String cardNum) {
		DbOperation db = new DbOperation();
		db.adm("DELETE FROM usergroup where cardnum='"+ cardNum +"' AND groupnum='"+ no +"';");
		db.adm("DELETE FROM requestlist where cardnum='"+ cardNum +"' AND number='"+ no +"';");
	}
	
	public static String getHost(String no) {
		DbOperation db = new DbOperation();
		ResultSet res = db.search("select * from groupinfo WHERE groupnum="+ Integer.valueOf(no) +";");
		String temp = null;
		try {
			res.next();
			temp = res.getString("cardnum");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public static void refuseApply(String id) {
		DbOperation db = new DbOperation();
		// 查询拒绝请求类型
		ResultSet res = db.search("select * from requestlist WHERE no="+ Integer.valueOf(id) +";");
		int temp = 0;
		try {
			res.next();
			temp = res.getInt("type");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 拒绝请求
		if(temp==2) {
			db.adm("UPDATE requestlist SET type=4 WHERE no="+ Integer.valueOf(id) +";");
		}
		else if(temp==5) {
			db.adm("UPDATE requestlist SET type=7 WHERE no="+ Integer.valueOf(id) +";");
		}
	}
	
	public static void typeBack(String cardNum) {
		DbOperation db = new DbOperation();
		db.adm("UPDATE requestlist SET type=0 WHERE number='"+ cardNum +"' AND type=2;");
		db.adm("UPDATE requestlist SET type=2 WHERE number='"+ cardNum +"' AND type=5;");
	}
	
	public static void main(String []args) throws SQLException { // 测试功能函数
	
	}
}
