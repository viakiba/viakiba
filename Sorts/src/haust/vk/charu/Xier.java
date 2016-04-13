package haust.vk.charu;

public class Xier {
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
		int d = a.length;
		while(true){//直到d==1
			d = d / 2;
			for(int x=0;x<d;x++){//确定一组结束
				for(int i=x+d;i<a.length;i=i+d){//确定目标插入值
					int item=a[i];//目标插入值赋值给item
					int j;//确定需要比较的值的位置
					for(j=i-d;j>=0&&a[j]>item;j=j-d){
						a[j+d]=a[j];
					}//遍历找到需要插入的位置（由于执行了一下j=j-d）
					a[j+d]=item;//所以再执行一次j+d即是需要插入的位置
				}
			}
			if(d == 1){//确定所需要的分组轮次结束
				break;
			}
		 }
		}
	}