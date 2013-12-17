package ru.terra.terramarket.dto.waybill;

import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.UserDTO;
import ru.terra.terramarket.db.entity.Waybill;
import ru.terra.terramarket.db.entity.WaybillItem;

import java.util.ArrayList;
import java.util.List;

public class WayBillDTO extends CommonDTO {

    public int count;
    public Long selldate;
    public List<WayBillItemDTO> waybillItems;
    public UserDTO user;
    public String supplier, title;

    public WayBillDTO(Waybill wb) {
        this.id = wb.getId();
        this.count = wb.getCount();
        this.selldate = wb.getSelldate().getTime();
        this.waybillItems = new ArrayList<>();
        for (WaybillItem wbi : wb.getWaybillItemList())
            waybillItems.add(new WayBillItemDTO(wbi, false));

        this.user = new UserDTO(wb.getUser());
        this.supplier = wb.getSupplier();
        this.title = wb.getTitle();
    }

    public WayBillDTO(int count, Long selldate, List<WayBillItemDTO> waybillItems, UserDTO user, String supplier, String title) {
        this.count = count;
        this.selldate = selldate;
        this.waybillItems = waybillItems;
        this.user = user;
        this.supplier = supplier;
        this.title = title;
    }
}
