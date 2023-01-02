package client.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import com.lms.ui.headerIcon2;
//import com.lms.ui.libraryManagerPanel;

import java.awt.Dimension;

import client.UserInfor;
import client.service.*;

public class LibStuMainUI extends JPanel {
	int index = 0;
//	private static JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtBookeName;
	private JTextField txtBookNamber;
	private JTable Tables;
	private JPanel panelBigerMain;
	private JLabel txtheader;
	private JLabel txtheader2;
	private JLabel lblLibraryMessage;
	private JLabel lblMainMenu;
	private JLabel lbllendManager;
	private JLabel lblUserManae;
	private JLabel lblHeaderOne;
	private ImageIcon headerImage;
	private JPanel panelIcon;
	private JPanel panelheadIcon;

	
	/**
	 * 
	 */
	public LibStuMainUI(UserInfor a) {
		
		setOpaque(true) ;
		setSize(1405,929);
		setOpaque(true) ;
		setBorder(new LineBorder(Color.LIGHT_GRAY));
		setLayout(null);
		
		//JPanel contentPane = new JPanel();
		
		JPanel panel = new JPanel();
		//JPanel contentPane = new JPanel();
		//add(contentPane);
		panel.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, 1, 250, 889);
		add(panel);
		panel.setLayout(null);

		panelheadIcon = new JPanel();
		panelheadIcon.setBackground(Color.WHITE);
		panelheadIcon.setBounds(0, 0, 249, 251);
		panel.add(panelheadIcon);
		panelheadIcon.setLayout(null);
			
		panelIcon = new LibheaderIconPanel();
		panelIcon.setBounds(36, 28, 188, 188);
		panelheadIcon.add(panelIcon);
		
