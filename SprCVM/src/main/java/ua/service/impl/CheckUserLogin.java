package ua.service.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.UserRepository;

public class CheckUserLogin implements ConstraintValidator<UserCheck, String>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UserCheck arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		if (userRepository==null) 
			return true;
		return userRepository.findByLogin(arg0)==null;
	}
}
