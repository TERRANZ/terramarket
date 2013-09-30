package ru.terra.terramarket.cache;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.network.RestClient;

public class WayBillsCache extends AbstractCache<Integer, WayBillDTO> {
	private static WayBillsCache instance = new WayBillsCache();

	public static WayBillsCache getInstance() {
		return instance;
	}

	private WayBillsCache() {
	}
	@Override
	public void fill() {
		ListDTO<WayBillDTO> wbs = new RestClient().loadWBs();
		if (wbs != null)
			for (WayBillDTO prod : wbs.data) {
				add(prod.id, prod);
			}
	}
}
