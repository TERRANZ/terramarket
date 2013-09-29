package ru.terra.terramarket.dto.sell;

import java.util.Date;
import java.util.List;

import ru.terra.terramarket.dto.CommonDTO;

public class SellDTO extends CommonDTO {
	public Date sellDate;
	public List<SellItemDTO> sellItems;

}
