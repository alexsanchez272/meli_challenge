package uy.meli.challenge.dao;

import java.util.List;

import uy.meli.challenge.entity.Cache;

public interface IItemCacheDAO {
	
	List<Cache> findAll();

}
