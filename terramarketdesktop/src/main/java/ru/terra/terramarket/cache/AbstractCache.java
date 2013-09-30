package ru.terra.terramarket.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Vadim Korostelev Date: 21.08.13 Time: 12:38
 */
public abstract class AbstractCache<K, V> {
	private Map<K, V> cacheMap = new HashMap<>();

	public void add(K key, V value) {
		cacheMap.put(key, value);
	}

	public Integer size() {
		return cacheMap.size();
	}

	public void del(K key) {
		cacheMap.remove(key);
	}

	public List<V> getValues() {
		return new ArrayList<>(cacheMap.values());
	}

	public V get(K key) {
		return cacheMap.get(key);
	}
	
	public abstract void fill();
}
