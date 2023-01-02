package client.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.*;
import server.communication.*;

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
import javax.swing.JButton;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class StManagerUI_St extends JPanel {
	private JPanel panel_1;
	private JLabel lblLabel_extraMess;
	private JLabel lblLabel_extraEdit;
	private JLabel lblLabel_profileEdit;
	private JLabel lblLabel_profileSave;
	private JLabel lblLabel_phoneJudge;
	private JLabel lblLabel_birthJudge;
	private JLabel lblLabel_mailJudge;
	private  JLabel lblLabel_profile;
	private JLabel lblLabel_SelfintroJudge;
	private JTextField textField_SelfIntro;
	private JTextField textField_name;
	private JTextField textField_genderEdit;
	private JTextField textField_nameEdit;
	private JTextField textField_gender;
	private JTextField textField_ID;
	private JTextField textField_IDEdit;
	private JTextField textField_StNum;
	private JTextField textField_StNumEdit;
	private JTextField textField_phoneEdit;
	private JTextField textField_mail;
	private JTextField textField_mailEdit;
	private JTextField textField_phone;
	private JTextField textField_birth;
	private JTextField textField_year;
	private JTextField textField_month;
	private JTextField textField_day;
	private JTextField textField_SelfIntroEdit;
	private JLabel lblLabel_ExtraSave;
	private JTextField textField_header;
	private JPanel panel_Request;
	private JTextField textField_request;
	private JTextField textField_reason;
	
	private String name;//姓名
	private String ID;//一卡通
	private String gender="";//性别
	private String StNum="";//学号
	private String phone="";//联系方式
	private String mail="";//邮件地址
	private String birth;//生日
	private String da="";//年月日
	private String ye="";
	private String mo="";
	private String Selfintro="";//自我介绍
	private String applyreason="";//申请理由
	//头像？
	
	private int Edit_flag=0;//是否为编辑状态
	private int phone_flag=0;//电话是否合法
	private int mail_flag=0;//邮件是否合法
	private int Birth_flag=0;//生日是否合法
	private int SelfIntro_flag=1;//自我介绍是否合法
	private JTextArea textArea_SelfIntro;
	/*private int status_phone=0;//判断信息更改是否完成
	private int status_mail=0;//判断信息更改是否完成
	private int status_birth=0;//判断信息更改是否完成*/

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
	 * 判断邮件是否合法
	 */
	public boolean isSelfIntroLegal(String str) {
	    return (str.length()<=11)?true:false;

	}
	/**
	 * Create the panel.
	 */
	public StManagerUI_St(String t_ID,String t_name) {
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(1405, 929);//设置大小
		setLayout(null);
		
		name=t_name;
		ID=t_ID;
		/*、
		 * 挂载页面获得信息
		 * */
		
		//标头
		textField_header = new JTextField();
		textField_header.setEditable(false);
		textField_header.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header.setForeground(new Color(255, 255, 255));
		textField_header.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField_header.setText("\u5B66\u751F\u4FE1\u606F");
		textField_header.setBackground(new Color(30, 144, 255));
		textField_header.setBounds(122, 99, 843, 30);
		add(textField_header);
		textField_header.setColumns(10);
		
		//**************************************************************************************
		//右侧信息panel
		JPanel panel_Mess = new JPanel();
		panel_Mess.setBackground(new Color(255, 255, 255));
		panel_Mess.setBounds(1021, 40, 249, 260);
		add(panel_Mess);
		panel_Mess.setLayout(null);
		
		ImageIcon images = new ImageIcon("picture/man.png");//!!!!!或根据数据库返回的图像
		
        OnlyCardNum obj1 = new OnlyCardNum(ID);//******************************************************头像接口
		Message msg = new Message("getPhoto", obj1);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		while(res.status.equals("100"));
		if(res.status.equals("200"))
		{
			String classPath = this.getClass().getResource("/").getPath();
			String path=classPath.replaceAll("Vcampus7/bin","Vcampus7/picture");
			FileResponse tem=(FileResponse)res.response[0];
			saveFile(path,tem);
			images=new ImageIcon("picture\\"+tem.fileName);
		}
		//else 用默认的head_temp.jpg
        //头像自适应
		Image temp_image = images.getImage();
		temp_image = temp_image.getScaledInstance(175,175, Image.SCALE_DEFAULT);
		images.setImage(temp_image);
		
		//头像
		lblLabel_profile = new JLabel(images);
		lblLabel_profile.setBounds(47, 37, 160, 160);
//		lblLabel_profile.setIcon(new ImageIcon("picture/man.png"));
		lblLabel_profile.setHorizontalAlignment(SwingConstants.CENTER);//控件居中
		lblLabel_profile.setBackground(new Color(192, 192, 192));
		panel_Mess.add(lblLabel_profile);
		

		//头像保存
		/*lblLabel_profileSave = new JLabel("\u4FDD\u5B58");
		lblLabel_profileSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		lblLabel_profileSave.setBounds(50, 217, 66, 33);
		lblLabel_profileSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_profileSave.setFont(new Font("微软雅黑", Font.BOLD, 15));
		panel_Mess.add(lblLabel_profileSave);*/
		
		//头像编辑
		lblLabel_profileEdit = new JLabel("\u66F4\u6539\u5934\u50CF");
		lblLabel_profileEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setCurrentDirectory(new File("."));
				chooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
				int returnVal = chooser.showOpenDialog(lblLabel_profileEdit);//是否打开文件选择框
				if (returnVal == JFileChooser.APPROVE_OPTION) {//如果符合文件类型
				String filepath = chooser.getSelectedFile().getAbsolutePath();//获取绝对路径
				
				//******************************************************头像接口
				SendFile obj2=new SendFile(filepath,ID,ID);
				Message msg1 = new Message("sendPhoto", obj2);
				Object temp1 = Sender.send(msg1);
				Message res1 = (Message)temp1;
				while(res1.status.equals("100"));
				//更新图片
				ImageIcon images1=new ImageIcon(filepath);
				lblLabel_profile = new JLabel(images1);
				JOptionPane.showMessageDialog(null, "亲，更改成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
			   }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_profileEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_profileEdit.setBounds(96, 212, 66, 33);
		lblLabel_profileEdit.setForeground(new Color(30, 144, 255));
		lblLabel_profileEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		panel_Mess.add(lblLabel_profileEdit);
	
		
		//**************************************************************************************
		//******************************************************基本信息接口
		Message msg6 = new Message("getBasic", obj1);
		Object temp6 = Sender.send(msg6);
		Message res6 = (Message)temp6;
		while(res6.status.equals("100"));
		if(res6.status.equals("200"))
		{
			StuBasicInfo tem6=(StuBasicInfo)res6.response[0];
			 
			 if(tem6.sex==0) {
				 gender="待定";
			 }
			 else if(tem6.sex==1) {
				 gender="男";
			 }
			 else if(tem6.sex==2) {
				 gender="女";
			 }
			 StNum=tem6.stuNum;
		}
		//基本信息panel
		JPanel panel_BasicMess = new JPanel();
		panel_BasicMess.setBackground(new Color(255, 255, 255));
		panel_BasicMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess.setBounds(110, 128, 870, 148);
		add(panel_BasicMess);
		panel_BasicMess.setLayout(null);
		
		//基本信息标签
		JLabel lblLabel_basicMess = new JLabel("\u4E2A\u4EBA\u57FA\u672C\u4FE1\u606F");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(67, 10, 119, 26);
		panel_BasicMess.add(lblLabel_basicMess);
		//编辑标签
		JLabel lblLabel_basicEdit = new JLabel("\u7F16\u8F91");
		lblLabel_basicEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//光标移入，箭头-》指头
				lblLabel_basicEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {//点击
				JOptionPane.showMessageDialog(null, "请移步到基本信息修改申请栏哦", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		lblLabel_basicEdit.setForeground(new Color(135, 206, 250));
		lblLabel_basicEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_basicEdit.setBounds(185, 10, 54, 27);
		panel_BasicMess.add(lblLabel_basicEdit);
		//装饰的panel（蓝条）
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(47, 8, 10, 29);
		panel_BasicMess.add(panel);
		//姓名
		textField_name = new JTextField();
		textField_name.setText(" \u59D3\u540D");
		textField_name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_name.setEditable(false);
		textField_name.setColumns(10);
		textField_name.setBackground(new Color(248, 248, 255));
		textField_name.setBounds(47, 47, 172, 46);
		panel_BasicMess.add(textField_name);
		//姓名编辑栏
		textField_nameEdit = new JTextField(name);
		textField_nameEdit.setEditable(false);
		textField_nameEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_nameEdit.setColumns(10);
		textField_nameEdit.setBackground(Color.WHITE);
		textField_nameEdit.setBounds(219, 47, 221, 46);
		panel_BasicMess.add(textField_nameEdit);
		//性别栏
		textField_gender = new JTextField();
		textField_gender.setText(" \u6027\u522B");
		textField_gender.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_gender.setEditable(false);
		textField_gender.setColumns(10);
		textField_gender.setBackground(new Color(248, 248, 255));
		textField_gender.setBounds(47, 92, 172, 46);
		panel_BasicMess.add(textField_gender);
		//性别编辑栏
		textField_genderEdit = new JTextField(gender);
		textField_genderEdit.setEditable(false);
		textField_genderEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_genderEdit.setColumns(10);
		textField_genderEdit.setBackground(Color.WHITE);
		textField_genderEdit.setBounds(219, 92, 221, 46);
		panel_BasicMess.add(textField_genderEdit);
		//一卡通号
		textField_ID = new JTextField();
		textField_ID.setText(" \u4E00\u5361\u901A\u53F7");
		textField_ID.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_ID.setEditable(false);
		textField_ID.setColumns(10);
		textField_ID.setBackground(new Color(248, 248, 255));
		textField_ID.setBounds(440, 47, 172, 46);
		panel_BasicMess.add(textField_ID);
		//一卡通号编辑
		textField_IDEdit = new JTextField(ID);
		textField_IDEdit.setEditable(false);
		textField_IDEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_IDEdit.setColumns(10);
		textField_IDEdit.setBackground(Color.WHITE);
		textField_IDEdit.setBounds(612, 47, 221, 46);
		panel_BasicMess.add(textField_IDEdit);
		//学号
		textField_StNum = new JTextField();
		textField_StNum.setText(" \u5B66\u53F7");
		textField_StNum.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_StNum.setEditable(false);
		textField_StNum.setColumns(10);
		textField_StNum.setBackground(new Color(248, 248, 255));
		textField_StNum.setBounds(440, 92, 172, 46);
		panel_BasicMess.add(textField_StNum);
		//学号编辑
		textField_StNumEdit = new JTextField(StNum);
		textField_StNumEdit.setEditable(false);
		textField_StNumEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_StNumEdit.setColumns(10);
		textField_StNumEdit.setBackground(Color.WHITE);
		textField_StNumEdit.setBounds(612, 92, 221, 46);
		panel_BasicMess.add(textField_StNumEdit);
		
		//**************************************************************************************
		//扩展信息panel
		//******************************************************扩展信息接口
		Message msg4 = new Message("getExtension", obj1);
		Object temp4 = Sender.send(msg4);
		Message res4 = (Message)temp4;
		while(res4.status.equals("100"));
		if(res4.status.equals("200"))
		{
			StuExtendInfo tem4=(StuExtendInfo)res4.response[0];
			 phone=tem4.phone;
			 mail=tem4.email;
			 Selfintro=tem4.selfIntro;
			 da=tem4.birthDate;
			 ye=tem4.birthYear;
			 mo=tem4.birthMonth;
		}
		//有初始化信息
		if(phone!=null) {
			phone_flag=1;
			//status_phone=1;
		}
		if(mail!=null) {
			mail_flag=1;
			//status_mail=1;
		}
		if(Selfintro!=null) {
			SelfIntro_flag=1;
		}
		if(da!=null&&ye!=null&&mo!=null) {
			Birth_flag=1;
			//status_birth=1;
		}
		
		JPanel panel_ExtraMess = new JPanel();
		panel_ExtraMess.setBackground(new Color(255, 255, 255));
		panel_ExtraMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ExtraMess.setBounds(110, 300, 870, 590);
		add(panel_ExtraMess);
		panel_ExtraMess.setLayout(null);
		//装饰panel
		panel_1 = new JPanel();
		panel_1.setBounds(48, 10, 10, 28);
		panel_1.setBackground(new Color(100, 149, 237));
		panel_ExtraMess.add(panel_1);
		//扩展信息标签
		lblLabel_extraMess = new JLabel("\u4E2A\u4EBA\u6269\u5C55\u4FE1\u606F");
		lblLabel_extraMess.setBounds(68, 14, 110, 24);
		lblLabel_extraMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		panel_ExtraMess.add(lblLabel_extraMess);
		
		//判断
		lblLabel_SelfintroJudge = new JLabel("");
		lblLabel_SelfintroJudge.setForeground(new Color(0, 128, 0));
		lblLabel_SelfintroJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_SelfintroJudge.setBounds(230, 150, 29, 23);
		panel_ExtraMess.add(lblLabel_SelfintroJudge);
		//自我介绍栏
		textField_SelfIntro = new JTextField();
		textField_SelfIntro.setText(" \u4E2A\u4EBA\u4ECB\u7ECD\uFF08100\u5B57\u5185\uFF09");
		textField_SelfIntro.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_SelfIntro.setEditable(false);
		textField_SelfIntro.setColumns(10);
		textField_SelfIntro.setBackground(new Color(248, 248, 255));
		textField_SelfIntro.setBounds(48, 137, 786, 46);
		panel_ExtraMess.add(textField_SelfIntro);
		//自我介绍编辑栏
		
		/*textField_SelfIntroEdit = new JTextField();
		textField_SelfIntroEdit.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(Edit_flag==1)
				{//失去焦点时，没有输入内容，显示提示内容
					String temp = textField_SelfIntroEdit.getText();
					if(isSelfIntroLegal(temp)) {//判断电话是否合法
						lblLabel_SelfintroJudge.setText("√");
						lblLabel_SelfintroJudge.setForeground(Color.green);
						SelfIntro_flag=1;//标志电话符合规则
					}
					else
					{
						lblLabel_SelfintroJudge.setForeground(Color.red);
						lblLabel_SelfintroJudge.setText("×");
						SelfIntro_flag=0;//标志电话不符合规则
					}
				}		
			}		
		});	
		textField_SelfIntroEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_SelfIntroEdit.setColumns(10);
		textField_SelfIntroEdit.setBackground(Color.WHITE);
		textField_SelfIntroEdit.setBounds(48, 183, 786, 380);
		panel_ExtraMess.add(textField_SelfIntroEdit);
		*/
		
		textArea_SelfIntro = new JTextArea(Selfintro);
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
						SelfIntro_flag=1;//标志电话符合规则
					}
					else
					{
						lblLabel_SelfintroJudge.setForeground(Color.red);
						lblLabel_SelfintroJudge.setText("×");
						SelfIntro_flag=0;//标志电话不符合规则
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
		
		//判断
		lblLabel_phoneJudge = new JLabel("");
		lblLabel_phoneJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_phoneJudge.setForeground(new Color(0, 128, 0));
		lblLabel_phoneJudge.setBounds(186, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_phoneJudge);
		//联系方式栏
		textField_phone = new JTextField();
		textField_phone.setText(" \u8054\u7CFB\u65B9\u5F0F");
		textField_phone.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_phone.setEditable(false);
		textField_phone.setColumns(10);
		textField_phone.setBackground(new Color(248, 248, 255));
		textField_phone.setBounds(48, 45, 172, 46);
		panel_ExtraMess.add(textField_phone);		
		//联系方式编辑栏
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
						phone_flag=1;//标志电话符合规则
						//status_phone=1;
					}
					else
					{
						lblLabel_phoneJudge.setForeground(Color.red);
						lblLabel_phoneJudge.setText("×");
						phone_flag=0;//标志电话不符合规则
						//status_phone=1;
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
		
		//邮件判断
		lblLabel_mailJudge = new JLabel("");
		lblLabel_mailJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_mailJudge.setForeground(new Color(0, 128, 0));
		lblLabel_mailJudge.setBounds(574, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_mailJudge);
		//邮件栏
		textField_mail = new JTextField();
		textField_mail.setText(" \u90AE\u7BB1");
		textField_mail.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_mail.setEditable(false);
		textField_mail.setColumns(10);
		textField_mail.setBackground(new Color(248, 248, 255));
		textField_mail.setBounds(441, 45, 172, 46);
		panel_ExtraMess.add(textField_mail);
		//邮件编辑栏
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
						mail_flag=1;//标志邮件符合规则
						//status_mail=1;
					}
					else
					{
						lblLabel_mailJudge.setForeground(Color.red);
						lblLabel_mailJudge.setText("×");
						mail_flag=0;//标志邮件不符合规则
						//status_mail=1;
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
		
		//生日判断
		lblLabel_birthJudge = new JLabel("");
		lblLabel_birthJudge.setForeground(new Color(0, 128, 0));
		lblLabel_birthJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_birthJudge.setBounds(186, 104, 29, 23);
		panel_ExtraMess.add(lblLabel_birthJudge);
		//生日栏
		textField_birth = new JTextField();
		textField_birth.setText(" \u51FA\u751F\u65E5\u671F");
		textField_birth.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_birth.setEditable(false);
		textField_birth.setColumns(10);
		textField_birth.setBackground(new Color(248, 248, 255));
		textField_birth.setBounds(48, 91, 172, 46);
		panel_ExtraMess.add(textField_birth);
		
		//年
		textField_year = new JTextField(ye);
		if(ye==null) {//未编辑过
			textField_year.setForeground(Color.GRAY);
			textField_year.setText(" 例1999");//默认文本
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
						Birth_flag=0;//标志日期不符合规则
						//status_birth=1;
						lblLabel_birthJudge.setText("");
					}
					else {
						if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
							lblLabel_birthJudge.setText("√");
							lblLabel_birthJudge.setForeground(Color.green);
							Birth_flag=1;//标志日期符合规则
							//status_birth=1;
						}
						else
						{
							lblLabel_birthJudge.setForeground(Color.red);
							lblLabel_birthJudge.setText("×");
							Birth_flag=0;//标志日期不符合规则
							//status_birth=1;
						}
					}	
				}		
			}		
		});	
		textField_year.setEditable(false);
		textField_year.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_year.setColumns(10);
		textField_year.setBackground(Color.WHITE);
		textField_year.setBounds(220, 91, 221, 46);
		panel_ExtraMess.add(textField_year);
		
		//月
		textField_month = new JTextField(mo);
		if(mo==null) {//未编辑过
			textField_month.setForeground(Color.GRAY);
			textField_month.setText("例 1");//默认文本
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
						Birth_flag=0;//标志日期不符合规则
						lblLabel_birthJudge.setText("");
						//status_birth=1;
					}
					else {
						if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
							lblLabel_birthJudge.setText("√");
							lblLabel_birthJudge.setForeground(Color.green);
							Birth_flag=1;//标志日期符合规则
							//status_birth=1;
						}
						else
						{
							lblLabel_birthJudge.setForeground(Color.red);
							lblLabel_birthJudge.setText("×");
							Birth_flag=0;//标志日期不符合规则
							//status_birth=1;
						}
					}		
				}		
			}			
		});	
		textField_month.setEditable(false);
		textField_month.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_month.setColumns(10);
		textField_month.setBackground(Color.WHITE);
		textField_month.setBounds(441, 91, 172, 46);
		panel_ExtraMess.add(textField_month);
		
		//日
		textField_day = new JTextField(da);
		if(da==null) {
			textField_day.setText("例 1");
			textField_day.setForeground(Color.GRAY);
		}
		//默认文本
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
					Birth_flag=0;//标志日期不符合规则
					//status_birth=1;
				}
				else {
					if(isDate(temp1,temp2,temp3)) {//判断日期是否合法
						lblLabel_birthJudge.setText("√");
						lblLabel_birthJudge.setForeground(Color.green);
						Birth_flag=1;//标志日期符合规则
						//status_birth=1;
					}
					else
					{
						lblLabel_birthJudge.setForeground(Color.red);
						lblLabel_birthJudge.setText("×");
						Birth_flag=0;//标志日期不符合规则
						//status_birth=1;
					}
				}
				
			}
			
		});	
		textField_day.setEditable(false);
		textField_day.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_day.setColumns(10);
		textField_day.setBackground(Color.WHITE);
		textField_day.setBounds(613, 91, 221, 46);
		panel_ExtraMess.add(textField_day);
		
		//保存标签
		lblLabel_ExtraSave = new JLabel("");
		lblLabel_ExtraSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
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
		//编辑标签
		lblLabel_extraEdit = new JLabel("\u7F16\u8F91");
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
		lblLabel_extraEdit.setBackground(new Color(255, 255, 255));
		lblLabel_extraEdit.setBounds(186, 18, 30, 20);
		lblLabel_extraEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		panel_ExtraMess.add(lblLabel_extraEdit);

		
		//**************************************************************************************
		//申请panel
		panel_Request = new JPanel();
		panel_Request.setBackground(new Color(248, 248, 255));
		panel_Request.setBounds(1021, 393, 249, 497);
		add(panel_Request);
		panel_Request.setLayout(null);
		
		//申请标签
		textField_request = new JTextField();
		textField_request.setText("\u57FA\u672C\u4FE1\u606F\u4FEE\u6539\u7533\u8BF7");
		textField_request.setHorizontalAlignment(SwingConstants.CENTER);
		textField_request.setForeground(Color.WHITE);
		textField_request.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField_request.setEditable(false);
		textField_request.setColumns(10);
		textField_request.setBackground(new Color(30, 144, 255));
		textField_request.setBounds(1021, 353, 249, 30);
		add(textField_request);
		
		//申请内容标签
		JLabel lblLabel_content = new JLabel("\u4FEE\u6539\u5185\u5BB9");
		lblLabel_content.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblLabel_content.setBounds(46, 10, 84, 24);
		panel_Request.add(lblLabel_content);
		
		/*
		//性别勾选
		JCheckBox CheckBox_gender = new JCheckBox("\u6027\u522B");
		CheckBox_gender.setFont(new Font("微软雅黑", Font.BOLD, 15));
		CheckBox_gender.setBackground(new Color(248, 248, 255));
		CheckBox_gender.setBounds(23, 40, 129, 23);
		panel_Request.add(CheckBox_gender);
		//学号勾选
		JCheckBox CheckBox_StNum = new JCheckBox("\u5B66\u53F7");
		CheckBox_StNum.setFont(new Font("微软雅黑", Font.BOLD, 15));
		CheckBox_StNum.setBackground(new Color(248, 248, 255));
		CheckBox_StNum.setBounds(23, 65, 129, 23);
		panel_Request.add(CheckBox_StNum);
		*/
		JRadioButton RadioButton_gender = new JRadioButton("性别");
		RadioButton_gender.setFont(new Font("微软雅黑", Font.BOLD, 18));
		RadioButton_gender.setBackground(new Color(248, 248, 255));
		RadioButton_gender.setBounds(46, 37, 84, 24);
		panel_Request.add(RadioButton_gender);
		
		JRadioButton RadioButton_StNum = new JRadioButton("学号");
		RadioButton_StNum.setFont(new Font("微软雅黑", Font.BOLD, 18));
		RadioButton_StNum.setBackground(new Color(248, 248, 255));
		RadioButton_StNum.setBounds(46, 70, 84, 24);
		panel_Request.add(RadioButton_StNum);
		
		//申请原因
		JLabel lblLabel_reason = new JLabel("\u7533\u8BF7\u7406\u7531(50\u5B57\u5185)");
		lblLabel_reason.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblLabel_reason.setBounds(46, 94, 129, 24);
		panel_Request.add(lblLabel_reason);
		//申请原因编辑
		JTextArea textArea_reason = new JTextArea();
		textArea_reason.setBounds(46, 133, 159, 315);
		textArea_reason.setLineWrap(true);//自动换行
		textArea_reason.setWrapStyleWord(true);//断航不断字
		panel_Request.add(textArea_reason);
		/*
		textField_reason = new JTextField();
		textField_reason.setColumns(10);
		textField_reason.setBounds(23, 128, 119, 324);
		panel_Request.add(textField_reason);
		*/
		
		//申请按钮
		JButton btnButton_apply = new JButton("\u7533\u8BF7");
		btnButton_apply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean gender_flag=RadioButton_gender.isSelected();
				int sex;
				if(gender_flag)
					sex=1;
				else
					sex=0;
				boolean StNum_flag=RadioButton_StNum.isSelected();
				int stNum;
				if(StNum_flag)
					stNum=1;
				else
					stNum=0;
				String reason=textArea_reason.getText();
				if(reason.length()>50) {
					JOptionPane.showMessageDialog(null, "亲，申请理由超过50字了", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(sex==0&&stNum==0) {
					JOptionPane.showMessageDialog(null, "亲，请选择要修改的信息", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					ChangeWithReason obj5 = new ChangeWithReason(ID,sex,stNum,reason,name);//******************************************************头像接口
					Message msg5 = new Message("sendRequest", obj5);
					Object temp5 = Sender.send(msg5);
					Message res5 = (Message)temp5;
					while(res5.status.equals("100"));
					JOptionPane.showMessageDialog(null, "亲，申请成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					/*
					 * 发送文本
					 * */
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnButton_apply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnButton_apply.setForeground(Color.WHITE);
		btnButton_apply.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnButton_apply.setBackground(new Color(135, 206, 250));
		btnButton_apply.setBounds(46, 463, 159, 24);
		panel_Request.add(btnButton_apply);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(36, 10, 10, 29);
		panel_Request.add(panel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(100, 149, 237));
		panel_2_1.setBounds(36, 94, 10, 29);
		panel_Request.add(panel_2_1);
	}
	public static void saveFile(String path, FileResponse obj) {
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(path+'/'+obj.fileName);
			byte[] b = obj.bytes;
			fileOutputStream.write(b);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

