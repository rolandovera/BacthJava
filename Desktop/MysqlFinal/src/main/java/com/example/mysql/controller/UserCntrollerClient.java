package com.example.mysql.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.User;
import com.example.mysql.repository.UserRestClient;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@RestController
@RequestMapping(path = "/usersClient")
public class UserCntrollerClient {

	@Autowired
	private UserRestClient userResource;

	Disposable dis;


	@GetMapping(path = "/lista")
	public Single<List<User>> getAllUsersd() {

		return userResource.getUsers().toList();
	}

	@GetMapping(path = "/listas")
	void getTopContributors() {
		Observable<User> user = userResource.getUsers();
		dis=(Disposable) user;
		
		

	}

	@PostMapping(path = "/insert")
	public String createUser(@RequestParam String name, @RequestParam String email) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email);

		return userResource.createUser(map).execute().body();
	}

	@PutMapping(path = "/update")
	public String updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String email)
			throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		return userResource.updateUser(map).execute().body();
	}

	@DeleteMapping(path = "/delete")
	public String deleteUser(@RequestParam int id) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("id", id);
		return userResource.deleteUser(map);

	}
}
