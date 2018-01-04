/* Program 5.1-Demonstrates the priority queue using linked list
 * Pradyoth Rao
 * ESE 554
 */
class link
{
	public long item;
	public link next;
	public link(long a)
	{
		item=a;
	}
	public void displaylink()
	{
		System.out.print(item + " ");
	}
}
	class priority{
		private link first;
		public priority()
		{
			first=null;
		}
		public boolean isempty()
		{
			return(first==null);
		}
		public void insert(long data)
		{
			link n1=new link(data);
			link prev=null;
			link current=first;
			while(current!=null&&data>current.item)
			{
				prev=current;
				current=current.next;
			}
			if(prev==null)
				first=n1;
			else
				prev.next=n1;
			n1.next=current;
		}
		public link remove()
		{
			link temp=first;
			first=first.next;
			return temp;
		}
		public void display()
		{
			if(isempty())
			{
				System.out.print("\n The list is empty");
			}
			else
			{
			System.out.print("The list is: \n");
			link current=first;
			while(current!=null)
			{
				current.displaylink();
				current=current.next;
			}
			System.out.print("\n");
			}
		}
}
		

	

public class priotiyqueue {

	public static void main(String[] args) {
		priority p_q=new priority();
		p_q.insert(10);
		p_q.insert(20);
		p_q.insert(60);
		p_q.insert(30);
		p_q.insert(40);
		p_q.insert(50);
		p_q.display();
		while(!p_q.isempty())
		{
			p_q.remove();
			p_q.display();
		}
		
	}

}
