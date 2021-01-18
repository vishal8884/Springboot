package com.vishal.location.service;

import java.util.List;

import java.util.Optional;

import com.vishal.location.entities.Location;

public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocaion(Location location);

	Location getLocationById(int id);
	
	List<Location> getAllLocations();
}
