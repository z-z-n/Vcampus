package client.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class FunctionEduUI_Tr extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private JPanel panel_work;
	private JPanel panel_chooseCr;
	private JPanel panel_grade;
	private JPanel panel_UI;
	private JPanel panel_decorate_1;
	private JPanel panel_decorate_2;
	private JPanel panel_decorate_3;
	private JLabel lblLabel_name;

	/**
	 * Create the panel.
	 */
	public FunctionEduUI_Tr(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1405, 929);
		setLayout(null);

		panel_UI = new ChooseCourseUI_Tr(name,ID);
		//panel_UI = new JPanel();
		panel_UI.setBounds(70, 90, 1290, 820);
		add(panel_UI);
		panel_UI.setLayout(null);
		
		panel_decorate_1 = new JPanel();
		panel_decorate_1.setBackground(new Color(255, 255, 255));
		panel_decorate_1.setBounds(114, 76, 142, 3);
		add(panel_decorate_1);
		panel_decorate_2 = new JPanel();
		panel_decorate_2.setBackground(new Color(255, 255, 255));
		panel_decorate_2.setBounds(336, 77, 142, 3);
		add(panel_decorate_2);
		panel_decorate_3 = new JPanel();
		panel_decorate_3.setBackground(new Color(255, 255, 255));
		panel_decorate_3.setBounds(566, 77, 142, 3);
		add(panel_decorate_3);
		
		lblLabel_name = new JLabel("教师："+name);
		lblLabel_name.setForeground(new Color(100, 149, 237));
		lblLabel_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_name.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_name.setBounds(763, 32, 161, 29);
		add(lblLabel_name);
		
				
		//******************************************************************************************************************
		panel_work = new JPanel();
		panel_work.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_work.setBorder(null);
				panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_decorate_1.setBackground(new Color(100, 149, 237));
				panel_decorate_2.setBackground(Color.white);
				panel_decorate_3.setBackground(Color.white);
				
				panel_UI.setVisible(false);
				panel_UI = new HomeworkUI_Tr(name,ID);
				panel_UI.setBounds(56, 91, 1307, 824);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_work.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_work.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_work.setBackground(new Color(255, 255, 255));
			}
		});
		panel_work.setBackground(new Color(255, 255, 255));
		panel_work.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_work.setBounds(70, 21, 225, 53);
		add(panel_work);
		panel_work.setLayout(null);
		
		JLabel lblLabel_work = new JLabel("作业批改");
		lblLabel_work.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_work.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_work.setBounds(37, 12, 142, 32);
		panel_work.add(lblLabel_work);
		
		//******************************************************************************************************************
		panel_chooseCr = new JPanel();
		panel_chooseCr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_work.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_chooseCr.setBorder(null);
				panel_decorate_1.setBackground(Color.white);
				panel_decorate_2.setBackground(Color.white);
				panel_decorate_3.setBackground(new Color(100, 149, 237));
				
				panel_UI.setVisible(false);
				panel_UI = new ChooseCourseUI_Tr(name,ID);
				panel_UI.setBounds(56, 91, 1307, 824);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_chooseCr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_chooseCr.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_chooseCr.setBackground(new Color(255, 255, 255));
			}
		});
		panel_chooseCr.setBackground(new Color(255, 255, 255));
		panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_chooseCr.setBounds(520, 21, 225, 53);
		add(panel_chooseCr);
		panel_chooseCr.setLayout(null);
		
		JLabel lblLabel_choose = new JLabel("选课");
		lblLabel_choose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_choose.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_choose.setBounds(37, 12, 142, 32);
		panel_chooseCr.add(lblLabel_choose);
		

		//******************************************************************************************************************		
		panel_grade = new JPanel();
		panel_grade.setBounds(295, 21, 225, 53);
		add(panel_grade);
		panel_grade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_work.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_grade.setBorder(null);
				panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_decorate_1.setBackground(Color.white);
				panel_decorate_2.setBackground(new Color(100, 149, 237));
				panel_decorate_3.setBackground(Color.white);
				
				panel_UI.setVisible(false);
				panel_UI = new GradeUploadUI_Tr(name,ID);
				panel_UI.setBounds(56, 91, 1307, 824);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_grade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_grade.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_grade.setBackground(new Color(255, 255, 255));
			}
		});
		panel_grade.setBackground(new Color(255, 255, 255));
		panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_grade.setLayout(null);
		
		
		JLabel lblLabel_grade = new JLabel("学生成绩");
		lblLabel_grade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_grade.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_grade.setBounds(39, 12, 142, 32);
		panel_grade.add(lblLabel_grade);

		//******************************************************************************************************************	
		//默认选择
		panel_chooseCr.setBorder(null);		
		panel_work.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_decorate_3.setBackground(new Color(100, 149, 237));
		
		ImageIcon Icon1 = new ImageIcon("picture/homework.jpg");
		JLabel lblLabel_p = new JLabel(Icon1);
		lblLabel_p.setBounds(33, 12, 30, 30);
		panel_work.add(lblLabel_p);
		ImageIcon Icon2 = new ImageIcon("picture/choosec.jpg");
		JLabel lblLabel_c = new JLabel(Icon2);
		lblLabel_c.setBounds(37, 12, 30, 30);
		panel_chooseCr.add(lblLabel_c);
		ImageIcon Icon3 = new ImageIcon("picture/grade.jpg");
		JLabel lblLabel_g = new JLabel(Icon3);
		lblLabel_g.setBounds(39, 12, 30, 30);
		panel_grade.add(lblLabel_g);

	}

}
