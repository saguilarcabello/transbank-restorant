package cl.transbank.restorant.api.user;

public class UserRequest {
	private String userName;
	private String password;
	
	public UserRequest() {
		
	}
	
	/**
	 * Constructor
	 * @param userName the user name
	 * @param password the user's password
	 */
	public UserRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
