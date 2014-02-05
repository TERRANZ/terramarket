package ru.terra.server.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import ru.terra.server.constants.CoreUrlConstants;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.ListDTO;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.server.security.SecurityLevel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

public abstract class AbstractController<Bean, ReturnDto extends CommonDTO, Engine extends AbstractEngine<Bean, ReturnDto>> extends AbstractResource {

    protected Engine engine;

    private Logger logger = Logger.getLogger(AbstractController.class);

    public AbstractController(Class<Engine> engineClass) {
        try {
            engine = engineClass.newInstance();
        } catch (InstantiationException e) {
            logger.error("Unable to instantiate egine", e);
        } catch (IllegalAccessException e) {
            logger.error("Unable to access to engine class", e);
        }
    }

    @GET
    @Path(CoreUrlConstants.DoJson.DO_LIST)
    public ListDTO<ReturnDto> list(@Context HttpContext hc, @QueryParam("all") boolean all, @QueryParam("page") Integer page, @QueryParam("perpage") Integer perpage) {
        if (engine == null)
            throw new NotImplementedException();
        ListDTO<ReturnDto> ret = new ListDTO<>();
        ret.setData(engine.listDtos(all, page, perpage));
        return ret;
    }

    @GET
    @Path(CoreUrlConstants.DoJson.DO_GET)
    public ReturnDto get(@Context HttpContext hc, @QueryParam("id") Integer id) {
        if (engine == null)
            throw new NotImplementedException();
        return engine.getDto(id);
    }

    @GET
    @Path(CoreUrlConstants.DoJson.DO_DEL)
    public SimpleDataDTO<Boolean> delete(@Context HttpContext hc, @QueryParam("id") Integer id) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<Boolean>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        return new SimpleDataDTO<Boolean>(engine.delete(id));
    }
}
