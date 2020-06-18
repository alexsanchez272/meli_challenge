package uy.meli.interfaces.dto;
import java.time.LocalDateTime;

public class MeliBaseItemDTO {
	private String itemId;
	private LocalDateTime stopTime;

	public MeliBaseItemDTO() {
		super();
	}

	public MeliBaseItemDTO(String itemId, LocalDateTime stopTime) {
		super();
		this.itemId = itemId;
		this.stopTime = stopTime;
	}

	public String getItem_id() {
		return itemId;
	}

	public void setItem_id(String itemId) {
		this.itemId = itemId;
	}

	public LocalDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalDateTime stopTime) {
		this.stopTime = stopTime;
	}

}
