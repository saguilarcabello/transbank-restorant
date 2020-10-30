package cl.transbank.restorant.api.user.service;

import cl.transbank.restorant.security.ApplicationUser;

public interface UserServiceAuth {
	ApplicationUser login(String userName) throws UserException;
}
