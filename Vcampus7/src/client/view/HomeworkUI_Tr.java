package client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import client.Sender;
import server.common.GetFile;
import server.common.GradeClass;
import server.communication.Message;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.Sender;
import server.common.SendFile;
import server.common.UniversalClass;
import server.common.comment;
import server.communication.Message;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class HomeworkUI_Tr extends JPanel {
	private String name="崔致远";
	private String ID="213190973";
	private String st_ID="213190973";
	private String filepath="C:/";
	private JTable table_list;
	private JLabel lblLabel_path;

	/**
	 * Create the panel.
	 */
	public HomeworkUI_Tr(String t_name,String t_ID) {
		name=t_name;ID=t_ID;
		
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBackground(Color.WHITE);
		setSize(1290, 820);
		setLayout(null);
		
		ImageIcon images = new ImageIcon("picture/homework1.jpg");
		
		ImageIcon images1 = new ImageIcon("picture/message.jpg");
		
		//******************************************************************************************************************
		JPanel panel_homeworklist = new JPanel();
		panel_homeworklist.setBackground(new Color(255, 255, 255));
		panel_homeworklist.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_homeworklist.setBounds(51, 527, 1165, 266);
		add(panel_homeworklist);
		panel_homeworklist.setLayout(null);
		
		
		JLabel lblLabel_basicEdit = new JLabel("保存");
		lblLabel_basicEdit.setForeground(new Color(135, 206, 250));
		lblLabel_basicEdit.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblLabel_basicEdit.setBounds(863, 514, 54, 27);
		panel_homeworklist.add(lblLabel_basicEdit);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(20, 10, 10, 29);
		panel_homeworklist.add(panel_1_1);
		
		JLabel lblLabel_comment = new JLabel("评语");
		lblLabel_comment.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_comment.setBounds(40, 12, 44, 26);
		panel_homeworklist.add(lblLabel_comment);
		
		JLabel lblLabel_st = new JLabel("学生：213191956");
		lblLabel_st.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_st.setBounds(94, 13, 156, 26);
		panel_homeworklist.add(lblLabel_st);
		
		JTextArea textArea_comment = new JTextArea();
		textArea_comment.setWrapStyleWord(true);
		textArea_comment.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textArea_comment.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))); 
		textArea_comment.setBounds(20, 49, 1100, 196);
		panel_homeworklist.add(textArea_comment);
		
		//******************************************************************************************************************
		JPanel panel_comment = new JPanel();
		panel_comment.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_comment.setBackground(new Color(255, 255, 255));
		panel_comment.setBounds(51, 82, 1165, 417);
		add(panel_comment);
		panel_comment.setLayout(null);
		
		String obj=new String(ID);
		Message msg=new Message("gethomework",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		int cnt=res.num;
		Object[][] data = new Object[cnt][3];
		
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			JOptionPane.showMessageDialog(null, ((UniversalClass)res.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				//System.out.println(((GradeClass)res.response[i]).cardNum+((GradeClass)res.response[i]).courseId+((GradeClass)res.response[i]).score);
				comment tem=(comment)res.response[i];
				data[i][0]=tem.cardNum;
				data[i][1]="点击下载";
				data[i][2]="写评语";
			}
		}
		
		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		String header1[]= {"一卡通号","下载","评语"};
		/*Object[][] data = new Object[30][3];
		for(int i=0;i<30;i++)
		{
			data[i][0]="213191948";
			data[i][1]="下载";
			data[i][2]="评语";

		}*/
		model1.setDataVector(data, header1);
		JScrollPane scrollPane_list = new JScrollPane();
		scrollPane_list.setBounds(20, 49, 1100, 358);
		panel_comment.add(scrollPane_list);
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
		scrollPane_list.setViewportView(table_list);
		scrollPane_list.getViewport().setBackground(Color.white);//设置背景色
		table_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list.setRowHeight(30);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(100, 149, 237));
		panel_2.setBounds(20, 10, 10, 29);
		panel_comment.add(panel_2);
		
		JLabel lblLabel_List = new JLabel("作业列表");
		lblLabel_List.setFont(new Font("微软雅黑", Font.BOLD, 18));
		lblLabel_List.setBounds(40, 12, 89, 26);
		panel_comment.add(lblLabel_List);
		
		JButton btnNewButton = new JButton("选择文件保存路径");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setCurrentDirectory(new File("."));
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.showOpenDialog(table_list);//是否打开文件选择框
				filepath = chooser.getSelectedFile().getAbsolutePath();//获取绝对路径
				lblLabel_path.setText(filepath);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(132, 16, 150, 23);
		panel_comment.add(btnNewButton);
		
		
		
		JLabel lblLabel_3 = new JLabel("记得看提交的作业哦！");
		lblLabel_3.setBounds(187, 42, 148, 30);
		add(lblLabel_3);
		lblLabel_3.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		JLabel lblLabel_image1 = new JLabel(images1);
		lblLabel_image1.setBounds(49, 31, 100, 41);
		add(lblLabel_image1);
		lblLabel_image1.setBackground(new Color(240, 255, 255));
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
		lblLabel_path = new JLabel(filepath);
		lblLabel_path.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_path.setBounds(303, 13, 672, 26);
		panel_comment.add(lblLabel_path);
		//点击阅读
		table_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list.getSelectedColumn();
				int r=table_list.getSelectedRow();
				//String t_name=table_list.getValueAt(r, 0).toString();
				String t_ID=table_list.getValueAt(r, 0).toString();//学生一卡通
				if(c==1)
				{//下载				
					GetFile obj1=new GetFile(filepath,t_ID);
					Message msg1 = new Message("getFile", obj1);
			        Object temp1 = Sender.send(msg1);
					Message res1 = (Message)temp1;
					while(res1.status.equals("100"));
					if(res1.status.equals("404")) {
						JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "保存成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if(c==2) {//写评语
					String comment=textArea_comment.getText();
					if(comment=="") {
						JOptionPane.showMessageDialog(null, "亲，评语不能为空", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}else {
						comment obj2=new comment(t_ID,ID,comment);
						Message msg2 = new Message("comment", obj2);
				        Object temp2 = Sender.send(msg2);
						Message res2 = (Message)temp2;
						while(res2.status.equals("100"));
						if(res2.status.equals("404")) {
							JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "亲，评语提交成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});

	}
}
