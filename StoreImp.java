package storedbms;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class StoreImp implements Store{
	Scanner scan=new Scanner(System.in);
	LinkedHashMap<String,StoreDetails> coustmer=new LinkedHashMap<String,StoreDetails>();
	LinkedHashMap<String,StoreDetails> admin=new LinkedHashMap<String,StoreDetails>();
	
	@Override
	public void addItems() {
		System.out.println("Enter item name to add:");
		String itemName=scan.next();
		System.out.println("Enter number of items to add:");
		int numberOfItems=scan.nextInt();
		System.out.println("Enter Cost Price:");
		double costPrice=scan.nextDouble();
		System.out.println("Enter Selling Price:");
		double sellingPrice=scan.nextDouble();
		System.out.println("enter GST to incluude");
		double gst=scan.nextDouble();
		StoreDetails str=new StoreDetails(itemName, numberOfItems, costPrice, sellingPrice, gst);
		admin.put(itemName, str);
		coustmer.put(itemName, str);
		System.out.println("Item added sucessfully");
	}
	@Override
	public void removeItems()
	{
		System.out.println("Enter the item name to remove");
		String itemName=scan.next();
		if(coustmer.containsKey(itemName))
		{
			admin.remove(itemName);
			System.out.println("Item removed succesfully");
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
	@Override
	public void count() {
		System.out.println("Enter item name:");
		String itemName=scan.next();
		if(coustmer.containsKey(itemName))
		{
			System.out.println( coustmer.get(itemName).getCount()+"\tnumber of items available");
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
	@Override
	public void totalTranscationOfItem() 
	{
		Set<String> addedSet=admin.keySet();
		Set<String> soldSet=coustmer.keySet();
		for(String s:addedSet) 
		{
			int addedCount=admin.get(addedSet).getCount();
			for(String s1:soldSet)
			{
				int soldCount=coustmer.get(soldSet).getCount();
				int count=addedCount-soldCount;
				if(count!=addedCount) 
				{
					System.out.println(coustmer.get(soldSet).getItemName()+":\t"+count+"\t number of item sold");
				}
				else
				{
					System.out.println("Item not sold\t"+addedCount+"\tnumber of items remains same");
				}
				break;
			}
		}
	}
	@Override
	public void totalTranscationOfMoney() {
		double totalCostPriceAmount=0;
		Set<String> addedSet=admin.keySet();
		Set<String> soldSet=coustmer.keySet();
		for(String s:addedSet) 
		{
			int addedCount=admin.get(addedSet).getCount();
			for(String s1:soldSet)
			{
				int soldCount=coustmer.get(soldSet).getCount();
				double costPrice=coustmer.get(soldSet).getCostPrice(),sellingPrice=admin.get(soldSet).getSellingPrice();
				int count=addedCount-soldCount;
				if(count!=addedCount) 
				{
					totalCostPriceAmount+=costPrice*count;
				}
				else
				{
					System.out.println("Item not sold\t"+addedCount+"\tnumber of items remains same");
				}
				break;
			}
		}
		System.out.println("Total Transaction Amount="+totalCostPriceAmount);
	}

}
