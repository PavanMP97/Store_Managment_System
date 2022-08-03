package storedbms;

import java.util.Scanner;

import edbms.EmplloyeeNotFoundExcaption;
import edbms.EmployeeImpl;
import edbms.EmployeeRegistration;


public class UserAdmin 
{
	EmployeeImpl emp=new EmployeeImpl();
	EmployeeRegistration reg=new EmployeeRegistration();
	Scanner scan=new Scanner(System.in); 
	StoreImp strimp=new StoreImp();
	void user() 
	{
		System.out.println("Only for Admin");
		System.out.println("1: Register Employee\n2: Store Managment");
		System.out.println("enter choice");
		int ch=scan.nextInt();
		switch(ch)
		{
		case 1:
			reg.main(null);
			break;
		case 2:
			System.out.println("Enter id: ");
			int id=scan.nextInt();
			if(emp.getDb().containsKey(id)) 
			{
				System.out.println("Enter Password: ");
				int password=scan.nextInt();
				if(password==emp.getDb().get(id).getPassword()) 
				{
					System.out.println("WELCOME TO ADMIN THE SYSTEM IS IN ADMIN MODE");
					System.out.println("---------------------------------------------------------");
					while(true) 
					{
						System.out.println("1: Add Item\n2: Remove Item\n3: Count Item\n4: Total Transcation Of Item");
						System.out.println("5: totalTranscationOfMoney\n6: Add new Admin\n7: Delet Admin\\n8: Exit");

						//					 Reset Password :- yet to Implement

						System.out.println("Enter the choice: ");
						int choice=scan.nextInt();
						switch(choice) {
						case 1:
							strimp.addItems();
							break;
						case 2:
							strimp.removeItems();
							break;
						case 3:
							strimp.count();
							break;
						case 4:
							strimp.totalTranscationOfItem();
							break;
						case 5:
							strimp.totalTranscationOfMoney();
							break;
						case 6:
							emp.addEmployee();
							break;
						case 7:
							strimp.removeItems();
							break;
						case 8:
							System.out.println("THANK YOU....................!");
							System.exit(0);
							break;
						default:
							System.out.println("enter a Valid Choice");
						}
					}
				}
				else
				{
					try 
					{
						throw new PasswordIncorrectException("Password Incorrect");
					}
					catch (PasswordIncorrectException e) 
					{
						System.out.println(e.getMessage());
					}
				}
			}
			else
			{
				try 
				{
					throw new EmplloyeeNotFoundExcaption("Entered ID Not Found.....!");
				}
				catch (EmplloyeeNotFoundExcaption e)
				{
					System.out.println(e.getMessage());
				}
			}
		default:
			System.out.println("enter vaild choice");
			break;
		}

	}
}
