package uy.meli.challenge.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

public class ItemCacheDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ItemDTO itemInfo;
	private LocalDateTime creationDate;
	private Long responseTime;
    private Collection<MlApiDataDTO> mlApiDataCollection;
	
    public ItemCacheDTO() {
		super();
	}

	public ItemCacheDTO(ItemDTO itemInfo, LocalDateTime creationDate, Long responseTime,
			Collection<MlApiDataDTO> mlApiDataCollection) {
		super();
		this.itemInfo = itemInfo;
		this.creationDate = creationDate;
		this.responseTime = responseTime;
		this.mlApiDataCollection = mlApiDataCollection;
	}

	public ItemDTO getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(ItemDTO itemInfo) {
		this.itemInfo = itemInfo;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Collection<MlApiDataDTO> getMlApiDataCollection() {
		return mlApiDataCollection;
	}

	public void setMlApiDataCollection(Collection<MlApiDataDTO> mlApiDataCollection) {
		this.mlApiDataCollection = mlApiDataCollection;
	}
}
