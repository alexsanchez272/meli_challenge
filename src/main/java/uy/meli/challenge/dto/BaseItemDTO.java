package uy.meli.challenge.dto;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private LocalDateTime stop_time;
	
	public BaseItemDTO() {
		super();
	}
	
	public BaseItemDTO(String id, LocalDateTime stop_time) {
		super();
		this.id = id;
		this.stop_time = stop_time;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public LocalDateTime getStop_time() {
		return stop_time;
	}
	
	public void setStop_time(LocalDateTime stop_time) {
		this.stop_time = stop_time;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
