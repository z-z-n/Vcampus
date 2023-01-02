package client.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import client.Sender;
import server.common.FileResponse;
import server.common.OnlyCardNum;
import server.communication.Message;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FunctionEduUI_St extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private JPanel panel_profile;
	private JLabel lbllabel_profile;
	private JLabel lblLabel_name;
	private JPanel panel_workSubmit;
	private JPanel panel_chooseCr;
	private JPanel panel_grade;
	private JPanel panel_UI;

	/**
	 * Create the panel.
	 */
	public FunctionEduUI_St(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1405, 929);
		setLayout(null);
		
		/*panel_UI = new JPanel();
		panel_UI.setBounds(0, 0, 1130, 929);
		add(panel_UI);
		panel_UI.setLayout(null);*/
		panel_UI = new ChooseCourseUI_St(name,ID);
		panel_UI.setBounds(0, 0, 1130, 929);
		add(panel_UI);
		panel_UI.setLayout(null);
		
		panel_profile = new JPanel();
		panel_profile.setBackground(new Color(255, 255, 255));
		panel_profile.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_profile.setBounds(1170, 40, 225, 230);
		add(panel_profile);
		panel_profile.setLayout(null);
		
        ImageIcon images = new ImageIcon("picture/man.png");
		lbllabel_profile = new JLabel(images);
		lbllabel_profile.setHorizontalAlignment(SwingConstants.CENTER);//控件居中
		lbllabel_profile.setBackground(new Color(192, 192, 192));
		lbllabel_profile.setBounds(36, 20, 161, 161);
		panel_profile.add(lbllabel_profile);
		
		lblLabel_name = new JLabel("学生："+name);
		lblLabel_name.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblLabel_name.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_name.setBounds(36, 191, 161, 29);
		panel_profile.add(lblLabel_name);
		
		panel_workSubmit = new JPanel();
		panel_workSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_workSubmit.setBorder(null);
				panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				panel_UI.setVisible(false);
				panel_UI = new HomeworkUI_St(name,ID);
				panel_UI.setBounds(0, 0, 1130, 929);
				add(panel_UI);
				repaint();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_workSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_workSubmit.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_workSubmit.setBackground(new Color(255, 255, 255));
			}
		});
		panel_workSubmit.setBackground(new Color(255, 255, 255));
		panel_workSubmit.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_workSubmit.setBounds(1170, 333, 225, 90);
		add(panel_workSubmit);
		panel_workSubmit.setLayout(null);
		

		ImageIcon Icon1 = new ImageIcon("picture/homework.jpg");
		JLabel lblLabel_p = new JLabel(Icon1);
		lblLabel_p.setBounds(38, 28, 30, 30);
		panel_workSubmit.add(lblLabel_p);
		
		JLabel lblLabel_work = new JLabel("作业提交");
		lblLabel_work.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_work.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_work.setBounds(38, 28, 142, 32);
		panel_workSubmit.add(lblLabel_work);
		
		JPanel panel_decorate = new JPanel();
		panel_decorate.setBackground(new Color(100, 149, 237));
		panel_decorate.setBounds(38, 70, 142, 3);
		panel_workSubmit.add(panel_decorate);
		

		
		panel_chooseCr = new JPanel();
		panel_chooseCr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_workSubmit.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_chooseCr.setBorder(null);
				
				panel_UI.setVisible(false);
				panel_UI = new ChooseCourseUI_St(name,ID);
				panel_UI.setBounds(0, 0, 1130, 929);
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
		panel_chooseCr.setBounds(1170, 451, 225, 90);
		add(panel_chooseCr);
		panel_chooseCr.setLayout(null);
		
		ImageIcon Icon2 = new ImageIcon("picture/choosec.jpg");
		JLabel lblLabel_c = new JLabel(Icon2);
		lblLabel_c.setBounds(38, 28, 30, 30);
		panel_chooseCr.add(lblLabel_c);
		
		JLabel lblLabel_choose = new JLabel("选课");
		lblLabel_choose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_choose.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_choose.setBounds(38, 28, 142, 32);
		panel_chooseCr.add(lblLabel_choose);
		
		JPanel panel_decorate_1 = new JPanel();
		panel_decorate_1.setBackground(new Color(100, 149, 237));
		panel_decorate_1.setBounds(38, 70, 142, 3);
		panel_chooseCr.add(panel_decorate_1);

		
		
		panel_grade = new JPanel();
		panel_grade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_workSubmit.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_grade.setBorder(null);
				panel_chooseCr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				
				panel_UI.setVisible(false);
				panel_UI = new GradeInquiryUI_St(name,ID);
				panel_UI.setBounds(0, 0, 1130, 929);
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
		panel_grade.setBounds(1170, 568, 225, 90);
		add(panel_grade);
		panel_grade.setLayout(null);
		
		ImageIcon Icon3 = new ImageIcon("picture/grade.jpg");
		JLabel lblLabel_g = new JLabel(Icon3);
		lblLabel_g.setBounds(38, 28, 30, 30);
		panel_grade.add(lblLabel_g);
		
		JLabel lblLabel_grade = new JLabel("成绩查询");
		lblLabel_grade.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_grade.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_grade.setBounds(38, 28, 142, 32);
		panel_grade.add(lblLabel_grade);
		
		JPanel panel_decorate_2 = new JPanel();
		panel_decorate_2.setBackground(new Color(100, 149, 237));
		panel_decorate_2.setBounds(38, 70, 142, 3);
		panel_grade.add(panel_decorate_2);
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(1170, 299, 10, 29);
		add(panel);
		
		JLabel lblLabel_CrSchedule = new JLabel("功能选择");
		lblLabel_CrSchedule.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_CrSchedule.setBounds(1190, 301, 89, 26);
		add(lblLabel_CrSchedule);
		
		
		//默认选择
		panel_workSubmit.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_grade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_chooseCr.setBorder(null);
		
		
		
		

	}

}
