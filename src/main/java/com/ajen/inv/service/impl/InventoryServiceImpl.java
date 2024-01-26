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
	@Transactional
	public Iterable<InventoryItem> getAll() {
		// TODO Auto-generated method stub
		
		 Iterable<InventoryItem> res = null;
		try {
			res = invRepo.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		
		return res;
	}

	
	@Override
	public List<InventoryItem> findAll() {
		return (List<InventoryItem>) invRepo.findAll();
	}
	
	

	@Override
	public InventoryItem findById(Long id) {
		return invRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found")); // Replace with a custom exception
	}

	@Override
	public InventoryItem save(InventoryItem inventoryItem) {
		return invRepo.save(inventoryItem);
    }
		
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		invRepo.deleteById(id);
		
	}

	

	

	
		
		
		
		
		
		
	}


