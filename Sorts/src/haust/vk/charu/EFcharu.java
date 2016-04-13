package haust.vk.charu;

public class EFcharu {
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

	private static void sorts(int[] a) {
		//需要进行n次排序
		for(int i=0;i<a.length;i++){
		//初始三个指向
		int temp=a[i];
		int low=0;
		int high=i-1;
		int mid=0;
		//找到目的位置
		while(low<=high){
			mid=(low+high)/2;
			if(temp<a[mid]){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		//把目标位置到i之间的数据全部右移一位，把目标位置空出来
		for(int j=i-1;j>=low;j--){
			a[j+1]=a[j];
		}
		//如果low=i，就不用进行下列步骤了，原因是：初始位置是0，第一次不进行赋值了
		if(low!=i){
			a[low]=temp;
		}
			}
		}
	}

