package uy.meli.challenge.dao;

import java.util.List;
import java.util.Optional;

import uy.meli.challenge.entity.ApiData;
import uy.meli.challenge.entity.ItemCache;

public interface IItemCacheDAO {
	
	List<ItemCache> findAll();
	
	ItemCache findByItemId(String id);
	
	void createItemCache(ItemCache itemCache);
	
	void createApiData(ApiData apiData);

}
