package haust.vk.builder.a_builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {
	private List<SendInterface> list = new ArrayList<>();
	
	public void produceMailSender(int count){
		  for(int i=0; i<count; i++){  
	            list.add(new SendMailClass());  
	       }  
	}
	
	public void produceSmsSender(int count){
		for(int i=0; i<count; i++){
			 list.add(new SendSmsClass());  
		}
	}
	
	public List<SendInterface> getList() {
		return list;
	}
}
