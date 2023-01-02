package client.service;


import server.common.*;
import server.communication.*;
import client.*;
import client.view.MainUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LibAddPanel extends JPanel{
	/*private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public LibAddPanel()
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
	
	JLabel lblNewLabel = new JLabel("所要添加书名：");
	lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel.setBounds(100, 100, 100, 30);
	panel.add(lblNewLabel);
	
	textField = new JTextField();
	textField.setText("");
	textField.setBounds(200, 100, 100, 30);
	panel.add(textField);
	textField.setColumns(10);

	
	JButton btnNewButton = new JButton("添加");
	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	btnNewButton.setBounds(150, 280, 93, 23);
	panel.add(btnNewButton);
	
	JLabel lblNewLabel_2 = new JLabel("所要添加书号：");
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
	

	int status = 0;*/
	
	/*btnNewButton.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(1==1)////////////////////////////////////////////////////归还成功的判断
			{
				JOptionPane.showMessageDialog(null, "上架成功");
		}
			else {
				JOptionPane.showMessageDialog(null, "上架失败，没有该书");
			}
		}
	});*/
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public LibAddPanel()
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
	
	JLabel lblNewLabel = new JLabel("所要添加书名：");
	lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel.setBounds(100, 100, 100, 30);
	panel.add(lblNewLabel);
	
	textField = new JTextField();
	textField.setText("");
	textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	textField.setBounds(200, 100, 167, 30);
	panel.add(textField);
	textField.setColumns(10);

	JLabel lblNewLabel4 = new JLabel("上架书籍");
	lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel4.setForeground(new Color(255, 200, 0));
	lblNewLabel4.setFont(new Font("微软雅黑", Font.PLAIN, 30));
	lblNewLabel4.setBounds(0, 20, 300, 30);
	panel.add(lblNewLabel4);
	
	JButton btnNewButton = new JButton("添加");
	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	btnNewButton.setBounds(194, 274, 93, 23);
	panel.add(btnNewButton);
	
	JLabel lblNewLabel_2 = new JLabel("所要添加书号：");
	lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_2.setBounds(100, 152, 100, 30);
	panel.add(lblNewLabel_2);
	
	textField_2 = new JTextField();
	textField_2.setText("");
	textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	textField_2.setColumns(10);
	textField_2.setBounds(200, 152, 167, 30);
	panel.add(textField_2);
	
	JLabel lblNewLabel_3 = new JLabel("该书出版社：");
	lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_3.setBounds(100, 207, 100, 30);
	panel.add(lblNewLabel_3);
	
	textField_3 = new JTextField();
	textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	textField_3.setText("");
	textField_3.setColumns(10);
	textField_3.setBounds(200, 207, 167, 30);
	panel.add(textField_3);
	btnNewButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {

        	String name=textField.getText();///////////////////////////书名，书号，出版社
			String number=textField_2.getText();
			String chubanshe=textField_3.getText();
			if(name.length()==0) {
				JOptionPane.showMessageDialog(null, "书名不能为空");
			}
			else if(number.length()==0) {
				JOptionPane.showMessageDialog(null, "书号不能为空");
			}
			else if(chubanshe.length()==0) {
				JOptionPane.showMessageDialog(null, "出版社不能为空");
			}
			else {
			Book obj=new Book(number,name,chubanshe);
			Message msg=new Message("addbook",obj);
			
			Object temp=Sender.send(msg);
			Message res=(Message)temp;
			
			while(res.status.equals("100"));
			if(res.status.equals("105"))
			{
				JOptionPane.showMessageDialog(null, "已有该书");
			}
			
			else
			{
				
				JOptionPane.showMessageDialog(null, "上架成功");
			}
			
		}
		
        }
	});
	}
	
	/*btnNewButton.addActionListener(new ActionListener());

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			String name=textField.getText();///////////////////////////书名，书号，出版社
			String number=textField_2.getText();
			String chubanshe=textField_3.getText();
			
			Book obj=new Book(number,name,chubanshe);
			Message msg=new Message("addbook",obj);
			
			Object temp=Sender.send(msg);
			Message res=(Message)temp;
			
			while(res.status.equals("100"));
			if(res.status.equals("106"))
			{
				JOptionPane.showMessageDialog(null, "已有该书");
			}
			
			else
			{
				////////
				JOptionPane.showMessageDialog(null, "上架成功");
			}
			
		}
		
		
	});*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}