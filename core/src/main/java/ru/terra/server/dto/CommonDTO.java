package ru.terra.server.dto;

import java.io.Serializable;
import java.util.Date;

public class CommonDTO implements Serializable {
    public String errorMessage = "";
    public Integer errorCode = 0;
    public String status = "";
    public Long timestamp = new Date().getTime();
    public Integer id = -1;

}
