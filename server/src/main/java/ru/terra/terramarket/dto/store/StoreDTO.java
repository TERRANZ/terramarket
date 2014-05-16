package ru.terra.terramarket.dto.store;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.Store;
import ru.terra.terramarket.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class StoreDTO extends CommonDTO {
    public Integer count;
    public Date updated;
    public ProductDTO product;

    public StoreDTO() {
    }

    public StoreDTO(Store s) {
        this.id = s.getId();
        this.count = s.getCount();
        this.product = new ProductDTO(s.getProduct());
        this.updated = s.getUpdated();
    }

}
