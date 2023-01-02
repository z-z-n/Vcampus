package server.common;

public class StuExtendInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public String cardNum;
	public String selfIntro;
	public String phone;
	public String email;
	public String birthYear;
	public String birthMonth;
	public String birthDate;
	public StuExtendInfo(String car, String sel, String pho, String ema, String birthY, String birthM, String birthD) {
		this.cardNum = car;
		this.birthDate = birthD;
		this.birthMonth = birthM;
		this.birthYear = birthY;
		this.email = ema;
		this.phone = pho;
		this.selfIntro = sel;
	}
}
