package server.main;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.logging.Level;
import java.sql.SQLException;

import server.process.Process;
import server.communication.Message;

public class Demo {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("The server starting...");
		while (true) {
			Socket socket = server.accept();
			invoke(socket);
		}
	}
	
	private static void invoke(final Socket socket) throws IOException {
		new Thread(new Runnable() {
			public void run() {
				try {
					ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
					ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
					Object obj = is.readObject();
					Message content = (Message)obj;
					try {
						Process.manage(content);
					} catch (SQLException e) {
						e.printStackTrace();
					} // 请求处理
					os.writeObject(content); // 返回
					os.flush();
				}
				catch(IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}

