package cl.transbank.restorant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cl.transbank.restorant.api.user.service.UserException;
import cl.transbank.restorant.api.user.service.UserService;
import cl.transbank.restorant.api.user.service.UserServiceAuth;
import cl.transbank.restorant.security.ApplicationUser;

@SpringBootTest
class UserServiceTests {

	@Test
	void userLoginOk() {
		UserServiceAuth userService = new UserService();
		
		ApplicationUser result = userService.login("jhonDoe");
		
		assertEquals(result.getUsername(), "jhonDoe");
	}
	
	@Test
	void userLoginFail() {
		UserServiceAuth userService = new UserService();
				
		Exception exception = assertThrows(UserException.class, () ->		
			userService.login("jhonDoeabc"));
		
		assertEquals("Credenciales inválidas", exception.getMessage());
	}
}
