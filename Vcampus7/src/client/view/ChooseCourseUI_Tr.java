package client.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.CourseScheduling;
import server.common.GradeClass;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseCourseUI_Tr extends JPanel {

	private String name="崔致远";
	private String ID="213191956";
	private String proposal="";//排课建议
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Create the panel.
	 */
	public ChooseCourseUI_Tr(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1290, 820);
		setLayout(null);
		
		
		JPanel panel_BasicMess = new JPanel();
		panel_BasicMess.setLayout(null);
		panel_BasicMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess.setBackground(Color.WHITE);
		panel_BasicMess.setBounds(69, 155, 1137, 120);
		add(panel_BasicMess);
		
		JLabel lblLabel_basicMess = new JLabel("教师信息");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(67, 10, 119, 26);
		panel_BasicMess.add(lblLabel_basicMess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(47, 8, 10, 29);
		panel_BasicMess.add(panel);
		
		textField_1 = new JTextField();
		textField_1.setText(" 姓名");
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(248, 248, 255));
		textField_1.setBounds(44, 50, 172, 46);
		panel_BasicMess.add(textField_1);
		
		textField_2 = new JTextField(name);
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(216, 50, 349, 46);
		panel_BasicMess.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setText(" 一卡通号");
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(248, 248, 255));
		textField_4.setBounds(565, 50, 172, 46);
		panel_BasicMess.add(textField_4);
		
		textField_5 = new JTextField(ID);
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(737, 50, 349, 46);
		panel_BasicMess.add(textField_5);
		
		JLabel lblLabel_extraEdit_1 = new JLabel("课表");
		lblLabel_extraEdit_1.setForeground(new Color(135, 206, 250));
		lblLabel_extraEdit_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_extraEdit_1.setBackground(Color.WHITE);
		lblLabel_extraEdit_1.setBounds(183, 16, 30, 20);
		panel_BasicMess.add(lblLabel_extraEdit_1);
		
		JPanel panel_ExtraMess = new JPanel();
		panel_ExtraMess.setLayout(null);
		panel_ExtraMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_ExtraMess.setBackground(Color.WHITE);
		panel_ExtraMess.setBounds(69, 298, 1137, 498);
		add(panel_ExtraMess);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(48, 10, 10, 28);
		panel_ExtraMess.add(panel_1);
		
		JLabel lblLabel_extraMess = new JLabel("课程申请");
		lblLabel_extraMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_extraMess.setBounds(68, 14, 110, 24);
		panel_ExtraMess.add(lblLabel_extraMess);
		
		JLabel lblLabel_SelfintroJudge = new JLabel("");
		lblLabel_SelfintroJudge.setForeground(new Color(0, 128, 0));
		lblLabel_SelfintroJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_SelfintroJudge.setBounds(230, 150, 29, 23);
		panel_ExtraMess.add(lblLabel_SelfintroJudge);
		
		textField_3 = new JTextField();
		textField_3.setText("  排课建议（200字内）");
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(248, 248, 255));
		textField_3.setBounds(46, 45, 1042, 61);
		panel_ExtraMess.add(textField_3);
		
		JTextArea textArea_application = new JTextArea("");
		textArea_application.setWrapStyleWord(true);
		textArea_application.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea_application.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		textArea_application.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textArea_application.setBounds(46, 106, 1042, 369);
		panel_ExtraMess.add(textArea_application);
		
		JLabel lblLabel_phoneJudge = new JLabel("");
		lblLabel_phoneJudge.setForeground(new Color(0, 128, 0));
		lblLabel_phoneJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_phoneJudge.setBounds(186, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_phoneJudge);
		
		JLabel lblLabel_mailJudge = new JLabel("");
		lblLabel_mailJudge.setForeground(new Color(0, 128, 0));
		lblLabel_mailJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_mailJudge.setBounds(574, 59, 29, 23);
		panel_ExtraMess.add(lblLabel_mailJudge);
		
		JLabel lblLabel_birthJudge = new JLabel("");
		lblLabel_birthJudge.setForeground(new Color(0, 128, 0));
		lblLabel_birthJudge.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_birthJudge.setBounds(186, 104, 29, 23);
		panel_ExtraMess.add(lblLabel_birthJudge);
		
		JLabel lblLabel_ExtraSave = new JLabel("");
		lblLabel_ExtraSave.setForeground(new Color(106, 90, 205));
		lblLabel_ExtraSave.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_ExtraSave.setBounds(780, 10, 54, 27);
		panel_ExtraMess.add(lblLabel_ExtraSave);
		
		JLabel lblLabel_extraEdit = new JLabel("提交");
		lblLabel_extraEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 传输数据
				 */
				proposal=textArea_application.getText();
				if(proposal.length()<=200) {
					CourseScheduling obj=new CourseScheduling(ID,proposal);
					Message msg=new Message("setPreferTime",obj);
					Object temp = Sender.send(msg);
					Message res = (Message)temp;
					while(res.status.equals("100"));
					if(res.status.equals("404")) {
						JOptionPane.showMessageDialog(null, "上传失败"+((UniversalClass)res.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "排课建议字数超过200字了", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_extraEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_extraEdit.setForeground(new Color(100, 149, 237));
		lblLabel_extraEdit.setFont(new Font("微软雅黑", Font.BOLD, 17));
		lblLabel_extraEdit.setBackground(Color.WHITE);
		lblLabel_extraEdit.setBounds(177, 12, 39, 26);
		panel_ExtraMess.add(lblLabel_extraEdit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(71, 45, 1137, 88);
		add(panel_2);
		panel_2.setLayout(null);
		
		ImageIcon images=new ImageIcon("picture/course.jpg");
		JLabel lblNewLabel = new JLabel(images);
		lblNewLabel.setBounds(0, 0, 152, 88);
		panel_2.add(lblNewLabel);
		
		JPanel panel_decorate_3 = new JPanel();
		panel_decorate_3.setBackground(new Color(135, 206, 250));
		panel_decorate_3.setBounds(162, 64, 965, 3);
		panel_2.add(panel_decorate_3);
		
		textField = new JTextField();
		textField.setBounds(162, 10, 965, 30);
		panel_2.add(textField);
		textField.setText("课程设置");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(30, 144, 255));

	}

}
