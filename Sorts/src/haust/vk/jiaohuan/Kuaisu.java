package haust.vk.jiaohuan;

import org.junit.Test;

public class Kuaisu {
	private static int[] a=new int[]{54,53,25,4,8,7,8,95,14,45};
	public static void main(String[] args) {
		int len=a.length;	
		for(int i=0;i<len;i++){
			System.out.print(a[i]+"  ");
		}
		System.out.println();
		//从0开始
		kuai(0,len-1);
		for(int i=0;i<len;i++){
			System.out.print(a[i]+"  ");
		}
	}
	@Test
	public static  void kuai(int left,int right){
		int i,j,k,l;//k记录基准数，l用于交换，ij用于指引位置
		if(left>right){
			return ;
		}
		i=left;//第一次left为0 左
		j=right;//第一次right为9 右
		k=a[left];//存的是基准数
		while(i!=j){
			//从右往左，直到找到a[j]<k的时候跳出循环，j记录位置 前提i<j
			while(a[j]>=k && i<j){
				j--;
			}
			//从左往右，直到找到a[j]>k的时候跳出循环，i记录位置 前提i<j
			while(a[i]<=k && i<j){
				i++;
			}
			//找到i和j之后（相互交换位置）
			if(i<j){
			l=a[i];
			a[i]=a[j];
			a[j]=l;
			}
		}
		//交换完成后，把第一个数插入到指定位置
		a[left]=a[i];
		a[i]=k;
		//递归
		kuai(left,i-1);
		kuai(i+1,right);
		
	}
}
