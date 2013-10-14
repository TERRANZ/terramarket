package ru.terra.terramarket.cache;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.store.StoreDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class StoreCache extends AbstractCache<Integer, StoreDTO> {
	private static StoreCache instance = new StoreCache();

	public static StoreCache getInstance() {
		return instance;
	}

	private StoreCache() {
	}

	@Override
	public void fill() {
		ListDTO<StoreDTO> store = new RestClient().loadStore();
		for (StoreDTO dto : store.data)
			add(dto.id, dto);
	}

}
