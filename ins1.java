/* Program 3.3
 * Pradyoth Rao
 * 
 */


class arrayins{
	private long a[];
	private int ne;
	public int j=0;
	public arrayins(int max)
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
public void nodups()
	{
		long temp[]=new long[ne];//Temporary array for storing array without duplicates
		for(int i=0;i<ne;i++)
		{
			if(a[i]!=a[i+1])
				temp[j++]=a[i];
			else
				continue;
		}
		temp[j]=a[ne];
		for(int i=0;i<j;i++)
			a[i]=temp[i];
		System.out.print("\n The array without duplicate is \n");
		for(int i=0;i<j;i++)
			System.out.print(a[i]+" ");
}
public void insertsort()
	{
		int in,out;
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
	}
}

public class ins1 {

	public static void main(String[] args) {
		int max=100;
		arrayins ar;
		ar=new arrayins(max);
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
		ar.insert(00);
		ar.insert(99);
		ar.insert(55);
		System.out.print("The unsorted array is \n");
		ar.display();
		ar.insertsort();
		System.out.println("\n The sorted array is");
		ar.display();
		ar.nodups();
	}
}
