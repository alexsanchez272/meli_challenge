package uy.meli.challenge.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class MlApiDataDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private BigInteger meliApiResponseTime;
	private Integer meliApiStatusCode;
	
	public MlApiDataDTO() {
		super();
	}

	public MlApiDataDTO(BigInteger meliApiResponseTime, Integer meliApiStatusCode) {
		super();
		this.meliApiResponseTime = meliApiResponseTime;
		this.meliApiStatusCode = meliApiStatusCode;
	}

	public BigInteger getMeliApiResponseTime() {
		return meliApiResponseTime;
	}

	public void setMeliApiResponseTime(BigInteger meliApiResponseTime) {
		this.meliApiResponseTime = meliApiResponseTime;
	}

	public Integer getMeliApiStatusCode() {
		return meliApiStatusCode;
	}

	public void setMeliApiStatusCode(Integer meliApiStatusCode) {
		this.meliApiStatusCode = meliApiStatusCode;
	}
	
}
