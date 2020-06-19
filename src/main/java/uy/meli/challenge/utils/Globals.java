package uy.meli.challenge.utils;

import uy.meli.challenge.dto.ItemCacheDTO;

public class Globals {

	public static ThreadLocal<ItemCacheDTO> GLOBAL_CACHE;

	static {
		GLOBAL_CACHE = new ThreadLocal<ItemCacheDTO>() {
			@Override
			public ItemCacheDTO initialValue() {
				return new ItemCacheDTO();
			}
		};
	}

}
