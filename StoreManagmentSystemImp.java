package storedbms;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class StoreManagmentSystemImp {
	private String itemName;
	private int Quantity;
	private double totalAmount;
//	------------------------------------------------------------------------------------
	
	public StoreManagmentSystemImp(String itemName, int quantity, double totalAmount) {
		this.itemName = itemName;
		Quantity = quantity;
		this.totalAmount = totalAmount;
	}
//	------------------------------------------------------------------------------------
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
