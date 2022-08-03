package storedbms;

import java.io.*;
import java.util.Set;

public class StoreFileHandling extends StoreImp{
	void writingMode() {
		try {
			FileOutputStream fos=new FileOutputStream("StoreFile.ser");
			try {
				ObjectOutputStream  oos=new ObjectOutputStream(fos);
				Set<String> set=admin.keySet();
				for(String s:set) {
					oos.writeObject(admin.get(s));
				}
				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	void readMode() 
	{
		try 
		{
			FileInputStream fos=new FileInputStream("StoreFile.ser");
			try 
			{
				ObjectInputStream  oos=new ObjectInputStream(fos);
				Object obj=oos.read();
				Store store=(Store)obj;
				System.out.println(store);
				oos.close();
				fos.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}



	public static void main(String[] args) 
	{

	}
}
