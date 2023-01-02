package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import client.Sender;
import client.service.JTextFieldHintListener;//默认内容类
import server.common.*;
import server.communication.Message;


public class RegisterUI extends JFrame {

	private String UserID;//账号
	private String UserName;//姓名
	private String UserBirth;//生日
	private String UserPassWord;//密码
	private String UserRePassWord;//确认密码
	private String UserVercode;//验证码
	private int UserID_flag=0;//不为空/样例
	//private int Birth_flag=0;//日期符合规则为1
	private int Name_flag=0;//姓名符合规则为1
	private int Pass_flag=0;//密码符合规则为1
	private int RePass_flag=0;//确认密码相同为1
	private JPanel contentPane;
	private JTextField textField_UserID;
	private JTextField textField_Password;
	private JTextField textField_RePassword;
	private JTextField textField_VerCode;
	private JTextField textField_year;
	private JTextField textField_month;
	private JTextField textField_day;
	private JTextField textField_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new RegisterUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 判断姓名大于等于2小于等于4，只含有汉字
	 */
	public boolean isName(String str) {
	    String regex = "^[\\u4e00-\\u9fa5]+$";
	    boolean flag1=(1<str.length()&&str.length()<5)?true:false;
	    boolean flag2=str.matches(regex);
	    return (flag1==true&&flag2==true)?true:false;
	  }
	/**
	 * 判断密码是否符合大于等于8位，只含有数字，字母和_
	 */
	public boolean isLetterDigitOr_(String str) {
	    String regex = "^[_a-z0-9A-Z]+$";
	    boolean flag1=(str.length()<8)?false:true;
	    boolean flag2=str.matches(regex);
	    return (flag1==true&&flag2==true)?true:false;
	  }
	/**
	 * 判断日期是否合法，利用java.text.SimpleDateFormat类进行判断
	 */
	public boolean isDate(String str1,String str2,String str3) {
		boolean result = true;
        String temp1=str1+"-"+str2+"-"+str3;//统一格式
		try{
			//规定格式 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//获取当前时间
			String nowdate = sdf.format(new Date());
			sdf.setLenient(false);//此处指定日期/时间解析是否不严格，在true是不严格，false时为严格
			Date setdate = sdf.parse(temp1);//从给定字符串的开始解析文本,设置的日期
			//时间date类型 和 时间String类型
			if(setdate.getTime()<=sdf.parse(nowdate).getTime()){//小于当前日期
				if(Integer.parseInt(str1)>1950) {//年大于1950
					result = true;}
				else {
					result = false;
				}				
			}
			else{
				result = false;
			}
		}catch(Exception e){//判断是否符合最基本的日期规范
			result = false;
		}
		return result;
    }
	/**
	 * 判断账号是否合法
	 
	public boolean isIDempty(String str) {
        boolean result = false;
        if(str==" 账号"){ 
            result = true;
        }
        return result;
    }*/
	/**
	 * Create the frame.
	 */
	public RegisterUI() {
		final JFrame jf =new JFrame();
		jf.setTitle("Vcampus Register");//标头
		jf.setResizable(false);//不能更改大小
		jf.setVisible(true);//显示界面
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 430, 410);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		jf.setContentPane(contentPane);
		jf.setLocationRelativeTo(null);//居中
		contentPane.setBackground(Color.decode("#eeeced"));//设置背景颜色
		contentPane.setFocusable(true);//默认启动时光标不在文本框内
		contentPane.setLayout(null);
		
