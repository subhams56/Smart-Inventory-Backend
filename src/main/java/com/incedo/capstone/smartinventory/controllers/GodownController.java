package com.incedo.capstone.smartinventory.controllers;


import com.incedo.capstone.smartinventory.entities.Godowns;
import com.incedo.capstone.smartinventory.exceptions.GodownNotFoundException;
import com.incedo.capstone.smartinventory.services.GodownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/godowns")
public class GodownController {

    @Autowired
    private GodownService godownService;

    @GetMapping("/getAllGodowns")
    public List<Godowns> getAllGodowns() {
        return godownService.getAllGodowns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Godowns> getGodownById(@PathVariable int id) {
        Optional<Godowns> godown = godownService.getGodownById(id);
        return godown.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addGodown")
    public ResponseEntity<Godowns> addGodown(@RequestBody Godowns godown) {
        Godowns savedGodown = godownService.addGodown(godown);
        return new ResponseEntity<>(savedGodown, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Godowns> updateGodown(@PathVariable int id, @RequestBody Godowns updatedGodown) {
        try {
            Godowns savedGodown = godownService.updateGodown(id, updatedGodown);
            return new ResponseEntity<>(savedGodown, HttpStatus.OK);
        } catch (GodownNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGodown(@PathVariable int id) {
        try {
            String message = godownService.deleteGodown(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (GodownNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
