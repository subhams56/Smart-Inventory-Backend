package com.incedo.capstone.smartinventory.services;

import com.incedo.capstone.smartinventory.entities.Inwards;
import com.incedo.capstone.smartinventory.exceptions.InwardsIdNotFoundException;
import com.incedo.capstone.smartinventory.repositories.InwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InwardService {

    @Autowired
    InwardRepository inwardRepository;

    public List<Inwards> fetchAllInwards(){
        return inwardRepository.findAll();
    }

    public Inwards getInwardsId(int id) {
        Optional<Inwards> op = inwardRepository.findById(id);

        if(op.isPresent())
            return op.get();
        else
            throw new InwardsIdNotFoundException("No Record found for Inwards with id: " + id);
    }

    public Inwards addInwards(Inwards inward) {
        return inwardRepository.save(inward);
    }

    public Inwards updateInwards(int id, Inwards updatedInwards) {
        Optional<Inwards> opInwards = inwardRepository.findById(id);

        if(opInwards.isPresent()) {
            Inwards existingInward = opInwards.get();

            existingInward.setBillCheckedBy(updatedInwards.getBillCheckedBy());
            existingInward.setDateOfSupply(updatedInwards.getDateOfSupply());
            existingInward.setInvoiceNo(updatedInwards.getInvoiceNo());
            existingInward.setInwardsId(updatedInwards.getInwardsId());
            existingInward.setItemName(updatedInwards.getItemName());
            existingInward.setNameOfTheSupplier(updatedInwards.getNameOfTheSupplier());
            existingInward.setQuantity(updatedInwards.getQuantity());
            existingInward.setReceiptNo(updatedInwards.getReceiptNo());
            existingInward.setReceivedBy(updatedInwards.getReceivedBy());

            return inwardRepository.save(existingInward);
        } else {
            return null;
        }
    }

    public void deleteInwards(int id) {
        inwardRepository.deleteById(id);
    }

    public boolean purchaseInwards(Inwards inwards) {
        Inwards i  = inwardRepository.findById(inwards.getInwardsId()).get();

        i.setProductsToPurchase(inwards.getProductsToPurchase());

        Inwards iDB = inwardRepository.save(i);

        if(iDB != null)
            return true;
        else
            return false;
    }
}
