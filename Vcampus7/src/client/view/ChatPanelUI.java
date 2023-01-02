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

public class ChatPanelUI extends JPanel {
	private JScrollPane scrollPane_list;
	private JTable table_list1;//成员
	private JTextArea textPaneSend;
	public JTable table_list2;//消息
	
	private String ob_name="";//对象姓名
	private String ob_ID="";//对象一卡通
	private String my_ID="";//我的一卡通
	private String grHost_ID="";//群主一卡通
	//private int grHost_r="";//群主一卡通
	private JButton btnSend;
	public JScrollPane scrollPaneRecieve;
	private ChetMainUI b;

	/**
	 * @wbp.parser.constructor
	 */
	public ChatPanelUI(String t_name,String t_ID,String t_myID,ChetMainUI b) {
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
		
		ChatPanelUI a=this;
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
						b.MessageFri.get(Integer.parseInt(b.mapFri.get(ob_ID))).add("my%"+time+"\n"+context);
						b.focusV=b.MessageFri.get(Integer.parseInt(b.mapFri.get(ob_ID)));
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
	    panel_list.setLayout(null);
	    panel_list.setBackground(Color.WHITE);
	    panel_list.setBounds(810, 59, 292, 870);
	    add(panel_list);
	    
	    ImageIcon Icon_man = new ImageIcon("picture/man3.jpg");
		JLabel lblLabel_background = new JLabel(Icon_man);
	    lblLabel_background.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLabel_background.setBounds(0, 0, 292, 870);
	    panel_list.add(lblLabel_background);
	    scrollPaneRecieve.getViewport().setBackground(Color.white);//设置背景色    
	    
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

		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI(LayoutManager layout) {
		super(layout);
		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public ChatPanelUI(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}
}
