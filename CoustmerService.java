package storedbms;

import java.util.Scanner;
import java.util.Set;



public class CoustmerService extends CoustmerImp {

	public static void main(String[] args) {
		CoustmerImp cst=new CoustmerImp();
		UserAdmin us=new UserAdmin();
		Scanner scan=new Scanner(System.in);
		boolean b=true;
		int user=0;
		System.out.println("WELCOM TO PAVAN PROVISION STORE");
		System.out.println("----------------------------------------------------------------");
		while(b) {
			System.out.println("1: Admin\n2: Coustmer");
			System.out.println("Enter choice to switch user");
			user=scan.nextInt();
			b=false;
		}
		while(true) {
			switch(user) 
			{
			case 1:
				us.user();
				break;
			case 2:
				System.out.println("---------------------------------------------------");
				System.out.println("1: List of items\n2: Select items\n3: View Item Details");
				System.out.println("4: Delet item\n5: Raise quantity\n6: Decrease quantity");
				System.out.println("7: TotalAmount\n8: Number of items selected\n9: Remove all\n10: Bill\n11: Exit");
				System.out.println("---------------------------------------------------");
				System.out.println("Enter choice");
				int choice=scan.nextInt();
				switch(choice) {
				case 1:
					Set<String> set=cst.coustmerImp.keySet();
					for(String s:set) {
					System.out.println(cst.coustmerImp.get(s));
					}
					break;
				case 2:
					cst.selectItem();
					break;
				case 3:
					System.out.println("Enter item name");
					String name=scan.next();
					if(cst.coustmerImp.containsKey(name))
					{
						System.out.println(cst.coustmerImp.get(name));
					}
					else
					{
						try
						{
						throw new ItemNotFoundException("Entered item not found");
						}
						catch (ItemNotFoundException e) 
						{
							System.out.println(e.getMessage());
						}
					}
					break;
				case 4:
					cst.deletItem();
					break;
				case 5:
					cst.raiseQuantity();
					break;
				case 6:
					cst.decreaseQuantity();
					break;
				case 7:
					cst.showTotalAmount();
					break;
				case 8:
					cst.numberOfItemsAdded();
					break;
				case 9:
					Set<String> set1=cst.coustmerImp.keySet();
					for(String s:set1) {
					System.out.println(cst.coustmerImp.remove(s));
					}
					System.out.println("All Items Removed");
					break;
				case 10:
					cst.bill();
					break;
				case 11:
					System.out.println("Thank You..........!");
					System.exit(0);
					break;
					default:
						System.out.println("Enter valid choice");
				}
			}
		}
	}
}