/* Program 6.1-Program to perform recursive addition
 * Pradyoth Rao
 * ESE 554 */
class multiplication{
	

public int mult(int x,int y)
{
	if(y==1)
		return x;
	else
		return (x+mult(x,y-1));
}
}
public class Multiplication_app {

	public static void main(String[] args) {
		multiplication m=new multiplication();
		int a;
		a=m.mult(16,6);
		System.out.print("The product is " + a);
		}

}
