package ru.terra.terramarket.dto.waybill;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

public class WayBillItemDTO extends CommonDTO {
	public int count;
	public WayBillDTO waybill;
	public ProductDTO product;

}
