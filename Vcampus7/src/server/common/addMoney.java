package server.common;

public class addMoney implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public double money;
	public String cardNum;
	public addMoney(String ca, double mo) {
		this.cardNum = ca;
		this.money = mo;
	}
}
