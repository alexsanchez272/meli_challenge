package uy.meli.challenge.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;

import com.sun.istack.NotNull;

import uy.meli.challenge.dto.ItemDTO;

@Entity
@Table(name = "item_cache")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ItemCache implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "item_info")
	@NotNull
	@Type(type = "ItemJsonType")
	private ItemDTO itemInfo;

	@Column(name = "creation_date")
	private LocalDateTime creationDate;

	@Column(name = "response_time")
	private Long responseTime;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCacheId")
    private Collection<MlApiData> mlApiDataCollection;
	
	public ItemCache() {
		super();
	}
	
	public ItemCache(Integer id, ItemDTO itemInfo, LocalDateTime creationDate, Long responseTime) {
		super();
		this.id = id;
		this.itemInfo = itemInfo;
		this.creationDate = creationDate;
		this.responseTime = responseTime;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Collection<MlApiData> getMlApiDataCollection() {
		return mlApiDataCollection;
	}

	public void setMlApiDataCollection(Collection<MlApiData> mlApiDataCollection) {
		this.mlApiDataCollection = mlApiDataCollection;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ItemCache)) {
            return false;
        }
        ItemCache other = (ItemCache) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uy.meli.challenge.entity.ItemCache[ id=" + id + " ]";
    }

}
