import java.io.*;
import java.util.Random;

class DataItem
{ 
private String iData; 
public DataItem(String ii)
{ iData = ii; }
public String getKey()
{ return iData; }
}

class HashTable
{
private DataItem[] hashArray; // array holds hash table
private static int arraySize;
// -------------------------------------------------------------
public HashTable(int size) // constructor
{
arraySize = size;
hashArray = new DataItem[arraySize];
new DataItem(null);
}
// -------------------------------------------------------------
public void displayTable()
{
System.out.print("Table: ");
for(int j=0; j<arraySize; j++)
{
if(hashArray[j] != null)
System.out.print(hashArray[j].getKey() + " ");
else
System.out.print("-- ");
}
System.out.println(" ");
}
public static int hashFunc(String key)
{
int hashVal = 0;
for(int j=0; j<key.length(); j++) // left to right
{
int letter = key.charAt(j) - 96; // get char code
hashVal = (hashVal * 27 + letter) % arraySize; 
}
return hashVal; 
} 

public void insert(DataItem item) // insert a DataItem
//(assumes table not full)
{
String key = item.getKey(); // extract key
int hashVal = hashFunc(key); // hash the key
//until empty cell or -1,
while(hashArray[hashVal] != null &&
hashArray[hashVal].getKey() != null)
{
++hashVal; // go to next cell
hashVal %= arraySize; // wraparound if necessary
}
hashArray[hashVal] = item; // insert item
} 
// end delete()
}//end class

public class Hash_String_App {

	public static void main(String[] args) throws IOException {
		DataItem aDataItem;
		String aKey;
		String s[]={"abc","cats","ijk","lmn","dogs","oop","ds","java","loop","ten"};
		int size, n;
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		//keysPerCell = 10;
		HashTable theHashTable = new HashTable(size);
		for(int j=0; j<n; j++)
		{
			aKey=s[j];
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		while(true) // interact with user
		{
		System.out.print("Enter first letter of ");
		System.out.print("show or Insert ");
		char choice = getChar();
		switch(choice)
		{
		case 's':
		theHashTable.displayTable();
		break;
		case 'i':
		System.out.print("Enter key value to insert: ");
		aKey = getString();
		aDataItem = new DataItem(aKey);
		theHashTable.insert(aDataItem);
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
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
	String s = getString();
	return Integer.parseInt(s);
	}
	public static String generateRandomChars(String candidateChars, int length) {
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	}

}
		


