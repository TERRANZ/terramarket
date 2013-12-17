package ru.terra.terramarket.controller;


import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.controller.AbstractController;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.security.SecurityLevel;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.Store;
import ru.terra.terramarket.dto.store.StoreDTO;
import ru.terra.terramarket.engine.StoreEngine;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

@Path(URLConstants.DoJson.Store.STORE)
public class StoreController extends AbstractController<Store, StoreDTO, StoreEngine> {
    public StoreController() {
        super(StoreEngine.class);
    }

    @POST
    @Path(URLConstants.DoJson.DO_CREATE)
    public SimpleDataDTO<Boolean> create(@Context HttpContext hc, @QueryParam("product") Integer product, @QueryParam("count") Integer count) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        return engine.addToStore(product, count);
    }
}
