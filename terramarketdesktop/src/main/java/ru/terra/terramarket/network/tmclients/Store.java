package ru.terra.terramarket.network.tmclients;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.store.StoreDTO;

public interface Store {
	@GET
	@Path(URLConstants.DoJson.Store.STORE + URLConstants.DoJson.DO_LIST)
	ListDTO<StoreDTO> loadStore(@HeaderParam("Cookie") String session, @QueryParam("all") boolean all, @QueryParam("page") int page,
			@QueryParam("perpage") int perpage);

	@POST
	@Path(URLConstants.DoJson.Store.STORE + URLConstants.DoJson.DO_CREATE)
	SimpleDataDTO<Boolean> addToStore(@HeaderParam("Cookie") String session, @QueryParam("product") Integer product, @QueryParam("count") Integer count);
}
