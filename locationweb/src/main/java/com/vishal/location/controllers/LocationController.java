package com.vishal.location.controllers;

import java.util.List;


import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vishal.location.entities.Location;
import com.vishal.location.respository.LocationRepository;
import com.vishal.location.service.LocationService;
import com.vishal.location.util.EmailUtil;
import com.vishal.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap)
	{
		Location locationSaved = service.saveLocation(location);
		String msg  = "Location saced with id " +locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("tt4059264@gmail.com", "Location Saved", "Location saved sucessfully "+locationSaved);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) 
	{
		List<Location> locations=service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("deleteLocations")
	public String deleteLocation(@RequestParam("id") int id , ModelMap modelMap)
	{
		Location location = service.getLocationById(id);
		service.deleteLocaion(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id ,  ModelMap modelMap)
	{
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap)
	{
		service.updateLocation(location);
		
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		String path = servletContext.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
	
}
