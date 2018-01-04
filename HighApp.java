/* Program 2.2 The program to find the maximum key in the array and delete it.
 * Pradyoth Rao
 * ESE 554 Assignment 1.
 */

class HighArray {
		private long a[];
		private int maxel;
		public HighArray(int max)
		{
			a = new long[max];
			maxel = 0;
		}
		public boolean find(int key)
		{
			int i;
			for(i=0;i<=maxel;i++)
			{
				if(a[i]==key)
					break;
				else
					return false;
			}
			return true;
		}
		public void insert(int value)
		{
			a[maxel] = value;
			maxel++;
		}
		public boolean delete(long value)//function to delete a key in the array
		{
			int j;
			for(j=0;j<maxel;j++)
			{
				if(a[j]==value)
					break;
			}
				if(j==maxel)
					return false;
				else
				{
					int k;
					for(k=j;k<maxel;k++)
						a[k]=a[k+1];
					maxel--;
					return true;
				}
					
			
		}
		public void display()
		{
			int j;
			System.out.println("\n");
			for(j=0;j<maxel;j++)
				System.out.println(a[j]+" ");
		}
		public long getmax()//function to find the maximum array
		{
			long max=0,temp;
			if(maxel==0)
			{
				return -1;
			}
			else
			{
				for(int i=0;i<maxel;i++)
				{
					temp=a[i];
					if(temp>=max)
						max=temp;
				}
				return max;
			}
		}
}
public class HighApp {

	public static void main(String[] args) {
		int maxsize=100;
		HighArray arr;
		long maxi;
		arr = new HighArray(maxsize);
		arr.insert(77);//Inserting elements to the array
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(11);
		arr.insert(00);
		arr.insert(33);
		arr.insert(66);
		arr.insert(88);
		/*if(!arr.find(11))
			System.out.print("\n Element found");
		else
			System.out.print("\n Not found");
		*/
		System.out.print("\n The original array");
		arr.display();
		maxi=arr.getmax();
		if(maxi==-1)
			System.out.print("\n Array empty");
		else
		{
			System.out.print("\n The highest key is " + maxi);
			arr.delete(maxi);
			System.out.print("\n The deleted element is" + maxi);
		}
		System.out.print("\n The new array is");
		arr.display();

	}

}
