package uy.meli.challenge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.service.IItemService;
import uy.meli.challenge.utils.Globals;

@RestController
@RequestMapping("/items")
public class ItemRest {
	
	@Autowired
	private IItemService itemService;
	
	@GetMapping(value = "/{id}")
	public ItemDTO findItemById(@PathVariable("id") String id) {		
		long startTime = System.nanoTime();
		
		ItemDTO itemDto=  itemService.getItemById(id);
		Globals.GLOBAL_CACHE.get().setResponseTime((System.nanoTime() - startTime)/1000000);
		return itemDto;
	}
}
