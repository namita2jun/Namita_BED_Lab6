package com.greatLearning.studentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatLearning.studentManagement.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.username=?1")
	public User getUserByUserName(String username);

}
