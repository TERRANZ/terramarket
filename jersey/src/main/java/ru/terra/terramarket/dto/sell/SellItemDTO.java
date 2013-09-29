package ru.terra.terramarket.dto.sell;

import flexjson.JSONDeserializer;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

public class SellItemDTO extends CommonDTO {

    public Integer count;
    public ProductDTO prod;

    public SellItemDTO(SellsItem si) {
        this.id = si.getId();
        count = si.getCount();
        prod = new ProductDTO(si.getProduct());
    }

    public static SellItemDTO valueOf(String json) {
        return new JSONDeserializer<SellItemDTO>().deserialize(json);
    }
}
