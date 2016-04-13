package haust.vk.jishu;

import java.util.ArrayList;
import java.util.List;

public class Jishu {
	
	public static void main(String[] args) {
		int[] a=new int[]{49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
		System.out.println("排序前----------");
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"---");
		}
		
		jishuSort(a);
		System.out.println("结束");
		System.out.println("排序后----------");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"---");
		}
		System.out.println("结束");
	}
	public static void jishuSort(int a[]){
		int max=a[0];
		int times=0;
		for(int i=0;i<a.length;i++){
			if(max<a[i]){
				max=a[i];
			}
		}
		while(max>0){
			max=max/10;
			times++;
		}
		
		//System.out.println(times);
		List<ArrayList> queue=new ArrayList<ArrayList>() ;
		for(int i=0;i<10;i++){
			ArrayList queue1=new ArrayList();
			queue.add(queue1);
		}
		
		for(int i=0;i<times;i++){
			for(int j=0;j<a.length;j++){
				int x=(a[j]%(int)Math.pow(10,i+1)/(int)Math.pow(10,i));
				ArrayList queue2=new ArrayList();
				queue2=queue.get(x);
				queue2.add(a[j]);
				queue.set(x, queue2);
			}
			int count=0;
			for(int j=0;j<10;j++){
				while(queue.get(j).size()>0){
					ArrayList<Integer> queue3=queue.get(j);;
					a[count]=queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}
}
