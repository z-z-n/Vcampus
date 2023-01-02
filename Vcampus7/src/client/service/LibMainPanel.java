package client.service;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.LineBorder;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class LibMainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LibMainPanel() {
		setBackground(Color.WHITE);
		setSize(1076,822);
		setOpaque(true) ;
		
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		String hehe = dateFormat.format( now );
		
String year= hehe.substring(0,4);
String month= hehe.substring(5,7);
String date= hehe.substring(8,11);
		
		
		
		
		JPanel a1 = new JPanel();
		a1.setBackground(new Color(255, 255, 255));
		a1.setBounds(610, 288, 344, 534);
		
		
		add(a1);
		a1.setLayout(null);
		
		JLabel  b1= new JLabel("每日推荐");
		b1.setBounds(89, 10, 165, 53);
		//b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setBackground(new Color(240, 240, 240));
		b1.setForeground(new Color(210, 180, 140));
		b1.setFont(new Font("华文楷体", Font.BOLD, 40));
		b1.setHorizontalAlignment(SwingConstants.TRAILING);
		a1.add(b1);
		
		JLabel b2 = new JLabel();ImageIcon img1 = new ImageIcon("picture//moon.jpg");
		b2.setBounds(22, 73, 300, 201);
		b2.setIcon(img1);
		a1.add(b2);
		
		JButton c1 = new JButton("《月亮与六便士》");
		c1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		c1.setBounds(22, 300, 300, 30);
		c1.setBackground(Color.WHITE);
		a1.add(c1);
		c1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://baike.baidu.com/item/%E6%9C%88%E4%BA%AE%E5%92%8C%E5%85%AD%E4%BE%BF%E5%A3%AB/9521816?fromtitle=%E6%9C%88%E4%BA%AE%E4%B8%8E%E5%85%AD%E4%BE%BF%E5%A3%AB&fromid=476673&fr=aladdin";
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
				c1.setBackground(new Color(255, 250, 250));
				c1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				c1.setBackground(Color.WHITE);
			}
		});
		JButton c2 = new JButton("《了不起的盖茨比》");
		c2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		c2.setBounds(22, 346, 300, 30);
		c2.setBackground(Color.WHITE);
		a1.add(c2);
		c2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://baike.baidu.com/item/%E4%BA%86%E4%B8%8D%E8%B5%B7%E7%9A%84%E7%9B%96%E8%8C%A8%E6%AF%94/1535?fr=aladdin";
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
				c2.setBackground(new Color(255, 250, 250));
				c2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				c2.setBackground(Color.WHITE);
			}
		});
		JButton c4 = new JButton("《简爱》");
		c4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		c4.setBounds(22, 438, 300, 30);
		c4.setBackground(Color.WHITE);
		a1.add(c4);
		c4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://baike.baidu.com/item/%E7%AE%80%C2%B7%E7%88%B1/5526?fromtitle=%E7%AE%80%E7%88%B1&fromid=379080";
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
				c4.setBackground(new Color(255, 250, 250));
				c4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				c4.setBackground(Color.WHITE);
			}
		});
		JButton c3 = new JButton("《人性的弱点》");
		c3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		c3.setBounds(22, 392, 300, 30);
		a1.add(c3);
		c3.setBackground(Color.WHITE);
		c3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://baike.baidu.com/item/%E4%BA%BA%E6%80%A7%E7%9A%84%E5%BC%B1%E7%82%B9/83258";
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
				c3.setBackground(new Color(255, 250, 250));
				c3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				c3.setBackground(Color.WHITE);
			}
		});
		JButton c5 = new JButton("《相对论》");
		c5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		c5.setBounds(22, 480, 300, 30);
		a1.add(c5);
		c5.setBackground(Color.WHITE);
		c5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "https://baike.baidu.com/item/%E7%9B%B8%E5%AF%B9%E8%AE%BA/48750";
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
				c5.setBackground(new Color(255, 250, 250));
				c5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				c5.setBackground(Color.WHITE);
			}
		});
		
		
	
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 26, 1076, 132);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.BLACK);
		ImageIcon img0 = new ImageIcon("picture//head1.png");
		lblNewLabel.setIcon(img0);
		
		
		final ImageIcon[] icons = new ImageIcon[3];
		icons[0] = new ImageIcon("picture//head1.png");
		icons[1] = new ImageIcon("picture//head2.png");
		icons[2] = new ImageIcon("picture//head3.png");
		final Random random = new Random();
		new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setIcon(icons[random.nextInt(icons.length)]);
			}
		}).start();
		setLayout(null);
