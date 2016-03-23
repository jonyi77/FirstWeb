package ua.controller;

import ua.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.save("Петро", "pet", "097523654", "kjgb@kbfv.com", "123456");

	}

}
