package server.common;

import java.sql.Date; // 注意使用了sql.Date!

public class HallInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public double money;
	public double moneyUsed;
	public int bookBorrowed;
	public Date date; // 这个date的类型是java.sql.date类型
	public HallInfo(double m,double mUsed, int b, Date d) {
		this.bookBorrowed = b;
		this.money = m;
		this.moneyUsed = mUsed;
		this.date = d;
	}
}
