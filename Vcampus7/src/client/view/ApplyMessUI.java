package client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import client.Sender;
import server.common.Chat;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ApplyMessUI extends JFrame {

	private JPanel contentPane;
	private JTable table_list;
	private ChetMainUI a;
	private ApplyMessUI c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyMessUI frame = new ApplyMessUI(new ChetMainUI("崔","213191956"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ApplyMessUI(ChetMainUI a) {
		this.a=a;
		c=this;
		setTitle("申请信息");
		this.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e)
	          {
					//********************关闭信号接口
	        	    OnlyCardNum obj=new OnlyCardNum(a.ID);
					Message msg1=new Message("typeBack",obj);
					Object temp1 = Sender.send(msg1);
					 Message res1 = (Message)temp1;							
					while(res1.status.equals("100"));
					if(res1.status.equals("404")) {
						//JOptionPane.showMessageDialog(null, "返回是否已读失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						//JOptionPane.showMessageDialog(null, "返回是否已读成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
					a.MessageNot.clear();
	        	  //System.out.println("test");
	        	  setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        	  
	          }
	      });
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1070, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_list = new JScrollPane();
		scrollPane_list.setBounds(0, 0, 1056, 499);
		contentPane.add(scrollPane_list);
		
		
		
		//成员列表
		class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
			 
			  public MultiLineCellRenderer() {
			    setLineWrap(true);
			    setWrapStyleWord(true);
			    setOpaque(true);
			  }
			 
			  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
				setFont(new Font("微软雅黑", Font.PLAIN, 12));
			    setText((value == null) ? "" : value.toString());
			    return this;
			  }
		}
		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};		
		String header1[]= {"消息类型","申请人姓名","申请人ID","申请ID","内容","操作","操作"};
		int x=30;
		Object[][] data1 = new Object[0][7];
		Icon Icon1 = new ImageIcon("picture/openmail.png");
		model1.setDataVector(data1, header1);
		table_list = new JTable(model1)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		//list
		table_list.setDefaultRenderer(Object.class, new MultiLineCellRenderer());
		scrollPane_list.setViewportView(table_list);
		scrollPane_list.getViewport().setBackground(Color.white);//设置背景色
		table_list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list.setRowHeight(80);
		//table_list.setShowVerticalLines(false);

		table_list.getTableHeader().setResizingAllowed(true);
		table_list.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size1 = table_list.getTableHeader().getPreferredSize();
		size1.height = 25;//设置新的表头高度
		table_list.getTableHeader().setPreferredSize(size1);
		scrollPane_list.setViewportView(table_list);
		//设置列宽
		TableColumn Column_look = table_list.getColumnModel().getColumn(4);
		Column_look.setPreferredWidth(500);
		Column_look.setMaxWidth(500);
		Column_look.setMinWidth(500);		
		
		Icon Icon2 = new ImageIcon("picture/mail.png");	
		//点击会话
		table_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list.getSelectedColumn();
				int r=table_list.getSelectedRow();
				String t_class=table_list.getValueAt(r, 0).toString();//类别
				String t_ID=table_list.getValueAt(r, 2).toString();  //一卡通
				String t_MessID=table_list.getValueAt(r, 3).toString();//申请ID
				String t_name=table_list.getValueAt(r, 1).toString();  //姓名
				if(t_class.equals("好友申请")) {
					if(c==5) {//同意
						UniversalClass obj1=new UniversalClass(t_MessID);
						Message msg1=new Message("passFriends",obj1);
						Object temp1 = Sender.send(msg1);
						Message res1 = (Message)temp1;										
						while(res1.status.equals("100"));
						if(res1.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "操作失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//成功
							JOptionPane.showMessageDialog(null, "操作成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							//添加消息
							DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
							tableModel.removeRow(r);//删除
							table_list.repaint();
							a.MessageNot.remove(r);//删除下标元素
							
							//好友表增加
							DefaultTableModel tableModel1 = (DefaultTableModel)a.table_list1.getModel();
							tableModel1.addRow(new Object[]{t_name, t_ID,Icon2});
							//映射
							a.mapFri.put(t_ID,Integer.toString(a.MessageFri.size()));
							Vector<String> temV=new Vector<String>();
							temV.add(t_name);
							a.MessageFri.add(temV);

						}
					}
					else if(c==6) {//拒绝
						UniversalClass obj1=new UniversalClass(t_MessID);
						Message msg2=new Message("refuseApply",obj1);
						Object temp2 = Sender.send(msg2);
						Message res2 = (Message)temp2;										
						while(res2.status.equals("100"));
						if(res2.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "操作失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//成功
							JOptionPane.showMessageDialog(null, "操作成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							//添加消息
							DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
							tableModel.removeRow(r);//删除
							table_list.repaint();
							a.MessageNot.remove(r);//删除下标元素
						}
					}
				}
				else if(t_class.equals("加群申请")) {
					if(c==5) {//同意
						UniversalClass obj1=new UniversalClass(t_MessID);
						Message msg1=new Message("passGroup",obj1);
						Object temp1 = Sender.send(msg1);
						Message res1 = (Message)temp1;										
						while(res1.status.equals("100"));
						if(res1.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "操作失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//成功
							JOptionPane.showMessageDialog(null, "操作成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							//添加消息
							DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
							tableModel.removeRow(r);//删除
							table_list.repaint();
							a.MessageNot.remove(r);//删除下标元素							
							//群表增加
							//DefaultTableModel tableModel1 = (DefaultTableModel)a.table_list2.getModel();
							//tableModel1.addRow(new Object[]{t_name, t_ID,Icon2});							
							//映射
							//a.mapGro.put(t_ID,Integer.toString(a.MessageGro.size()));
							//Vector<String> temV=new Vector<String>();
							//temV.add(t_name);
							//a.MessageGro.add(temV);
						}
					}
					else if(c==6) {//拒绝
						UniversalClass obj1=new UniversalClass(t_MessID);
						Message msg2=new Message("refuseApply",obj1);
						Object temp2 = Sender.send(msg2);
						Message res2 = (Message)temp2;										
						while(res2.status.equals("100"));
						if(res2.status.equals("404")) {
							JOptionPane.showMessageDialog(null, "操作失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						}
						else {//成功
							JOptionPane.showMessageDialog(null, "操作成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
							//添加消息
							DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
							tableModel.removeRow(r);//删除
							table_list.repaint();
							a.MessageNot.remove(r);//删除下标元素
						}
					}		
				}
				else {
					if(c==5) {//删除
						JOptionPane.showMessageDialog(null, "操作成功", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						//添加消息
						DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
						tableModel.removeRow(r);//删除
						table_list.repaint();
						a.MessageNot.remove(r);//删除下标元素
					}
				}
			}
		});
		int len=a.MessageNot.size();
		for(int i=0;i<len;i++)
		{
			DefaultTableModel tableModel = (DefaultTableModel)table_list.getModel();
			Chat tem=a.MessageNot.get(i);
			String t_IDAndName[]=tem.str2.split("%");
			if(tem.str1.equals("好友申请")||tem.str1.equals("加群申请")) {//申请
				tableModel.addRow(new Object[]{tem.str1, t_IDAndName[1],t_IDAndName[0],tem.str4,"事由："+tem.str3,"\n\n          同意","\n\n          拒绝"});// 添加行
				table_list.repaint();
			}
			else {//申请结果
				tableModel.addRow(new Object[]{tem.str1, tem.str2,"","","","删除",""});// 添加行
				table_list.repaint();
			}
		}
		
	}

}
