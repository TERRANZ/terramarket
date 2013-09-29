package ru.terra.terramarket.dto.waybill;

import java.util.List;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.UserDTO;

public class WayBillDTO extends CommonDTO {
	public int count;
	public Long selldate;
	public List<WayBillItemDTO> waybillItems;
	public UserDTO user;
	public String supplier, title;

}
