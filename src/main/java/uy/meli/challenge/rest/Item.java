package uy.meli.challenge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.entity.Cache;

@RestController
@RequestMapping("/items")
public class Item {
	
	@Autowired
	private IItemCacheDAO cacheDAO;
	
	@GetMapping
	public String findAll() {
		List<Cache> caches = cacheDAO.findAll();
		
		return "Hello World";
	}
}
