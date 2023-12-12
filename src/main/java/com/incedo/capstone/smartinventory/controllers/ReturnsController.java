package com.incedo.capstone.smartinventory.controllers;

import com.incedo.capstone.smartinventory.entities.Returns;
import com.incedo.capstone.smartinventory.services.ReturnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class ReturnsController {

    @Autowired
    public ReturnsService returnsService;

    @GetMapping
    public List<Returns> getAllReturns() {

        return returnsService.getAllReturns();
    }

    @GetMapping("/returns/{returnid}")
    public Returns getReturnsById(@PathVariable int returnid)
    {
        return returnsService.getReturnsById(returnid);
    }

    @PostMapping("/addReturns")
    public ResponseEntity<Returns> addReturns(@PathVariable Returns returns)
    {
        Returns addedReturns = returnsService.addReturns(returns);
        return new ResponseEntity<>(addedReturns, HttpStatus.CREATED);
    }

    @PutMapping("/updateReturns/{id}")
    public ResponseEntity<Returns> updateReturns(@PathVariable int returnid, Returns updatedReturns)
    {
        Returns updatedEntity = returnsService.updateReturns(returnid, updatedReturns);
        if(updatedEntity != null)
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteReturns/{id}")
    public ResponseEntity<Void> deleteReturn(@PathVariable int returnid)
    {
        returnsService.deleteReturn(returnid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
