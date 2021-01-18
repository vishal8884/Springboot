package com.vishal.location.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishal.location.entities.Location;
import com.vishal.location.respository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository repository;
	
	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public void deleteLocaion(Location location) {
		repository.delete(location);

	}

	@Override
	public Location getLocationById(int id) {
		return repository.findById(id).orElse(null);
		
		
	}

	@Override
	public List<Location> getAllLocations() {
		
		return repository.findAll();
	}

}
