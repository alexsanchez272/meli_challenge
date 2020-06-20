package uy.meli.challenge.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.exceptions.ItemNotFoundException;
import uy.meli.challenge.service.IItemService;

@RestController
@RequestMapping("/items")
public class ItemRest {

	@Autowired
	private IItemService itemService;

	@GetMapping(value = "/{id}")
	public ItemDTO findItemById(@PathVariable("id") String id) {
		Optional<ItemDTO> itemDto = itemService.getItemById(id);

		if (!itemDto.isPresent()) {
			throw new ItemNotFoundException();
		}

		return itemDto.get();
	}
}
