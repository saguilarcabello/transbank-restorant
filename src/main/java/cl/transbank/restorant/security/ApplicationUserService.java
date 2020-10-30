package cl.transbank.restorant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.transbank.restorant.api.user.service.UserServiceAuth;

@Service
public class ApplicationUserService implements UserDetailsService {
	
	private UserServiceAuth userService;

	@Autowired
	public ApplicationUserService(UserServiceAuth userService) {
		this.userService = userService;
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return userService.login(userName);
	}

}
