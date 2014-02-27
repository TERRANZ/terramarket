package ru.terra.server.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.log4j.Logger;
import ru.terra.server.db.entity.AbstractUser;
import ru.terra.server.security.SecurityLevel;
import ru.terra.server.security.SessionInfo;
import ru.terra.server.security.SessionsHolder;
import sun.misc.IOUtils;

import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@Produces(MediaType.APPLICATION_JSON)
public class AbstractResource {
    protected SessionsHolder sessionsHolder = SessionsHolder.getInstance();
    private Logger logger = Logger.getLogger(AbstractResource.class);

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
        AbstractUser u = getCurrentUser(context);
        return u != null ? u.getId() : null;
    }

    protected AbstractUser getCurrentUser(HttpContext context) {
        SessionInfo sessionInfo = sessionsHolder.getSession(extractSessionId(context));
        return sessionInfo == null ? null : sessionInfo.getUser();
    }

    protected boolean checkUserCanAccess(HttpContext context, SecurityLevel level) {
        AbstractUser u = getCurrentUser(context);
        if (u == null) {
            logger.info("User is null");
            return false;
        }
        if (u.getLevel() >= level.ordinal())
            return true;
        return false;
    }

    public static Response getFile(String path) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            stream.write(IOUtils.readFully(new FileInputStream(new File(path)), -1, true));
        } catch (IOException e) {
            Logger.getLogger(AbstractResource.class).error("Unable to read file", e);
            Response response = Response
                    .noContent()
                    .build();
            return response;
        }
        CacheControl cc = new CacheControl();
        cc.setNoTransform(true);
        cc.setMustRevalidate(false);
        cc.setNoCache(false);
        cc.setMaxAge(3600);
        EntityTag entityTag = new EntityTag(String.valueOf(path.hashCode()));

        Response response = Response
                .ok()
                .cacheControl(cc)
                .tag(entityTag)
                .entity(stream.toByteArray())
                .build();
        return response;
    }

}
