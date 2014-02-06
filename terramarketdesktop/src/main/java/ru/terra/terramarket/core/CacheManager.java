package ru.terra.terramarket.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.cache.AbstractCache;
import ru.terra.terramarket.cache.GroupCache;
import ru.terra.terramarket.cache.ProductsCache;
import ru.terra.terramarket.cache.SellsCache;
import ru.terra.terramarket.cache.StoreCache;
import ru.terra.terramarket.cache.WayBillsCache;

public class CacheManager {
	private static CacheManager instance = new CacheManager();
	private Logger logger = Logger.getLogger(CacheManager.class);
	private Map<Class<?>, AbstractCache<?>> caches = new HashMap<>();

	private CacheManager() {
		caches.put(GroupCache.class, new GroupCache());
		caches.put(ProductsCache.class, new ProductsCache());
		caches.put(SellsCache.class, new SellsCache());
		caches.put(StoreCache.class, new StoreCache());
		caches.put(WayBillsCache.class, new WayBillsCache());
	}

	public static CacheManager getInstance() {
		return instance;
	}

	public void fillCache(final Shell shell) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					caches.get(ProductsCache.class).fill(shell);
					caches.get(GroupCache.class).fill(shell);
					caches.get(WayBillsCache.class).fill(shell);
					caches.get(StoreCache.class).fill(shell);
					caches.get(SellsCache.class).fill(shell);
				} catch (Exception e) {
					logger.error("Unable to load", e);
				}
			}
		}).start();

	}

	public AbstractCache getCache(Class clazz) {
		return caches.get(clazz);
	}
}
