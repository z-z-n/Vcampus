package server.common;

public class StuBasicInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public int sex; // 0未知1男2女
	public String stuNum; // 学号
	public String cardNum;
	public StuBasicInfo(String card, String stu, int s) {
		this.cardNum = card;
		this.sex = s;
		this.stuNum = stu;
	}
}
