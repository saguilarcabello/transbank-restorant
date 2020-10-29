package cl.transbank.restorant.api.user.service;

import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.user.User;
import cl.transbank.restorant.api.user.UserRequest;
import cl.transbank.restorant.api.user.UserResponse;

@Service
public class UserService implements UserServiceAuth {
	
	private final static String MSG_INVALID_CREDENTIALS = "Credenciales inválidas";

	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.user.service.UserServiceAuth#login(cl.transbank.restorant.api.user.UserRequest)
	 */
	@Override
	public UserResponse login(UserRequest userRequest) throws UserException {
		
		User user = findByUserName(userRequest.getUserName());
		if (user == null) {
			throw new UserException(MSG_INVALID_CREDENTIALS);
		}
		
		if (!validateUser(userRequest, user)) {
			throw new UserException(MSG_INVALID_CREDENTIALS);
		}
		
		UserResponse userResponse = new UserResponse(user.getName(), user.getEmail());
		return userResponse;
	}
	
	
	/**
	 * Validate if the password is the same registered value
	 * @param userRequest user request object
	 * @param user user object
	 * @return true if valid credentials, false if is not
	 */
	private boolean validateUser(UserRequest userRequest, User user) {
		String passwordEncripted = userRequest.getPassword();
		if (passwordEncripted.equals(user.getPassword())) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Find user by user name
	 * @param userName the user name
	 * @return the user object
	 */
	private User findByUserName(String userName) {
		
		//Default user get from the storage location
		User user = new User("jhonDoe", "Jhon Doe", "jhon.doe@mail.com", "123456");
		
		//emulate if the user is found on the list of users
		User userResponse = null;
		if (userName.equals(user.getUserName())) {
			userResponse = user;
		}
		
		return userResponse;
	}

}
