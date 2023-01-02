package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import client.Sender;
import client.service.SMpinglun;
import client.service.SMpinglun2;
import client.service.SMpinglunDlg;
import client.service.SMsearch;
import client.service.SMsearch2;
import client.service.SMshangjiaDlg;
import client.Sender;
import server.common.*;
import server.common.Bookshow;
import server.common.CommentGood;
import server.common.FileResponse;
import server.common.OnlyCardNum;
import server.common.StringWithInt;
import server.common.UniversalClass;
import server.communication.Message;

public class SMgoodsUI extends JPanel {
	private JPanel main;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SMgoodsUI(String id,String number) {
		setSize(1405, 884);
		setOpaque(true) ;
		setBackground(Color.white);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 200, 1405, 25);
		add(panel);
		panel.setLayout(null);
		
		
		OnlyCardNum obj1 = new OnlyCardNum(number);
 		Message msg1 = new Message("getDetail", obj1);
 		
 		Object temp1 = Sender.send(msg1);
		Message res1 = (Message)temp1;
        
		while(res1.status.equals("100"));
		
		JLabel ming = new JLabel(((Goods)res1.response[0]).name);
		ming.setHorizontalAlignment(SwingConstants.CENTER);
		ming.setFont(new Font("华文行楷", Font.PLAIN, 40));
		ming.setBounds(522, 112, 263, 67);
		add(ming);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		panel_1.setBounds(297, 248, 782, 480);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		
		 ImageIcon huan = new ImageIcon("picture\\zhanwu.png");
		

				
		        OnlyCardNum obj5 = new OnlyCardNum(number);//******************************************************图片接口
				Message msg5 = new Message("getPic", obj5);
				Object temp5 = Sender.send(msg5);
				Message res5 = (Message)temp5;
				while(res5.status.equals("100"));
				if(res5.status.equals("200"))
				{
					String classPath = this.getClass().getResource("/").getPath();
					String path=classPath.replaceAll("Vcampus7/bin","Vcampus7/picture");
					FileResponse tem=(FileResponse)res5.response[0];
					saveFile(path,tem);
					huan=new ImageIcon("picture\\"+tem.fileName);
				}
				//else 用默认的head_temp.jpg
		        //头像自适应
				Image temp_image = huan.getImage();
				temp_image = temp_image.getScaledInstance(337,327, Image.SCALE_DEFAULT);
				huan.setImage(temp_image);
				
