package com.example.MysqlFinal; 

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.mysql.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootConfiguration
@WebAppConfiguration 
public class TestController {

	private MockMvc mvc; 
	 
	@Before 
	public void setUp() throws Exception { 
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build(); 
	} 
   
    @Test 
	public void testUserController() throws Exception { 
		RequestBuilder request = null; 
 
		request = get("/users"); 
		mvc.perform(request) 
				.andExpect(status().isOk()) 
				.andExpect(content().string(equalTo("[]")));
  
}
 
}
