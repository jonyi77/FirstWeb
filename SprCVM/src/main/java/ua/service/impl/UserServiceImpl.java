package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.User;
import ua.repository.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private UserRepository userRepository;
	
	public void save(String login, String password, String name, String email, String phone){
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		userRepository.save(user);
	}
	
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	public void delete(String id){
		
	}

}
