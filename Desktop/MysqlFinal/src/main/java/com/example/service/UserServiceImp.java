package com.example.service;

import java.util.List;

import com.example.mysql.model.User;

public interface UserServiceImp {
	public List<User> getAllToDo();
	public User getToDoById(int id);
	public User saveToDo(User datos);
	public void removeToDo(User id);
}
