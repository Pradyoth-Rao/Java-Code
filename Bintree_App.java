import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class node{
	public String data;
	public node left;
	public node right;
	
	public void displayNode()
	{
		System.out.print("{");
		System.out.print(data);
		System.out.print("}");
	}
}
class tree{
private node root;

public tree(String str){

	root = null;
	
	node[] forrest = new node[str.length()];
	for(int i=0;i<str.length();i++){
		forrest[i]= new node();
		forrest[i].data = String.valueOf(str.charAt(i));
		
		node plus = new node();
		plus.data = "+";
		plus.left  = forrest[0];
		plus.right = forrest[1];
		
		for(int j =2; j<forrest.length;j++){
			node newNode = new node();
			newNode.data = "+";
			newNode.left = plus;
			newNode.right = forrest[j];
			plus = newNode;
		}
		root = plus;
		
	}
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
private void preOrder(node localRoot)
{
	if(localRoot != null)
	{
		System.out.print(localRoot.data + " ");
		preOrder(localRoot.left);
		preOrder(localRoot.right);
	}	
}

private void inOrder(node localRoot)
{
	if(localRoot != null)
	{
		inOrder(localRoot.left);
		System.out.print(localRoot.data + " ");
		inOrder(localRoot.right);
	}
}
private void postOrder(node localRoot)
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
			node temp = (node)globalStack.pop();
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






public class Bintree_App {

	public static void main(String[] args) throws IOException  {
		int value;
		String str;
		System.out.print("\n Enter the input string of alphabets");
		str=getString();
		tree theTree = new tree(str);
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


