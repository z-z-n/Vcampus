package server.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DbOperation {
	public static Connection con;
	public Statement statement;
	public static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/vcampus?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	public static String user="root";
	public static String password="1226"; // 这里用户名和密码，每个人根据自己电脑上的配置改动
	static {
		try {
			Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
		}catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        }catch (SQLException e) {
            System.out.println("数据库连接或操作失败");
        }
	}
	public DbOperation() {
		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet search(String sql) { // 数据库查询操作，sql为数据库操作指令
		ResultSet resultSet = null;
		try {
			resultSet = this.statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	public void adm(String sql) { //adm为add delete mutify 增删改的意思
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void stop() {
//		resultSet.close();
        try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {   // 使用示例
//		DbOperation one = new DbOperation();
//		DbOperation two = new DbOperation();
//		ResultSet res = one.search("select * from userbasic");
//		ResultSet res2 = two.search("select * from userbasic");
//		try {
//			while (res.next()) {
//			    String name = null;
//			    double sex = 0;
//				name = res.getString("cardNum");
//				sex = res.getDouble("money");
//			    System.out.println(name+'\t'+sex+'\t');
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	
		Long time = System.currentTimeMillis();  //获取当前时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(time);//注意这里返回的是string类型
		System.out.println(date);
		
//		DbOperation db = new DbOperation();
//		String sql = "INSERT INTO emailcheck (cardNum,code,tme) VALUES ('213198890','111111','"+ date +"');";
//		System.out.println(sql);
//		db.adm(sql);
		
		DbOperation db2 = new DbOperation();
		String sql2 = "select tme from emailcheck where cardnum = '213198890'";
		ResultSet result = db2.search(sql2);
		try {
			while(result.next()) {
				String tme = result.getString("tme");
				Long t = format.parse(tme).getTime();
				System.out.println((System.currentTimeMillis() - t) / (1000 * 60));
				// 获取相差时间
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
