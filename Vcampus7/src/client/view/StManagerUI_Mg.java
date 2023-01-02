package client.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import client.Sender;
import server.common.*;
import server.communication.Message;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StManagerUI_Mg extends JPanel {
	private JTextField textField_search;
	private JTable table_st;
	private JTable table_mail;
	private JLabel lblLabel_search;
	public JLabel lblLabel_test;
	
	public String add_name;
	public void setJLabel(JLabel aLabel){
		this.lblLabel_test = aLabel;
	}
	
	public JLabel getJLabel(){
		return lblLabel_test;
	}
	//设置table
	public static void makeFace(JTable table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected,boolean hasFocus,
                    int row, int column) {
                if(row%2==0){
                    setBackground(new Color(248,248,255));
                }else{
                    setBackground(new Color(255,255,255));
                }
                /* setIcon(null); // 一定要这句，不然会出现Icon不断改变的现象
                setBorder(null); // 去掉边框
                if(value instanceof ImageIcon) {
                 setIcon((Icon) value);// 因为DefaultTableCellRenderer是extends JLabel的
                 if(isSelected)
                     setBorder(new LineBorder(Color.red));
                                                        // 如果是选中状态，设置选取中的边框为红色
                }
                if(column==2) {
                	value=new ImageIcon("picture/mail.png");
 
                	if(value instanceof ImageIcon){
            			setIcon((Icon) value);
                	}
                }
                */
                setHorizontalAlignment(JLabel.CENTER);// 表格内容居中
                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// 列头内容居中
                table.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                table.setRowHeight(25);//设置行高
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn col = table.getColumn(table.getColumnName(i));
            col.setCellRenderer(renderer);
        }

        //设置标头
		
        table.getTableHeader().setResizingAllowed(true);
		table.getTableHeader().setBackground(new Color(135, 206, 250));
		table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table.getTableHeader().setPreferredSize(size);
		
		//设置列宽
		TableColumn Column_look = table.getColumnModel().getColumn(2);
		Column_look.setPreferredWidth(200);
		Column_look.setMaxWidth(200);
		Column_look.setMinWidth(200);
    }
	/**
	 * Create the panel.
	 */
	public StManagerUI_Mg() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setSize(1405, 929);
		setLayout(null);
		
		//********************************************************************************
		//*************************所有学生信息接口
		UniversalClass obj1 = new UniversalClass("404");
		Message msg1 = new Message("getAllInfo", obj1);
		Object temp1 = Sender.send(msg1);
		Message res1 = (Message)temp1;
		while(res1.status.equals("100"));
		boolean flag;

		if(res1.status.equals("200"))
		{
			flag=true;
		}
		else{flag=false;}
		//存数据
		int x=res1.num;
		Object[][] data = new Object[x][3];
		Object[] Name1=new Object[x];
		Object[] ID1=new Object[x];
		if(flag)
		{
			for(int i=0;i<x;i++)
			{
				NameAndCardNum temNC=(NameAndCardNum)res1.response[i];
				data[i][0]=temNC.name;Name1[i]=temNC.name;
				data[i][1]=temNC.cardNum;ID1[i]=temNC.cardNum;
				data[i][2]="点击编辑";
			}
		}

		
		JPanel panel_search = new JPanel();
		panel_search.setBackground(new Color(255, 255, 255));
		panel_search.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_search.setBounds(425, 111, 900, 80);
		add(panel_search);
		panel_search.setLayout(null);
		
		String[]  category=new String[] {"姓名","一卡通号"};
		final JComboBox comboBox = new JComboBox(category);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(135, 206, 250));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" 姓名", " 一卡通号"}));
		comboBox.setFont(new Font("微软雅黑", Font.BOLD, 16));
		comboBox.setBounds(37, 23, 123, 35);
		panel_search.add(comboBox);
		
		textField_search = new JTextField();
		textField_search.setBounds(181, 23, 548, 35);
		panel_search.add(textField_search);
		textField_search.setColumns(10);
		//查询点击
		JButton btnButton_search = new JButton("\u67E5\u8BE2");
		btnButton_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String t_search=textField_search.getText();
				String select=(String) comboBox.getSelectedItem();
				int flag=0;int row=0;
				if(select==" 姓名") {
					for(int i=0;i<x;i++) {
						//if(t_search==table_st.getValueAt(i, 0).toString()) {
						if(data[i][0].equals(t_search)) {
							flag=1;row=i;
							break;
						}
					}
					if(flag==1) {
						table_st.setRowSelectionInterval(row,row);//选中行
					}
					else {
						JOptionPane.showMessageDialog(null, "亲，未找到对应学生，请检查输入", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if(select==" 一卡通号") {
					for(int i=0;i<x;i++) {//查找
						//if(t_search==table_st.getValueAt(i, 1).toString()) {
						if(data[i][1].equals(t_search)) {
							flag=1;row=i;
							break;
						}
					}
					if(flag==1) {
						table_st.setRowSelectionInterval(row,row);//选中行
					}
					else {
						JOptionPane.showMessageDialog(null, "亲，未找到对应学生，请检查输入", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnButton_search.setForeground(new Color(255, 255, 255));
		btnButton_search.setBackground(new Color(135, 206, 250));
		btnButton_search.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnButton_search.setBounds(744, 25, 105, 35);
		panel_search.add(btnButton_search);
		
		//********************************************************************************
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(425, 72, 10, 28);
		panel_1.setBackground(new Color(100, 149, 237));
		add(panel_1);
		
		lblLabel_search = new JLabel("\u5B66\u751F\u67E5\u8BE2");
		lblLabel_search.setBounds(459, 72, 88, 28);
		lblLabel_search.setFont(new Font("微软雅黑", Font.BOLD, 18));
		add(lblLabel_search);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(425, 211, 10, 28);
		panel_1_1.setBackground(new Color(100, 149, 237));
		add(panel_1_1);
		
		JLabel lblLabel_StList = new JLabel("\u5B66\u751F\u5217\u8868");
		lblLabel_StList.setBounds(459, 211, 88, 28);
		lblLabel_StList.setFont(new Font("微软雅黑", Font.BOLD, 18));
		add(lblLabel_StList);
		
		JPanel panel_StList = new JPanel();
		panel_StList.setBackground(new Color(255, 255, 255));
		panel_StList.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_StList.setBounds(425, 250, 900, 640);
		add(panel_StList);
		panel_StList.setLayout(null);
		
		//DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		//标头
		String header[]= {"姓名","一卡通号","查看/编辑"};
		
		model.setDataVector(data, header);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 62, 800, 540);
		panel_StList.add(scrollPane);
		table_st = new JTable(model)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

		};
		scrollPane.setViewportView(table_st);
		scrollPane.getViewport().setBackground(Color.white);//设置背景色
		table_st.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		makeFace(table_st);//设置表格样式
        /*table_st.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        table_st.setRowHeight(25);//设置行高
        //设置标头
		
        table_st.getTableHeader().setResizingAllowed(true);
        table_st.getTableHeader().setBackground(new Color(135, 206, 250));
        table_st.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table_st.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table_st.getTableHeader().setPreferredSize(size);
		
		//设置列宽
		TableColumn Column_look = table_st.getColumnModel().getColumn(2);
		Column_look.setPreferredWidth(200);
		Column_look.setMaxWidth(200);
		Column_look.setMinWidth(200);*/
		
		
		table_st.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_st.getSelectedColumn();
				int r=table_st.getSelectedRow();
				if(c==2)
				{
					new Manager_editUI(table_st.getValueAt(r, 0).toString(),table_st.getValueAt(r, 1).toString()).setVisible(true);
				}
			}
		});
		/*
		table_st.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_st.getTableHeader().setBackground(new Color(47, 47, 172, 46));
		table_st.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table_st.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table_st.getTableHeader().setPreferredSize(size);
		table_st.setRowHeight(25);//设置行高
		
		//设置列宽
		TableColumn Column_look = table_st.getColumnModel().getColumn(2);
		TableColumn Column_edit = table_st.getColumnModel().getColumn(5);
		TableColumn Column_delete = table_st.getColumnModel().getColumn(6);
		Column_look.setPreferredWidth(200);
		Column_look.setMaxWidth(200);
		Column_look.setMinWidth(200);
		Column_edit.setPreferredWidth(40);
		Column_edit.setMaxWidth(40);
		Column_edit.setMinWidth(40);
		Column_delete.setPreferredWidth(40);
		Column_delete.setMaxWidth(40);
		Column_delete.setMinWidth(40);
		 */
		
		/*
		//点击添加
		JButton btnButton_add = new JButton("\u6DFB\u52A0");
		btnButton_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open();
				model.addRow(new Object[]{"姓名", "一卡通号", ""});
			}
		});
		btnButton_add.setBackground(new Color(135, 206, 250));
		btnButton_add.setForeground(new Color(255, 255, 255));
		btnButton_add.setFont(new Font("微软雅黑", Font.BOLD, 16));
		btnButton_add.setBounds(744, 11, 105, 35);
		panel_StList.add(btnButton_add);*/
		/*
		JLabel lblLabel_test = new JLabel("New label");
		lblLabel_test.setBounds(54, 22, 65, 16);
		panel_StList.add(lblLabel_test);
		*/
		//********************************************************************************
		JPanel panel_Mess = new JPanel();
		panel_Mess.setBackground(new Color(255, 255, 255));
		panel_Mess.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Mess.setBounds(36, 111, 349, 779);
		add(panel_Mess);
		panel_Mess.setLayout(null);
		
		//******************************************************申请信息接口
		//UniversalClass obj1 = new UniversalClass("404");
		Message msg2 = new Message("getRequest", obj1);
		Object temp2 = Sender.send(msg2);
		Message res2 = (Message)temp2;
		while(res2.status.equals("100"));
		boolean flag1;
		if(res1.status.equals("200"))
		{
			flag1=true;
		}
		else{flag1=false;}
		
		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		//标头
		String header1[]= {"姓名","一卡通号","打开","删除"};
		int y=res2.num;
		String reason[] = new String[y];
		int sex[]=new int[y];
		int StNum[]=new int[y];
		Object[][] data1 = new Object[y][4];
		Icon Icon1 = new ImageIcon("picture/openmail.png");
		Icon Icon2 = new ImageIcon("picture/delete.jpg");
		if(flag1)
		{
			for(int i=0;i<y;i++)
			{
				ChangeWithReason temCWR=(ChangeWithReason)res2.response[i];
				data1[i][0]=temCWR.name;
				data1[i][1]=temCWR.cardNum;
				reason[i]=temCWR.reason;
				sex[i]=temCWR.sex;
				StNum[i]=temCWR.stunum;
				data1[i][2]=Icon1;
				data1[i][3]=Icon2;
			}
		}
		
		model1.setDataVector(data1, header1);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 33, 307, 706);
		panel_Mess.add(scrollPane_1);
		table_mail = new JTable(model1)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

		};
		scrollPane_1.setViewportView(table_mail);
		scrollPane_1.getViewport().setBackground(Color.white);//设置背景色
		table_mail.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_mail.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_mail.setRowHeight(25);//设置行高
        //设置标头
		
		table_mail.getTableHeader().setResizingAllowed(true);
		table_mail.getTableHeader().setBackground(new Color(135, 206, 250));
		table_mail.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size = table_mail.getTableHeader().getPreferredSize();
		size.height = 32;//设置新的表头高度32
		table_mail.getTableHeader().setPreferredSize(size);
		
		//设置列宽
		TableColumn Column_look = table_mail.getColumnModel().getColumn(2);
		Column_look.setPreferredWidth(50);
		Column_look.setMaxWidth(50);
		Column_look.setMinWidth(50);
		TableColumn Column_delete = table_mail.getColumnModel().getColumn(3);
		Column_delete.setPreferredWidth(50);
		Column_delete.setMaxWidth(50);
		Column_delete.setMinWidth(50);
		//点击阅读
		table_mail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_mail.getSelectedColumn();
				int r=table_mail.getSelectedRow();
				String t_name=table_mail.getValueAt(r, 0).toString();
				String t_ID=table_mail.getValueAt(r, 1).toString();
				String t_reason=reason[r];
				int t_sex=sex[r];
				int t_StNum=StNum[r];
				if(c==2)
				{//打开邮件
					new mailReadUI(t_name,t_ID,t_sex,t_StNum,t_reason).setVisible(true);
				}
				if(c==3) {//删除邮件
					//是否确认删除
					int yn=JOptionPane.showConfirmDialog(null, "是否删除选择的申请？", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
					if(yn==JOptionPane.YES_OPTION){
					     //是
						DefaultTableModel tableModel = (DefaultTableModel) table_mail.getModel();
						tableModel.removeRow(r);// 删除的行序号
						//数据库删除
				        OnlyCardNum obj2 = new OnlyCardNum(t_ID);
						Message msg3 = new Message("refuseRequest", obj2);
				        Object temp3 = Sender.send(msg3);
						Message res3 = (Message)temp3;
						while(res3.status.equals("100"));
						JOptionPane.showMessageDialog(null, "亲，删除成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);						
					}

				}
			}
		});
		
		/*JButton btnButton_DeleteAll = new JButton("\u5220\u9664\u5168\u90E8");
		btnButton_DeleteAll.setForeground(Color.WHITE);
		btnButton_DeleteAll.setBackground(new Color(135, 206, 250));
		btnButton_DeleteAll.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btnButton_DeleteAll.setBounds(208, 25, 105, 31);
		panel_Mess.add(btnButton_DeleteAll);
		
		JLabel lblLabel_action = new JLabel("\u64CD\u4F5C");
		lblLabel_action.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_action.setBounds(95, 23, 42, 31);
		panel_Mess.add(lblLabel_action);*/
		
		/*JLabel lblLabel_mail = new JLabel("");
		lblLabel_mail.setIcon(new ImageIcon("picture/mail.png"));
		lblLabel_mail.setBounds(36, 23, 42, 33);
		panel_Mess.add(lblLabel_mail);*/
		
		JLabel lblLabel_Apply = new JLabel("\u57FA\u672C\u4FE1\u606F\u4FEE\u6539\u7533\u8BF7\u6D88\u606F\u680F");
		lblLabel_Apply.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_Apply.setBounds(70, 72, 207, 28);
		add(lblLabel_Apply);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.setBounds(36, 72, 10, 28);
		add(panel_1_2);

	}
}