package ru.terra.terramarket.dto.sell;

import java.util.Date;
import java.util.List;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.UserDTO;

public class SellDTO extends CommonDTO {
	public Long sellDate;
	public List<SellItemDTO> sellItems;
	public UserDTO user;
}
