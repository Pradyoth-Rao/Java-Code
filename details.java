package bank;
class employee {
		private int empid;
		private double salary;
		employee(int id,double sal)
		{
			empid = id;
			salary = sal;
		}
		public void display()
		{
			System.out.print("The employee id is:" + empid);
			System.out.print("\n The salary is:" + salary);
		}
}
public class details {

	public static void main(String[] args) {
		employee e1 = new employee(1,100);
		e1.display();
		
		
		// TODO Auto-generated method stub

	}

}
