package server.service;

import java.util.Random;

public class VerificationCodeGetter {
	public static String get() { // 返回6位数验证码
		Random r = new Random();
		int i1 = r.nextInt(10);
		int i2 = r.nextInt(10);
		int i3 = r.nextInt(10);
		int i4 = r.nextInt(10);
		int i5 = r.nextInt(10);
		int i6 = r.nextInt(10);
		String temp = Integer.toString(i1)+Integer.toString(i2)+Integer.toString(i3)
		+Integer.toString(i4)+Integer.toString(i5)+Integer.toString(i6) ;
		return temp;
	}
	
	public static void main(String[]args) {
		VerificationCodeGetter.get();
	}
}
