package client.service;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LibChangeDlg extends JDialog {

	 final JPanel contentPanel = new JPanel();
	 JTextField name1;
	 JTextField numbe1r;
	 JTextField chubanshe1;
	 JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LibChangeDlg dialog = new LibChangeDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LibChangeDlg() {
		setBounds(100, 100, 450, 450);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton queding = new JButton("修改");
			queding.setBounds(100, 350, 93, 30);
			queding.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.setLayout(null);
			contentPanel.add(queding);
		}
		
		JButton quxiao = new JButton("取消");
		quxiao.setBounds(221, 350, 93, 30);
		contentPanel.add(quxiao);
		
		JLabel name = new JLabel("书名：");
		name.setBounds(90, 101, 75, 25);
		contentPanel.add(name);
		
		name1 = new JTextField();
		name1.setBounds(170, 101, 150, 25);
		contentPanel.add(name1);
		name1.setColumns(10);
		
		JLabel number = new JLabel("书号：");
		number.setBounds(90, 147, 75, 25);
		contentPanel.add(number);
		
		numbe1r = new JTextField();
		numbe1r.setColumns(10);
		numbe1r.setBounds(170, 147, 150, 25);
		contentPanel.add(numbe1r);
		
		JLabel chubanshe = new JLabel("出版社：");
		chubanshe.setBounds(90, 198, 75, 25);
		contentPanel.add(chubanshe);
		
		chubanshe1 = new JTextField();
		chubanshe1.setColumns(10);
		chubanshe1.setBounds(170, 198, 150, 25);
		contentPanel.add(chubanshe1);
		
		JLabel enter1 = new JLabel("这个空添1：");
		enter1.setBounds(90, 252, 75, 25);
		contentPanel.add(enter1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(170, 252, 150, 25);
		contentPanel.add(textField_3);
	}
}
