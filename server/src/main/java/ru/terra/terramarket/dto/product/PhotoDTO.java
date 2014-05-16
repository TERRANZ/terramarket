package ru.terra.terramarket.dto.product;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.Photo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: Vadim Korostelev
 * Date: 12.09.13
 * Time: 10:59
 */
@XmlRootElement
public class PhotoDTO extends CommonDTO {

    private String path, name;
    private Integer userId;
    private Integer productId;

    public PhotoDTO() {
    }

    public PhotoDTO(Photo photo) {
        this.id = photo.getId();
        this.path = photo.getPath();
        this.name = photo.getName();
        this.userId = photo.getUserId().getId();
        this.productId = photo.getProductId().getId();
    }
}
