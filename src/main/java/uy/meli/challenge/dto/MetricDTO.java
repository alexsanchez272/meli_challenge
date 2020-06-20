package uy.meli.challenge.dto;

import java.io.Serializable;
import java.util.List;

public class MetricDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String date;
	private Long avg_response_time;
	private Integer total_requests;
	private Long avg_response_time_api_calls;
	private Integer total_count_api_calls;
	private List<InfoRequestDTO> info_requests;

	public MetricDTO() {
		super();
	}

	public MetricDTO(String date, Long avg_response_time, Integer total_requests, Long avg_response_time_api_calls,
			Integer total_count_api_calls, List<InfoRequestDTO> info_requests) {
		super();
		this.date = date;
		this.avg_response_time = avg_response_time;
		this.total_requests = total_requests;
		this.avg_response_time_api_calls = avg_response_time_api_calls;
		this.total_count_api_calls = total_count_api_calls;
		this.info_requests = info_requests;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getAvg_response_time() {
		return avg_response_time;
	}

	public void setAvg_response_time(Long avg_response_time) {
		this.avg_response_time = avg_response_time;
	}

	public Integer getTotal_requests() {
		return total_requests;
	}

	public void setTotal_requests(Integer total_requests) {
		this.total_requests = total_requests;
	}

	public Long getAvg_response_time_api_calls() {
		return avg_response_time_api_calls;
	}

	public void setAvg_response_time_api_calls(Long avg_response_time_api_calls) {
		this.avg_response_time_api_calls = avg_response_time_api_calls;
	}

	public Integer getTotal_count_api_calls() {
		return total_count_api_calls;
	}

	public void setTotal_count_api_calls(Integer total_count_api_calls) {
		this.total_count_api_calls = total_count_api_calls;
	}

	public List<InfoRequestDTO> getInfo_requests() {
		return info_requests;
	}

	public void setInfo_requests(List<InfoRequestDTO> info_requests) {
		this.info_requests = info_requests;
	}
}
