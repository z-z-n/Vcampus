package client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import client.UserInfor;
import client.service.LibSearchPanel;
import client.service.SMbought;
import client.service.SMcar;
import client.service.SMsearch;
//import client.view.SMpinglun.TableViewRenderer;
import server.common.CommentGood;
import server.common.Goods;
import server.common.UniversalClass;
import server.communication.Message;
import client.Sender;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;



public class SMStuUI extends JPanel {
	private JTextField sousuo;
	private JPanel main;
	int a1=0;
	int a2=1;
	int a3=2;
	int a4=3;
	int a5=4;
	int a6=6;
	int n=0;
	/**
	 * Create the panel.
	 */
	public SMStuUI(UserInfor user) {
		setOpaque(true) ;
		setSize(1405,929);
		//setBorder(new LineBorder(Color.white));
		setBackground(Color.white);
		setLayout(null);
		
		JPanel panel = new JPanel();
		main = new JPanel();
		JPanel head = new JPanel();
		
		head.setBounds(0, 0, 1405, 45);
		main.setBounds(0, 59, 1405, 884);
		main.setBackground(Color.white);
		add(panel);
		add(main);
		add(head);
		head.setLayout(null);
		
		  JButton shouye = new JButton("商城首页");
		  shouye.setContentAreaFilled(false);
		  shouye.setBorderPainted(false);
	        shouye.setFont(new Font("微软雅黑", Font.PLAIN, 14));
	        shouye.setBounds(534, 0, 100, 45);
	        head.add(shouye);
	        shouye.addMouseListener(new MouseAdapter() {
     			@Override
     			public void mouseEntered(MouseEvent e) {
     				shouye.setContentAreaFilled(true);
     				shouye.setBackground(new Color(240,55,38));
     				shouye.setForeground(Color.white);
     			}

     			@Override
     			public void mouseExited(MouseEvent e) {
     				shouye.setContentAreaFilled(false);
     				shouye.setForeground(Color.black);
     			}

     			@Override
     			public void mouseClicked(MouseEvent e) {
     				main.setVisible(false);
    				main = new SMStuUI(user);
    				//main.setBounds(286, 68, 1076, 623);
    			    add(main);
    				repaint();
     			}
     		});
		
		JButton car = new JButton("购物车");
		car.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		car.setBounds(734, 0, 100, 45);
		
		head.add(car);
		car.setContentAreaFilled(false);
		car.setBorderPainted(false);
		
		JButton yigoumai = new JButton("\u5DF2\u8D2D\u4E70");
		yigoumai.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		yigoumai.setContentAreaFilled(false);
		yigoumai.setBorderPainted(false);
		yigoumai.setBounds(638, 0, 100, 45);

		
		
		head.add(yigoumai);
		yigoumai.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				yigoumai.setContentAreaFilled(true);
 				yigoumai.setBackground(new Color(240,55,38));
 				yigoumai.setForeground(Color.white);
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				yigoumai.setContentAreaFilled(false);
 				yigoumai.setForeground(Color.black);
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				main.setVisible(false);
 				main = new SMbought(user.UserID);
 				//main.setBounds(286, 68, 1076, 623);
 			    add(main);
 				repaint();
 			}
 		});
		car.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				car.setContentAreaFilled(true);
 				car.setBackground(new Color(240,55,38));
 				car.setForeground(Color.white);
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				car.setContentAreaFilled(false);
 				car.setForeground(Color.black);
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				main.setVisible(false);
				main = new SMcar(user.UserID);
				//main.setBounds(286, 68, 1076, 623);
			    add(main);
				repaint();
				///////////////////////////////////////////////////////////////////////////lookCar(user.ID)
 			}
 		});
                main.setLayout(null);
                
                sousuo = new JTextField();
                sousuo.setBounds(440, 62, 600, 45);
                sousuo.setForeground(Color.BLACK);
                sousuo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
                sousuo.setCaretColor(Color.BLACK);
                sousuo .setBorder(javax.swing.BorderFactory.createLineBorder(new Color(240,55,38)));
                main.add(sousuo);
                sousuo.setColumns(10);
                
                JButton search = new JButton("搜索");
                search.setBounds(1038, 59, 100, 51);
                search.setBackground(new Color(240,55,38));       
               // search。setContentAreaFilled(false);//不绘制按钮区域
               // search。setBorderPainted(false);//不绘制边框
                search.setContentAreaFilled(false);
                search.setBorderPainted(false);
                search.setForeground(Color.WHITE);
                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                search.setFont(new Font("微软雅黑", Font.PLAIN, 24));
                main.add(search);
                
              
                
                JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setBounds(437, 59, 701, 51);
                lblNewLabel.setOpaque(true) ;
                lblNewLabel.setBackground(new Color(240,55,38));
                main.add(lblNewLabel);
                
                ImageIcon cat = new ImageIcon("picture\\tianmao2.png");
                JLabel tianmao = new JLabel(cat);
                tianmao.setBounds(242, 25, 150, 140);
                main.add(tianmao);
                
                JButton kaui1 = new JButton("耳机");
                kaui1.setBounds(440, 114, 100, 30);
                kaui1.setHorizontalAlignment(SwingConstants.LEFT);
                kaui1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kaui1.setContentAreaFilled(false);
                kaui1.setBorderPainted(false);
                main.add(kaui1);
                kaui1.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kaui1.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kaui1.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kaui1.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                
                JButton kuai2 = new JButton("自行车");
                kuai2.setBounds(550, 114, 100, 30);
                kuai2.setHorizontalAlignment(SwingConstants.LEFT);
                kuai2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kuai2.setContentAreaFilled(false);
                kuai2.setBorderPainted(false);
                main.add(kuai2);
                kuai2.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kuai2.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kuai2.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kuai2.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                JButton kuai3 = new JButton("课本");
                kuai3.setBounds(660, 114, 100, 30);
                kuai3.setHorizontalAlignment(SwingConstants.LEFT);
                kuai3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kuai3.setContentAreaFilled(false);
                kuai3.setBorderPainted(false);
                main.add(kuai3);
                kuai3.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kuai3.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kuai3.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kuai3.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                JButton kuai4 = new JButton("手表");
                kuai4.setBounds(770, 114, 100, 30);
                kuai4.setHorizontalAlignment(SwingConstants.LEFT);
                kuai4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kuai4.setContentAreaFilled(false);
                kuai4.setBorderPainted(false);
                main.add(kuai4);
                kuai4.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kuai4.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kuai4.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kuai4.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                JButton kuai5 = new JButton("吉他");
                kuai5.setBounds(880, 114, 100, 30);
                kuai5.setHorizontalAlignment(SwingConstants.LEFT);
                kuai5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kuai5.setContentAreaFilled(false);
                kuai5.setBorderPainted(false);
                main.add(kuai5);
                kuai5.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kuai5.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kuai5.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kuai5.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                JButton kuai6 = new JButton("笔");
                kuai6.setBounds(990, 114, 100, 30);
                kuai6.setHorizontalAlignment(SwingConstants.LEFT);
                kuai6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
                kuai6.setContentAreaFilled(false);
                kuai6.setBorderPainted(false);
                main. add(kuai6);
                
             
                kuai6.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseEntered(MouseEvent e) {
        				kuai6.setForeground(new Color(240,55,38));
        			}

        			@Override
        			public void mouseExited(MouseEvent e) {
        				kuai6.setForeground(Color.black);
        			}

        			@Override
        			public void mouseClicked(MouseEvent e) {
        				main.setVisible(false);
        				main = new SMsearch(user.UserID,kuai6.getText());
        				//main.setBounds(286, 68, 1076, 623);
        			    add(main);
        				repaint();

        			}
        		});
                
          
                
                JPanel show = new JPanel();
                show.setLayout(null);
                show.setBounds(242, 187, 900, 660);
                main.add(show);
                
                JTable table = new JTable();
                table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                table.setModel(new DefaultTableModel(
                	new Object[][] {
                	},
                	new String[] {
                		"商品名", "商品号", "价格", "库存", "商品描述"
                	}
                ));
                
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                TableColumn column = table.getColumnModel().getColumn(4 );//取第一列
      		  column.setPreferredWidth(400);
      		  column.setMaxWidth(400);
      		  column.setMinWidth(400);
      		  table.setRowHeight(40);
      		table.setBounds(10, 10, 880, 640);
      		table.setBorder(BorderFactory.createLineBorder(Color.black));
      		table.setFont(new Font("微软雅黑", Font.PLAIN, 10));
    		JScrollPane sp=new JScrollPane(table);
    		sp.setLocation(10, 10);
    		sp.setSize(880, 640);
    		
    		table.setDefaultRenderer(Object.class, new TableViewRenderer());//红色标记部分是用来渲染JTable的自定义绘制器
    		
    		UniversalClass obj = new UniversalClass("");//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    		Message msg = new Message("search", obj);
    		Object temp = Sender.send(msg);
    		Message res = (Message)temp;
            
    		while(res.status.equals("100")); 
    		
    		
    		n=res.num;
    		for(int i=0;i<n;i=i+1)
    		{
    		    
    			tableModel.addRow(new Object[]{((Goods)res.response[i]).name,((Goods)res.response[i]).id,String.valueOf(((Goods)res.response[i]).price),((Goods)res.response[i]).number,((Goods)res.response[i]).introduction});
    			
    		}
    		repaint();
    		table.addMouseListener( new MouseListener(){
	             public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

	                //得到选中的行列的索引值

	               int r= table.getSelectedRow();


	               //得到选中的单元格的值，表格中都是字符串

	               Object value= table.getValueAt(r, 1);

	         //   String info=r+"行"+c+"列结果 : "+value.toString();
	            main.setVisible(false);
				main = new SMgoodsUI(user.UserID,value.toString());
				//main.setBounds(286, 68, 1076, 623);
			    add(main);
				repaint();        

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
                
                //show.add(table);
                show.add(sp);
                
                ImageIcon huan = new ImageIcon("picture\\huanyipi.png");
                
                
                String shangpingming=sousuo.getText();
                
                search.addMouseListener(new MouseAdapter() {////////////////////////////////实现搜索
         			@Override
         			public void mouseEntered(MouseEvent e) {
         				
         			}

         			@Override
         			public void mouseExited(MouseEvent e) {
         				
         			}

         			@Override
         			public void mouseClicked(MouseEvent e) {
         				String shangpingming=sousuo.getText();
         				//六个六个的展示
         				main.setVisible(false);
        				main = new SMsearch(user.UserID,shangpingming);
        			    add(main);
        				repaint();
         			}
         		});
//                setVisible(false);
// 				main = new SMsearch(id,show1.getText());
//				//main.setBounds(286, 68, 1076, 623);
//			    add(main);
//				repaint();///？

	}
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
