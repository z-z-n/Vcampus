package client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Sender;
import server.common.Chat;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddOrCreateUI extends JFrame {

	private JPanel contentPane;
	private String name="崔致远";
	private String ID="213191956";
	private String g_name="群聊1";

	private String g_ID="213191956";//加群聊
	private String g_reason="我是……";//加群理由
	private JPanel panel_friend;
	private JPanel panel_Srgroup;
	private JPanel panel_Crgroup;
	private JLabel lblLabel_friend;
	private JLabel lblLabel_Srgroup;
	private JLabel lblLabel_Crgroup;
	private JPanel panel_operation;
	//public JLabel lblNewLabel;
	public ChetMainUI a;//传递之前的对象

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrCreateUI frame = new AddOrCreateUI("崔致远","213191956",new ChetMainUI("崔致远","213191956"));
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
	public AddOrCreateUI(String t_name,String t_ID,ChetMainUI a) {
		setResizable(false);
		name=t_name;ID=t_ID;
		this.a=a;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("加好友/群/创建群聊");		
		setBounds(100, 100, 620, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_friend = new JPanel();
		panel_friend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabel_friend.setForeground(new Color(255, 255, 255));
				lblLabel_Srgroup.setForeground(Color.black);
				lblLabel_Crgroup.setForeground(Color.black);
				panel_friend.setBackground(new Color(135, 206, 250));
				panel_Srgroup.setBackground(new Color(255, 255, 255));
				panel_Crgroup.setBackground(new Color(255, 255, 255));
				
				panel_operation.setVisible(false);
				panel_operation = new AddFriendUI(name,ID," 请输入对方一卡通",0);
				panel_operation.setBounds(10, 45, 586, 408);
				getContentPane().add(panel_operation);
				repaint();			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_friend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		panel_friend.setBackground(new Color(135, 206, 250));
		panel_friend.setBounds(10, 0, 109, 35);
		contentPane.add(panel_friend);
		panel_friend.setLayout(null);
		
		lblLabel_friend = new JLabel("加好友");
		lblLabel_friend.setForeground(new Color(255, 255, 255));
		lblLabel_friend.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_friend.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_friend.setBounds(23, 10, 58, 15);
		panel_friend.add(lblLabel_friend);
		
		panel_Srgroup = new JPanel();
		panel_Srgroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabel_friend.setForeground(Color.black);
				lblLabel_Srgroup.setForeground(new Color(255, 255, 255));
				lblLabel_Crgroup.setForeground(Color.black);
				panel_friend.setBackground(new Color(255, 255, 255));
				panel_Srgroup.setBackground(new Color(135, 206, 250));
				panel_Crgroup.setBackground(new Color(255, 255, 255));
				
				panel_operation.setVisible(false);
				panel_operation = new AddFriendUI(name,ID," 请输入群号",1);
				panel_operation.setBounds(10, 45, 586, 408);
				getContentPane().add(panel_operation);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Srgroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});;
		panel_Srgroup.setBackground(new Color(255, 255, 255));
		panel_Srgroup.setBounds(120, 0, 109, 35);
		contentPane.add(panel_Srgroup);
		panel_Srgroup.setLayout(null);
		
		lblLabel_Srgroup = new JLabel("加群");
		lblLabel_Srgroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_Srgroup.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_Srgroup.setBounds(28, 10, 58, 15);
		panel_Srgroup.add(lblLabel_Srgroup);

		panel_Crgroup = new JPanel();
		panel_Crgroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabel_friend.setForeground(Color.black);
				lblLabel_Srgroup.setForeground(Color.black);
				lblLabel_Crgroup.setForeground(new Color(255, 255, 255));
				panel_friend.setBackground(new Color(255, 255, 255));
				panel_Srgroup.setBackground(new Color(255, 255, 255));
				panel_Crgroup.setBackground(new Color(135, 206, 250));
				
				panel_operation.setVisible(false);
				panel_operation = new CreateGroupUI(name,ID,a);
				panel_operation.setBounds(10, 45, 586, 408);
				getContentPane().add(panel_operation);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_Crgroup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		panel_Crgroup.setBackground(new Color(255, 255, 255));
		panel_Crgroup.setBounds(230, 0, 109, 35);
		contentPane.add(panel_Crgroup);
		panel_Crgroup.setLayout(null);
		
		lblLabel_Crgroup = new JLabel("创建群聊");
		lblLabel_Crgroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_Crgroup.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_Crgroup.setBounds(15, 10, 76, 15);
		panel_Crgroup.add(lblLabel_Crgroup);
		
		panel_operation = new AddFriendUI(name,ID," 请输入对方一卡通",0);
		panel_operation.setBounds(10, 45, 586, 408);
		contentPane.add(panel_operation);
		panel_operation.setLayout(null);
		
		/*lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(367, 20, 58, 15);
		contentPane.add(lblNewLabel);*/
	}

}
