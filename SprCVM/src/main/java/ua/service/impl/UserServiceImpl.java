package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Role;
import ua.entity.User;
import ua.repository.UserRepository;

@Service
public class UserServiceImpl {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	public User findById(int id){
		return userRepository.findOne(id);
	}
	
	public void save(String name, String login, String phone, String email, String password){
		User user = new User();
		user.setName(name);
		user.setLogin(login);
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}
	
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	public void delete(String id){
		try {
			int idParse = Integer.parseInt(id);
			userRepository.delete(idParse);
		} catch (NumberFormatException e) {
			
		}
		
	}

}
