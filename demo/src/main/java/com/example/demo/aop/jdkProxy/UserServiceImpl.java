package com.example.demo.aop.jdkProxy;

public class UserServiceImpl implements UserService {
	@Override
	public void add() {
		System.out.println("--------------------------add--------------------------");
	}
}
