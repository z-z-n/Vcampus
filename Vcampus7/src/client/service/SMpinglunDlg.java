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

import server.common.CommentGood;
import server.common.Goods;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SMpinglunDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMpinglunDlg dialog = new SMpinglunDlg(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMpinglunDlg(String id,String number) {
		
		setBounds(400, 200, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("您的评论");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 10, 103, 30);
		contentPanel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true); 
		textArea.setBounds(140, 10, 271, 190);
		contentPanel.add(textArea);
		
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
 				String pinglun=textArea.getText();
 				if(pinglun.length()==0)
 				{
 					 JOptionPane.showMessageDialog(null, "评论不能为空");
 				} 	
 				
 				
 							
 				//else {
 					CommentGood obj = new CommentGood(number,id,"1",pinglun);
	 				 
	 	    		Message msg = new Message("commentgood", obj);
	 	    		
	 	    		Object temp = Sender.send(msg);
		    		Message res = (Message)temp;
		            
		    		while(res.status.equals("100"));
 				
 						JOptionPane.showMessageDialog(null, "操作成功");
 						dispose();
 				//}				
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
