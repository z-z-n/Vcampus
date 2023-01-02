package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//import java.util.logging.Level;
import server.communication.*;

public class Sender {
	public static Object send(Message msg) {
		Socket socket = null;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		Message res = null;
		try {
			socket = new Socket("localhost", 8888);
			os = new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(msg); // 发送请求
			os.flush();
			// 接收处理结果
			is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Object obj = is.readObject();
			if (obj != null) {
				res = (Message)obj;
			}
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch(Exception ex) {}
			try {
				os.close();
			} catch(Exception ex) {}
			try {
				socket.close();
			} catch(Exception ex) {}
		}
		return res;
	}
}
