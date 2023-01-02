package client.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import client.Sender;
import server.common.CommentGood;
import server.common.OnlyCardNum;
import server.communication.Message;


//import server.common.Bookshow;

public class SMpinglun extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SMpinglun frame = new SMpinglun("1");
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
	public SMpinglun(String number) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTable table_3 = new JTable();

		

		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"姓名", "评论"
			}
		));
		DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
	
		 TableColumn column = table_3.getColumnModel().getColumn( 0 );//取第一列
		  column.setPreferredWidth(100);
		  column.setMaxWidth(100);
		  column.setMinWidth( 100);
		table_3.setRowHeight(30);
	
		
		table_3.setBounds(40, 201, 583, 112);
		table_3.setBorder(BorderFactory.createLineBorder(Color.black));
		table_3.setFont(new Font("微软雅黑", Font.PLAIN, 10));
		JScrollPane sp=new JScrollPane(table_3);
		
		
		table_3.setDefaultRenderer(Object.class, new TableViewRenderer());//红色标记部分是用来渲染JTable的自定义绘制器
	
		OnlyCardNum obj = new OnlyCardNum(number);
 		Message msg = new Message("getComment", obj);
 		
 		Object temp = Sender.send(msg);
		Message res = (Message)temp;
        
		while(res.status.equals("100"));

		for(int i=0;i<res.num;i=i+1)
		{
		    
			tableModel.addRow(new Object[]{((CommentGood)res.response[i]).name,((CommentGood)res.response[i]).content});
			
		}
		
		
		repaint();
		
		table_3.addMouseListener( new MouseListener(){
	             public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

	                //得到选中的行列的索引值

	               int r= table_3.getSelectedRow();

	               int c= table_3.getSelectedColumn();

	               //得到选中的单元格的值，表格中都是字符串

	               Object value= table_3.getValueAt(r, c);

	            String info=r+"行"+c+"列结果 : "+value.toString();

	            javax.swing.JOptionPane.showMessageDialog(null,info);

	             }

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO 自动生成的方法存根
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO 自动生成的方法存根
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO 自动生成的方法存根
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO 自动生成的方法存根
					
				}

	         }); 
		
		contentPane.add(sp);
		

	}
	
	//自定义的表格绘制器
			class TableViewRenderer extends JTextArea implements TableCellRenderer 
			{ 
			       public TableViewRenderer() 
			       { 
			            //将表格设为自动换行
			       setLineWrap(true); //利用JTextArea的自动换行方法
			       }
			       public Component getTableCellRendererComponent(JTable jtable, Object obj, //obj指的是单元格内容
			            boolean isSelected, boolean hasFocus, int row, int column) 
			       { 
			       setText(obj == null ? "" : obj.toString()); //利用JTextArea的setText设置文本方法
			       return this; 
			       } 
			    } 

}
