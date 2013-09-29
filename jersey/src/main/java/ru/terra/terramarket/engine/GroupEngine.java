package ru.terra.terramarket.engine;

import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.GroupsJpaController;
import ru.terra.terramarket.db.entity.Groups;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.dto.product.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class GroupEngine extends AbstractEngine<Groups, GroupDTO> {

    private ProductEngine productEngine = new ProductEngine();

    public GroupEngine() {
        super(new GroupsJpaController());
    }

    @Override
    public boolean updateDTO(GroupDTO groupDTO) {
        Groups groups = getBean(groupDTO.id);
        if (groups != null) {
            dtoToEntity(groupDTO, groups);
            updateBean(groups);
        }
        return false;
    }

    @Override
    public GroupDTO getDto(Integer id) {
        return new GroupDTO(getBean(id), true);
    }

    @Override
    public void dtoToEntity(GroupDTO groupDTO, Groups groups) {
        groups.setName(groupDTO.name);
        groups.setParent(groupDTO.parent);
        if (groupDTO.productList != null) {
            List<Product> products = new ArrayList<>();
            for (ProductDTO productDTO : groupDTO.productList) {
                Product product = productEngine.getBean(productDTO.id);
                if (product != null)
                    products.add(product);
            }
            groups.setProductList(products);
        }
    }

    @Override
    public GroupDTO entityToDto(Groups groups) {
        return new GroupDTO(groups, true);
    }
}
