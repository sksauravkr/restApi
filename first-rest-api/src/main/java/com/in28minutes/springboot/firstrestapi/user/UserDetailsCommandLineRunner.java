package com.in28minutes.springboot.firstrestapi.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	private UserDetailRepository repository;
	
	public UserDetailsCommandLineRunner(UserDetailRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetail("Ranga","Admin"));
		repository.save(new UserDetail("Ram","Admin"));
		
		List<UserDetail> ls = repository.findAll();
		ls.forEach(user -> System.out.println(user.toString()));
		
		System.out.println(repository.findByRole("Admin"));
	}

}
