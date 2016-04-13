package haust.vk.jiaohuan;

import java.util.Scanner;

public class Maopao {
	public static void main(String[] args) {
		int d[]=new int[11];
		//计数置零
		for(int i=0;i<11;i++){
			d[i]=0;
		}
		System.out.println("请输入一串数字用','隔开");
		Scanner cin=new Scanner(System.in);
		int n=0;
		String str=cin.next();
		String[] a=str.split(",");
		int[] b=new int[a.length];
		for(int i=0;i<a.length;i++){
			b[i]=Integer.parseInt(a[i]);//b[i]存放数字
		}
		int temp=0;
		for(int i=0;i<b.length;i++){
			for(int m=1;m<b.length;m++){
				if(b[m-1]<b[m]){
					temp=b[m-1];
					b[m-1]=b[m];
					b[m]=temp;
				}
			}
		}
		
		for(int i=0;i<b.length;i++){
			System.out.print(b[i]+",");
		}
	}
}
