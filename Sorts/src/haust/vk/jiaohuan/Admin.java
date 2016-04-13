package haust.vk.jiaohuan;

public class Admin {
	private int score;
	private String name;
	
	public Admin(){
		super();
	}
	
	public Admin(int score,String name){
		this.score=score;
		this.name=name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Admin [score=" + score + ", name=" + name + "]";
	}
	
	
}
