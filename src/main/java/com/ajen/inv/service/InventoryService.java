package com.ajen.inv.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ajen.inv.model.InventoryItem;
/**
 * 
 * 
 * @author ajenk
 */
@Service
public interface InventoryService {
	
	
	List<InventoryItem> findAll();
	
    InventoryItem findById(Long id);
    
    InventoryItem save(InventoryItem inventoryItem);
    
    InventoryItem update(Long id, InventoryItem inventoryItem );
    
    void delete(Long id);
	


}
