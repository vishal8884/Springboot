package com.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Library;
import com.library.repo.LibraryRepo;

@Component
@Controller
public class LibraryController {

	@Autowired
	LibraryRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/addbook")
	public String addedBook(Library library)
	{
		repo.save(library);
		return "bookadded";
	}
	
	@RequestMapping("/viewbook")
	public ModelAndView viewbook(@RequestParam int bookid)
	{
		System.out.println(bookid);
		ModelAndView mv = new ModelAndView("viewbookbyid");
		Library library = repo.findById(bookid).orElse(new Library());
		System.out.println(repo.findByauthor("vishal"));
		mv.addObject(library);
		return mv;
	}
	
	
	
}
