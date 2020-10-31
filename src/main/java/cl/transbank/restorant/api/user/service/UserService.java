package cl.transbank.restorant.api.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.sale.service.SaleService;
import cl.transbank.restorant.api.user.User;
import cl.transbank.restorant.security.ApplicationUser;

@Service
public class UserService implements UserServiceAuth {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaleService.class);
	private final static String MSG_INVALID_CREDENTIALS = "Credenciales inválidas";
	

	/* (non-Javadoc)
	 * @see cl.transbank.restorant.api.user.service.UserServiceAuth#login(java.lang.String)
	 */
	@Override
	public ApplicationUser login(String userName) throws UserException {
		LOGGER.info("user login");
		
		User user = findByUserName(userName);
		if (user == null) {
			LOGGER.error(String.format("user not found: %s", userName));
			throw new UserException(MSG_INVALID_CREDENTIALS);
		}
			
		ApplicationUser userResponse = new ApplicationUser(
				user.getPassword(),
				user.getUserName(),
				true,
				true,
				true,
				true);
		return userResponse;
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
				"$2a$10$2LJO7/1wyPT1HO54E/R9pumxWV/9Js3WHT5LM/5R92v0eOqrX0ryu"
			);
		
		//emulate if the user is found on the list of users
		User userResponse = null;
		if (userName.equals(user.getUserName())) {
			userResponse = user;
		}
		
		return userResponse;
	}

}
