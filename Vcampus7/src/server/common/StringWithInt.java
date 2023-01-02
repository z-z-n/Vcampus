package server.common;

public class StringWithInt implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String id; // 商品ID
	public String cardNum; // 一卡通号
	public int number; // 个数
	public StringWithInt(String id,String cardNum, int number) {
		this.id = id;
		this.cardNum = cardNum;
		this.number = number;
	}
}
