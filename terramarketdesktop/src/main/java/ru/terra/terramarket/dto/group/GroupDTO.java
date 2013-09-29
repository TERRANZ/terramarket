package ru.terra.terramarket.dto.group;

import java.util.List;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

public class GroupDTO extends CommonDTO {
	public String name;
	public int parent;
	public List<ProductDTO> productList;
}
