package haust.vk.factory.a_one;

public class SendFactory {
	public SendInterface Produce(String type){
		if("mail".equals(type)){
			return new SendMailClass();
		}else if("sms".equals(type)){
			return new SendSmsClass();
		}else{
			System.out.println("不支持的输入类型");
			return null;
		}
	}
}
