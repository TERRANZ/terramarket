package ru.terra.terramarket.dto.waybill;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.WaybillItem;
import ru.terra.terramarket.dto.product.ProductDTO;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WayBillItemDTO extends CommonDTO {

    public int count;
    public WayBillDTO waybill;
    public ProductDTO product;

    public WayBillItemDTO() {
    }

    public WayBillItemDTO(WaybillItem wbi, boolean recursive) {
        this.id = wbi.getId();
        this.count = wbi.getCount();
        if (recursive)
            this.waybill = new WayBillDTO(wbi.getWaybill());
        this.product = new ProductDTO(wbi.getProduct());
    }

    public WayBillItemDTO(int count, WayBillDTO waybill, ProductDTO product) {
        this.count = count;
        this.waybill = waybill;
        this.product = product;
    }
}
