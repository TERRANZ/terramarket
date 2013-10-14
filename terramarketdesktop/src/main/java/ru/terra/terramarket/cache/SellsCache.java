package ru.terra.terramarket.cache;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.sell.SellDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class SellsCache extends AbstractCache<Integer, SellDTO> {
	private static SellsCache instance = new SellsCache();

	public static SellsCache getInstance() {
		return instance;
	}

	private SellsCache() {
	}

	@Override
	public void fill(Shell shell) {
		for (SellDTO dto : new RestClient(shell).loadSells().data)
			add(dto.id, dto);
	}

}
