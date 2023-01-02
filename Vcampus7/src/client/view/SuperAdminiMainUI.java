package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.*;
import client.view.MainPanelUI.paneDate;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.Icon;


public class SuperAdminiMainUI extends JFrame  {
	
	int index=0;
	private paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("picture//show1.jpg"), new ImageIcon("picture//show2.jpg"),
			new ImageIcon("picture//show3.jpg"), new ImageIcon("picture//show4.jpg"), new ImageIcon("picture//show5.jpg")};
	private JPanel contentPane;
	private JPanel UserInforPanel;
	private JPanel SwitchPanel;
	private JPanel MainPanel;
	private JPanel PersonalPanel1;
	private JPanel PersonalPanel2;
	private JLabel lblCardLabel;
	private JLabel lblCardLabel1;
	private JLabel lblBookLabel;
	private JLabel lblBookLabel1;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblHeadLabel;
	private JPanel ForMainPanel;
	private JPanel ForPersonPanel;
	private JPanel ForEducationPanel;
	private JPanel ForLibraryPanel;
	private JPanel ForStorePanel;
	private JLabel lblMainHeadLabel;
	private JLabel lblPersonHeadLabel;
	private JLabel lblCardLabel0;
	private JLabel lblCardLabel01;
	private JLabel lblBackgroundLabel;
	private JLabel lblShooltitleLabel;
	private JSeparator Headseparator0;
	private JLabel lblExitLabel;
	private JLabel lblExitLabel1;
	private JLabel lblShowLabel;
	private JPanel inSwitchpanel;
	private JPanel WebsiPanel;
	private JLabel lblSwiftLabel;
	private JPanel inSwitchPanel2;
	private JLabel lblSwitchIconLabel2;
	private JLabel lblSwitchLabel2;
	private JPanel inSwitchPanel1_2;
	private JLabel lblSwitchIconLabel1_2;
	private JLabel lblSwitchLabel1_2;
	private JPanel inSwitchPanel1_3;
	private JLabel lblSwitchIconLabel1_3;
	private JLabel lblSwitchLabel1_3;
	private JPanel inSwitchPanel1_4;
	private JLabel lblSwitchIconLabel1_4;
	private JLabel lblSwitchLabel1_4;
	private JLabel lblScheduleLabel;
	private JPanel inSwitchpanel_1;
	private JLabel lblSchedLabel;
	private JSeparator swSeparator_1;
	private JLabel lblWebsiteLabel;
	private JLabel lblWebLabel;
	private JPanel WebPanel;
	private JLabel lblWebLabel1;
	private JPanel WebPanel_1;
	private JLabel lblWebLabel_1;
	private JLabel lblWebLabel1_1;
	private JPanel WebPanel_2;
	private JLabel lblWebLabel_2;
	private JLabel lblWebLabel1_2;
	private JPanel WebPanel_3;
	private JLabel lblWebLabel_3;
	private JLabel lblWebLabel1_3;
	private JPanel WebPanel_4;
	private JLabel lblWebLabel_4;
	private JLabel lblWebLabel1_4;
	private JPanel WebPanel_5;
	private JLabel lblWebLabel_5;
	private JLabel lblWebLabel1_5;
	private JPanel WebPanel_6;
	private JLabel lblWebLabel_6;
	private JLabel lblWebLabel1_6;
	private JPanel WebPanel_7;
	private JLabel lblWebLabel_7;
	private JLabel lblWebLabel1_7;
	private JPanel StatusPanel;
	private JLabel lblStatusLabel;
	private JLabel lblStatusLabel2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperAdminiMainUI frame = new SuperAdminiMainUI("343191956","崔致远","34");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public SuperAdminiMainUI(String t1,String t2,String t3) {
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		setTitle("\u865A\u62DF\u6821\u56ED");
		UserInfor user=new UserInfor(t1,t2,t3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1680, 1050);
		contentPane = new JPanel();
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		// 获取图片 三种图片格式都可以
		java.awt.Image img = tk.getImage("picture\\title.png");
		// 给窗体设置图标
		this.setIconImage(img);
		
		UserInforPanel = new JPanel();
		//UserInforPanel.setBackground(new Color(200,246, 247, 252));
	    UserInforPanel.setBackground(new Color(246, 247, 252));
	    UserInforPanel.setOpaque(false);//透明
		UserInforPanel.setBounds(0, 0, 260, 1011);
		contentPane.add(UserInforPanel);
		UserInforPanel.setLayout(null);
		UserInforPanel.setBorder(new LineBorder(new Color(192,192,192)));
		
		
		JLabel lblWelcomeLabel1 = new JLabel("\u6B22\u8FCE\u4F60\uFF01");
		lblWelcomeLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblWelcomeLabel1.setBounds(42, 225, 86, 53);
		UserInforPanel.add(lblWelcomeLabel1);
		
        //头像自适应
		ImageIcon images = new ImageIcon("picture\\administer.jpg");//!!!!!根据数据库返回的图像
		Image temp_image = images.getImage();
		temp_image = temp_image.getScaledInstance(175,175, Image.SCALE_DEFAULT);
		images.setImage(temp_image);
		
		lblHeadLabel = new JLabel(images);
		lblHeadLabel.setBounds(42, 40, 175, 175);
		UserInforPanel.add(lblHeadLabel);
		
		JLabel lblWelcomeLabel2 = new JLabel(user.name);
		lblWelcomeLabel2.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblWelcomeLabel2.setBounds(111, 225, 111, 53);
		UserInforPanel.add(lblWelcomeLabel2);
		
		lblNewLabel = new JLabel("\u6211\u7684\u6570\u636E");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblNewLabel.setBounds(42, 283, 118, 46);
		UserInforPanel.add(lblNewLabel);
		
		PersonalPanel1 = new JPanel();
		PersonalPanel1.setBackground(new Color(255, 255, 255));
		PersonalPanel1.setBorder(new LineBorder(Color.WHITE, 2, true));
		PersonalPanel1.setToolTipText("");
		PersonalPanel1.setBounds(24, 339, 212, 100);
		UserInforPanel.add(PersonalPanel1);
		PersonalPanel1.setLayout(null);
		
		images = new ImageIcon("picture\\card.jpg");
		lblCardLabel = new JLabel(images);
		lblCardLabel.setBounds(10, 10, 54, 30);
		PersonalPanel1.add(lblCardLabel);
		
		lblCardLabel1 = new JLabel("\u3010\u6821\u56ED\u5361\u3011");
		lblCardLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblCardLabel1.setBounds(61, 10, 102, 30);
		PersonalPanel1.add(lblCardLabel1);
		
		lblCardLabel0 = new JLabel("\u5361\u53F7\uFF1A");
		lblCardLabel0.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblCardLabel0.setBounds(20, 50, 62, 30);
		PersonalPanel1.add(lblCardLabel0);
		
		lblCardLabel01 = new JLabel(user.UserID);
		lblCardLabel01.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblCardLabel01.setBounds(71, 51, 131, 30);
		PersonalPanel1.add(lblCardLabel01);
		
		PersonalPanel2 = new JPanel();
		PersonalPanel2.setToolTipText("");
		PersonalPanel2.setBorder(new LineBorder(Color.WHITE, 2, true));
		PersonalPanel2.setBackground(Color.WHITE);
		PersonalPanel2.setBounds(24, 500, 212, 100);
		UserInforPanel.add(PersonalPanel2);
		PersonalPanel2.setLayout(null);
		
		images = new ImageIcon("picture\\book.jpg");
		lblBookLabel = new JLabel(images);
		lblBookLabel.setBounds(15, 10, 44, 40);
		PersonalPanel2.add(lblBookLabel);
		
		lblBookLabel1 = new JLabel("\u3010\u56FE\u4E66\u9986\u3011");
		lblBookLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblBookLabel1.setBounds(64, 15, 102, 30);
		PersonalPanel2.add(lblBookLabel1);
		
		separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(24, 276, 212, 1);
		UserInforPanel.add(separator);
		
		StatusPanel = new JPanel();
		StatusPanel.setLayout(null);
		StatusPanel.setForeground(Color.LIGHT_GRAY);
		StatusPanel.setBorder(new LineBorder(new Color(192, 192, 192)));
		StatusPanel.setBackground(Color.WHITE);
		StatusPanel.setBounds(260, 980, 1406, 34);
		contentPane.add(StatusPanel);
		
		lblStatusLabel = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		lblStatusLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblStatusLabel.setBounds(10, 0, 101, 34);
		StatusPanel.add(lblStatusLabel);
		
		lblStatusLabel2 = new JLabel(user.UserID+" ("+user.status+")");
		lblStatusLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		lblStatusLabel2.setBounds(95, 0, 222, 34);
		StatusPanel.add(lblStatusLabel2);
		
		SwitchPanel = new JPanel();
		SwitchPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		//SwitchPanel.setOpaque(false);
		SwitchPanel.setBackground(Color.WHITE);
		SwitchPanel.setBounds(259, 0, 1405, 50);
		contentPane.add(SwitchPanel);
		SwitchPanel.setLayout(null);
		
		Headseparator0 = new JSeparator();
		Headseparator0.setOrientation(SwingConstants.VERTICAL);
		Headseparator0.setForeground(Color.LIGHT_GRAY);
		Headseparator0.setBackground(Color.LIGHT_GRAY);
		Headseparator0.setBounds(158, 0, 2, 50);
		SwitchPanel.add(Headseparator0);
		
		JSeparator Headseparator1 = new JSeparator();
		Headseparator1.setForeground(Color.LIGHT_GRAY);
		Headseparator1.setOrientation(SwingConstants.VERTICAL);
		Headseparator1.setBackground(Color.LIGHT_GRAY);
		Headseparator1.setBounds(266, 2, 2, 40);
		SwitchPanel.add(Headseparator1);
		
		JSeparator Headseparator2 = new JSeparator();
		Headseparator2.setOrientation(SwingConstants.VERTICAL);
		Headseparator2.setForeground(Color.LIGHT_GRAY);
		Headseparator2.setBackground(Color.LIGHT_GRAY);
		Headseparator2.setBounds(377, 0, 2, 40);
		SwitchPanel.add(Headseparator2);
		
		JSeparator Headseparator3 = new JSeparator();
		Headseparator3.setOrientation(SwingConstants.VERTICAL);
		Headseparator3.setForeground(Color.LIGHT_GRAY);
		Headseparator3.setBackground(Color.LIGHT_GRAY);
		Headseparator3.setBounds(488, 0, 2, 40);
		SwitchPanel.add(Headseparator3);
		
		JSeparator Headseparator4 = new JSeparator();
		Headseparator4.setOrientation(SwingConstants.VERTICAL);
		Headseparator4.setForeground(Color.LIGHT_GRAY);
		Headseparator4.setBackground(Color.LIGHT_GRAY);
		Headseparator4.setBounds(599, 0, 2, 40);
		SwitchPanel.add(Headseparator4);
		
		JSeparator Headseparator5 = new JSeparator();
		Headseparator5.setOrientation(SwingConstants.VERTICAL);
		Headseparator5.setForeground(Color.LIGHT_GRAY);
		Headseparator5.setBackground(Color.LIGHT_GRAY);
		Headseparator5.setBounds(710, 0, 2, 40);
		SwitchPanel.add(Headseparator5);
		ForMainPanel = new JPanel();
		ForMainPanel.setBackground(Color.WHITE);
		MainPanel = new JPanel();
		MainPanel.setBackground(Color.WHITE);
		MainPanel.setBounds(259,50,1405,929);
		MainPanel.setLayout(null);
		
		
		//*************************************************************************首页
		lblShowLabel = new JLabel("");
		lblShowLabel.setBounds(170, 45, 1065, 400);
		MainPanel.add(lblShowLabel);

		inSwitchpanel = new JPanel();
		inSwitchpanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		inSwitchpanel.setBackground(Color.WHITE);
		inSwitchpanel.setBounds(44, 500, 226, 393);
		MainPanel.add(inSwitchpanel);
		inSwitchpanel.setLayout(null);
		
		lblSwiftLabel = new JLabel("\u5FEB\u6377\u5165\u53E3");
		lblSwiftLabel.setForeground(Color.DARK_GRAY);
		lblSwiftLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblSwiftLabel.setBounds(29, 22, 118, 30);
		inSwitchpanel.add(lblSwiftLabel);
		
		JSeparator swSeparator = new JSeparator();
		swSeparator.setForeground(Color.DARK_GRAY);
		swSeparator.setBackground(Color.DARK_GRAY);
		swSeparator.setBounds(28, 62, 155, 2);
		inSwitchpanel.add(swSeparator);
		
		images = new ImageIcon("picture\\1hom.jpg");
		
		inSwitchPanel2 = new JPanel();
		inSwitchPanel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inSwitchPanel2.setBackground(new Color(255, 250, 250));
				inSwitchPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inSwitchPanel2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(Color.WHITE);
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//**********************************************学生管理
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		inSwitchPanel2.setLayout(null);
		inSwitchPanel2.setBackground(Color.WHITE);
		inSwitchPanel2.setBounds(29, 87, 140, 50);
		inSwitchpanel.add(inSwitchPanel2);
		
		images = new ImageIcon("picture\\2student.jpg");
		lblSwitchIconLabel2 = new JLabel(images);
		lblSwitchIconLabel2.setBounds(10, 10, 30, 30);
		inSwitchPanel2.add(lblSwitchIconLabel2);
		
		lblSwitchLabel2 = new JLabel("\u5B66\u751F\u7BA1\u7406");
		lblSwitchLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblSwitchLabel2.setBounds(50, 10, 90, 30);
		inSwitchPanel2.add(lblSwitchLabel2);
		
		inSwitchPanel1_2 = new JPanel();
		inSwitchPanel1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inSwitchPanel1_2.setBackground(new Color(255, 250, 250));
				inSwitchPanel1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inSwitchPanel1_2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(Color.WHITE);
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//*************************************************教务
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		inSwitchPanel1_2.setLayout(null);
		inSwitchPanel1_2.setBackground(Color.WHITE);
		inSwitchPanel1_2.setBounds(29, 147, 140, 50);
		inSwitchpanel.add(inSwitchPanel1_2);
		
		images = new ImageIcon("picture\\3edu.jpg");
		lblSwitchIconLabel1_2 = new JLabel(images);
		lblSwitchIconLabel1_2.setBounds(10, 10, 30, 30);
		inSwitchPanel1_2.add(lblSwitchIconLabel1_2);
		
		lblSwitchLabel1_2 = new JLabel("\u6559\u52A1\u670D\u52A1");
		lblSwitchLabel1_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblSwitchLabel1_2.setBounds(50, 10, 90, 30);
		inSwitchPanel1_2.add(lblSwitchLabel1_2);
		
		inSwitchPanel1_3 = new JPanel();
		inSwitchPanel1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inSwitchPanel1_3.setBackground(new Color(255, 250, 250));
				inSwitchPanel1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inSwitchPanel1_3.setBackground(Color.WHITE);
			}
			public void mouseClicked(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(Color.WHITE);
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//*****************************************************图书馆
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		inSwitchPanel1_3.setLayout(null);
		inSwitchPanel1_3.setBackground(Color.WHITE);
		inSwitchPanel1_3.setBounds(29, 207, 140, 50);
		inSwitchpanel.add(inSwitchPanel1_3);
		
		images = new ImageIcon("picture\\4lib.jpg");
		lblSwitchIconLabel1_3 = new JLabel(images);
		lblSwitchIconLabel1_3.setBounds(10, 10, 30, 30);
		inSwitchPanel1_3.add(lblSwitchIconLabel1_3);
		
		lblSwitchLabel1_3 = new JLabel("\u56FE\u4E66\u9986");
		lblSwitchLabel1_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblSwitchLabel1_3.setBounds(50, 10, 80, 30);
		inSwitchPanel1_3.add(lblSwitchLabel1_3);
		
		inSwitchPanel1_4 = new JPanel();
		inSwitchPanel1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				inSwitchPanel1_4.setBackground(new Color(255, 250, 250));
				inSwitchPanel1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				inSwitchPanel1_4.setBackground(Color.WHITE);
			}
			public void mouseClicked(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(Color.WHITE);
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//**************************************************商城
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		inSwitchPanel1_4.setLayout(null);
		inSwitchPanel1_4.setBackground(Color.WHITE);
		inSwitchPanel1_4.setBounds(29, 267, 140, 50);
		inSwitchpanel.add(inSwitchPanel1_4);
		
		images = new ImageIcon("picture\\5str.jpg");
		lblSwitchIconLabel1_4 = new JLabel(images);
		lblSwitchIconLabel1_4.setBounds(10, 10, 30, 30);
		inSwitchPanel1_4.add(lblSwitchIconLabel1_4);
		
		lblSwitchLabel1_4 = new JLabel("\u7F51\u4E0A\u5546\u57CE");
		lblSwitchLabel1_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblSwitchLabel1_4.setBounds(50, 10, 90, 30);
		inSwitchPanel1_4.add(lblSwitchLabel1_4);
		
		WebsiPanel = new JPanel();
		WebsiPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		WebsiPanel.setBackground(Color.WHITE);
		WebsiPanel.setBounds(306, 500, 467, 393);
		MainPanel.add(WebsiPanel);
		WebsiPanel.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.DARK_GRAY);
		separator_1_1.setBackground(Color.DARK_GRAY);
		separator_1_1.setBounds(31, 62, 155, 2);
		WebsiPanel.add(separator_1_1);
		
		lblWebsiteLabel = new JLabel("\u5E38\u7528\u6821\u56ED\u7F51\u7AD9");
		lblWebsiteLabel.setForeground(Color.DARK_GRAY);
		lblWebsiteLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblWebsiteLabel.setBounds(31, 22, 179, 30);
		WebsiPanel.add(lblWebsiteLabel);
		
		WebPanel = new JPanel();
		WebPanel.setBackground(Color.WHITE);
		WebPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://www.seu.edu.cn/";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel.setBackground(new Color(255, 250, 250));
				WebPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel.setBackground(Color.WHITE);
			}
		});
		WebPanel.setBounds(34, 87, 157, 50);
		WebsiPanel.add(WebPanel);
		WebPanel.setLayout(null);
		
		lblWebLabel = new JLabel("\u5B66\u6821\u5B98\u7F51");
		lblWebLabel.setBounds(50, 13, 97, 24);
		WebPanel.add(lblWebLabel);
		lblWebLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		ImageIcon webimg = new ImageIcon("picture\\web1.jpg");
		lblWebLabel1 = new JLabel(webimg);
		lblWebLabel1.setBounds(10, 10, 30, 30);
		WebPanel.add(lblWebLabel1);
		
		WebPanel_1 = new JPanel();
		WebPanel_1.setLayout(null);
		WebPanel_1.setBackground(Color.WHITE);
		WebPanel_1.setBounds(34, 158, 157, 50);
		WebsiPanel.add(WebPanel_1);
		WebPanel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://newxk.urp.seu.edu.cn/xsxk/profile/index.html";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_1.setBackground(new Color(255, 250, 250));
				WebPanel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_1.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_1 = new JLabel("\u5B66\u751F\u9009\u8BFE");
		lblWebLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_1.setBounds(50, 13, 97, 24);
		WebPanel_1.add(lblWebLabel_1);
		
		webimg = new ImageIcon("picture\\web2.jpg");
		lblWebLabel1_1 = new JLabel(webimg);
		lblWebLabel1_1.setBounds(10, 10, 30, 30);
		WebPanel_1.add(lblWebLabel1_1);
		
		WebPanel_2 = new JPanel();
		WebPanel_2.setLayout(null);
		WebPanel_2.setBackground(Color.WHITE);
		WebPanel_2.setBounds(34, 239, 157, 50);
		WebsiPanel.add(WebPanel_2);
		WebPanel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://ehall.seu.edu.cn/new/index.html";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_2.setBackground(new Color(255, 250, 250));
				WebPanel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_2.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_2 = new JLabel("\u670D\u52A1\u5927\u5385");
		lblWebLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_2.setBounds(50, 13, 97, 24);
		WebPanel_2.add(lblWebLabel_2);
		
		webimg = new ImageIcon("picture\\web3.jpg");
		lblWebLabel1_2 = new JLabel(webimg);
		lblWebLabel1_2.setBounds(10, 10, 30, 30);
		WebPanel_2.add(lblWebLabel1_2);
		
		WebPanel_3 = new JPanel();
		WebPanel_3.setLayout(null);
		WebPanel_3.setBackground(Color.WHITE);
		WebPanel_3.setBounds(249, 87, 157, 50);
		WebsiPanel.add(WebPanel_3);
		WebPanel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://nic.seu.edu.cn/index.htm";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_3.setBackground(new Color(255, 250, 250));
				WebPanel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_3.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_3 = new JLabel("\u7F51\u7EDC\u4E2D\u5FC3");
		lblWebLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_3.setBounds(50, 13, 97, 24);
		WebPanel_3.add(lblWebLabel_3);
		
		webimg = new ImageIcon("picture\\web4.jpg");
		lblWebLabel1_3 = new JLabel(webimg);
		lblWebLabel1_3.setBounds(10, 10, 30, 30);
		WebPanel_3.add(lblWebLabel1_3);
		
		WebPanel_4 = new JPanel();
		WebPanel_4.setLayout(null);
		WebPanel_4.setBackground(Color.WHITE);
		WebPanel_4.setBounds(249, 158, 157, 50);
		WebsiPanel.add(WebPanel_4);
		WebPanel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://jwc.seu.edu.cn/";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_4.setBackground(new Color(255, 250, 250));
				WebPanel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_4.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_4 = new JLabel("\u6559\u52A1\u5904");
		lblWebLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_4.setBounds(50, 13, 97, 24);
		WebPanel_4.add(lblWebLabel_4);
		
		webimg = new ImageIcon("picture\\web5.jpg");
		lblWebLabel1_4 = new JLabel(webimg);
		lblWebLabel1_4.setBounds(10, 10, 30, 30);
		WebPanel_4.add(lblWebLabel1_4);
		
		WebPanel_5 = new JPanel();
		WebPanel_5.setLayout(null);
		WebPanel_5.setBackground(Color.WHITE);
		WebPanel_5.setBounds(249, 239, 157, 50);
		WebsiPanel.add(WebPanel_5);
		WebPanel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://zwc.seu.edu.cn/";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_5.setBackground(new Color(255, 250, 250));
				WebPanel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_5.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_5 = new JLabel("\u603B\u52A1\u5904");
		lblWebLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_5.setBounds(50, 13, 97, 24);
		WebPanel_5.add(lblWebLabel_5);
		
		webimg = new ImageIcon("picture\\web6.jpg");
		lblWebLabel1_5 = new JLabel(webimg);
		lblWebLabel1_5.setBounds(10, 10, 30, 30);
		WebPanel_5.add(lblWebLabel1_5);
		
		WebPanel_6 = new JPanel();
		WebPanel_6.setLayout(null);
		WebPanel_6.setBackground(Color.WHITE);
		WebPanel_6.setBounds(31, 316, 157, 50);
		WebsiPanel.add(WebPanel_6);
		WebPanel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://my.seu.edu.cn/";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_6.setBackground(new Color(255, 250, 250));
				WebPanel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_6.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_6 = new JLabel("\u4FE1\u606F\u95E8\u6237");
		lblWebLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_6.setBounds(50, 13, 97, 24);
		WebPanel_6.add(lblWebLabel_6);
		
		webimg = new ImageIcon("picture\\web7.jpg");
		lblWebLabel1_6 = new JLabel(webimg);
		lblWebLabel1_6.setBounds(10, 10, 30, 30);
		WebPanel_6.add(lblWebLabel1_6);
		
		WebPanel_7 = new JPanel();
		WebPanel_7.setLayout(null);
		WebPanel_7.setBackground(Color.WHITE);
		WebPanel_7.setBounds(249, 316, 157, 50);
		WebsiPanel.add(WebPanel_7);
		WebPanel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://caiwuchujf.seu.edu.cn/";
				try {
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						desktop.browse(java.net.URI.create(url));
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				WebPanel_7.setBackground(new Color(255, 250, 250));
				WebPanel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				WebPanel_7.setBackground(Color.WHITE);
			}
		});
		
		lblWebLabel_7 = new JLabel("\u8D22\u52A1\u5904");
		lblWebLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblWebLabel_7.setBounds(50, 13, 97, 24);
		WebPanel_7.add(lblWebLabel_7);
		
		webimg = new ImageIcon("picture\\web8.jpg");
		lblWebLabel1_7 = new JLabel(webimg);
		lblWebLabel1_7.setBounds(10, 10, 30, 30);
		WebPanel_7.add(lblWebLabel1_7);
		panedate = new paneDate();
		panedate.setBounds(170, 45, 1065, 400);
		MainPanel.add(panedate);
		Timer timer = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panedate.repaint();
			}
		});
		timer.start();
		
		inSwitchpanel_1 = new JPanel();
		inSwitchpanel_1.setLayout(null);
		inSwitchpanel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		inSwitchpanel_1.setBackground(Color.WHITE);
		inSwitchpanel_1.setBounds(808, 500, 550, 393);
		MainPanel.add(inSwitchpanel_1);
		
		lblSchedLabel = new JLabel("\u8FD1\u671F\u6821\u5386");
		lblSchedLabel.setForeground(Color.DARK_GRAY);
		lblSchedLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
		lblSchedLabel.setBounds(29, 22, 118, 30);
		inSwitchpanel_1.add(lblSchedLabel);
		
		swSeparator_1 = new JSeparator();
		swSeparator_1.setForeground(Color.DARK_GRAY);
		swSeparator_1.setBackground(Color.DARK_GRAY);
		swSeparator_1.setBounds(28, 62, 155, 2);
		inSwitchpanel_1.add(swSeparator_1);
		images = new ImageIcon("picture\\secdule1.jpg");
		lblScheduleLabel = new JLabel(images);
		lblScheduleLabel.setBounds(10, 81, 535, 302);
		inSwitchpanel_1.add(lblScheduleLabel);
		contentPane.add(MainPanel);
		ForMainPanel.setBorder(null);
		ForMainPanel.setBounds(160, 1, 106, 40);
		SwitchPanel.add(ForMainPanel);
		ForMainPanel.setLayout(null);
		ForMainPanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {//鼠标移入
				if(ForMainPanel.getBackground()!=Color.WHITE)
				{
					ForMainPanel.setBackground(new Color(255, 250, 250));
					ForMainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {//移出
				if(ForMainPanel.getBackground()!=Color.WHITE)
				{
					ForMainPanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {//按压
				ForMainPanel.setBackground(Color.WHITE);
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				JPanel temp=new JPanel();
				temp.setBackground(Color.WHITE);
				temp.setBounds(259,50,1405,929);
				temp.setLayout(null);
				
				//***************************************************************************************首页内容重复
				inSwitchpanel = new JPanel();
				inSwitchpanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
				inSwitchpanel.setBackground(Color.WHITE);
				inSwitchpanel.setBounds(44, 500, 226, 393);
				temp.add(inSwitchpanel);
				inSwitchpanel.setLayout(null);
				
				lblSwiftLabel = new JLabel("\u5FEB\u6377\u5165\u53E3");
				lblSwiftLabel.setForeground(Color.DARK_GRAY);
				lblSwiftLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
				lblSwiftLabel.setBounds(29, 22, 118, 30);
				inSwitchpanel.add(lblSwiftLabel);
				
				JSeparator swSeparator = new JSeparator();
				swSeparator.setForeground(Color.DARK_GRAY);
				swSeparator.setBackground(Color.DARK_GRAY);
				swSeparator.setBounds(28, 62, 155, 2);
				inSwitchpanel.add(swSeparator);
				
				inSwitchPanel2 = new JPanel();
				inSwitchPanel2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						inSwitchPanel2.setBackground(new Color(255, 250, 250));
						inSwitchPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						inSwitchPanel2.setBackground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						ForMainPanel.setBackground(new Color(240, 240, 240));
						ForPersonPanel.setBackground(Color.WHITE);
						ForEducationPanel.setBackground(new Color(240, 240, 240));
						ForLibraryPanel.setBackground(new Color(240, 240, 240));
						ForStorePanel.setBackground(new Color(240, 240, 240));
						
						MainPanel.setVisible(false);
						MainPanel = new MainPanelUI();//**************************************************学生管理
						MainPanel.setBounds(259,50,1405,929);
						contentPane.add(MainPanel);
						repaint();
					}
				});
				inSwitchPanel2.setLayout(null);
				inSwitchPanel2.setBackground(Color.WHITE);
				inSwitchPanel2.setBounds(29, 87, 140, 50);
				inSwitchpanel.add(inSwitchPanel2);
				
				ImageIcon images = new ImageIcon("picture\\2student.jpg");
				lblSwitchIconLabel2 = new JLabel(images);
				lblSwitchIconLabel2.setBounds(10, 10, 30, 30);
				inSwitchPanel2.add(lblSwitchIconLabel2);
				
				lblSwitchLabel2 = new JLabel("\u5B66\u751F\u7BA1\u7406");
				lblSwitchLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblSwitchLabel2.setBounds(50, 10, 90, 30);
				inSwitchPanel2.add(lblSwitchLabel2);
				
				inSwitchPanel1_2 = new JPanel();
				inSwitchPanel1_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						inSwitchPanel1_2.setBackground(new Color(255, 250, 250));
						inSwitchPanel1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						inSwitchPanel1_2.setBackground(Color.WHITE);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						ForMainPanel.setBackground(new Color(240, 240, 240));
						ForPersonPanel.setBackground(new Color(240, 240, 240));
						ForEducationPanel.setBackground(Color.WHITE);
						ForLibraryPanel.setBackground(new Color(240, 240, 240));
						ForStorePanel.setBackground(new Color(240, 240, 240));
						
						MainPanel.setVisible(false);
						MainPanel = new MainPanelUI();//**************************************************************教务
						MainPanel.setBounds(259,50,1405,929);
						contentPane.add(MainPanel);
						repaint();
					}
				});
				inSwitchPanel1_2.setLayout(null);
				inSwitchPanel1_2.setBackground(Color.WHITE);
				inSwitchPanel1_2.setBounds(29, 147, 140, 50);
				inSwitchpanel.add(inSwitchPanel1_2);
				
				images = new ImageIcon("picture\\3edu.jpg");
				lblSwitchIconLabel1_2 = new JLabel(images);
				lblSwitchIconLabel1_2.setBounds(10, 10, 30, 30);
				inSwitchPanel1_2.add(lblSwitchIconLabel1_2);
				
				lblSwitchLabel1_2 = new JLabel("\u6559\u52A1\u670D\u52A1");
				lblSwitchLabel1_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblSwitchLabel1_2.setBounds(50, 10, 90, 30);
				inSwitchPanel1_2.add(lblSwitchLabel1_2);
				
				inSwitchPanel1_3 = new JPanel();
				inSwitchPanel1_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						inSwitchPanel1_3.setBackground(new Color(255, 250, 250));
						inSwitchPanel1_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						inSwitchPanel1_3.setBackground(Color.WHITE);
					}
					public void mouseClicked(MouseEvent e) {
						ForMainPanel.setBackground(new Color(240, 240, 240));
						ForPersonPanel.setBackground(new Color(240, 240, 240));
						ForEducationPanel.setBackground(new Color(240, 240, 240));
						ForLibraryPanel.setBackground(Color.WHITE);
						ForStorePanel.setBackground(new Color(240, 240, 240));
						
						MainPanel.setVisible(false);
						MainPanel = new MainPanelUI();//********************************************************图书馆
						MainPanel.setBounds(259,50,1405,929);
						contentPane.add(MainPanel);
						repaint();
					}
				});
				inSwitchPanel1_3.setLayout(null);
				inSwitchPanel1_3.setBackground(Color.WHITE);
				inSwitchPanel1_3.setBounds(29, 207, 140, 50);
				inSwitchpanel.add(inSwitchPanel1_3);
				
				images = new ImageIcon("picture\\4lib.jpg");
				lblSwitchIconLabel1_3 = new JLabel(images);
				lblSwitchIconLabel1_3.setBounds(10, 10, 30, 30);
				inSwitchPanel1_3.add(lblSwitchIconLabel1_3);
				
				lblSwitchLabel1_3 = new JLabel("\u56FE\u4E66\u9986");
				lblSwitchLabel1_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblSwitchLabel1_3.setBounds(50, 10, 80, 30);
				inSwitchPanel1_3.add(lblSwitchLabel1_3);
				
				inSwitchPanel1_4 = new JPanel();
				inSwitchPanel1_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						inSwitchPanel1_4.setBackground(new Color(255, 250, 250));
						inSwitchPanel1_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						inSwitchPanel1_4.setBackground(Color.WHITE);
					}
					public void mouseClicked(MouseEvent e) {
						ForMainPanel.setBackground(new Color(240, 240, 240));
						ForPersonPanel.setBackground(new Color(240, 240, 240));
						ForEducationPanel.setBackground(new Color(240, 240, 240));
						ForLibraryPanel.setBackground(new Color(240, 240, 240));
						ForStorePanel.setBackground(Color.WHITE);
						
						MainPanel.setVisible(false);
						MainPanel = new MainPanelUI();//******************************************************商城
						MainPanel.setBounds(259,50,1405,929);
						contentPane.add(MainPanel);
						repaint();
					}
				});
				inSwitchPanel1_4.setLayout(null);
				inSwitchPanel1_4.setBackground(Color.WHITE);
				inSwitchPanel1_4.setBounds(29, 267, 140, 50);
				inSwitchpanel.add(inSwitchPanel1_4);
				
				images = new ImageIcon("picture\\5str.jpg");
				lblSwitchIconLabel1_4 = new JLabel(images);
				lblSwitchIconLabel1_4.setBounds(10, 10, 30, 30);
				inSwitchPanel1_4.add(lblSwitchIconLabel1_4);
				
				lblSwitchLabel1_4 = new JLabel("\u7F51\u4E0A\u5546\u57CE");
				lblSwitchLabel1_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblSwitchLabel1_4.setBounds(50, 10, 90, 30);
				inSwitchPanel1_4.add(lblSwitchLabel1_4);
				
				WebsiPanel = new JPanel();
				WebsiPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
				WebsiPanel.setBackground(Color.WHITE);
				WebsiPanel.setBounds(306, 500, 467, 393);
				temp.add(WebsiPanel);
				WebsiPanel.setLayout(null);
				
				JSeparator separator_1_1 = new JSeparator();
				separator_1_1.setForeground(Color.DARK_GRAY);
				separator_1_1.setBackground(Color.DARK_GRAY);
				separator_1_1.setBounds(31, 62, 155, 2);
				WebsiPanel.add(separator_1_1);
				
				lblWebsiteLabel = new JLabel("\u5E38\u7528\u6821\u56ED\u7F51\u7AD9");
				lblWebsiteLabel.setForeground(Color.DARK_GRAY);
				lblWebsiteLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
				lblWebsiteLabel.setBounds(31, 22, 179, 30);
				WebsiPanel.add(lblWebsiteLabel);
				
				WebPanel = new JPanel();
				WebPanel.setBackground(Color.WHITE);
				WebPanel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "https://www.seu.edu.cn/";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel.setBackground(new Color(255, 250, 250));
						WebPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel.setBackground(Color.WHITE);
					}
				});
				WebPanel.setBounds(34, 87, 157, 50);
				WebsiPanel.add(WebPanel);
				WebPanel.setLayout(null);
				
				lblWebLabel = new JLabel("\u5B66\u6821\u5B98\u7F51");
				lblWebLabel.setBounds(50, 13, 97, 24);
				WebPanel.add(lblWebLabel);
				lblWebLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				
				ImageIcon webimg = new ImageIcon("picture\\web1.jpg");
				lblWebLabel1 = new JLabel(webimg);
				lblWebLabel1.setBounds(10, 10, 30, 30);
				WebPanel.add(lblWebLabel1);
				
				WebPanel_1 = new JPanel();
				WebPanel_1.setLayout(null);
				WebPanel_1.setBackground(Color.WHITE);
				WebPanel_1.setBounds(34, 158, 157, 50);
				WebsiPanel.add(WebPanel_1);
				WebPanel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "http://newxk.urp.seu.edu.cn/xsxk/profile/index.html";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_1.setBackground(new Color(255, 250, 250));
						WebPanel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_1.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_1 = new JLabel("\u5B66\u751F\u9009\u8BFE");
				lblWebLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_1.setBounds(50, 13, 97, 24);
				WebPanel_1.add(lblWebLabel_1);
				
				webimg = new ImageIcon("picture\\web2.jpg");
				lblWebLabel1_1 = new JLabel(webimg);
				lblWebLabel1_1.setBounds(10, 10, 30, 30);
				WebPanel_1.add(lblWebLabel1_1);
				
				WebPanel_2 = new JPanel();
				WebPanel_2.setLayout(null);
				WebPanel_2.setBackground(Color.WHITE);
				WebPanel_2.setBounds(34, 239, 157, 50);
				WebsiPanel.add(WebPanel_2);
				WebPanel_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "http://ehall.seu.edu.cn/new/index.html";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_2.setBackground(new Color(255, 250, 250));
						WebPanel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_2.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_2 = new JLabel("\u670D\u52A1\u5927\u5385");
				lblWebLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_2.setBounds(50, 13, 97, 24);
				WebPanel_2.add(lblWebLabel_2);
				
				webimg = new ImageIcon("picture\\web3.jpg");
				lblWebLabel1_2 = new JLabel(webimg);
				lblWebLabel1_2.setBounds(10, 10, 30, 30);
				WebPanel_2.add(lblWebLabel1_2);
				
				WebPanel_3 = new JPanel();
				WebPanel_3.setLayout(null);
				WebPanel_3.setBackground(Color.WHITE);
				WebPanel_3.setBounds(249, 87, 157, 50);
				WebsiPanel.add(WebPanel_3);
				WebPanel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "https://nic.seu.edu.cn/index.htm";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_3.setBackground(new Color(255, 250, 250));
						WebPanel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_3.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_3 = new JLabel("\u7F51\u7EDC\u4E2D\u5FC3");
				lblWebLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_3.setBounds(50, 13, 97, 24);
				WebPanel_3.add(lblWebLabel_3);
				
				webimg = new ImageIcon("picture\\web4.jpg");
				lblWebLabel1_3 = new JLabel(webimg);
				lblWebLabel1_3.setBounds(10, 10, 30, 30);
				WebPanel_3.add(lblWebLabel1_3);
				
				WebPanel_4 = new JPanel();
				WebPanel_4.setLayout(null);
				WebPanel_4.setBackground(Color.WHITE);
				WebPanel_4.setBounds(249, 158, 157, 50);
				WebsiPanel.add(WebPanel_4);
				WebPanel_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//打开网站
						Desktop desktop = Desktop.getDesktop();
						String url = "https://jwc.seu.edu.cn/";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_4.setBackground(new Color(255, 250, 250));
						WebPanel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_4.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_4 = new JLabel("\u6559\u52A1\u5904");
				lblWebLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_4.setBounds(50, 13, 97, 24);
				WebPanel_4.add(lblWebLabel_4);
				
				webimg = new ImageIcon("picture\\web5.jpg");
				lblWebLabel1_4 = new JLabel(webimg);
				lblWebLabel1_4.setBounds(10, 10, 30, 30);
				WebPanel_4.add(lblWebLabel1_4);
				
				WebPanel_5 = new JPanel();
				WebPanel_5.setLayout(null);
				WebPanel_5.setBackground(Color.WHITE);
				WebPanel_5.setBounds(249, 239, 157, 50);
				WebsiPanel.add(WebPanel_5);
				WebPanel_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "https://zwc.seu.edu.cn/";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_5.setBackground(new Color(255, 250, 250));
						WebPanel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_5.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_5 = new JLabel("\u603B\u52A1\u5904");
				lblWebLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_5.setBounds(50, 13, 97, 24);
				WebPanel_5.add(lblWebLabel_5);
				
				webimg = new ImageIcon("picture\\web6.jpg");
				lblWebLabel1_5 = new JLabel(webimg);
				lblWebLabel1_5.setBounds(10, 10, 30, 30);
				WebPanel_5.add(lblWebLabel1_5);
				
				WebPanel_6 = new JPanel();
				WebPanel_6.setLayout(null);
				WebPanel_6.setBackground(Color.WHITE);
				WebPanel_6.setBounds(31, 316, 157, 50);
				WebsiPanel.add(WebPanel_6);
				WebPanel_6.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "http://my.seu.edu.cn/";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_6.setBackground(new Color(255, 250, 250));
						WebPanel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_6.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_6 = new JLabel("\u4FE1\u606F\u95E8\u6237");
				lblWebLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_6.setBounds(50, 13, 97, 24);
				WebPanel_6.add(lblWebLabel_6);
				
				webimg = new ImageIcon("picture\\web7.jpg");
				lblWebLabel1_6 = new JLabel(webimg);
				lblWebLabel1_6.setBounds(10, 10, 30, 30);
				WebPanel_6.add(lblWebLabel1_6);
				
				WebPanel_7 = new JPanel();
				WebPanel_7.setLayout(null);
				WebPanel_7.setBackground(Color.WHITE);
				WebPanel_7.setBounds(249, 316, 157, 50);
				WebsiPanel.add(WebPanel_7);
				WebPanel_7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Desktop desktop = Desktop.getDesktop();
						String url = "http://caiwuchujf.seu.edu.cn/";
						try {
							if (desktop.isSupported(Desktop.Action.BROWSE)) {
								desktop.browse(java.net.URI.create(url));
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
					@Override
					public void mouseEntered(MouseEvent e) {
						WebPanel_7.setBackground(new Color(255, 250, 250));
						WebPanel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						WebPanel_7.setBackground(Color.WHITE);
					}
				});
				
				lblWebLabel_7 = new JLabel("\u8D22\u52A1\u5904");
				lblWebLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
				lblWebLabel_7.setBounds(50, 13, 97, 24);
				WebPanel_7.add(lblWebLabel_7);
				
				webimg = new ImageIcon("picture\\web8.jpg");
				lblWebLabel1_7 = new JLabel(webimg);
				lblWebLabel1_7.setBounds(10, 10, 30, 30);
				WebPanel_7.add(lblWebLabel1_7);
				panedate = new paneDate();
				panedate.setBounds(170, 45, 1065, 400);
				temp.add(panedate);
				Timer timer= new Timer(4000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panedate.repaint();
					}
				});
				//timer1.start();
				
				inSwitchpanel_1 = new JPanel();
				inSwitchpanel_1.setLayout(null);
				inSwitchpanel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
				inSwitchpanel_1.setBackground(Color.WHITE);
				inSwitchpanel_1.setBounds(808, 500, 550, 393);
				temp.add(inSwitchpanel_1);
				
				lblSchedLabel = new JLabel("\u8FD1\u671F\u6821\u5386");
				lblSchedLabel.setForeground(Color.DARK_GRAY);
				lblSchedLabel.setFont(new Font("微软雅黑", Font.BOLD, 25));
				lblSchedLabel.setBounds(29, 22, 118, 30);
				inSwitchpanel_1.add(lblSchedLabel);
				
				swSeparator_1 = new JSeparator();
				swSeparator_1.setForeground(Color.DARK_GRAY);
				swSeparator_1.setBackground(Color.DARK_GRAY);
				swSeparator_1.setBounds(28, 62, 155, 2);
				inSwitchpanel_1.add(swSeparator_1);
				images = new ImageIcon("picture\\secdule1.jpg");
				lblScheduleLabel = new JLabel(images);
				lblScheduleLabel.setBounds(10, 81, 535, 302);
				inSwitchpanel_1.add(lblScheduleLabel);			
				//********************************************************************************重复
				
				MainPanel=temp;
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		lblMainHeadLabel = new JLabel("\u9996\u9875");
		lblMainHeadLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblMainHeadLabel.setBounds(10, 5, 44, 30);
		ForMainPanel.add(lblMainHeadLabel);
		
		ForPersonPanel = new JPanel();
		ForPersonPanel.setBorder(null);
		ForPersonPanel.setBounds(268, 1, 108, 40);
		SwitchPanel.add(ForPersonPanel);
		ForPersonPanel.setLayout(null);
		ForPersonPanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(ForPersonPanel.getBackground()!=Color.WHITE)
				{
					ForPersonPanel.setBackground(new Color(255, 250, 250));
					ForPersonPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(ForPersonPanel.getBackground()!=Color.WHITE)
				{
					ForPersonPanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(Color.WHITE);
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//******************************************************学生管理
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		lblPersonHeadLabel = new JLabel("\u5B66\u751F\u7BA1\u7406");
		lblPersonHeadLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblPersonHeadLabel.setBounds(10, 5, 88, 30);
		ForPersonPanel.add(lblPersonHeadLabel);
		
		ForEducationPanel = new JPanel();
		ForEducationPanel.setBorder(null);
		ForEducationPanel.setBounds(379, 1, 108, 40);
		SwitchPanel.add(ForEducationPanel);
		ForEducationPanel.setLayout(null);
		ForEducationPanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(ForEducationPanel.getBackground()!=Color.WHITE)
				{
					ForEducationPanel.setBackground(new Color(255, 250, 250));
					ForEducationPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(ForEducationPanel.getBackground()!=Color.WHITE)
				{
					ForEducationPanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(Color.WHITE);
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//*********************************************************教务
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		JLabel lblEducationLabel = new JLabel("\u6559\u52A1\u670D\u52A1");
		lblEducationLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblEducationLabel.setBounds(10, 5, 88, 30);
		ForEducationPanel.add(lblEducationLabel);
		
		ForLibraryPanel = new JPanel();
		ForLibraryPanel.setBorder(null);
		ForLibraryPanel.setBounds(490, 1, 108, 40);
		SwitchPanel.add(ForLibraryPanel);
		ForLibraryPanel.setLayout(null);
		ForLibraryPanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(ForLibraryPanel.getBackground()!=Color.WHITE)
				{
					ForLibraryPanel.setBackground(new Color(255, 250, 250));
					ForLibraryPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(ForLibraryPanel.getBackground()!=Color.WHITE)
				{
					ForLibraryPanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(Color.WHITE);
				ForStorePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//*************************************************************图书馆
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		JLabel lblLibraryLabel = new JLabel("\u56FE\u4E66\u9986");
		lblLibraryLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblLibraryLabel.setBounds(10, 5, 82, 30);
		ForLibraryPanel.add(lblLibraryLabel);
		
		ForStorePanel = new JPanel();
		ForStorePanel.setBorder(null);
		ForStorePanel.setBounds(601, 1, 108, 40);
		SwitchPanel.add(ForStorePanel);
		ForStorePanel.setLayout(null);
		ForStorePanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(ForStorePanel.getBackground()!=Color.WHITE)
				{
					ForStorePanel.setBackground(new Color(255, 250, 250));
					ForStorePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(ForStorePanel.getBackground()!=Color.WHITE)
				{
					ForStorePanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(Color.WHITE);
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//******************************************************************商城
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		JLabel lblStoreLabel = new JLabel("\u7F51\u4E0A\u5546\u57CE");
		lblStoreLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblStoreLabel.setBounds(10, 5, 82, 30);
		ForStorePanel.add(lblStoreLabel);
		
		images = new ImageIcon("picture\\school_title.jpg");
		lblShooltitleLabel = new JLabel(images);
		lblShooltitleLabel.setBounds(5, 5, 152, 40);
		SwitchPanel.add(lblShooltitleLabel);
		
		images = new ImageIcon("picture\\exit1.jpg");
		
		JPanel ExitPanel = new JPanel();
		ExitPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		ExitPanel.setBackground(Color.WHITE);
		ExitPanel.setBounds(1241, 9, 136, 32);
		SwitchPanel.add(ExitPanel);
		ExitPanel.setLayout(null);
		ExitPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {//鼠标移入
				ExitPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginUI().setVisible(true);
				//System.exit(0);
				dispose();
			}
		});
		
		lblExitLabel1 = new JLabel("\u7528\u6237\u767B\u51FA");
		lblExitLabel1.setBounds(40, 0, 86, 30);
		ExitPanel.add(lblExitLabel1);
		lblExitLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblExitLabel = new JLabel(images);
		lblExitLabel.setBounds(13, 5, 20, 20);
		ExitPanel.add(lblExitLabel);
		
		ImageIcon bgimages = new ImageIcon("picture\\bg2.jpg");
		lblBackgroundLabel = new JLabel(bgimages);
		lblBackgroundLabel.setBounds(0, 0, 260, 1011);
		contentPane.add(lblBackgroundLabel);
		
	}
	class paneDate extends JPanel {
		/**
		 * 图片轮播
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imageicon[index % imageicon.length].getImage(), 1, 1, this);
			index++;
		}
	}
	
}
