package storedbms;

public class LowStockException extends Exception{
	private String message;

	

	public LowStockException(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}


}
