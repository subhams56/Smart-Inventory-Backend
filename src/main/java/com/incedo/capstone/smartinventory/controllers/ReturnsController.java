package com.incedo.capstone.smartinventory.controllers;

import com.incedo.capstone.smartinventory.entities.ReturnsRegister;
import com.incedo.capstone.smartinventory.services.ReturnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReturnsController {

    @Autowired
    public ReturnsService returnsService;

    @GetMapping("/returns")
    public List<ReturnsRegister> getAllReturns() {

        return returnsService.getAllReturns();
    }

    @GetMapping("/returns/{returnid}")
    public ReturnsRegister getReturnsById(@PathVariable int returnid)
    {
        return returnsService.getReturnsById(returnid);
    }

//    @PostMapping("/addReturns")
//    public ResponseEntity<ReturnsRegister> addReturns(@PathVariable ReturnsRegister returnsRegister)
//    {
////        ReturnsRegister addedReturnsRegister = returnsService.addReturns(returnsRegister);
////        return new ResponseEntity<>(addedReturnsRegister, HttpStatus.CREATED);
//    }

        @PostMapping("/returns/addReturns")
    public ResponseEntity <ReturnsRegister> addReturns(@RequestBody ReturnsRegister returnsRegister)
    {
        ReturnsRegister addedReturnsRegister = returnsService.addReturns(returnsRegister);
        return new ResponseEntity<>(addedReturnsRegister, HttpStatus.CREATED);
    }

    @PutMapping("/updateReturns/{returnid}")
    public ResponseEntity<ReturnsRegister> updateReturns(@PathVariable int returnid, @RequestBody ReturnsRegister updatedReturnsRegister)
    {
        ReturnsRegister updatedEntity = returnsService.updateReturns(returnid, updatedReturnsRegister);
        if(updatedEntity != null)
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/deleteReturns/{returnid}")
    public String deleteReturn(@PathVariable ("returnid") int returnid)
    {
        String msg = returnsService.deleteReturn(returnid);
        return msg;
    }
}
