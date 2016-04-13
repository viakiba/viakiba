package haust.vk.xuanze;

public class JDxuanze {
	public static void main(String[] args) {
		int a[]=new int[]{1,2,5,4,2,36,5,5,333,41,2};
		System.out.println("排序前：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
		System.out.println();
		sorts(a);
		System.out.println("排序后：");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
	}
	
	//核心代码如下
	public static void sorts(int a[]){
		
		for(int i=0;i<a.length;i++){//控制次数，每一次，初始遍历位置前进一位
			int min=a[i];
			int k=i;
			for(int j=a.length-1;j>=i;j--){//找到最小的一个数字
				if(min<a[j]){
					min=a[j];//记录最小的一个数字
					k=j;//记录最小的一位数字的下角标
				}
			}
			a[k]=a[i];
			a[i]=min;
		}
	}
}
