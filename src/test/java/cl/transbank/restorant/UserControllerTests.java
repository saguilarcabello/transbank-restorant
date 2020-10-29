package cl.transbank.restorant;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.transbank.restorant.api.user.UserRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

	@Autowired
	private MockMvc mock;
	
	private URL baseUrl;
	
	@BeforeEach
	public void setup() throws Exception {
		this.baseUrl = new URL("http://localhost:8080");
	}
	
	@Test
	void LoginControllerOk() throws Exception {
		mock.perform(MockMvcRequestBuilders.post(this.baseUrl.toString() + "/api/login")
				.content(asJsonString(new UserRequest("jhonDoe", "EqdmPh53c9x")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	void LoginControllerFail() throws Exception {
		mock.perform(MockMvcRequestBuilders.post(this.baseUrl.toString() + "/api/login")
				.content(asJsonString(new UserRequest("jhonDoeabc123", "EqdmPh53c9x")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
	
	
	private static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
