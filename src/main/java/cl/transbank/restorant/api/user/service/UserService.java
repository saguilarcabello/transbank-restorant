package cl.transbank.restorant.api.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.sale.service.SaleService;
import cl.transbank.restorant.api.user.User;
import cl.transbank.restorant.api.user.UserRequest;
import cl.transbank.restorant.api.user.UserResponse;
import cl.transbank.restorant.api.user.util.PasswordUtil;

@Service
public class UserService implements UserServiceAuth {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaleService.class);
	private final static String MSG_INVALID_CREDENTIALS = "Credenciales inválidas";

	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.user.service.UserServiceAuth#login(cl.transbank.restorant.api.user.UserRequest)
	 */
	@Override
	public UserResponse login(UserRequest userRequest) throws UserException {
		LOGGER.info("user login");
		
		User user = findByUserName(userRequest.getUserName());
		if (user == null) {
			LOGGER.error(String.format("user not found: %s", userRequest.getUserName()));
			throw new UserException(MSG_INVALID_CREDENTIALS);
		}
		
		if (!validateUser(userRequest, user)) {
			LOGGER.error(String.format("invalid password for user: %s", userRequest.getUserName()));
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
		boolean passwordMatch = PasswordUtil.verifyUserPassword(
				userRequest.getPassword(), 
				user.getPassword(), 
				user.getSalt()
		);
		
		if (passwordMatch) {
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
		User user = new User("jhonDoe", 
				"Jhon Doe", 
				"jhon.doe@mail.com", 
				"V+WrOR5BFiAMrixO9uekgi4t7/puFB/BUImO1poScos=", 
				"AxP6y6I10FRoFp36FMtNmDjz6dsuHj"
			);
		
		//emulate if the user is found on the list of users
		User userResponse = null;
		if (userName.equals(user.getUserName())) {
			userResponse = user;
		}
		
		return userResponse;
	}

}
