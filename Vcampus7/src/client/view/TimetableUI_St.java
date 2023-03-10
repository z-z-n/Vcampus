package client.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.LineBorder;

import client.ClassInfor;
import client.Sender;
import server.common.CourseScheduling;
import server.common.StuCourse;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TimetableUI_St extends JFrame {

	private String name="崔致远";
	private String ID="213191956";
	public JTextArea textField_1_12;
	public JTextArea textField_2_12;
	public JTextArea textField_3_12;
	public JTextArea textField_4_12;
	public JTextArea textField_5_12;
	public JTextArea textField_1_34;
	public JTextArea textField_2_34;
	public JTextArea textField_3_34;
	public JTextArea textField_4_34;
	public JTextArea textField_5_34;
	public JTextArea textField_1_56;
	public JTextArea textField_1_78;
	public JTextArea textField_2_56;
	public JTextArea textField_2_78;
	public JTextArea textField_3_56;
	public JTextArea textField_3_78;
	public JTextArea textField_4_56;
	public JTextArea textField_4_78;
	public JTextArea textField_5_56;
	public JTextArea textField_5_78;
	private JTextField textField_grap;
	private JTextField textField_header;
	private JTextField textField_header1;
	private JTextField textField_header2;
	private JTextField textField_header3;
	private JTextField textField_header4;
	private JTextField textField_header5;
	private JPanel panel;
	private JLabel lblLabel_CrSchedule;
	private JTextField textField_8;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;

	private String CrID="";
	private String TrID="";
	private String CrName="";
	private String classroom="";
	private int daytime=0;
	private int crtime=0;
	private int crtype=0;
	private int crCapacity=0;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JScrollPane scrollPane_7;
	private JScrollPane scrollPane_8;
	private JScrollPane scrollPane_9;
	private JScrollPane scrollPane_10;
	private JScrollPane scrollPane_11;
	private JScrollPane scrollPane_12;
	private JScrollPane scrollPane_13;
	private JScrollPane scrollPane_14;
	private JScrollPane scrollPane_15;
	private JScrollPane scrollPane_16;
	private JScrollPane scrollPane_17;
	private JScrollPane scrollPane_18;
	private JScrollPane scrollPane_19;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableUI_St frame = new TimetableUI_St("崔致远","213191956");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * 时间转化成对应JTextArea
	 */
	public JTextArea TimeToTextArea(int day,int cr) {
		if(day==0) {
			if(cr==0) {
				return textField_1_12;
			}
			else if(cr==1) {
				return textField_1_34;
			}
			else if(cr==2) {
				return textField_1_56;
			}
			else if(cr==3) {
				return textField_1_78;
			}
		}
		else if(day==1) {
			if(cr==0) {
				return textField_2_12;
			}
			else if(cr==1) {
				return textField_2_34;
			}
			else if(cr==2) {
				return textField_2_56;
			}
			else if(cr==3) {
				return textField_2_78;
			}
		}
		else if(day==2) {
			if(cr==0) {
				return textField_3_12;
			}
			else if(cr==1) {
				return textField_3_34;
			}
			else if(cr==2) {
				return textField_3_56;
			}
			else if(cr==3) {
				return textField_3_78;
			}
		}
		else if(day==3) {
			if(cr==0) {
				return textField_4_12;
			}
			else if(cr==1) {
				return textField_4_34;
			}
			else if(cr==2) {
				return textField_4_56;
			}
			else if(cr==3) {
				return textField_4_78;
			}
		}
		else if(day==4) {
			if(cr==0) {
				return textField_5_12;
			}
			else if(cr==1) {
				return textField_5_34;
			}
			else if(cr==2) {
				return textField_5_56;
			}
			else if(cr==3) {
				return textField_5_78;
			}
		}
		return textField_1_12;
	}

	/**
	 * Create the frame.
	 */
	public TimetableUI_St(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(Color.WHITE);
		setSize(1249, 718);
		getContentPane().setLayout(null);
		
		

		JPanel panel_course = new JPanel();
		panel_course.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_course.setBackground(Color.WHITE);
		panel_course.setBounds(5, 7, 1222, 660);
		getContentPane().add(panel_course);
		panel_course.setLayout(null);
		
		/*ImageIcon images = new ImageIcon("picture/course.png");
		JLabel lblLabel_background = new JLabel(images);
		lblLabel_background.setBounds(120, 69, 1080, 540);
		panel_course.add(lblLabel_background);*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 100, 209, 116);
		panel_course.add(scrollPane);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textField_1_12 = new JTextArea("");
		scrollPane.setViewportView(textField_1_12);
		textField_1_12.setEditable(false);
		textField_1_12.setBackground(new Color(255, 255, 255));
		textField_1_12.setColumns(10);
		textField_1_12.setWrapStyleWord(true);
		textField_1_12.setLineWrap(true);
		textField_1_12.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(338, 100, 209, 116);
		panel_course.add(scrollPane_3);
		
		textField_2_12 = new JTextArea("");
		scrollPane_3.setViewportView(textField_2_12);
		textField_2_12.setEditable(false);
		textField_2_12.setColumns(10);
		textField_2_12.setBackground(new Color(255, 255, 255));
		textField_2_12.setWrapStyleWord(true);
		textField_2_12.setLineWrap(true);
		textField_2_12.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(547, 100, 209, 116);
		panel_course.add(scrollPane_8);
		
		textField_3_12 = new JTextArea("");
		scrollPane_8.setViewportView(textField_3_12);
		textField_3_12.setEditable(false);
		textField_3_12.setColumns(10);
		textField_3_12.setBackground(new Color(255, 255, 255));
		textField_3_12.setWrapStyleWord(true);
		textField_3_12.setLineWrap(true);
		textField_3_12.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(756, 100, 209, 116);
		panel_course.add(scrollPane_12);
		
		
		textField_4_12 = new JTextArea("");
		scrollPane_12.setViewportView(textField_4_12);
		textField_4_12.setEditable(false);
		textField_4_12.setColumns(10);
		textField_4_12.setBackground(new Color(255, 255, 255));
		textField_4_12.setWrapStyleWord(true);
		textField_4_12.setLineWrap(true);
		textField_4_12.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_16 = new JScrollPane();
		scrollPane_16.setBounds(965, 100, 209, 116);
		panel_course.add(scrollPane_16);
		
		
		textField_5_12 = new JTextArea("");
		scrollPane_16.setViewportView(textField_5_12);
		textField_5_12.setEditable(false);
		textField_5_12.setColumns(10);
		textField_5_12.setBackground(new Color(255, 255, 255));
		textField_5_12.setWrapStyleWord(true);
		textField_5_12.setLineWrap(true);
		textField_5_12.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(129, 216, 209, 116);
		panel_course.add(scrollPane_1);
		
		
		textField_1_34 = new JTextArea("");
		scrollPane_1.setViewportView(textField_1_34);
		textField_1_34.setEditable(false);
		textField_1_34.setColumns(10);
		textField_1_34.setBackground(new Color(248, 248, 255));
		textField_1_34.setWrapStyleWord(true);
		textField_1_34.setLineWrap(true);
		textField_1_34.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(338, 216, 209, 116);
		panel_course.add(scrollPane_5);
		
		
		textField_2_34 = new JTextArea("");
		scrollPane_5.setViewportView(textField_2_34);
		textField_2_34.setEditable(false);
		textField_2_34.setColumns(10);
		textField_2_34.setBackground(new Color(248, 248, 255));
		textField_2_34.setWrapStyleWord(true);
		textField_2_34.setLineWrap(true);
		textField_2_34.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(547, 216, 209, 116);
		panel_course.add(scrollPane_9);
		
		textField_3_34 = new JTextArea("");
		scrollPane_9.setViewportView(textField_3_34);
		textField_3_34.setEditable(false);
		textField_3_34.setColumns(10);
		textField_3_34.setBackground(new Color(248, 248, 255));
		textField_3_34.setWrapStyleWord(true);
		textField_3_34.setLineWrap(true);
		textField_3_34.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_13 = new JScrollPane();
		scrollPane_13.setBounds(756, 216, 209, 116);
		panel_course.add(scrollPane_13);
		
		textField_4_34 = new JTextArea("");
		scrollPane_13.setViewportView(textField_4_34);
		textField_4_34.setEditable(false);
		textField_4_34.setColumns(10);
		textField_4_34.setBackground(new Color(248, 248, 255));
		textField_4_34.setWrapStyleWord(true);
		textField_4_34.setLineWrap(true);
		textField_4_34.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_17 = new JScrollPane();
		scrollPane_17.setBounds(965, 216, 209, 116);
		panel_course.add(scrollPane_17);
		
		textField_5_34 = new JTextArea("");
		scrollPane_17.setViewportView(textField_5_34);
		textField_5_34.setEditable(false);
		textField_5_34.setColumns(10);
		textField_5_34.setBackground(new Color(248, 248, 255));
		textField_5_34.setWrapStyleWord(true);
		textField_5_34.setLineWrap(true);
		textField_5_34.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(129, 400, 209, 116);
		panel_course.add(scrollPane_2);
		
		textField_1_56 = new JTextArea("");
		scrollPane_2.setViewportView(textField_1_56);
		textField_1_56.setEditable(false);
		textField_1_56.setColumns(10);
		textField_1_56.setBackground(new Color(255, 255, 255));
		
		textField_1_56.setWrapStyleWord(true);
		textField_1_56.setLineWrap(true);
		textField_1_56.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 	
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(129, 516, 209, 116);
		panel_course.add(scrollPane_4);
		
		textField_1_78 = new JTextArea("");
		scrollPane_4.setViewportView(textField_1_78);
		textField_1_78.setEditable(false);
		textField_1_78.setColumns(10);
		textField_1_78.setBackground(new Color(248, 248, 255));
		textField_1_78.setWrapStyleWord(true);
		textField_1_78.setLineWrap(true);
		textField_1_78.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(338, 400, 209, 116);
		panel_course.add(scrollPane_6);
		
		textField_2_56 = new JTextArea("");
		scrollPane_6.setViewportView(textField_2_56);
		textField_2_56.setEditable(false);
		textField_2_56.setColumns(10);
		textField_2_56.setBackground(new Color(255, 255, 255));
		
		textField_2_56.setWrapStyleWord(true);
		textField_2_56.setLineWrap(true);
		textField_2_56.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 	
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(338, 516, 209, 116);
		panel_course.add(scrollPane_7);
		
		textField_2_78 = new JTextArea("");
		scrollPane_7.setViewportView(textField_2_78);
		textField_2_78.setEditable(false);
		textField_2_78.setColumns(10);
		textField_2_78.setBackground(new Color(248, 248, 255));
		textField_2_78.setWrapStyleWord(true);
		textField_2_78.setLineWrap(true);
		textField_2_78.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(547, 400, 209, 116);
		panel_course.add(scrollPane_10);
		
		textField_3_56 = new JTextArea("");
		scrollPane_10.setViewportView(textField_3_56);
		textField_3_56.setEditable(false);
		textField_3_56.setColumns(10);
		textField_3_56.setBackground(new Color(255, 255, 255));
		
		textField_3_56.setWrapStyleWord(true);
		textField_3_56.setLineWrap(true);
		textField_3_56.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 	
		
		scrollPane_11 = new JScrollPane();
		scrollPane_11.setBounds(547, 516, 209, 116);
		panel_course.add(scrollPane_11);
		
		textField_3_78 = new JTextArea("");
		scrollPane_11.setViewportView(textField_3_78);
		textField_3_78.setEditable(false);
		textField_3_78.setColumns(10);
		textField_3_78.setBackground(new Color(248, 248, 255));
		textField_3_78.setWrapStyleWord(true);
		textField_3_78.setLineWrap(true);
		textField_3_78.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		scrollPane_14 = new JScrollPane();
		scrollPane_14.setBounds(756, 400, 209, 116);
		panel_course.add(scrollPane_14);
		
		textField_4_56 = new JTextArea("");
		scrollPane_14.setViewportView(textField_4_56);
		textField_4_56.setEditable(false);
		textField_4_56.setColumns(10);
		textField_4_56.setBackground(new Color(255, 255, 255));
		
		textField_4_56.setWrapStyleWord(true);
		textField_4_56.setLineWrap(true);
		textField_4_56.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 	
		
		scrollPane_15 = new JScrollPane();
		scrollPane_15.setBounds(756, 516, 209, 116);
		panel_course.add(scrollPane_15);
		
		textField_4_78 = new JTextArea("");
		scrollPane_15.setViewportView(textField_4_78);
		textField_4_78.setEditable(false);
		textField_4_78.setColumns(10);
		textField_4_78.setBackground(new Color(248, 248, 255));
		textField_4_78.setWrapStyleWord(true);
		textField_4_78.setLineWrap(true);
		textField_4_78.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		scrollPane_18 = new JScrollPane();
		scrollPane_18.setBounds(965, 400, 209, 116);
		panel_course.add(scrollPane_18);
		
		textField_5_56 = new JTextArea("");
		scrollPane_18.setViewportView(textField_5_56);
		textField_5_56.setEditable(false);
		textField_5_56.setColumns(10);
		textField_5_56.setBackground(new Color(255, 255, 255));
		
		textField_5_56.setWrapStyleWord(true);
		textField_5_56.setLineWrap(true);
		textField_5_56.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 	
		
		scrollPane_19 = new JScrollPane();
		scrollPane_19.setBounds(965, 516, 209, 116);
		panel_course.add(scrollPane_19);
		
		textField_5_78 = new JTextArea("");
		scrollPane_19.setViewportView(textField_5_78);
		textField_5_78.setEditable(false);
		textField_5_78.setColumns(10);
		textField_5_78.setBackground(new Color(248, 248, 255));
		textField_5_78.setWrapStyleWord(true);
		textField_5_78.setLineWrap(true);
		textField_5_78.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		textField_grap = new JTextField();
		textField_grap.setEditable(false);
		textField_grap.setBackground(new Color(255, 255, 255));
		textField_grap.setBounds(23, 332, 1151, 68);
		panel_course.add(textField_grap);
		textField_grap.setColumns(10);
		
		textField_header = new JTextField();
		textField_header.setEditable(false);
		textField_header.setBackground(new Color(135, 206, 250));
		textField_header.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header.setText("节次 \\ 星期");
		textField_header.setBounds(23, 55, 106, 45);
		panel_course.add(textField_header);
		textField_header.setColumns(10);
		
		textField_header1 = new JTextField();
		textField_header1.setEditable(false);
		textField_header1.setText("星期一");
		textField_header1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header1.setBackground(new Color(135, 206, 250));
		textField_header1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header1.setColumns(10);
		textField_header1.setBounds(129, 55, 209, 45);
		panel_course.add(textField_header1);
		
		textField_header2 = new JTextField();
		textField_header2.setEditable(false);
		textField_header2.setText("星期二");
		textField_header2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header2.setBackground(new Color(135, 206, 250));
		textField_header2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header2.setColumns(10);
		textField_header2.setBounds(338, 55, 209, 45);
		panel_course.add(textField_header2);
		
		textField_header3 = new JTextField();
		textField_header3.setEditable(false);
		textField_header3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header3.setText("星期三");
		textField_header3.setBackground(new Color(135, 206, 250));
		textField_header3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header3.setColumns(10);
		textField_header3.setBounds(547, 55, 209, 45);
		panel_course.add(textField_header3);
		
		textField_header4 = new JTextField();
		textField_header4.setEditable(false);
		textField_header4.setText("星期四");
		textField_header4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header4.setBackground(new Color(135, 206, 250));
		textField_header4.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header4.setColumns(10);
		textField_header4.setBounds(756, 55, 209, 45);
		panel_course.add(textField_header4);
		
		textField_header5 = new JTextField();
		textField_header5.setEditable(false);
		textField_header5.setText("星期五");
		textField_header5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_header5.setBackground(new Color(135, 206, 250));
		textField_header5.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_header5.setColumns(10);
		textField_header5.setBounds(965, 55, 209, 45);
		panel_course.add(textField_header5);
		
		panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(23, 16, 10, 29);
		panel_course.add(panel);
		
		lblLabel_CrSchedule = new JLabel("课表");
		lblLabel_CrSchedule.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_CrSchedule.setBounds(43, 18, 89, 26);
		panel_course.add(lblLabel_CrSchedule);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("第一节");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_1.setBounds(23, 100, 106, 58);
		panel_course.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("第二节");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(23, 158, 106, 58);
		panel_course.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText("第三节");
		textField_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(23, 216, 106, 58);
		panel_course.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("第四节");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(23, 274, 106, 58);
		panel_course.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText("第五节");
		textField_5.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(23, 400, 106, 58);
		panel_course.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("第六节");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(23, 458, 106, 58);
		panel_course.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("第七节");
		textField_7.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(23, 516, 106, 58);
		panel_course.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setText("第八节");
		textField_8.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(23, 574, 106, 58);
		panel_course.add(textField_8);
		
		/*
		 * 传递已有课程
		 */
		StuCourse obj2=new StuCourse(ID);
		Message msg2=new Message("printSchedules",obj2);
		Object temp2 = Sender.send(msg2);
		Message res2 = (Message)temp2;
		int cnt=res2.num;
		Vector<ClassInfor> vec=new Vector(cnt);//课程id+时间
		
		while(res2.status.equals("100"));
		if(res2.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((StuCourse)res2.response[0]).teacherCard, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				StuCourse tem=(StuCourse)res2.response[i];
				vec.add(new ClassInfor(tem.courseId,tem.courseTime));
				
				//获得课程名
				StuCourse obj6=new StuCourse(tem.courseId);
				Message msg6=new Message("getCourseName",obj6);
				Object temp6 = Sender.send(msg6);
				Message res6 = (Message)temp6;
				String t_coursename="";				
				while(res6.status.equals("100"));
				if(res6.status.equals("404")) {
					JOptionPane.showMessageDialog(null, ((UniversalClass)res6.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					t_coursename=((UniversalClass)res6.response[0]).context;
				}
				
				//获得教师姓名
				StuCourse obj5=new StuCourse(tem.teacherCard);
				Message msg5=new Message("getTeacherName",obj5);
				Object temp5 = Sender.send(msg5);
				Message res5 = (Message)temp5;
				String t_trname="";				
				while(res5.status.equals("100"));
				if(res5.status.equals("404")) {
					JOptionPane.showMessageDialog(null, ((UniversalClass)res5.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					t_trname=((UniversalClass)res5.response[0]).context;
				}
				
				String message=tem.courseId+" "+t_trname+" "+t_coursename+"\n";				
				int len=tem.courseTime.length();//时间
				for(int j=0;j<len;j++) {
					char t1=tem.courseTime.charAt(j);
					int value=Integer.valueOf(t1)-97;
					int day=value/4;
					int course=value%4;
					if(TimeToTextArea(day,course).getText().equals("")) {
						TimeToTextArea(day,course).setText(message);
						TimeToTextArea(day,course).paintImmediately(TimeToTextArea(day,course).getBounds());
					}
					else {
						TimeToTextArea(day,course).append(message);
						TimeToTextArea(day,course).paintImmediately(TimeToTextArea(day,course).getBounds());
					}
				}
			}
		}

	}
}
