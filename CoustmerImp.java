package storedbms;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class CoustmerImp extends StoreImp implements Coustmer 
{
	 double totalAmount;
	Scanner scan=new Scanner(System.in);
	LinkedHashMap<String,StoreManagmentSystemImp> coustmerImp=new LinkedHashMap<String,StoreManagmentSystemImp>();
//	-----------------------------------------------------------------------------------------------
	@Override
	public void selectItem()
	{
		System.out.println("enter the Item to Search");
		String item=scan.next();
		if(coustmer.containsKey(item))
		{
			int count=coustmer.get(item).getCount();
			System.out.println(count+"\tnumber of items available");
			System.out.println("enter the Quantity");
			int quantity=scan.nextInt();
			if(quantity<=count)
			{
				System.out.println("item added to cart");
			}
			else
			{
				try 
				{
					throw new LowStockException("LowStock");
				}
				catch (LowStockException e) 
				{
					System.out.println(e.getMessage()+"\tonly\t"+count+"\tnumber of items left");
				}
				
				
//---------------------------------------------------------------------------------------------------

				
//------------------------	   Billing       --------------------------------------------------------
				
				
				double cost=coustmer.get(item).getSellingPrice();
				totalAmount+=quantity*cost;
				StoreManagmentSystemImp coustmer=new StoreManagmentSystemImp(item, quantity, totalAmount);
				coustmerImp.put(item, coustmer);

			}
		}
		else
		{
			try
			{
				throw new ItemNotFoundException("item Not Found");
			}
			catch (ItemNotFoundException e)
			{
				System.out.println(e.getMessage());
			}			}
		
	}
//	--------------------------------------------------------------------------------------------------

	@Override
	public void showItems() 
	{
		Set<String> set= coustmerImp.keySet();
		if(set==null) 
		{
			System.out.println("No items added to show");
		}
		else
		{
			for(String s:set) 
			{
				System.out.println( coustmerImp.get(s));
			}
		}
	}
//	----------------------------------------------------------------------------------------------------

	
	@Override
	public void deletItem() 
	{
		System.out.println("enter the item name to delet:");
		String itemName=scan.next();
		if(coustmerImp.containsKey(itemName)) 
		{
			coustmerImp.remove(itemName);
		}
		else
		{
			try
			{
				throw new ItemNotFoundException("itemNotFound");
			}
			catch (ItemNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
//	--------------------------------------------------------------------------------------------------

	@Override
	public void raiseQuantity()
	{
		System.out.println("enter the item name to raise the quantity:");
		String itemName=scan.next();
		if(coustmerImp.containsKey(itemName)) 
		{
			System.out.println("Re-enter the quantity");
			int quantity=scan.nextInt();
			coustmerImp.get(itemName).setQuantity(quantity);
			System.out.println("quantity added");
		}
		else
		{
			try
			{
				throw new ItemNotFoundException("itemNotFound");
			}
			catch (ItemNotFoundException e) {
				System.out.println(e.getMessage());
			}	
		}

	}
	
	
//-----------------------------------------------------------------------------------------------------
	
	@Override
	public void decreaseQuantity() 
	{
		System.out.println("enter the item name to decrease the quantity:");
		String itemName=scan.next();
		if(coustmerImp.containsKey(itemName)) 
		{
			System.out.println("Re-enter the quantity");
			int quantity=scan.nextInt();
			coustmerImp.get(itemName).setQuantity(quantity);
			System.out.println("quantity added");
		}
		else
		{
			try
			{
				throw new ItemNotFoundException("itemNotFound");
			}
			catch (ItemNotFoundException e)
			{
				System.out.println(e.getMessage());
			}	
		}

	}
	
	
//	--------------------------------------------------------------------------------------------------
	

	@Override
	public void showTotalAmount() {
		System.out.println("Total Amount="+totalAmount);
	}
	
	
	
//	--------------------------------------------------------------------------------------------------

	
	@Override
	public void numberOfItemsAdded() {
		int count=coustmerImp.size();
			System.out.println(count+"\titems added");
		
	}

	@Override
	public void bill() {
		Payment pay=new Payment();
		pay.paymentMood();
	}
	

}
