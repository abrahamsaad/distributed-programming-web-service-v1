package com.uninorte.distributed.programming.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.uninorte.distributed.programming.web.service.repository.UserRepository;

@RestController
public class UsersController {
	
	private Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@Autowired
	private static Environment environment;
	
	@Autowired
	private UserRepository repository;
	
	public static ArrayList<User> listOfUser =new ArrayList();
	
	static {
		
		listOfUser.add(new User(1,"asaad1","password","asaad@uninorte.edu.co"));
		listOfUser.add(new User(2,"asaad2","password","asaad@uninorte.edu.co"));
		listOfUser.add(new User(3,"asaad3","password","asaad@uninorte.edu.co"));
		listOfUser.add(new User(4,"asaad4","password","asaad@uninorte.edu.co"));
		listOfUser.add(new User(5,"asaad5","password","asaad@uninorte.edu.co"));
	}
	
	public UsersController() {
		super();
		
	}
	
	@GetMapping(path = "/user/get/all")
	public List<User> getAllUser(@RequestHeader(name = "Authorization",defaultValue = "APP-CODE;UNIXTIMESTAMP;UNIQ-TOKEN") String authorization){
		logger.info("getAllUser was called");
		return repository.findAll();
		//return listOfUser;
	}
	
	@GetMapping(path = "/user/get/{user_id}")
	public User getUser(@RequestHeader(name = "Authorization",defaultValue = "APP-CODE;UNIXTIMESTAMP;UNIQ-TOKEN") String authorization,@PathVariable int user_id){
		logger.info("getUser was called with {}",user_id);
		return repository.findById(user_id).get();
		//Predicate<? super User> predicate= user-> user.getUser_id().equals(user_id);
        //return listOfUser.stream().filter(predicate).findFirst().orElse(null);		
        
	}
	
	@PostMapping(path = "/user/create")
	public List<User> createUser(@RequestHeader(name = "Authorization",defaultValue = "APP-CODE;UNIXTIMESTAMP;UNIQ-TOKEN") String authorization,@RequestBody User newUser){
		//this.listOfUser.add(newUser);
		logger.info("createUser was called with {}",newUser.toString());
		repository.save(newUser);
		
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/user/delete")
	public List<User> deleteUser(@RequestHeader(name = "Authorization",defaultValue = "APP-CODE;UNIXTIMESTAMP;UNIQ-TOKEN") String authorization,@RequestParam Integer user_id){
		//Predicate<? super User> predicate= user-> user.getUser_id().equals(user_id);
		//listOfUser.removeIf(predicate);
		logger.info("/user/get/all was called");
		repository.deleteById(user_id);
		
		return repository.findAll();
	}

}
