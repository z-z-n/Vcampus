package client.service;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import client.Sender;
import server.common.FileResponse;
import server.common.OnlyCardNum;
import server.common.SendFile;
import server.communication.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/////////////////////修改效果图
public class SMtupianDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private static JLabel textField_1;
	private String absolutePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SMtupianDlg dialog = new SMtupianDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SMtupianDlg() {
		setBounds(400, 200, 633, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("商品号");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(116, 52, 80, 30);
			contentPanel.add(lblNewLabel);
		
		
			textField = new JTextField();
			textField.setBounds(192, 53, 200, 30);
			contentPanel.add(textField);
			textField.setColumns(10);
		
		
			JLabel lblNewLabel1 = new JLabel("效果图");
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setBounds(116, 200, 80, 30);
			contentPanel.add(lblNewLabel1);
			
		
		
			textField_1 = new JLabel();
			
			textField_1.setBounds(192, 116, 200, 200);
			contentPanel.add(textField_1);
			
			
			
			absolutePath="picture//zhanwu.png";
			
			JButton btnNewButton = new JButton("上传图片");
			btnNewButton.setBounds(245, 326, 93, 23);
			contentPanel.add(btnNewButton);
			String xiaoguotu=textField_1.getText();
			
			
			
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JFileChooser chooser = new JFileChooser();
					  chooser.setMultiSelectionEnabled(true);
					  /** 过滤文件类型 * */
					  FileNameExtensionFilter filter = new FileNameExtensionFilter("image(*.jpg, *.png, *.gif)", "jpg", "png", "gif");
					  chooser.setFileFilter(filter);
					  int returnVal = chooser.showOpenDialog(btnNewButton);
					  if (returnVal == JFileChooser.APPROVE_OPTION) { 
					   /** 得到选择的文件* */
					   File[] arrfiles = chooser.getSelectedFiles();
					   if (arrfiles == null || arrfiles.length == 0) {
					    return;
					   }
					   //判断是否有文件为jpg或者png
					 File  ff = chooser.getSelectedFile();
					 //创建一个fileName得到选择文件的名字
					 String fileName =ff.getName();
					 //lastIndexOf(".") 返回"."在文件名中最后一次出现的下标
					 //substring(int index)从指定的index开始截取后面的字符串
					 //比如： a.txt 最后一次出现的.下标是 1 substring(1)就是从下标1的位置开始截取 截取后的新字符串为 .txt
					 //所以这里需要+1 才能只截取文件类型 txt
					 String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
					 //判断选择的文件是否是图片文件 必须排除不是的情况 不然后续操作会报错
					 if(!(prefix.equals("jpg") || prefix.equals("png") || prefix.equals("JPG") || prefix.equals("PNG"))){
					 JOptionPane.showMessageDialog(new JDialog(),":请选择.jpg 或 .png格式的图片");
					 return;
					 }

					     
					   //通过文件选择器对象拿到选择的文件.拿到该文件的绝对路径
					    absolutePath = chooser.getSelectedFile().getAbsolutePath();
					   //创建一个ImageIcon对象 传入图片文件的绝对路径
					     ImageIcon imageIcon = new ImageIcon(absolutePath);
					     textField_1.setIcon(imageIcon);
					     textField_1.getIcon();

					  }
					 
				}
			});
		
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
			
		
		
		okButton.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseExited(MouseEvent e) {
 				
 			}

 			@Override
 			public void mouseClicked(MouseEvent e) {
 				

 				String booknumber=textField.getText();
 				
 				
 				
 				if(booknumber.length()==0)
 				{
 					 JOptionPane.showMessageDialog(contentPanel, "商品号不能为空");
 				}
 				else 
 				{
 					if(absolutePath.length()==0)
 				{
 						 JOptionPane.showMessageDialog(contentPanel, "效果图不能为空");
 				}
 					
 					else
 					{
 						System.out.print(absolutePath);
 		 				//////////////////////第一个参数是绝对路径
 						SendFile obj = new SendFile(absolutePath,booknumber,"113193311");
 						Message msg = new Message("setPic",obj);
 						Object temp = Sender.send(msg); 				
 						Message res = (Message)temp;
 						while(res.status.equals("100"));
 						if(res.status.equals("200"))
 			 				{
 							JOptionPane.showMessageDialog(contentPanel, "操作成功");
 			 				}
 						
 						
 						///////////////////////////////////////setPic(xiaoguotu,booknumber,null)
 						
 					}
 				}
 				
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
	
	
		  
}
