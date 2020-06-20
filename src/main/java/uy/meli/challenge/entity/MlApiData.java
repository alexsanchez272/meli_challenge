package uy.meli.challenge.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * 
 * @author ale
 *
 */
@Entity
@Table(name = "ml_api_data")
public class MlApiData implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "meli_api_response_time")
	private Long meliApiResponseTime;

	@Column(name = "meli_api_status_code")
	private Integer meliApiStatusCode;

	@JoinColumn(name = "api_data_id", referencedColumnName = "id")
	@NotNull
	@ManyToOne(optional = false)
	private ApiData apiDataId;

	public MlApiData() {
		super();
	}

	public MlApiData(Integer id, Long meliApiResponseTime, Integer meliApiStatusCode, ApiData apiData) {
		super();
		this.id = id;
		this.meliApiResponseTime = meliApiResponseTime;
		this.meliApiStatusCode = meliApiStatusCode;
		this.apiDataId = apiData;
	}

	public MlApiData(Long meliApiResponseTime, Integer meliApiStatusCode, ApiData apiData) {
		super();
		this.meliApiResponseTime = meliApiResponseTime;
		this.meliApiStatusCode = meliApiStatusCode;
		this.apiDataId = apiData;
	}

	public MlApiData(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMeliApiResponseTime() {
		return meliApiResponseTime;
	}

	public void setMeliApiResponseTime(Long meliApiResponseTime) {
		this.meliApiResponseTime = meliApiResponseTime;
	}

	public Integer getMeliApiStatusCode() {
		return meliApiStatusCode;
	}

	public void setMeliApiStatusCode(Integer meliApiStatusCode) {
		this.meliApiStatusCode = meliApiStatusCode;
	}

	public ApiData getItemCacheId() {
		return apiDataId;
	}

	public void setItemCacheId(ApiData itemCacheId) {
		this.apiDataId = itemCacheId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof MlApiData)) {
			return false;
		}
		MlApiData other = (MlApiData) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "uy.meli.challenge.entity.MlApiData[ id=" + id + " ]";
	}

}
