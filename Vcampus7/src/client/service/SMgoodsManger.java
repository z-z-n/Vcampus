package client.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class SMgoodsManger extends JPanel {

	/**
	 * Create the panel.
	 */
	public SMgoodsManger(String number) {
		setOpaque(true) ;
		setSize(1405,884);
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
		
		ImageIcon shangjia = new ImageIcon("picture\\xinzeng.png");
		
		JButton gong1 = new JButton(shangjia);
		gong1.setContentAreaFilled(false);
		 gong1.setBorderPainted(false);
		gong1.setBounds(300, 130, 200, 200);
		add(gong1);
		gong1.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				new SMshangjiaDlg().setVisible(true);
				

 			}
 		});
		
		
		ImageIcon xiajia = new ImageIcon("picture\\xiajia.png");
		JButton gong2 = new JButton(xiajia);
		gong2.setContentAreaFilled(false);
		gong2.setBorderPainted(false);
		gong2.setBounds(600, 130, 200, 200);
		add(gong2);
		gong2.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				new SMxiajiaDlg().setVisible(true);
				

 			}
 		});
		
		ImageIcon xiaoguotu = new ImageIcon("picture\\xiaoguotu.png");
		JButton gong3 = new JButton(xiaoguotu);
		gong3.setContentAreaFilled(false);
		gong3.setBorderPainted(false);
		gong3.setBounds(900, 130, 200, 200);
		add(gong3);
		gong3.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				new SMtupianDlg().setVisible(true);
				

 			}
 		});
		
		JLabel gong11 = new JLabel("上架商品");
		gong11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gong11.setHorizontalAlignment(SwingConstants.CENTER);
		gong11.setBounds(300, 340, 200, 40);
		add(gong11);
		
		
		JLabel gong22 = new JLabel("下架商品");
		gong22.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gong22.setHorizontalAlignment(SwingConstants.CENTER);
		gong22.setBounds(600, 340, 200, 40);
		add(gong22);
		
		JLabel gong33 = new JLabel("修改效果图");
		gong33.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gong33.setHorizontalAlignment(SwingConstants.CENTER);
		gong33.setBounds(900, 340, 200, 40);
		add(gong33);
		
		ImageIcon xinzeng = new ImageIcon("picture\\tianjia.png");
		JButton gong4 = new JButton(xinzeng);
		gong4.setContentAreaFilled(false);
		gong4.setBorderPainted(false);
		gong4.setBounds(300, 451, 200, 200);
		add(gong4);
		gong4.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				new SMzengDlg().setVisible(true);
				

 			}
 		});
		
		JLabel gong44 = new JLabel("增加数量");
		gong44.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gong44.setHorizontalAlignment(SwingConstants.CENTER);
		gong44.setBounds(300, 661, 200, 40);
		add(gong44);
		
		ImageIcon xiugai = new ImageIcon("picture\\xuigai.png");
		JButton gong5= new JButton(xiugai);
		gong5.setContentAreaFilled(false);
		gong5.setBorderPainted(false);
		gong5.setBounds(600, 451, 200, 200);
		add(gong5);
		gong5.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				new SMxuigaiDlg().setVisible(true);
				

 			}
 		});
		
		JLabel gong55 = new JLabel("修改价格");
		gong55.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		gong55.setHorizontalAlignment(SwingConstants.CENTER);
		gong55.setBounds(600, 661, 200, 40);
		add(gong55);
		
		ImageIcon daikaifa = new ImageIcon("picture\\daikaifa.png");
		JButton dai= new JButton(daikaifa);
		dai.setContentAreaFilled(false);
		dai.setBorderPainted(false);
		dai.setBounds(900, 451, 200, 200);
		add(dai);
		dai.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				
 				JOptionPane.showMessageDialog(null, "功能待开发");
				

 			}
 		});
		
		JLabel da= new JLabel("待开发...");
		da.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		da.setHorizontalAlignment(SwingConstants.CENTER);
		da.setBounds(900, 661, 200, 40);
		add(da);

	}

}
