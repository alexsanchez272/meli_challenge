package uy.meli.challenge.dto;
import java.time.LocalDateTime;

public class BaseItemDTO {
	private String itemId;
	private LocalDateTime stopTime;

	public BaseItemDTO() {
		super();
	}

	public BaseItemDTO(String itemId, LocalDateTime stopTime) {
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
