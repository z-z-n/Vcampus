package server.common;

public class HistoryInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String id; // 购买商品ID
	public String name; // 商品名称，若已下架则显示“该商品已下架”
	public String introduction; // 商品简介，若已下架则显示“该商品已下架”
	public double pay; // 当时花的钱
	public int num; // 购买商品的数目
	public java.sql.Date date; // 购买日期，注意日期格式是java.sql.Date
	public HistoryInfo(String id, String name, String introduction, double pay, int num, java.sql.Date date) {
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.pay = pay;
		this.num = num;
		this.date = date;
	}
}


