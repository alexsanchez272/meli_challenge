package uy.meli.challenge.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.entity.ApiData;
import uy.meli.challenge.entity.ItemCache;
import uy.meli.challenge.entity.MlApiData;

@Repository
public class ItemCacheDAOImpl implements IItemCacheDAO {
	private static final Logger LOGGER = Logger.getLogger(ItemCacheDAOImpl.class.getName());
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
	public ItemCache findByItemId(String id) {
		try {
			ItemCache item = (ItemCache) em
					.createNativeQuery("SELECT * FROM item_cache e WHERE e.item_info->'id' = '\"" + id + "\"'",
							ItemCache.class)
					.getSingleResult();
			return item;
		} catch (NoResultException nre) {
		}
		return null;
	}

	@Override
	public void createItemCache(ItemCache itemCache) {
		em.persist(itemCache);		
	}

	@Override
	public void createApiData(ApiData apiData) {
		em.persist(apiData);		
	}
	
	
	

}
