package haust.vk.guibing;

public class Guibing {
	public static void main(String[] args) {
		int[] a=new int[]{11,24,1,35,58,56,24};
		System.out.println("排序前");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
		sorts(a,0,a.length-1);
		System.out.println();
		System.out.println("排序后");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"--");
		}
		System.out.println("结束");
	}

	private static void sorts(int[] a, int low, int high) {
		if(low<high){
			int middle=(low+high)/2;
			
			sorts(a,low,middle);
			sorts(a,middle+1,high);
			merge(a,low,middle,high);
		}
		
	}

	private static void merge(int[] a, int low, int middle, int high) {
		int[] temArr=new int[a.length];
		int mid=middle+1;
		int tmp=low;
		int thrid=low;
		
		while(low<=middle && mid<=high)
		{
			if(a[low]<=a[mid]){
				temArr[thrid++]=a[low++];
			}else{
				temArr[thrid++]=a[mid++];
			}
		}
		
		while(low<=middle){
			temArr[thrid++]=a[low++];
		}
		
		while(mid<=high){
			temArr[thrid++] =a[mid++];
		}
		
		while(tmp<high){
			a[tmp]=temArr[tmp++];
		}
	}
}
