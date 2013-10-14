package ru.terra.terramarket.cache;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class WayBillsCache extends AbstractCache<Integer, WayBillDTO> {
	private static WayBillsCache instance = new WayBillsCache();

	public static WayBillsCache getInstance() {
		return instance;
	}

	private WayBillsCache() {
	}
	@Override
	public void fill(Shell shell) {
		ListDTO<WayBillDTO> wbs = new RestClient(shell).loadWBs();
		if (wbs != null)
			for (WayBillDTO prod : wbs.data) {
				add(prod.id, prod);
			}
	}
}
