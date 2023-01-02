package client.service;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Sender;

import server.common.OnlyCardNum;
import server.common.addMoney;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SMxuigaiDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField hao;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMxuigaiDlg dialog = new SMxuigaiDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMxuigaiDlg() {
		setBounds(400, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("商品号");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(74, 44, 80, 30);
			contentPanel.add(lblNewLabel);
		
		
			hao = new JTextField();
			hao.setBounds(152, 45, 150, 30);
			contentPanel.add(hao);
			hao.setColumns(10);
			
		
		
			JLabel lblNewLabel1 = new JLabel("新价格");
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setBounds(74, 84, 80, 30);
			contentPanel.add(lblNewLabel1);
			
		
		
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(152, 85, 150, 30);
			contentPanel.add(textField);
			
		
		
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
	     				String booknumber=hao.getText();
	     				
	     				String money=textField.getText();
	     				double money2;
	     				if(money.length()==0)
	     				{
	     					money2=0;
	     				}
	     				else
	     				{
	     				    money2=Double.valueOf(money.toString());
	     				}
	     				if(booknumber.length()==0)
	     				{
	     					 JOptionPane.showMessageDialog(contentPanel, "商品号不能为空");
	     				}
	     				else 
	     				{
	     					if(money.length()==0)
	     				{
	     						 JOptionPane.showMessageDialog(contentPanel, "书本价格不能为空");
	     				}
	     					if(money2<0)
	     					{
	     							 JOptionPane.showMessageDialog(contentPanel, "书本价格不能为负");
	     					}
	     					else
	     					{
	     						addMoney obj = new addMoney(booknumber,money2);
	     						Message msg = new Message("multifyPrice", obj);
	     		 	    		
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
