package ru.terra.terramarket.engine;

import org.apache.log4j.Logger;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.StoreJpaController;
import ru.terra.terramarket.db.entity.Store;
import ru.terra.terramarket.dto.store.StoreDTO;

import java.util.Date;


public class StoreEngine extends AbstractEngine<Store, StoreDTO> {
    private ProductEngine productEngine = new ProductEngine();
    private Logger logger = Logger.getLogger(this.getClass());

    public StoreEngine() {
        super(new StoreJpaController());
    }

    public SimpleDataDTO<Boolean> addToStore(Integer product, Integer count) {
        try {
            jpaController.create(new Store(null, productEngine.getBean(product), count, new Date()));
        } catch (Exception e) {
            logger.error("Unable to add product to store", e);
            return new SimpleDataDTO<>(false);
        }
        return new SimpleDataDTO<>(true);
    }

    @Override
    public boolean updateDTO(StoreDTO storeDTO) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public StoreDTO getDto(Integer id) {
        return new StoreDTO(getBean(id));
    }

    @Override
    public void dtoToEntity(StoreDTO storeDTO, Store store) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public StoreDTO entityToDto(Store store) {
        return new StoreDTO(store);
    }

    public boolean isProductAvailable(Integer id, Integer count) {
        return ((StoreJpaController) jpaController).isProductAvailable(productEngine.getBean(id), count);
    }

    public boolean decreaseProducts(Integer id, Integer count) {
        Store store = ((StoreJpaController) jpaController).findByProduct(productEngine.getBean(id));
        if (store == null)
            return false;
        store.setCount(store.getCount() - count);
        try {
            jpaController.update(store);
            return true;
        } catch (Exception e) {
            logger.error("Unable to decrease products count in store", e);
            return false;
        }
    }
}
