
public class HighArray {
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
			for(i=0;i<maxel;i++)
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
		public boolean delete(int value)
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
			for(j=0;j<maxel;j++)
				System.out.println(a[j]+" ");
			System.out.println(" ");
		}
}
class highapp{
	public void main(String[] args)
	{
		int maxsize=100;
		HighArray arr;
		arr = new HighArray(maxsize);
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(11);
		arr.insert(00);
		arr.insert(33);
		arr.insert(66);
		arr.insert(88);
		arr.display();
		if(arr.find(88))
			System.out.print("\n Element found");
		else
			System.out.print("\n Not found");
		
		if(arr.delete(22))
			System.out.print("\n Element deleted");
		else
			System.out.println("Not found");
		arr.display();

	}
}

