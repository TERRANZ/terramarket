package ru.terra.terramarket.cache;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.store.StoreDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class StoreCache extends AbstractCache<StoreDTO> {



	@Override
	public void fill(Shell shell) {
		ListDTO<StoreDTO> store = new RestClient(shell).loadStore();
		for (StoreDTO dto : store.data)
			add(dto.id, dto);
	}

}
