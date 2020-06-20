package uy.meli.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import uy.meli.challenge.dto.MetricDTO;

/**
 * 
 * @author ale
 *
 */
@Entity
@Table(name = "metric")
public class Metric implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Type(type = "MetricJsonType")
	@Column(name = "metric_inf")
	private MetricDTO metricInf;

	public Metric() {
	}
	
	public Metric(Integer id, MetricDTO metricInf) {
		super();
		this.id = id;
		this.metricInf = metricInf;
	}

	public Metric(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MetricDTO getMetricInf() {
		return metricInf;
	}

	public void setMetricInf(MetricDTO metricInf) {
		this.metricInf = metricInf;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Metric)) {
			return false;
		}
		Metric other = (Metric) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "uy.meli.challenge.entity.Metric[ id=" + id + " ]";
	}

}
