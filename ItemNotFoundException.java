package storedbms;

public class ItemNotFoundException extends Exception {
	private String message;

	public ItemNotFoundException(String message) {
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
