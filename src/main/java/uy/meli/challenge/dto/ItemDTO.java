package uy.meli.challenge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ItemDTO extends BaseItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tittle;
	private String categoryId;
	private BigDecimal price;
	private LocalDateTime starTime;
	private List<BaseItemDTO> childs;

	public ItemDTO() {
		super();
	}

	public ItemDTO(String itemId, LocalDateTime stopTime, String tittle, String categoryId, BigDecimal price,
			LocalDateTime starTime) {
		super(itemId, stopTime);
		this.tittle = tittle;
		this.categoryId = categoryId;
		this.price = price;
		this.starTime = starTime;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getStarTime() {
		return starTime;
	}

	public void setStarTime(LocalDateTime starTime) {
		this.starTime = starTime;
	}

	public List<BaseItemDTO> getChilds() {
		return childs;
	}

	public void setChilds(List<BaseItemDTO> childs) {
		this.childs = childs;
	}
}
