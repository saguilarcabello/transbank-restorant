package cl.transbank.restorant.api.user.service;

import cl.transbank.restorant.api.user.UserRequest;
import cl.transbank.restorant.api.user.UserResponse;

public interface UserServiceAuth {
	UserResponse login(UserRequest user) throws UserException;
}
