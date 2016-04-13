package haust.vk.jiaohuan;

import java.util.Scanner;

public class Maopao1 {
	public static void main(String[] args) {
		int temp=0;
		String name="";
		int score=0;
		Admin[] ad=new Admin[3];
		Scanner cin=new Scanner(System.in);
		int i=0;
		for(i=0;i<3;i++){
			System.out.println("请输入分数");
			score=cin.nextInt();
			System.out.println("请输入姓名");
			name=cin.next();
			Admin a=new Admin(score,name);
			ad[i]=a;
		}
		
		for(i=0;i<ad.length;i++){
			for(int m=1;m<ad.length;m++){
				if(ad[m-1].getScore()<ad[m].getScore()){
					temp=ad[m-1].getScore();
					name=ad[m-1].getName();
					ad[m-1].setScore(ad[m].getScore());
					ad[m-1].setName(ad[m].getName());
					ad[m].setScore(temp);
					ad[m].setName(name);
				}
			}
		}
		
		for(i=0;i<ad.length;i++){
			System.out.println(ad[i].toString());
		}
	}
}
