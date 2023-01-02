package server.process;

import server.communication.Message;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.*;

import server.common.*;
import server.service.*;
import server.dao.*;

public class Process {
	public static void manage(Message content) throws SQLException {
		String ins = content.instruction;
		switch(ins) {
			case "login":
				System.out.println("接收到请求：login");
				login(content);
				break;
			case "sendFile":
				System.out.println("接收到请求：sendFile");
				sendFile(content);
				break;
			case "getFile":
				System.out.println("接收到请求：getFile");
				getFile(content);
				break;
			case "sendMail":
				System.out.println("接收到请求：sendMail");
				sendMail(content);
				break;
			case "register":
				System.out.println("接收到请求：register");
				register(content);
				break;
			case "borrow":
				System.out.println("接收到请求：borrow");
				borrow(content);
				break;
			case "back":
				System.out.println("接收到请求：back");
				back(content);
				break;
			case"addbook":
				System.out.println("接收到请求：addbook");
				addbook(content);
				break;
			case"deletebook":
				System.out.println("接收到请求：deletebook");
				deletebook(content);
				break;
			case"modifybook":
				System.out.println("接收到请求：modifybook");
				modifybook(content);
				break;
			case"borrowed":
				System.out.println("接收到请求：findborrowed");
				borrowed(content);
				break;
			case"findid":
				System.out.println("接收到请求：findid");
				findId(content);
				break;
			case"findname":
				System.out.println("接收到请求：findname");
				findname(content);
				break;
			case "getPhoto":
				System.out.println("接收到请求：getPhoto");
				getPhoto(content);
				break;
			case "sendPhoto":
				System.out.println("接收到请求：sendPhoto");
				sendPhoto(content);
				break;
			case "getBasic":
				System.out.println("接收到请求：getBasic");
				getBasic(content);
				break;
			case "getExtension":
				System.out.println("接收到请求：getExtension");
				getExtension(content);
				break;
			case "sendRequest":
				System.out.println("接收到请求：sendRequest");
				sendRequest(content);
				break;
			case "sendExtension":
				System.out.println("接收到请求：sendExtension");
				sendExtension(content);
				break;
			case "getAllInfo":
				System.out.println("接收到请求：getAllInfo");
				getAllInfo(content);
				break;
			case "sendBasic":
				System.out.println("接收到请求：sendBasic");
				sendBasic(content);
				break;
			case "getRequest":
				System.out.println("接收到请求：getRequest");
				getRequest(content);
				break;
			case "refuseRequest":
				System.out.println("接收到请求：refuseRequest");
				refuseRequest(content);
				break;
			case "getHallInfo":
				System.out.println("接收到请求：getHallInfo");
				getHallInfo(content);
				break;
			case "addMoney":
				System.out.println("接收到请求：addMoney");
				addMoney(content);
				break;
			case "chooseCourse":                             //教务处理新增
				System.out.println("接收到请求:chooseCourse");
				chooseCourse(content);
				break;
			case "dropCourse":                           
				System.out.println("接收到请求:dropCourse");
				dropCourse(content);
				break;	
			case "courseScheduling":
				System.out.println("接收到请求：courseScheduling");
				courseScheduling(content);
				break;
			case "gradeUpload":
				System.out.println("接收到请求：gradeUpload");
				gradeUpload(content);
				break;
			case"printSchedules":
				System.out.println("接收到请求：printSchedules");
				printSchedules(content);
				break;
			case"printCourse":
				System.out.println("接收到请求：printCourse");
				printCourse(content);
				break;
			case"comment":
				System.out.println("接收到请求：comment");
				comment(content);
				break;
			case"readcomment":
				System.out.println("接收到请求：read comment");
				readcomment(content);
				break;
			case"gethomework":
				System.out.println("接收到请求：gethomework");
				gethomework(content);
				break;
			case"setPreferTime":
				System.out.println("接收到请求：setPreferTime");
				setPreferTime(content);
				break;
			case"getGradeByT":
				System.out.println("接收到请求：getGradeByT");
				getGradeByT(content);
				break;
			case"gradeInquiry":
				System.out.println("接收到请求：gradeInquiry");
				gradeInquiry(content);
				break;
			case"editGrade":
				System.out.println("接收到请求：editGrade");
				editGrade(content);
				break;
			case"getGradeByS":
				System.out.println("接收到请求：getGradeByS");
				getGradeByS(content);
				break;
			case"getPreferTime":
				System.out.println("接收到请求：getPreferTime");
				getPreferTime(content);
				break;
			case"deleteGrade":
				System.out.println("接收到请求：deletegrade");
				deletegrade(content);
				break;
			case "setPic":                                     //商场
				System.out.println("接收到请求：setPic");
				setPic(content);
				break;
			case "addGoods":
				System.out.println("接收到请求：addGoods");
				addGoods(content);
				break;
			case "moreGoods":
				System.out.println("接收到请求：moreGoods");
				moreGoods(content);
				break;
			case "multifyPrice":
				System.out.println("接收到请求：multifyPrice");
				multifyPrice(content);
				break;
			case "deleteGoods":
				System.out.println("接收到请求：deleteGoods");
				deleteGoods(content);
				break;
			case "search":
				System.out.println("接收到请求：search");
				search(content);
				break;
			case "getDetail":
				System.out.println("接收到请求：getDetail");
				getDetail(content);
				break;
			case "getCourseName":
				System.out.println("接收到请求：getCourseName");
				getCourseName(content);
				break;
			case "getTeacherName":
				System.out.println("接收到请求：getTeacherName");
				getTeacherName(content);
				break;
			case "getComment":
				System.out.println("接收到请求：getComment");
				getComment(content);
				break;
			case "buy":
				System.out.println("接收到请求：buy");
				buy(content);
				break;
			case "commentgood":
				System.out.println("接收到请求：commentgood");
				commentg(content);
				break;
			case "addCar":
				System.out.println("接收到请求：addCar");
				addCar(content);
				break;
			case "lookCar":
				System.out.println("接收到请求：lookCar");
				lookCar(content);
				break;
			case "getPic":
				System.out.println("接收到请求：getPic");
				getPic(content);
				break;
			case "deleteCar":
				System.out.println("接收到请求：deleteCar");
				deleteCar(content);
				break;
			case "getHistory":
				System.out.println("接收到请求：getHistory");
				getHistory(content);
				break;
			case "printGrade":
				System.out.println("接收到请求：printGrade");
				printGrade(content);
				break;
			case "createGroup":
				System.out.println("接收到请求：createGroup");
				createGroup(content);
				break;
			case "searchName":
				System.out.println("接收到请求：searchName");
				searchName(content);
				break;
			case "makeFriends":
				System.out.println("接收到请求：makeFriends");
				makeFriends(content);
				break;
			case "searchGroup":
				System.out.println("接收到请求：searchGroup");
				searchGroup(content);
				break;
			case "enterGroup":
				System.out.println("接收到请求：enterGroup");
				enterGroup(content);
				break;
			case "applicationRes":
				System.out.println("接收到请求：applicationRes");
				applicationRes(content);
				break;
			case "msgRes":
				System.out.println("接收到请求：msgRes");
				msgRes(content);
				break;
			case "passFriends":
				System.out.println("接收到请求：passFriends");
				passFriends(content);
				break;
			case "passGroup":
				System.out.println("接收到请求：passGroup");
				passGroup(content);
				break;
			case "sendMsg":
				System.out.println("接收到请求：sendMsg");
				sendMsg(content);
				break;
			case "getFriends":
				System.out.println("接收到请求：getFriends");
				getFriends(content);
				break;
			case "getGroup":
				System.out.println("接收到请求：getGroup");
				getGroup(content);
				break;
			case "groupMembers":
				System.out.println("接收到请求：groupMembers");
				groupMembers(content);
				break;
			case "deleteMembers":
				System.out.println("接收到请求：deleteMembers");
				deleteMembers(content);
				break;
			case "getHost":
				System.out.println("接收到请求：getHost");
				getHost(content);
				break;
			case "refuseApply":
				System.out.println("接收到请求：refuseApply");
				refuseApply(content);
				break;
			case "typeBack":
				System.out.println("接收到请求：typeBack");
				typeBack(content);
				break;
		}
	}
	