				JLabel zhaopian = new JLabel(huan);
				zhaopian.setBackground(Color.WHITE);
				zhaopian.setBounds(26, 74, 337, 327);
				panel_1.add(zhaopian);
		 
		 
	
		
		JTextArea miaoshu = new JTextArea(((Goods)res1.response[0]).introduction);
		//miaoshu.setHorizontalAlignment(SwingConstants.LEFT);
		miaoshu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		miaoshu.setLineWrap(true); 
		miaoshu.setEditable(false);
		miaoshu.setBounds(382, 29, 375, 76);
		panel_1.add(miaoshu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(382, 115, 368, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4EF7\u683C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.gray);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setBounds(0, 29, 66, 24);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(((Goods)res1.response[0]).price));
		lblNewLabel_1.setForeground(new Color(240,55,38));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(79, 10, 182, 56);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(243,241,255));
		panel_3.setForeground(new Color(117,91,240));
		panel_3.setBounds(382, 201, 368, 40);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("   \u5168\u6B3E\u9884\u552E");
		lblNewLabel_2.setForeground(new Color(117,91,240));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 0, 114, 40);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(249,248,255));
		panel_3_1.setBounds(382, 241, 368, 40);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("    发货时间  付款后21天内发货");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(Color.gray);
		lblNewLabel_3.setBounds(0, 0, 245, 40);
		panel_3_1.add(lblNewLabel_3);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBounds(382, 295, 220, 40);
		panel_1.add(panel_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("    库存        "+((Goods)res1.response[0]).number+"");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.gray);
		lblNewLabel_4.setBounds(0, 0, 220, 40);
		panel_3_1_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("    数量");
		lblNewLabel_4_1.setForeground(Color.GRAY);
		lblNewLabel_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(382, 345, 65, 40);
		panel_1.add(lblNewLabel_4_1);
		
		JTextField shuliang = new JTextField("1");
		shuliang.setBounds(470, 359, 54, 15);
		panel_1.add(shuliang);
		
		
		JPanel goumai = new JPanel();
		goumai.setBackground(new Color(117,91,240));
		goumai.setBounds(382, 395, 121, 40);
		panel_1.add(goumai);
		goumai.setLayout(null);
		goumai.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				// show6. setBorder(BorderFactory.createLineBorder(Color.red, 2));
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				 //、、show6. setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				if(id.equals("1"))
 				{
 					JOptionPane.showMessageDialog(null, "管理员没有权限");
 				}
 				else
 				{
 				String m=shuliang.getText();
 				int y = Integer.parseInt(m);

 				//////////////////////////////////////////////////////////////////buy(id,number,1)
 				//购买成功之后
 				StringWithInt obj2 = new StringWithInt(number,id,y);
 		 		Message msg2 = new Message("buy", obj2);
 		 		
 		 		Object temp2 = Sender.send(msg2);
 				Message res2 = (Message)temp2;
 				while(res2.status.equals("100"));
 				if(res2.status.equals("404"))
	    			JOptionPane.showMessageDialog(null, ((UniversalClass)res2.response[0]).context);
	    		if(res2.status.equals("200"))
	    		{
	    			JOptionPane.showMessageDialog(null, "操作成功");
	    		}
 				
	    		new SMpinglunDlg(id,number).setVisible(true);
 				}
 			}
 		});
		
		
		
		JLabel lblNewLabel_6 = new JLabel("立即购买");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(0, 0, 121, 40);
		goumai.add(lblNewLabel_6);
		
		
		JPanel car = new JPanel();
		car.setBackground(new Color(242,45,0));
		car.setBounds(530, 395, 164, 40);
		panel_1.add(car);
		car.setLayout(null);
		car.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				// show6. setBorder(BorderFactory.createLineBorder(Color.red, 2));
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				 //、、show6. setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				if(id.equals("1"))
 				{
 					JOptionPane.showMessageDialog(null, "管理员没有权限");
 				}
 				else
 				{

 				StringWithInt obj3 = new StringWithInt(number,id,1);
 		 		Message msg3 = new Message("addCar", obj3);
 		 		
 		 		Object temp3 = Sender.send(msg3);
 				Message res3 = (Message)temp3;
 				while(res3.status.equals("100"));
 				if(res3.status.equals("404"))
 				{
	    			JOptionPane.showMessageDialog(null, ((UniversalClass)res3.response[0]).context);
 				}
 				else	
	    		{
	    			JOptionPane.showMessageDialog(null, "操作成功");
	    		}
 				}
 				
 			}
 		});
		
		
		JLabel lblNewLabel_7 = new JLabel("添加至购物车");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.white);
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(40, 0, 124, 40);
		car.add(lblNewLabel_7);
		
		 ImageIcon car2 = new ImageIcon("picture\\car.png");
		JLabel car1 = new JLabel(car2);
		car1.setBounds(8, 4, 35, 35);
		car.add(car1);
		
		JButton pl = new JButton("查看评论区");
		pl.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		pl.setBounds(297, 757, 124, 39);
		add(pl);
		
		pl.addMouseListener(new MouseAdapter() {
 		
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				new SMpinglun2(number).setVisible(true);
			}
 		});
		
		
		

	}
	public static void saveFile(String path, FileResponse obj) {
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(path+'/'+obj.fileName);
			byte[] b = obj.bytes;
			fileOutputStream.write(b);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

