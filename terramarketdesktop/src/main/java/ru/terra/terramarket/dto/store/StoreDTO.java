package ru.terra.terramarket.dto.store;

import java.util.Date;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

public class StoreDTO extends CommonDTO {
	public Integer count;
	public Date updated;
	public ProductDTO product;

}
