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
import server.common.Goods;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SMxiajiaDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField xiajia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMxiajiaDlg dialog = new SMxiajiaDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMxiajiaDlg() {
		setBounds(400, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("商品号");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(80, 58, 80, 30);
			contentPanel.add(lblNewLabel);
		
		
			xiajia = new JTextField();
			xiajia.setBounds(160, 59, 150, 30);
			contentPanel.add(xiajia);
			xiajia.setColumns(10);
		
		
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
 				String booknumber=xiajia.getText();
 				if(booknumber.length()==0)
 				{
 					 JOptionPane.showMessageDialog(contentPanel, "商品号不能为空");
 				}
 				else 
 				{
 					
 					OnlyCardNum obj = new OnlyCardNum(booknumber);
	 	    		Message msg = new Message("deleteGoods", obj);
	 	    		
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
