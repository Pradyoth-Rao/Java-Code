/* Program 2.1 program to find the highest key in the array
 * Pradyoth Rao
 * ESE 554-Assignment 1
 */
class Arr1 {
		private long a[];
		private int maxel;
		public Arr1(int max)
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

public class MaxArr {

	public static void main(String[] args) {
		int maxsize=100;
		Arr1 arr;
		long maxi;
		arr = new Arr1(maxsize);
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
		maxi=arr.getmax();
		if(maxi==-1)
			System.out.print("\n Array empty");
		else
			System.out.print("\n The highest key is " + maxi);

	}

}
