package com.library.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.model.Library;

public interface LibraryRepo extends CrudRepository<Library, Integer>{

	List<Library> findByauthor(String author);
}
