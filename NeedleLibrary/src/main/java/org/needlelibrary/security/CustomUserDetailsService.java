package org.needlelibrary.security;

import java.util.Optional;

import org.needlelibrary.entity.User;
import org.needlelibrary.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findById(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException(username+" not found"));
		
		return user.map(CustomUserDetails::new).get();
	}

}
