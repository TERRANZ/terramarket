package ru.terra.terramarket.dto.product;

import flexjson.JSONDeserializer;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.server.dto.CommonDTO;

/**
 * User: Vadim Korostelev
 * Date: 12.09.13
 * Time: 10:59
 */
public class PhotoDTO extends CommonDTO {

    private String path, name;
    private Integer userId;
    private Integer productId;

    public PhotoDTO(Photo photo) {
        this.id = photo.getId();
        this.path = photo.getPath();
        this.name = photo.getName();
        this.userId = photo.getUserId().getId();
        this.productId = photo.getProductId().getId();
    }
}
