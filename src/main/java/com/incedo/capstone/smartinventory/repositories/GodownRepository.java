package com.incedo.capstone.smartinventory.repositories;

import com.incedo.capstone.smartinventory.entities.Godowns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GodownRepository extends JpaRepository<Godowns, Integer> {

}
