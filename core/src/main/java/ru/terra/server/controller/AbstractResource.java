package ru.terra.server.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.log4j.Logger;
import ru.terra.server.db.entity.AbstractUser;
import ru.terra.server.security.SecurityLevel;
import ru.terra.server.security.SessionsHolder;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
        return sessionsHolder.getSession(extractSessionId(context)).getUser();
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
}
