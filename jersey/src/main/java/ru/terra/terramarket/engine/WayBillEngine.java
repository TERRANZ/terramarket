package ru.terra.terramarket.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.server.engine.AbstractEngine;
import ru.terra.terramarket.db.controllers.WaybillItemJpaController;
import ru.terra.terramarket.db.controllers.WaybillJpaController;
import ru.terra.terramarket.db.entity.Waybill;
import ru.terra.terramarket.db.entity.WaybillItem;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.dto.waybill.WayBillItemDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WayBillEngine extends AbstractEngine<Waybill, WayBillDTO> {

    private WaybillItemJpaController waybillItemJpaController = new WaybillItemJpaController();
    private UsersEngine usersEngine = new UsersEngine();
    private ProductEngine productEngine = new ProductEngine();
    private Logger logger = LoggerFactory.getLogger(WayBillEngine.class);

    public WayBillEngine() {
        super(new WaybillJpaController());
    }

    public WaybillItem getWayBillItem(Integer id) {
        try {
            return waybillItemJpaController.get(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public WayBillDTO create(Long date, Integer user, Integer count, Integer[] products, Integer[] counts, String title, String supplier) {
        Waybill waybill = new Waybill();
        waybill.setCount(count);
        waybill.setSelldate(new Date(date));
        waybill.setUser(usersEngine.getBean(user));
        waybill.setWaybillItemList(new ArrayList<WaybillItem>());
        waybill.setTitle(title);
        waybill.setSupplier(supplier);
        createBean(waybill);
        for (int i = 0; i < products.length; i++) {
            WaybillItem wbi = new WaybillItem();
            wbi.setCount(counts[i]);
            wbi.setProduct(productEngine.getBean(products[i]));
            wbi.setWaybill(waybill);
            waybillItemJpaController.create(wbi);
            waybill.getWaybillItemList().add(wbi);
        }
        try {
            updateBean(waybill);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while creating waybill", e);
        }
        return new WayBillDTO(waybill);
    }

    public Boolean updateWayBillItems(Waybill waybill, Integer[] products, Integer[] counts) {
        waybill.getWaybillItemList().clear();
        try {
            updateBean(waybill);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while creating waybill", e);
        }
        for (int i = 0; i < products.length; i++) {
            WaybillItem wbi = new WaybillItem();
            wbi.setCount(counts[i]);
            wbi.setProduct(productEngine.getBean(products[i]));
            wbi.setWaybill(waybill);
            waybillItemJpaController.create(wbi);
            waybill.getWaybillItemList().add(wbi);
        }
        try {
            updateBean(waybill);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while creating waybill", e);
        }

        return true;
    }

    @Override
    public WayBillDTO getDto(Integer id) {
        return new WayBillDTO(getBean(id));
    }

    @Override
    public void dtoToEntity(WayBillDTO wayBillDTO, Waybill waybill) {
        waybill.setCount(wayBillDTO.count);
        waybill.setSelldate(new Date(wayBillDTO.selldate));
        waybill.setSupplier(wayBillDTO.supplier);
        waybill.setTitle(wayBillDTO.title);
        waybill.setUser(usersEngine.getBean(wayBillDTO.user.id));
        List<WaybillItem> waybillItems = new ArrayList<>();
        for (WayBillItemDTO wayBillItemDTO : wayBillDTO.waybillItems) {
            WaybillItem waybillItem = new WaybillItem();
            waybillItem.setCount(wayBillItemDTO.count);
            waybillItem.setProduct(productEngine.getBean(wayBillItemDTO.product.id));
            waybillItem.setWaybill(waybill);
            waybillItems.add(waybillItem);
        }
        waybill.setWaybillItemList(waybillItems);
    }

    @Override
    public WayBillDTO entityToDto(Waybill waybill) {
        return new WayBillDTO(waybill);
    }
}