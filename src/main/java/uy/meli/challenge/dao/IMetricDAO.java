package uy.meli.challenge.dao;

import java.util.List;

import uy.meli.challenge.entity.Metric;

public interface IMetricDAO {
	
	public List<Metric> findAll();

}
