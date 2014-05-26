package ru.terramarket.rest.service.dto.waybill;

import ru.terra.server.dto.CommonDTO;
import ru.terramarket.rest.service.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WayBillItemDTO extends CommonDTO {

    public int count;
    public WayBillDTO waybill;
    public ProductDTO product;

    public WayBillItemDTO() {
    }

}
