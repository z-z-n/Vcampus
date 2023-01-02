package client.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import client.Sender;
import server.common.Chat;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AddFriendUI extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private String tips="请输入一卡通";
	private String s_name="张致宁";//加好友
	private String s_ID="213191948";//加好友
	private String s_reason="我是……";//加好友理由
	private int flag=0;//找到为1
	private int flag1=0;//0为加好友，2为加群
	
	private JTextField textField_search;
	private JLabel lblLabel_finderID;
	private JLabel lblLabel_findername;
	private JPanel panel_finder;
	private JLabel lblLabel_notfind;
	private JLabel lblLabel_enter;

	/**
	 * Create the panel.
	 */
	public AddFriendUI(String t_name,String t_ID,String t_tips,int t_flag) {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(new Color(255, 255, 255));//586, 408)
		name=t_name;ID=t_ID;tips=t_tips;flag1=t_flag;
		setBounds(0, 0, 586, 408);
		setLayout(null);
		setFocusable(true);//默认启动时光标不在文本框内
		
		ImageIcon Icon_search = new ImageIcon("picture/search.jpg");
		JLabel lblLabel_search = new JLabel(Icon_search);
		lblLabel_search.setBounds(30, 50, 30, 30);
		add(lblLabel_search);
		
		textField_search = new JTextField();
		textField_search.setForeground(Color.GRAY);
		textField_search.setText(tips);//默认文本
		//重定义光标响应(光标不在账号文本框内，判断)
		textField_search.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_search.getText();
				if(temp.equals(tips)) {
					textField_search.setText("");
					textField_search.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_search.getText();
				if(temp1.equals("")) {
					textField_search.setForeground(Color.GRAY);
					textField_search.setText(tips);
				}				
			}	
		});	
		textField_search.setBounds(70, 51, 410, 30);
		add(textField_search);
		textField_search.setColumns(10);
		
		JButton Button_search = new JButton("搜索");
		Button_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String search=textField_search.getText();//搜索内容
				s_ID=textField_search.getText();//搜索内容
				flag=0;//默认没找到
				
				if(flag1==0) {//为加好友
					/*
					 * 传输现有好友get
					 */
					//*************************所有好友接口
					OnlyCardNum obj=new OnlyCardNum(ID);
					Message msg=new Message("getFriends",obj);
					Object temp = Sender.send(msg);
					Message res = (Message)temp;					
					int cnt=res.num;
					String data1[] = new String[cnt];					
					while(res.status.equals("100"));
					if(res.status.equals("404")) {
						//JOptionPane.showMessageDialog(null, "好友列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						for(int i=0;i<cnt;i++) {
							Chat tem=(Chat)res.response[i];
							data1[i]=tem.str1;//一卡通
						}
					}
					
					int flag_fr=0;
					for(int i=0;i<cnt;i++) {
						if(data1[i].equals(s_ID)) {
							flag_fr=1;
							break;
						}
					}
					if(flag_fr==1) {//已存在
						//JOptionPane.showMessageDialog(null, "该好友已存在！", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						lblLabel_enter.setText("已添加");
					}
					else {
						lblLabel_enter.setText("");
					}
					/*
					 * 搜索
					 */
					OnlyCardNum obj2=new OnlyCardNum(s_ID);
					Message msg2=new Message("searchName",obj2);
					Object temp2 = Sender.send(msg2);
					Message res2 = (Message)temp2;										
					while(res2.status.equals("100"));
					if(res2.status.equals("404")) {
						JOptionPane.showMessageDialog(null, "未找到该用户！", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						flag=0;//没找到
						panel_finder.setVisible(false);
						lblLabel_notfind.setVisible(true);
					}
					else {
						s_name=((UniversalClass)res2.response[0]).context;//获得用户名
						flag=1;//找到
						panel_finder.setVisible(true);
						lblLabel_notfind.setVisible(false);
						lblLabel_finderID.setText(textField_search.getText());
						lblLabel_findername.setText(s_name);
					}	
				}
				else {//为加群
					/*
					 * 传输现有群聊ID
					 */
					//********************所有群组接口
					OnlyCardNum obj=new OnlyCardNum(ID);
					Message msg1=new Message("getGroup",obj);
					Object temp1 = Sender.send(msg1);
					Message res1 = (Message)temp1;				
					int cnt1=res1.num;
					String data2[] = new String[cnt1];				
					while(res1.status.equals("100"));
					if(res1.status.equals("404")) {
						//JOptionPane.showMessageDialog(null, "群聊列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						for(int i=0;i<cnt1;i++) {
							Chat tem=(Chat)res1.response[i];
							data2[i]=tem.str1;//群号
						}
					}
					
					int flag_gr=0;
					for(int i=0;i<cnt1;i++) {
						if(data2[i].equals(s_ID)) {
							flag_gr=1;
							break;
						}
					}
					if(flag_gr==1) {
						//JOptionPane.showMessageDialog(null, "该群聊已存在！", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						lblLabel_enter.setText("已加入");
					}
					else {
						lblLabel_enter.setText("");
					}
					/*
					 * 搜索
					 */
					OnlyCardNum obj3=new OnlyCardNum(s_ID);
					Message msg3=new Message("searchGroup",obj3);
					Object temp3 = Sender.send(msg3);
					Message res3 = (Message)temp3;										
					while(res3.status.equals("100"));
					if(res3.status.equals("404")) {
						JOptionPane.showMessageDialog(null, "未找到该群聊！", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						flag=0;//没找到
						panel_finder.setVisible(false);
						lblLabel_notfind.setVisible(true);
					}
					else {
						s_name=((UniversalClass)res3.response[0]).context;//获得群名
						flag=1;//找到
						panel_finder.setVisible(true);
						lblLabel_notfind.setVisible(false);
						lblLabel_finderID.setText(textField_search.getText());
						lblLabel_findername.setText(s_name);
					}
				}				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Button_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Button_search.setBackground(new Color(135, 206, 250));
		Button_search.setFont(new Font("微软雅黑", Font.BOLD, 14));
		Button_search.setForeground(new Color(255, 255, 255));
		Button_search.setBounds(490, 48, 74, 30);
		add(Button_search);
		
		panel_finder = new JPanel();
		panel_finder.setBackground(new Color(255, 255, 255));
		panel_finder.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_finder.setBounds(70, 108, 494, 276);
		add(panel_finder);
		panel_finder.setLayout(null);
		panel_finder.setVisible(false);
		
		ImageIcon Icon_finder = new ImageIcon("picture/man1.png");
		JLabel lblLabel_finder = new JLabel(Icon_finder);
		lblLabel_finder.setBounds(10, 21, 105, 104);
		panel_finder.add(lblLabel_finder);
		
		lblLabel_findername = new JLabel("");
		lblLabel_findername.setBounds(125, 58, 112, 30);
		panel_finder.add(lblLabel_findername);
		
		lblLabel_finderID = new JLabel("");
		lblLabel_finderID.setBounds(125, 95, 112, 30);
		panel_finder.add(lblLabel_finderID);
		
		JTextArea textArea_reason = new JTextArea("我是……");
		textArea_reason.setBounds(10, 160, 474, 106);
		panel_finder.add(textArea_reason);
		textArea_reason.setLineWrap(true);//自动换行
		textArea_reason.setWrapStyleWord(true);//断航不断字
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea_reason.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(10, 135, 10, 20);
		panel_finder.add(panel);
		
		JLabel lblLabel_reason = new JLabel("申请理由(不超过20字)");
		lblLabel_reason.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLabel_reason.setBounds(30, 135, 153, 15);
		panel_finder.add(lblLabel_reason);
		
		JLabel lblLabel_add = new JLabel("添加");
		lblLabel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(flag==1) {//存在
					s_reason=textArea_reason.getText();
					if(s_reason.length()>20) {//超过20字
						JOptionPane.showMessageDialog(null, "亲，申请理由超过20字了", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						if(flag1==0) {//加好友
							/*
							 * 传递数据
							 */
							Chat obj4=new Chat(ID,s_ID,s_reason,"空");
							Message msg4=new Message("makeFriends",obj4);
							Object temp4 = Sender.send(msg4);
							Message res4 = (Message)temp4;										
							while(res4.status.equals("100"));
							if(res4.status.equals("404")) {
								JOptionPane.showMessageDialog(null, "加好友失败："+((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
							else {//成功
								JOptionPane.showMessageDialog(null, ((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}							
						}
						else {//加群
							/*
							 * 传递数据
							 */
							Chat obj5=new Chat(ID,s_ID,s_reason,"空");
							Message msg5=new Message("enterGroup",obj5);
							Object temp5 = Sender.send(msg5);
							Message res5 = (Message)temp5;										
							while(res5.status.equals("100"));
							if(res5.status.equals("404")) {
								JOptionPane.showMessageDialog(null, "加群聊失败："+((UniversalClass)res5.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
							else {//成功
								JOptionPane.showMessageDialog(null, ((UniversalClass)res5.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}								
						}
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_add.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_add.setForeground(new Color(100, 149, 237));
		lblLabel_add.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_add.setBounds(426, 135, 58, 15);
		panel_finder.add(lblLabel_add);
		
		lblLabel_enter = new JLabel("");
		lblLabel_enter.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLabel_enter.setBounds(125, 10, 58, 15);
		panel_finder.add(lblLabel_enter);
		
		lblLabel_notfind = new JLabel("未找到对应用户/群聊！");
		lblLabel_notfind.setForeground(new Color(192, 192, 192));
		lblLabel_notfind.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_notfind.setBounds(80, 79, 233, 30);
		add(lblLabel_notfind);
		lblLabel_notfind.setVisible(false);

	}
}
