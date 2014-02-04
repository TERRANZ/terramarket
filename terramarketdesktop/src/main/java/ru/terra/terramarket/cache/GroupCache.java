package ru.terra.terramarket.cache;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.network.RestClient;

@Cache
public class GroupCache extends AbstractCache<GroupDTO> {
	@Override
	public void fill(Shell shell) {
		ListDTO<GroupDTO> groups = new RestClient(shell).loadGroups();
		if (groups != null)
			for (GroupDTO group : groups.data) {
				add(group.id, group);
			}
	}
}
