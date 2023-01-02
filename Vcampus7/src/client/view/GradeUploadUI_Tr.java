package client.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import client.Sender;
import server.common.GradeClass;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GradeUploadUI_Tr extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private String stID="";
	private String crID="";
	private String grade="";
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_list;
	
	public boolean isGrade(String str) {
		boolean result = true;
		try {
			int grade=Integer.parseInt(str);
			if(grade>=0&&grade<=100) {
				result=true;
			}
			else {
				result=false;
			}

		} catch (NumberFormatException e) {
			result=false;
		}
	    return result;
	}

	/**
	 * Create the panel.
	 */
	public GradeUploadUI_Tr(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1290, 820);
		setLayout(null);
		
		
		textField = new JTextField();
		textField.setText("成绩提交");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(30, 144, 255));
		textField.setBounds(85, 44, 1034, 30);
		add(textField);
		
		JPanel panel_BasicMess = new JPanel();
		panel_BasicMess.setLayout(null);
		panel_BasicMess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_BasicMess.setBackground(Color.WHITE);
		panel_BasicMess.setBounds(56, 73, 1137, 168);
		add(panel_BasicMess);
		
		JLabel lblLabel_basicMess = new JLabel("课程信息");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(67, 10, 119, 26);
		panel_BasicMess.add(lblLabel_basicMess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(47, 8, 10, 29);
		panel_BasicMess.add(panel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setText("教师一卡通");
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(248, 248, 255));
		textField_1.setBounds(44, 50, 172, 46);
		panel_BasicMess.add(textField_1);
		
		textField_2 = new JTextField(ID);
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(216, 50, 349, 46);
		panel_BasicMess.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(" 学生一卡通号");
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(248, 248, 255));
		textField_3.setBounds(565, 50, 172, 46);
		panel_BasicMess.add(textField_3);
		
		textField_4 = new JTextField("");
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(737, 50, 349, 46);
		panel_BasicMess.add(textField_4);
		
		JLabel lblLabel_extraEdit_1 = new JLabel("保存");
		lblLabel_extraEdit_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	            stID=textField_4.getText();
				crID=textField_6.getText();
				grade=textField_8.getText();
				int g=Integer.parseInt(grade);
				
				if(isGrade(grade)&&!stID.equals("")&&!crID.equals("")) {
					/*
					 * 传输数据
					 */
					GradeClass obj1=new GradeClass(stID,crID,g);
					Message msg1=new Message("gradeUpload",obj1);
					Object temp1 = Sender.send(msg1);
					Message res1 = (Message)temp1;
					while(res1.status.equals("100"));
					if(res1.status.equals("404")) {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						//增加行
						DefaultTableModel tableModel = (DefaultTableModel) table_list.getModel();
						tableModel.addRow(new Object[]{crID, stID, grade,"编辑","删除"});
						table_list.repaint();	
						//tableModel.addRow(new Object[]{crID, stID, grade});	
					}										
				}
				else if(stID.equals("")&&!crID.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查成绩格式", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(stID.equals("")) {
					JOptionPane.showMessageDialog(null, "请检查课程号", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "请检查学生一卡通", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		lblLabel_extraEdit_1.setForeground(new Color(135, 206, 250));
		lblLabel_extraEdit_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_extraEdit_1.setBackground(Color.WHITE);
		lblLabel_extraEdit_1.setBounds(183, 16, 30, 20);
		panel_BasicMess.add(lblLabel_extraEdit_1);
		
		textField_5 = new JTextField();
		textField_5.setText("课程号");
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(248, 248, 255));
		textField_5.setBounds(44, 96, 172, 46);
		panel_BasicMess.add(textField_5);
		
		textField_6 = new JTextField("");
		textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(216, 96, 349, 46);
		panel_BasicMess.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("成绩");
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBackground(new Color(248, 248, 255));
		textField_7.setBounds(565, 96, 172, 46);
		panel_BasicMess.add(textField_7);
		
		textField_8 = new JTextField("");
		textField_8.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(737, 96, 349, 46);
		panel_BasicMess.add(textField_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(56, 273, 1137, 525);
		add(panel_1);
		panel_1.setLayout(null);
		
		/*
		 * 获得数据
		 */
		//*************************所有学生信息接口
		GradeClass obj=new GradeClass(ID);
		Message msg=new Message("getGradeByT",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		
		int cnt=res.num;
		Object[][] data = new Object[cnt][5];
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((GradeClass)res.response[0]).cardNum, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
			if(cnt==1) {
				data = new Object[0][5];
			}
		}
		else {
			for(int i=0;i<cnt;i++) {
				//System.out.println(((GradeClass)res.response[i]).cardNum+((GradeClass)res.response[i]).courseId+((GradeClass)res.response[i]).score);
				GradeClass tem=(GradeClass)res.response[i];
				data[i][0]=tem.courseId;//Name1[i]=tem.name;
				data[i][1]=tem.cardNum;//ID1[i]=tem.cardNum;
				data[i][2]=tem.score;
				data[i][3]="点击编辑";
				data[i][4]="点击删除";
			}
		}
	
		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		String header1[]= {"课程号","学生一卡通","成绩","点击编辑","点击删除"};
		/*
		int x=30;
		Object[][] data = new Object[x][4];
		for(int i=0;i<x;i++)
		{
			data[i][0]="1";
			data[i][1]="213191948";
			data[i][2]="90";
			data[i][3]="编辑";
		}*/
		model1.setDataVector(data, header1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 55, 1035, 448);
		panel_1.add(scrollPane);
		table_list = new JTable(model1)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		DefaultTableCellRenderer r1=new DefaultTableCellRenderer();
		r1.setHorizontalAlignment(JLabel.CENTER);//居中显示
		table_list.setDefaultRenderer(Object.class, r1);
		scrollPane.setViewportView(table_list);
		scrollPane.getViewport().setBackground(Color.white);//设置背景色
		table_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list.setRowHeight(30);
		
		JLabel lblLabel_3 = new JLabel("记得看提交的作业哦！");
		lblLabel_3.setBounds(168, 42, 148, 30);
		add(lblLabel_3);
		lblLabel_3.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
        //设置标头
		
		table_list.getTableHeader().setResizingAllowed(true);
		table_list.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size1 = table_list.getTableHeader().getPreferredSize();
		size1.height = 25;//设置新的表头高度
		table_list.getTableHeader().setPreferredSize(size1);
		
		//设置列宽
		TableColumn Column_look = table_list.getColumnModel().getColumn(3);
		Column_look.setPreferredWidth(100);
		Column_look.setMaxWidth(100);
		Column_look.setMinWidth(100);
		/*TableColumn Column_delete = table_hwlist.getColumnModel().getColumn(6);
		Column_delete.setPreferredWidth(50);
		Column_delete.setMaxWidth(50);
		Column_delete.setMinWidth(50);
		*/
		
		//点击阅读
		table_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list.getSelectedColumn();
				int r=table_list.getSelectedRow();
				String t_Cr=table_list.getValueAt(r, 0).toString();
				String t_ID=table_list.getValueAt(r, 1).toString();
				//String t_reason=reason[r];
				if(c==3) {
					String m = JOptionPane.showInputDialog(null, "请输入修改成绩","成绩修改", JOptionPane.INFORMATION_MESSAGE);
					if(isGrade(m)) {
						int g=Integer.parseInt(m);
						GradeClass obj2=new GradeClass(t_ID,t_Cr,g);
						Message msg2=new Message("editGrade",obj2);
						Object temp2 = Sender.send(msg2);
						Message res2 = (Message)temp2;
						while(res2.status.equals("100"));
						/*
						 * 传数据
						*/
						if(res2.status.equals("404")) {
							JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							DefaultTableModel tableModel = (DefaultTableModel) table_list.getModel();
							tableModel.setValueAt(m, r, 2);// 取单元格数据,row是行号,column是列号
							table_list.repaint();	
						}						
					}
					else{
						JOptionPane.showMessageDialog(null, "亲，请输入正确格式", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}

				}
				else if(c==4) {
					int yn=JOptionPane.showConfirmDialog(null, "是否删除该项成绩？", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
					if(yn==JOptionPane.YES_OPTION) {
						 //是
						DefaultTableModel tableModel = (DefaultTableModel) table_list.getModel();
						tableModel.removeRow(r);// 删除的行序号
						table_list.repaint();	
						//数据库删除
						GradeClass obj4 = new GradeClass(t_ID,t_Cr);//学生一卡通、课程ID
						Message msg4 = new Message("deleteGrade", obj4);
				        Object temp4 = Sender.send(msg4);
						Message res4 = (Message)temp4;
						while(res4.status.equals("100"));
						if(res4.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "亲，删除失败："+((UniversalClass)res4.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "亲，删除成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(48, 10, 10, 29);
		panel_1.add(panel_2);
		
		JLabel lblLabel_basicMess_1 = new JLabel("成绩列表");
		lblLabel_basicMess_1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess_1.setBounds(68, 12, 119, 26);
		panel_1.add(lblLabel_basicMess_1);

	}

}
