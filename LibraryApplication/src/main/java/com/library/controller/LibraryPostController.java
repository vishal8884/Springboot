package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Library;
import com.library.repo.LibraryRepo;

@RestController
@Component
public class LibraryPostController {
	
	@Autowired
	LibraryRepo repo;
	
	
	@GetMapping("books")
	//@ResponseBody
	public Iterable<Library> viewbook()
	{
		Iterable<Library> library=repo.findAll();
		return library;
	}
	
	@GetMapping("books/{bookid}")
	//@ResponseBody
	public Optional<Library> viewbook2(@PathVariable("bookid") int bookid)
	{
		Optional<Library> library=repo.findById(bookid);
		return library;
	}
	
	@PostMapping("books")
	public Library addbook(Library library)
	{
		repo.save(library);
		return library;
	}

}
