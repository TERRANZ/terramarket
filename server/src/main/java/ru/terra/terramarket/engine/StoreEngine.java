package ru.terra.terramarket.engine;

import org.apache.log4j.Logger;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.StoreJpaController;
import ru.terra.terramarket.db.entity.Product;
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
            dbController.create(new Store(null, productEngine.getBean(product), count, new Date()));
        } catch (Exception e) {
            logger.error("Unable to add product to store", e);
            return new SimpleDataDTO<>(false);
        }
        return new SimpleDataDTO<>(true);
    }

    public SimpleDataDTO<Boolean> updateStore(Integer productId, Integer count) {
        try {
            Product product = productEngine.getBean(productId);
            if (product == null)
                return new SimpleDataDTO<>(false);
            Store store = ((StoreJpaController) dbController).findByProduct(product);
            if (store == null)
                return new SimpleDataDTO<>(false);
            store.setCount(count);
            store.setProdId(product);
            store.setUpdated(new Date());
            dbController.update(store);
        } catch (Exception e) {
            logger.error("Unable to update product in store", e);
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
        return ((StoreJpaController) dbController).isProductAvailable(productEngine.getBean(id), count);
    }

    public boolean decreaseProducts(Integer id, Integer count) {
        Store store = ((StoreJpaController) dbController).findByProduct(productEngine.getBean(id));
        if (store == null)
            return false;
        store.setCount(store.getCount() - count);
        try {
            dbController.update(store);
            return true;
        } catch (Exception e) {
            logger.error("Unable to decrease products count in store", e);
            return false;
        }
    }
}
