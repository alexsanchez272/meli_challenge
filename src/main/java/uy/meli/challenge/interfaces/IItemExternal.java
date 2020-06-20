package uy.meli.challenge.interfaces;

import java.util.Optional;

import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

public interface IItemExternal {
	
	public Optional<MeliItemDTO> getItem(String id);
	
	public Optional<MeliBaseItemDTO[]> getItemChilds(String id);

}
