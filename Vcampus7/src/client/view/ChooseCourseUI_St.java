package client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import client.ClassInfor;
import client.Sender;
import server.common.ChangeWithReason;
import server.common.CourseScheduling;
import server.common.GradeClass;
import server.common.OnlyCardNum;
import server.common.StuCourse;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class ChooseCourseUI_St extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private String Exit_time="";
	private String Exit_course="";
	private JTextField textField;
	private JTable table_Cr;

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
	public ChooseCourseUI_St(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1130, 929);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(37, 79, 1056, 805);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(35, 10, 10, 29);
		panel.add(panel_1);
		
		JLabel lblLabel_CrSchedule = new JLabel("课程列表");
		lblLabel_CrSchedule.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_CrSchedule.setBounds(55, 12, 89, 26);
		panel.add(lblLabel_CrSchedule);
		
		/*table_Cr = new JTable();
		table_Cr.setBounds(35, 49, 979, 767);
		panel.add(table_Cr);*/
		
		textField = new JTextField();
		textField.setText("选课");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(30, 144, 255));
		textField.setBounds(154, 49, 843, 30);
		add(textField);
		
		/*
		 * 教务设置课程
		 */
		CourseScheduling obj=new CourseScheduling();
		Message msg=new Message("printCourse",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		int cnt=res.num;
		Object[][] data = new Object[cnt][7];
		String data1[]=new String[cnt];
		
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((CourseScheduling)res.response[0]).teacherCard, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				//System.out.println(((GradeClass)res.response[i]).cardNum+((GradeClass)res.response[i]).courseId+((GradeClass)res.response[i]).score);
				CourseScheduling tem=(CourseScheduling)res.response[i];
				data[i][0]=tem.courseId;
				//data[i][1]=tem.teacherCard;			
				data[i][2]=StringToTime(tem.courseTime);
				data1[i]=tem.courseTime;
				data[i][3]="不冲突";
				data[i][4]="选择";
				data[i][5]="退选";
				data[i][6]="0";//0为未选，1为已选
				
				//获得教师姓名
				StuCourse obj6=new StuCourse(tem.teacherCard);
				Message msg6=new Message("getTeacherName",obj6);
				Object temp6 = Sender.send(msg6);
				Message res6 = (Message)temp6;
				
				while(res6.status.equals("100"));
				if(res6.status.equals("404")) {
					JOptionPane.showMessageDialog(null, ((UniversalClass)res6.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					data[i][1]=((UniversalClass)res6.response[0]).context;
				}
			}
		}
		
		
		/*
		 * 传递已有课程
		 */
		StuCourse obj5=new StuCourse(ID);
		Message msg5=new Message("printSchedules",obj5);
		Object temp5 = Sender.send(msg5);
		Message res5 = (Message)temp5;
		int cnt1=res5.num;
		String data2[]=new String[cnt1];
		
		while(res5.status.equals("100"));
		if(res5.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((StuCourse)res5.response[0]).teacherCard, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt1;i++) {
				StuCourse tem=(StuCourse)res5.response[i];
				//String message=tem.courseId+" "+tem.teacherCard+" "+tem.courseTime+"\n";
				data2[i]=tem.courseId;//获得已选课程ID
				}
		}
		
		//找已存在课程
		for(int i=0;i<cnt;i++) {
			int t_flag=0;
			for(int j=0;j<cnt1;j++) {
				if(data[i][0].toString().equals(data2[j])) {
					t_flag=1;
				}
			}
			if(t_flag==1) {//存在相同课程
				data[i][3]="冲突";
				data[i][6]="1";
				Exit_time=Exit_time+data1[i];//更新已存在课程时间
			}
		}
		
		DefaultTableModel model = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		/*String header[]= {"课程详情","课程名称","课程类型","授课教师","时间","选择","退选"};
		int y=30;
		Object[][] data = new Object[y][7];
		for(int i=0;i<y;i++)
		{
			data[i][0]="课程详情";
			data[i][1]="课程名称";
			data[i][2]="test";
			data[i][3]="test";
			data[i][4]="test";
			data[i][5]="test";
			data[i][6]="test";
		}*/
		//String header[]= {"课程号","授课教师","时间","是否冲突","选择"};
		String header[]= {"课程号","授课教师","时间","是否冲突","选择","退选"};
		/*int y=30;
		Object[][] data = new Object[y][5];
		String data1[]=new String[y];
		for(int i=0;i<y;i++)
		{
			data[i][0]="课程名称";
			data[i][1]="213191948";
			data[i][2]="周一 一二节";
			data[i][3]="不冲突";
			data[i][4]="选择";
		}*/
		model.setDataVector(data, header);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 49, 979, 730);
		panel.add(scrollPane_1);
		table_Cr = new JTable(model)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
           /* public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            	Component component = super.prepareRenderer(renderer, row, column);

            	if (column == 0) {
            	component.setForeground(Color.blue);
            	}
            	return component;
            	}*/
		};
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);//居中显示
		table_Cr.setDefaultRenderer(Object.class, r);
		scrollPane_1.setViewportView(table_Cr);
		scrollPane_1.getViewport().setBackground(Color.white);//设置背景色
		table_Cr.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_Cr.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_Cr.setRowHeight(50);//设置行高
		
		JLabel lblLabel_basicEdit = new JLabel("课表");
		lblLabel_basicEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new TimetableUI_St(name,ID).setVisible(true);	
			}
		});
		lblLabel_basicEdit.setForeground(new Color(100, 149, 237));
		lblLabel_basicEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_basicEdit.setBounds(960, 10, 54, 27);
		panel.add(lblLabel_basicEdit);
        //设置标头
		
		table_Cr.getTableHeader().setResizingAllowed(true);
		table_Cr.getTableHeader().setBackground(new Color(135, 206, 250));
		table_Cr.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table_Cr.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table_Cr.getTableHeader().setPreferredSize(size);
		
		//设置列宽
		TableColumn Column_look = table_Cr.getColumnModel().getColumn(4);
		Column_look.setPreferredWidth(50);
		Column_look.setMaxWidth(50);
		Column_look.setMinWidth(50);
		/*TableColumn Column_delete = table_Cr.getColumnModel().getColumn(5);
		Column_delete.setPreferredWidth(50);
		Column_delete.setMaxWidth(50);
		Column_delete.setMinWidth(50);*/
		
		//点击阅读
		table_Cr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_Cr.getSelectedColumn();
				int r=table_Cr.getSelectedRow();
				String t_time=data1[r];
				String t_status=table_Cr.getValueAt(r, 3).toString();
				String t_crID=table_Cr.getValueAt(r, 0).toString();//课程号
				String t_choose=table_Cr.getValueAt(r, 4).toString();//选择状态
				if(c==4){//选择
					/*
					 * 是否冲突
					 * 不冲突:选择 保存课程内容 改为退选 重新计算冲突项
					 */
					if(t_status.equals("不冲突")) {//是否冲突
						//不冲突
						int yn=JOptionPane.showConfirmDialog(null, "是否选择？", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
						if(yn==JOptionPane.YES_OPTION) {							
							//char[] chars=Exit_time.toCharArray();
							//Arrays.sort(chars);//排序
							//Exit_time=Arrays.toString(chars);
							/*
							 * 上传
							 */
							StuCourse obj2 = new StuCourse(ID,t_crID);
							Message msg3 = new Message("chooseCourse", obj2);
						    Object temp3 = Sender.send(msg3);
						    Message res3 = (Message)temp3;
							while(res3.status.equals("100"));	
							if(res3.status.equals("404")) {
								JOptionPane.showMessageDialog(null, ((StuCourse)res3.response[0]).cardNum, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
							else {//上传成功
								Exit_time=Exit_time+t_time;//合并时间
								data[r][6]="1";//更新已选状态
								DefaultTableModel tableModel = (DefaultTableModel) table_Cr.getModel();
								//更新冲突
								//for(int i=0;i<30;i++) {
								for(int i=0;i<cnt;i++) {
									int len=data1[i].length();//某一课程字母时间长度
									int flag=0;
									for(int j=0;j<len;j++) {//第一个字母
										char t_char=data1[i].charAt(j);//下标 转char
										String t_string=String.valueOf(t_char);//转string
										if(Exit_time.indexOf(t_string)!=-1) {//Exittime中是否存在，不存在-1，存在下标
											flag=1;
											break;
										}	
									}
									if(flag==1) {
										tableModel.setValueAt("冲突", i, 3);// 取单元格数据,row是行号,column是列号
									}
									else {
										tableModel.setValueAt("不冲突", i, 3);
									}
								}
								//tableModel.setValueAt("退选", r, 4);// 取单元格数据,row是行号,column是列号
								table_Cr.repaint();
								JOptionPane.showMessageDialog(null, ((StuCourse)res3.response[0]).cardNum, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
						}						
					}
					else {
						JOptionPane.showMessageDialog(null, "课程冲突", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						/*//退选
						if(t_choose.equals("退选")) {
							int exit=JOptionPane.showConfirmDialog(null, "是否退选？", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
							if(exit==JOptionPane.YES_OPTION) {

								StuCourse obj4 = new StuCourse(ID,t_crID);
								Message msg4 = new Message("dropCourse", obj4);
							    Object temp4 = Sender.send(msg4);
							    Message res4 = (Message)temp4;
								while(res4.status.equals("100"));	
								if(res4.status.equals("404")) {
									JOptionPane.showMessageDialog(null, ((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
								}
								else {//上传成功
									Exit_time=Exit_time.replace(t_time, "");//删除时间
									DefaultTableModel tableModel = (DefaultTableModel) table_Cr.getModel();
									//更新冲突
									//for(int i=0;i<30;i++) {
									for(int i=0;i<cnt;i++) {
										int len=data1[i].length();//某一课程字母时间长度
										int flag=0;
										for(int j=0;j<len;j++) {//第一个字母
											char t_char=data1[i].charAt(j);//下标 转char
											String t_string=String.valueOf(t_char);//转string
											if(Exit_time.indexOf(t_string)!=-1) {//Exittime中是否存在，不存在-1，存在下标
												flag=1;
												break;
											}	
										}
										if(flag==1) {
											tableModel.setValueAt("冲突", i, 3);// 取单元格数据,row是行号,column是列号
										}
										else {
											tableModel.setValueAt("不冲突", i, 3);
										}
									}
									tableModel.setValueAt("选择", r, 4);// 取单元格数据,row是行号,column是列号
									table_Cr.repaint();
									JOptionPane.showMessageDialog(null, ((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "课程冲突", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}*/
					}
				}
				else if(c==5){//退选
					if(data[r][6].equals("0")) {//是否已选
						JOptionPane.showMessageDialog(null, "课程未选择", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {//已选
						int exit=JOptionPane.showConfirmDialog(null, "是否退选？", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
						if(exit==JOptionPane.YES_OPTION) {
							StuCourse obj4 = new StuCourse(ID,t_crID);
							Message msg4 = new Message("dropCourse", obj4);
						    Object temp4 = Sender.send(msg4);
						    Message res4 = (Message)temp4;
							while(res4.status.equals("100"));	
							if(res4.status.equals("404")) {
								JOptionPane.showMessageDialog(null, ((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
							else {//上传成功
								Exit_time=Exit_time.replace(t_time, "");//删除时间
								data[r][6]="0";//更新未选状态
								DefaultTableModel tableModel = (DefaultTableModel) table_Cr.getModel();
								//更新冲突
								//for(int i=0;i<30;i++) {
								for(int i=0;i<cnt;i++) {
									int len=data1[i].length();//某一课程字母时间长度
									int flag=0;
									for(int j=0;j<len;j++) {//第一个字母
										char t_char=data1[i].charAt(j);//下标 转char
										String t_string=String.valueOf(t_char);//转string
										if(Exit_time.indexOf(t_string)!=-1) {//Exittime中是否存在，不存在-1，存在下标
											flag=1;
											break;
										}	
									}
									if(flag==1) {
										tableModel.setValueAt("冲突", i, 3);// 取单元格数据,row是行号,column是列号
									}
									else {
										tableModel.setValueAt("不冲突", i, 3);
									}
								}
								//tableModel.setValueAt("选择", r, 4);// 取单元格数据,row是行号,column是列号
								table_Cr.repaint();
								JOptionPane.showMessageDialog(null, ((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			}

		});

	}
}
