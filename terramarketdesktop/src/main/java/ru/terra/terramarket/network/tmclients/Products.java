package ru.terra.terramarket.network.tmclients;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

public interface Products {
	@GET
	@Path(URLConstants.DoJson.Product.PRODUCT + URLConstants.DoJson.DO_LIST)
	ListDTO<ProductDTO> loadProducts(@HeaderParam("Cookie") String session, @QueryParam("all") boolean all, @QueryParam("page") int page,
			@QueryParam("perpage") int perpage);

	@POST
	@Path(URLConstants.DoJson.Product.PRODUCT + URLConstants.DoJson.DO_CREATE)
	ProductDTO createProduct(@HeaderParam("Cookie") String session, @QueryParam("name") String name, @QueryParam("mincount") Integer mincount,
			@QueryParam("barcode") String barcode, @QueryParam("qtype") Integer qtype, @QueryParam("pricein") Integer priceIn,
			@QueryParam("priceout") Integer priceOut, @QueryParam("groupid") Integer group);

	@POST
	@Path(URLConstants.DoJson.Product.PRODUCT + "do.update.json")
	SimpleDataDTO<Boolean> updateProduct(@HeaderParam("Cookie") String session, @QueryParam("name") String name, @QueryParam("mincount") Integer mincount,
			@QueryParam("barcode") String barcode, @QueryParam("qtype") Integer qtype, @QueryParam("pricein") Integer priceIn,
			@QueryParam("priceout") Integer priceOut, @QueryParam("groupid") Integer group);
}
