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

import uy.meli.challenge.dao.IMetricDAO;
import uy.meli.challenge.entity.Metric;

@Repository
public class MetricDAO implements IMetricDAO {
	private static final Logger LOGGER = Logger.getLogger(MetricDAO.class.getName());
	@Autowired
	private EntityManager em;

	@Override
	public List<Metric> findAll() {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Metric> cq = cb.createQuery(Metric.class);
			Root<Metric> from = cq.from(Metric.class);
			cq.select(from);
			Query query = em.createQuery(cq);
			return query.getResultList();

		} catch (NoResultException nre) {
		}
		return null;
	}

}
