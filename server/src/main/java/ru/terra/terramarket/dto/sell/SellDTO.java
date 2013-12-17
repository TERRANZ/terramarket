package ru.terra.terramarket.dto.sell;

import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.UserDTO;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.SellsItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellDTO extends CommonDTO {

    public Long sellDate;
    public List<SellItemDTO> sellItems;
    public UserDTO user;

    public SellDTO(Sells sell) {
        this.id = sell.getId();
        this.sellDate = sell.getSelldate().getTime();
        this.sellItems = new ArrayList<>();
        for (SellsItem si : sell.getSellsItemList()) {
            this.sellItems.add(new SellItemDTO(si));
        }
        this.user = new UserDTO(sell.getUser());
    }

}
