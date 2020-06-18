package uy.meli.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@Component
public class MeliClient implements IItemExternal{
	
	@Autowired
	private RestOperations restOperations;
	private final String url;
	private final String childrenEndpont;
	
	@Autowired
	public MeliClient(@Value("${item.service.url}") final String url,
			@Value("${item.child.service.endpoint}") final String childrenEndpont) {
		this.url = url;
		this.childrenEndpont = childrenEndpont;
	} 

	@Override
	public MeliItemDTO getItem(String id) {
		return restOperations.getForObject(url, MeliItemDTO.class, id);
	}

	@Override
	public MeliBaseItemDTO[] getItemChilds(String id) {
		MeliBaseItemDTO[] childs = restOperations.getForObject(url+childrenEndpont, MeliBaseItemDTO[].class, id);
		return childs;
				
	}
	
	

}
