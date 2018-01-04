/* Program 7.1
 * Pradyoth Rao
 * ESE 554
 */
class ArrayPar{
	public int[] a;
	private int n;
	public ArrayPar(int max)
	{
		a= new int[max];
		n=0;
	}
	public void insert(int value)
	{
		a[n]=value;
		n++;
	}
	public int size()
	{
		return n;
	}
	public void display()
	{
		System.out.print("A=");
		for(int j=0;j<n;j++)
			System.out.print(a[j]+" ");
		System.out.print(" ");
	}
	public int partition(int left,int right)
	{
		int tr=right;
		int pivot=a[right];
		System.out.println("\n The pivot is"+pivot);
		int leftptr=left-1;
		int rightptr=tr+1;
		while(true)
		{
			while(leftptr<right&&a[++leftptr]<pivot)
				;
			while(rightptr>left&&a[--rightptr]>pivot)
				;
			if(leftptr>=rightptr)
				break;
			else
				swap(leftptr,rightptr);
		}
		return leftptr;
	}
	public void swap(int a1,int b1)
	{
		int temp;
		temp=a[a1];
		a[a1]=a[b1];
		a[b1]=temp;
	}
	
}
	

public class Quicksort_app {

	public static void main(String[] args) {
		int max=8;
		ArrayPar arr;
		arr=new ArrayPar(max);
		for(int j=0;j<max;j++)
		{
			int n=(int)(java.lang.Math.random()*199);
			arr.insert(n);
		}
		arr.display();
		int size=arr.size();
		arr.partition(0, size-1);
		
	}

}
