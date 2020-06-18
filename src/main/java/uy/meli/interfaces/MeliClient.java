package uy.meli.interfaces;

import org.springframework.stereotype.Component;

import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.interfaces.IItemExternal;

@Component
public class MeliClient implements IItemExternal{

	@Override
	public ItemDTO getItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
