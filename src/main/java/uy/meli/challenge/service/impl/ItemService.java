package uy.meli.challenge.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.entity.ItemCache;
import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.challenge.service.IItemService;
import uy.meli.challenge.utils.ItemDTOConverter;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@Service
public class ItemService implements IItemService {

	@Autowired
	private IItemExternal meliClient;

	@Autowired
	private IItemCacheDAO itemCacheDAO;

	@Autowired
	private ItemDTOConverter converter;

	@Override
	public ItemDTO getItemById(String id) throws RuntimeException {
		ItemDTO itemDTO = new ItemDTO();
		Optional<ItemCache> itemCache = itemCacheDAO.findByItemId(id);

		if (itemCache.isPresent()) {
			itemDTO = itemCache.get().getItemInfo();
		} else {
			long startTime = System.nanoTime();
			MeliItemDTO item = meliClient.getItem(id);
			MeliBaseItemDTO[] childs = meliClient.getItemChilds(id);
			
			itemDTO = converter.meliDTOToItemDTO(item, childs);
		}
		return itemDTO;
	}

	public void temp() {
//		ItemCacheDTO itemCacheDTO = new ItemCacheDTO();
//		itemCacheDTO.setItemInfo(itemDTO);
//		ModelMapper modelMapper = new ModelMapper();
//		ItemCache  itemCache = modelMapper.map(itemCacheDTO, ItemCache.class);	
	}

}
