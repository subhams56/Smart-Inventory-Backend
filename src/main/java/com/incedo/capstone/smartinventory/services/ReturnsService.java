package com.incedo.capstone.smartinventory.services;
import com.incedo.capstone.smartinventory.entities.ReturnsRegister;
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


    public List<ReturnsRegister> getAllReturns()
    {
        return returnsRepository.findAll();
    }


    public ReturnsRegister getReturnsById(int returnid)
    {
        Optional<ReturnsRegister> optionalReturns = returnsRepository.findById(returnid);
        if(optionalReturns.isPresent())
            return optionalReturns.get();
        else
            throw new ReturnIdNotFoundException("No Record found for the "+returnid);
    }

    public ReturnsRegister addReturns(ReturnsRegister returnsRegister) {
        return returnsRepository.save(returnsRegister);
    }

    public ReturnsRegister updateReturns(int returnid, ReturnsRegister updatedReturnsRegister) {
        Optional<ReturnsRegister> opReturns = returnsRepository.findById(returnid);
        if (opReturns.isPresent())
        {
            ReturnsRegister existingReturn = opReturns.get();

            existingReturn.setReturnid(updatedReturnsRegister.getReturnid());
            existingReturn.setGodownid(updatedReturnsRegister.getGodownid());
            existingReturn.setReturnDate(updatedReturnsRegister.getReturnDate());
            existingReturn.setBillCheckedby(updatedReturnsRegister.getBillCheckedby());
            existingReturn.setBillValue(updatedReturnsRegister.getBillValue());
            existingReturn.setDeliveryDate(updatedReturnsRegister.getDeliveryDate());
            existingReturn.setInvoiceNumber(updatedReturnsRegister.getInvoiceNumber());
            existingReturn.setItemName(updatedReturnsRegister.getItemName());
            existingReturn.setQuatity(updatedReturnsRegister.getQuatity());

            return returnsRepository.save(existingReturn);

        }

        else
            return null;


    }

    public String deleteReturn(int returnid) {
        if(returnsRepository.existsById(returnid))
        {
            returnsRepository.deleteById(returnid);
            return "Deleted ";
        }
        else
            throw new ReturnIdNotFoundException("No record Found!");

    }
}
