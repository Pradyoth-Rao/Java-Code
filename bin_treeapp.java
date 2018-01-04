/* Program 6.2- Program to form a binary tree pattern using recursion
 * Pradyoth Rao
 * ESE 554
 */

class bt{
	public void tree(String[][] ch,int i,int n, int count)
	{
		if(i>n)
			return;
		else
		{
			int mid=(i+n)/2;
			ch[count][mid]="x";
			count++;
			if(count>4)
				count=0;
			tree(ch,i,mid-1,count);
			tree(ch,mid+1,n,count);
		}
	}
	public void display(String ch[][],int it,int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print("\n");
			for(int j=0;j<n;j++)
				System.out.print(ch[i][j]+" ");
		}
	}
}
public class bin_treeapp {

	public static void main(String[] args) {
		bt b=new bt();
		String ch[][]=new String[5][16];
		for(int i=0;i<=4;i++)
			for(int j=0;j<16;j++)
			{
				ch[i][j]="-";
			}
		b.tree(ch,0,15,0);
		for(int j=0;j<16;j++)
			ch[4][j]="x";
		b.display(ch, 0, 15);
		

	}

}
