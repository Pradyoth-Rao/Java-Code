//Chapter 12, Exercise 5: Write a program that implements the tree heap 
//Pradyoth Rao
//ESE 554


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Node
{
	public int e;			//data item (key)
	public Node left;
	public Node right;
	public Node parent;
	boolean isleft = false;
	
	public int getKey() {return e;}
	public void setKey(int id) {e = id;}
	
	public void display()
	{ System.out.print(getKey() + " "); }
}

class TreeHeap
{
	private Node root;
	private int numNodes;
	
	public TreeHeap()
	{
		numNodes = 0;
		root = new Node();
	}
	
	public boolean isEmpty() {return numNodes==0;}
	
	//find next empty node and insert it there
	public void insert(int key)
	{
		Node newNode = new Node();
		newNode.setKey(key);
		if(numNodes == 0) root = newNode;
		else
		{
			//find place to put newNode
			Node current = root;
			int n = numNodes+1;
			int k;
			int[] path = new int[n];
			int j = 0;
			while(n >= 1)
			{
				path[j] = n % 2;
				n /= 2;
				j++;
			}
			//find parent of new child
			for(k = j-2; k > 0; k--)
			{
				if(path[k] == 1)
					current = current.right;
				else
					current = current.left;
			}
			//find which child new node should go into
			
			if(current.left != null)
			{
				current.right = newNode;
				newNode.isleft = false;
			}
			else
			{
				current.left = newNode;
				newNode.isleft = true;
			}
			newNode.parent = current;
			
			trickleUp(newNode);
		}
		numNodes++;
	}
	
	//modify to copy values from node to parent
	public void trickleUp(Node newNode)
	{
		int bottom = newNode.getKey();
		Node current = newNode;
		while( current.parent != null && current.parent.getKey() < bottom )
		{
			current.setKey(current.parent.getKey());
			current = current.parent;
		}
		current.setKey(bottom);
	}
	
	//remove root node
	public Node remove()
	{
		Node removedNode = root;
		if(numNodes==0) return null;
		//only root exists
		if(numNodes==1)
		{
			root = null;
			numNodes--;
			return removedNode;
		}
		//put the last node at the root
		//find last node
		Node current = root;
		int n = numNodes;
		int k;
		int[] path = new int[n];
		int j = 0;
		while(n >= 1)
		{
			path[j] = n % 2;
			n /= 2;
			j++;
		}
		//find parent of new child
		for(k = j-2; k >= 0; k--)
		{
			if(path[k] == 1)
				current = current.right;
			else
				current = current.left;
		}
		root.setKey(current.getKey());
		//erase the last node
		if(current.isleft)
			current.parent.left = null;
		else
			current.parent.right = null;
		trickleDown(root);				//then trickle it down to appropriate place
		numNodes--;
		return removedNode;
	}
	
	//modify to copy values from node to child
	public void trickleDown(Node newNode)
	{
		Node current = newNode;
		int top = newNode.getKey();
		Node largerChild;
		while(current.left != null || current.right != null) //while node has at least one child
		{
			if(current.right != null && //right exists?
					current.left.getKey() <
					current.right.getKey() )
				largerChild = current.right;
			else
				largerChild = current.left;
			if(top >= largerChild.getKey() )
				break;
			
			current.setKey(largerChild.getKey());
			current = largerChild;
		}
		current.setKey(top);
	}
	
	public boolean change(int index, int newValue)
	{
		if(index<0 || index>numNodes)
			return false;
		
		//find node at specified index
		Node current = root;
		int n = index;
		int k;
		int[] path = new int[n];
		int j = 0;
		while(n >= 1)
		{
			path[j] = n % 2;
			n /= 2;
			j++;
		}
		//find parent of new child
		for(k = j-2; k >= 0; k--)
		{
			if(path[k] == 1)
				current = current.right;
			else
				current = current.left;
		}
		
		int oldValue = current.getKey();
		current.setKey(newValue);
		
		if(oldValue < newValue)
			trickleUp(current);
		else
			trickleDown(current);
		return true;
	}
	
	public void display()
	{
		Stack<Node> globalStack = new Stack<Node>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		".......................................................");
		while(isRowEmpty==false)
		{
			Stack<Node> localStack = new Stack<Node>();
			isRowEmpty = true;
			
			for(int j = 0; j < nBlanks; j++)
				System.out.print(" ");
			
			while(globalStack.isEmpty() == false)
			{
				Node temp = globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.e);
					localStack.push(temp.left);
					localStack.push(temp.right);
					
					if(temp.left != null ||
							temp.right != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j = 0; j < nBlanks*2 - 2; j++)
					System.out.print(" ");
			} //end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty() == false)
				globalStack.push( localStack.pop() );
		} //end while isRowEmpty is false
		System.out.println(
		".......................................................");
	} //end display()
} //end class TreeHeap

class Tree_heap
{
	public static void main(String[] args) throws IOException
	{
		int value, value2;
		TreeHeap theHeap = new TreeHeap();
		boolean success;
		
		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		
		while(true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, remove, change: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theHeap.display();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				theHeap.insert(value);
				break;
			case 'r':
				if(!theHeap.isEmpty())
					theHeap.remove();
				else
					System.out.println("Can't remove; heap empty");
				break;
			case 'c':
				System.out.print("Enter current index of item: ");
				value = getInt();
				System.out.print("Enter new key: ");
				value2 = getInt();
				success = theHeap.change(value, value2);
				if(!success)
					System.out.println("Invalid index\n");
				break;
			default:
				System.out.println("Invalid entry!\n");
			} //end switch
		} //end while
	} //end main
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
} //end class TreeHeapApp