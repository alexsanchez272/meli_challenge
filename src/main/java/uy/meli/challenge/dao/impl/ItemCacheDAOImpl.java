package uy.meli.challenge.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.entity.Cache;

@Repository
public class ItemCacheDAOImpl implements IItemCacheDAO {

	@Autowired
	private EntityManager em;

	@Override
	public List<Cache> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cache> cq = cb.createQuery(Cache.class);
		Root<Cache> from = cq.from(Cache.class);
		cq.select(from);
		Query query = em.createQuery(cq);
		return query.getResultList();
	}

}
