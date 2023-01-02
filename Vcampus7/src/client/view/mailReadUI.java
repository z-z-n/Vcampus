package client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class mailReadUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_nameEdit;
	private JTextField textField_ID;
	private JTextField textField_IDEdit;

	private String name;
	private String ID;
	private String reason="test";
	private int gender=1;
	private int StNum=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mailReadUI frame = new mailReadUI("test","test",1,1,"reason");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mailReadUI(String t_name, String t_ID, int t_sex, int t_StNum, String t_reason) {
		setTitle("Application Modify");
		/*
		 * 读数据
		 */
		name=t_name;ID=t_ID;
		reason=t_reason;StNum=t_StNum;gender=t_sex;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 903, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JPanel panel_BasicMess = new JPanel();
		panel_BasicMess.setLayout(null);
		panel_BasicMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess.setBackground(Color.WHITE);
		panel_BasicMess.setBounds(10, 10, 869, 105);
		contentPane.add(panel_BasicMess);
		
		JLabel lblLabel_basicMess = new JLabel("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(67, 10, 119, 26);
		panel_BasicMess.add(lblLabel_basicMess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(47, 8, 10, 29);
		panel_BasicMess.add(panel);
		
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
		
		JPanel panel_BasicMess_1 = new JPanel();
		panel_BasicMess_1.setLayout(null);
		panel_BasicMess_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess_1.setBackground(Color.WHITE);
		panel_BasicMess_1.setBounds(10, 135, 869, 398);
		contentPane.add(panel_BasicMess_1);
		
		JLabel lblLabel_basicMess_1 = new JLabel("\u7533\u8BF7\u7406\u7531");
		lblLabel_basicMess_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess_1.setBounds(67, 82, 119, 26);
		panel_BasicMess_1.add(lblLabel_basicMess_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(47, 80, 10, 29);
		panel_BasicMess_1.add(panel_1);
		
		JTextArea textArea = new JTextArea(reason);
		textArea.setLineWrap(true);//自动换行
		textArea.setWrapStyleWord(true);//断航不断字
		textArea.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		textArea.setEditable(false);
		textArea.setBounds(47, 119, 789, 244);
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		panel_BasicMess_1.add(textArea);
		
		
		JRadioButton RadioButton_StNum = new JRadioButton("\u5B66\u53F7");
		RadioButton_StNum.setBounds(166, 48, 110, 27);
		panel_BasicMess_1.add(RadioButton_StNum);
		if(StNum==0)
		{
			RadioButton_StNum.setSelected(false);
		}
		else
		{
			RadioButton_StNum.setSelected(true);
		}
		RadioButton_StNum.setEnabled(false);
		RadioButton_StNum.setBackground(new Color(255, 255, 255));
		RadioButton_StNum.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		RadioButton_StNum.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JRadioButton RadioButton_gender = new JRadioButton("\u6027\u522B");
		RadioButton_gender.setBounds(47, 48, 109, 24);
		panel_BasicMess_1.add(RadioButton_gender);
		if(gender==0)
		{
			RadioButton_gender.setSelected(false);
		}
		else
		{
			RadioButton_gender.setSelected(true);
		}
		RadioButton_gender.setEnabled(false);
		RadioButton_gender.setBackground(new Color(255, 255, 255));
		RadioButton_gender.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		RadioButton_gender.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(47, 10, 10, 29);
		panel_BasicMess_1.add(panel_1_1);
		
		JLabel lblLabel_basicMess_1_1 = new JLabel("\u4FEE\u6539\u9879");
		lblLabel_basicMess_1_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess_1_1.setBounds(67, 12, 119, 26);
		panel_BasicMess_1.add(lblLabel_basicMess_1_1);
	}
}