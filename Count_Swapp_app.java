/* Program 7.2
 * Pradyoth Rao
 * ESE 554
 */
class ArrayIns{
	public int[] a;
	private int n;
	public int copies_count;
	public int comp_count;
	public ArrayIns(int max)
	{
		a= new int[max];
		n=0;
		copies_count=0;
		comp_count=0;
	}
	public void insert(int value)
	{
		a[n]=value;
		n++;
	}
	public int size()
	{
		return n;
	}
	public void display()
	{
		System.out.print("A=");
		for(int j=0;j<n;j++)
			System.out.print(a[j]+" ");
		System.out.print(" ");
	}
	public void quickSort()
	{
	recQuickSort(0, n-1);
	}
	public void recQuickSort(int left, int right)
	{
	int size = right-left+1;
	if(size <= 3)
	manualSort(left, right);
	else 
	{
	long median = medianOf3(left, right);
	int partition = partitionIt(left, right, median);
	recQuickSort(left, partition-1);
	recQuickSort(partition+1, right);
	}
	} 
	public long medianOf3(int left, int right)
	{
	int center = (left+right)/2;
	if( a[left] > a[center] )
	{
		swap(left, center);
		comp_count++;
		copies_count+=3;
	}
	if( a[left] > a[right] )
	{
		swap(left, right);
		copies_count+=3;
		comp_count++;
	}
	if( a[center] > a[right] )
	{
		swap(center, right);
		copies_count+=3;
		comp_count++;
	}
	swap(center, right-1);
	copies_count+=3;
	return a[right-1]; 
	} 
	public void swap(int dex1, int dex2) // swap two elements
	{
	int temp = a[dex1];
	a[dex1] = a[dex2]; 
	a[dex2] = temp;
	} 
	public int partitionIt(int left, int right, long pivot)
	{
	int leftPtr = left;
	int rightPtr = right - 1;
	while(true)
	{
	while( a[++leftPtr] < pivot )
	{comp_count++;}
	; 
	while( a[--rightPtr] > pivot ) 
	{comp_count++;}
	; 
	if(leftPtr >= rightPtr) 
	break; 
	else 
	swap(leftPtr, rightPtr); 
	} 
	swap(leftPtr, right-1); 
	return leftPtr; 
	} 
	public void manualSort(int left, int right)
	{
	int size = right-left+1;
	if(size <= 1)
	return; 
	if(size == 2)
	{ 
	if( a[left] > a[right] )
	{
		swap(left, right);
		copies_count+=3;
		comp_count++;
	}
	return;
	}
	else 
	{ 
	if( a[left] > a[right-1] )
	{
		swap(left, right-1);
		copies_count+=3;
		comp_count++;
	}
	if( a[left] > a[right] )
	{
		swap(left, right);
		copies_count+=3;
		comp_count++;
	}
	if( a[right-1] > a[right] )
	{
		swap(right-1, right);
		copies_count+=3;
		comp_count++;
	}
	}
	}
}
	
	
public class Count_Swapp_app {

	public static void main(String[] args) {
		int maxSize = 10; 
		ArrayIns arr; 
		arr = new ArrayIns(maxSize);
		for(int j=0; j<maxSize; j++)
		{ 
		int n = (int)(java.lang.Math.random()*99);
		arr.insert(n);
		}
		arr.display(); 
		arr.quickSort(); 
		arr.display();
		int con=arr.comp_count;
		int cop=arr.copies_count;
		System.out.println("\n The copy count is"+cop+"\n The comparison count is"+con);

	}

}
