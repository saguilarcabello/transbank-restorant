package cl.transbank.restorant.api.user.service;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {
	
	public UserException() {
		super();
	}
	
	public UserException(String msg) {
		super(msg);
	}
	
	public UserException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public UserException(Throwable cause) {
        super(cause);
    }
}
