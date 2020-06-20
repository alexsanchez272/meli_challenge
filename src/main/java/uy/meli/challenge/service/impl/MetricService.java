package uy.meli.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.meli.challenge.dao.IMetricDAO;
import uy.meli.challenge.dto.MetricDTO;
import uy.meli.challenge.entity.Metric;
import uy.meli.challenge.service.IMetricService;

@Service
public class MetricService implements IMetricService {
	@Autowired
	private IMetricDAO metricDAO;

	@Override
	public List<MetricDTO> getMeytrics() {

		Optional<List<Metric>> metricas = Optional.ofNullable(metricDAO.findAll());
		List<MetricDTO> metricasDTO = new ArrayList<MetricDTO>();
		
		if (metricas.isPresent()) {
			for (Metric metrica : metricas.get()) {
					metricasDTO.add(metrica.getMetricInf());
			}
		}

		return metricasDTO;
	}

}
