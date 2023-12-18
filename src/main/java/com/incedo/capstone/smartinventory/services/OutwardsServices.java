package com.incedo.capstone.smartinventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.capstone.smartinventory.entities.Outwards;
import com.incedo.capstone.smartinventory.exceptions.OutwardsIdNotFoundException;
import com.incedo.capstone.smartinventory.repositories.OutwardsRepository;


@Service
public class OutwardsServices {
	
	@Autowired
	OutwardsRepository outwardsRepository;
	
	public List<Outwards> fetchAllOutwards(){
		return outwardsRepository.findAll();
		
	}
	public Outwards getOutwardsId(int id) {
		Optional<Outwards> op=outwardsRepository.findById(id);
		
		if(op.isPresent())
			return op.get();
		else
			
			throw new OutwardsIdNotFoundException("No Record found for Outwards with id: "+id);
	}

	public Outwards addOutwards(Outwards outward)
	{
		return outwardsRepository.save(outward);
	}
	public Outwards updateOutwards(int id,Outwards updatedOutwards)
	{
		Optional<Outwards>opOutwards=outwardsRepository.findById(id);
		if(opOutwards.isPresent())
		{
			Outwards existingOutwards=opOutwards.get();
			
			existingOutwards.setBillCheckedBy(updatedOutwards.getBillCheckedBy());
			existingOutwards.setBillValue(updatedOutwards.getBillValue());
			existingOutwards.setDateOfDelivery(updatedOutwards.getDateOfDelivery());
			existingOutwards.setDateOfSupply(updatedOutwards.getDateOfSupply());
			existingOutwards.setDeliveredTo(updatedOutwards.getDeliveredTo());
			existingOutwards.setInvoiceNo(updatedOutwards.getInvoiceNo());
			existingOutwards.setItemName(updatedOutwards.getItemName());
			existingOutwards.setOutwardsId(updatedOutwards.getOutwardsId());
			existingOutwards.setPurpose(updatedOutwards.getPurpose());
			existingOutwards.setQuantity(updatedOutwards.getQuantity());
			existingOutwards.setReceiptNo(updatedOutwards.getReceiptNo());
			
			
			
			
		return outwardsRepository.save(existingOutwards);
		}
		else
		{
			return null;
		}
	}
	public void deleteOutwards(int id)
	{
		outwardsRepository.deleteById(id);
	}
	
	
	

}
