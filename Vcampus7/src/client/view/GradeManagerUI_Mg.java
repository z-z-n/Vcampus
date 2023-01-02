package client.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.GradeClass;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class GradeManagerUI_Mg extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblLabel_basicMess;
	private JPanel panel_decorate;
	private JLabel lblNewLabel;
	private JPanel panel_decorate_1;
	private JTable table_list;
	private JScrollPane scrollPane;

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
	public GradeManagerUI_Mg() {
		setBackground(Color.WHITE);
		setSize(1249, 929);
		setLayout(null);
		
		/*
		 * 获得数据
		 */
		//*************************所有学生信息接口
		GradeClass obj=new GradeClass();
		Message msg=new Message("printGrade",obj);
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
				data[i][0]=tem.courseId;
				data[i][1]=tem.cardNum;
				data[i][2]=tem.score;
				data[i][3]="点击编辑";
				data[i][4]="点击删除";
			}
		}
		
		JPanel panel_Mess = new JPanel();
		panel_Mess.setLayout(null);
		panel_Mess.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Mess.setBackground(Color.WHITE);
		panel_Mess.setBounds(22, 23, 1217, 196);
		add(panel_Mess);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(20, 90, 10, 29);
		panel_Mess.add(panel_1);
		
		JLabel lblLabel_CrMess = new JLabel("搜索设置");
		lblLabel_CrMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_CrMess.setBounds(40, 93, 89, 26);
		panel_Mess.add(lblLabel_CrMess);
		
		textField = new JTextField();
		textField.setText(" 课程号");
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(248, 248, 255));
		textField.setBounds(20, 129, 109, 46);
		panel_Mess.add(textField);
		
		textField_1 = new JTextField("");
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(129, 129, 170, 46);
		panel_Mess.add(textField_1);
		
		textField_7 = new JTextField("");
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(408, 129, 170, 46);
		panel_Mess.add(textField_7);
		/*
		textField_2 = new JTextField();
		textField_2.setText(" 教师一卡通");
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(248, 248, 255));
		textField_2.setBounds(299, 129, 109, 46);
		panel_Mess.add(textField_2);
		
		textField_3 = new JTextField("");
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(408, 129, 170, 46);
		panel_Mess.add(textField_3);*/
		
		JButton Button_search = new JButton("搜索");
		Button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				String Cr_ID=textField_1.getText();
				String St_ID=textField_7.getText();
				int rows = table_list.getRowCount();
				
				if(!Cr_ID.equals("")&&!St_ID.equals("")) {
					table_list.clearSelection();//清除选中状态
					int flag=0;
					for(int i=0;i<rows;i++) {
						String t1=table_list.getValueAt(i, 0).toString();
						String t2=table_list.getValueAt(i, 1).toString();
						if(t1.equals(Cr_ID)) {
							if(t2.equals(St_ID)) {
								table_list.setRowSelectionInterval(i,i);//选中行
								flag=1;
							}
						}	
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null, "亲，未找到对应内容，请检查输入", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
				else if(Cr_ID.equals("")&&St_ID.equals("")) {//都空
					JOptionPane.showMessageDialog(null, "搜索信息为空", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(!Cr_ID.equals("")) {//学生一卡通为空
					table_list.clearSelection();//清除选中状态
					int flag=0;
					for(int i=0;i<rows;i++) {
						String t1=table_list.getValueAt(i, 0).toString();
						if(t1.equals(Cr_ID)) {
							table_list.setRowSelectionInterval(i,i);//选中行
							flag=1;
						}	
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null, "亲，未找到对应课程，请检查输入", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else{//课程号空
					table_list.clearSelection();//清除选中状态
					int flag=0;
					for(int i=0;i<rows;i++) {
						String t2=table_list.getValueAt(i, 1).toString();
						if(t2.equals(St_ID)) {
							table_list.setRowSelectionInterval(i,i);//选中行
							flag=1;
						}	
					}
					if(flag==0) {
						JOptionPane.showMessageDialog(null, "亲，未找到对应学生，请检查输入", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		Button_search.setForeground(Color.WHITE);
		Button_search.setFont(new Font("微软雅黑", Font.BOLD, 16));
		Button_search.setBackground(new Color(100, 149, 237));
		Button_search.setBounds(612, 140, 89, 26);
		panel_Mess.add(Button_search);
		
		ImageIcon Icon1 = new ImageIcon("picture/grade1.jpg");
		
		/*textField_4 = new JTextField();
		textField_4.setText("课程名称");
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(248, 248, 255));
		textField_4.setBounds(578, 129, 109, 46);
		panel_Mess.add(textField_4);
		
		textField_5 = new JTextField("");
		textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(687, 129, 170, 46);
		panel_Mess.add(textField_5);
		*/
		textField_6 = new JTextField();
		textField_6.setText("学生一卡通");
		textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(248, 248, 255));
		textField_6.setBounds(299, 129, 109, 46);
		panel_Mess.add(textField_6);
		
		
		panel_decorate = new JPanel();
		panel_decorate.setBackground(new Color(135, 206, 250));
		panel_decorate.setBounds(20, 58, 450, 3);
		panel_Mess.add(panel_decorate);
		
		lblNewLabel = new JLabel("成绩管理");
		lblNewLabel.setForeground(new Color(169, 169, 169));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(480, 41, 209, 37);
		panel_Mess.add(lblNewLabel);
		
		panel_decorate_1 = new JPanel();
		panel_decorate_1.setBackground(new Color(135, 206, 250));
		panel_decorate_1.setBounds(687, 58, 450, 3);
		panel_Mess.add(panel_decorate_1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(22, 240, 1217, 668);
		add(panel);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(21, 10, 10, 29);
		panel.add(panel_2);
		
		lblLabel_basicMess = new JLabel("成绩列表");
		lblLabel_basicMess.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_basicMess.setBounds(41, 12, 119, 26);
		panel.add(lblLabel_basicMess);
		
		
		

		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		String header[]= {"课程号","学生一卡通","成绩","编辑","删除"};
		/*int x=30;
		Object[][] data1 = new Object[x][4];
		for(int i=0;i<x;i++)
		{
			data1[i][0]="1";
			data1[i][1]="213191948";
			data1[i][2]="90";
			data1[i][3]="编辑";
		}*/
		model1.setDataVector(data, header);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 49, 1115, 592);
		panel.add(scrollPane);
		table_list = new JTable(model1)
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
		/*TableColumn Column_look = table_hwlist.getColumnModel().getColumn(5);
		Column_look.setPreferredWidth(50);
		Column_look.setMaxWidth(50);
		Column_look.setMinWidth(50);
		TableColumn Column_delete = table_hwlist.getColumnModel().getColumn(6);
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
							 //是
							DefaultTableModel tableModel = (DefaultTableModel) table_list.getModel();
							tableModel.removeRow(r);// 删除的行序号
							table_list.repaint();
							JOptionPane.showMessageDialog(null, "亲，删除成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});

	}

}
