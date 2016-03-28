package haust.vk.b_entity;

public class Student {
	private String name1;
	private int age;
	public String getName() {
		return name1;
	}
	public void setName(String name) {
		this.name1 = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name1 = name;
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
