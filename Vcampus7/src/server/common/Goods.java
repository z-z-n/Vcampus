package server.common;

public class Goods implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String id; // 商品id
	public String name; // 商品名
	public double price;  // 商品价格
	public int number; // 商品数量
	public String introduction; // 商品简介
	public Goods(String id, String name, double price, int number, String introduction) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.introduction = introduction;
	}
}
