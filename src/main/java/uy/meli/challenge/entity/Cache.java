package uy.meli.challenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import uy.meli.challenge.dto.ItemDTO;

@Entity
@Table(name = "cache")
public class Cache {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "answer")
	@Type(type = "ItemJsonType")
	private ItemDTO answer;

	public ItemDTO getAnswer() {
		return answer;
	}

	public void setAnswer(ItemDTO answer) {
		this.answer = answer;
	}

	@Column(name = "date")
	private LocalDateTime date;

	@Column(name = "response_time")
	private Long responseTime;

	@Column(name = "response_time_api_call")
	private Long responseTimeApiCall;

	@Column(name = "status_code_api_call")
	private Integer statusCodeApi;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Long getResponseTimeApiCall() {
		return responseTimeApiCall;
	}

	public void setResponseTimeApiCall(Long responseTimeApiCall) {
		this.responseTimeApiCall = responseTimeApiCall;
	}

	public Integer getStatusCodeApi() {
		return statusCodeApi;
	}

	public void setStatusCodeApi(Integer statusCodeApi) {
		this.statusCodeApi = statusCodeApi;
	}

}
