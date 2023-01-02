package server.common;

public class ChangeWithReason implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public String cardNum;
	public int sex; // 是否想修改性别 0否 1是
	public int stunum; // 是否想修改学号 0否 1是
	public String reason;
	public String name;
	public ChangeWithReason(String ca, int se, int st, String re, String na) {
		this.cardNum = ca;
		this.sex = se;
		this.stunum = st;
		this.reason = re;
		this.name = na;
	}
}
