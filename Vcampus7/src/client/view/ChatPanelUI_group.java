package client.view;

import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import client.Sender;
import server.common.Chat;
import server.common.NameAndCardNum;
import server.common.OnlyCardNum;
import server.common.UniversalClass;
import server.communication.Message;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ChatPanelUI_group extends JPanel {
	private JTextArea textPaneSend;
	public JTable table_list2;//消息
	private JButton btnSend;
	public JScrollPane scrollPaneRecieve;
	private ChetMainUI b;
	private JTable table_list1;//成员
	private JScrollPane scrollPane_list;
	
	private String ob_name="";//对象姓名
	private String ob_ID="";//对象一卡通
	private String my_ID="";//我的一卡通
	private String grHost_ID="";//群主一卡通
	//private int grHost_r="";//群主一卡通


	/**
	 * @wbp.parser.constructor
	 */
	public ChatPanelUI_group(String t_name,String t_ID,String t_myID,ChetMainUI b) {
		ob_name=t_name;ob_ID=t_ID;my_ID=t_myID;this.b=b;
		setLayout(null);
		setBounds(0, 0, 1104,929);
		
		JSplitPane splitPaneChat = new JSplitPane();
		splitPaneChat.setResizeWeight(0.7);
		splitPaneChat.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPaneChat.setBounds(0, 59, 813, 870);
		add(splitPaneChat);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		JPanel panelSend = new JPanel();
		panelSend.setBackground(Color.WHITE);
		panelSend.setLayout(null);
		panelSend.setBorder(new LineBorder(Color.LIGHT_GRAY));
		splitPaneChat.setRightComponent(panelSend);
		
		JPanel panelSwitch = new JPanel();
		panelSwitch.setBackground(new Color(100, 149, 237));
		panelSwitch.setBounds(10, 0, 790, 40);
		panelSend.add(panelSwitch);
		panelSwitch.setLayout(null);
		
		JLabel lblLabel_tips = new JLabel("请输入：(每次输入内容≤30字)");
		lblLabel_tips.setFont(new Font("微软雅黑", Font.BOLD, 16));
		lblLabel_tips.setForeground(new Color(255, 255, 255));
		lblLabel_tips.setBounds(10, 10, 300, 20);
		panelSwitch.add(lblLabel_tips);
		
		ImageIcon Icon_history = new ImageIcon("picture/history.png");
		
		textPaneSend = new JTextArea();
		textPaneSend.setFont(new Font("宋体", Font.BOLD, 16));
		textPaneSend.setBounds(10, 41, 790, 163);
		panelSend.add(textPaneSend);
		
		JPanel panelRecieve = new JPanel();
		splitPaneChat.setLeftComponent(panelRecieve);
		panelRecieve.setLayout(null);
		
		ChatPanelUI_group a=this;
		btnSend = new JButton("\u53D1\u9001");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String context=textPaneSend.getText();
				if(context.length()>30) {
					JOptionPane.showMessageDialog(null, "消息长度超过30个字了", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					/*
					 * 发消息
					*/ 
					//Chat，构造函数4个参数分别为：用户一卡通，好友一卡通或群号，消息内容，第4个参数随便写。每条消息30字以内。
					Chat obj3=new Chat(my_ID,ob_ID,context,"空");
					Message msg3=new Message("sendMsg",obj3);
					Object temp3 = Sender.send(msg3);
					Message res3 = (Message)temp3;										
					while(res3.status.equals("100"));
					if(res3.status.equals("404")) {
						JOptionPane.showMessageDialog(null, "您已被移除群聊", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						a.setVisible(false);
					}
					else {//成功
						//JOptionPane.showMessageDialog(null, ((UniversalClass)res3.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
						//添加时间
						Date day=new Date();    
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
						String time=df.format(day);
						//添加到消息界面
						DefaultTableModel tableModel = (DefaultTableModel)table_list2.getModel();
						tableModel.addRow(new Object[]{"", time+"\n"+context});// 添加行
						table_list2.repaint();
						textPaneSend.setText("");
						int rowCount = table_list2.getRowCount();
						table_list2.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
						Rectangle rect = table_list2.getCellRect(rowCount-1, 0, true);
						table_list2.scrollRectToVisible(rect);
						//添加到消息列表中
						b.MessageGro.get(Integer.parseInt(b.mapGro.get(ob_ID))).add("my%"+time+"\n"+context);
						b.focusV=b.MessageGro.get(Integer.parseInt(b.mapGro.get(ob_ID)));
//						System.out.println(b.mapFri.get(ob_ID)); 
					}
					/*
					//添加消息
					DefaultTableModel tableModel = (DefaultTableModel)table_list2.getModel();
					tableModel.addRow(new Object[]{"", context});// 添加行
					table_list2.repaint();
					textPaneSend.setText("");
					int rowCount = table_list2.getRowCount();
					table_list2.getSelectionModel().setSelectionInterval(rowCount-1, rowCount-1);
					Rectangle rect = table_list2.getCellRect(rowCount-1, 0, true);
					table_list2.scrollRectToVisible(rect);*/	
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnSend.setBackground(new Color(135, 206, 250));
		btnSend.setBounds(698, 220, 103, 30);
		panelSend.add(btnSend);
		btnSend.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		scrollPaneRecieve = new JScrollPane();
		scrollPaneRecieve.setBounds(5, 10, 800, 583);
		panelRecieve.add(scrollPaneRecieve);
			
		//消息table
		class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {
			 
			  public MultiLineCellRenderer() {
			    setLineWrap(true);
			    setWrapStyleWord(true);
			    setOpaque(true);
			  }
			 
			  public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
				if(column==0){
					setForeground(Color.black);
					if(!value.toString().equals("")) {
			              setBackground(new Color(248,248,255));
					}
					else {
						setBackground(new Color(255,255,255));
					}
	            }else if(column==1){
	            	if(!value.toString().equals("")) {
			              setBackground(new Color(135, 206, 250));
			              setForeground(Color.white);
					}
	            	else {
	            		setBackground(new Color(255,255,255));
	            		setForeground(Color.black);
	            	}
	            }
	            else {
	            	setBackground(new Color(255,255,255));
	            	setForeground(Color.black);
	            	
	            }
				setFont(new Font("微软雅黑", Font.PLAIN, 16));
			    setText((value == null) ? "" : value.toString());
			    return this;
			  }
	    }
		DefaultTableModel dm = new DefaultTableModel() {
		      public Class getColumnClass(int column)
	            {
	                return getValueAt(0, column).getClass();
	            }
		};
		Object[][] data = new Object[0][2];
		String header[]= {"其他","我"};
		dm.setDataVector(data,header);
		int len_now=b.focusV.size();		
		//dm.setDataVector(new Object[][] { { "对于以直销方式为主的企业来说，人员推销的效果直接影响到产品能", "" }, { "", "是的\n没错" }, { "", "我们公司这种研发、生产和经营性企业需要面向市场，大量的高素质" } }, new Object[] { "其它", "我"});		 
	    table_list2 = new JTable(dm) {
	    	 @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	    };
	    table_list2.setFont(new Font("微软雅黑", Font.BOLD, 20));
	    table_list2.setRowHeight(70);
	    table_list2.setDefaultRenderer(String.class, new MultiLineCellRenderer());
	    table_list2.setShowHorizontalLines(false);
	    table_list2.setShowVerticalLines(false);
	    scrollPaneRecieve.setViewportView(table_list2);
	    
	    JPanel panelHead = new JPanel();
	    panelHead.setLayout(null);
	    panelHead.setBackground(new Color(37, 198, 254));
	    panelHead.setBounds(0, 0, 1102, 60);
	    add(panelHead);
	    
	    JLabel lblLabelHead = new JLabel(ob_name);
	    lblLabelHead.setForeground(Color.WHITE);
	    lblLabelHead.setFont(new Font("微软雅黑", Font.PLAIN, 20));
	    lblLabelHead.setBounds(20, 13, 357, 33);
	    panelHead.add(lblLabelHead);
	    
	    JPanel panel_list = new JPanel();
	    panel_list.setBackground(Color.WHITE);
	    panel_list.setBounds(810, 59, 292, 870);
	    add(panel_list);
	    panel_list.setLayout(null);
	    
	    ImageIcon Icon_man = new ImageIcon("picture/man2.png");
	    scrollPaneRecieve.getViewport().setBackground(Color.white);//设置背景色
	    
	    
	    //打印消息	    
	    for(int i=1;i<len_now;i++) {
			DefaultTableModel tableModel = (DefaultTableModel)table_list2.getModel();
			String t_str[]=b.focusV.get(i).split("%");
			String t="";
			for(int j=1;j<t_str.length;j++) {
				t+=t_str[j];
			}
			if(t_str[0].equals(ob_name)) {
				tableModel.addRow(new Object[]{t,""});
			}
			else {
				tableModel.addRow(new Object[]{"",t});
			}
			table_list2.repaint();//重绘
		}
	    
	    /*
		 * 群主一卡通
		 */
		OnlyCardNum obj2=new OnlyCardNum(ob_ID);
		Message msg2=new Message("getHost",obj2);
		Object temp2 = Sender.send(msg2);
		Message res2 = (Message)temp2;										
		while(res2.status.equals("100"));
		if(res2.status.equals("404")) {
			JOptionPane.showMessageDialog(null, "获取群主一卡通失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {//成功
			grHost_ID=((OnlyCardNum)res2.response[0]).cardNum;
		}
	    
	    //群成员
	    scrollPane_list = new JScrollPane();
	    scrollPane_list.setBounds(10, 10, 272, 850);
	    
	    /*
		 * 传递群成员，群成员列表
		 */
		//*************************所有群成员接口
		OnlyCardNum obj=new OnlyCardNum(ob_ID);
		Message msg=new Message("groupMembers",obj);
		Object temp = Sender.send(msg);
		Message res = (Message)temp;
		
		int cnt=res.num;
		Object[][] data1 = new Object[cnt][3];
		
		while(res.status.equals("100"));
		if(res.status.equals("404")) {
			JOptionPane.showMessageDialog(null, "群成员列表获取失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			for(int i=0;i<cnt;i++) {
				NameAndCardNum tem=(NameAndCardNum)res.response[i];
				data1[i][0]=tem.name;//姓名
				data1[i][1]=tem.cardNum;//一卡通
				if(tem.cardNum.equals(grHost_ID)) {
					data1[i][2]="群主";
				}
				else {
					data1[i][2]="踢出群聊";
				}
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
		String header1[]= {"群成员","一卡通","操作"};
		/*int x=30;
		Object[][] data1 = new Object[x][3];
		for(int i=0;i<x;i++)
		{
			data1[i][0]="崔";
			data1[i][1]="213191948";
			data1[i][2]="踢出群聊";
		}*/
		model1.setDataVector(data1, header1);
		table_list1 = new JTable(model1)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		//list1成员列表
		DefaultTableCellRenderer r1=new DefaultTableCellRenderer();
		r1.setHorizontalAlignment(JLabel.CENTER);//居中显示
		table_list1.setDefaultRenderer(Object.class, r1);
		table_list1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table_list1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		table_list1.setRowHeight(40);
		table_list1.setShowVerticalLines(false);
		panel_list.add(scrollPane_list);


		table_list1.getTableHeader().setResizingAllowed(true);
		table_list1.getTableHeader().setBackground(new Color(135, 206, 250));
		table_list1.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 16));
		Dimension size1 = table_list1.getTableHeader().getPreferredSize();
		size1.height = 25;//设置新的表头高度
		table_list1.getTableHeader().setPreferredSize(size1);
		table_list1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//单击编辑列
				int c=table_list1.getSelectedColumn();
				int r=table_list1.getSelectedRow();
				String t_name=table_list1.getValueAt(r, 0).toString();
				String t_ID=table_list1.getValueAt(r, 1).toString();  
				if(c==2)
				{//踢出群聊
					if(grHost_ID.equals(my_ID)) {//判断是不是群主
						if(t_ID.equals(my_ID)) {//群主选中自己，无事发生							
						}
						else {//群主选别人
							int yn=JOptionPane.showConfirmDialog(null, "是否将该成员踢出群聊！", "请确认",JOptionPane.YES_NO_OPTION);//选择是则yn等于0  选择否yn等于1
							if(yn==JOptionPane.YES_OPTION) {
								/*
								 * 传递消息
								 */
								Chat obj1=new Chat(ob_ID,t_ID,"空","空");
								Message msg1=new Message("deleteMembers",obj1);
								Object temp1 = Sender.send(msg1);
								Message res1 = (Message)temp1;										
								while(res1.status.equals("100"));
								if(res1.status.equals("404")) {
									JOptionPane.showMessageDialog(null, "踢出群聊失败", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
								}
								else {//成功
									JOptionPane.showMessageDialog(null, ((UniversalClass)res1.response[0]).context, "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
									//踢出群聊
									DefaultTableModel tableModel = (DefaultTableModel) table_list1.getModel();
									tableModel.removeRow(r);// 删除行
									table_list1.repaint();
								}			
							}
						}
					}
					else {//不是群主
						JOptionPane.showMessageDialog(null, "您没有权限", "提示(｡･ω･｡)ﾉ♡", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
	    scrollPane_list.setViewportView(table_list1);
	    panel_list.add(scrollPane_list);
	    

		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI_group(LayoutManager layout) {
		super(layout);
		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI_group(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI_group(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
}
