package server.service;

import java.io.*;
import java.net.*;

public class EmailSender {
	
	public EmailSender() {
		
	}
	
	public static void send(String host, String dest, String verificationCode) throws Exception {
		
		// smtp是25端口
				String line;
				Socket socket = new Socket(host, 25);
				
				InputStream is = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter writer = new OutputStreamWriter(os, "utf-8");
				
				line=reader.readLine();
				System.out.println(line);
				
				writer.write("HELO a\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("auth login\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("MTM2MzY0MjQ0MUBxcS5jb20=\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("ZGZtY3VrbWp1YnJhamZqaQ==\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("MAIL FROM: <1363642441@qq.com>\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("RCPT TO: <" + dest + ">\r\n");	// 确认接收者
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("DATA\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				
				// 正文
				writer.write("Subject:验证码："+ verificationCode +"。5分钟内有效。\r\n");
				writer.write("From:<1363642441@qq.com>\r\n");
				
				writer.write("\r\n.\r\n");	// 正文结束
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				writer.write("QUIT\r\n");
				writer.flush();
				line=reader.readLine();
				System.out.println(line);
				socket.close();
	}
	
	public static void main(String[]args) { // 测试功能函数
		try {
			EmailSender.send("smtp.qq.com", "213190973@seu.edu.cn", VerificationCodeGetter.get());
			System.out.println("邮件发送成功");
//			EmailSender.send("smtp.qq.com", "1501394749@qq.com", VerificationCodeGetter.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
