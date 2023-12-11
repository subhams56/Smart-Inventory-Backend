package com.incedo.capstone.smartinventory.services;

import com.incedo.capstone.smartinventory.entities.Godowns;
import com.incedo.capstone.smartinventory.exceptions.GodownNotFoundException;
import com.incedo.capstone.smartinventory.repositories.GodownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GodownService {

    @Autowired
    private GodownRepository godownRepository;

    public List<Godowns> getAllGodowns() {
        return godownRepository.findAll();
    }

    public Optional<Godowns> getGodownById(int id) {
        return godownRepository.findById(id);
    }

    public Godowns addGodown(Godowns godown) {
        return godownRepository.save(godown);
    }

    public Godowns updateGodown(int id, Godowns updatedGodown) {
        if (godownRepository.existsById(id)) {
            updatedGodown.setId(id);
            return godownRepository.save(updatedGodown);
        }
        throw new GodownNotFoundException("Godown with id " + id + " not found");
    }

    public String deleteGodown(int id) {
        if (godownRepository.existsById(id)) {
            godownRepository.deleteById(id);
            return "Godown with id " + id + " deleted successfully";
        }
        throw new GodownNotFoundException("Godown with id " + id + " not found");
    }
}
