package client.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.print.Book;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import server.common.*;
import server.communication.*;
import client.*;
//import com.mysql.cj.protocol.Message;

//import client.Sender;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class LibChangePanel extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public LibChangePanel()
	{
		setOpaque(true) ;
	setSize(1076,623);
	setBorder(new LineBorder(Color.LIGHT_GRAY));
	setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBorder(new LineBorder(Color.white));
	
	panel.setBounds(40, 30, 718, 404);
	add(panel);
	panel.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("所要修改书名：");
	lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel.setBounds(100, 100, 100, 30);
	panel.add(lblNewLabel);
	
	textField = new JTextField();
	textField.setText("");
	textField.setBounds(200, 100, 100, 30);
	panel.add(textField);
	textField.setColumns(10);

	
	JButton btnNewButton = new JButton("修改");
	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	btnNewButton.setBounds(150, 280, 93, 23);
	panel.add(btnNewButton);
	
	JLabel lblNewLabel_2 = new JLabel("所要修改书号：");
	lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_2.setBounds(100, 152, 100, 30);
	panel.add(lblNewLabel_2);
	
	textField_2 = new JTextField();
	textField_2.setText("");
	textField_2.setColumns(10);
	textField_2.setBounds(200, 152, 100, 30);
	panel.add(textField_2);
	
	JLabel lblNewLabel_3 = new JLabel("该书出版社：");
	lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_3.setBounds(100, 213, 100, 30);
	panel.add(lblNewLabel_3);
	
	textField_3 = new JTextField();
	textField_3.setText("");
	textField_3.setColumns(10);
	textField_3.setBounds(200, 213, 100, 30);
	panel.add(textField_3);
	
	btnNewButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String name=textField.getText();///////////////////////////书名，书号，出版社
			String number=textField_2.getText();
			String chubanshe=textField_3.getText();
			if(name.length()==0) {
				JOptionPane.showMessageDialog(null, "书名不能为空");
			}
			else if(number.length()==0) {
				JOptionPane.showMessageDialog(null, "书籍编号不能为空");
			}
			else if(chubanshe.length()==0) {
				JOptionPane.showMessageDialog(null, "书籍出版社不能为空");
			}
			else {
				
			
			Book obj=new Book(number,name,chubanshe);
			Message msg=new Message("modifybook",obj);
			
			Object temp=Sender.send(msg);
			Message res=(Message)temp;
			
			while(res.status.equals("100"));
			if(res.status.equals("106"))
			{
				JOptionPane.showMessageDialog(null, "操作失败，该书不存在");
				return;
			}
			if(res.status.equals("107"))
			{
				JOptionPane.showMessageDialog(null, "该书已被借出，无法修改");
				return;
			}
			
			else
			{
			
				JOptionPane.showMessageDialog(null, "修改成功");
				return;
			}
			
		}	
		}
	});
		
	}
}