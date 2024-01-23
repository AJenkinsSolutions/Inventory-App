package com.ajen.inv.service;
/**
 * 
 * 
 * @author ajenk
 */

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ajen.inv.model.InventoryItem;

@Service
public interface InventoryService {
	
	public Iterable<InventoryItem> getAll();
	


}
