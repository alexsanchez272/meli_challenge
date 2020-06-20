package uy.meli.challenge.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.springframework.cache.annotation.Cacheable;

import com.sun.istack.NotNull;

import uy.meli.challenge.dto.ItemDTO;

@Entity
@Table(name = "api_data")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ApiData implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "response_time")
	private Long responseTime;
	
	@JoinColumn(name = "item_cache_id", referencedColumnName = "id")
	@ManyToOne
	private ItemCache itemCacheId;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "apiDataId")
    private Collection<MlApiData> mlApiDataCollection;
	
	public ApiData() {
		super();
	}
	
	public ApiData(Integer id, Date creationDate, Long responseTime) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.responseTime = responseTime;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
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
	
	public ItemCache getItemCacheId() {
		return itemCacheId;
	}

	public void setItemCacheId(ItemCache itemCacheId) {
		this.itemCacheId = itemCacheId;
	}
	
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ApiData)) {
            return false;
        }
        ApiData other = (ApiData) object;
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
