package cl.transbank.restorant.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cl.transbank.restorant.api.user.UserRequest;
import cl.transbank.restorant.api.user.UserResponse;
import cl.transbank.restorant.api.user.service.UserException;
import cl.transbank.restorant.api.user.service.UserServiceAuth;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private UserServiceAuth service;

	@Autowired
	public UserController(UserServiceAuth service) {
		this.service = service;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public UserResponse login(@RequestBody UserRequest userRequest) {
		UserResponse user = null;
		try {
			user = service.login(userRequest);
		} catch (UserException e) {
			throw new ResponseStatusException(
			           HttpStatus.FORBIDDEN, e.getMessage(), e);
		}
		return user;
	}
	
}
