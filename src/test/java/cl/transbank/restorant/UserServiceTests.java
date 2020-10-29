package cl.transbank.restorant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cl.transbank.restorant.api.user.UserRequest;
import cl.transbank.restorant.api.user.UserResponse;
import cl.transbank.restorant.api.user.service.UserException;
import cl.transbank.restorant.api.user.service.UserService;
import cl.transbank.restorant.api.user.service.UserServiceAuth;

@SpringBootTest
class UserServiceTests {

	@Test
	void userLoginOk() {
		UserServiceAuth userService = new UserService();
		
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("jhonDoe");
		userRequest.setPassword("EqdmPh53c9x");
		
		UserResponse result = userService.login(userRequest);
		
		assertEquals(result.getName(), "Jhon Doe");
		assertEquals(result.getEmail(), "jhon.doe@mail.com");
	}
	
	@Test
	void userLoginFail() {
		UserServiceAuth userService = new UserService();
		
		UserRequest userRequest = new UserRequest();
		userRequest.setUserName("jhonDoe");
		userRequest.setPassword("EqdmPh53c9xabcd");
		
		Exception exception = assertThrows(UserException.class, () ->		
			userService.login(userRequest));
		
		assertEquals("Credenciales inválidas", exception.getMessage());
	}
}
