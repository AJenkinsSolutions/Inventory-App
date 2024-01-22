package com.ajen.inv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * @author ajenk
 */
@RestController
public class InventoryController {
	
	
	
	//TODO: get 
	/**
	 * Retrieve a list of all inventory items.
	 * Service Method: inventoryService.findAll()
	 * GET /api/inventory/{id}
	 * @author ajenk
	 */
	public void getAllInventoryItems() {
		
	}
	
	/**
	 * Retrieve a single inventory item by ID.
	 * Service Method: inventoryService.findById(id)
	 * POST /api/inventory
	 * @author ajenk
	 */
	public void getById() {}
	
	
	/**
	 * Description: Create a new inventory item.
		Service Method: inventoryService.create(item)
		PUT /api/inventory/{id}
	 */
	public void createItem() {}
	
	/**
	 * Description: Create a new inventory item.
		Service Method: inventoryService.create(item)
		PUT /api/inventory/{id}
	 */
	public void updateItem() {}
	
	/**
	 * Description: Delete an inventory item.
		Service Method: inventoryService.delete(id)
	 */
	public void deleteItem() {}
	
	

}
