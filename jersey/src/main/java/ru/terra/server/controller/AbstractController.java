package ru.terra.server.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import org.apache.log4j.Logger;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.ListDTO;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.server.security.SecurityLevel;
import ru.terra.server.security.SessionsHolder;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

public abstract class AbstractController<Bean, ReturnDto extends CommonDTO, Engine extends AbstractEngine<Bean, ReturnDto>> {
    protected SessionsHolder sessionsHolder = SessionsHolder.getInstance();
    protected Engine engine;
    private Logger logger = Logger.getLogger(AbstractController.class);

    public AbstractController(Class<Engine> engineClass) {
        try {
            engine = engineClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected static String getParameter(HttpContext context, String key) {
        return context.getRequest().getQueryParameters().getFirst(key);
    }

    protected String extractSessionId(HttpContext context) {
        return context.getRequest().getCookieNameValueMap().getFirst("JSESSIONID");
    }

    protected boolean isAuthorized(HttpContext context) {
        String sessionId = extractSessionId(context);
        if (sessionId == null)
            return false;
        return sessionsHolder.getSession(sessionId) != null;
    }

    protected Integer getCurrentUserId(HttpContext context) {
        User u = getCurrentUser(context);
        return u != null ? u.getId() : null;
    }

    protected User getCurrentUser(HttpContext context) {
        return sessionsHolder.getSession(extractSessionId(context)).getUser();
    }

    protected boolean checkUserCanAccess(HttpContext context, SecurityLevel level) {
        User u = getCurrentUser(context);
        if (u != null && u.getLevel() >= level.ordinal())
            return true;
        return false;
    }

    @GET
    @Path(URLConstants.DoJson.DO_LIST)
    public ListDTO<ReturnDto> list(@Context HttpContext hc, @QueryParam("all") boolean all, @QueryParam("page") Integer page, @QueryParam("perpage") Integer perpage) {
        logger.info("Loading list of dtos");
        if (engine == null)
            throw new NotImplementedException();
        ListDTO<ReturnDto> ret = new ListDTO<>();
        ret.setData(engine.listDtos(all, page, perpage));
        return ret;
    }

    @GET
    @Path(URLConstants.DoJson.DO_GET)
    public ReturnDto get(@Context HttpContext hc, @QueryParam("id") Integer id) {
        if (engine == null)
            throw new NotImplementedException();
        return engine.getDto(id);
    }

    @GET
    @Path(URLConstants.DoJson.DO_DEL)
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
