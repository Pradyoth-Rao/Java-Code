//Pradyoth Rao
//ESE 554
//Chapter 12, Exercise 2: Create a toss() function that throws new values 
//at the end of the array. Then make a restoreHeap() function that puts 
//everything in order using heapsort.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class HeapNode
{
private int iData; // data item (key)
// -------------------------------------------------------------
public HeapNode(int key) // constructor
{ iData = key; }
// -------------------------------------------------------------
public int getKey()
{ return iData; }
// -------------------------------------------------------------
public void setKey(int id)
{ iData = id; }
// -------------------------------------------------------------
} // end class Node
class TossHeap
{
	private HeapNode[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public TossHeap(int mx)
	{
		maxSize = mx;
		currentSize = 0;
		heapArray = new HeapNode[maxSize];
	}
	
	public boolean isEmpty() {return currentSize==0;}
	
	public void toss(int key) //just throws a new node at the end of the array
	{
		HeapNode newNode = new HeapNode(key);
		heapArray[currentSize] = newNode;
		currentSize++;
	}
	
	public void restoreHeap()
	{
		for(int j=(currentSize/2)-1; j >= 0; j--) // go through all nodes with children
			trickleDown(j);
	}
	
	
	public void trickleUp(int index)
	{
		int parent = (index-1) / 2;
		HeapNode bottom = heapArray[index];
		while( index > 0 && heapArray[parent].getKey() > bottom.getKey() )
		{
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = bottom;
	}
	
	public HeapNode remove()
	{
		HeapNode root = heapArray[0]; //save root for function return
		heapArray[0] = heapArray[--currentSize];	//put the last node at the root
		trickleDown(0);				//then trickle it down to appropriate place
		return root;
	}
	
	public void trickleDown(int index)
	{
		int smallerChild;
		HeapNode top = heapArray[index];
		while(index < currentSize/2) //while node has at least one child
		{
			int leftChild = 2*index+1;
			int rightChild = leftChild+1;
			if(rightChild < currentSize && //rightchild exists?
					heapArray[leftChild].getKey() >
					heapArray[rightChild].getKey() )
				smallerChild = rightChild;
			else
				smallerChild = leftChild;
			if(top.getKey() <= heapArray[smallerChild].getKey() )
				break;
			
			heapArray[index] = heapArray[smallerChild];
			index = smallerChild;
		}
		heapArray[index] = top;
	}
	
	
	
	public void displayHeap()
	{
		System.out.print("heapArray: ");
		for(int m = 0; m<currentSize; m++)
			if(heapArray != null)
				System.out.print(heapArray[m].getKey() + " ");
			else
				System.out.print("-- ");
		System.out.println();
		
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "............................";
		System.out.println(dots+dots);
		
		while(currentSize > 0)
		{
			if(column == 0)
				for(int k=0; k<nBlanks; k++)
					System.out.print(' ');
			System.out.print(heapArray[j].getKey());
			if(++j == currentSize)
				break;
			
			if(++column == itemsPerRow)
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			}
			else
				for(int k = 0; k<nBlanks*2-2; k++)
					System.out.print(' ');
		}
		System.out.println("\n"+dots+dots);
	}
} //end class Heap

class Toss_Heap
{
	public static void main(String[] args) throws IOException
	{
		int value;
		TossHeap theHeap = new TossHeap(31);
		//boolean success;
		
		
		theHeap.toss(80);
		theHeap.toss(30);
		theHeap.toss(10);
		theHeap.toss(90);
		
		while(true)
		{
			System.out.print("Enter first letter of ");
			System.out.print("show,delete,restore, toss: ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theHeap.displayHeap();
				break;
			
			case 'd':
				if(!theHeap.isEmpty())
					theHeap.remove();
				else
					System.out.println("Can't remove; heap empty");
				break;
			case 'r':
				theHeap.restoreHeap();
				break;
			case 't':
				System.out.print("Enter value to toss: ");
				value = getInt();
				theHeap.toss(value);
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
} //end class HeapApp