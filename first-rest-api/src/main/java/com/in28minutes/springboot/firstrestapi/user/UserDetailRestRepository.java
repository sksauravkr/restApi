package com.in28minutes.springboot.firstrestapi.user;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface UserDetailRestRepository extends PagingAndSortingRepository<UserDetail, Long>{
	
	List<UserDetail> findByRole(String role);
}
