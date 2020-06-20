package uy.meli.challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import uy.meli.challenge.dto.ItemDTO;
import uy.meli.challenge.entity.ApiData;
import uy.meli.challenge.entity.ItemCache;
import uy.meli.challenge.entity.MlApiData;
import uy.meli.challenge.service.impl.ItemService;
import uy.meli.challenge.utils.Globals;
import uy.meli.challenge.utils.MetricData;

public class AppFilter implements Filter {

	@Autowired
	private ItemService itemService;

	
	public AppFilter() {
		super();
	}

	public AppFilter(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			Globals.GLOBAL_CACHE.get().put(MetricData.API_REQUEST_DATE.getValue(), new Date());
			Globals.GLOBAL_CACHE.get().put(MetricData.API_START_TIME.getValue(), System.currentTimeMillis());

			chain.doFilter(request, response);
		} finally {
			Globals.GLOBAL_CACHE.get().put(MetricData.API_STOP_TIME.getValue(), System.currentTimeMillis());
			createItemCache();
			Globals.GLOBAL_CACHE.remove();
		}

	}

	@Override
	public void destroy() {
	}

	@SuppressWarnings("unchecked")
	private void createItemCache() {

		ItemCache itemCache = new ItemCache();
		Optional<ItemDTO> itemInfo = (Optional<ItemDTO>) Globals.GLOBAL_CACHE.get()
				.get(MetricData.API_ITEM_INFO.getValue());
		
		itemCache.setItemInfo(itemInfo.isPresent()?itemInfo.get() : null);

		ApiData apiData = new ApiData();
		apiData.setCreationDate((Date) Globals.GLOBAL_CACHE.get().get(MetricData.API_REQUEST_DATE.getValue()));
		apiData.setResponseTime((Long) Globals.GLOBAL_CACHE.get().get(MetricData.API_STOP_TIME.getValue())
				- (Long) Globals.GLOBAL_CACHE.get().get(MetricData.API_START_TIME.getValue()));
		apiData.setItemCacheId((itemCache.getItemInfo() != null) ? itemCache : null);

		if (Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_ITEM_START_TIME.getValue()) != null) {
			List<MlApiData> apiDataCollection = new ArrayList<>();
			apiDataCollection.add(new MlApiData(
					(Long) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_ITEM_STOP_TIME.getValue())
							- (Long) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_ITEM_START_TIME.getValue()),
					(Integer) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_ITEM_STATUS_CODE.getValue()), apiData));

			if (Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_CHILD_START_TIME.getValue()) != null) {
				apiDataCollection.add(new MlApiData(
						(Long) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_CHILD_STOP_TIME.getValue())
								- (Long) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_CHILD_START_TIME.getValue()),
						(Integer) Globals.GLOBAL_CACHE.get().get(MetricData.CLIENT_ITEM_STATUS_CODE.getValue()),
						apiData));
			}
			apiData.setMlApiDataCollection(apiDataCollection);
		}
		itemService.saveApiData(apiData);

	}
}
