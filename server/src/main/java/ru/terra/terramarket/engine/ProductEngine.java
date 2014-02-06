package ru.terra.terramarket.engine;

import org.apache.log4j.Logger;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.ProductJpaController;
import ru.terra.terramarket.db.entity.Groups;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.dto.product.ProductDTO;

public class ProductEngine extends AbstractEngine<Product, ProductDTO> {

    private Logger logger = Logger.getLogger(ProductEngine.class);

    public ProductEngine() {
        super(new ProductJpaController());
    }


    @Override
    public ProductDTO getDto(Integer id) {
        return new ProductDTO(getBean(id));
    }

    @Override
    public void dtoToEntity(ProductDTO productDTO, Product product) {
        product.setName(productDTO.name);
        product.setBarcode(productDTO.barcode);
        Groups groups = new GroupEngine().getBean(productDTO.group.id);
        product.setGroup(groups);
        product.setMincount(productDTO.mincount);
        product.setPriceIn(productDTO.priceIn);
        product.setPriceOut(productDTO.priceOut);
        product.setQtype(productDTO.qtype);
        product.setRating(productDTO.rating);
        //TODO: photos?
    }

    @Override
    public ProductDTO entityToDto(Product product) {
        return new ProductDTO(product);
    }
}
