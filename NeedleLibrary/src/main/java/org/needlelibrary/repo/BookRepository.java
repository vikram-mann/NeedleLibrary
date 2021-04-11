package org.needlelibrary.repo;

import java.util.List;

import org.needlelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> 
{

	List<Book> findByTitleContaining(String title);

	List<Book> findByAuthorsContaining(String authors);
	

}
