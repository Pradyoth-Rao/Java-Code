import java.io.*;
////////////////////////////////////////////////////////////////
class Data_Item
{ // (could have more data)
private int iData; // data item (key)
//--------------------------------------------------------------
public Data_Item(int ii) // constructor
{ iData = ii; }
//--------------------------------------------------------------
public int getKey()
{ return iData; }
//--------------------------------------------------------------
} 
class Hash_Table
{
private Data_Item[] hashArray; // array holds hash table
private Data_Item nonItem;
private int arrayssize;// for deleted items
// -------------------------------------------------------------
public Hash_Table(int ssize) // constructor
{
arrayssize = ssize;
hashArray = new Data_Item[arrayssize];
nonItem = new Data_Item(-1); // deleted item key is -1
}
// -------------------------------------------------------------
public void displayTable()
{
System.out.print("Table: ");
for(int j=0; j<arrayssize; j++)
{
if(hashArray[j] != null)
System.out.print(hashArray[j].getKey() + " ");
else
System.out.print("-- ");
}
System.out.println(" ");
}
public int hashFunc(int key)
{
 int rem,sum=0;
 while(key!=0)
 {
	 rem= key%arrayssize;
	 sum+=rem;
	 key=key/arrayssize;
 }
 return sum;
}
public void insert(Data_Item item) // insert a Data_Item
//(assumes table not full)
{
int key = item.getKey(); // extract key
int hashVal = hashFunc(key); // hash the key
//until empty cell or -1,
while(hashArray[hashVal] != null &&hashArray[hashVal].getKey() != -1)
{
++hashVal; // go to next cell
hashVal %= arrayssize; // wraparound if necessary
}
hashArray[hashVal] = item; // insert item
}
public Data_Item delete(int key) // delete a Data_Item
{
int hashVal = hashFunc(key); // hash the key
while(hashArray[hashVal] != null) // until empty cell,
{ // found the key?
if(hashArray[hashVal].getKey() == key)
{
Data_Item temp = hashArray[hashVal]; // save item
hashArray[hashVal] = nonItem; // delete item
return temp; // return item
}
++hashVal; // go to next cell
hashVal %= arrayssize; // wraparound if necessary
}
return null; // can’t find item
} // end delete()
// -------------------------------------------------------------
public Data_Item find(int key) // find item with key
{
int hashVal = hashFunc(key); // hash the key
while(hashArray[hashVal] != null) // until empty cell,
{ // found the key?
if(hashArray[hashVal].getKey() == key)
return hashArray[hashVal]; // yes, return item
++hashVal; // go to next cell
hashVal %= arrayssize; // wraparound if necessary
}
return null; // can’t find item
}
}
public class Hash_folding {
	public static void main(String[] args) throws IOException{
		Data_Item aData_Item;
		int a_Key, ssize, n, keysPerCell;
		System.out.print("Enter ssize of hash table: ");
		ssize = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		// make table
		Hash_Table theHash_Table = new Hash_Table(ssize);
		for(int j=0; j<n; j++) // insert data
		{
		a_Key = (int)(java.lang.Math.random() *keysPerCell * ssize);
		aData_Item = new Data_Item(a_Key);
		theHash_Table.insert(aData_Item);
		}
		while(true) // interact with user
		{
		System.out.print("Enter first letter of ");
		System.out.print("show, insert, delete, or find: ");
		char choice = getChar();
		switch(choice)
		{
		case 's':
		theHash_Table.displayTable();
		break;
		case 'i':
		System.out.print("Enter key value to insert: ");
		a_Key = getInt();
		aData_Item = new Data_Item(a_Key);
		theHash_Table.insert(aData_Item);
		break;
		case 'd':
			System.out.print("Enter key value to delete: ");
			a_Key = getInt();
			theHash_Table.delete(a_Key);
			break;
			case 'f':
			System.out.print("Enter key value to find: ");
			a_Key = getInt();
			aData_Item = theHash_Table.find(a_Key);
			if(aData_Item != null)
			{
			System.out.println("Found " + a_Key);
			}
			else
			System.out.println("Could not find " + a_Key);
			break;
		default:
			System.out.print("Invalid entry\n");
		} // end switch
	} // end while
} // end main()
	public static String getString() throws IOException
	{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;
	}
	//--------------------------------------------------------------
	public static char getChar() throws IOException
	{
	String s = getString();
	return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
	String s = getString();
	return Integer.parseInt(s);
	}	

}


