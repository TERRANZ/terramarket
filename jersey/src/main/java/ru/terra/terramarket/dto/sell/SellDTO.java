package ru.terra.terramarket.dto.sell;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import flexjson.JSONDeserializer;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.server.dto.CommonDTO;

public class SellDTO extends CommonDTO {

	public Date sellDate;
	public List<SellItemDTO> sellItems;

	public SellDTO(Sells sell) {
        this.id = sell.getId();
		sellDate = sell.getSelldate();
		sellItems = new ArrayList<>();
		for (SellsItem si : sell.getSellsItemList()) {
			sellItems.add(new SellItemDTO(si));
		}
	}
    public static SellDTO valueOf(String json) {
        return new JSONDeserializer<SellDTO>().deserialize(json);
    }
}
