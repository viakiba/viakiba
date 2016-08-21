package haust.vk.tongxin.ProCoum;
class Person{
	private String name;
	private String sex;
	private Boolean isimpty = Boolean.TRUE;//内存区为空！
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void set(String name,String sex){
		synchronized (this) {
			while(!isimpty.equals(Boolean.TRUE)){//不为空的话等待消费者消费！
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.name = name;//为空的话生产者创造！
			this.sex = sex;
			System.out.println("set");
			isimpty = Boolean.FALSE;//创造结束后修改属性！
			this.notifyAll();
		}
	}
	
	public void get(){
		synchronized (this) {
			while(!isimpty.equals(Boolean.FALSE)){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("姓名"+getName()+ ",  "+"性别"+getSex()+"get");
			isimpty = Boolean.TRUE;
			this.notifyAll();
		}
	}
}

