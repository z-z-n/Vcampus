package client.view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Chatbackground extends JPanel {

	/**
	 * Create the panel.
	 */
	public Chatbackground() {
		setBounds(0, 0, 1104,929);
		setLayout(null);
		
		ImageIcon Icon_images = new ImageIcon("picture/chat.jpg");
		JLabel lblNewLabel = new JLabel(Icon_images);
		lblNewLabel.setBounds(0, 0, 1104, 929);
		add(lblNewLabel);

	}

}
