import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class inode{
	public String data;
	public inode left;
	public inode right;
	
	public void displayinode()
	{
		System.out.print("{");
		System.out.print(data);
		System.out.print("}");
	}
}
class BalTree {

private inode root;

	public BalTree(String str){
	
		root = null;
		int nElems = 0;
		
		inode[] nArray = new inode[str.length()];
		for(int i=0;i<str.length();i++){
			nArray[i]= new inode();
			nArray[i].data = String.valueOf(str.charAt(i));
			nElems++;
		}
			while(nElems>1){
				int count =0;
				for(int j =0; j<nElems; j++){
					if(j%2==1){
						inode tempinode = new inode();
						tempinode.data = "+";
						tempinode.left  = nArray[j-1];
						tempinode.right = nArray[j];
						nArray[count]= tempinode;
						count++;
						
					}
					if(j%2==0 && j == nElems-1){
						nArray[count] = nArray[j];
					}
				}
					nElems -= count;
				}
				root = nArray[0];
			}

	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal: ");
		preOrder(root);
		break;
		case 2: System.out.print("\nInorder traversal: ");
		inOrder(root);
		break;
		case 3: System.out.print("\nPostorder traversal: ");
		postOrder(root);
		break;
		}
		System.out.println();
	}


	private void preOrder(inode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.data + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}	
	}

	private void inOrder(inode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.left);
			System.out.print(localRoot.data + " ");
			inOrder(localRoot.right);
		}
	}
	private void postOrder(inode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data + " ");
		}
	}
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while(isRowEmpty==false)
		{

			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				inode temp = (inode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.data);
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
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		} // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	} // end displayTree()

}

public class Balance_Bintree {

	public static void main(String[] args) throws IOException {
		int value;
		String str;
		System.out.print("\n Enter the input string of alphabets");
		str=getString();
		BalTree theTree = new BalTree(str);
		while(true)
		{
			System.out.print("Enter first letter of show, " + "or traverse ");
			int choice = getChar();
			switch(choice)
			{
			case 's':
				theTree.displayTree();
				break;
			case 't':
				System.out.print("Enter type 1, 2 or 3: ");
				value = getInt();
				theTree.traverse(value);
			break;
			default:
				System.out.print("Invalid entry\n");
			} 
	} 
} 
	
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



}


