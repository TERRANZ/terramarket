package ru.terra.terramarket.cache;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.network.RestClient;

public class GroupCache extends AbstractCache<Integer, GroupDTO> {
	private static GroupCache instance = new GroupCache();

	public static GroupCache getInstance() {
		return instance;
	}

	private GroupCache() {
	}

	public void fill() {
		ListDTO<GroupDTO> groups = new RestClient().loadGroups();
		if (groups != null)
			for (GroupDTO group : groups.data) {
				add(group.id, group);
			}
	}
}
