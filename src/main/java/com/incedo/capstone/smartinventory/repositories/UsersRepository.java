package com.incedo.capstone.smartinventory.repositories;

import com.incedo.capstone.smartinventory.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUsername(String username);
}
