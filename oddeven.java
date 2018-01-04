/* Program 3.4
 * Pradyoth Rao
 * ESE 554
 */

class arrins{
	private long a[];
	private int ne;
	
	public arrins(int max)
	{
		a= new long[max];
		ne=0;
	}
	public void insert(long value)
	{
		a[ne]=value;
		ne++;
	}
	public void display()
	{
		for(int i=0;i<ne;i++)
			System.out.print(a[i]+" ");
	}
	public void oneswap()
	{
		long temp;
		int i=0;
		while(i<ne)
		{
		for(int j=0;j<ne-2;j=j+2)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
		for(int j=1;j<ne-2;j=j+2)
		{
			if(a[j]>a[j+1])
			{
				temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
		i++;
		}
	}
}

	
public class oddeven {

	public static void main(String[] args) {
		int max=100;
		arrins ar;
		ar=new arrins(max);
		ar.insert(6);
		ar.insert(7);
		ar.insert(5);
		ar.insert(4);
		ar.insert(1);
		ar.insert(0);
		ar.insert(13);
		ar.insert(11);
		ar.insert(10);
		ar.insert(17);
		System.out.print("The unsorted array is \n");
		ar.display();
		ar.oneswap();
		System.out.println("\n The sorted array is");
		ar.display();
	}
}
		
	


