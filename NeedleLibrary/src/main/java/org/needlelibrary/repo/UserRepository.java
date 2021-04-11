package org.needlelibrary.repo;


import org.needlelibrary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> 
{
	
	//Optional<User> findByuser_id(String user_id);
	

}
