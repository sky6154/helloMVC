package com.kyeomjae.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyeomjae.springmvc.domain.User;
import com.kyeomjae.springmvc.service.UserService;

@RestController
@RequestMapping("/rest")
public class RestHomeController {
	@Autowired
	UserService userService;

    @RequestMapping("/allusers")
    public List<User> getAllUsers() {
    	List<User> users = this.userService.getAll();
    	return users;
    }
    
    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable String id) { // PathVariable << 경로로 들어감
    	User user = this.userService.get(id);
    	return user;
    }
}
