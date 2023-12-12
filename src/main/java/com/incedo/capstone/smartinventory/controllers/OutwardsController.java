package com.incedo.capstone.smartinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.capstone.smartinventory.entities.Outwards;
import com.incedo.capstone.smartinventory.services.OutwardsServices;







@RestController
@RequestMapping("/outwards")
public class OutwardsController {
	
@Autowired
OutwardsServices outwardsServices;

@GetMapping
public List<Outwards> getAllOutwards()
{
	return outwardsServices.fetchAllOutwards();
	
}
@GetMapping("/{id}")

public ResponseEntity<Outwards> getOutwardsById(@PathVariable int id)
{
	Outwards outwards=outwardsServices.getOutwardsId(id);
	if(outwards !=null)
	{
		return new ResponseEntity<>(outwards,HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}






@PostMapping("/addOutwards")

public ResponseEntity<Outwards> addOutwards(@RequestBody Outwards Outwards)
{
	Outwards addedOutwards=outwardsServices.addOutwards(Outwards);
	return new ResponseEntity<>(addedOutwards,HttpStatus.CREATED);
}



@PutMapping("/updateOutwards/{id}")
public ResponseEntity<Outwards> updateOutwards(@PathVariable int id,@RequestBody Outwards updatedOutwards)
{
	Outwards updatedOutward=outwardsServices.updateOutwards(id, updatedOutwards);
	if (updatedOutwards !=null)
	{
		return new ResponseEntity<>(updatedOutwards,HttpStatus.OK);
		
	}
	else
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}



@DeleteMapping("/deleteOutwards/{id}")
public ResponseEntity<Void> deleteOutwards(@PathVariable int id)
{
	outwardsServices.deleteOutwards(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}
