package client.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibheaderIconPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LibheaderIconPanel() {
		setSize(175,175);
		setLayout(null);
		setBackground(null);
		
		ImageIcon image01=new ImageIcon("picture\\seuxiaohui.png");
		JLabel lblIconHeader = new JLabel(image01);
		lblIconHeader.setBounds(0, 0, 175, 175);
		add(lblIconHeader);
		
		

	}
}
