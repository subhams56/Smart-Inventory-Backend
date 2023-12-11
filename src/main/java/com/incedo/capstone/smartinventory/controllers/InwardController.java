package com.incedo.capstone.smartinventory.controllers;

import com.incedo.capstone.smartinventory.entities.Inwards;
import com.incedo.capstone.smartinventory.services.InwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inwards")
public class InwardController {

    @Autowired
    InwardService inwardService;

    @GetMapping
    public List<Inwards> getAllInwards() {
        return inwardService.fetchAllInwards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inwards> getInwardsById(@PathVariable int id) {
        Inwards inward = inwardService.getInwardsId(id);
        return inward != null
                ? new ResponseEntity<>(inward, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addInwards")

    public ResponseEntity<Inwards> addInwards(@RequestBody Inwards inward) {
        Inwards addedInward = inwardService.addInwards(inward);
        return new ResponseEntity<>(addedInward, HttpStatus.CREATED);
    }

    @PutMapping("/updateInwards/{id}")
    public ResponseEntity<Inwards> updateInwards(@PathVariable int id, @RequestBody Inwards updatedInwards) {
        Inwards updatedInward = inwardService.updateInwards(id, updatedInwards);
        return updatedInward != null
                ? new ResponseEntity<>(updatedInward, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteInwards/{id}")

    public ResponseEntity<Void> deleteInwards(@PathVariable int id) {
        inwardService.deleteInwards(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

