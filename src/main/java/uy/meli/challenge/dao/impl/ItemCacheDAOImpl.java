package uy.meli.challenge.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.entity.ItemCache;

@Repository
public class ItemCacheDAOImpl implements IItemCacheDAO {

	@Autowired
	private EntityManager em;

	@Override
	public List<ItemCache> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ItemCache> cq = cb.createQuery(ItemCache.class);
		Root<ItemCache> from = cq.from(ItemCache.class);
		cq.select(from);
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Optional<ItemCache> findByItemId(String id) {
		ItemCache item = (ItemCache) em.createNativeQuery("SELECT * FROM item_cache e WHERE e.item_info->'id' = '\""+ id +"\"'", ItemCache.class).getSingleResult();
		Optional<ItemCache> optItem = Optional.ofNullable(item);
		return optItem;
	}
	
	

}
