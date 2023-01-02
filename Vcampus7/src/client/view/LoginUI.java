package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import java.awt.image.BufferedImage;


import client.service.CheckCode;//默认内容类
import client.service.TextPrompt;//默认内容类

import server.common.*;
import server.communication.*;
import client.*;

public class LoginUI extends JFrame{
	
	JLabel label = new JLabel();
	JLabel nameLabel=new JLabel("",JLabel.CENTER);
	SpringLayout springLayout=new SpringLayout();
	
	JPanel centerPanel=new JPanel(springLayout);
	
	JLabel username=new JLabel();
	JTextField userText=new JTextField();
	JLabel pas=new JLabel();
	JPasswordField pasText=new JPasswordField();
	//验证码图片
	JLabel check=new JLabel();
	JTextField checkText=new JTextField();
	
	JButton loginbtn=new JButton("登录");
	JButton zhuche=new JButton("注册");
	JButton change=new JButton("看不清，换一张");
	
	
	public LoginUI() {
		super("Login");
		Container contentPane=getContentPane();
		
		nameLabel.setFont(new Font("华文行楷",Font.PLAIN,40));
		nameLabel.setPreferredSize(new Dimension(200,80));
		
		Font centerFont =new Font("楷体",Font.PLAIN,20);
		Font centerFont1 =new Font("楷体",Font.PLAIN,15);
		Font centerFont2 =new Font("楷体",Font.PLAIN,10);
		username.setFont(centerFont);
		userText.setPreferredSize(new Dimension(200,30));
		//check.setFont(centerFont);
		check.setPreferredSize(new Dimension(110,30));
		checkText.setPreferredSize(new Dimension(122,30));
		pas.setFont(centerFont);
		pasText.setPreferredSize(new Dimension(200,30));
		loginbtn.setFont(centerFont);
		loginbtn.setPreferredSize(new Dimension(250,30));
		loginbtn.setBackground(Color.decode("#75d0ff"));
		loginbtn.setForeground(Color.white);
		zhuche.setFont(centerFont1);
		zhuche.setBorderPainted(false);
		zhuche.setForeground(Color.black);
		zhuche.setContentAreaFilled(false);
		change.setFont(centerFont2);
		change.setBorderPainted(false);
		change.setForeground(Color.gray);
		change.setContentAreaFilled(false);
		
		ImageIcon img = new ImageIcon((BufferedImage)CheckCode.createImage()[1]);//创建图片对象
		ImageIcon img0 = new ImageIcon("picture/54.png");
		ImageIcon img1 = new ImageIcon("picture/65.png");
		ImageIcon img2 = new ImageIcon("picture/75.png");//创建图片对象
		
		
		nameLabel.setIcon(img0);
		check.setIcon(img);
		username.setIcon(img1);
		pas.setIcon(img2);
		
		centerPanel.add(username);
		centerPanel.add(userText);
		centerPanel.add(pas);
		centerPanel.add(pasText);
		centerPanel.add(loginbtn);
		//loginbtn.addActionListener();
		centerPanel.add(zhuche);
		//zhuche.addActionListener();
		centerPanel.add(check);
		centerPanel.add(checkText);
		centerPanel.add(change);
		
		 new TextPrompt("账号", userText);
		 new TextPrompt("密码", pasText);
		 new TextPrompt("验证码", checkText);

		
		
		//弹簧布局
		//Spring titleLabelWidth=Spring.width(username);
		//Spring titleTxtwidth=Spring.width(titleTxt);
		//Spring spaceWidth=Spring.constant(20);
		//Spring childWidth=Spring.sum(Spring.sum(titleLabelWidth, titleTxtwidth),spaceWidth);
		//int offsetX=childWidth.getValue()/2;
		
		Spring childWidth=Spring.sum(Spring.sum(Spring.width(username), Spring.width(userText)), Spring.constant(20));
		int offsetX=childWidth.getValue()/2;
		//账号
		springLayout.putConstraint(SpringLayout.WEST, username,-offsetX-1,SpringLayout.HORIZONTAL_CENTER, centerPanel);
		springLayout.putConstraint(SpringLayout.NORTH, username,10,SpringLayout.NORTH, centerPanel);
		
		springLayout.putConstraint(SpringLayout.WEST, userText,20,SpringLayout.EAST, username);
		springLayout.putConstraint(SpringLayout.NORTH, userText,0,SpringLayout.NORTH, username);
		//密码
		springLayout.putConstraint(SpringLayout.EAST, pas,0,SpringLayout.EAST, username);
		springLayout.putConstraint(SpringLayout.NORTH, pas,20,SpringLayout.SOUTH, username);
		
		springLayout.putConstraint(SpringLayout.WEST, pasText,20,SpringLayout.EAST, pas);
		springLayout.putConstraint(SpringLayout.NORTH, pasText,0,SpringLayout.NORTH, pas);
		//验证码
		springLayout.putConstraint(SpringLayout.WEST, check,0,SpringLayout.WEST, pas);
		springLayout.putConstraint(SpringLayout.NORTH, check,20,SpringLayout.SOUTH, pas);
		//换一张
		springLayout.putConstraint(SpringLayout.WEST, change,0,SpringLayout.WEST, check);
		springLayout.putConstraint(SpringLayout.NORTH, change,-5,SpringLayout.SOUTH, check);
		
		springLayout.putConstraint(SpringLayout.WEST, checkText,20,SpringLayout.EAST, check);
		springLayout.putConstraint(SpringLayout.NORTH, checkText,0,SpringLayout.NORTH, check);
		//登录
		springLayout.putConstraint(SpringLayout.WEST, loginbtn,-50,SpringLayout.WEST, pasText);
		springLayout.putConstraint(SpringLayout.NORTH, loginbtn,60,SpringLayout.SOUTH, pasText);
		
		springLayout.putConstraint(SpringLayout.WEST, zhuche,10,SpringLayout.EAST, loginbtn);
		springLayout.putConstraint(SpringLayout.NORTH, zhuche,40,SpringLayout.NORTH, loginbtn);
		
		
		contentPane.add(nameLabel,BorderLayout.NORTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
	
		
		setSize(450,350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setBackground(Color.decode("#ebf2f9"));
	
		//点击看不清，换一张更换验证码
		change.addMouseListener((MouseListener) new MouseListener(){
			
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==e.BUTTON1)
				{
					ImageIcon img3 = new ImageIcon((BufferedImage)CheckCode.createImage()[1]);//创建图片对象
					check.setIcon(img3);
					//System.out.println("鼠标左点击事件");
				}
				//System.out.println("鼠标点击事件完成");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//点击图片更换
        check.addMouseListener((MouseListener) new MouseListener(){
			
			public void mouseClicked(MouseEvent e)
			{
				if(e.getButton()==e.BUTTON1)
				{
					ImageIcon img3 = new ImageIcon((BufferedImage)CheckCode.createImage()[1]);//创建图片对象
					check.setIcon(img3);
					//System.out.println("鼠标左点击事件");
				}
				//System.out.println("鼠标点击事件完成");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	//点击注册按钮	
	loginbtn.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = userText.getText();
            String password = new String( pasText.getPassword());
            String checkcode = checkText.getText();
            String a=CheckCode.code;
            if(0==name.length()){
                JOptionPane.showMessageDialog(contentPane, "账号不能为空");
               // userText.grabFocus();
                
                return;
            }
            if(0==password.length()){
                JOptionPane.showMessageDialog(contentPane, "密码不能为空");
              
                return;
            }
            if(0==checkcode.length()){
                JOptionPane.showMessageDialog(contentPane, "验证码不能为空");
              
                return;
            }
            if(!(a.equals(checkcode))){
                JOptionPane.showMessageDialog(contentPane, "验证码错误");
             
                return;
            }
	            //与后端通信程序qkLm
	            LoginClass obj = new LoginClass(name,password);
	    		Message msg = new Message("login", obj);
	    		
	    		Object temp = Sender.send(msg);
	    		Message res = (Message)temp;
	            
	    		while(res.status.equals("100"));
	    		
	    		if(res.status.equals("200"))
	    		{
	                JOptionPane.showMessageDialog(contentPane, "登陆成功");	                
	              //登录成功进入主页面
    				dispose();
    				LoginFeedback tpFeedback=(LoginFeedback)res.response[0];
    				switch(tpFeedback.priority)
    				{
    				case "2":
    					new TeacherMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				case "1":
    					new StudentMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				case "3":
    					new EduAdminiMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				case "4":
    					new LibrarianMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				case "5":
    					new SaleAdminiMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				case "6":
    					new SuperAdminiMainUI(name,tpFeedback.name,tpFeedback.priority).setVisible(true);
    					break;
    				default:
    					System.out.println("身份信息错误！");
    					break;
    				}
	                return;
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(contentPane, ((LoginFeedback)res.response[0]).name);
	    			return;
	    		}
	        }
	    });
		
		//点击注册按钮弹出登陆页面
		zhuche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击，跳转登陆界面
				dispose();
				new RegisterUI();
			}
		});
	}
	public static void main(String[] args) {
		new LoginUI();
	}

}