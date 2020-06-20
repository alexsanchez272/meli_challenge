package uy.meli.challenge.service;

import java.util.Optional;

import org.springframework.scheduling.annotation.Async;

import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.entity.ApiData;
import uy.meli.challenge.entity.ItemCache;

public interface IItemService {
	
	public Optional<ItemDTO> getItemById(String id);
	
	@Async
	public void saveItemCache(ItemCache itemCache);
	
	@Async
	public void saveApiData(ApiData apiData);

}
