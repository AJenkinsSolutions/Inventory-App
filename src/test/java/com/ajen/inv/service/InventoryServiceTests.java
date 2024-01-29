package com.ajen.inv.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ajen.inv.model.InventoryItem;
import com.ajen.inv.repository.InventoryRepository;
import com.ajen.inv.service.impl.InventoryServiceImpl;

/**
 * 
 * 
 * @author ajenk
 */
@ExtendWith(MockitoExtension.class)
public class InventoryServiceTests {
	
	@InjectMocks
	private InventoryServiceImpl inventoryService;
	
	@Mock
	private InventoryRepository inventoryRepository; 
	
	
	private InventoryItem item;
	
	@BeforeEach
	void setUp() {
		item = new InventoryItem();
		item.setItemId(1L);
		item.setItemName("Test item Name");
		item.setQuantity("109");
		item.setLocation("TestLocation");
	}
	@Order(1)
	@DisplayName("Find All Tests")
	@Test
	void findAllTest() throws Exception {
		
	when(inventoryRepository.findAll()).thenReturn(Arrays.asList(item));
	
	List<InventoryItem> results = inventoryService.findAll();
	
	assertNotNull(results);
	assertEquals(1, results.size());
	verify(inventoryRepository).findAll();
		
	}
	
	@Order(2)
	@DisplayName("Find By Id Test ")
	@Test
	void findByIdTest() throws Exception {
		when(inventoryRepository.findById(anyLong())).thenReturn(Optional.of(item));
		
		InventoryItem results = inventoryService.findById(anyLong());
		
		assertNotNull(results);
		assertEquals("Test item Name", results.getItemName());
		verify(inventoryRepository).findById(anyLong());
	}
	
	@Test
	void saveTest() throws Exception {
		
	}
	
	@Test
	void updateTest() throws Exception {
		
	}
	
	
	@Test
	void deleteTest() throws Exception {
		
	}
	
}
