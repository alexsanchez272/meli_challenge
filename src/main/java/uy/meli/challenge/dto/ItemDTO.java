package uy.meli.challenge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import uy.meli.challenge.dto.BaseItemDTO;

public class ItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String category_id;
	private BigDecimal price;
	private LocalDateTime start_time;
	private LocalDateTime stop_time;
	private List<BaseItemDTO> childs;

	public ItemDTO() {

	}

	public ItemDTO(String id, String title, String category_id, BigDecimal price, LocalDateTime start_time,
			LocalDateTime stopTime, List<BaseItemDTO> childs) {
		super();
		this.id = id;
		this.title = title;
		this.category_id = category_id;
		this.price = price;
		this.start_time = start_time;
		this.stop_time = stopTime;
		this.childs = childs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getStopTime() {
		return stop_time;
	}

	public void setStopTime(LocalDateTime stopTime) {
		this.stop_time = stopTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}
	
	public LocalDateTime getStop_time() {
		return stop_time;
	}

	public void setStop_time(LocalDateTime stop_time) {
		this.stop_time = stop_time;
	}

	public List<BaseItemDTO> getChilds() {
		return childs;
	}

	public void setChilds(List<BaseItemDTO> childs) {
		this.childs = childs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
