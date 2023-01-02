package client.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.Chat;
import server.common.GradeClass;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateGroupUI extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private String g_name="群聊1";
	private static ChetMainUI aFrame;//传递之前对象
	
	private JTextField textField_name;
	private JTextField textField_groupName;
	private JTextField textField_ID;
	private JLabel lblLabel_NameRule;

	/**
	 * Create the panel.
	 */
	public CreateGroupUI(String t_name,String t_ID,ChetMainUI aFrame) {
		setBorder(null);
		setBackground(new Color(255, 255, 255));//586, 408)
		name=t_name;ID=t_ID;this.aFrame=aFrame;
		setBounds(0, 0, 586, 408);
		setLayout(null);
		setFocusable(true);//默认启动时光标不在文本框内
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 49, 232, 3);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(354, 49, 232, 3);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("欢迎创建群聊");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel.setBounds(232, 31, 122, 33);
		add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLUE);
		panel_2.setBounds(59, 86, 10, 20);
		add(panel_2);
		
		JLabel lblLabel_reason = new JLabel("信息");
		lblLabel_reason.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_reason.setBounds(79, 86, 153, 20);
		add(lblLabel_reason);
		
		textField_name = new JTextField(name);
		textField_name.setBackground(new Color(255, 255, 255));
		textField_name.setEditable(false);
		textField_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		textField_name.setForeground(new Color(0, 0, 0));
		textField_name.setColumns(10);
		textField_name.setBounds(209, 124, 186, 38);
		add(textField_name);
		
		lblLabel_NameRule = new JLabel("*不超过12个字，一经提交无法更改！");
		lblLabel_NameRule.setFont(new Font("宋体", Font.PLAIN, 13));
		lblLabel_NameRule.setBounds(209, 209, 275, 27);
		add(lblLabel_NameRule);
		
		textField_groupName = new JTextField();
		textField_groupName.setForeground(Color.GRAY);
		textField_groupName.setText(" 群聊昵称");//默认文本
		//重定义光标响应(光标不在账号文本框内，判断)
		textField_groupName.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_groupName.getText();
				if(temp.equals(" 群聊昵称")) {
					textField_groupName.setText("");
					textField_groupName.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp1 = textField_groupName.getText();
				if(temp1.equals("")) {
					textField_groupName.setForeground(Color.GRAY);
					textField_groupName.setText(" 群聊昵称");
					lblLabel_NameRule.setForeground(Color.black);
				}
				else if(temp1.length()>12) {
					lblLabel_NameRule.setForeground(Color.red);
				}
				else {
					lblLabel_NameRule.setForeground(Color.black);
				}
			}	
		});	
		textField_groupName.setColumns(10);
		textField_groupName.setBounds(209, 236, 186, 38);
		add(textField_groupName);
		
		ImageIcon Icon_user = new ImageIcon("picture/group.jpg");
		JLabel lblLabel_UserName = new JLabel(Icon_user);
		lblLabel_UserName.setBounds(109, 124, 90, 90);
		add(lblLabel_UserName);
		
		JLabel lblLabel_groupName = new JLabel();
		lblLabel_groupName.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLabel_groupName.setText("昵称");
		lblLabel_groupName.setBounds(169, 239, 30, 30);
		add(lblLabel_groupName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		panel_3.setBounds(0, 285, 586, 123);
		add(panel_3);
		
		textField_ID = new JTextField(ID);
		textField_ID.setBackground(new Color(255, 255, 255));
		textField_ID.setEditable(false);
		textField_ID.setForeground(new Color(0, 0, 0));
		textField_ID.setFont(new Font("微软雅黑", Font.BOLD, 14));
		textField_ID.setColumns(10);
		textField_ID.setBounds(209, 173, 186, 38);
		add(textField_ID);
		
		JButton Button_apply = new JButton("提交");
		Button_apply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				g_name=textField_groupName.getText();
				if(g_name.length()>12) {
					JOptionPane.showMessageDialog(null, "亲，群昵称超过12字了", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(g_name.equals(" 群聊昵称")) {
					JOptionPane.showMessageDialog(null, "请修改群昵称", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					int yn=JOptionPane.showConfirmDialog(null, "提示：群昵称一经提交无法更改！", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
					if(yn==JOptionPane.YES_OPTION) {
						/*
						 * 传输数据
						 */
						//*************************创建群聊接口
						Chat obj=new Chat(ID,g_name,"空","空");
						Message msg=new Message("createGroup",obj);
						Object temp = Sender.send(msg);
						Message res = (Message)temp;						
						while(res.status.equals("100"));
						if(res.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "创建群聊失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//成功
							String g_ID=((UniversalClass)res.response[0]).context;//获得群号
							JOptionPane.showMessageDialog(null, "创建群聊群号："+g_ID+" 即将关闭返回主页面", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							ImageIcon Icon = new ImageIcon("picture/openmail.png");
							DefaultTableModel tableModel = (DefaultTableModel) aFrame.table_list2.getModel();
							tableModel.addRow(new Object[]{g_name, g_ID,Icon});//加一行
							aFrame.table_list2.repaint();
						}							
					}				
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Button_apply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Button_apply.setBackground(new Color(135, 206, 250));
		Button_apply.setForeground(new Color(255, 255, 255));
		Button_apply.setFont(new Font("微软雅黑", Font.BOLD, 14));
		Button_apply.setBounds(443, 251, 97, 23);
		add(Button_apply);

	}

}
