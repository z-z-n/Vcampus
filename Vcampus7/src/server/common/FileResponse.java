package server.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileResponse implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public byte[] bytes = null;
	public String fileName = null;
	public FileResponse(String filePath) {
		try {
			// 基本思想：转化为字节数组，存在对象里面一起传过去
			File file = new File(filePath);  
	        long fileSize = file.length();  
	        if (fileSize > Integer.MAX_VALUE) {  
	            return;  
	        }  
	        FileInputStream fi = new FileInputStream(file);  
	        byte[] buffer = new byte[(int) fileSize];  
	        int offset = 0;  
	        int numRead = 0;  
	        while (offset < buffer.length  
	        && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {  
	            offset += numRead;  
	        }  
	        // 确保所有数据均被读取  
	        if (offset != buffer.length) {  
	        	fi.close();
	        	throw new IOException("Could not completely read file "  
	                    + file.getName()); 
	        }  
	        fi.close(); 
	        bytes = buffer;
	        this.fileName = file.getName();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
