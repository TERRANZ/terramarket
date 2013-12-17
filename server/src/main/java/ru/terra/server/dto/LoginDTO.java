package ru.terra.server.dto;

import flexjson.JSONDeserializer;

public class LoginDTO extends CommonDTO {
    public String message = "";
    public boolean logged;
    public String session = "";

    public static LoginDTO valueOf(String json) {
        return new JSONDeserializer<LoginDTO>().deserialize(json);
    }

}
