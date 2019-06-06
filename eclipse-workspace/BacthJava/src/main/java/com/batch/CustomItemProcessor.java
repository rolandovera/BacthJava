package com.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<User, User> {

	public User process(User item) throws Exception {
		System.out.println("Processing..." + item);
		return item;
	}
	
	private User getUser() {
		User user=new User();
		user.getId();
		user.getName().toUpperCase();
		user.getEmail();
		return user;
	}
}
