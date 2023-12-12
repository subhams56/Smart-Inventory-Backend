package com.incedo.capstone.smartinventory.services;
import com.incedo.capstone.smartinventory.entities.Returns;
import com.incedo.capstone.smartinventory.exceptions.ReturnIdNotFoundException;
import com.incedo.capstone.smartinventory.repositories.ReturnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReturnsService {

    @Autowired
    public ReturnsRepository returnsRepository;


    public List<Returns> getAllReturns()
    {
        return returnsRepository.findAll();
    }


    public Returns getReturnsById(int returnid)
    {
        Optional<Returns> optionalReturns = returnsRepository.findById(returnid);
        if(optionalReturns.isPresent())
            return optionalReturns.get();
        else
            throw new ReturnIdNotFoundException("No Record found for the "+returnid);
    }

    public Returns addReturns(Returns returns) {
        return returnsRepository.save(returns);
    }

    public Returns updateReturns(int returnid, Returns updatedReturns) {
        Optional<Returns> opReturns = returnsRepository.findById(returnid);
        if (opReturns.isPresent())
        {
            Returns existingReturn = opReturns.get();

            existingReturn.setReturnid(updatedReturns.getReturnid());
            existingReturn.setGodownid(updatedReturns.getGodownid());
            existingReturn.setReturnDate(updatedReturns.getReturnDate());
            existingReturn.setBillCheckedby(updatedReturns.getBillCheckedby());
            existingReturn.setBillValue(updatedReturns.getBillValue());
            existingReturn.setDeliveryDate(updatedReturns.getDeliveryDate());
            existingReturn.setInvoiceNumber(updatedReturns.getInvoiceNumber());
            existingReturn.setItemName(updatedReturns.getItemName());
            existingReturn.setQuatity(updatedReturns.getQuatity());

            return returnsRepository.save(existingReturn);

        }

        else
            return null;


    }

    public void deleteReturn(int returnid) {
        returnsRepository.deleteById(returnid);
    }
}
