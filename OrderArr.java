/* Program 2.5- The program to merge 2 sorted array into 1 sorted array
 * Pradyoth Rao
 * ESE 554-Assignment 1
 */




class OrderArray{
	private long a[];
	private long b[];
	private long c[];
	private int la,lb,lc;
	public OrderArray(int l1,int l2)
	{
		la=0;
		lb=0;
		a=new long[l1];
		b=new long[l1];
	}
	public void insertA(long av)
	{
		int j;
		for(j=0; j<la; j++)
		if(a[j] > av)
		break;
		for(int k=la; k>j; k--)
		a[k] = a[k-1];
		a[j] = av; 
		la++;
	}
	public void insertB(long bv)
	{
		int j;
		for(j=0; j<lb; j++)
		if(b[j] > bv)
		break;
		for(int k=lb; k>j; k--)
		b[k] = b[k-1];
		b[j] = bv; 
		lb++;
	}
	public void displayA() // displays array A contents
	{
		System.out.print("\n The array A is ");
		for(int j=0; j<la; j++) 
			System.out.print(a[j]+" ");
	}
	public void displayB() // displays array B contents
	{
		System.out.print("\n The array B is ");
		for(int j=0; j<lb; j++) 
			System.out.print(b[j]+" ");
	}
	public void merge()//Function to merge two arrays
	{
		int i=0,j=0,k=0;
		lc=la+lb;
		c=new long[lc];
		while(i<la && j<lb)
		{
			if(a[i]<b[j])
			{
				c[k]=a[i];
				i++;
				k++;
			}
			else
			{
				c[k]=b[j];
				j++;
				k++;
			}
		}
			if(j<lb)
			{
				while(j<lb)
				{
					c[k]=b[j];
					k++;
					j++;
				}
			}
			if(i<la)
			{
				while(i<la)
				{
					c[k]=a[i];
					k++;
					i++;
				}
			}


		System.out.print("\n The merged and sorted array is: ");
		for(int l=0;l<lc;l++)
			System.out.print(c[l]+" ");
		
		
		
	}
}
public class OrderArr {

	public static void main(String[] args) {
		OrderArray arr;
		arr = new OrderArray(5,3);
		arr.insertA(10);
		arr.insertA(40);
		arr.insertA(30);
		arr.insertA(20);
		arr.insertA(50);
		arr.insertB(60);
		arr.insertB(90);
		arr.insertB(80);
		arr.displayA();
		arr.displayB();
		arr.merge();
		

	}

}
