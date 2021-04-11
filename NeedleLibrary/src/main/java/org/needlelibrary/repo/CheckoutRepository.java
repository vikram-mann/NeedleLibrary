package org.needlelibrary.repo;

import java.util.List;
import java.util.Optional;

import org.needlelibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Integer> 
{
	
	Optional<Checkout> findByIsbnAndUserId(String isbn, String userName);
	
	List<Checkout> findByUserId(String userName);

	List<Checkout> findByIsbn(String isbn);
	
	Optional<Checkout> findById(Long id);

}
