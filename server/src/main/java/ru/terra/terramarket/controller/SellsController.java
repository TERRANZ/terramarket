package ru.terra.terramarket.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.controller.AbstractController;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.security.SecurityLevel;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.User;
import ru.terra.terramarket.dto.sell.SellDTO;
import ru.terra.terramarket.engine.SellsEngine;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

/**
 * User: Vadim Korostelev
 * Date: 30.09.13
 * Time: 13:14
 */
@Path(URLConstants.DoJson.Sell.SELL)
public class SellsController extends AbstractController<Sells, SellDTO, SellsEngine> {
    protected Logger logger = Logger.getLogger(this.getClass());

    public SellsController() {
        super(SellsEngine.class);
    }

    @POST
    @Path(URLConstants.DoJson.Sell.SELL_DO_SELL_JSON)
    public SimpleDataDTO<Integer> doSell(@Context HttpContext hc,
                                         @QueryParam("counts") String counts,
                                         @QueryParam("products") String products) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.CASHIER)) {
            SimpleDataDTO<Integer> ret = new SimpleDataDTO<>(-1);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        logger.info("Doing sell with products = " + products + " and counts = " + counts);
        String[] parsedProds = products.split(",");
        String[] parsedCounts = counts.split(",");
        return engine.doSell((User) getCurrentUser(hc), parsedProds, parsedCounts);
    }

}
