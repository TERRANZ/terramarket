/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Waybill;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.db.entity.WaybillItem;

/**
 *
 * @author terranz
 */
public class WaybillItemJpaController extends AbstractJpaController<WaybillItem> implements Serializable {

    public WaybillItemJpaController() {
        super(WaybillItem.class);
    }

    @Override
    public void create(WaybillItem waybillItem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Waybill waybillId = waybillItem.getWaybill();
            if (waybillId != null) {
                waybillId = em.getReference(waybillId.getClass(), waybillId.getId());
                waybillItem.setWaybill(waybillId);
            }
            Product prodId = waybillItem.getProduct();
            if (prodId != null) {
                prodId = em.getReference(prodId.getClass(), prodId.getId());
                waybillItem.setProduct(prodId);
            }
            em.persist(waybillItem);
            if (waybillId != null) {
                waybillId.getWaybillItemList().add(waybillItem);
                waybillId = em.merge(waybillId);
            }
            if (prodId != null) {
                prodId.getWaybillItemList().add(waybillItem);
                prodId = em.merge(prodId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(WaybillItem waybillItem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WaybillItem persistentWaybillItem = em.find(WaybillItem.class, waybillItem.getId());
            Waybill waybillIdOld = persistentWaybillItem.getWaybill();
            Waybill waybillIdNew = waybillItem.getWaybill();
            Product prodIdOld = persistentWaybillItem.getProduct();
            Product prodIdNew = waybillItem.getProduct();
            if (waybillIdNew != null) {
                waybillIdNew = em.getReference(waybillIdNew.getClass(), waybillIdNew.getId());
                waybillItem.setWaybill(waybillIdNew);
            }
            if (prodIdNew != null) {
                prodIdNew = em.getReference(prodIdNew.getClass(), prodIdNew.getId());
                waybillItem.setProduct(prodIdNew);
            }
            waybillItem = em.merge(waybillItem);
            if (waybillIdOld != null && !waybillIdOld.equals(waybillIdNew)) {
                waybillIdOld.getWaybillItemList().remove(waybillItem);
                waybillIdOld = em.merge(waybillIdOld);
            }
            if (waybillIdNew != null && !waybillIdNew.equals(waybillIdOld)) {
                waybillIdNew.getWaybillItemList().add(waybillItem);
                waybillIdNew = em.merge(waybillIdNew);
            }
            if (prodIdOld != null && !prodIdOld.equals(prodIdNew)) {
                prodIdOld.getWaybillItemList().remove(waybillItem);
                prodIdOld = em.merge(prodIdOld);
            }
            if (prodIdNew != null && !prodIdNew.equals(prodIdOld)) {
                prodIdNew.getWaybillItemList().add(waybillItem);
                prodIdNew = em.merge(prodIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = waybillItem.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The waybillItem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WaybillItem waybillItem;
            try {
                waybillItem = em.getReference(WaybillItem.class, id);
                waybillItem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The waybillItem with id " + id + " no longer exists.", enfe);
            }
            Waybill waybillId = waybillItem.getWaybill();
            if (waybillId != null) {
                waybillId.getWaybillItemList().remove(waybillItem);
                waybillId = em.merge(waybillId);
            }
            Product prodId = waybillItem.getProduct();
            if (prodId != null) {
                prodId.getWaybillItemList().remove(waybillItem);
                prodId = em.merge(prodId);
            }
            em.remove(waybillItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    
}
