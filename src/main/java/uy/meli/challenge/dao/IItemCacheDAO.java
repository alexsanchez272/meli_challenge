package uy.meli.challenge.dao;

import java.util.List;
import java.util.Optional;

import uy.meli.challenge.entity.ItemCache;

public interface IItemCacheDAO {
	
	List<ItemCache> findAll();
	
	Optional<ItemCache> findByItemId(String id);

}
