package cl.transbank.restorant.api.user;

public class UserResponse {
	private String name;
	private String email;
	
	public UserResponse( ) {
		
	}
	
	/**
	 * constructor
	 * @param name the user name
	 * @param email the user email
	 */
	public UserResponse(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
