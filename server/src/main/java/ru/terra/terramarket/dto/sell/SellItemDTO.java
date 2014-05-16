package ru.terra.terramarket.dto.sell;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.terramarket.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SellItemDTO extends CommonDTO {

    public Integer count;
    public ProductDTO prod;

    public SellItemDTO() {
    }

    public SellItemDTO(SellsItem si) {
        this.id = si.getId();
        count = si.getCount();
        prod = new ProductDTO(si.getProduct());
    }

}
