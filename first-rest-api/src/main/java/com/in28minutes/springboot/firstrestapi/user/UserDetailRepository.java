package com.in28minutes.springboot.firstrestapi.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long>{
	
	List<UserDetail> findByRole(String role);
}
