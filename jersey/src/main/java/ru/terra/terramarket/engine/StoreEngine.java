package ru.terra.terramarket.engine;

import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.StoreJpaController;
import ru.terra.terramarket.db.entity.Store;
import ru.terra.terramarket.dto.store.StoreDTO;

import java.util.ArrayList;
import java.util.List;


public class StoreEngine extends AbstractEngine<Store, StoreDTO> {

    public StoreEngine() {
        super(new StoreJpaController());
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
}
