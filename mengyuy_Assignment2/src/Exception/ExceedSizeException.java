package Exception;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is a custom exceptoin handler.
 * The exception will be thrown when the student sizes exceeds the max size.
 */
public class ExceedSizeException extends Exception {
	
	private String message = null;
	
	public ExceedSizeException() {}
	
	public ExceedSizeException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
