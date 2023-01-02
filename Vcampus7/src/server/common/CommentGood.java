package server.common;

public class CommentGood implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String id; // 商品ID
	public String cardNum; // 一卡通号
	public String name; // 姓名
	public String content; // 评论内容
	public CommentGood(String id, String cardNum, String name, String content) {
		this.id = id;
		this.cardNum = cardNum;
		this.name = name;
		this.content = content;
	}
}
