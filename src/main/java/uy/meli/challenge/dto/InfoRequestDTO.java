package uy.meli.challenge.dto;

import java.io.Serializable;

public class InfoRequestDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer status_code;
	private Integer count;
	
	public InfoRequestDTO() {
		super();
	}

	public InfoRequestDTO(Integer status_code, Integer count) {
		super();
		this.status_code = status_code;
		this.count = count;
	}

	public Integer getStatus_code() {
		return status_code;
	}

	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
