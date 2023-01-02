package client.view;

import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import client.*;
import server.common.*;
import client.view.MainPanelUI.paneDate;
import server.common.GradeClass;
import server.common.OnlyCardNum;
import server.communication.Message;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.Icon;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.util.Vector;
import java.util.Calendar;  
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;  
import java.util.TimerTask;

public class ChetMainUI extends JPanel {
	//private JScrollPane scrollPanelFriend;
	private JPanel PanelFriend;
	public JTable table_list1;//好友
	public JTable table_list2;//群组
	private JPanel panel_friend;
	private JPanel panel_group;
	private JLabel lblLabel_friend;
	private JLabel lblLabel_group;
	private JScrollPane scrollPane_list;
	private JPanel panelChat;
	public String name="崔致远";
	public String ID="213191956";
	private JLabel lblLabel_add;
	private String focusD;
	public Vector<String> focusV;
	public boolean Gro;
	public Vector<Vector<String>> MessageFri;//好友消息
	public Vector<Vector<String>> MessageGro;//群聊消息
	public Vector<Chat> MessageNot;//群聊消息
	public Object[][] data1;
	public Object[][] data2;
	public Map<String,String> mapFri;
	public Map<String,String> mapGro;
	private JLabel lblLabel_apply;
	
	private ChatPanelUI chatPanel;
	private ChatPanelUI_group chatPanel_group;
	/**
	 * @wbp.parser.constructor
	 */
	public ChetMainUI(String t_name,String t_ID) {
		MessageFri=new Vector<Vector<String>>();
		MessageGro=new Vector<Vector<String>>();
		MessageNot=new Vector<Chat>();
		focusV=new Vector<String>();
		
		name=t_name;ID=t_ID;
		Gro=false;
		setBounds(0, 0, 1405,929);
		setLayout(null);
		mapFri=new HashMap<String,String>();
		mapGro=new HashMap<String,String>();
		/*ChatPanelUI panelChat = new ChatPanelUI();
		panelChat.setBounds(301, 0, 1104, 929);
		add(panelChat);
		panelChat.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 4, 290, 919);
		tabbedPane.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		tabbedPane.setBorder(null);
		add(tabbedPane);
		scrollPanelFriend = new JScrollPane();
		tabbedPane.addTab("\u8054\u7CFB\u4EBA\u5217\u8868", null, scrollPanelFriend, null);
		*/
		panelChat = new Chatbackground();
		panelChat.setBounds(301, 0, 1104, 929);
		add(panelChat);
		panelChat.setLayout(null);
		
		//成员列表
		PanelFriend = new JPanel();
		PanelFriend.setBackground(Color.WHITE);
		PanelFriend.setBounds(5, 4, 290, 919);
		//tabbedPane.addTab("\u8054\u7CFB\u4EBA\u5217\u8868", null, PanelFriend, null);
		PanelFriend.setLayout(null);
		add(PanelFriend);
		
		//好友按钮
		panel_friend = new JPanel();
		panel_friend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabel_friend.setForeground(new Color(100, 149, 237));
				lblLabel_group.setForeground(Color.black);
				scrollPane_list.setViewportView(table_list1);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_friend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_friend.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_friend.setBackground(new Color(255, 255, 255));
			}
		});
		panel_friend.setBackground(new Color(255, 255, 255));
		panel_friend.setBounds(0, 0, 90, 30);
		PanelFriend.add(panel_friend);
		panel_friend.setLayout(null);
		
		lblLabel_friend = new JLabel("好友");
		lblLabel_friend.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLabel_friend.setForeground(new Color(100, 149, 237));
		lblLabel_friend.setBounds(29, 5, 34, 15);
		panel_friend.add(lblLabel_friend);
		//群组按钮
		panel_group = new JPanel();
		panel_group.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblLabel_friend.setForeground(Color.black);
				lblLabel_group.setForeground(new Color(100, 149, 237));
				scrollPane_list.setViewportView(table_list2);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_group.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				panel_group.setBackground(new Color(248, 248, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_group.setBackground(new Color(255, 255, 255));
			}
		});
		panel_group.setBackground(Color.WHITE);
		panel_group.setBounds(91, 0, 90, 30);
		PanelFriend.add(panel_group);
		panel_group.setLayout(null);
		
		lblLabel_group = new JLabel("群聊");
		lblLabel_group.setForeground(new Color(0, 0, 0));
		lblLabel_group.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLabel_group.setBounds(28, 5, 34, 15);
		panel_group.add(lblLabel_group);
		
		
		scrollPane_list = new JScrollPane();
		scrollPane_list.setBounds(0, 32, 285, 849);
		PanelFriend.add(scrollPane_list);
		
		/*
		 * 获得好友列表和群组列表
		 */
		//*************************所有好友接口
		OnlyCardNum obj=new OnlyCardNum(ID);
		Message msg=new Message("getFriends",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		
		int cnt=res.num;
		Icon Icon1 = new ImageIcon("picture/openmail.png");
		Object[][] data1 = new Object[cnt][3];
		
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			//JOptionPane.showMessageDialog(null, "好友列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				Chat tem=(Chat)res.response[i];
				data1[i][0]=tem.str2;//姓名
				data1[i][1]=tem.str1;//一卡通
				data1[i][2]=Icon1;
				mapFri.put(tem.str1,Integer.toString(i));//对好友的map和vector添加项
				Vector<String> temV=new Vector<String>();
				temV.add(tem.str2);
				MessageFri.add(temV);
				
			}
		}
		
		//********************所有群组接口
		Message msg1=new Message("getGroup",obj);
		Object temp1 = Sender.send(msg1);
		Message res1 = (Message)temp1;
		
		int cnt1=res1.num;
		Object[][] data2 = new Object[cnt1][3];
		
		while(res1.status.equals("100"));
		if(res1.status.equals("404")) {
			//JOptionPane.showMessageDialog(null, "群聊列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt1;i++) {
				Chat tem=(Chat)res1.response[i];
				data2[i][0]=tem.str2;//群名
				data2[i][1]=tem.str1;//群号
				data2[i][2]=Icon1;
				
				mapGro.put(tem.str1,Integer.toString(i));//对群的map和vector添加项
				Vector<String> temV=new Vector<String>();
				temV.add(tem.str2);
				MessageGro.add(temV);
			}
		}
		

		//成员列表
		DefaultTableModel model1 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		DefaultTableModel model2 = new DefaultTableModel()	
		{
			public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
		};
		String header1[]= {"好友","一卡通","消息"};
		String header2[]= {"群组","群号","消息"};
		/*int x=30;
		data1 = new Object[x][3];
		data2 = new Object[x][3];
		Icon Icon1 = new ImageIcon("picture/openmail.png");

		for(int i=0;i<x;i++)
		{
			data1[i][0]="崔";
			data1[i][1]="213191948";
			data1[i][2]=Icon1;
			data2[i][0]="张";
			data2[i][1]="18";
			data2[i][2]=Icon1;

		}*/
		model1.setDataVector(data1, header1);
		table_list1 = new JTable(model1)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		model2.setDataVector(data2, header2);
		table_list2 = new JTable(model2)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		//list1好友
		DefaultTableCellRenderer r1=new DefaultTableCellRenderer();
		r1.setHorizontalAlignment(JLabel.CENTER);//居中显示
		table_list1.setDefaultRenderer(Object.class, r1);
		scrollPane_list.setViewportView(table_list1);
		scrollPane_list.getViewport().setBackground(Color.white);//设置背景色
		table_list1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list1.setRowHeight(80);
		table_list1.setShowVerticalLines(false);

		table_list1.getTableHeader().setResizingAllowed(true);
		table_list1.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list1.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size1 = table_list1.getTableHeader().getPreferredSize();
		size1.height = 25;//设置新的表头高度
		table_list1.getTableHeader().setPreferredSize(size1);
		
		//list2群组
		table_list2.setDefaultRenderer(Object.class, r1);
		table_list2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list2.setRowHeight(80);
		table_list2.setShowVerticalLines(false);

		table_list2.getTableHeader().setResizingAllowed(true);
		table_list2.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list2.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size2 = table_list2.getTableHeader().getPreferredSize();
		size2.height = 25;//设置新的表头高度
		table_list2.getTableHeader().setPreferredSize(size2);
		
		ChetMainUI b=this;
		//点击会话
		table_list1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list1.getSelectedColumn();
				int r=table_list1.getSelectedRow();
				String t_name=table_list1.getValueAt(r, 0).toString();//好友姓名
				String t_ID=table_list1.getValueAt(r, 1).toString();  //好友一卡通
				if(c==2)
				{//对话消息
					focusD=t_ID;
					Gro=false;
					focusV=MessageFri.get(Integer.parseInt(mapFri.get(focusD)));
					panelChat.setVisible(false);
					chatPanel=new ChatPanelUI(t_name,t_ID,ID,b);//好友姓名、一卡通、我的一卡通
					
					panelChat = chatPanel;
					panelChat.setBounds(301, 0, 1104, 929);
					add(panelChat);
					repaint();
					table_list1.setValueAt(Icon1, r, 2);
					table_list1.repaint();
				}
			}
		});
		
		//点击会话
		table_list2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list2.getSelectedColumn();
				int r=table_list2.getSelectedRow();
				String t_name=table_list2.getValueAt(r, 0).toString();
				String t_ID=table_list2.getValueAt(r, 1).toString();
				if(c==2)
				{//对话消息
					focusD=t_ID;
					Gro=true;
					focusV=MessageGro.get(Integer.parseInt(mapGro.get(focusD)));
					panelChat.setVisible(false);
					chatPanel_group=new ChatPanelUI_group(t_name,t_ID,ID,b);

					panelChat = chatPanel_group;
					panelChat.setBounds(301, 0, 1104, 929);
					add(panelChat);
					repaint();
					table_list2.setValueAt(Icon1, r, 2);
					table_list2.repaint();
				}
			}
		});		
		//添加好友或创建群聊
		//lblLabel_add = new JLabel(Icon_add);
		ChetMainUI a=this;
		lblLabel_add = new JLabel("+");
		lblLabel_add.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabel_add.setFont(new Font("微软雅黑", Font.BOLD, 26));
		lblLabel_add.setToolTipText("加好友、群/创建群聊");
		lblLabel_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddOrCreateUI(name,ID,a).setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_add.setBounds(260, 0, 25, 25);
		PanelFriend.add(lblLabel_add);
		
		
		lblLabel_apply = new JLabel("≡");
		lblLabel_apply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new	ApplyMessUI(b).setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLabel_apply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblLabel_apply.setToolTipText("申请消息");
		lblLabel_apply.setFont(new Font("微软雅黑", Font.BOLD, 26));
		lblLabel_apply.setBounds(234, 2, 25, 25);
		PanelFriend.add(lblLabel_apply);
		
		timer2(a);
		// TODO 自动生成的构造函数存根
	}

	public ChetMainUI(LayoutManager layout) {
		super(layout);
		// TODO 自动生成的构造函数存根
	}

	public ChetMainUI(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public ChetMainUI(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
	public void timer2(ChetMainUI b) {  
        Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            public void run() {  
        		Icon Icon2 = new ImageIcon("picture/mail.png");
        		Icon Icon1 = new ImageIcon("picture/openmail.png");
                //System.out.println("-------设定要指定任务--------");  
                OnlyCardNum obj=new OnlyCardNum(ID);
    			Message msg3=new Message("applicationRes",obj);
    			Object temp3 = Sender.send(msg3);
    			Message res3 = (Message)temp3;
    			int cnt3=res3.num;
    			while(res3.status.equals("100"));
    			if(res3.status.equals("404")) {
    				//JOptionPane.showMessageDialog(null, "好友列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
    			}
    			else {
    				for(int i=0;i<cnt3;i++)
    				{
    					Chat tem=(Chat)res3.response[i];
    					MessageNot.add(tem);
    					
    					if(tem.str1.equals("好友申请结果")) {//Exit_time.indexOf(t_string)!=-1
    						//System.out.println("-------设定要指定任务--------");  
    						if(tem.str2.indexOf("通过")!=-1) {//对方同意好友申请
    							DefaultTableModel tableModel = (DefaultTableModel)table_list1.getModel(); 
        						tableModel.addRow(new Object[] {tem.str3,tem.str4,Icon2});
        						table_list1.repaint(); 
        						//映射
    							mapFri.put(tem.str4,Integer.toString(MessageFri.size()));
    							Vector<String> temV=new Vector<String>();
    							temV.add(tem.str3);
    							MessageFri.add(temV);     						
    						}
    					}
    					else if(tem.str1.equals("入群申请结果")) {
    						if(tem.str2.indexOf("通过")!=-1) {//对方同意群聊申请
    							DefaultTableModel tableModel = (DefaultTableModel)table_list2.getModel(); 
        						tableModel.addRow(new Object[] {tem.str3,tem.str4,Icon2});
        						table_list2.repaint(); 
        						//映射 一卡通、
    							mapGro.put(tem.str4,Integer.toString(MessageGro.size()));
    							Vector<String> temV=new Vector<String>();
    							temV.add(tem.str3);
    							MessageGro.add(temV);
    						}
    					}
    				}
    			}
    			/*处理接收到的通知消息
    			 * MessageNot是未处理的消息
    			 * */
    			
    			Message msg4=new Message("msgRes",obj);
    			Object temp4 = Sender.send(msg4);
    			Message res4 = (Message)temp4;
    			int cnt4=res4.num;
    			boolean flag=false;//用于标记当前页面消息是否更新
    			
    			while(res4.status.equals("100"));
    			if(res4.status.equals("404")) {
    				//JOptionPane.showMessageDialog(null, "好友列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
    			}
    			else 
    			{
    				for(int i=0;i<cnt4;i++)
    				{
    					Chat tem=(Chat)res4.response[i];
    					if(tem.str1.equals(focusD))
    						flag=true;
    					if(mapFri.get(tem.str1) != null)
    					{
    						int indx=Integer.parseInt(mapFri.get(tem.str1));//把map映射的下标地址String转成int
    						MessageFri.get(indx).add(tem.str2+"%"+tem.str3+"\n"+tem.str4);//用%分割人名和内容，内容中时间和消息用\n分割
    						DefaultTableModel tableModel = (DefaultTableModel)table_list1.getModel(); 
    						tableModel.setValueAt(Icon2,indx,2);
    						table_list1.repaint(); 
    						//System.out.println(flag);
    						if(flag)
    						{
    							//System.out.println("test");
    							tableModel.setValueAt(Icon1,indx,2);
    							table_list1.repaint(); 
    							focusV=MessageFri.get(indx);
    							DefaultTableModel t_tableModel = (DefaultTableModel)chatPanel.table_list2.getModel();					
    							if(name.equals(tem.str2)) {
    								t_tableModel.addRow(new Object[]{"", tem.str3+"\n"+tem.str4});// 添加行
    								chatPanel.table_list2.repaint();
    							}
    							else {
    								t_tableModel.addRow(new Object[]{tem.str3+"\n"+tem.str4,""});// 添加行
    								chatPanel.table_list2.repaint();
    							}
    							int rowCount = chatPanel.table_list2.getRowCount();
    							chatPanel.table_list2.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
    							Rectangle rect = chatPanel.table_list2.getCellRect(rowCount-1, 0, true);
    							chatPanel.table_list2.scrollRectToVisible(rect);
    						}
    					}
    					else
    					{
    						if(mapGro.get(tem.str1)!=null)
    						{
    							int indx=Integer.parseInt(mapGro.get(tem.str1));//把map映射的下标地址String转成int
    							MessageGro.get(indx).add(tem.str2+"%"+tem.str3+"\n"+tem.str4);//用%分割人名和内容，内容中时间和消息用\n分割
    							DefaultTableModel tableModel = (DefaultTableModel)table_list2.getModel(); 
    							tableModel.setValueAt(Icon2,indx,2);
    							table_list2.repaint();
        						if(flag)
        						{
        							tableModel.setValueAt(Icon1,indx,2);
        							table_list2.repaint(); 
        							focusV=MessageGro.get(indx);
        							DefaultTableModel t_tableModel = (DefaultTableModel)chatPanel_group.table_list2.getModel();					
        							if(name.equals(tem.str2)) {
        								t_tableModel.addRow(new Object[]{"", tem.str3+"\n"+tem.str4});// 添加行
        								chatPanel_group.table_list2.repaint();
        							}
        							else {
        								t_tableModel.addRow(new Object[]{tem.str3+"\n"+tem.str4,""});// 添加行
        								chatPanel_group.table_list2.repaint();
        							}
        							int rowCount = chatPanel_group.table_list2.getRowCount();
        							chatPanel_group.table_list2.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
        							Rectangle rect = chatPanel_group.table_list2.getCellRect(rowCount-1, 0, true);
        							chatPanel_group.table_list2.scrollRectToVisible(rect);
        						}
    						}
    					}
    				}

    			}
    			/*处理接收到的聊天消息
    			 * 
    			 * flag=true
    			 * 重绘当前对话框
    			 * false
    			 * 列表显示新消息
    			 * */
               /* if(Gro) {
                	//群聊界面
                }
                else {
                	//focusV=MessageFri.get(Integer.parseInt(mapFri.get(focusD)));
                	if(focusV.size()!=0) {
        				panelChat.setVisible(false);
        				//chatPanel.table_list2.re
        				panelChat = new ChatPanelUI(focusV.get(0),focusD,ID,b);//好友姓名、一卡通、我的一卡通
        				panelChat.setBounds(301, 0, 1104, 929);
        				add(panelChat); 
        				//panelChat.table_list2
        				b.repaint();
                	}
                }*/
    			
            }  
        }, 0, 3000);  
    }
}
