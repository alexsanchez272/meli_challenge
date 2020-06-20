package uy.meli.interfaces;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperations;

import uy.meli.challenge.interfaces.IItemExternal;
import uy.meli.challenge.utils.Globals;
import uy.meli.challenge.utils.MetricData;
import uy.meli.interfaces.dto.MeliBaseItemDTO;
import uy.meli.interfaces.dto.MeliItemDTO;

@Component
public class MeliClient implements IItemExternal {

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
	public Optional<MeliItemDTO> getItem(String id) {
		ResponseEntity<MeliItemDTO> meliResponse = null;

		try {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_ITEM_START_TIME.getValue(), System.currentTimeMillis());
			meliResponse = restOperations.getForEntity(url, MeliItemDTO.class, id);
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_ITEM_STATUS_CODE.getValue(), meliResponse.getStatusCodeValue());
		} catch (HttpStatusCodeException ex) {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_ITEM_STATUS_CODE.getValue(), ex.getStatusCode().value());
		} finally {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_ITEM_STOP_TIME.getValue(), System.currentTimeMillis());
		}
		return Optional.ofNullable((meliResponse != null) ? meliResponse.getBody() : null);
	}

	@Override
	public Optional<MeliBaseItemDTO[]> getItemChilds(String id) {
		ResponseEntity<MeliBaseItemDTO[]> childResponse = null;
		try {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_CHILD_START_TIME.getValue(), System.currentTimeMillis());
			childResponse = restOperations.getForEntity(url + childrenEndpont, MeliBaseItemDTO[].class, id);
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_CHILD_STATUS_CODE.getValue(),
					childResponse.getStatusCodeValue());
		} catch (HttpStatusCodeException ex) {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_CHILD_STATUS_CODE.getValue(), ex.getStatusCode().value());
		} finally {
			Globals.GLOBAL_CACHE.get().put(MetricData.CLIENT_CHILD_STOP_TIME.getValue(), System.currentTimeMillis());
		}
		return Optional.ofNullable((childResponse != null) ? childResponse.getBody() : null);
	}

}
