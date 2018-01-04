/* Program 5.2-DEqueue implementation using doubly linked list
 * Pradyoth Rao
 * ESE 554
 */
import java.io.*;
class link1{
	public long data;
	public link1 next;
	public link1 prev;
	public link1(long dd)
	{
		data=dd;
	}
	public void display()
	{
		System.out.print(data +" ");
	}
}
class dequeue{
	private link1 first;
	private link1 last;
	public dequeue()
	{
		first=null;
		last=null;
	}
	public boolean isempty()
	{
		return(first==null);
	}
	public void insert_left(long dd)
	{
		link1 n1= new link1(dd);
		if(isempty())
			last=n1;
		else
			first.prev=n1;
		n1.next=first;
		first=n1;
	}
	public void insert_right(long dd)
	{
		link1 n1= new link1(dd);
		if(isempty())
			first=n1;
		else
		{
			last.next=n1;
			n1.prev=last;
		}
		last=n1;
	}
	public link1 delete_right()
	{
		link1 temp=last;
		if(first.next==null)
			first=null;
		else
			last.prev.next=null;
		last=last.prev;
		return temp;
	}
	public link1 delete_left()
	{
		link1 temp=first;
		if(first.next==null)
			last=null;
		else
			first.next.prev=null;
		first=first.next;
		return temp;
	}
	public void display_left()
	{
		System.out.println("\n Queue from left->right: \n");
		link1 current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		System.out.print(" ");
	}
	public void display_right()
	{
		System.out.println("\n Queue from right->left: \n");
		link1 current=last;
		while(current!=null)
		{
			current.display();
			current=current.prev;
		}
		System.out.print(" ");
	}
	
}
public class DEqueue_App {

	public static void main(String[] args)throws IOException {
		dequeue q1=new dequeue();
		q1.insert_left(10);
		q1.insert_left(20);
		q1.insert_left(50);
		q1.insert_right(80);
		q1.insert_right(90);
		q1.insert_right(70);
		q1.display_left();
		q1.display_right();
		q1.delete_left();
		q1.delete_right();
		q1.display_left();
		q1.display_right();
		}

}
