package ru.terra.server.dto;

import flexjson.JSONDeserializer;
import ru.terra.terramarket.db.entity.User;

public class UserDTO extends CommonDTO {
    public String name;
    public Integer level;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.level = user.getLevel();
    }

    public static UserDTO valueOf(String json) {
        return new JSONDeserializer<UserDTO>().deserialize(json);
    }

}
