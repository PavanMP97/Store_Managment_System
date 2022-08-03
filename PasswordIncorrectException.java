package storedbms;

public class PasswordIncorrectException extends Exception{

	private String message;
	public PasswordIncorrectException(String message) {
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
