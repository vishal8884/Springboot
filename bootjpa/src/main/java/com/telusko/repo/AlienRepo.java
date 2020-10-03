package com.telusko.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.telusko.bootjpa.model.Alien;


public interface AlienRepo extends CrudRepository<Alien , Integer>  
{

}
