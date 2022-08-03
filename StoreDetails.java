package storedbms;

public class StoreDetails 
{


	private String itemName;
	private int count;
	private double costPrice;
	private double sellingPrice;
	private double gst;

	public StoreDetails(String itemName, int count, double costPrice, double sellingPrice, double gst)

	{

		this.itemName = itemName;
		this.count = count;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.gst = gst;
	}

	public String getItemName() 

	{
		return itemName;
	}

	public void setItemName(String itemName) 

	{
		this.itemName = itemName;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "itemName=" + itemName + "\tcount=" + count + "\tcostPrice=" + costPrice + "\tsellingPrice="
				+ sellingPrice + "\tgst=" + gst;
	}


}
