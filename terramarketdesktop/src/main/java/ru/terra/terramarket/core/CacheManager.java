package ru.terra.terramarket.core;

import org.apache.log4j.Logger;

import ru.terra.terramarket.cache.GroupCache;
import ru.terra.terramarket.cache.ProductsCache;
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

	public void fillCache() {
		try {
			ProductsCache.getInstance().fill();
			GroupCache.getInstance().fill();
			WayBillsCache.getInstance().fill();
			StoreCache.getInstance().fill();
		} catch (Exception e) {
			logger.error("Unable to load", e);
		}
		
	}
}
