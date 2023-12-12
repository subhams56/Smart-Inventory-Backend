package com.incedo.capstone.smartinventory.repositories;



import org.springframework.stereotype.Repository;

import com.incedo.capstone.smartinventory.entities.Outwards;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface OutwardsRepository extends JpaRepository<Outwards,Integer>
{
	
	//Optional<Inwards>findByInwardsId(String name);
}