//		
		add(lblNewLabel);
		lblNewLabel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 184, 1076, 30);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(525, 212, 30, 610);
		add(panel_1);
		
		JLabel date1 = new JLabel();
		ImageIcon img4 = new ImageIcon("picture//date.png");
		date1.setIcon(img4);
		date1.setBounds(591, 234, 50, 50);
		add(date1);
		
		String year1=year;
		String month1=month;
		String day1=date;
		JLabel date2 = new JLabel(year1+"年");
		date2.setHorizontalAlignment(SwingConstants.CENTER);
		date2.setForeground(Color.RED);
		
		date2.setBounds(647, 234, 124, 50);
		date2.setFont(new Font("华文楷体", Font.BOLD, 30));
		add(date2);
		
		JLabel date2_1 = new JLabel(month1+"月");
		date2_1.setHorizontalAlignment(SwingConstants.CENTER);
		date2_1.setForeground(Color.BLUE);
		date2_1.setFont(new Font("华文楷体", Font.BOLD, 30));
		date2_1.setBounds(778, 234, 80, 50);
		add(date2_1);
		
		JLabel date2_2 = new JLabel(day1+"日");
		date2_2.setHorizontalAlignment(SwingConstants.CENTER);
		date2_2.setForeground(Color.GREEN);
		date2_2.setFont(new Font("华文楷体", Font.BOLD, 30));
		date2_2.setBounds(868, 234, 80, 50);
		add(date2_2);
		
		JLabel news = new JLabel("新闻咨询");
		news.setForeground(Color.RED);
		news.setBounds(59, 244, 60, 20);
		add(news);
		
		JButton news1 = new JButton("图书馆中外文电子资源满意度调查");
		news1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://lib.seu.edu.cn/bencandy.php?fid=263&id=8353";
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
				news1.setBackground(new Color(255, 250, 250));
				news1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				news1.setBackground(Color.WHITE);
			}
		});
		news1.setHorizontalAlignment(SwingConstants.LEFT);
		news1.setBounds(59, 274, 433, 30);
		add(news1);
		news1.setBackground(Color.WHITE);
		news1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				news1.setBackground(new Color(43, 187, 173));
				news1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				news1.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		
		JButton news2 = new JButton("我馆成功立项2021年度国家知识产权局专利局专利信息服务科研创新项目");
		news2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://lib.seu.edu.cn/bencandy.php?fid=263&id=8352";
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
				news2.setBackground(new Color(255, 250, 250));
				news2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				news2.setBackground(Color.WHITE);
			}
		});
		news2.setHorizontalAlignment(SwingConstants.LEFT);
		news2.setBounds(59, 318, 433, 30);
		add(news2);
		news2.setBackground(Color.WHITE);
		news2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				news2.setBackground(new Color(43, 187, 173));
				news2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				news2.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		JButton news3 = new JButton("清华大学图书馆蒋耘中书记一行来我馆调研交流");
		news3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://lib.seu.edu.cn/bencandy.php?fid=263&id=8344";
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
				news3.setBackground(new Color(255, 250, 250));
				news3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				news3.setBackground(Color.WHITE);
			}
		});
		news3.setHorizontalAlignment(SwingConstants.LEFT);
		news3.setBounds(59, 362, 433, 30);
		add(news3);
		news3.setBackground(Color.WHITE);
		news3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				news3.setBackground(new Color(43, 187, 173));
				news3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				news3.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		JButton news5 = new JButton("发挥文献计量专长 服务学者发展需求 ——学科服务走进机械工程学院");
		news5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://lib.seu.edu.cn/bencandy.php?fid=263&id=8336";
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
				news5.setBackground(new Color(255, 250, 250));
				news5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				news5.setBackground(Color.WHITE);
			}
		});
		news5.setHorizontalAlignment(SwingConstants.LEFT);
		news5.setBounds(59, 446, 433, 30);
		add(news5);
		news5.setBackground(Color.WHITE);
		news5.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				news5.setBackground(new Color(43, 187, 173));
				news5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				news5.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		JButton news4 = new JButton("图书馆热议习近平总书记在庆祝中国共产党成立100周年大会上的讲话");
		news4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Desktop desktop = Desktop.getDesktop();
				String url = "http://lib.seu.edu.cn/bencandy.php?fid=263&id=8328";
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
				news4.setBackground(new Color(255, 250, 250));
				news4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				news4.setBackground(Color.WHITE);
			}
		});
		news4.setHorizontalAlignment(SwingConstants.LEFT);
		news4.setBounds(59, 402, 433, 30);
		add(news4);
		news4.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(39, 524, 469, 249);
		
		final ImageIcon[] icons1 = new ImageIcon[3];
		icons1[0] = new ImageIcon("picture//tail1.png");
		icons1[1] = new ImageIcon("picture//tail2.png");
		icons1[2] = new ImageIcon("picture//tail3.png");
		lblNewLabel_1.setIcon(icons1[0]);
		final Random random1 = new Random();
		new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_1.setIcon(icons1[random1.nextInt(icons1.length)]);
			}
		}).start();
		setLayout(null);
		add(lblNewLabel_1);
		news4.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				news4.setBackground(new Color(43, 187, 173));
				news4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				news4.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			
			}
		});	

	}
}
