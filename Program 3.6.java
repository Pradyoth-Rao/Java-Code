/* Program 3.3
 * Pradyoth Rao
 * ESE 554
 */

class arrayins1{
	private long a[];
	private int ne;
	public int j=0;
	public arrayins1(int max)
	{
		a= new long[max];
		ne=0;
	}
	public void insert(long value)
	{
		a[ne]=value;
		ne++;
		 for(int i=0;i<ne-1;i++)
		{
			if(value==a[i])
				a[i]=-1;
		}
		
	}
	public void display()
	{
		for(int i=0;i<ne;i++)
			System.out.print(a[i]+" ");
	}
	public void insertsort()
	{
		int in,out,count=0;
		for(out=1;out<ne;out++)
		{
			long temp=a[out];
			in=out;
			while(in>0&&a[in-1]>=temp)
			{
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
		System.out.print("\nThe array with -1 for duplicates is \n ");
		for(int i=0;i<ne;i++)
			System.out.print(a[i]+" ");
		for(int i=0;i<ne;i++)
		{
			if(a[i]==-1)
				count++;
			
		}
		System.out.print("\nThe array without duplicates is: \n");
		for(int i=count;i<ne;i++)
			System.out.print(a[i]+" ");
	}
}

public class duplicate {

	public static void main(String[] args) {
		int max=100;
		arrayins1 ar;
		ar=new arrayins1(max);
		ar.insert(77);
		ar.insert(33);
		ar.insert(44);
		ar.insert(55);
		ar.insert(66);
		ar.insert(99);
		ar.insert(22);
		ar.insert(11);
		ar.insert(88);
		ar.insert(11);
		ar.insert(88);
		ar.insert(99);
		ar.insert(99);
		ar.insert(99);
		ar.insertsort();
		
	}

}
