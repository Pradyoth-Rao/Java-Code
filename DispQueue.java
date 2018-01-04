/* Program 4.1-Program to display the contents of the queue
 * Pradyoth Rao
 * ESE 554
 */
class queue{
	private int maxsize;
	private long[] queuearr;
	private int front;
	private int rear;
	private int nitems;
	
	public queue(int s)
	{
		maxsize=s;
		queuearr=new long[maxsize];
		front=0;
		rear=-1;
		nitems=0;
	}
	public void insert(int s)
	{
		if(rear==maxsize-1)
			rear=-1;
		queuearr[++rear]=s;
		nitems++;
		display();
	}
	public long remove()
	{
		long temp=queuearr[front++];
		if(front==maxsize)
			front=0;
		nitems--;
		return temp;
		
	}
	public long peekfront()
	{
		return(queuearr[front]);
	}
	public long peekrear()
	{
		return(queuearr[rear]);
	}
	public boolean isempty()
	{
		if(nitems==0)
			return true;
		else
			return false;
	}
	public boolean isfull()
	{
		if(nitems==maxsize)
			return true;
		else
			return false;
	}
	public int size()
	{
		return nitems;
	}
	public void display()
	{
		if(isempty())
			System.out.print("\n The queue is empty");
		else if(isfull())
			System.out.print("\n The queue is full");
		else
		{
			System.out.print("\n The contents of the queue is: \n");
			for(int i=front;i<=rear;i++)
			{
				System.out.print(queuearr[i]+" ");
			}
		}
	}
}
public class DispQueue {

	public static void main(String[] args) {
		queue q1=new queue(6);
		q1.display();
		q1.insert(10);
		q1.insert(20);
		q1.insert(30);
		q1.insert(40);
		q1.insert(50);
		q1.insert(60);
		while(!q1.isempty())
		{
			q1.remove();
			q1.display();
		}
	}
}
