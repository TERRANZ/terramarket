package ru.terra.terramarket.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.controller.AbstractController;
import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.security.SecurityLevel;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.Waybill;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.dto.waybill.WayBillItemDTO;
import ru.terra.terramarket.engine.ProductEngine;
import ru.terra.terramarket.engine.UsersEngine;
import ru.terra.terramarket.engine.WayBillEngine;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@Path(URLConstants.DoJson.WayBill.WAYBILL)
public class WayBillsController extends AbstractController<Waybill, WayBillDTO, WayBillEngine> {
    public WayBillsController() {
        super(WayBillEngine.class);
    }

    private UsersEngine usersEngine = new UsersEngine();
    private ProductEngine productEngine = new ProductEngine();

    @GET
    @Path(URLConstants.DoJson.WayBill.UPDATE_ITEMS)
    public SimpleDataDTO<Boolean> updateItems(@Context HttpContext hc,
                                              @QueryParam("id") Integer id,
                                              @QueryParam("counts") String counts,
                                              @QueryParam("products") String products) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        Waybill wb = engine.getBean(id);
        if (wb != null) {
            String[] parsedProds = products.split(",");
            String[] parsedCounts = counts.split(",");
            Integer[] prods = new Integer[parsedProds.length];
            Integer[] cnts = new Integer[parsedCounts.length];
            for (int i = 0; i < parsedCounts.length; i++) {
                prods[i] = Integer.parseInt(parsedProds[i]);
                cnts[i] = Integer.parseInt(parsedCounts[i]);
            }
            engine.updateWayBillItems(wb, prods, cnts);
            return new SimpleDataDTO<>(true);
        }
        return new SimpleDataDTO<>(false);
    }

    @POST
    @Path(URLConstants.DoJson.DO_CREATE)
    public WayBillDTO create(@Context HttpContext hc,
                             @QueryParam("date") Long date,
                             @QueryParam("count") Integer count,
                             @QueryParam("products") String products,
                             @QueryParam("counts") String counts,
                             @QueryParam("title") String title,
                             @QueryParam("supplier") String supplier) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            CommonDTO ret = new CommonDTO();
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return (WayBillDTO) ret;
        }

        List<WayBillItemDTO> items = new ArrayList<>();
        String[] parsedProducts = products.split(",");
        String[] parsedCounts = counts.split(",");
        Integer[] iproducts = new Integer[parsedProducts.length];
        Integer[] icounts = new Integer[parsedCounts.length];
        for (int i = 0; i < parsedProducts.length; i++) {
            iproducts[i] = Integer.parseInt(parsedProducts[i]);
            icounts[i] = Integer.parseInt(parsedCounts[i]);
        }
        return engine.create(date, getCurrentUserId(hc), count, iproducts, icounts, title, supplier);
    }

    @POST
    @Path(URLConstants.DoJson.DO_UPDATE)
    public SimpleDataDTO<Boolean> update(@Context HttpContext hc,
                                         @QueryParam("date") Long date,
                                         @QueryParam("count") Integer count,
                                         @QueryParam("products") String products,
                                         @QueryParam("counts") String counts,
                                         @QueryParam("title") String title,
                                         @QueryParam("supplier") String supplier) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }

        List<WayBillItemDTO> items = new ArrayList<>();
        String[] parsedProducts = products.split(",");
        String[] parsedCounts = counts.split(",");
        for (int i = 0; i < parsedProducts.length; i++) {
            Integer prod = Integer.parseInt(parsedProducts[i]);
            Integer icount = Integer.parseInt(parsedCounts[i]);
            items.add(new WayBillItemDTO(icount, null, productEngine.getDto(prod)));
        }
        return new SimpleDataDTO<>(
                engine.updateDTO(
                        new WayBillDTO(
                                count, date, items, usersEngine.getDto(getCurrentUserId(hc)), supplier, title)));
    }

}
