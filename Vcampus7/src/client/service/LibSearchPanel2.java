package client.service;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.BackBook;
import server.common.Bookshow;
import server.common.BorrowBook;
import server.communication.Message;

public class LibSearchPanel2 extends JPanel  {
	//private JTable Tables;
	private JTextField txtBookeName;
	private JTextField txtBookNamber;
	//private JTable table;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTable table_3;
	/**
	 * Create the panel.
	 */
	public LibSearchPanel2() {
//		setSize(1670, 982);
//		setLayout(null);
		setOpaque(true) ;
		setSize(1076,623);
		setOpaque(true) ;
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(Color.white));
		
		panel.setBounds(40, 30, 718, 404);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("图书查询");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 200, 0));
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 20, 300, 30);
		panel.add(lblNewLabel);
		
		JLabel book = new JLabel("搜索书名：");
		book.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		book.setBounds(60, 100, 70, 30);
		panel.add(book);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 100, 150, 30);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 163, 150, 30);
		panel.add(textField_1);
		
		JLabel book_1 = new JLabel("搜索书号：");
		book_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		book_1.setBounds(60, 163, 70, 30);
		panel.add(book_1);
		
		JButton btnNewButton1 = new JButton("书名查询");
		btnNewButton1.setBounds(313, 101, 93, 30);
		panel.add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("编号查询");
		btnNewButton2.setBounds(313, 163, 93, 30);
		panel.add(btnNewButton2);

		
		
		
		btnNewButton1.addActionListener(new ActionListener() {
	        	
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        	String name=textField_2.getText();
	        	//String name=textField_1.getText();
	        	if(name.length()==0)
	    		{
	    			JOptionPane.showMessageDialog(null, "书名不能为空");
	    		}
	        	else {
		            //与后端通信程序qkLm
		            String obj = name;///////////////////书名查找
		    		Message msg = new Message("findname", obj);
		    		
		    		Object temp = Sender.send(msg);
		    		Message res = (Message)temp;
		            
		    		//while(res.status.equals("100"));
		    		if(res.status.equals("404"))
		    		{
		    			JOptionPane.showMessageDialog(null, "操作失败，该书不存在");
		    		}
		    		else
		    		{    		
		    			table_3 = new JTable();
			    		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			    		table_3.setModel(new DefaultTableModel(
			    			new Object[][] {
			    			},
			    			new String[] {
			    				"\u4E66\u540D", "\u4E66\u53F7", "\u51FA\u7248\u793E", "\u501F\u9605\u65F6\u95F4"
			    			}
			    		));
			    		DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
			    			    		
			    		int cnt=res.num;
			    		tableModel.addRow(new Object[]{"书名", "书号","出版社", "是否被借出"});
			    		
			    		//tableModel.addRow(new Object[]{"111","1","12"});
			    		while(cnt>0) {
						    Bookshow t=(Bookshow)res.response[cnt-1];
						    if(t.isBorrowed==1) {								    
			    			tableModel.addRow(new Object[]{t.bookName,t.bookId,t.compress,"被借出"});/////////////////数据库返回的信息res的信息
			    			cnt--;
						    }
						    else {
						    	tableModel.addRow(new Object[]{t.bookName,t.bookId,t.compress,"被借阅"});/////////////////数据库返回的信息res的信息
				    			cnt--;
						    }
			    		
			    		}
			    		//tableModel.addRow(new Object[]{"书名", "书号","出版社", "是否被借出"});
			    		
			    		//Bookshow t=(Bookshow)res.response[0];
			    		//tableModel.addRow(new Object[]{t.bookName, t.bookName,t.compress,t.isBorrowed});/////////////////数据库返回的信息res的信息
			    		
			    		table_3.setBounds(40, 201, 583, 112);
			    		table_3.setBorder(BorderFactory.createLineBorder(Color.black));
			    		table_3.setFont(new Font("微软雅黑", Font.PLAIN, 10));
			    		panel.add(table_3);
			    		JOptionPane.showMessageDialog(null, "查询成功");
			    		repaint();
		    		}
		        }
	        }
		    });
		
		
			btnNewButton2.addActionListener(new ActionListener() {
	        	
	        @Override
	        public void actionPerformed(ActionEvent e) {

	        	
	        	//String id=textField_2.getText();
	        	String id=textField_1.getText();
	        	if(id.length()==0)
	    		{
	    			JOptionPane.showMessageDialog(null, "书的编号不能为空");
	    		}
	        	else {
		            //与后端通信程序qkLm
		            String obj = id;///////////////////书号查找
		    		Message msg = new Message("findid", obj);
		    		
		    		Object temp = Sender.send(msg);
		    		Message res = (Message)temp;
		            
		    		//while(res.status.equals("100"));
		    		if(res.status.equals("404"))
		    		{
		    			JOptionPane.showMessageDialog(null, "操作失败，该书不存在");
		    		}
		    		else
		    		{
		    		    table_3 = new JTable();
			    		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			    		table_3.setModel(new DefaultTableModel(
			    			new Object[][] {
			    			},
			    			new String[] {
			    				"\u4E66\u540D", "\u4E66\u53F7", "\u51FA\u7248\u793E", "\u501F\u9605\u65F6\u95F4"
			    			}
			    		));
			    		DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
			    	
			    		
			    		//int cnt=res.num;
			    		tableModel.addRow(new Object[]{"书名", "书号","出版社", "是否被借出"});
			    	  //((Bookshow)res.response[0]);
			    		if(((Bookshow)res.response[0]).isBorrowed==1) {
			    		tableModel.addRow(new Object[]{((Bookshow)res.response[0]).bookName, ((Bookshow)res.response[0]).bookId,
			    				((Bookshow)res.response[0]).compress,"被借阅"});
			    		}
			    		else {
			    			tableModel.addRow(new Object[]{((Bookshow)res.response[0]).bookName, ((Bookshow)res.response[0]).bookId,
				    				((Bookshow)res.response[0]).compress,"可借阅"});
			    		}
			    		table_3.setBounds(40, 201, 583, 112);
			    		table_3.setBorder(BorderFactory.createLineBorder(Color.black));
			    		table_3.setFont(new Font("微软雅黑", Font.PLAIN, 10));
			    		panel.add(table_3);
			    		repaint();
			    		JOptionPane.showMessageDialog(null, "查询成功");
		    		}
		        }
	        }
		    });

	}
}

