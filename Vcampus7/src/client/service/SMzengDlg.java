package client.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import client.Sender;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import server.common.StringWithInt;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
////增加商品个数
public class SMzengDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField number;
	private JTextField shuliang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMzengDlg dialog = new SMzengDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMzengDlg() {
		setBounds(400, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("商品号");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(77, 47, 80, 30);
			contentPanel.add(lblNewLabel);
		
		
			number = new JTextField();
			number.setBounds(154, 48, 150, 30);
			contentPanel.add(number);
			number.setColumns(10);
			//////////////////////////////////////////
//			number.addFocusListener(new FocusListener() {			
//
//				@Override
//				public void focusGained(FocusEvent e) {
//					//获取焦点时，清空提示内容
//					String temp = number.getText();
//					if(temp.equals(" 账号")) {
//						number.setText("");
//						number.setForeground(Color.BLACK);
//					}
//				}
//
//				@Override
//				public void focusLost(FocusEvent e) {
//					//失去焦点时，没有输入内容，显示提示内容
//					String temp1 = number.getText();
//					if(temp1.equals("")) {
//						
//						number.setForeground(Color.GRAY);
//						number.setText(" 账号");
//					}
//					
//				}
//				
//			});	
			
		
			JLabel lblNewLabel2 = new JLabel("增加数量");
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setBounds(77, 87, 80, 30);
			contentPanel.add(lblNewLabel2);
		
		
			
			shuliang = new JTextField();
			shuliang.setColumns(10);
			shuliang.setBounds(154, 88, 150, 30);
			contentPanel.add(shuliang);
			
//			shuliang.addFocusListener(new FocusListener() {			
//
//				@Override
//				public void focusGained(FocusEvent e) {
//					//获取焦点时，清空提示内容
//					String temp = shuliang.getText();
//					if(temp.equals(" 账号")) {
//						shuliang.setText("");
//						shuliang.setForeground(Color.BLACK);
//					}
//				}
//
//				@Override
//				public void focusLost(FocusEvent e) {
//					//失去焦点时，没有输入内容，显示提示内容
//					String temp1 = shuliang.getText();
//					if(temp1.equals("")) {
//						
//						shuliang.setForeground(Color.GRAY);
//						shuliang.setText(" 账号");
//					}
//					
//				}
//				
//			});	
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
				okButton.addMouseListener(new MouseAdapter() {
		     			@Override
		     			public void mouseEntered(MouseEvent e) {
		     				
		     			}

		     			@Override
		     			public void mouseExited(MouseEvent e) {
		     				
		     			}

		     			@Override
		     			public void mouseClicked(MouseEvent e) {
		     				String booknumber=number.getText();//
		     				String bookcount=shuliang.getText();///////////////////////////////////////////
		     				int bookcount2;
		     				if(bookcount.length()==0)
		     				{
		     					bookcount2=0;
		     				}
		     				else
		     				{
		     				    bookcount2=Integer.parseInt(bookcount);
		     				}
		     				
		     				if(booknumber.length()==0)
		     				{
		     					 JOptionPane.showMessageDialog(contentPanel, "商品号不能为空");
		     				}
		     				else 
		     				{
		     					if(bookcount.length()==0)
		     				{
		     						 JOptionPane.showMessageDialog(contentPanel, "新增书本数量不能为空");
		     				}
		     					if(bookcount2<0)
		     					{
		     							 JOptionPane.showMessageDialog(contentPanel, "新增书本数量不能为付");
		     					}
		     					else
		     					{
		     						
		     						
		     						StringWithInt obj = new StringWithInt(booknumber,"11",bookcount2);
		     						Message msg = new Message("moreGoods", obj);
		     		 	    		
		     		 	    		Object temp = Sender.send(msg);
		     			    		Message res = (Message)temp;
		     			            
		     			    		while(res.status.equals("100"));
		     			    	
		     			    		if(res.status=="200")
		     			    		{
		     			    			JOptionPane.showMessageDialog(contentPanel, "操作成功");
		     			    		}
		     						dispose();
		     						
		     						
		     					}
		     				}
		     				
		     			}
		     		});
				cancelButton.addMouseListener(new MouseAdapter() {
	     			@Override
	     			public void mouseEntered(MouseEvent e) {
	     				
	     			}

	     			@Override
	     			public void mouseExited(MouseEvent e) {
	     				
	     			}

	     			@Override
	     			public void mouseClicked(MouseEvent e) {
	     				dispose();
	     				
	     			}
	     		});
				
		
	}

}
