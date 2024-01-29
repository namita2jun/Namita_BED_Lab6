package com.greatLearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatLearning.studentManagement.entity.User;
import com.greatLearning.studentManagement.repository.UserJpaRepository;
import com.greatLearning.studentManagement.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserJpaRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("could not find user");
		}

		return new MyUserDetails(user);
	}

	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
