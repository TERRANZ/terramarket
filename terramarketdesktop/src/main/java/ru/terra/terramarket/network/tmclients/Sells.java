package ru.terra.terramarket.network.tmclients;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.sell.SellDTO;

public interface Sells {
	@POST
	@Path(URLConstants.DoJson.Sell.SELL + URLConstants.DoJson.Sell.SELL_DO_SELL_JSON)
	SimpleDataDTO<Integer> doSell(@HeaderParam("Cookie") String session, @QueryParam("products") String products, @QueryParam("counts") String counts);
	
	@GET
	@Path(URLConstants.DoJson.Sell.SELL + URLConstants.DoJson.DO_LIST)
	ListDTO<SellDTO> loadSells(@HeaderParam("Cookie") String session, @QueryParam("all") boolean all, @QueryParam("page") int page,
			@QueryParam("perpage") int perpage);

}
