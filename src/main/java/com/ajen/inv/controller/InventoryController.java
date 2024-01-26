package com.ajen.inv.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ajen.inv.bean.Result;
import com.ajen.inv.model.InventoryItem;
import com.ajen.inv.service.impl.InventoryServiceImpl;

/**
 * 
 * 
 * @author ajenk
 */
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	
	private static Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	InventoryServiceImpl inventoryItemService;
	
	

//	@GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.findAll();
    }

    @GetMapping("/{id}")
    public InventoryItem getItemById(@PathVariable Long id) {
        return inventoryItemService.findById(id);
    }

    @PostMapping
    public InventoryItem createItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryItemService.save(inventoryItem);
    }

    @PutMapping("/{id}")
    public InventoryItem updateItem(@PathVariable Long id, @RequestBody InventoryItem inventoryItem) {
        // Additional logic to update the item
        return inventoryItemService.save(inventoryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        inventoryItemService.delete(id);
        return ResponseEntity.ok().build();
    }
    
//	/**
//	 * Retrieve a list of all inventory items.
//	 * Service Method: inventoryService.findAll()
//	 * GET /api/inventory/{id}
//	 * @author ajenk
//	 */
//	@GetMapping(value = "get")
//	public Result getAllInventoryItems() {
//		
//		logger.info("Entered get method");
//		
//		ModelMap model = new ModelMap();
//		Result result = null; 
//		
//		try {
//			
//			Iterable<InventoryItem> res = invServiceImpl.getAll();
//			
//			model.addAttribute("item", res);
//			result = new Result("Constants.ok", "Retrieved All Items", model);
//			
//		} catch (Exception e) {
//			logger.error("Error in get method inventory controller");
//			
//			result = new Result("Constants.ERROR", "Failed to Retrieve all items", e.getMessage());
//		}
//		
//		
//		return result;
//	}
//	
//	/**
//	 * Retrieve a single inventory item by ID.
//	 * Service Method: inventoryService.findById(id)
//	 * POST /api/inventory
//	 * @author ajenk
//	 */
//	public void getById() {}
//	
//	
//	/**
//	 * Description: Create a new inventory item.
//		Service Method: inventoryService.create(item)
//		PUT /api/inventory/{id}
//	 */
//	public void createItem() {}
//	
//	/**
//	 * Description: Create a new inventory item.
//		Service Method: inventoryService.create(item)
//		PUT /api/inventory/{id}
//	 */
//	public void updateItem() {}
//	
//	/**
//	 * Description: Delete an inventory item.
//		Service Method: inventoryService.delete(id)
//	 */
//	public void deleteItem() {}
//	

}
