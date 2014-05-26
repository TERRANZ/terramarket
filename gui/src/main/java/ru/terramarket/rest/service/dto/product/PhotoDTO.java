package ru.terramarket.rest.service.dto.product;

import ru.terra.server.dto.CommonDTO;

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
}
