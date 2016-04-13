package haust.vk.xuanze;

import java.util.Arrays;

public class Dui {
	public static void main(String[] args) {
		int[] a=new int[]{11,24,1,35,58,56,24};
		System.out.println("排序前");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
		System.out.println("=================================");
		int len=a.length;
		//循环建堆
		for(int i=0;i<len-1;i++){
			//建堆
			buildMaxHeap(a,len-1-i);
			
			//交换堆顶和最后一个元素
			swap(a,0,len-1-i);
			System.out.println(Arrays.toString(a));
		}
		System.out.println("=================================");
		System.out.println(Arrays.toString(a));
	}
//建堆
	private static void buildMaxHeap(int[] a, int lastIndex) {
		 //从lastIndex处节点（最后一个节点）的父节点开始 
		for(int i=(lastIndex-1)/2;i>=0;i--){
			//k保存正在判断的节点
			int k=i;
			//如果当前k节点的子节点存在 
			while(k*2+1<=lastIndex){
				//k节点的左子节点的索引
				int biggerIndex=2*k+1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex<lastIndex){
					//如果右子节点的值较大	
					if(a[biggerIndex]<a[biggerIndex+1]){
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(a[k]<a[biggerIndex]){
					//交换他们
					swap(a,k,biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k=biggerIndex;
				}else{
					break;
				}
			}
		}
	}
//交换
	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
