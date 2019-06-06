package com.example.mysql.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.User;
import com.example.mysql.repository.UserRepository;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{id}")
	public Optional<User> getUser(@PathVariable(value = "id") int id) {
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}

	@GetMapping("/users/{id}")
	public Single<Optional<User>> getUser1(@PathVariable(value = "id") int id) {
		return Single.just(userRepository.findById(id));
	}

	@GetMapping("/{id}")
	public Single<User> getUserById(@PathVariable(value = "id") int id) {
		return Single.just(userRepository.findById(id).get());
	}

	@PostMapping
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);
		return "Saved";
	}

	@PostMapping(path = "/add")
	public Single<User> addNewUser1(@RequestParam String name, @RequestParam String email) {

		User user = new User();
		user.setName(String.valueOf(name));
		user.setEmail(String.valueOf(email));

		return Single.just(userRepository.save(user)).subscribeOn(Schedulers.computation());

	}

	/*
	 * @GetMapping(path = "/byName/{name}") public Single<Single<User>>
	 * getByName(@PathVariable(value = "name") String name) { return
	 * Single.just(userRepository.findByNameUser(name));
	 * 
	 * }
	 * 
	 * @GetMapping(path = "/byEmail/{email}") public Single<Single<User>>
	 * getByEmail(@PathVariable(value = "email") String email) { return
	 * Single.just(userRepository.findUserEmal(email));
	 * 
	 */

	@GetMapping()
	public Observable<User> getAll() {
		
//		Observable.fromIterable(userRepository.findAll()).subscribeOn(Schedulers.computation());
		
		return Observable.fromIterable(userRepository.findAll()).subscribeOn(Schedulers.computation());
		
//		return null;
	}
	@GetMapping(path="/al")
	public Observable<User> getAll1() {
		
//		Observable.fromIterable(userRepository.findAll()).subscribeOn(Schedulers.computation());
		
		return Observable.fromIterable(userRepository.findAll()).subscribeOn(Schedulers.computation()).filter(x->x.getName().equals("juan"));
		
//		return null;
	}
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PutMapping
	public Single<User> updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String email) {

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		return Single.just(userRepository.save(user));

	}

	@DeleteMapping(path = "/{id}")
	public Single<String> deleteUser(@PathVariable(value = "id") int id) {
		User user = new User();
		user.setId(id);
		userRepository.delete(user);
		return Single.just("deleted");
	}
}