	private static void login(Message content) {
		LoginClass obj = (LoginClass)content.data;
		String res = null;
		LoginFeedback[] temp = new LoginFeedback[1];
		String pattern = "^([1-2]1|3[1-4])3[0-9]{6}$";
		if(Pattern.matches(pattern, obj.cardNum)) { // 使用正则表达式判断一卡通号格式正确性
			try {
				res = DbService.loginCheck(obj.cardNum, obj.pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(!res.equals("密码不正确") && !res.equals("该用户未注册")) {
				content.status="200";
				if(obj.cardNum.substring(0, 1).equals("2")) { // 学生一卡通2开头，代表权限1
					temp[0] = new LoginFeedback(res,"1");
				}else if(obj.cardNum.substring(0, 1).equals("1")) { // 教师一卡通1开头，代表权限2
					temp[0] = new LoginFeedback(res,"2");
				}else if(obj.cardNum.substring(0, 2).equals("31")){ // 教务管理员
					temp[0] = new LoginFeedback(res,"3");
				}else if(obj.cardNum.substring(0, 2).equals("32")){ // 图书馆管理员
					temp[0] = new LoginFeedback(res,"4");
				}else if(obj.cardNum.substring(0, 2).equals("33")){ // 商城管理员
					temp[0] = new LoginFeedback(res,"5");
				}else if(obj.cardNum.substring(0, 2).equals("34")){ // 超级管理员
					temp[0] = new LoginFeedback(res,"6");
				}
			}
			else {
				content.status="404";
				temp[0] = new LoginFeedback(res,"无姓名");
			}
		}
		else {
			content.status="404";
			temp[0] = new LoginFeedback("不符合格式的一卡通号","无姓名");
		}
		content.response = temp;
		// 处理结束
	}
	
	private static void sendFile(Message content) throws SQLException {
		//学生给老师发文件
		try {		
			SendFile obj = (SendFile)content.data;
			String path="D:/Vcampus/作业"+"/"+obj.Filename; //后端存储文件的文件夹
			if((DbService.sf(path, obj.cardNum, obj.teacherCard)==1)){
				FileOutputStream fileOutputStream=new FileOutputStream(path);
				byte[] b = obj.bytes;
				fileOutputStream.write(b);
				fileOutputStream.close();
				UniversalClass[] temp = new UniversalClass[1];
				temp[0] = new UniversalClass("操作成功");
				content.response = temp;
				content.status="200";
			}
			else {
				UniversalClass[] temp = new UniversalClass[1];
				temp[0] = new UniversalClass("你没有选该老师的课");
				content.response = temp;
				content.status="404";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void getFile(Message content) throws SQLException {
		//老师接受并下载文件
		GetFile obj = (GetFile)content.data;
		System.out.println("存储地址："+obj.downloadPath);
		ResultSet res=DbService.gf(obj.card);
		res.next();
		FileResponse[] temp = new FileResponse[1];
		String store=res.getString("filePath");     //根据学生一卡通得到后端存放的文件		
		temp[0] = new FileResponse(store);	
		saveFile(obj.downloadPath,temp[0]);
		content.response = temp;
		content.status="200";
	}
	
	public static void saveFile(String path, FileResponse obj) {
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(path+'/'+obj.fileName);
			byte[] b = obj.bytes;
			fileOutputStream.write(b);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void sendMail(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String dest = obj.cardNum + "@seu.edu.cn";
		// 创建验证码
		String code = VerificationCodeGetter.get();
		// 发送验证码
		try {
			EmailSender.send("smtp.qq.com", dest, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 查看该一卡通号在emailcheck数据库中是否存在,存在则更新,不存在则加一条数据
		try {
			DbService.setEmail(code,obj.cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void register(Message content) {
		// 确定该一卡通是否已经被注册
		RegisterClass obj = (RegisterClass)content.data;
		String cardNum = obj.cardNum;
		UniversalClass[] temp = new UniversalClass[1];
		content.status = "404";
		try {
			if(DbService.isRegistered(cardNum)) {
				// 查看验证码的正确性
				String res = DbService.checkEmail(cardNum,obj.code);
				if(res.equals("200")) {
					// 使用正则表达式验证密码的合法性
					String pattern = "^[0-9a-zA-Z_]{8,}$";
					if(Pattern.matches(pattern, obj.pwd)){
						// 存入数据
						DbService.addUser(obj.cardNum,obj.pwd,obj.name);
						content.status = "200";
						temp[0] = new UniversalClass("注册成功");
					}
					else {
						temp[0] = new UniversalClass("密码不符合要求");
					}		
				}
				else {
					temp[0] = new UniversalClass(res);
				}
			}
			else {
				temp[0] = new UniversalClass("该一卡通已被注册");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		content.response = temp;
	}
	
	private static void borrow(Message content) throws SQLException {
		BorrowBook obj=(BorrowBook)content.data;
		String card=obj.cardNum;
		String id=obj.bookId;
		String date=obj.da;
		String res=DbService.borrow(card, id, date);
		if(res=="该书已被借出") {
			content.status="102";
		}
		else if(res=="借书量超出学生可借数"||res=="借书量超出教师可借数") {
			content.status="103";
			UniversalClass[] temp = new UniversalClass[1];
			temp[0]=new UniversalClass(res);
			content.response=temp;
		}
		else if(res=="超出学生借阅时长(5天)"||res=="超出教师借阅时长(10天)") {
			content.status="104";
			UniversalClass[] temp = new UniversalClass[1];
			temp[0]=new UniversalClass(res);
			content.response=temp;
		}
		else if(res=="没有该编号的书") {
			content.status="106";
		}
		else if(res=="借阅成功") {
			content.status="201";		
		}
	}
	
	private static void back(Message content) throws SQLException {
		BackBook obj=(BackBook) content.data;
		String card=obj.cardNum;
		String id=obj.bookId;
		String res=DbService.back(card, id);
		if(res=="归还成功") {
			content.status="202";
		}
		else {
			content.status="101";
		}
	}
	
	private static void addbook(Message content) throws SQLException {
		Book obj=(Book)content.data;
		String name=obj.bookName;
		String id=obj.bookId;
		String com=obj.compress;
		String res=DbService.addbook(id, name, com);
		if(res.equals("已有该编号的书")) {
			content.status="105";
		}
		else {
			content.status="206";
		}
	}
	
	private static void deletebook(Message content) throws SQLException {
		String obj=(String)content.data;
		String res=DbService.deletebook(obj);
		if(res=="没有该编号的书") {
			content.status="106";
		}
		else if(res=="下架成功") {
			content.status="207";
		}
		else {
			content.status="107";
		}
	}
	
	private static void modifybook(Message content) throws SQLException {
		Book obj=(Book)content.data;
		String name=obj.bookName;
		String id=obj.bookId;
		String com=obj.compress;
		String res=DbService.modifybook(id, name, com);
		if(res=="没有该编号的书") {
			content.status="106";
		}
		else if(res=="修改成功") {
			content.status="205";
		}
		else {
			content.status="107";
		}
	}
	
	private static void borrowed(Message content) throws SQLException {
		String card=(String) content.data;
		ResultSet res=DbService.findborrow(card);
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		BorrowBook[] temp = new BorrowBook[cnt];
		ResultSet res1=DbService.findborrow(card);
		while(res1.next()) {
			Date d=res1.getDate("finalDate");
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");	
			temp[i]=new BorrowBook(res1.getString("cardNum"),res1.getString("bookId"),f.format(d));
			i++;
		}
		content.num=cnt;
		content.status="203";
		content.response=temp;
	}
	
	private static void findId(Message content) throws SQLException {
		String id=(String) content.data;
		ResultSet res1=DbService.findbyid(id);
		ResultSet res=DbService.findbyid(id);
		if(res1.next()) {			
			Bookshow[] temp = new Bookshow[1];
			while(res.next()) {
				temp[0]=new Bookshow(res.getString("bookId"),res.getString("bookName"),res.getString("compress"),res.getInt("isBorrowed"));
			}
			content.status="204";
			content.response=temp;
		}
		else {
			UniversalClass[]temp=new UniversalClass[1];
			temp[0]=new UniversalClass("没有该书");
			content.response=temp;
			content.status="404";
		}
	}
	
	private static void findname(Message content) throws SQLException {
		String name=(String) content.data;
		ResultSet res=DbService.findbyname(name);
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		if(cnt>0) {
		int i=0;
		ResultSet res1=DbService.findbyname(name);
		Bookshow[] temp = new Bookshow[cnt];
		while(res1.next()) {	
			temp[i]=new Bookshow(res1.getString("bookId"),res1.getString("bookName"),res1.getString("compress"),res1.getInt("isBorrowed"));
			i++;
		}
		content.num=cnt;
		content.status="204";
		content.response=temp;
		}
		else {
			UniversalClass []temp=new UniversalClass[1];
			temp[0]=new UniversalClass("没有该名字的书");
			content.response=temp;
			content.status="404";
		}
	}
	
	
	private static void getPhoto(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String cardNum = obj.cardNum; // 获取一卡通号
		String path = null;
		try {
			path = DbService.getFilePath(cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		if(path != null) {
			FileResponse[] temp = new FileResponse[1];
			temp[0] = new FileResponse(path);
			content.response = temp;
			content.status = "200";
		}
		else {
			UniversalClass[] temp = new UniversalClass[1];
			temp[0] = new UniversalClass("该生没有上传照片");
			content.response = temp;
			content.status = "404";
		}
	}
	
	private static void sendPhoto(Message content) { // 学生上传照片
		try {
			SendFile obj = (SendFile)content.data;
			String path = "D:/Vcampus/学生照片/"+obj.Filename;
			FileOutputStream fileOutputStream=new FileOutputStream(path);
			byte[] b = obj.bytes;
			fileOutputStream.write(b);
			fileOutputStream.close();
//			System.out.println("数据库操作 "+obj.cardNum+" "+obj.teacherCard+" "+obj.Filename);
			DbService.addPhoto(obj.cardNum, path);
			UniversalClass[] temp = new UniversalClass[1];
			temp[0] = new UniversalClass("操作成功");
			content.response = temp;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		content.status="200";
	}
	
	private static void getBasic(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String cardNum = obj.cardNum; // 获取一卡通号
		StuBasicInfo[] temp = new StuBasicInfo[1];
		try {
			temp[0] = DbService.getStuBasic(cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		content.response = temp;
		content.status = "200";
	}
	
	private static void getExtension(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String cardNum = obj.cardNum; // 获取一卡通号
		StuExtendInfo[] temp = new StuExtendInfo[1];
		try {
			temp[0] = DbService.getStuExtension(cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		content.response = temp;
		content.status = "200";
	}
	
	private static void sendRequest(Message content) {
		ChangeWithReason obj = (ChangeWithReason)content.data;
		// 数据库操作
		try {
			DbService.addRequest(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("申请成功，等待教务管理员审核");
		content.response = temp;
		content.status = "200";
	}
	
	private static void sendExtension(Message content) {
		StuExtendInfo obj = (StuExtendInfo)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		String pattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$" ;
		if(obj.email == null|| obj.email.equals("") ||Pattern.matches(pattern, obj.email)) {
			// 数据库操作
			DbService.setStuExtension(obj);
			// 向前端返回结果
			temp[0] = new UniversalClass("修改成功");
			content.response = temp;
			content.status = "200";
		}
		else {
			temp[0] = new UniversalClass("请输入正确的邮箱格式");
			content.response = temp;
			content.status = "404";
		}
	}
	
	private static void getAllInfo(Message content) {
		int count = DbService.getStuNameAndCardNumCount();
		NameAndCardNum[] temp = DbService.getStuNameAndCardNum(count);
		content.response = temp;
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void sendBasic(Message content) {
		StuBasicInfo obj = (StuBasicInfo)content.data;
		DbService.setStuBasicInfo(obj);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("修改成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void getRequest(Message content) {
		int count = DbService.getInfoRequestCount();
		ChangeWithReason[] temp = DbService.getInfoRequest(count);
		content.response = temp;
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void refuseRequest(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		DbService.refuseRequest(obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void getHallInfo(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		HallInfo[] temp = new HallInfo[1];
		try {
			temp[0] = DbService.getHallInfo(obj.cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		content.response = temp;
		content.status = "200";
	}
	
	private static void addMoney(Message content) {
		addMoney obj = (addMoney)content.data;
		try {
			DbService.addMoney(obj.cardNum, obj.money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void chooseCourse(Message content) {
		//学生选课请求响应函数
		StuCourse obj = (StuCourse)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		content.status="404";
		try {
			if(DbService.isRegistered(obj.cardNum)==false) {
					if(DbService.isCourse(obj.courseId)) {
							if(DbService.courseConflicts(obj.cardNum,obj.courseId)) {
								if(DbService.addcnt(obj.courseId)==1) {
									DbService.addChoosedCourse(obj.cardNum,obj.courseId);					
									content.status="200";
									temp[0]=new UniversalClass("选课成功");
								}
								else {
									temp[0]=new UniversalClass("课容量已满");
								}
							}
							else {
								temp[0]=new UniversalClass("课程冲突");
							}
					}
					else {
						temp[0]=new UniversalClass("课程不存在");
					}
			}
			else {
				temp[0]=new UniversalClass("学生未注册");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		content.response=temp;
      }
	
	private static void dropCourse(Message content) throws SQLException {
		StuCourse obj=(StuCourse)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		if(DbService.dropchoosedcourse(obj.cardNum,obj.courseId)==0) {
			temp[0]=new UniversalClass("没有选择该课程");
			content.status="404";
		}
		else {
			content.status="200";
			temp[0]=new UniversalClass("退选成功");
		}
		content.response=temp;
	}
	
	private static void setPreferTime(Message content) throws SQLException {
		//教师设置预期时间
		CourseScheduling obj = (CourseScheduling)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		DbService.setTime(obj.prefertime,obj.teacherCard);
		if(obj.prefertime!=null) {
			temp[0]=new UniversalClass("预期课程时间设置成功");
		}else {
			temp[0]=new UniversalClass("默认时间设置成功");
		}
		content.status="200";
		content.response=temp;
	}
	
	private static void courseScheduling(Message content) {
		//教务排课请求响应函数
		CourseScheduling obj = (CourseScheduling)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		content.status="404";
		try {
			if(DbService.registeredCheck(obj.teacherCard)) {
				String pattern="^[a-t]+";
				if(Pattern.matches(pattern, obj.courseTime)) {
					if(DbService.typeconflict(obj.courseTime, obj.type)==1) {
						if(DbService.checkclassroom(obj.classroom,obj.courseTime)==0) {
							DbService.addCourse(obj.courseId,obj.teacherCard,obj.courseName,obj.courseTime,obj.classroom,obj.capacity,obj.prefertime,obj.type);
							content.status="200";
							temp[0]=new UniversalClass("排课成功");
						}
						else {						
							temp[0]=new UniversalClass("教室冲突");				
						}
					}
					else {
						temp[0]=new UniversalClass("必修课时间冲突");
					}
				}
			}
			else {
				temp[0]=new UniversalClass("该课程教师不存在");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		content.response=temp;
	}	
	
	private static void gradeUpload(Message content) {
		//学生选课请求响应函数
		GradeClass obj = (GradeClass)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		content.status="404";
		try {
			  if(DbService.registeredCheck(obj.cardNum)) {
				  if(DbService.isCourse(obj.courseId)) {
					  if(DbService.gradeCheck(obj.cardNum,obj.courseId)) {
						  if(obj.score>=0&&obj.score<=100) {
							  DbService.scoreUpload(obj.cardNum,obj.courseId,obj.score);
							  content.status="200";
							  temp[0]=new UniversalClass("成绩上传成功");
						  }
						  else {
							  temp[0]=new UniversalClass("请检查输入成绩是否有效");
						  }
					  }
					  else {
						  temp[0]=new UniversalClass("成绩已存在");
					  } 
				  }
				  else {
					  temp[0]=new UniversalClass("课程不存在，请检查输入课程是否正确");
				  }
			}
			  else {
				  temp[0]=new UniversalClass("学生未注册，请检查输入学生一卡通号是否正确");
			  }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		content.response=temp;
      }
	
	private static void getGradeByS(Message content) throws SQLException {
		//课程名查成绩
		GradeClass obj = (GradeClass)content.data;
		String courseId=DbService.getCourseId2(obj.courseId);
		GradeClass[] temp = new GradeClass[1];
		content.status="404";
		if(courseId!=null) {
			ResultSet res=DbService.scoreInquiryByT2(courseId,obj.cardNum);
			if(res.next()) {
				temp[0]=new GradeClass(res.getString("cardNum"),res.getString("courseId"),res.getInt("score"));
				content.status="200";
			}else {
				temp[0]=new GradeClass("该课程成绩暂未上传");
			}
		}else {
			temp[0]=new GradeClass("课程不存在，请检查输入课程是否正确");
		}
		content.response=temp;
      }
	private static void printCourse(Message content) throws SQLException {
		//打印已有课程
		content.status="404";
		ResultSet res=DbService.sendCourse();
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		if(cnt!=0) {
			CourseScheduling[] temp = new CourseScheduling[cnt];
			ResultSet res1=DbService.sendCourse();
			while(res1.next()) {
				temp[i]=new CourseScheduling(res1.getString("courseId"),res1.getString("teacherCard"),res1.getString("courseName"),res1.getString("courseTime"),
						res1.getString("classroom"),res1.getInt("capacity"),res1.getInt("type"));
				i++;
			}
			content.num=cnt;
			content.status="200";
			content.response=temp;
		}else {
			CourseScheduling[] temp = new CourseScheduling[1];
			temp[0]=new CourseScheduling("暂未排课，请排课后查询");
			content.num=1;
			content.status="404";
			content.response=temp;
		}
		
	}
	
	private static void printGrade(Message content) throws SQLException {
		GradeClass obj=(GradeClass)content.data;
		ResultSet res=DbService.printScore();
		content.status="404";
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		if(cnt!=0) {
			ResultSet res1=DbService.printScore();
			GradeClass[] temp = new GradeClass[cnt];
			while(res1.next()) {
				temp[i]=new GradeClass(res1.getString("cardNum"),res1.getString("courseId"),res1.getInt("score"));
				i++;
			}
		    content.status="200";
			content.response=temp; 
			content.num=cnt;	
		}else {
			GradeClass[] temp = new GradeClass[1];
			temp[0]=new GradeClass("暂无上传成绩");
			content.num=1;
			content.status="404";
			content.response=temp;
		}	
      }

	private static void printSchedules(Message content) throws SQLException {
		//学生课表请求响应函数
		StuCourse obj = (StuCourse)content.data;
		String cardNum = obj.cardNum;
		ResultSet res=DbService.sendschedule(cardNum);
		content.status="404";
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		if(cnt!=0) {
			ResultSet res1=DbService.sendschedule(cardNum);
			StuCourse[] temp = new StuCourse[cnt];
			while(res1.next()) {
				temp[i]=new StuCourse(res1.getString("cardNum"),res1.getString("teacherCard"),res1.getString("courseId"),res1.getString("courseTime"));
				i++;
			}
		    content.status="200";
			content.response=temp; 
			content.num=cnt;	
		}else {
			StuCourse[] temp = new StuCourse[1];
			temp[0]=new StuCourse("暂未选课，请先选课后查询课表");
			content.num=1;
			content.status="404";
			content.response=temp;
		}	
      }
	
	private static void comment(Message content) throws SQLException {
		//老师给评语
		comment obj=(comment)content.data;
		String tc=obj.teachercard;
		String comment=obj.comment;
		String card=obj.cardNum;
		UniversalClass []temp=new UniversalClass[1];
		DbService.comment(card, tc,comment);
		content.status="200";
		temp[0]=new UniversalClass("批改成功");
		content.response=temp;
	}
	
	private static void getTeacherName(Message content) throws SQLException {
		StuCourse obj=(StuCourse)content.data;
		UniversalClass []temp=new UniversalClass[1];
		String res=DbService.getTN(obj.cardNum);
		content.status="200";
		temp[0]=new UniversalClass(res);
		content.response=temp;
	}
	
	private static void getCourseName(Message content) throws SQLException {
		StuCourse obj=(StuCourse)content.data;
		UniversalClass []temp=new UniversalClass[1];
		String res=DbService.getCN(obj.cardNum);
		content.status="200";
		temp[0]=new UniversalClass(res);
		content.response=temp;
	}
	
	private static void readcomment(Message content) throws SQLException {
		comment obj=(comment)content.data;
		String card=obj.cardNum;
		String tc=obj.teachercard;
		ResultSet res=DbService.readcomment(card,tc);
		if(res.next()) {
			int correct=res.getInt("correct");
			if(correct==1) {
				content.status="200";
				String co=res.getString("comment");
				UniversalClass []temp=new UniversalClass[1];
				temp[0]=new UniversalClass(co);
				content.response=temp;
			}
			else {
				UniversalClass []temp=new UniversalClass[1];
				temp[0]=new UniversalClass("作业尚未批改");
				content.response=temp;
				content.status="100";
			}
		}
		else {
			content.status="404";
			UniversalClass []temp=new UniversalClass[1];
			temp[0]=new UniversalClass("没有该提交记录");
			content.response=temp;
		}
	}
   
	private static void gethomework(Message content) throws SQLException {
		//老师查看学生提交的记录
		String obj=(String)content.data;
		ResultSet res=DbService.gethomework(obj);
		ResultSet res1=DbService.gethomework(obj);
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		if(cnt==0) {
			content.status="404";
			UniversalClass []temp=new UniversalClass[1];
			temp[0]=new UniversalClass("无学生提交记录");
			content.response=temp;
		}
		else {
			int i=0;
			comment []temp=new comment[cnt];
			content.num=cnt;
			while(res1.next()) {
				temp[i]=new comment(res1.getString("cardNum"));
				i++;
			}
			content.response=temp;
			content.status="200";
		}
	}
	
	private static void getGradeByT(Message content) throws SQLException {
		//查看老师上传的成绩
		GradeClass obj = (GradeClass)content.data;
		String courseId=DbService.getCourseId(obj.cardNum);
		ResultSet res=DbService.scoreInquiryByT(courseId);
		content.status="404";
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		if(cnt!=0) {
			GradeClass[] temp = new GradeClass[cnt];
			ResultSet res1=DbService.scoreInquiryByT(courseId);
			try {
				  while(res1.next()) {
						temp[i]=new GradeClass(res1.getString("cardNum"),res1.getString("courseId"),res1.getInt("score"));
						i++;
				  }
			}catch(SQLException e) {
				e.printStackTrace();
			}
			content.num=cnt;
			content.status="200";
			content.response=temp;
		}else {
			GradeClass[] temp = new GradeClass[1];
			temp[0]=new GradeClass("您暂未上传成绩");
			content.num=1;
			content.status="404";
			content.response=temp;
		}	
	}
	
	private static void gradeInquiry(Message content) throws SQLException {
		//查看学生的所有成绩
		GradeClass obj = (GradeClass)content.data;
		ResultSet res=DbService.scoreInquiry(obj.cardNum);
		content.status="404";
		int cnt=0;
		while(res.next()) {
			cnt++;
		}
		int i=0;
		if(cnt!=0) {
			GradeClass[] temp = new GradeClass[cnt];
			ResultSet res1=DbService.scoreInquiry(obj.cardNum);
			while(res1.next()) {
				temp[i]=new GradeClass(res1.getString("cardNum"),res1.getString("courseId"),res1.getInt("score"));
				i++;
			}
			content.num=cnt;
			content.status="200";
			content.response=temp;
		}else {
			GradeClass[] temp = new GradeClass[1];
			temp[0]=new GradeClass("暂未可查询成绩");
			content.num=1;
			content.status="404";
			content.response=temp;
		}
  	}
	private static void editGrade(Message content) throws SQLException {
		GradeClass obj = (GradeClass)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		try {
			DbService.editScore(obj.cardNum,obj.courseId,obj.score);
			content.status="200";
			temp[0]=new UniversalClass("编辑成功");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		content.response=temp;
	}
	
	private static void getPreferTime(Message content) throws SQLException {
		//教师设置预期时间
		CourseScheduling obj = (CourseScheduling)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		String res=DbService.getTime(obj.teacherCard);
		content.status="200";
		temp[0]=new UniversalClass(res);
		content.response=temp;
	}
	
	private static void deletegrade(Message content) {
		GradeClass obj=(GradeClass)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		DbService.deletegrade(obj.cardNum, obj.courseId);
		content.status="200";
		temp[0]=new UniversalClass("删除成绩成功");
		content.response=temp;
	}

	
	//商场
	private static void setPic(Message content) {
		SendFile obj = (SendFile)content.data;
		String path = "D:/Vcampus/商品照片/"+obj.Filename;
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(path);
			byte[] b = obj.bytes;
			fileOutputStream.write(b);
			fileOutputStream.close();
			DbService.setPic(obj.cardNum, path); // 将该商品ID和对应存储路径存到数据库里面
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void addGoods(Message content) {
		Goods obj = (Goods)content.data;
		String res = null;
		UniversalClass[] temp = new UniversalClass[1];
		try {
			res = DbService.addGoods(obj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res.equals("操作成功")) {
			content.status = "200";
		}
		else {
			content.status = "404";
		}
		temp[0] = new UniversalClass(res);
		content.response = temp;
	}
	
	private static void moreGoods(Message content) {
		StringWithInt obj = (StringWithInt)content.data;
		try {
			DbService.moreGoods(obj.id, obj.number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void multifyPrice(Message content) {
		addMoney obj = (addMoney)content.data;
		DbService.multifyPrice(obj.cardNum,obj.money);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void deleteGoods(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		DbService.deleteGoods(obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void search(Message content) {
		UniversalClass obj = (UniversalClass)content.data;
		String word = obj.context;
		int count = DbService.getSearchCount(word);
		Goods[] temp = DbService.getSearch(count, word);
		content.response = temp;	 
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void getDetail(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		Goods[] temp = new Goods[1];
		try {
			temp[0] = DbService.getDetail(obj.cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		content.response = temp;
		content.status = "200";
	}
	
	private static void getComment(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String id = obj.cardNum;
		int count = DbService.getCommentCount(id);
		CommentGood[] temp = DbService.getComment(count, id);
		content.response = temp;	 
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void buy(Message content) {
		StringWithInt obj = (StringWithInt)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		String res = null;
		try {
			res = DbService.buy(obj.id, obj.cardNum, obj.number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res.equals("操作成功")) {
			content.status = "200";
		}
		else {
			content.status = "404";
		}
		temp[0] = new UniversalClass(res);
		content.response = temp;
	}
	
	private static void commentg(Message content) {
		CommentGood obj = (CommentGood)content.data;
		DbService.commentg(obj.cardNum, obj.id, obj.content);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void addCar(Message content) {
		StringWithInt obj = (StringWithInt)content.data;
		String res = null;
		try {
			res = DbService.addCar(obj.cardNum, obj.id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass(res);
		content.response = temp;
		if(res.equals("操作成功")) {
			content.status = "200";
		}
		else {
			content.status = "404";
		}
	}
	
	private static void lookCar(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.lookCarCount(obj.cardNum);
		Goods[] temp = DbService.lookCar(count, obj.cardNum);
		content.response = temp;	 
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void getPic(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String path = null;
		try {
			path = DbService.getPicPath(obj.cardNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 向前端返回结果
		if(path != null) {
			FileResponse[] temp = new FileResponse[1];
			temp[0] = new FileResponse(path);
			content.response = temp;
			content.status = "200";
		}
		else {
			UniversalClass[] temp = new UniversalClass[1];
			temp[0] = new UniversalClass("该商品没有效果图");
			content.response = temp;
			content.status = "404";
		}
	}
	
	private static void deleteCar(Message content) {
		StringWithInt obj = (StringWithInt)content.data;
		DbService.deleteCar(obj.id, obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void getHistory(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.getHistoryCount(obj.cardNum);
		HistoryInfo[] temp = DbService.getHistory(obj.cardNum, count);
		content.response = temp;	 
		content.num = count; // 返回对象的个数
		content.status = "200";
	}
	
	private static void createGroup(Message content) {
		Chat obj = (Chat)content.data;
		String no = DbService.createGroup(obj.str1,obj.str2);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass(no);
		content.response = temp;
		content.status = "200";
	}
	
	private static void searchName(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String name = DbService.searchName(obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass(name);
		content.response = temp;
		if(name.equals("查不到")) {
			content.status="404";
		}
		else {
			content.status="200";
		}
	}
	
	private static void makeFriends(Message content) {
		Chat obj = (Chat)content.data;
		boolean res = DbService.makeFriends(obj.str1,obj.str2,obj.str3);
		UniversalClass[] temp = new UniversalClass[1];
		if(obj.str1.equals(obj.str2)) {
			temp[0] = new UniversalClass("不能添加自己为好友");
			content.status = "404";
		}
		else {
			if(res) {
				temp[0] = new UniversalClass("操作成功");
				content.status = "200";
			}
			else {
				temp[0] = new UniversalClass("你已提交好友申请或已是好友");
				content.status = "404";
			}
		}
		content.response = temp;
	}
	
	private static void searchGroup(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String name = DbService.searchGroup(obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass(name);
		content.response = temp;
		if(name.equals("查不到")) {
			content.status="404";
		}
		else {
			content.status="200";
		}
	}
	
	private static void enterGroup(Message content) {
		Chat obj = (Chat)content.data;
		boolean res = DbService.enterGroup(obj.str1,obj.str2,obj.str3);
		UniversalClass[] temp = new UniversalClass[1];
		if(res) {
			temp[0] = new UniversalClass("操作成功");
			content.status = "200";
		}
		else {
			temp[0] = new UniversalClass("你已提交入群申请或已是入群");
			content.status = "404";
		}
		content.response = temp;
	}
	
	private static void applicationRes(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.applicationResCount(obj.cardNum);
		if(count==0) {
			content.status = "404";
			content.num = 0;
		}
		else {
			Chat[] temp = DbService.applicationRes(count, obj.cardNum);
			content.response = temp;	 
			content.num = count; // 返回对象的个数
			content.status = "200";
		}
	}
	
	private static void msgRes(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.msgResCount(obj.cardNum);
		if(count==0) {
			content.status = "404";
			content.num = 0;
		}
		else {
			Chat[] temp = DbService.msgRes(count, obj.cardNum);
			content.response = temp;	 
			content.num = count; // 返回对象的个数
			content.status = "200";
		}
	}
	
	private static void passFriends(Message content) {
		UniversalClass obj = (UniversalClass)content.data;
		DbService.passFriends(obj.context);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void passGroup(Message content) {
		UniversalClass obj = (UniversalClass)content.data;
		DbService.passGroup(obj.context);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void sendMsg(Message content) {
		Chat obj = (Chat)content.data;
		UniversalClass[] temp = new UniversalClass[1];
		boolean res =  DbService.sendMsg(obj.str1,obj.str2,obj.str3);
		if(res) {
			temp[0] = new UniversalClass("操作成功");
			content.status = "200";
		}
		else {
			temp[0] = new UniversalClass("您已被请出群聊");
			content.status = "404";
		}
		content.response = temp;
	}
	
	private static void getFriends(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.getFriendsCount(obj.cardNum);
		if(count==0) {
			content.status = "404";
			content.num = 0;
		}
		else {
			Chat[] temp = DbService.getFriends(obj.cardNum, count);
			content.response = temp;	 
			content.num = count; // 返回对象的个数
			content.status = "200";
		}
	}
	
	private static void getGroup(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.getGroupCount(obj.cardNum);
		if(count==0) {
			content.status = "404";
			content.num = 0;
		}
		else {
			Chat[] temp = DbService.getGroup(obj.cardNum, count);
			content.response = temp;	 
			content.num = count; // 返回对象的个数
			content.status = "200";
		}
	}
	
	private static void groupMembers(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		int count = DbService.groupMembersCount(obj.cardNum);
		if(count==0) {
			content.status = "404";
			content.num = 0;
		}
		else {
			NameAndCardNum[] temp = DbService.groupMembers(obj.cardNum, count);
			content.response = temp;	 
			content.num = count; // 返回对象的个数
			content.status = "200";
		}
	}
	
	private static void deleteMembers(Message content) {
		Chat obj = (Chat)content.data;
		DbService.deleteMembers(obj.str1,obj.str2);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void getHost(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		String res = DbService.getHost(obj.cardNum);
		OnlyCardNum[] temp = new OnlyCardNum[1];
		temp[0] = new OnlyCardNum(res);
		content.response = temp;
		content.status = "200";
	}
	
	private static void refuseApply(Message content) {
		UniversalClass obj = (UniversalClass)content.data;
		DbService.refuseApply(obj.context);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
	
	private static void typeBack(Message content) {
		OnlyCardNum obj = (OnlyCardNum)content.data;
		DbService.typeBack(obj.cardNum);
		UniversalClass[] temp = new UniversalClass[1];
		temp[0] = new UniversalClass("操作成功");
		content.response = temp;
		content.status = "200";
	}
}

