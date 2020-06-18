package uy.meli.interfaces.dto;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MeliBaseItemDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private LocalDateTime stop_time;
	
	public MeliBaseItemDTO() {
		super();
	}
	
	public MeliBaseItemDTO(String id, LocalDateTime stop_time) {
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
