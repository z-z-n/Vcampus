package client.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import client.Sender;
import server.common.SendFile;
import server.common.UniversalClass;
import server.common.comment;
import server.communication.Message;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class HomeworkUI_St extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private JTextField textField_ID1;
	private JTextField textField_IDEdit1;
	private JTextField textField_path;
	private JTextField textField_pathEdit;
	private JTextField textField_ID2;
	private JTextField textField_IDEdit2;
	private JTextArea textArea_comment;

	/**
	 * Create the panel.
	 */
	public HomeworkUI_St(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1130, 929);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(70, 50, 1000, 129);
		add(panel);
		panel.setLayout(null);
		
		ImageIcon images = new ImageIcon("picture/homework1.jpg");
		JLabel lblLabel_image = new JLabel(images);
		lblLabel_image.setBounds(0, 0, 129, 129);
		panel.add(lblLabel_image);
		
		JLabel lblLabel_1 = new JLabel("作业提交:");
		lblLabel_1.setForeground(new Color(100, 149, 237));
		lblLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblLabel_1.setBounds(152, 46, 98, 39);
		panel.add(lblLabel_1);
		
		JLabel lblLabel_2 = new JLabel("欢迎，"+name+" "+ID);
		lblLabel_2.setForeground(new Color(100, 149, 237));
		lblLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblLabel_2.setBounds(271, 46, 320, 39);
		panel.add(lblLabel_2);
		
		ImageIcon images1 = new ImageIcon("picture/message.jpg");
		JLabel lblLabel_image1 = new JLabel(images1);
		lblLabel_image1.setBackground(new Color(240, 255, 255));
		lblLabel_image1.setBounds(811, 25, 100, 41);
		panel.add(lblLabel_image1);
		
		JLabel lblLabel_3 = new JLabel("记得看作业评语！");
		lblLabel_3.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		lblLabel_3.setBounds(811, 65, 147, 30);
		panel.add(lblLabel_3);
		
		//******************************************************************************************************************
		JPanel panel_homeworklist = new JPanel();
		panel_homeworklist.setBackground(new Color(255, 255, 255));
		panel_homeworklist.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_homeworklist.setBounds(70, 212, 1000, 171);
		add(panel_homeworklist);
		panel_homeworklist.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(35, 10, 10, 29);
		panel_homeworklist.add(panel_1);
		
		JLabel lblLabel_hw = new JLabel("作业提交");
		lblLabel_hw.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_hw.setBounds(55, 12, 89, 26);
		panel_homeworklist.add(lblLabel_hw);
		
		textField_ID1 = new JTextField();
		textField_ID1.setText(" 教师一卡通号");
		textField_ID1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_ID1.setEditable(false);
		textField_ID1.setColumns(10);
		textField_ID1.setBackground(new Color(248, 248, 255));
		textField_ID1.setBounds(34, 54, 172, 46);
		panel_homeworklist.add(textField_ID1);
		
		textField_IDEdit1 = new JTextField("");
		textField_IDEdit1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_IDEdit1.setColumns(10);
		textField_IDEdit1.setBackground(Color.WHITE);
		textField_IDEdit1.setBounds(206, 54, 349, 46);
		panel_homeworklist.add(textField_IDEdit1);
		
		JButton btnButton_select = new JButton("选择并提交");
		btnButton_select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tr_ID=textField_IDEdit1.getText();
				if(tr_ID=="") {
					JOptionPane.showMessageDialog(null, "一卡通号不能为空", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JFileChooser chooser = new JFileChooser();             //设置选择器
					chooser.setCurrentDirectory(new File("."));
					chooser.showOpenDialog(btnButton_select);//是否打开文件选择框
					String filepath = chooser.getSelectedFile().getAbsolutePath();//获取绝对路径
					textField_pathEdit.setText(filepath);
					
					//******************************************************文件接口
					SendFile obj1=new SendFile(filepath,ID,tr_ID);
					Message msg1 = new Message("sendFile", obj1);
					Object temp1 = Sender.send(msg1);
					Message res1 = (Message)temp1;
					while(res1.status.equals("100"));
					if(res1.status.equals("404")) {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					/*chooser.setFileFilter(new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
					int returnVal = chooser.showOpenDialog(btnButton_select);//是否打开文件选择框
					if (returnVal == JFileChooser.APPROVE_OPTION) {//如果符合文件类型
						
					}*/					
				}				
			}	
		});
		btnButton_select.setBackground(new Color(135, 206, 250));
		btnButton_select.setForeground(Color.WHITE);
		btnButton_select.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnButton_select.setBounds(580, 99, 113, 46);
		panel_homeworklist.add(btnButton_select);
		
		textField_path = new JTextField();
		textField_path.setText("文件路径");
		textField_path.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_path.setEditable(false);
		textField_path.setColumns(10);
		textField_path.setBackground(new Color(248, 248, 255));
		textField_path.setBounds(34, 100, 172, 46);
		panel_homeworklist.add(textField_path);
		
		textField_pathEdit = new JTextField("");
		textField_pathEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_pathEdit.setEditable(false);
		textField_pathEdit.setColumns(10);
		textField_pathEdit.setBackground(Color.WHITE);
		textField_pathEdit.setBounds(206, 100, 349, 46);
		panel_homeworklist.add(textField_pathEdit);
		
		
		//******************************************************************************************************************
		JPanel panel_comment = new JPanel();
		panel_comment.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_comment.setBackground(new Color(255, 255, 255));
		panel_comment.setBounds(70, 410, 1000, 481);
		add(panel_comment);
		panel_comment.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(35, 10, 10, 29);
		panel_comment.add(panel_2);
		
		JLabel lblLabel_Comment = new JLabel("作业评语");
		lblLabel_Comment.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_Comment.setBounds(55, 10, 89, 26);
		panel_comment.add(lblLabel_Comment);
		
		textField_ID2 = new JTextField();
		textField_ID2.setText(" 教师一卡通号");
		textField_ID2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_ID2.setEditable(false);
		textField_ID2.setColumns(10);
		textField_ID2.setBackground(new Color(248, 248, 255));
		textField_ID2.setBounds(35, 49, 172, 46);
		panel_comment.add(textField_ID2);
		
		textField_IDEdit2 = new JTextField("");
		textField_IDEdit2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_IDEdit2.setColumns(10);
		textField_IDEdit2.setBackground(Color.WHITE);
		textField_IDEdit2.setBounds(207, 49, 349, 46);
		panel_comment.add(textField_IDEdit2);
		
		JButton btnButton_look = new JButton("查看");
		btnButton_look.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tr_ID=textField_IDEdit2.getText();
				//******************************************************评语接口
				comment obj2=new comment(ID,tr_ID);
				Message msg2 = new Message("readcomment", obj2);
				Object temp2 = Sender.send(msg2);
				Message res2 = (Message)temp2;
				while(res2.status.equals("100"));
				if(res2.status.equals("404")) {
					JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					//JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					textArea_comment.setText(((UniversalClass)res2.response[0]).context);//评语
				}
			}
		});
		btnButton_look.setForeground(Color.WHITE);
		btnButton_look.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnButton_look.setBackground(new Color(135, 206, 250));
		btnButton_look.setBounds(579, 49, 103, 46);
		panel_comment.add(btnButton_look);
		
		textArea_comment = new JTextArea("");
		textArea_comment.setWrapStyleWord(true);
		textArea_comment.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea_comment.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		textArea_comment.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textArea_comment.setEditable(false);
		textArea_comment.setBounds(35, 96, 925, 354);
		panel_comment.add(textArea_comment);


	}
}
