package haust.vk.e_fileupload;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月15日
 */
public class DownAction extends ActionSupport{
	/*************1. 显示所有要下载文件的列表*********************/
	public String List() throws Exception{
		//得到upload的路径
		String path = ServletActionContext.getServletContext().getRealPath("upload");
		//得到目标对象
		File file = new File(path);
		//得到所有要下载的文件的文件名
		String[] fileNames = file.list();
		//保存
		ActionContext ac = ActionContext.getContext();
		//得到代表request的map
		Map<String, Object> request=(Map<String, Object>) ac.get("request");
		
		request.put("fileNames", fileNames);
		
		return "List";
	}
	
/*************2. 文件下载*********************/
	
	// 1. 获取要下载的文件的文件名
	private String fileName;
	
	public void setFileName(String fileName){
		
		try {
			new String (fileName.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.fileName=fileName;
	}
	
	//2.下载提交的业务方法 (在struts.xml中配置返回stream)
	public String down() throws Exception {
		return "download";
	}
	
	// 3. 返回文件流的方法
	public InputStream getAttrInputStream(){
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/"+fileName);
	}
	
	//4.下载显示的文件名
	public String getDownFileName(){
		try {
			fileName = URLEncoder.encode(fileName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileName;
	}
}
