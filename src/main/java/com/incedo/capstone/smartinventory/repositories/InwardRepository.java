package com.incedo.capstone.smartinventory.repositories;

import com.incedo.capstone.smartinventory.entities.Inwards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InwardRepository extends JpaRepository<Inwards,Integer> {
}
