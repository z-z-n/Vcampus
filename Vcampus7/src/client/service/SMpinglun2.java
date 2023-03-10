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
						"??????", "??????"
					}
				));
				DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
			
				 TableColumn column = table_3.getColumnModel().getColumn( 0 );//????????????
				  column.setPreferredWidth(100);
				  column.setMaxWidth(100);
				  column.setMinWidth( 100);
				table_3.setRowHeight(30);
			
				
				table_3.setBounds(40, 201, 583, 112);
				table_3.setBorder(BorderFactory.createLineBorder(Color.black));
				table_3.setFont(new Font("????????????", Font.PLAIN, 10));
				JScrollPane sp=new JScrollPane(table_3);
				sp.setBounds(0, 10, 774, 418);
				
				
				table_3.setDefaultRenderer(Object.class, new TableViewRenderer());//?????????????????????????????????JTable?????????????????????
			
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
			             public void mouseClicked(MouseEvent e) {//???????????????????????????

			                //?????????????????????????????????

			               int r= table_3.getSelectedRow();

			               int c= table_3.getSelectedColumn();

			               //?????????????????????????????????????????????????????????

			               Object value= table_3.getValueAt(r, c);

			            String info=r+"???"+c+"????????? : "+value.toString();

			            javax.swing.JOptionPane.showMessageDialog(null,info);

			             }

						@Override
						public void mousePressed(MouseEvent e) {
							// TODO ???????????????????????????
							
						}

						@Override
						public void mouseReleased(MouseEvent e) {
							// TODO ???????????????????????????
							
						}

						@Override
						public void mouseEntered(MouseEvent e) {
							// TODO ???????????????????????????
							
						}

						@Override
						public void mouseExited(MouseEvent e) {
							// TODO ???????????????????????????
							
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
	
	//???????????????????????????
	class TableViewRenderer extends JTextArea implements TableCellRenderer 
	{ 
	       public TableViewRenderer() 
	       { 
	            //???????????????????????????
	       setLineWrap(true); //??????JTextArea?????????????????????
	       }
	       public Component getTableCellRendererComponent(JTable jtable, Object obj, //obj????????????????????????
	            boolean isSelected, boolean hasFocus, int row, int column) 
	       { 
	       setText(obj == null ? "" : obj.toString()); //??????JTextArea???setText??????????????????
	       return this; 
	       } 
	    } 

}