		JPanel panelMenu = new JPanel();
		panelMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMenu.setBackground(new Color(43, 187, 173));
				panelMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelMenu.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//txtheader.setText(lbllendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LibMainPanel();
				panelBigerMain.setBounds(286, 68, 1076, 822);
				add(panelBigerMain);
				repaint();
			}
		});
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBounds(0, 250, 249, 44);
		panel.add(panelMenu);
		panelMenu.setLayout(null);

		lblMainMenu = new JLabel(" 图书馆主页");
		lblMainMenu.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblMainMenu.setForeground(Color.BLACK);
		lblMainMenu.setBounds(100, 13, 74, 20);
		panelMenu.add(lblMainMenu);
		ImageIcon imageMenu = new ImageIcon("picture\\lbmain1.png");
		JLabel lblMenu1 = new JLabel(imageMenu);
		lblMenu1.setBounds(50, 12, 22, 22);
		panelMenu.add(lblMenu1);
		
		

		JPanel paneLibrarymanage = new JPanel();
		paneLibrarymanage.setLayout(null);
		paneLibrarymanage.setBackground(Color.WHITE);
		paneLibrarymanage.setBounds(0, 295, 249, 44);
		panel.add(paneLibrarymanage);
		paneLibrarymanage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneLibrarymanage.setBackground(new Color(43, 187, 173));
				paneLibrarymanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneLibrarymanage.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//txtheader.setText(lbllendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LibStuPanel(a.UserID);
				panelBigerMain.setBounds(286, 68, 1076, 623);
				add(panelBigerMain);
				repaint();

			}
		});
		lblLibraryMessage = new JLabel(" 个人信息");
		lblLibraryMessage.setForeground(Color.BLACK);
		lblLibraryMessage.setFont(new Font("微软雅黑 Light", Font.PLAIN,13));
		lblLibraryMessage.setBounds(100, 13, 74, 20);
		paneLibrarymanage.add(lblLibraryMessage);
		ImageIcon imageManager = new ImageIcon("picture\\lbmain2.png");
		JLabel lblManager = new JLabel(imageManager);
		lblManager.setBounds(50, 12, 22, 22);
		paneLibrarymanage.add(lblManager);
		
		
		JPanel paneLendManage = new JPanel();
		paneLendManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paneLendManage.setBackground(new Color(43, 187, 173));
				paneLendManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				paneLendManage.setBackground(Color.white);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				//txtheader.setText(lbllendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LibSearchPanel(a.UserID);
				panelBigerMain.setBounds(286, 68, 1076, 623);
			    add(panelBigerMain);
				repaint();

			}
		});
		paneLendManage.setLayout(null);
		paneLendManage.setBackground(Color.WHITE);
		paneLendManage.setBounds(0, 340, 249, 44);
		panel.add(paneLendManage);

		lbllendManager = new JLabel(" 图书查阅");
		lbllendManager.setForeground(Color.BLACK);
		lbllendManager.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lbllendManager.setBounds(100, 13, 74, 20);
		paneLendManage.add(lbllendManager);

		
		ImageIcon imagelend = new ImageIcon("picture\\lbmain3.png");
		JLabel lblManager_1 = new JLabel(imagelend);
		lblManager_1.setBounds(50, 12, 22, 22);
		paneLendManage.add(lblManager_1);

		JPanel panelUsermanage = new JPanel();
		panelUsermanage.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panelUsermanage.setBackground(new Color(43, 187, 173));
				panelUsermanage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelUsermanage.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//txtheader.setText(lbllendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LibStuLendPanel(a.UserID);
				panelBigerMain.setBounds(286, 68, 1076, 623);
				add(panelBigerMain);
				repaint();
			
			}
		});
		panelUsermanage.setLayout(null);
		panelUsermanage.setBackground(Color.WHITE);
		panelUsermanage.setBounds(0, 385, 249, 44);
		panel.add(panelUsermanage);

		lblUserManae = new JLabel(" 借阅图书");
		lblUserManae.setForeground(Color.BLACK);
		lblUserManae.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblUserManae.setBounds(100, 13, 74, 20);
		panelUsermanage.add(lblUserManae);
		
		
		ImageIcon imageUsermanger = new ImageIcon("picture\\\\lbmain4.png");
		JLabel lblManager_1_1 = new JLabel(imageUsermanger);
		lblManager_1_1.setBounds(50, 12, 22, 22);
		panelUsermanage.add(lblManager_1_1);

		JPanel panelstatisticsManage = new JPanel();
		panelstatisticsManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelstatisticsManage.setBackground(new Color(43, 187, 173));
				panelstatisticsManage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelstatisticsManage.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			//	txtheader.setText(lbllendManager.getText());
				panelBigerMain.setVisible(false);
				panelBigerMain = new LibStuRetPanel(a.UserID);
				panelBigerMain.setBounds(286, 68, 1076, 623);
				add(panelBigerMain);
				repaint();
				

			}
		});
		panelstatisticsManage.setLayout(null);
		panelstatisticsManage.setBackground(Color.WHITE);
		panelstatisticsManage.setBounds(0, 429, 249, 44);
		panel.add(panelstatisticsManage);

		JLabel lblstatistics = new JLabel(" 归还图书");
		lblstatistics.setForeground(Color.BLACK);
		lblstatistics.setFont(new Font("微软雅黑 Light", Font.PLAIN, 13));
		lblstatistics.setBounds(100, 13, 74, 20);
		panelstatisticsManage.add(lblstatistics);
		ImageIcon imagestatistics = new ImageIcon("picture\\\\lbmain5.png");
		JLabel lblManager_1_1_1 = new JLabel(imagestatistics);
		lblManager_1_1_1.setText("");
		lblManager_1_1_1.setBounds(50, 12, 22, 22);
		panelstatisticsManage.add(lblManager_1_1_1);
		
		
		
		txtheader = new JLabel("东南大学图书馆");
		txtheader.setFont(new Font("华文楷体", Font.BOLD, 40));
		txtheader.setForeground(new Color(105, 105, 105));
		txtheader.setBounds(650, 12, 300, 40);
		add(txtheader);
		
		panelBigerMain = new LibMainPanel();
		panelBigerMain.setBounds(286, 68, 1076, 822);
		add(panelBigerMain);
		
}
}
