package cl.transbank.restorant.api.user.service;

import cl.transbank.restorant.security.ApplicationUser;

public interface UserServiceAuth {
	/**
	 * Verify if the user logged in is a valid user
	 * @param userName the user name
	 * @return a subclass of UserDetails
	 * @throws UserException
	 */
	ApplicationUser login(String userName) throws UserException;
}
