package ru.terra.terramarket.network.tmclients;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.group.GroupDTO;

public interface Groups {
	@GET
	@Path(URLConstants.DoJson.Group.GROUP + URLConstants.DoJson.DO_LIST)
	ListDTO<GroupDTO> loadGroups(@HeaderParam("Cookie") String session, @QueryParam("all") boolean all, @QueryParam("page") int page,
			@QueryParam("perpage") int perpage);
}
