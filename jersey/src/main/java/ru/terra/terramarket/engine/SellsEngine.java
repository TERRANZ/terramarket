package ru.terra.terramarket.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.ProductJpaController;
import ru.terra.terramarket.db.controllers.SellsItemJpaController;
import ru.terra.terramarket.db.controllers.SellsJpaController;
import ru.terra.terramarket.db.controllers.StoreJpaController;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.sell.SellDTO;

import java.util.ArrayList;
import java.util.List;


public class SellsEngine extends AbstractEngine<Sells, SellDTO> {

    private Logger logger = LoggerFactory.getLogger(SellsEngine.class);
    private SellsItemJpaController sellsItemJpaController = new SellsItemJpaController();
    private ProductJpaController productJpaController = new ProductJpaController();
    private StoreJpaController storeJpaController = new StoreJpaController();

    public SellsEngine() {
        super(new SellsJpaController());
    }

    public CommonDTO doSell(String[] products, String[] counts) {
        logger.info("doint sell");
        List<Integer> productList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            Integer pId = Integer.parseInt(products[i]);
            productList.add(pId);
            Integer count = Integer.parseInt(counts[i]);
            countList.add(count);
            try {
                if (!storeJpaController.isProductAvailable(productJpaController.get(pId), count)) {
                    CommonDTO errorDTO = new CommonDTO();
                    errorDTO.errorMessage = "Продукт " + pId + " в количестве " + count + " недоступен на складе!";
                    errorDTO.errorCode = 1;
                    return errorDTO;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Sells sell = new Sells();
        createBean(sell);
        for (int i = 0; i < productList.size(); i++) {
            try {
                SellsItem si = new SellsItem();
                si.setProdId(productJpaController.get(productList.get(i)));
                si.setCount(countList.get(i));
                si.setSellId(sell);
                sellsItemJpaController.create(si);
            } catch (NumberFormatException e) {
                logger.error("error while parsing prod id", e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new SimpleDataDTO<>(productList.size());
    }


    @Override
    public boolean updateDTO(SellDTO sellDTO) {
        return false;
    }
    @Override
    public SellDTO getDto(Integer id) {
        return new SellDTO(getBean(id));
    }

    @Override
    public void dtoToEntity(SellDTO sellDTO, Sells sells) {

    }

    @Override
    public SellDTO entityToDto(Sells sells) {
        return new SellDTO(sells);
    }
}
