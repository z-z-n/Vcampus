package client.view;
/**
 * 学生成绩查询
 */

import java.awt.Color;
import client.Sender;
import server.common.*;
import server.communication.Message;
import java.awt.Dimension;


import client.Sender;
import server.common.GradeClass;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GradeInquiryUI_St extends JPanel {
	private String name="崔致远";
	private String ID="213191956";
	private String CrID="";
	private JTextField textField_search;
	private JTable table_list;
	

	/**
	 * Create the panel.
	 */
	public GradeInquiryUI_St(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1130, 929);
		setLayout(null);
		

		// * 获得数据
		//*************************所有学生信息接口
		GradeClass obj=new GradeClass(ID);
		Message msg=new Message("gradeInquiry",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		int cnt=res.num;
		Object[][] data = new Object[cnt][3];
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((GradeClass)res.response[0]).cardNum, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				//System.out.println(((GradeClass)res.response[i]).cardNum+((GradeClass)res.response[i]).courseId+((GradeClass)res.response[i]).score);
				GradeClass tem=(GradeClass)res.response[i];
				data[i][0]=tem.courseId;//Name1[i]=tem.name;
				data[i][1]=tem.cardNum;//ID1[i]=tem.cardNum;
				data[i][2]=String.valueOf(tem.score);
			}
		}
		
		JPanel panel_search = new JPanel();
		panel_search.setBackground(new Color(255, 255, 255));
		panel_search.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_search.setBounds(50, 40, 1009, 115);
		add(panel_search);
		panel_search.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setBounds(23, 10, 10, 29);
		panel_search.add(panel_1);
		
		JLabel lblLabel_GradeInquiry = new JLabel("成绩查询");
		lblLabel_GradeInquiry.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_GradeInquiry.setBounds(43, 12, 89, 26);
		panel_search.add(lblLabel_GradeInquiry);
		
		textField_search = new JTextField(" 课程号");
		textField_search.setForeground(Color.GRAY);
		//重定义光标响应(光标不在年文本框内，判断)
		textField_search.addFocusListener(new FocusListener() {			

			@Override
			public void focusGained(FocusEvent e) {
				//获取焦点时，清空提示内容
				String temp = textField_search.getText();
				if(temp.equals(" 课程号")) {
					textField_search.setText("");
					textField_search.setForeground(Color.BLACK);
				}	
			}

			@Override
			public void focusLost(FocusEvent e) {
				//失去焦点时，没有输入内容，显示提示内容
				String temp = textField_search.getText();
				if(temp.equals("")) {
					textField_search.setForeground(Color.GRAY);
					textField_search.setText(" 课程号");
				}		
			}		
		});			
		textField_search.setBounds(66, 48, 802, 40);
		panel_search.add(textField_search);
		textField_search.setColumns(10);
		
		
		
		ImageIcon Icon_search = new ImageIcon("picture/search.jpg");
		JLabel lblLabel_search = new JLabel(Icon_search);
		lblLabel_search.setBounds(23, 52, 30, 30);
		panel_search.add(lblLabel_search);
		
		JPanel panel_list = new JPanel();
		panel_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_list.setBackground(new Color(255, 255, 255));
		panel_list.setBounds(50, 191, 1009, 698);
		add(panel_list);
		panel_list.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(123, 170, 936, 1);
		add(panel_2);
		
		JLabel lblLabel_Gradelist = new JLabel("成绩列表");
		lblLabel_Gradelist.setForeground(new Color(192, 192, 192));
		lblLabel_Gradelist.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_Gradelist.setBounds(50, 155, 89, 26);
		add(lblLabel_Gradelist);
		
		
		
		DefaultTableModel model = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		String header[]= {"课程号","学生一卡通","成绩"};
		/*int y=30;
		Object[][] data = new Object[y][3];
		for(int i=0;i<y;i++)
		{
			data[i][0]="课程名称";
			data[i][1]="test";
			data[i][2]="test";
		}*/
		model.setDataVector(data, header);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 61, 948, 607);
		panel_list.add(scrollPane);
		table_list = new JTable(model)
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
		table_list.setDefaultRenderer(Object.class, r);
		scrollPane.setViewportView(table_list);
		scrollPane.getViewport().setBackground(Color.white);//设置背景色
		table_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list.setRowHeight(50);//设置行高
		
        //设置标头
		
		table_list.getTableHeader().setResizingAllowed(true);
		table_list.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table_list.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table_list.getTableHeader().setPreferredSize(size);
		
		//设置列宽
		/*TableColumn Column_look = table_list.getColumnModel().getColumn(5);
		Column_look.setPreferredWidth(50);
		Column_look.setMaxWidth(50);
		Column_look.setMinWidth(50);
		TableColumn Column_delete = table_list.getColumnModel().getColumn(6);
		Column_delete.setPreferredWidth(50);
		Column_delete.setMaxWidth(50);
		Column_delete.setMinWidth(50);
		
		
		//点击阅读
		table_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list.getSelectedColumn();
				int r=table_list.getSelectedRow();
				//String t_name=table_list.getValueAt(r, 0).toString();
				String t_ID=table_list.getValueAt(r, 2).toString();
				//String t_reason=reason[r];
				//int t_sex=sex[r];
				//int t_StNum=StNum[r];
				if(c==0) {//课程详情
				//获取课程信息

				}
			}
		});
		*/
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CrID=textField_search.getText();
				int flag=0;int row=0;
				if(CrID!=" 课程号") {
					for(int i=0;i<cnt;i++) {
					//for(int i=0;i<y;i++) {
						if(data[i][0].equals(CrID)) {
							flag=1;row=i;
							break;
						}
					}
					if(flag==1) {
						table_list.setRowSelectionInterval(row,row);//选中行
					}
					else {
						JOptionPane.showMessageDialog(null, "亲，未找到对应学生，请检查输入", "提示(｡･ω･｡)ﾉ", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnNewButton.setBounds(891, 48, 97, 40);
		panel_search.add(btnNewButton);

	}
}
