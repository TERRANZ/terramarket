package ru.terra.server.dto;

import flexjson.JSONDeserializer;

public class SimpleDataDTO<T> extends CommonDTO {
    public T data;

    public SimpleDataDTO(T data) {
        this.data = data;
    }

    public static SimpleDataDTO valueOf(String json) {
        return new JSONDeserializer<SimpleDataDTO>().deserialize(json);
    }
}
