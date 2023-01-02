package client.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import client.ClassInfor;
import client.Sender;
import server.common.CourseScheduling;
import server.common.GradeClass;
import server.common.UniversalClass;
import server.communication.Message;
import javax.swing.JScrollPane;
import java.util.Vector;

public class CourseScheduleUI_Mg extends JPanel {
	private JTextArea textField_1_12;
	private JTextArea textField_2_12;
	private JTextArea textField_3_12;
	private JTextArea textField_4_12;
	private JTextArea textField_5_12;
	private JTextArea textField_1_34;
	private JTextArea textField_2_34;
	private JTextArea textField_3_34;
	private JTextArea textField_4_34;
	private JTextArea textField_5_34;
	private JTextArea textField_1_56;
	private JTextArea textField_1_78;
	private JTextArea textField_2_56;
	private JTextArea textField_2_78;
	private JTextArea textField_3_56;
	private JTextArea textField_3_78;
	private JTextArea textField_4_56;
	private JTextArea textField_4_78;
	private JTextArea textField_5_56;
	private JTextArea textField_5_78;
	private JTextField textField_grap;
	private JTextField textField_header;
	private JTextField textField_header1;
	private JTextField textField_header2;
	private JTextField textField_header3;
	private JTextField textField_header4;
	private JTextField textField_header5;
	private JPanel panel;
	private JLabel lblLabel_CrSchedule;
	private JPanel panel_1;
	private JLabel lblLabel_CrMess;
	private JTextField textField_CrID;
	private JTextField textField_CrIDEdit;
	private JTextField textField_TrID;
	private JTextField textField_TrIDEdit;
	private JTextField textField_Crtime;
	private JTextField textField_8;
	private JTextField textField_classroom;
	private JTextField textField_classroomEdit;
	private JTextField textField_CrName;
	private JTextField textField_CrNameEdit;
	private JTextField textField_CrType;
	private JComboBox comboBox;
	private JTextField textField_Trwilling;
	private JTextArea textArea;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JButton Button_application;
	private JTextField textField_capacity;
	private JTextField textField_capacityEdit;

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
	private JScrollPane scrollPane_20;

