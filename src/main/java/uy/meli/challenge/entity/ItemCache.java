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
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ItemCache implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "item_info")
	@NotNull
	@Type(type = "ItemJsonType")
	private ItemDTO itemInfo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "itemCacheId")
    private Collection<ApiData> apiDataCollection;
	
	public ItemCache() {
		super();
	}
	
	public ItemCache(Integer id, ItemDTO itemInfo) {
		super();
		this.id = id;
		this.itemInfo = itemInfo;
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
	
	public Collection<ApiData> getMlApiDataCollection() {
		return apiDataCollection;
	}

	public void setMlApiDataCollection(Collection<ApiData> mlApiDataCollection) {
		this.apiDataCollection = mlApiDataCollection;
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
