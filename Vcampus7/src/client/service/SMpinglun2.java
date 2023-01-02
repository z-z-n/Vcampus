package client.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
import client.service.SMpinglun.TableViewRenderer;
import server.common.CommentGood;
import server.common.OnlyCardNum;
import server.communication.Message;

public class SMpinglun2 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMpinglun2 dialog = new SMpinglun2("1");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMpinglun2(String number) {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
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
				sp.setBounds(0, 10, 774, 418);
				
				
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
				contentPanel.setLayout(null);
				
				contentPanel.add(sp);
				
				okButton.addMouseListener(new MouseAdapter() {		
		 			@Override
		 			public void mouseEntered(MouseEvent e) {
		 				
		 			}
		 			@Override
		 			public void mouseExited(MouseEvent e) {			
		 			}
		 			@Override
		 			public void mouseClicked(MouseEvent e) {
		 				
		 						dispose();
		 				//}				
		 			}
		 		});
			cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
						
					}
			});
				
				
		
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
