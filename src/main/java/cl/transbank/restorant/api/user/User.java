package cl.transbank.restorant.api.user;

public class User {
	private String userName;
	private String name;
	private String password;
	private String email;
	
	/**
	 * Constructor
	 */
	public User () {
		
	}
	
	/**
	 * Constructor
	 * @param name User name
	 * @param email User email
	 * @param password user password
	 */
	public User(String userName, String name, String email, String password) {
		this.userName = userName;
		this.name = name;
		this.email = email;
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