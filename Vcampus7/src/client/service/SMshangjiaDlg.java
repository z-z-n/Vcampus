package client.service;
/////////////////上架
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import client.Sender;

import server.common.*;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class SMshangjiaDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField jiage;
	private JTextField shuliang;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMshangjiaDlg dialog = new SMshangjiaDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMshangjiaDlg() {
		setBounds(400, 200, 525, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("名称");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(110, 35, 80, 30);
			contentPanel.add(lblNewLabel);
		}
		
		name = new JTextField();
		name.setBounds(190, 35, 150, 30);
		contentPanel.add(name);
		name.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("价格");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 75, 80, 30);
		contentPanel.add(lblNewLabel);
		
		jiage = new JTextField();
		jiage.setColumns(10);
		jiage.setBounds(190, 75, 150, 30);
		contentPanel.add(jiage);
		

		
		JLabel lblNewLabel_1 = new JLabel("数量");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(110, 115, 80, 30);
		contentPanel.add(lblNewLabel_1);
		
		shuliang = new JTextField();
		shuliang.setColumns(10);
		shuliang.setBounds(190, 115, 150, 30);
		contentPanel.add(shuliang);
		
		
		JLabel lblNewLabel_2 = new JLabel("商品描述");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(110, 250, 80, 30);
		contentPanel.add(lblNewLabel_2);
		
		JLabel hao = new JLabel("\u5546\u54C1\u53F7");
		hao.setHorizontalAlignment(SwingConstants.CENTER);
		hao.setBounds(110, 155, 80, 30);
		contentPanel.add(hao);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 155, 150, 30);
		contentPanel.add(textField);
		
		JTextArea miaoshu = new JTextArea();
		miaoshu.setLineWrap(true); 
		miaoshu.setBounds(190, 211, 150, 114);
		contentPanel.add(miaoshu);
		
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
 				
 				String bookname=name.getText();
 				String jia=jiage.getText();
 				String bookshuliang=shuliang.getText();
 				String bookmiaoshu=miaoshu.getText();
 				String booknumber=textField.getText();
 				
 					if(bookname.length()==0 || bookshuliang.length()==0 ||bookmiaoshu.length()==0||jia.length()==0||booknumber.length()==0)
 					{
 							 JOptionPane.showMessageDialog(contentPanel, "信息不能为空");
 					}
 					else
 					{
 						if(bookmiaoshu.length()>200)
 						{
 							JOptionPane.showMessageDialog(contentPanel, "商品描述200字以内");
 						}
 						else
 						{
 					if(booknumber.length()>5)
 					{
 						JOptionPane.showMessageDialog(contentPanel, "商品号五位以内");
 					}
 					else
 					{
 						
 						double money2;
 						if(jia.length()==0)
 						{
 							money2=0;
 						}
 						else
 						{
 						    money2=Double.valueOf(jia.toString());
 						}
 						int bookcount2;
 						if(bookshuliang.length()==0)
 						{
 							bookcount2=0;
 						}
 						else
 						{
 						    bookcount2=Integer.parseInt(bookshuliang);
 						}
 						
 						Goods obj = new Goods(booknumber,bookname,money2,bookcount2,bookmiaoshu);
		 				 
			 	    		Message msg = new Message("addGoods", obj);
			 	    		
			 	    		Object temp = Sender.send(msg);
				    		Message res = (Message)temp;
				            
				    		while(res.status.equals("100"));
				    		
				    		if(res.status.equals("404"))
				    			JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context);
				    		if(res.status.equals("200"))
				    		{
				    			JOptionPane.showMessageDialog(null, "操作成功");
				    		}
				    		
				    		dispose();
 						
				//JOptionPane.showMessageDialog(contentPanel, "操作成功");
 						}
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
