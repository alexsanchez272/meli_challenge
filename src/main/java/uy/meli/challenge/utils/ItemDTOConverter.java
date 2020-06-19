package uy.meli.challenge.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import uy.meli.challenge.dto.BaseItemDTO;
import uy.meli.challenge.dto.ItemDTO;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@Component
public class ItemDTOConverter {
	
	private ItemDTO itemDTO;
	private List<BaseItemDTO> itemChilds;
	
	public ItemDTO meliDTOToItemDTO(MeliItemDTO meliItemDTO, MeliBaseItemDTO[] childs) {
		
		itemDTO = new ItemDTO();
		itemDTO.setId((!meliItemDTO.getId().isEmpty())?meliItemDTO.getId():"");
		itemDTO.setTitle((!meliItemDTO.getTitle().isEmpty())?meliItemDTO.getTitle():"");
		itemDTO.setCategory_id((!meliItemDTO.getCategory_id().isEmpty())?meliItemDTO.getCategory_id():"");
		itemDTO.setPrice((meliItemDTO.getPrice() != null)?meliItemDTO.getPrice():null);
		itemDTO.setStart_time((meliItemDTO.getStart_time() != null)?meliItemDTO.getStart_time():null);
		itemDTO.setStop_time((meliItemDTO.getStop_time() != null)?meliItemDTO.getStop_time():null);
		
		itemChilds = new ArrayList<>();		
		for (MeliBaseItemDTO child : childs) {
			itemChilds.add(new BaseItemDTO(child.getId(), child.getStop_time()));
		}
		
		itemDTO.setChilds(itemChilds);
		
		return itemDTO;
	}
	

}
