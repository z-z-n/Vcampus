package client.service;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import client.Sender;
import server.common.BackBook;
import server.common.BorrowBook;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LibStuLendPanel2 extends JPanel{
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public LibStuLendPanel2(String card,String number)
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
	
	JButton btnNewButton = new JButton("借阅");
	btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	btnNewButton.setBounds(149, 229, 93, 23);
	panel.add(btnNewButton);

	JLabel lblNewLabel = new JLabel("图书借阅");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setForeground(new Color(255, 200, 0));
	lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
	lblNewLabel.setBounds(0, 20, 300, 30);
	panel.add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("所要借阅书号：");
	lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_2.setBounds(99, 101, 100, 30);
	panel.add(lblNewLabel_2);
	
	textField_2 = new JTextField();
	textField_2.setText(number);
	textField_2.setColumns(10);
	textField_2.setBounds(199, 101, 100, 30);
	panel.add(textField_2);
	
	JLabel lblNewLabel_3 = new JLabel("归还日期：");
	lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
	lblNewLabel_3.setBounds(99, 162, 100, 30);
	panel.add(lblNewLabel_3);
	
	textField_3 = new JTextField();
	textField_3.setText("");
	textField_3.setColumns(10);
	textField_3.setBounds(199, 162, 147, 30);
	new TextPrompt("例如2021-07-18", textField_3);
	panel.add(textField_3);
	
	
	
	btnNewButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {

        //	String card=textField.getText();
        	String id=number;
        	String da=textField_3.getText();
        	int flag=0;
       	 	String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(da);
            boolean dateFlag = m.matches();
            if (!dateFlag) {
           	 JOptionPane.showMessageDialog(null,"格式错误");
               
            }
           
            else {
           	 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
                formatter.setLenient(false);
                try{  
               	 Date date = formatter.parse(da); 
               	 flag=1;
                }catch(Exception e1){
                    flag=0;
                }
	            //与后端通信程序qkLm
                if(flag==1) {
	            //与后端通信程序qkLm
	            BorrowBook obj = new BorrowBook(card,id,da);
	    		Message msg = new Message("borrow", obj);
	    		
	    		Object temp = Sender.send(msg);
	    		Message res = (Message)temp;
	            
	    		while(res.status.equals("100"));
	    		
	    		if(res.status.equals("201"))
	    		{
	                JOptionPane.showMessageDialog(null, "借阅成功");	                          
    				
	    		}
	    		else if(res.status.equals("102"))
	    		{
	    			JOptionPane.showMessageDialog(null, "书被借出");
	    			
	    		}
	    		else if(res.status.equals("103"))
	    		{
	    			JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context);
	    			
	    		}
	    		else if(res.status.equals("104"))
	    		{
	    			JOptionPane.showMessageDialog(null,((UniversalClass)res.response[0]).context);
	    			
	    		}
                }
                else {
                	JOptionPane.showMessageDialog(null,"非法日期");
                }
	        }
        }
	    });
	}
}
