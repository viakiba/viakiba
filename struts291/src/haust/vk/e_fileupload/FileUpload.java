package haust.vk.e_fileupload;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月15日
 */
public class FileUpload extends ActionSupport{
	private File file1;
	private String file1FileName;
	private String file1ContentType;
	
	/**
	 * @param file1 the file1 to set
	 */
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	
	/**
	 * @param file1FileName the file1FileName to set
	 */
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	
	/**
	 * @param file1ContentType the file1ContentType to set
	 */
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	
	@Override
	public String execute() throws Exception {
		
		/*
		 * 拿到上传文件进行处理
		 */
		
		/* 把文件上传到web应用下的upload目录下
		 */
		
		/* 获取上传的目录路径
		 */
		
		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		System.out.println(path);
		/**
		 * 创建目标文件对象
		 */
		File destFile = new File(path,file1FileName);
		//把上传文件复制到目标目录下
		FileUtils.copyFile(file1, destFile);
		
		
		return SUCCESS;
	}
}
