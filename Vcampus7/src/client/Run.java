package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import server.common.*;
import server.communication.*;

public class Run {
	public static void main(String[] args) {
//		实例三 获取文件
//		GetFile obj = new GetFile("d:\\东南大学");
//		Message msg = new Message("getFile",obj);
		
		
//		实例二 向后端传文件
//		SendFile obj = new SendFile("D:\\东南大学\\行政\\本科生选课指南.pdf","213193311","113193311");
//		Message msg = new Message("sendFile",obj);
		
		
//		实例一 登录案例
//		LoginClass obj = new LoginClass("313193311","20001226y");
//		Message msg = new Message("login", obj);
		
		
		OnlyCardNum obj = new OnlyCardNum("213193321");
		Message msg = new Message("refuseRequest", obj);
		
		
		// 发送请求(Message类)，接收结果(Message类)
		// 发送请求是着重注意instruction和data；接收时注意status和response和num(代表response数组的个数，一般为1)
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		
		
//		实例三请注释掉下面这行
		System.out.println(res.status+((UniversalClass)res.response[0]).context);
		
//		实例一 二注释掉下面这行
//		saveFile("D:/东南大学",(FileResponse)res.response[0]);
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
}
