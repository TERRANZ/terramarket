package ru.terramarket.rest.service.dto.sell;

import ru.terra.server.dto.CommonDTO;
import ru.terramarket.rest.service.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SellItemDTO extends CommonDTO {

    public Integer count;
    public ProductDTO prod;

    public SellItemDTO() {
    }
}
