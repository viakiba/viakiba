package haust.vk.tongxin.ProCoum;

class Producer implements Runnable{
	private Person p;
	
	public Producer(Person p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if( i % 2 == 0){
				p.set("ÁõÕÑ", "ÄÐ");
			}else{
				p.set("ÕÂÔóÌì", "Å®");
			}
		}
	}
}
