/*Program 4.4-Inverse priority
 * Pradyoth Rao
 * ESE 554 
 */
class priorityq{
	private int maxsize;
	private long[] q;
	public int nitems;
	public priorityq(int s)
	{
		maxsize=s;
		q=new long[maxsize];
		nitems=0;
	}
	public void insert(int value)
	{
		q[nitems]=value;
		nitems++;
		display();
	}
	public long remove()
	{
		for(int i=0;i<nitems;i++)
		{
			for(int j=0;j<nitems-1;j++)
			{
				if(q[j]>q[j+1])
				{
					long temp=q[j];
					q[j]=q[j+1];
					q[j+1]=temp;
				}
			}
		}
		display();
		return q[--nitems];
		
	}
	public boolean isempty()
	{
		return (nitems==0);
	}
	public boolean isfull()
	{
		return (nitems==maxsize);
	}
	public void display()
	{
		if(isempty())
			System.out.print("\n The queue is empty");
		else if(isfull())
			System.out.print("\n The queue is full");
		else
		{
			System.out.print("\n The content of the queue is: ");
			for(int j=0;j<nitems;j++)
				System.out.print(q[j]+" ");
		}
	}
}
public class Priority_Delete {

	public static void main(String[] args) {
		priorityq q1 = new priorityq(6);
		q1.insert(10);
		q1.insert(50);
		q1.insert(40);
		q1.insert(30);
		q1.insert(20);
		while(!q1.isempty())
		{
			long k=q1.remove();
			System.out.print("\n The removed element is: " + k);
		}
		q1.display();
		
	}

}
