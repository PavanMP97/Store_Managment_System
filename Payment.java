package storedbms;

import java.util.Scanner;

interface PamentGateway{
	void payment() ;
}
class PhonePe implements PamentGateway{

	@Override
	public void payment() {
		System.out.println("paying through phonepe");		
	}

}
class GooglePay implements PamentGateway{

	@Override
	public void payment() {
		System.out.println("paying through Googlepe");		
	}

}
class Paytm implements PamentGateway{
	@Override
	public void payment() {
		System.out.println("paying through paytem");		
	}
}
class Person{
	String name;
	PamentGateway gateway;
	public Person(String name, PamentGateway gateway) {
		super();
		this.name = name;
		this.gateway = gateway;
	}

}
public class Payment {
	Person per;
	Scanner scan=new Scanner(System.in);
	void paymentMood() {
		System.out.println("Enter your name");
		String name=scan.next();
		System.out.println("Enter Payment Method: ");
		System.out.println("1: PhonePe\n2: GooglePay\n3: Paytm");
		System.out.println("Enter Choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			per=new Person(name, new PhonePe());
			System.out.println("Payment Done");
			break;
		case 2:
			per=new Person(name, new GooglePay());
			System.out.println("Payment Done");
			break;
		case 3:
			per=new Person(name, new Paytm());
			System.out.println("Payment Done");
			break;
		}
	}

}

