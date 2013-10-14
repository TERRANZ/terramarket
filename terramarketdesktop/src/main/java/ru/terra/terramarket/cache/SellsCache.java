package ru.terra.terramarket.cache;

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
	public void fill() {
		for (SellDTO dto : new RestClient().loadSells().data)
			add(dto.id, dto);
	}

}
