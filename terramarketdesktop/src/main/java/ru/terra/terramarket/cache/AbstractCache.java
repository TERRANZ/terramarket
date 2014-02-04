package ru.terra.terramarket.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Shell;

/**
 * User: Vadim Korostelev Date: 21.08.13 Time: 12:38
 */
public abstract class AbstractCache<V> {
	private Map<Integer, V> cacheMap = new HashMap<>();

	public void add(Integer id, V value) {
		cacheMap.put(id, value);
	}

	public Integer size() {
		return cacheMap.size();
	}

	public void del(Integer id) {
		cacheMap.remove(id);
	}

	public List<V> getValues() {
		return new ArrayList<>(cacheMap.values());
	}

	public V get(Integer id) {
		return cacheMap.get(id);
	}

	public abstract void fill(Shell shell);

}
