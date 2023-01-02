package client.view;

import client.Sender;
import server.common.*;
import server.communication.*;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Manager_editUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_editUI frame = new Manager_editUI("213191948","张致宁");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String name;//姓名
	private String ID;//一卡通
	private String gender="";//性别
	private String StNum="";//学号
	private String phone="";//联系方式
	private String mail="";//邮件地址
	private String birth;//生日
	private String Selfintro="";//自我介绍
	private String applyreason="";//申请理由
	private String da="";//年月日
	private String ye="";
	private String mo="";
	private int Edit_flag=0;//是否为编辑状态
	private int Edit_flag1=0;//是否为编辑状态
	
	private JTextField textField;
	private JTextField textField_name;
	private JTextField textField_nameEdit;
	private JTextField textField_gender;
	private JTextField textField_genderEdit;
	private JTextField textField_ID;
	private JTextField textField_IDEdit;
	private JTextField textField_StNum;
	private JTextField textField_StNumEdit;
	private JTextField textField_SelfIntro;
	private JTextField textField_phone;
	private JTextField textField_phoneEdit;
	private JTextField textField_mail;
	private JTextField textField_mailEdit;
	private JTextField textField_birth;
	private JTextField textField_year;
	private JTextField textField_month;
	private JTextField textField_day;
	private JLabel lblLabel_genderJudge;
	private JLabel lblLabel_StNumJudge;
	
	
	/**
	 * 判断性别
	 */
	public boolean isGender(String str) {
		String regex = "^[男]*[女]*";//判断学号
	    boolean flag=str.matches(regex);
	    return flag;
	    /*
		if(str=="男"||str=="女") {
			return true;
		}
		else {
			return false;
		}
		*/
	}/**
	 * 判断学号
	 */
	public boolean isStNum(String str) {
		String regex = "^[a-z0-9A-Z]+";//判断学号
	    boolean flag=str.matches(regex);
	    return flag;
	}
	/**
	 * 判断生日是否合法，利用java.text.SimpleDateFormat类进行判断
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
	 * 判断联系方式是否合法11位数字
	 */
	public boolean isMail(String str) {
		String regex = "^[_a-z0-9A-Z]+@[.a-z0-9A-Z]+$";//判断邮箱
	    boolean flag=str.matches(regex);
	    return flag;
	}
	/**
	 * 判断邮件是否合法
	 */
	public boolean isPhone(String str) {
		String regex = "^[0-9]+$";//数字
		boolean flag1=(str.length()==11)?true:false;
	    boolean flag2=str.matches(regex);
	    return (flag1==true&&flag2==true)?true:false;

	}
	/**
	 * 判断自我介绍是否合法
	 */
	public boolean isSelfIntroLegal(String str) {
	    return (str.length()<=11)?true:false;

	}

	/**
	 * Create the frame.
	 */
	public Manager_editUI(String t_name,String t_ID) {
		name=t_name;
		ID=t_ID;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1089, 988);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("学生信息");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(30, 144, 255));
		textField.setBounds(115, 89, 843, 30);
		contentPane.add(textField);
		
		//******************************************************基本信息接口
		OnlyCardNum obj1 = new OnlyCardNum(ID);
		Message msg1 = new Message("getBasic", obj1);
		Object temp1 = Sender.send(msg1);
		Message res1 = (Message)temp1;
		while(res1.status.equals("100"));
		if(res1.status.equals("200"))
		{
			StuBasicInfo tem1=(StuBasicInfo)res1.response[0];
			 
			 if(tem1.sex==0) {
				 gender="待定";
			 }
			 else if(tem1.sex==1) {
				 gender="男";
			 }
			 else if(tem1.sex==2) {
				 gender="女";
			 }
			 StNum=tem1.stuNum;
		}
		/*
		if(gender!=null) {
			gender_flag=1;
		}
		if(StNum!=null) {
			StNum_flag=1;
		}*/
		
		JPanel panel_BasicMess = new JPanel();
		panel_BasicMess.setLayout(null);
		panel_BasicMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess.setBackground(Color.WHITE);
		panel_BasicMess.setBounds(103, 118, 870, 148);
		contentPane.add(panel_BasicMess);
		
		JLabel lblLabel_basicMess = new JLabel("个人基本信息");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(67, 10, 119, 26);
		panel_BasicMess.add(lblLabel_basicMess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(47, 8, 10, 29);
		panel_BasicMess.add(panel);
		
		lblLabel_genderJudge = new JLabel("");
		lblLabel_genderJudge.setForeground(new Color(0, 128, 0));
		lblLabel_genderJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_genderJudge.setBounds(180, 103, 29, 23);
		panel_BasicMess.add(lblLabel_genderJudge);
		
		lblLabel_StNumJudge = new JLabel("");
		lblLabel_StNumJudge.setForeground(new Color(0, 128, 0));
		lblLabel_StNumJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_StNumJudge.setBounds(573, 103, 29, 23);
		panel_BasicMess.add(lblLabel_StNumJudge);
		
		textField_name = new JTextField();
		textField_name.setText(" 姓名");
		textField_name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_name.setEditable(false);
		textField_name.setColumns(10);
		textField_name.setBackground(new Color(248, 248, 255));
		textField_name.setBounds(47, 47, 172, 46);
		panel_BasicMess.add(textField_name);
		
		textField_nameEdit = new JTextField(name);
		textField_nameEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_nameEdit.setEditable(false);
		textField_nameEdit.setColumns(10);
		textField_nameEdit.setBackground(Color.WHITE);
		textField_nameEdit.setBounds(219, 47, 221, 46);
		panel_BasicMess.add(textField_nameEdit);
		
		textField_gender = new JTextField();
		textField_gender.setText(" 性别");
		textField_gender.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_gender.setEditable(false);
		textField_gender.setColumns(10);
		textField_gender.setBackground(new Color(248, 248, 255));
		textField_gender.setBounds(47, 92, 172, 46);
		panel_BasicMess.add(textField_gender);
		
		textField_genderEdit = new JTextField(gender);
		textField_genderEdit.addFocusListener(new FocusListener() {			
			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_genderEdit.getText();
				if(isGender(temp1)) {
					lblLabel_genderJudge.setText("√");
					lblLabel_genderJudge.setForeground(Color.green);
				}
				else
				{
					lblLabel_genderJudge.setForeground(Color.red);
					lblLabel_genderJudge.setText("×");
				}					
			}					
		});	
		textField_genderEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_genderEdit.setEditable(false);
		textField_genderEdit.setColumns(10);
		textField_genderEdit.setBackground(Color.WHITE);
		textField_genderEdit.setBounds(219, 92, 221, 46);
		panel_BasicMess.add(textField_genderEdit);
		
		textField_ID = new JTextField();
		textField_ID.setText(" 一卡通号");
		textField_ID.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_ID.setEditable(false);
		textField_ID.setColumns(10);
		textField_ID.setBackground(new Color(248, 248, 255));
		textField_ID.setBounds(440, 47, 172, 46);
		panel_BasicMess.add(textField_ID);
		
		textField_IDEdit = new JTextField(ID);
		textField_IDEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_IDEdit.setEditable(false);
		textField_IDEdit.setColumns(10);
		textField_IDEdit.setBackground(Color.WHITE);
		textField_IDEdit.setBounds(612, 47, 221, 46);
		panel_BasicMess.add(textField_IDEdit);
		
		textField_StNum = new JTextField();
		textField_StNum.setText(" 学号");
		textField_StNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_StNum.setEditable(false);
		textField_StNum.setColumns(10);
		textField_StNum.setBackground(new Color(248, 248, 255));
		textField_StNum.setBounds(440, 92, 172, 46);
		panel_BasicMess.add(textField_StNum);
		
		textField_StNumEdit = new JTextField(StNum);
		textField_StNumEdit.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_StNumEdit.getText();
				if(isStNum(temp1)) {
					lblLabel_StNumJudge.setText("√");
					lblLabel_StNumJudge.setForeground(Color.green);
				}
				else
				{
					lblLabel_StNumJudge.setForeground(Color.red);
					lblLabel_StNumJudge.setText("×");
				}					
			}					
		});	
		textField_StNumEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_StNumEdit.setEditable(false);
		textField_StNumEdit.setColumns(10);
		textField_StNumEdit.setBackground(Color.WHITE);
		textField_StNumEdit.setBounds(612, 92, 221, 46);
		panel_BasicMess.add(textField_StNumEdit);
		
		JLabel lblLabel_BasicSave = new JLabel("");
		lblLabel_BasicSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Edit_flag1==1) {
					 gender=textField_genderEdit.getText();
					 int sex=0;
					 if(gender.equals("男"))
						 sex=1;
					 else if(gender.equals("女")) {
						 sex=2;
					 }
					 else {
						 sex=0;
					 }
					 StNum=textField_StNumEdit.getText();
					 if(isGender(gender)&&isStNum(StNum)) {//判断格式是否符合规则
						 /*
						  * 更新
						  */
						StuBasicInfo obj4 = new StuBasicInfo(ID,StNum,sex);
						Message msg4 = new Message("sendBasic", obj4);
						Object temp4 = Sender.send(msg4);
						Message res4 = (Message)temp4;
						while(res4.status.equals("100"));
						//不可编辑
						textField_gender.setEditable(false);
						textField_StNumEdit.setEditable(false);
						lblLabel_BasicSave.setText("");
						Edit_flag1=0;	
						JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					 }
					 else if(isStNum(StNum)) {
						 JOptionPane.showMessageDialog(null, "亲，请检查性别格式后再保存", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						 
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "亲，请检查学号格式后再保存", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					 }
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(Edit_flag1==1) {
					lblLabel_BasicSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			}
		});
		lblLabel_BasicSave.setForeground(new Color(106, 90, 205));
		lblLabel_BasicSave.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_BasicSave.setBounds(779, 10, 54, 27);
		panel_BasicMess.add(lblLabel_BasicSave);
		
		
		JLabel lblLabel_basicEdit = new JLabel("编辑");
		lblLabel_basicEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//光标移入，箭头-》指头
				lblLabel_basicEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {//点击
				textField_genderEdit.setEditable(true);
				textField_StNumEdit.setEditable(true);
				Edit_flag1=1;
				lblLabel_BasicSave.setText("保存");
			}
		});
		lblLabel_basicEdit.setForeground(new Color(135, 206, 250));
		lblLabel_basicEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_basicEdit.setBounds(185, 10, 54, 27);
		panel_BasicMess.add(lblLabel_basicEdit);
		
		//*******************************************************************************
		//*************************************************************扩展信息接口
		Message msg2 = new Message("getExtension", obj1);
		Object temp2 = Sender.send(msg2);
		Message res2 = (Message)temp2;
		while(res2.status.equals("100"));
		if(res2.status.equals("200"))
		{
			 StuExtendInfo tem2=(StuExtendInfo)res2.response[0];
			 phone=tem2.phone;
			 mail=tem2.email;
			 Selfintro=tem2.selfIntro;
			 da=tem2.birthDate;
			 ye=tem2.birthYear;
			 mo=tem2.birthMonth;
		}
				
		JPanel panel_ExtraMess = new JPanel();
		panel_ExtraMess.setLayout(null);
		panel_ExtraMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ExtraMess.setBackground(Color.WHITE);
		panel_ExtraMess.setBounds(103, 292, 870, 590);
		contentPane.add(panel_ExtraMess);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(48, 10, 10, 28);
		panel_ExtraMess.add(panel_1_1);
		
		
		JLabel lblLabel_extraMess = new JLabel("个人扩展信息");
		lblLabel_extraMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_extraMess.setBounds(68, 14, 108, 24);
		panel_ExtraMess.add(lblLabel_extraMess);
		
		JLabel lblLabel_SelfintroJudge = new JLabel("");
		lblLabel_SelfintroJudge.setForeground(new Color(0, 128, 0));
		lblLabel_SelfintroJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_SelfintroJudge.setBounds(230, 150, 29, 23);
		panel_ExtraMess.add(lblLabel_SelfintroJudge);
		
		textField_SelfIntro = new JTextField();
		textField_SelfIntro.setText(" 个人介绍（100字内）");
		textField_SelfIntro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_SelfIntro.setEditable(false);
		textField_SelfIntro.setColumns(10);
		textField_SelfIntro.setBackground(new Color(248, 248, 255));
		textField_SelfIntro.setBounds(48, 137, 786, 46);
		panel_ExtraMess.add(textField_SelfIntro);
		
		JTextArea textArea_SelfIntro = new JTextArea(Selfintro);
		textArea_SelfIntro.setEditable(false);
		textArea_SelfIntro.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textArea_SelfIntro.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Edit_flag==1)
				{//失去焦点时，没有输入内容，显示提示内容
					String temp = textArea_SelfIntro.getText();
					if(isSelfIntroLegal(temp)) {//判断电话是否合法
						lblLabel_SelfintroJudge.setText("√");
						lblLabel_SelfintroJudge.setForeground(Color.green);
					}
					else
					{
						lblLabel_SelfintroJudge.setForeground(Color.red);
						lblLabel_SelfintroJudge.setText("×");
					}
				}		
			}		
		});	
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea_SelfIntro.setLineWrap(true);//自动换行
		textArea_SelfIntro.setWrapStyleWord(true);//断航不断字
		textArea_SelfIntro.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		textArea_SelfIntro.setBounds(48, 182, 786, 393);
		panel_ExtraMess.add(textArea_SelfIntro);
		
		JLabel lblLabel_phoneJudge = new JLabel("");
		lblLabel_phoneJudge.setForeground(new Color(0, 128, 0));
		lblLabel_phoneJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_phoneJudge.setBounds(186, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_phoneJudge);
		
		textField_phone = new JTextField();
		textField_phone.setText(" 联系方式");
		textField_phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_phone.setEditable(false);
		textField_phone.setColumns(10);
		textField_phone.setBackground(new Color(248, 248, 255));
		textField_phone.setBounds(48, 45, 172, 46);
		panel_ExtraMess.add(textField_phone);
		
		textField_phoneEdit = new JTextField(phone);
		textField_phoneEdit.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Edit_flag==1)
				{//失去焦点时，没有输入内容，显示提示内容
					String temp = textField_phoneEdit.getText();
					if(isPhone(temp)) {//判断电话是否合法
						lblLabel_phoneJudge.setText("√");
						lblLabel_phoneJudge.setForeground(Color.green);
					}
					else
					{
						lblLabel_phoneJudge.setForeground(Color.red);
						lblLabel_phoneJudge.setText("×");
					}
				}		
			}		
		});	
		textField_phoneEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_phoneEdit.setEditable(false);
		textField_phoneEdit.setColumns(10);
		textField_phoneEdit.setBackground(Color.WHITE);
		textField_phoneEdit.setBounds(220, 45, 221, 46);
		panel_ExtraMess.add(textField_phoneEdit);
		
		JLabel lblLabel_mailJudge = new JLabel("");
		lblLabel_mailJudge.setForeground(new Color(0, 128, 0));
		lblLabel_mailJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_mailJudge.setBounds(574, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_mailJudge);
		
		textField_mail = new JTextField();
		textField_mail.setText(" 邮箱");
		textField_mail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_mail.setEditable(false);
		textField_mail.setColumns(10);
		textField_mail.setBackground(new Color(248, 248, 255));
		textField_mail.setBounds(441, 45, 172, 46);
		panel_ExtraMess.add(textField_mail);
		
		textField_mailEdit = new JTextField(mail);
		textField_mailEdit.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Edit_flag==1)
				{//失去焦点时，没有输入内容，显示提示内容
					String temp = textField_mailEdit.getText();
					if(isMail(temp)) {//判断邮件是否合法
						lblLabel_mailJudge.setText("√");
						lblLabel_mailJudge.setForeground(Color.green);
					}
					else
					{
						lblLabel_mailJudge.setForeground(Color.red);
						lblLabel_mailJudge.setText("×");
					}
				}		
			}		
		});	
		textField_mailEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_mailEdit.setEditable(false);
		textField_mailEdit.setColumns(10);
		textField_mailEdit.setBackground(Color.WHITE);
		textField_mailEdit.setBounds(613, 45, 221, 46);
		panel_ExtraMess.add(textField_mailEdit);
		
		JLabel lblLabel_birthJudge = new JLabel("");
		lblLabel_birthJudge.setForeground(new Color(0, 128, 0));
		lblLabel_birthJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_birthJudge.setBounds(186, 104, 29, 23);
		panel_ExtraMess.add(lblLabel_birthJudge);
		
		textField_birth = new JTextField();
		textField_birth.setText(" 出生日期");
		textField_birth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_birth.setEditable(false);
		textField_birth.setColumns(10);
		textField_birth.setBackground(new Color(248, 248, 255));
		textField_birth.setBounds(48, 91, 172, 46);
		panel_ExtraMess.add(textField_birth);
		
		textField_year = new JTextField(ye);
		if(ye==null) {//未编辑过
			textField_year.setText(" 例1999");
			textField_year.setForeground(Color.GRAY);
		}
		//重定义光标响应(光标不在年文本框内，判断)
				textField_year.addFocusListener(new FocusListener() {			

					@Override
					public void focusGained(FocusEvent e) {
						if(Edit_flag==1)
						{//获取焦点时，清空提示内容
							String temp = textField_year.getText();
							if(temp.equals(" 例1999")) {
								textField_year.setText("");
								textField_year.setForeground(Color.BLACK);
							}
						}	
					}

					@Override
					public void focusLost(FocusEvent e) {
						if(Edit_flag==1)
						{				//失去焦点时，没有输入内容，显示提示内容
							String temp1 = textField_year.getText();
							String temp2 = textField_month.getText();
							String temp3 = textField_day.getText();
							if(temp1.equals("")) {
								textField_year.setForeground(Color.GRAY);
								textField_year.setText(" 例1999");
								lblLabel_birthJudge.setText("");
							}
							else {
								if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
									lblLabel_birthJudge.setText("√");
									lblLabel_birthJudge.setForeground(Color.green);
								}
								else
								{
									lblLabel_birthJudge.setForeground(Color.red);
									lblLabel_birthJudge.setText("×");
								}
							}	
						}		
					}		
				});	
		textField_year.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_year.setEditable(false);
		textField_year.setColumns(10);
		textField_year.setBackground(Color.WHITE);
		textField_year.setBounds(220, 91, 221, 46);
		panel_ExtraMess.add(textField_year);
		
		textField_month = new JTextField(mo);
		if(mo==null) {//未编辑过
			textField_month.setText("例 1");
			textField_month.setForeground(Color.GRAY);
		}

		//重定义光标响应(光标不在月文本框内，判断)
				textField_month.addFocusListener(new FocusListener() {			

					@Override
					public void focusGained(FocusEvent e) {
						if(Edit_flag==1)
						{
							//获取焦点时，清空提示内容
							String temp = textField_month.getText();
							if(temp.equals("例 1")) {
								textField_month.setText("");
								textField_month.setForeground(Color.BLACK);
							}
						}		
					}

					@Override
					public void focusLost(FocusEvent e) {
						if(Edit_flag==1) {
							//失去焦点时，没有输入内容，显示提示内容
							String temp1 = textField_year.getText();
							String temp2 = textField_month.getText();
							String temp3 = textField_day.getText();
							if(temp2.equals("")) {
								textField_month.setForeground(Color.GRAY);
								textField_month.setText("例 1");
								lblLabel_birthJudge.setText("");
							}
							else {
								if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
									lblLabel_birthJudge.setText("√");
									lblLabel_birthJudge.setForeground(Color.green);
								}
								else
								{
									lblLabel_birthJudge.setForeground(Color.red);
									lblLabel_birthJudge.setText("×");
								}
							}		
						}		
					}			
				});	
		textField_month.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_month.setEditable(false);
		textField_month.setColumns(10);
		textField_month.setBackground(Color.WHITE);
		textField_month.setBounds(441, 91, 172, 46);
		panel_ExtraMess.add(textField_month);
		
		textField_day = new JTextField(da);
		if(da==null) {//未编辑过
			textField_day.setText("例 1");
			textField_day.setForeground(Color.GRAY);
		}

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
							lblLabel_birthJudge.setText("");
						}
						else {
							if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
								lblLabel_birthJudge.setText("√");
								lblLabel_birthJudge.setForeground(Color.green);
							}
							else
							{
								lblLabel_birthJudge.setForeground(Color.red);
								lblLabel_birthJudge.setText("×");
							}
						}
						
					}
					
				});	
		textField_day.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_day.setEditable(false);
		textField_day.setColumns(10);
		textField_day.setBackground(Color.WHITE);
		textField_day.setBounds(613, 91, 221, 46);
		panel_ExtraMess.add(textField_day);
		
		JLabel lblLabel_ExtraSave = new JLabel("");
		lblLabel_ExtraSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Edit_flag==1) {
					 phone=textField_phoneEdit.getText();
					 mail=textField_mailEdit.getText();
					 da=textField_day.getText();
					 mo=textField_month.getText();
					 ye=textField_year.getText();
					 Selfintro=textArea_SelfIntro.getText();

					if(isPhone(phone)&&isMail(mail)&&isSelfIntroLegal(Selfintro)&&isDate(ye,mo,da)) {//判断所有信息是否合法
						/*
						 * 更新
						 * */
						//******************************************************基本信息接口
						StuExtendInfo obj3 = new StuExtendInfo(ID,Selfintro,phone,mail,ye,mo,da);
						Message msg3 = new Message("sendExtension", obj3);
						Object temp3 = Sender.send(msg3);
						Message res3 = (Message)temp3;
						while(res3.status.equals("100"));
						
						//不可编辑
						textArea_SelfIntro.setEditable(false);
						textField_phoneEdit.setEditable(false);
						textField_mailEdit.setEditable(false);
						textField_year.setEditable(false);
						textField_month.setEditable(false);
						textField_day.setEditable(false);
						lblLabel_ExtraSave.setText("");
						Edit_flag=0;
						JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(isPhone(phone)&&isMail(mail)&&isDate(ye,mo,da)){//弹出自我介绍错误提示框
						JOptionPane.showMessageDialog(null, "亲，请检查自我介绍格式", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(isPhone(phone)&&isMail(mail)){//弹出生日错误提示框
					    JOptionPane.showMessageDialog(null, "亲，生日日期有问题", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(isPhone(phone)){//弹出邮件错误提示框
						JOptionPane.showMessageDialog(null, "亲，请检查邮件地址", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "亲，请检查联系方式", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(Edit_flag==1) {
					lblLabel_ExtraSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			}
		});
		lblLabel_ExtraSave.setForeground(new Color(106, 90, 205));
		lblLabel_ExtraSave.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_ExtraSave.setBounds(780, 10, 54, 27);
		panel_ExtraMess.add(lblLabel_ExtraSave);
		
		JLabel lblLabel_extraEdit = new JLabel("编辑");
		lblLabel_extraEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//点击编辑
				//可编辑
				textArea_SelfIntro.setEditable(true);
				textField_phoneEdit.setEditable(true);
				textField_mailEdit.setEditable(true);
				textField_year.setEditable(true);
				textField_month.setEditable(true);
				textField_day.setEditable(true);
				lblLabel_ExtraSave.setText("保存");
				Edit_flag=1;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_extraEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_extraEdit.setForeground(new Color(135, 206, 250));
		lblLabel_extraEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_extraEdit.setBackground(Color.WHITE);
		lblLabel_extraEdit.setBounds(186, 18, 30, 20);
		panel_ExtraMess.add(lblLabel_extraEdit);
		
		
	}
}
