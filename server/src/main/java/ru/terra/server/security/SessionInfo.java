package ru.terra.server.security;

import ru.terra.terramarket.db.entity.User;

import java.util.Date;
import java.util.HashMap;

/**
 * User: Vadim Korostelev
 * Date: 09.09.13
 * Time: 15:45
 */
public class SessionInfo {
    private String sessionid;
    private User user;
    private HashMap<String, String> parameters = new HashMap<>();
    private Date sessionAccessDate = new Date();

    public SessionInfo(String sessionid, User user) {
        this.sessionid = sessionid;
        this.user = user;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }

    public Date getSessionAccessDate() {
        return sessionAccessDate;
    }

    public void setSessionAccessDate(Date sessionAccessDate) {
        this.sessionAccessDate = sessionAccessDate;
    }
}
