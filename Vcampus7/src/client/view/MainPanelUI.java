package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import client.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.Icon;

public class MainPanelUI extends JPanel{
	
	int index=0;
	private paneDate panedate;
	ImageIcon[] imageicon = { new ImageIcon("picture//show1.jpg"), new ImageIcon("picture//show2.jpg"),
			new ImageIcon("picture//show3.jpg"), new ImageIcon("picture//show4.jpg"), new ImageIcon("picture//show5.jpg")};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanelUI frame = new MainPanelUI();
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
	public MainPanelUI() {
		setBackground(new Color(240,240,240));
		setBorder(null);
		setBounds(0,0,1405, 929);
		setLayout(null);
		
		JLabel lblShowLabel = new JLabel("");
		lblShowLabel.setBounds(170, 45, 1065, 400);
		add(lblShowLabel);
//		//图片轮播
//		panedate = new paneDate();
//		panedate.setBounds(170, 45, 1065, 400);
//		panedate.setBorder(new LineBorder(Color.blue));
//		add(panedate);
//		
//		JLabel lblNewLabel = new JLabel("NONE");
//		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
//		lblNewLabel.setBounds(153, 483, 494, 237);
//		add(lblNewLabel);
//		Timer timer = new Timer(1500, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				panedate.repaint();
//			}
//		});
//		timer.start();
		
		
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
