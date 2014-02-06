package ru.terra.terramarket.dto.group;

import ru.terra.server.dto.CommonDTO;
import ru.terra.terramarket.db.entity.Groups;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.dto.product.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class GroupDTO extends CommonDTO {

    public String name;
    public int parent;
    public List<ProductDTO> productList;

    public GroupDTO() {
    }

    public GroupDTO(Groups group, boolean recursive) {
        this.id = group.getId();
        this.name = group.getName();
        this.parent = group.getParent();
        this.productList = new ArrayList<>();
        if (recursive)
            for (Product prod : group.getProductList()) {
                productList.add(new ProductDTO(prod));
            }
    }
}