		//插入图片,上下间距40
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("picture/sign.png"));
		lblNewLabel.setBounds(160, 15, 80, 105);
		//lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);//控件居中
		contentPane.add(lblNewLabel);
		
		//账号文本框
		textField_UserID = new JTextField();
		//textField_UserID.addFocusListener(new JTextFieldHintListener(textField_UserID, " 账号"));//默认文本为账号
		textField_UserID.setForeground(Color.GRAY);
		textField_UserID.setText(" 账号");//默认文本
		//重定义光标响应(光标不在账号文本框内，判断)
		textField_UserID.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_UserID.getText();
				if(temp.equals(" 账号")) {
					textField_UserID.setText("");
					textField_UserID.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_UserID.getText();
				if(temp1.equals("")) {
					UserID_flag=0;//标志账号不符合规则
					textField_UserID.setForeground(Color.GRAY);
					textField_UserID.setText(" 账号");
				}
				else {
					UserID_flag=1;//标志账号符合规则
				}
				
			}
			
		});	
		textField_UserID.setBounds(124, 120, 186, 30);
		contentPane.add(textField_UserID);
		textField_UserID.setColumns(10);
		//图标
		JLabel lblLabel_User = new JLabel();
		lblLabel_User.setIcon(new ImageIcon("picture/User.png"));
		lblLabel_User.setBounds(90, 120, 30, 27);
		contentPane.add(lblLabel_User);
		
		//*************************************************************
		/*
		//生日
		//插入图
		JLabel lblLabel_birth = new JLabel();
		lblLabel_birth.setIcon(new ImageIcon("picture/User.png"));
		lblLabel_birth.setBounds(90, 163, 30, 27);
		contentPane.add(lblLabel_birth);
		//年
		JLabel lblLabel_year = new JLabel("\u5E74");
		lblLabel_year.setBounds(171, 165, 21, 22);
		contentPane.add(lblLabel_year);
		//月
		JLabel lblLabel_month = new JLabel("\u6708");
		lblLabel_month.setBounds(229, 165, 21, 22);
		contentPane.add(lblLabel_month);
		//日
		JLabel lblLabel_day = new JLabel("\u65E5");
		lblLabel_day.setBounds(290, 165, 21, 22);
		contentPane.add(lblLabel_day);
		//基本合法性判断
		JLabel lblLabel_DataJudge = new JLabel("");
		lblLabel_DataJudge.setBounds(320, 163, 45, 27);
		contentPane.add(lblLabel_DataJudge);
		
		//年
		textField_year = new JTextField();
		textField_year.setForeground(Color.GRAY);
		textField_year.setText("例1999");//默认文本
		//重定义光标响应(光标不在年文本框内，判断)
		textField_year.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_year.getText();
				if(temp.equals("例1999")) {
					textField_year.setText("");
					textField_year.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_year.getText();
				String temp2 = textField_month.getText();
				String temp3 = textField_day.getText();
				if(temp1.equals("")) {
					textField_year.setForeground(Color.GRAY);
					textField_year.setText("例1999");
					Birth_flag=0;//标志日期不符合规则
					lblLabel_DataJudge.setText("");
				}
				else {
					if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
						lblLabel_DataJudge.setText("√");
						lblLabel_DataJudge.setForeground(Color.green);
						Birth_flag=1;//标志日期符合规则
					}
					else
					{
						lblLabel_DataJudge.setForeground(Color.red);
						lblLabel_DataJudge.setText("×");
						Birth_flag=0;//标志日期不符合规则
					}
				}
				
			}
			
		});	
		textField_year.setBounds(124, 162, 45, 28);
		contentPane.add(textField_year);
		textField_year.setColumns(10);
		
		
        //月
		textField_month = new JTextField();
		textField_month.setForeground(Color.GRAY);
		textField_month.setText("例 1");//默认文本
		//重定义光标响应(光标不在月文本框内，判断)
		textField_month.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_month.getText();
				if(temp.equals("例 1")) {
					textField_month.setText("");
					textField_month.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_year.getText();
				String temp2 = textField_month.getText();
				String temp3 = textField_day.getText();
				if(temp2.equals("")) {
					textField_month.setForeground(Color.GRAY);
					textField_month.setText("例 1");
					Birth_flag=0;//标志日期不符合规则
					lblLabel_DataJudge.setText("");
				}
				else {
					if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
						lblLabel_DataJudge.setText("√");
						lblLabel_DataJudge.setForeground(Color.green);
						Birth_flag=1;//标志日期符合规则
					}
					else
					{
						lblLabel_DataJudge.setForeground(Color.red);
						lblLabel_DataJudge.setText("×");
						Birth_flag=0;//标志日期不符合规则
					}
				}
				
			}
			
		});	
		textField_month.setBounds(192, 162, 36, 28);
		contentPane.add(textField_month);
		textField_month.setColumns(10);
		
		//日
		textField_day = new JTextField();
		textField_day.setForeground(Color.GRAY);
		textField_day.setText("例 1");//默认文本
		//重定义光标响应(光标不在日文本框内，判断)
		textField_day.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_day.getText();
				if(temp.equals("例 1")) {
					textField_day.setText("");
					textField_day.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_year.getText();
				String temp2 = textField_month.getText();
				String temp3 = textField_day.getText();
				if(temp3.equals("")) {
					textField_day.setForeground(Color.GRAY);
					textField_day.setText("例 1");
					lblLabel_DataJudge.setText("");
					Birth_flag=0;//标志日期不符合规则
				}
				else {
					if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
						lblLabel_DataJudge.setText("√");
						lblLabel_DataJudge.setForeground(Color.green);
						Birth_flag=1;//标志日期符合规则
					}
					else
					{
						lblLabel_DataJudge.setForeground(Color.red);
						lblLabel_DataJudge.setText("×");
						Birth_flag=0;//标志日期不符合规则
					}
				}
				
			}
			
		});		
		textField_day.setBounds(246, 162, 42, 28);
		contentPane.add(textField_day);
		textField_day.setColumns(10);
		*/
		//************************************************************* 
		//图标
		JLabel lblLabel_UserName = new JLabel();
		lblLabel_UserName.setIcon(new ImageIcon("picture/User.png"));
		lblLabel_UserName.setBounds(90, 157, 30, 27);
		contentPane.add(lblLabel_UserName);
        //判断
		JLabel lbllabel_NameJudge = new JLabel("");
		lbllabel_NameJudge.setBounds(320, 165, 81, 22);
		contentPane.add(lbllabel_NameJudge);
		//姓名输入
		textField_Name = new JTextField();
		textField_Name.setText(" 姓名");
		textField_Name.setForeground(Color.GRAY);
		//重定义光标响应(光标不在账号文本框内，判断)
		textField_Name.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_Name.getText();
				if(temp.equals(" 姓名")) {
					textField_Name.setText("");
					textField_Name.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_Name.getText();
				if(temp1.equals("")) {
					textField_Name.setForeground(Color.GRAY);
					textField_Name.setText(" 姓名");
					Name_flag=0;//标志账号不符合规则
					lbllabel_NameJudge.setText("");	
				}
				else if(isName(temp1)){
					lbllabel_NameJudge.setText("√");	
					lbllabel_NameJudge.setForeground(Color.green);
					Name_flag=1;//标志姓名符合规则
				}
				else {
					lbllabel_NameJudge.setText("×");
					lbllabel_NameJudge.setForeground(Color.red);
					Name_flag=1;//标志姓名不符合规则
				}
				
			}
			
		});			
		textField_Name.setColumns(10);
		textField_Name.setBounds(124, 157, 186, 30);
		contentPane.add(textField_Name);

		//************************************************************* 
		//密码输入规则
		JLabel lblLabel_PasswRule = new JLabel("*8位及以上数字、字母和下划线");
		lblLabel_PasswRule.setFont(new Font("宋体", Font.PLAIN, 13));
		lblLabel_PasswRule.setBounds(124, 185, 275, 27);
		contentPane.add(lblLabel_PasswRule);
        //判断
		JLabel lbllabel_passwJudge = new JLabel("");
		lbllabel_passwJudge.setBounds(318, 209, 81, 22);
		contentPane.add(lbllabel_passwJudge);
		//确认密码判断
		JLabel lblLabel_rePasswJudge = new JLabel("");
		lblLabel_rePasswJudge.setBounds(318, 249, 81, 22);
		contentPane.add(lblLabel_rePasswJudge);
		
		//密码文本框
		textField_Password = new JPasswordField();
		//textField_Password = new JTextField();
		textField_Password.setForeground(Color.GRAY);
		((JPasswordField) textField_Password).setEchoChar((char)0);//不隐藏
		textField_Password.setText(" 密码");//默认文本
		//重定义光标响应
		textField_Password.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_Password.getText();
				((JPasswordField) textField_Password).setEchoChar('*');//隐藏
				if(temp.equals(" 密码")) {
					textField_Password.setText("");
					textField_Password.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp = textField_Password.getText();
				if(temp.equals("")) {
					textField_Password.setForeground(Color.GRAY);
					((JPasswordField) textField_Password).setEchoChar((char)0);
					textField_Password.setText(" 密码");
					lbllabel_passwJudge.setText("");
					Pass_flag=0;//标志密码不符合规则
				}
				else {
					if(isLetterDigitOr_(temp)) {//判断是和密码一致
						lbllabel_passwJudge.setText("√");
						lbllabel_passwJudge.setForeground(Color.green);
						lblLabel_PasswRule.setForeground(Color.black);
						Pass_flag=1;//标志密码符合规则
					}
					else
					{
						lblLabel_PasswRule.setText("*8位及以上数字、字母和下划线");
						lblLabel_PasswRule.setFont(new Font("宋体", Font.PLAIN, 13));
						lblLabel_PasswRule.setForeground(Color.red);
						lbllabel_passwJudge.setText("");
						Pass_flag=0;//标志密码不符合规则
					}
				}
				
			}
			
		});
		textField_Password.setBounds(124, 205, 186, 30);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		//图标
		JLabel lblLabel_Passw = new JLabel();
	    lblLabel_Passw.setIcon(new ImageIcon("picture/Password.png"));
		lblLabel_Passw.setBounds(90, 205, 30, 30);
		contentPane.add(lblLabel_Passw);
		
		//*************************************************************
		//确认密码文本框
		textField_RePassword = new JPasswordField();
		//textField_RePassword = new JTextField();
		textField_RePassword.setForeground(Color.GRAY);
		textField_RePassword.setText(" 确认密码");//默认文本
		((JPasswordField) textField_RePassword).setEchoChar((char)0);//不隐藏
		textField_RePassword.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_RePassword.getText();
				if(temp.equals(" 确认密码")) {
					textField_RePassword.setText("");
					textField_RePassword.setForeground(Color.BLACK);
					((JPasswordField) textField_RePassword).setEchoChar('*');
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_Password.getText();
				String temp2 = textField_RePassword.getText();
				if(temp2.equals("")) {
					textField_RePassword.setForeground(Color.GRAY);
					textField_RePassword.setText(" 确认密码");
					((JPasswordField) textField_RePassword).setEchoChar((char)0);
					lblLabel_rePasswJudge.setText("");	
					RePass_flag=0;
				}
				else {
					if(temp2.equals(temp1)&&Pass_flag==1) {//判断是否符合规则
						lblLabel_rePasswJudge.setText("√");	
						lblLabel_rePasswJudge.setForeground(Color.green);
						RePass_flag=1;//标志确认密码一致
					}
					else
					{
						lblLabel_rePasswJudge.setText("×");
						lblLabel_rePasswJudge.setForeground(Color.red);
						RePass_flag=0;
					}
				}
				
			}
			
		});
		textField_RePassword.setBounds(124, 245, 186, 30);
		contentPane.add(textField_RePassword);
		textField_RePassword.setColumns(10);
		//图标
		JLabel lblLabel_Passw2 = new JLabel();
		lblLabel_Passw2.setIcon(new ImageIcon("picture/Password.png"));
		lblLabel_Passw2.setBounds(90, 245, 30, 30);
		contentPane.add(lblLabel_Passw2);
		
		//*************************************************************
		//验证码文本框
		textField_VerCode = new JTextField();
		textField_VerCode.addFocusListener(new JTextFieldHintListener(textField_VerCode, " 邮箱验证码"));//默认文本为验证码
		textField_VerCode.setBounds(124, 285, 186, 30);
		contentPane.add(textField_VerCode);
		textField_VerCode.setColumns(10);
		
		//按键
		JButton btnButton_mail = new JButton();
		btnButton_mail.setIcon(new ImageIcon("picture/mail.png"));
		btnButton_mail.setBounds(90, 290, 30, 21);
		contentPane.add(btnButton_mail);
		btnButton_mail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击发送邮件
				//收集用户信息
				UserID=textField_UserID.getText();
				//UserBirth=textField_year.getText()+"."+textField_month.getText()+"."+textField_day.getText();//生日1999.1.1
				UserName=textField_Name.getText();
				UserPassWord=textField_Password.getText();//密码
				if(Pass_flag==1&&RePass_flag==1&&Name_flag==1&&UserID_flag==1) {
				
		            OnlyCardNum obj = new OnlyCardNum(UserID);
		    		Message msg = new Message("sendMail", obj);
		    		
		    		Object temp = Sender.send(msg);
		    		Message res = (Message)temp;
		            
		    		while(res.status.equals("100"));
		    		
		    		if(res.status.equals("200"))
		    		{
		                JOptionPane.showMessageDialog(null, "验证码发送成功");	
		                return;
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context, "错误×", JOptionPane.WARNING_MESSAGE);
		    			return;
		    		}
				}
				else if(Name_flag==1&&UserID_flag==1){//弹出密码错误提示框
					JOptionPane.showMessageDialog(null, "密码错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}
				else if(UserID_flag==1){//弹出姓名错误提示框
				    JOptionPane.showMessageDialog(null, "姓名错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}
				else {//弹出ID错误提示框
					JOptionPane.showMessageDialog(null, "账号错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		
		//*************************************************************
		//注册按键
		JButton btnRegister_Button = new JButton("\u6CE8\u518C");
		btnRegister_Button.setFont(new Font("宋体", Font.BOLD, 18));

		btnRegister_Button.setBounds(90, 325, 220, 30);
		btnRegister_Button.setForeground(Color.white);//字体颜色白色
		contentPane.add(btnRegister_Button);
		btnRegister_Button.setBackground(Color.decode("#75d0ff"));
		btnRegister_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击注册
				UserVercode=textField_VerCode.getText();//获取验证码
				UserPassWord=textField_Password.getText();//密码
				UserID=textField_UserID.getText();
				UserName=textField_Name.getText();
				if(Pass_flag==1&&RePass_flag==1&&Name_flag==1&&UserID_flag==1) {
					RegisterClass obj = new RegisterClass(UserID,UserPassWord,UserVercode,UserName);
		    		Message msg = new Message("register", obj);
		    		
		    		Object temp = Sender.send(msg);
		    		Message res = (Message)temp;
		            
		    		while(res.status.equals("100"));
		    		
		    		if(res.status.equals("200"))
		    		{
		    			JOptionPane.showMessageDialog(null, "注册成功，请返回登录界面");	                
		                return;
		    		}
		    		else
		    		{
		    			JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context, "错误×", JOptionPane.WARNING_MESSAGE);
		    			return;
		    		}
				}
				else if(Name_flag==1&&UserID_flag==1){//弹出密码错误提示框
					JOptionPane.showMessageDialog(null, "密码错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}
				else if(UserID_flag==1){//弹出姓名错误提示框
				    JOptionPane.showMessageDialog(null, "姓名错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}
				else {//弹出ID错误提示框
					JOptionPane.showMessageDialog(null, "账号错误，请检查！", "错误×", JOptionPane.WARNING_MESSAGE);
				}
	            
			}
		});
		
		//*************************************************************
		//登录跳转
		JLabel lblLabel_Login = new JLabel("\u767B\u5F55");
		lblLabel_Login.setBounds(378, 349, 36, 22);
		contentPane.add(lblLabel_Login);
		lblLabel_Login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击，跳转登陆界面
				new LoginUI().setVisible(true);
				jf.dispose();
			}
		});

	}
}