package client.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.Book;
import server.common.BorrowBook;
import server.communication.Message;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LibStuPanel extends JPanel {
		private JTextField yijietext;
		private JTextField kejietext;
		private JTable book;
		private JTable table;
		private JTable table_1;
		private JTable table_2;
		private JTable table_3;

		/**
		 * Create the panel.
		 */
		public LibStuPanel(String card) {
			setSize(1076,623);
			setBorder(new LineBorder(Color.LIGHT_GRAY));
			setLayout(null);
			setOpaque(true) ;	
			//this.setLayout(new BorderLayout());

			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new LineBorder(Color.white));
			
			panel.setBounds(24, 50, 718, 404);
			add(panel);
			panel.setLayout(null);
			
//			JLabel number = new JLabel("个人信息查询结果：");
//			number.setForeground(Color.ORANGE);
//			number.setFont(new Font("微软雅黑", Font.PLAIN, 30));
//			number.setBounds(38, 39, 314, 30);
//			panel.add(number);
			
			JLabel lblNewLabel = new JLabel("个人信息查询结果");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(new Color(255, 200, 0));
			lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 20, 300, 30);
			panel.add(lblNewLabel);
			
			
			table_3 = new JTable();
    		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    		table_3.setModel(new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    				"\u4E66\u540D", "\u4E66\u53F7", "\u51FA\u7248\u793E"
    			}
    		));
    		DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
    		tableModel.addRow(new Object[]{"一卡通","书籍编号","归还时间"});
    		table_3.setBounds(38, 89, 583, 112);
    		table_3.setBorder(BorderFactory.createLineBorder(Color.black));
    		table_3.setFont(new Font("微软雅黑", Font.PLAIN, 10));
    		panel.add(table_3);
    		String obj = card;
    		Message msg = new Message("borrowed", obj);
    		
    		Object temp = Sender.send(msg);
    		Message res = (Message)temp;
            
    		while(res.status.equals("100"));
    		int cnt=res.num;
    		
    		while(cnt>0)
    		{			
    			tableModel.addRow(new Object[]{((BorrowBook)res.response[cnt-1]).cardNum,
    				((BorrowBook)res.response[cnt-1]).bookId,((BorrowBook)res.response[cnt-1]).da});
    			cnt--;
    		}
    		repaint();
			
		}
	}

