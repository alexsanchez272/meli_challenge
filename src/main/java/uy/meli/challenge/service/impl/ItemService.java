package uy.meli.challenge.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uy.meli.challenge.dao.IItemCacheDAO;
import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.entity.ApiData;
import uy.meli.challenge.entity.ItemCache;
import uy.meli.challenge.entity.MlApiData;
import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.challenge.service.IItemService;
import uy.meli.challenge.utils.Globals;
import uy.meli.challenge.utils.ItemDTOConverter;
import uy.meli.challenge.utils.MetricData;
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
	public Optional<ItemDTO> getItemById(String id) {

		Optional<ItemDTO> itemDTO = Optional.empty();

		Optional<ItemCache> itemCache = Optional.ofNullable(itemCacheDAO.findByItemId(id));

		if (itemCache.isPresent()) {
			itemDTO = Optional.of(itemCache.get().getItemInfo());
			Globals.GLOBAL_CACHE.get().put(MetricData.API_ITEM_INFO.getValue(), Optional.empty());
			return itemDTO;
		} else {
			Optional<MeliItemDTO> item = meliClient.getItem(id);
			Optional<MeliBaseItemDTO[]> childs = Optional.empty();
			if (item.isPresent()) {
				childs = meliClient.getItemChilds(id);
			}
			if (item.isPresent()) {
				itemDTO = Optional.of(converter.meliDTOToItemDTO(item.get(), childs.get()));
			}
			Globals.GLOBAL_CACHE.get().put(MetricData.API_ITEM_INFO.getValue(), itemDTO);
			return itemDTO;
		}
	}

	@Override
	@Transactional
	public void saveItemCache(ItemCache itemCache) {
		itemCacheDAO.createItemCache(itemCache);
	}

	@Override
	@Transactional
	public void saveApiData(ApiData apiData) {
		if (apiData.getItemCacheId() != null) {
			itemCacheDAO.createItemCache(apiData.getItemCacheId());
		}
		itemCacheDAO.createApiData(apiData);
	}

	public void temp() {
//		ItemCacheDTO itemCacheDTO = new ItemCacheDTO();
//		itemCacheDTO.setItemInfo(itemDTO);
//		ModelMapper modelMapper = new ModelMapper();
//		ItemCache  itemCache = modelMapper.map(itemCacheDTO, ItemCache.class);	
	}

}
