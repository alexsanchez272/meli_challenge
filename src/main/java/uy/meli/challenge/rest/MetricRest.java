package uy.meli.challenge.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.meli.challenge.dto.MetricDTO;
import uy.meli.challenge.entity.Metric;
import uy.meli.challenge.exceptions.ItemNotFoundException;
import uy.meli.challenge.service.IMetricService;

@RestController
@RequestMapping("/health")
public class MetricRest {

	@Autowired
	private IMetricService metricService;

	@GetMapping
	public List<MetricDTO> findAll() {
		List<MetricDTO> metricsDto = metricService.getMeytrics();

		return metricsDto;
	}
}
