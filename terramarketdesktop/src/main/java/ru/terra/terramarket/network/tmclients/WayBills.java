package ru.terra.terramarket.network.tmclients;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;

public interface WayBills {
	@GET
	@Path(URLConstants.DoJson.WayBill.WAYBILL + URLConstants.DoJson.DO_LIST)
	ListDTO<WayBillDTO> loadWBs(@HeaderParam("Cookie") String session, @QueryParam("all") boolean all, @QueryParam("page") int page,
			@QueryParam("perpage") int perpage);

	@POST
	@Path(URLConstants.DoJson.WayBill.WAYBILL + URLConstants.DoJson.DO_CREATE)
	WayBillDTO createWB(@HeaderParam("Cookie") String session, @QueryParam("date") Long date, @QueryParam("count") Integer count,
			@QueryParam("products") String products, @QueryParam("counts") String counts, @QueryParam("title") String title,
			@QueryParam("supplier") String supplier);

	@POST
	@Path(URLConstants.DoJson.WayBill.WAYBILL + URLConstants.DoJson.DO_UPDATE)
	SimpleDataDTO<Boolean> updateWayBill(@HeaderParam("Cookie") String session, @QueryParam("field") String field, @QueryParam("param") String param,
			@QueryParam("id") Integer id);

	@POST
	@Path(URLConstants.DoJson.WayBill.WAYBILL + URLConstants.DoJson.WayBill.UPDATE_ITEMS)
	SimpleDataDTO<Boolean> updateWayBillItems(@HeaderParam("Cookie") String session, @QueryParam("products") String products,
			@QueryParam("counts") String counts, @QueryParam("id") Integer id);

}
