package com.example.MysqlFinal;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.mysql.model.User;
import com.example.mysql.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestUserRepository {
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void userAll() {
		Iterable<User> datos = userRepo.findAll();
		
		assertNotNull(datos);
		//fail("No NullPointerException");
		//assertTrue(datos!= null);
	}
}
