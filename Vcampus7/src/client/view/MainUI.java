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


public class MainUI extends JFrame  {
	
	int index=0;
	protected paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("picture//show1.jpg"), new ImageIcon("picture//show2.jpg"),
			new ImageIcon("picture//show3.jpg"), new ImageIcon("picture//show4.jpg"), new ImageIcon("picture//show5.jpg")};
	protected JPanel contentPane;
	protected JPanel UserInforPanel;
	protected JPanel SwitchPanel;
	protected JPanel MainPanel;
	protected JLabel lblNewLabel;
	protected JSeparator separator;
	protected JLabel lblHeadLabel;
	protected JPanel ForMainPanel;
	protected JPanel ForPersonPanel;
	protected JPanel ForEducationPanel;
	protected JPanel ForLibraryPanel;
	protected JPanel ForStorePanel;
	protected JPanel ForLifePanel;
	protected JLabel lblMainHeadLabel;
	protected JLabel lblPersonHeadLabel;
	protected JSeparator Headseparator6;
	protected JLabel lblBackgroundLabel;
	protected JLabel lblShooltitleLabel;
	protected JSeparator Headseparator0;
	protected JLabel lblExitLabel;
	protected JLabel lblExitLabel1;
	protected JLabel lblShowLabel;
	protected JPanel inSwitchpanel;
	protected JPanel WebsiPanel;
	protected JLabel lblSwiftLabel;
	protected JLabel lblScheduleLabel;
	protected JPanel inSwitchpanel_1;
	protected JLabel lblSchedLabel;
	protected JSeparator swSeparator_1;
	protected JLabel lblWebsiteLabel;
	protected JLabel lblWebLabel;
	protected JPanel WebPanel;
	protected JLabel lblWebLabel1;
	protected JPanel WebPanel_1;
	protected JLabel lblWebLabel_1;
	protected JLabel lblWebLabel1_1;
	protected JPanel WebPanel_2;
	protected JLabel lblWebLabel_2;
	protected JLabel lblWebLabel1_2;
	protected JPanel WebPanel_3;
	protected JLabel lblWebLabel_3;
	protected JLabel lblWebLabel1_3;
	protected JPanel WebPanel_4;
	protected JLabel lblWebLabel_4;
	protected JLabel lblWebLabel1_4;
	protected JPanel WebPanel_5;
	protected JLabel lblWebLabel_5;
	protected JLabel lblWebLabel1_5;
	protected JPanel WebPanel_6;
	protected JLabel lblWebLabel_6;
	protected JLabel lblWebLabel1_6;
	protected JPanel WebPanel_7;
	protected JLabel lblWebLabel_7;
	protected JLabel lblWebLabel1_7;
	protected JPanel StatusPanel;
	protected JLabel lblStatusLabel;
	protected JLabel lblStatusLabel2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI("213191956","崔致远","2");
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
	public MainUI(String t1,String t2,String t3) {
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
		ImageIcon images = new ImageIcon("picture\\head_temp.jpg");//!!!!!根据数据库返回的图像
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
		
		images = new ImageIcon("picture\\card.jpg");
		
		images = new ImageIcon("picture\\book.jpg");
		
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
		
		images = new ImageIcon("picture\\2per.jpg");
		
		images = new ImageIcon("picture\\3edu.jpg");
		
		images = new ImageIcon("picture\\4lib.jpg");
		
		images = new ImageIcon("picture\\5str.jpg");
		
		images = new ImageIcon("picture\\6life.jpg");
		
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
		//******************************************************
		
		Headseparator6 = new JSeparator();
		Headseparator6.setOrientation(SwingConstants.VERTICAL);
		Headseparator6.setForeground(Color.LIGHT_GRAY);
		Headseparator6.setBackground(Color.LIGHT_GRAY);
		Headseparator6.setBounds(821, 0, 2, 40);
		//*****************************************************************************************首页选项
		SwitchPanel.add(Headseparator6);
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
				ForLifePanel.setBackground(new Color(240, 240, 240));
				
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
				ImageIcon images = new ImageIcon("picture\\secdule1.jpg");
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
				ForLifePanel.setBackground(new Color(240, 240, 240));
				
				MainPanel.setVisible(false);
				MainPanel = new StManagerUI_St(user.UserID,user.name);//******************************************************个人中心
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		lblPersonHeadLabel = new JLabel("\u4E2A\u4EBA\u4E2D\u5FC3");
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
				ForLifePanel.setBackground(new Color(240, 240, 240));
				
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
				ForLifePanel.setBackground(new Color(240, 240, 240));
				
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
				ForLifePanel.setBackground(new Color(240, 240, 240));
				
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
		
		ForLifePanel = new JPanel();
		ForLifePanel.setBorder(null);
		ForLifePanel.setBounds(712, 1, 108, 40);
		SwitchPanel.add(ForLifePanel);
		ForLifePanel.setLayout(null);
		ForLifePanel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(ForLifePanel.getBackground()!=Color.WHITE)
				{
					ForLifePanel.setBackground(new Color(255, 250, 250));
					ForLifePanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(ForLifePanel.getBackground()!=Color.WHITE)
				{
					ForLifePanel.setBackground(new Color(240, 240, 240));
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				ForMainPanel.setBackground(new Color(240, 240, 240));
				ForEducationPanel.setBackground(new Color(240, 240, 240));
				ForPersonPanel.setBackground(new Color(240, 240, 240));
				ForLibraryPanel.setBackground(new Color(240, 240, 240));
				ForStorePanel.setBackground(new Color(240, 240, 240));
				ForLifePanel.setBackground(Color.WHITE);
				
				MainPanel.setVisible(false);
				MainPanel = new MainPanelUI();//******************************************************生活服务
				MainPanel.setBounds(259,50,1405,929);
				contentPane.add(MainPanel);
				repaint();
			}
		});
		
		JLabel lblLifeLabel = new JLabel("\u751F\u6D3B\u670D\u52A1");
		lblLifeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblLifeLabel.setBounds(10, 5, 82, 30);
		ForLifePanel.add(lblLifeLabel);
		
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
		protected static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imageicon[index % imageicon.length].getImage(), 1, 1, this);
			index++;
		}
	}
	
}
