package haust.vk.charu;

public class ZJcharu {
	public static void main(String[] args) {
		int[] a=new int[]{11,24,1,35,58,56,24};
		System.out.println("排序前");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
		sorts(a);
		System.out.println();
		System.out.println("排序后");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
	}

	private static void sorts(int[] a) {//从小到大进行排序
		
		for(int i=1;i<a.length;i++){//从一开始，就可以避免下面的空指针异常了
			//设置目标值
			int item=a[i];
			int j=i-1;
			while(j>=0){
				if(a[j]>item){//如果a[j]大于目标值。则把a[j]进行右移，然后j--判断，大于的话接着右移，不满足则跳出while循环
					a[j+1]=a[j];
					j--;
				}else{
					break;
				}
			}
			a[j+1]=item;//找到后，把item放在找到的位置即可
			
		}
	}
}
