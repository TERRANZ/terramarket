package ru.terramarket.rest.service.dto.store;

import ru.terra.server.dto.CommonDTO;
import ru.terramarket.rest.service.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class StoreDTO extends CommonDTO {
    public Integer count;
    public Date updated;
    public ProductDTO product;

    public StoreDTO() {
    }

}
