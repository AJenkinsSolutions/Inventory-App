package com.ajen.inv.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ajen.inv.bean.Result;
import com.ajen.inv.controller.InventoryController;
import com.ajen.inv.model.InventoryItem;
import com.ajen.inv.repository.InventoryRepository;
import com.ajen.inv.service.InventoryService;

import ch.qos.logback.core.joran.conditional.ThenAction;
import jakarta.transaction.Transactional;

/**
 * 
 * 
 * @author ajenk
 */
@Service
public class InventoryServiceImpl implements InventoryService{
	
	private static Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	@Autowired
	InventoryRepository invRepo;

	
	@Override
	public List<InventoryItem> findAll() {
		return (List<InventoryItem>) invRepo.findAll();
	}
	
	

	@Override
	public InventoryItem findById(Long id) {
		logger.info("Entered into getItemById in InventoryServiceImpl");
		return invRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found")); // Replace with a custom exception
	}

	@Override
	public InventoryItem save(InventoryItem inventoryItem) {
			
		return invRepo.save(inventoryItem);
    }
	
	
	@Override
	public InventoryItem update(Long id, InventoryItem inventoryItem) {
	
		
		 
		 try {
			 
			 Optional<InventoryItem> optionalObject = invRepo.findById(id);
			 
			 optionalObject.ifPresent(dbObj -> {
				 
				 dbObj.setItemName(inventoryItem.getItemName());
				 dbObj.setLocation(inventoryItem.getLocation());
				 dbObj.setQuantity(inventoryItem.getQuantity());
				 
				invRepo.save(dbObj);
				 
			 });

			 
		} catch (Exception e) {
			logger.error("Exception occured im update() in InventoryServiceImpl " + e.getMessage());
			e.printStackTrace();
		}
		 
		 return inventoryItem;
	}
		
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		invRepo.deleteById(id);
		
	}



	

	

	

	
		
		
		
		
		
		
	}


