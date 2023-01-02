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
import javax.swing.Icon;

public class FunctionEduUI_Mg extends JPanel {
	private JPanel panel_UI;
	private JPanel panel_decorate_1;
	private JPanel panel_grade;
	private JLabel lblLabel_grade;
	private JPanel panel_chooseCr;
	private JLabel lblLabel_choose;
	private JPanel panel_decorate_2;
	private JLabel lblLabel_name;
	private JLabel lblLabel_image;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public FunctionEduUI_Mg() {
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1405, 929);
		setLayout(null);

		panel_UI = new CourseScheduleUI_Mg();
		panel_UI.setBounds(156, 0, 1249, 929);
		add(panel_UI);
		panel_UI.setLayout(null);		
		
		
		//******************************************************************************************************************

		panel_grade = new JPanel();
		panel_grade.setForeground(new Color(255, 255, 255));
		panel_grade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_grade.setBorder(null);
				panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_decorate_1.setBackground(Color.white);
				panel_decorate_2.setBackground(new Color(100, 149, 237));
				
				panel_UI.setVisible(false);
				panel_UI = new GradeManagerUI_Mg();
				panel_UI.setBounds(156, 0, 1249, 929);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_grade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				//panel_grade.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//panel_grade.setBackground(new Color(255, 255, 255));
			}
		});
		panel_grade.setLayout(null);
		panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_grade.setBackground(new Color(100, 149, 237));
		panel_grade.setBounds(10, 204, 136, 53);
		add(panel_grade);
		
		lblLabel_grade = new JLabel("学生成绩");
		lblLabel_grade.setForeground(new Color(255, 255, 255));
		lblLabel_grade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_grade.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_grade.setBounds(27, 12, 80, 32);
		panel_grade.add(lblLabel_grade);

		panel_decorate_1 = new JPanel();
		panel_decorate_1.setBounds(10, 10, 16, 34);
		panel_grade.add(panel_decorate_1);
		panel_decorate_1.setBackground(Color.WHITE);
		
		//******************************************************************************************************************	
		panel_chooseCr = new JPanel();
		panel_chooseCr.setForeground(new Color(255, 255, 255));
		panel_chooseCr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_chooseCr.setBorder(null);
				panel_decorate_1.setBackground(new Color(100, 149, 237));
				panel_decorate_2.setBackground(Color.white);
				
				panel_UI.setVisible(false);
				panel_UI = new CourseScheduleUI_Mg();
				panel_UI.setBounds(156, 0, 1249, 929);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_chooseCr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				//panel_chooseCr.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//panel_chooseCr.setBackground(new Color(255, 255, 255));
			}
		});
		panel_chooseCr.setLayout(null);
		panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_chooseCr.setBackground(new Color(100, 149, 237));
		panel_chooseCr.setBounds(10, 273, 136, 53);
		add(panel_chooseCr);

		lblLabel_choose = new JLabel("教务排课");
		lblLabel_choose.setForeground(new Color(255, 255, 255));
		lblLabel_choose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_choose.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_choose.setBounds(27, 10, 80, 32);
		panel_chooseCr.add(lblLabel_choose);
		
		panel_decorate_2 = new JPanel();
		panel_decorate_2.setBounds(10, 10, 16, 34);
		panel_chooseCr.add(panel_decorate_2);
		panel_decorate_2.setBackground(Color.WHITE);
		
		//******************************************************************************************************************	
		//默认选择排课
		panel_chooseCr.setBorder(null);		
		panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_decorate_1.setBackground(new Color(100, 149, 237));		
		
		ImageIcon Icon1 = new ImageIcon("picture/EdMg.jpg");
		
		panel = new JPanel();
		panel.setBackground(new Color(53,87,187));
		panel.setBounds(10, 10, 136, 182);
		add(panel);
		panel.setLayout(null);
		
		lblLabel_name = new JLabel("操作");
		lblLabel_name.setBounds(0, 143, 136, 29);
		panel.add(lblLabel_name);
		lblLabel_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_name.setForeground(new Color(255, 255, 255));
		lblLabel_name.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_image = new JLabel(Icon1);
		lblLabel_image.setBounds(0, 0, 136, 136);
		panel.add(lblLabel_image);

	}

}
