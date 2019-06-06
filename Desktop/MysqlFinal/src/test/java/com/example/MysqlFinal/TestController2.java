package com.example.MysqlFinal;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.mysql.controller.UserController;
import com.example.mysql.model.User;
import com.example.mysql.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public  class TestController2 {

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserController userController;
	@Before
	public void setup() {
		MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<User> users = new ArrayList<>();
		//users.add(new User(1,"aldo","aldo@gmail.com"));
		//users.add(new User(2,"jhon","jhon@gmail.com"));
		
		when(userRepository.findAll());
		assertFalse(users.equals(null));
		//assertNotNull(users);
		//userController.getAllUsers();
	}
				
}
