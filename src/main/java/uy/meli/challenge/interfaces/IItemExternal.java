package uy.meli.challenge.interfaces;

import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

public interface IItemExternal {
	
	public MeliItemDTO getItem(String id);
	
	public MeliBaseItemDTO[] getItemChilds(String id);

}
