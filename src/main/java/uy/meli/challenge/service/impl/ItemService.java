package uy.meli.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.challenge.service.IItemService;

public class ItemService implements IItemService{
	
	@Autowired
	private IItemExternal meliClient;
	
	@Autowired
	private IItemCacheDAO itemCacheDAO;

	@Override
	public ItemDTO getItemById() {
		// TODO Auto-generated method stub
		return null;
	}

}
