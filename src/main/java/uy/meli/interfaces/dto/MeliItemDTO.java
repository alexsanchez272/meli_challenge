package uy.meli.interfaces.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import uy.meli.challenge.dto.BaseItemDTO;

public class MeliItemDTO extends MeliBaseItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tittle;
	private String categoryId;
	private BigDecimal price;
	private LocalDateTime starTime;

	public MeliItemDTO() {
		super();
	}

	public MeliItemDTO(String itemId, LocalDateTime stopTime, String tittle, String categoryId, BigDecimal price,
			LocalDateTime starTime, List<BaseItemDTO> childrens) {
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

}
