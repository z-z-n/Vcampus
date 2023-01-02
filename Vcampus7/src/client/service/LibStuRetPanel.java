package client.service;


import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import client.Sender;
import client.view.MainUI;
import server.common.BackBook;
import server.common.LoginClass;
import server.common.LoginFeedback;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LibStuRetPanel extends JPanel{
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public LibStuRetPanel(String card)
	{
	
		setOpaque(true) ;
	setSize(1076,623);
	setBorder(new LineBorder(Color.LIGHT_GRAY));
	setLayout(null);
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setBorder(new LineBorder(Color.white));
	
	panel.setBounds(40, 31, 718, 404);
	add(panel);
	panel.setLayout(null);
	
	JButton btnNewButton = new JButton("归还");
	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	btnNewButton.setBounds(150, 164, 93, 23);
	panel.add(btnNewButton);


	
	JLabel lblNewLabel_2 = new JLabel("所要归还书号：");
	lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_2.setBounds(96, 99, 100, 30);
	panel.add(lblNewLabel_2);
	
	textField_2 = new JTextField();
	textField_2.setText("");
	textField_2.setColumns(10);
	textField_2.setBounds(196, 99, 100, 30);
	panel.add(textField_2);
	
	JLabel lblNewLabel = new JLabel("图书归还");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(new Color(255, 200, 0));
	lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
	lblNewLabel.setBounds(0, 20, 300, 30);
	panel.add(lblNewLabel);
	
	/*JLabel lblNewLabel_3 = new JLabel("该书出版社：");
	lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_3.setBounds(100, 213, 100, 30);
	panel.add(lblNewLabel_3);*/
	
	/*textField_3 = new JTextField();
	textField_3.setText("");
	textField_3.setColumns(10);
	textField_3.setBounds(200, 213, 100, 30);
	panel.add(textField_3);*/
	

	
	/*btnNewButton.addActionListener(null);
		@Override
		public void actionPerformed(ActionEvent e) {
			if(status==202)////////////////////////////////////////////////////归还成功的判断
			{
				
				if(status==104)
				{
					JOptionPane.showMessageDialog(null, "归还超时");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "归还成功");
				}
		}
			else {
				JOptionPane.showMessageDialog(null, "归还失败，没有该书");
			}
		}
	});*/
	btnNewButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	String id=textField_2.getText();
        	if(id.length()==0)
    		{
    			JOptionPane.showMessageDialog(null, "书号不能为空");
    		}
        	else {
	            //与后端通信程序qkLm
	            BackBook obj = new BackBook(card,id);
	    		Message msg = new Message("back", obj);
	    		
	    		Object temp = Sender.send(msg);
	    		Message res = (Message)temp;
	            
	    		while(res.status.equals("100"));
	    		
	    		if(res.status.equals("202"))
	    		{
	                JOptionPane.showMessageDialog(null, "归还成功");	                
	              //登录成功进入主页面
    				
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "没有借该书");
	    			return;
	    		}
	        }
        }
	    });
		
	
	
	}

}