	/*
	 * 时间转化成对应string
	 */
	public String TimeToString(int day,int cr) {
		int b=97+day*4+cr;
		char a=(char)b;
		return String.valueOf(a);
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
	public String Change(char t) {
		int value=Integer.valueOf(t)-96;
		int day=value/4+1;
		int course1=value%4;
		int course2=(course1*2-1)*10+course1*2;
		String time="周"+Integer.toString(day)+"-"+Integer.toString(course2)+"节";
		return time;
	}
	public String StringToTime(String t) {
		int length=t.length();
		String time="";
		for(int i=0;i<length;i++) {
			char t1=t.charAt(i);
			if(i==0) {
				time=Change(t1);
			}
			else {
				time=time+"、"+Change(t1);
			}			
		}
		return time;
	}
	
	/**
	 * Create the panel.
	 */
	public CourseScheduleUI_Mg() {
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(1249, 929);
		setLayout(null);
		
		
		
		JPanel panel_Mess = new JPanel();
		panel_Mess.setBackground(new Color(255, 255, 255));
		panel_Mess.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Mess.setBounds(10, 10, 1217, 245);
		add(panel_Mess);
		panel_Mess.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(20, 10, 10, 29);
		panel_Mess.add(panel_1);
		
		lblLabel_CrMess = new JLabel("课程信息");
		lblLabel_CrMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_CrMess.setBounds(40, 12, 89, 26);
		panel_Mess.add(lblLabel_CrMess);
		
		textField_CrID = new JTextField();
		textField_CrID.setText(" 课程号");
		textField_CrID.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_CrID.setEditable(false);
		textField_CrID.setColumns(10);
		textField_CrID.setBackground(new Color(248, 248, 255));
		textField_CrID.setBounds(20, 49, 109, 46);
		panel_Mess.add(textField_CrID);
		
		textField_CrIDEdit = new JTextField("");
		textField_CrIDEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_CrIDEdit.setColumns(10);
		textField_CrIDEdit.setBackground(Color.WHITE);
		textField_CrIDEdit.setBounds(129, 49, 170, 46);
		panel_Mess.add(textField_CrIDEdit);
		
		textField_TrID = new JTextField();
		textField_TrID.setText(" 教师一卡通");
		textField_TrID.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_TrID.setEditable(false);
		textField_TrID.setColumns(10);
		textField_TrID.setBackground(new Color(248, 248, 255));
		textField_TrID.setBounds(299, 49, 109, 46);
		panel_Mess.add(textField_TrID);
		
		textField_TrIDEdit = new JTextField("");
		textField_TrIDEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_TrIDEdit.setColumns(10);
		textField_TrIDEdit.setBackground(Color.WHITE);
		textField_TrIDEdit.setBounds(408, 49, 170, 46);
		panel_Mess.add(textField_TrIDEdit);
		
		textField_Crtime = new JTextField();
		textField_Crtime.setText(" 课程时间");
		textField_Crtime.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_Crtime.setEditable(false);
		textField_Crtime.setColumns(10);
		textField_Crtime.setBackground(new Color(248, 248, 255));
		textField_Crtime.setBounds(20, 141, 109, 46);
		panel_Mess.add(textField_Crtime);
		
		JComboBox comboBox_day = new JComboBox();
		comboBox_day.setForeground(new Color(0, 0, 0));
		comboBox_day.setModel(new DefaultComboBoxModel(new String[] {"星期一", "星期二", "星期三", "星期四", "星期五"}));
		comboBox_day.setSelectedIndex(0);
		comboBox_day.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		comboBox_day.setBackground(new Color(248, 248, 255));
		comboBox_day.setBounds(129, 141, 75, 46);
		panel_Mess.add(comboBox_day);
		
		JComboBox comboBox_course = new JComboBox();
		comboBox_course.setForeground(new Color(0, 0, 0));
		comboBox_course.setBackground(new Color(248, 248, 255));
		comboBox_course.setModel(new DefaultComboBoxModel(new String[] {"第一二节", "第三四节", "第五六节", "第七八节"}));
		comboBox_course.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		comboBox_course.setBounds(204, 141, 95, 46);
		panel_Mess.add(comboBox_course);
		
		Vector<ClassInfor> vec=new Vector();
		JButton Button_add = new JButton("添加");
		Button_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CrID=textField_CrIDEdit.getText();
				TrID=textField_TrIDEdit.getText();
				classroom=textField_classroomEdit.getText();
				CrName=textField_CrNameEdit.getText();
				daytime=comboBox_day.getSelectedIndex();
				crtime=comboBox_course.getSelectedIndex();
				crtype=comboBox.getSelectedIndex()+1;
				if(!CrID.equals("")&&!TrID.equals("")&&!classroom.equals("")&&!CrName.equals("")&&!textField_capacityEdit.getText().equals("")) {//不空
					String time=TimeToString(daytime,crtime);
					String proposal=textArea.getText();
					crCapacity=Integer.valueOf(textField_capacityEdit.getText());
					int size=vec.size();
					int flag=0;int r=0;
					String ID_cr="";String time_cr="";
					for(int i=0;i<size;i++) {//判断是否存在相同课程
						String v_ID=vec.get(i).CrID;
						if(CrID.equals(v_ID)) {
							flag=1;r=i;
							ID_cr=v_ID;
							time_cr=vec.get(i).time;
						}
					}
					//判断是否存在相同课程
					if(flag==1) {//存在相同课程
						
						//判断是否存在相同时间
						if(time_cr.indexOf(time)!=-1){//如果已存在
							JOptionPane.showMessageDialog(null, "课程存在相同时间段！", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//不存在相同时间
							time_cr=time_cr+time;//更新时间							
							/*
							 * 传输数据
							 */
							//课程Id、教师一卡通、课程名、上课时间、教室、课容量，预期上课时间、课程类型
							CourseScheduling obj1=new CourseScheduling(CrID,TrID,CrName,time_cr,classroom,crCapacity,proposal,crtype);
							Message msg1=new Message("courseScheduling",obj1);
							Object temp1 = Sender.send(msg1);
							Message res1 = (Message)temp1;
							while(res1.status.equals("100"));
							if(res1.status.equals("404")) {
								JOptionPane.showMessageDialog(null, "上传失败:"+((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								vec.set(r, new ClassInfor(ID_cr,time_cr));//更新vector
								String t_context=CrID+" "+TrID+" "+CrName+" "+classroom+" "+crCapacity+"\n";
								TimeToTextArea(daytime,crtime).append(t_context);//紧跟在此后面加上下面语句即可
								TimeToTextArea(daytime,crtime).paintImmediately(TimeToTextArea(daytime,crtime).getBounds());
								JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}	
							/*String t_context="*"+CrID+" | "+TrID+" | "+CrName+" | "+classroom+" | "+crCapacity+"\n";
							TimeToTextArea(daytime,crtime).append(t_context);//紧跟在此后面加上下面语句即可
							TimeToTextArea(daytime,crtime).paintImmediately(TimeToTextArea(daytime,crtime).getBounds());
							JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);	*/
							//清空
							/*textField_CrIDEdit.setText("");
							textField_TrIDEdit.setText("");
							textField_classroomEdit.setText("");
							textField_CrNameEdit.setText("");
							textField_capacityEdit.setText("");*/
						}
						
					}
					else {//不存在相同课程
						time_cr=time_cr+time;//更新时间
						/*
						 * 传输数据
						 */
						//课程Id、教师一卡通、课程名、上课时间、教室、课容量，预期上课时间、课程类型
						CourseScheduling obj1=new CourseScheduling(CrID,TrID,CrName,time_cr,classroom,crCapacity,proposal,crtype);
						Message msg1=new Message("courseScheduling",obj1);
						Object temp1 = Sender.send(msg1);
						Message res1 = (Message)temp1;
						while(res1.status.equals("100"));
						if(res1.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "上传失败:"+((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							vec.add(new ClassInfor(CrID,time_cr));//更新vector
							String t_context=CrID+" "+TrID+" "+CrName+" "+classroom+" "+crCapacity+"\n";
							TimeToTextArea(daytime,crtime).append(t_context);//紧跟在此后面加上下面语句即可
							TimeToTextArea(daytime,crtime).paintImmediately(TimeToTextArea(daytime,crtime).getBounds());
							JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}	
						/*String t_context="*"+CrID+" | "+TrID+" | "+CrName+" | "+classroom+" | "+crCapacity+"\n";
						TimeToTextArea(daytime,crtime).append(t_context);//紧跟在此后面加上下面语句即可
						TimeToTextArea(daytime,crtime).paintImmediately(TimeToTextArea(daytime,crtime).getBounds());
						JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);	*/
						//清空
						/*textField_CrIDEdit.setText("");
						textField_TrIDEdit.setText("");
						textField_classroomEdit.setText("");
						textField_CrNameEdit.setText("");
						textField_capacityEdit.setText("");*/
					}		
				}
				else if(!CrID.equals("")&&!TrID.equals("")&&!classroom.equals("")&&!CrName.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查课程容量格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!CrID.equals("")&&!TrID.equals("")&&!classroom.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查课程名称格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!CrID.equals("")&&!TrID.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查教室格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!CrID.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查教师一卡通格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "请检查课程号格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Button_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Button_add.setBackground(new Color(100, 149, 237));
		Button_add.setForeground(new Color(255, 255, 255));
		Button_add.setFont(new Font("微软雅黑", Font.BOLD, 16));
		Button_add.setBounds(319, 212, 89, 23);
		panel_Mess.add(Button_add);
		
		/*JButton Button_delete = new JButton("删除");
		Button_delete.setForeground(Color.WHITE);
		Button_delete.setFont(new Font("微软雅黑", Font.BOLD, 16));
		Button_delete.setBackground(new Color(100, 149, 237));
		Button_delete.setBounds(467, 212, 88, 23);
		panel_Mess.add(Button_delete);
		
		JButton Button_submit = new JButton("提交");
		Button_submit.setForeground(Color.WHITE);
		Button_submit.setFont(new Font("微软雅黑", Font.BOLD, 16));
		Button_submit.setBackground(new Color(100, 149, 237));
		Button_submit.setBounds(572, 212, 88, 23);
		panel_Mess.add(Button_submit);*/
		
		textField_classroom = new JTextField();
		textField_classroom.setText(" 教室");
		textField_classroom.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_classroom.setEditable(false);
		textField_classroom.setColumns(10);
		textField_classroom.setBackground(new Color(248, 248, 255));
		textField_classroom.setBounds(20, 95, 109, 46);
		panel_Mess.add(textField_classroom);
		
		textField_classroomEdit = new JTextField("");
		textField_classroomEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_classroomEdit.setColumns(10);
		textField_classroomEdit.setBackground(Color.WHITE);
		textField_classroomEdit.setBounds(129, 95, 170, 46);
		panel_Mess.add(textField_classroomEdit);
		
		textField_CrName = new JTextField();
		textField_CrName.setText(" 课程名称");
		textField_CrName.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_CrName.setEditable(false);
		textField_CrName.setColumns(10);
		textField_CrName.setBackground(new Color(248, 248, 255));
		textField_CrName.setBounds(299, 95, 109, 46);
		panel_Mess.add(textField_CrName);
		
		textField_CrNameEdit = new JTextField("");
		textField_CrNameEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_CrNameEdit.setColumns(10);
		textField_CrNameEdit.setBackground(Color.WHITE);
		textField_CrNameEdit.setBounds(408, 95, 170, 46);
		panel_Mess.add(textField_CrNameEdit);
		
		textField_CrType = new JTextField();
		textField_CrType.setText(" 课程类型");
		textField_CrType.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_CrType.setEditable(false);
		textField_CrType.setColumns(10);
		textField_CrType.setBackground(new Color(248, 248, 255));
		textField_CrType.setBounds(299, 141, 109, 46);
		panel_Mess.add(textField_CrType);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(248, 248, 255));
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"必修", "选修"}));
		comboBox.setBounds(408, 141, 170, 46);
		panel_Mess.add(comboBox);
		
		textField_Trwilling = new JTextField();
		textField_Trwilling.setText("教师意向");
		textField_Trwilling.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_Trwilling.setEditable(false);
		textField_Trwilling.setColumns(10);
		textField_Trwilling.setBackground(new Color(248, 248, 255));
		textField_Trwilling.setBounds(578, 49, 109, 138);
		panel_Mess.add(textField_Trwilling);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		scrollPane_20 = new JScrollPane();
		scrollPane_20.setBounds(687, 49, 485, 138);
		panel_Mess.add(scrollPane_20);
		
		textArea = new JTextArea();
		scrollPane_20.setViewportView(textArea);
		textArea.setEditable(false);
		textArea.setLineWrap(true);//自动换行
		textArea.setWrapStyleWord(true);//断航不断字
		textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		Button_application = new JButton("获取意向");
		Button_application.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 获得数据
				 */
				String tr_ID=textField_TrIDEdit.getText();
				if(!tr_ID.equals("")) {
					CourseScheduling obj=new CourseScheduling(tr_ID);
					Message msg=new Message("getPreferTime",obj);
					Object temp = Sender.send(msg);
					Message res = (Message)temp;
					while(res.status.equals("100"));
					if(res.status.equals("404")) {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						textArea.setText(((UniversalClass)res.response[0]).context);
						JOptionPane.showMessageDialog(null, "获取成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "教师一卡通不能为空", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Button_application.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		Button_application.setForeground(Color.WHITE);
		Button_application.setFont(new Font("微软雅黑", Font.BOLD, 16));
		Button_application.setBackground(new Color(100, 149, 237));
		Button_application.setBounds(1066, 197, 109, 23);
		panel_Mess.add(Button_application);
		
		textField_capacity = new JTextField();
		textField_capacity.setText(" 课程容量");
		textField_capacity.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_capacity.setEditable(false);
		textField_capacity.setColumns(10);
		textField_capacity.setBackground(new Color(248, 248, 255));
		textField_capacity.setBounds(20, 187, 109, 46);
		panel_Mess.add(textField_capacity);
		
		textField_capacityEdit = new JTextField("");
		textField_capacityEdit.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_capacityEdit.setColumns(10);
		textField_capacityEdit.setBackground(Color.WHITE);
		textField_capacityEdit.setBounds(129, 187, 170, 46);
		panel_Mess.add(textField_capacityEdit);
		
		JPanel panel_course = new JPanel();
		panel_course.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_course.setBackground(Color.WHITE);
		panel_course.setBounds(10, 265, 1217, 654);
		add(panel_course);
		panel_course.setLayout(null);
		
		/*ImageIcon images = new ImageIcon("picture/course.png");
		JLabel lblLabel_background = new JLabel(images);
		lblLabel_background.setBounds(120, 69, 1080, 540);
		panel_course.add(lblLabel_background);*/
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 100, 209, 116);
		panel_course.add(scrollPane);
		

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
		
		/*
		 * 传递已有课程
		 */
		
		CourseScheduling obj2=new CourseScheduling();
		Message msg2=new Message("printCourse",obj2);
		Object temp2 = Sender.send(msg2);
		Message res2 = (Message)temp2;
		int cnt=res2.num;
		//Vector<ClassInfor> vec=new Vector();//课程id+时间
		
		while(res2.status.equals("100"));
		if(res2.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((CourseScheduling)res2.response[0]).teacherCard, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				CourseScheduling tem=(CourseScheduling)res2.response[i];
				//CrID+" "+TrID+" "+CrName+" "+classroom+" "+crCapacity+"\n";

				vec.add(new ClassInfor(tem.courseId,tem.courseTime));
				String message=tem.courseId+" "+tem.teacherCard+" "+tem.courseName+" "+tem.classroom+" "+String.valueOf(tem.capacity)+"\n";
				
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
		
		

	}
}

