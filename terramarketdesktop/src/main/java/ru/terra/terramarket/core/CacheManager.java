package ru.terra.terramarket.core;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.cache.GroupCache;
import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.cache.SellsCache;
import ru.terra.terramarket.cache.StoreCache;
import ru.terra.terramarket.cache.WayBillsCache;

public class CacheManager {
	private static CacheManager instance = new CacheManager();
	private Logger logger = Logger.getLogger(CacheManager.class);

	private CacheManager() {
	}

	public static CacheManager getInstance() {
		return instance;
	}

	public void fillCache(Shell shell) {
		try {
			ProductsCache.getInstance().fill(shell);
			GroupCache.getInstance().fill(shell);
			WayBillsCache.getInstance().fill(shell);
			StoreCache.getInstance().fill(shell);
			SellsCache.getInstance().fill(shell);
		} catch (Exception e) {
			logger.error("Unable to load", e);
		}

	}
}
