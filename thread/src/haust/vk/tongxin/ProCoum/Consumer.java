package haust.vk.tongxin.ProCoum;

class Consumer implements Runnable{
	private Person p;
	
	public Consumer(Person p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			p.get();
		}
	}
}

